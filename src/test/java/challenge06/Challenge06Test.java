package challenge06;

import common.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.By.tagName;

public class Challenge06Test {

    private WebDriver driver;
//    JavascriptExecutor js;

    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {
        System.out.println( "All done!!!" );
    }

    @BeforeClass
    public void startClass() throws Exception{
        System.setProperty ( "webdriver.chrome.driver" , "./bin/chromedriver.exe" );

        ChromeOptions chOptions = new ChromeOptions();
        chOptions.setHeadless( true );
        driver = new ChromeDriver( chOptions );
    }
	
    @AfterClass
    public void stopSelenium( ) {      // stopClass() {
        driver.quit();
    }

    @BeforeMethod()
    public void beforeMethod() throws Exception {
    }

    @AfterMethod()
    public void afterMethod(){
    }


    @Test
    public void checkForNissanSkyline() {

        int modelRowsFound = checkForSpecificMakeAndModel( driver, "nissan", "skyline" );

        System.out.println( "Found " + modelRowsFound + ",  model rows." );

        if( modelRowsFound <= 0 ) {
            takeScreenShot( driver );
        }
    }


    /**
     * This really should be in a Page Object file.
     * @param driver
     * @param pWhichMake
     * @param pWhichModel
     * @return
     */
    protected int checkForSpecificMakeAndModel( WebDriver driver, String pWhichMake, String pWhichModel ) {

        int modelsFound = -1;   // have not yet checked.

        driver.get("https://www.copart.com/");

        driver.findElement(By.id("input-search")).sendKeys("nissan");

        driver.findElement(By.cssSelector(".btn-lightblue")).click();

        // THis works in method "findTableData", in file "TableDataToolsTest"
        // That method is called by Challenges #2 and #5.
        //
        String idNameOfDataTable = "serverSideDataTable";
        By byNameOfDataTable = By.id( idNameOfDataTable );
        WebElement weSSDTL = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated( By.id( "serverSideDataTable_length" )));


        UtilityStuff localUS = new UtilityStuff();

        // NOTE "CI4" is short for "CollapseInside4"

        String strCI4Xpath = "//*[@id=\"collapseinside4\"]";
        String strCI4css   = "#collapseinside4";
        String strCI4Id    = "collapseinside4";

//        By byCI14Xpath = By.xpath( strCI4Xpath );
//        WebElement weCI4XPath = driver.findElement( byCI14Xpath );
//        String weCI4XPathText = weCI4XPath.getText();
//        localUS.displayLengthAndContents( weCI4XPathText );

//        By byCI4Css = By.cssSelector( strCI4css );
//        WebElement weCI4Css = driver.findElement( byCI4Css );
//        String weCI4CssText = weCI4Css.getText();
//        localUS.displayLengthAndContents( weCI4CssText );

//        By byCI4Id = By.id( strCI4Id );
//        WebElement weCI4Id = driver.findElement( byCI4Id );
//        String weCI4IdText = weCI4Id.getText();
//        localUS.displayLengthAndContents( weCI4IdText );

        // this gives me an error message: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element
        // 7 | click | css=#collapseinside4 .form-control |  |
//      driver.findElement(By.cssSelector("#collapseinside4 .form-control")).click();

//        // 8 | type | css=.seachfilterinput > .ng-not-empty | skyline |
//        driver.findElement(By.cssSelector(".seachfilterinput > .ng-not-empty")).sendKeys("skyline");

        return modelsFound;
    }


    
    protected void takeScreenShot( WebDriver pDriver ) {
        try {
            File screenshotFile = ((TakesScreenshot)pDriver).getScreenshotAs(OutputType.FILE);

            String newPathName = "";   // ""f:\\temp\\";
            String newFileName = "STG_Challenge06.png";
            String newPathAndFileName = newPathName + newFileName;

            FileUtils.copyFile( screenshotFile, new File( newPathAndFileName ));
            System.out.println("Successfully captured a screenshot.  See file " + newPathAndFileName );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
