package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created because I have similar code on two challenges.  #3 and #7.
 */
public class MakeAndModelToolsTest {


    /**
     * @param driver
     * @param findWhichList  Either the keyword of "make" or "model"
     * @return  A map which has the Model or Make as a key. The value is the url.
     */
    public Map<String, String> findMakeOrModelData(WebDriver driver, String findWhichList ) {

        Map<String, String> results = new HashMap<>();

        //  To get the FIRST list of 5
        //  //*[@id="tabTrending"]/div[1]/div[2]/div[1]

        String howToFindList01 = "";
        String howToFindList02 = "";

        if( findWhichList.equalsIgnoreCase( "model" )) {
            howToFindList01 = "//*[@id=\"tabTrending\"]/div[1]/div[2]/div[1]";
            howToFindList02 = "//*[@id=\"tabTrending\"]/div[1]/div[2]/div[2]";
        } else if( findWhichList.equalsIgnoreCase( "make" )) {
            howToFindList01 = "//*[@id=\"tabTrending\"]/div[1]/div[2]/div[3]";
            howToFindList02 = "//*[@id=\"tabTrending\"]/div[1]/div[2]/div[4]";
        }

        results = collectMakeOrModelData(driver, howToFindList01, howToFindList02, findWhichList );

        return results;
    }



    protected Map<String, String> collectMakeOrModelData(WebDriver driver,
                                                         String howToFindList01,
                                                         String howToFindList02,
                                                         String findWhichList ) {

        Map<String, String> results;

        // DO THE FIRST SET.
        // ****************
        By bySearchForList01 = By.xpath( howToFindList01 );
        WebElement weList01 = driver.findElement( bySearchForList01 );
        String list01GetText = weList01.getText();
//      displayTraceInfoForString( list01GetText );
        String[] arrayGetText01 = this.splitListGetText( list01GetText );

        List<WebElement> listHRef01 = weList01.findElements(By.tagName("a"));
        int sizeList = listHRef01.size();
        List<String> listHrefSet01 = new ArrayList<>(0);

        for(WebElement we : listHRef01) {
            String oneHref = we.getAttribute("href");
            listHrefSet01.add( oneHref );
        }


        // DO THE SECOND SET.
        // ****************
        By bySearchForList02 = By.xpath( howToFindList02 );
        WebElement weList02 = driver.findElement( bySearchForList02 );
        String list02GetText = weList02.getText();
//      displayTraceInfoForString( list02GetText );
        String[] arrayGetText02 = this.splitListGetText( list02GetText );

        List<WebElement> listHRef02 = weList02.findElements(By.tagName("a"));
        List<String> listHrefSet02 = new ArrayList<>(0);

        for(WebElement we : listHRef02) {
            String oneHref = we.getAttribute("href");
            listHrefSet02.add( oneHref );
        }

        UtilityStuff objUS = new UtilityStuff( );

        results = combineTwoListStringToOneMap( arrayGetText01, arrayGetText02 );

//      objUS.printMapStringString( results, "Review map with keys and NO values." );

        results = this.combineMapAndListHref( results, listHrefSet01, findWhichList );
        results = this.combineMapAndListHref( results, listHrefSet02, findWhichList );

//      objUS.printMapStringString( results, "Review #2 of map with keys and SOME values." );

        return results;
    }


    protected void displayTraceInfoForString(String list01GetText) {
        // because I was doing the SAME thing multiple times.

        StringBuilder sbTrace = new StringBuilder( 100 );
        sbTrace.append( "for list01, the getText has ")
                .append( list01GetText.length() ).append( " chars, and contains [[[" )
                .append( list01GetText ).append( "]]]" );
        System.out.println( sbTrace );
    }


    protected String[] splitListGetText( String sourceList ) {

        String[ ] workArray = new String[ 0 ];  /// ArrayList<>(0 );

        if( sourceList != null ) {
            workArray = sourceList.split( "\n" );
        }

        return workArray;
    }


    protected Map<String, String> combineTwoListStringToOneMap( String[] list01, String[] list02 ) {

        Map<String, String> results = new HashMap<>();

        int sizeList01 = list01.length;

        for( int i = 0; i < sizeList01; i++ ) {
            String oneEntry = list01[ i ];
            results.put( oneEntry, "" );
        }

        int sizeList02 = list02.length;

        for( int i = 0; i < sizeList02; i++ ) {
            String oneEntry = list02[ i ];
            results.put( oneEntry, "" );
        }

        return results;
    }


    protected Map<String, String> combineMapAndListHref( Map<String, String> sourceMap,
                                                         List<String> listHrefSet,
                                                         String listType ) {
        int sizeList = listHrefSet.size();

        for( int i = 0; i < sizeList; i++ ) {
            String oneHref  = listHrefSet.get( i );
            int locListType = oneHref.indexOf( listType );

            if( locListType > - 1 ){
                int startOfTailText = locListType + listType.length() + 1;  // for the SLASH

                String tailText = oneHref.substring( startOfTailText );

                tailText = tailText.replace( "-", " ");
                tailText = tailText.toUpperCase();

                boolean isTailTextAKey = sourceMap.containsKey( tailText );
                if( isTailTextAKey ) {
                    sourceMap.replace( tailText, oneHref );
                } else {
                    sourceMap.put( tailText, "((empty))" );
                }
            }
        }

        return sourceMap;
    }

}
