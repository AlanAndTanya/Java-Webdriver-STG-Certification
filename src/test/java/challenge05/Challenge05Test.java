package challenge05;

import common.TableDataTools;
import common.TableDataToolsTest;
import common.UtilityStuff;
import common.Vehicle;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.List;
import java.util.Map;


public class Challenge05Test {

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
    public void test_SearchPorsche_ChgTo100( ) {
        driver.get("https://www.copart.com/");
        driver.manage().window().setSize(new Dimension(1024, 697));
        js.executeScript("window.scrollTo(0,0)");

        UtilityStuff localUtilStuff = new UtilityStuff();

        WebElement wbInputSrch = driver.findElement(By.id("input-search"));
        wbInputSrch.sendKeys("porsche");

        wbInputSrch.sendKeys(Keys.ENTER);

        Challenge05 ch05 = new Challenge05();
        TableDataTools localTDT = new TableDataTools();
        TableDataToolsTest localTDTT = new TableDataToolsTest( );

        List<Vehicle> listVehicle = localTDTT.findTableData( driver );

        localTDTT.displaySizeOfVehicleList( listVehicle );

        // Report #1 -- Vehicle Counts
        Map<String, Integer> report01 = localTDT.findListAndCountOfVehicles( listVehicle );
        localUtilStuff.printMap( report01, "Models and counts" );

        // Report #2 --
        Map<String, Integer> report02 = ch05.findListOfDamageTypeText( listVehicle );
        localUtilStuff.printMap( report02, "Damage Types -- and counts" );
    }

}
