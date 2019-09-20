package challenge04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class Challenge04Test {

//  public WebDriver driver;

    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {
 //     System. out .println( "All done!!!" );
    }

    @BeforeClass
    public void startClass() throws Exception{
//       System. setProperty ( "webdriver.chrome.driver" , "./bin/chromedriver.exe" );
//        driver = new ChromeDriver();

        // 2019_0806_2027  will try the Fifefox driver, as it worked for me on other project.
        //           2029  HACK. NOTE, I do not like that it is a hard-coded path.
//        String pathToGeckoDriver = "C:\\apps2019\\geckodriver\\geckodriver.exe";
//        // "E:\\GekoDriver\\geckodriver-v0.15.0-win64\\geckodriver.exe"
//        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver );
//        driver = new FirefoxDriver();

    }

    @AfterClass
    public void stopSelenium( ) {      // stopClass() {
//      driver.quit();
    }

    @BeforeMethod()
    public void beforeMethod() throws Exception {
    }

    @AfterMethod()
    public void afterMethod(){
    }

    @Test
    public void  testFindFibonacciValue( ) {

        SoftAssert mySoftAssert = new SoftAssert();
        Challenge04 c4 = new Challenge04();

        // added 1, as the map is ZERO based.
        HashMap< Integer, Integer> valuesExpected = c4.createMapOfLevelAndValue();
        HashMap< Integer, Integer> valuesActual   = new HashMap<>( c4.MAX_LEVELS_ON_HASH_MAP + 1);


        // fill or find the ACTUAL values.
        for( int i = 1; i <= c4.MAX_LEVELS_ON_HASH_MAP; i++ ) {
            int oneActual = c4.findFibonacciValue( i );
            valuesActual.put( i, oneActual );
        }

        // now compare the actual and expected values.
        for( int j = 1;  j <= c4.MAX_LEVELS_ON_HASH_MAP; j++ ) {
            int oneExpected = valuesExpected.get( j );
            int oneActual = valuesActual.get( j );
            String msg = "For " + j + ", we expected "+  oneExpected + ", and got " + oneActual;
            System.out.println( msg );
            mySoftAssert.assertEquals( oneActual, oneExpected );
        }

        mySoftAssert.assertAll();
    }



    @Test
    public void test1UsingSoftAssertion() {
        // 2019-08-07 23:26  copied from https://www.techbeamers.com/using-testng-assertions-selenium
        SoftAssert softAssert1 = new SoftAssert();
        String className = "SoftAssertion";

        softAssert1.assertTrue(true == true, "the condition is true." );
        softAssert1.assertEquals("SoftAssertion", "SoftAssertion");
        softAssert1.assertEquals(className, "SoftAssertion");
        softAssert1.assertAll();
    }


    @Test
    public void test2UsingSoftAssertion() {
        // 2019-08-09  00:08  from  https://stackoverflow.com/questions/52316733/softassertion-specific-to-test-in-testng
        SoftAssert softAssert2 = new SoftAssert();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(3, 3);
        softAssert.assertEquals(2, 2);
        softAssert.assertEquals(5, 5);
        softAssert.assertAll();
    }



    @Test
    public void testNumberToWord( ) {

        Challenge04 oneCh04 = new Challenge04();
        SoftAssert softAssertWords = new SoftAssert();

        //        13 - thirteen
        //        144 - one hundred forty four
        //        7408 - seven thousand four hundred eight

        String try13 = oneCh04.numberToWord( 13 );
        System.out.println( "Test with 13.  Got '" + try13 );
        softAssertWords.assertEquals( try13, "thirteen" );

        String try144 = oneCh04.numberToWord( 144 );
        System.out.println( "Test with 144.  Got '" + try144 );
        softAssertWords.assertEquals ( try144, "one hundred forty four" );

        String try7408 = oneCh04.numberToWord( 7408 );
        System.out.println( "Test with 7408.  Got '" + try7408 );
        softAssertWords.assertEquals ( try7408, "seven thousand four hundred eight" );

        softAssertWords.assertAll();
    }

}
