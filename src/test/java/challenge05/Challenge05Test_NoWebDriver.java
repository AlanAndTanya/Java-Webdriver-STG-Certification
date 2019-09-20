package challenge05;

import com.google.common.collect.Table;
import common.TableDataTools;
import common.TableDataToolsTest;
import common.Vehicle;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge05Test_NoWebDriver {


    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {
        System. out .println( "All done!!!    Location: method 'stopSuite', in file Challenge05Test_NoWebDriver.java" );
    }

    @BeforeClass
    public void startClass() throws Exception{
    }
	
    @AfterClass
    public void stopSelenium( ) {      // stopClass() {
    }

    @BeforeMethod()
    public void beforeMethod() throws Exception {
    }

    @AfterMethod()
    public void afterMethod(){
    }


    @Test
    public void testFindListAndCountOfVehicles( ) {
        // method 'findListAndCountOfVehicles' is used in method this.test_SearchPorsche_ChgTo100

        TableDataTools localTDT = new TableDataTools( );
        TableDataToolsTest localTDTT = new TableDataToolsTest();

        // Scenario: no vehicles
        List<Vehicle> list00 = new ArrayList<>(0);
        Map hmExpect00 = new HashMap();
        Map hmActual00 = localTDT.findListAndCountOfVehicles(list00);

        System.out.println( "The var 'hmExpect00' contains [[[" + hmExpect00 + "]]]" );
        System.out.println( "The var 'hmActual00' contains [[[" + hmActual00 + "]]]" );


        // Scenario: 3 vehicles, no matches.
        List<Vehicle> list01 = new ArrayList<>( 0 );
        Vehicle veh03a = new Vehicle( );
        veh03a.setModel("alpha" );
        list01.add( veh03a );
        Vehicle veh03b = new Vehicle( );
        veh03b.setModel("bravo" );
        list01.add( veh03b );
        Vehicle veh03c = new Vehicle( );
        veh03c.setModel("alpha" );
        list01.add( veh03c );

        Map hmExpect01 = new HashMap();
        hmExpect01.put( "alpha", 2 );
        hmExpect01.put( "bravo", 1 );

        Map hmActual01 = localTDT.findListAndCountOfVehicles(list01);

        System.out.println( "The var 'hmExpect01' contains [[[" + hmExpect01 + "]]]" );
        System.out.println( "The var 'hmActual01' contains [[[" + hmActual01 + "]]]" );

        Assert.assertEquals( hmActual01, hmExpect01 );
    }

}
