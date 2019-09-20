package challenge07;

import common.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

import static org.openqa.selenium.By.tagName;

public class Challenge07Test {

    private WebDriver driver;
    JavascriptExecutor js;

    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {
        System. out .println( "All done!!!" );
    }

    @BeforeClass
    public void startClass() throws Exception{
        System. setProperty ( "webdriver.chrome.driver" , "./bin/chromedriver.exe" );

        ChromeOptions chOptions = new ChromeOptions();
        chOptions.setHeadless( true );
        driver = new ChromeDriver( chOptions );

        js = (JavascriptExecutor) driver;
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
    public void createDesiredReports() {

        driver.get("https://www.copart.com/");

        // 2019_0905_2354  Don't need 'window.setSize' if we use the headless version.
//      driver.manage().window().setSize(new Dimension(1024, 700));

        MakeAndModelToolsTest objMMTT = new MakeAndModelToolsTest();
        UtilityStuff objUS = new UtilityStuff( );

        Map<String, String> listModels = objMMTT.findMakeOrModelData( driver, "model" );
        Map<String, String> listMakes = objMMTT.findMakeOrModelData( driver, "make" );

        objUS.printMapStringString( listModels, "Review map of 'listModels', in method 'createDesiredReports'." );
        objUS.printMapStringString( listMakes, "Review map of 'list Makes', in method 'createDesiredReports'." );
    }

}
