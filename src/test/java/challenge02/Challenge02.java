package challenge02;

import common.TableDataTools;
import common.TableDataToolsTest;
import common.Vehicle;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Challenge02 {

    private WebDriver driver;
//  JavascriptExecutor js;

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

//      js = (JavascriptExecutor) driver;
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
    public void searchExoticsThenCheckForPorsche() {

        driver.get("https://www.copart.com/");

        // 2019_0905_2354  Don't need 'window.setSize' if we use the headless version.
//      driver.manage().window().setSize(new Dimension(1024, 700));

        driver.findElement(By.id("input-search")).sendKeys("exotics");
        driver.findElement(By.id("input-search")).sendKeys(Keys.ENTER);

        TableDataTools localTDT = new TableDataTools( );
        TableDataToolsTest localTDTT = new TableDataToolsTest( );

        List<Vehicle> listVehicle = localTDTT.findTableData( driver );
        localTDTT.displaySizeOfVehicleList( listVehicle );

        int rowCount = localTDT.findCountOfOneMakeOnList( listVehicle, "porsche" );

        SoftAssert mySoftAssert = new SoftAssert();

        mySoftAssert.assertNotEquals( rowCount, 0 );

        // this is a 'hard' assert, as it collects all the 'soft' asserts.
        mySoftAssert.assertAll();

        // this is a HARD assert.
        Assert.assertNotEquals( rowCount, 0 );
    }

}
