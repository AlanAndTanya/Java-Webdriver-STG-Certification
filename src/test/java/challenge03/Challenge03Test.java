package challenge03;

import common.MakeAndModelToolsTest;
import common.UtilityStuff;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Challenge03Test {

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

        // Don't need 'window.setSize' if we use the headless version.
    //     driver.manage().window().setSize(new Dimension(1024, 700));

        MakeAndModelToolsTest objMMTT = new MakeAndModelToolsTest();
        UtilityStuff objUS = new UtilityStuff( );

        Map<String, String> listModels = objMMTT.findMakeOrModelData( driver, "model" );
        Map<String, String> listMakes = objMMTT.findMakeOrModelData( driver, "make" );

        this.outputToConsole( listModels );
        this.outputToConsole( listMakes );
    }



    protected void outputToConsole( Map<String, String> sourceMap ) {
        System.out.println( "****  Found " + sourceMap.size() + " entries.");

        for (Map.Entry<String, String> entry : sourceMap.entrySet()) {
            String theKey = entry.getKey();
            String theValue = entry.getValue();

            StringBuilder sb = new StringBuilder( );
            sb.append( theKey )
              .append( " - " )
              .append( theValue );

            System.out.println( sb );
        }
    }

}
