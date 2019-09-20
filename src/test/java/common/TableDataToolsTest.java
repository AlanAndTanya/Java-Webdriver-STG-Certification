package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TableDataToolsTest {

    public List<Vehicle> findTableData(WebDriver localDriver ) {

        List<Vehicle> listVehicle = new ArrayList<>();

        String idNameOfDataTable = "serverSideDataTable";
        By byNameOfDataTable = By.id( idNameOfDataTable );

        WebElement weSSDTL = (new WebDriverWait(localDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated( By.id( "serverSideDataTable_length" )));


        WebElement wbDataTableLength = localDriver.findElement(By.name("serverSideDataTable_length"));

        WebElement wbDataTable = localDriver.findElement( byNameOfDataTable );
        List<WebElement> listRows = wbDataTable.findElements(By.tagName("tr"));
        int rowCount = listRows.size();


        for( int i = 0; i < rowCount; i++ ) {
            WebElement oneRow = listRows.get(i);

            List<WebElement> listTD = oneRow.findElements(By.tagName("td"));
            int countColumns = listTD.size();

            // TODO: Remove the usage of magic numbers.  CODE SMELL.
            if( countColumns > 5 ) {
                Vehicle currVehicle = new Vehicle();

                for (int j = 0; j < countColumns; j++) {
                    WebElement oneTD = listTD.get(j);

                    String textOfOneTD = oneTD.getText();

                    if (j == 2) {
                        currVehicle.splitIntoLotNumberAndWatchThis(textOfOneTD);
                    } else if (j == 3) {
                        currVehicle.setModelYear(Integer.valueOf(textOfOneTD));
                    } else if (j == 4) {
                        currVehicle.setMake(textOfOneTD);
                    } else if (j == 5) {
                        currVehicle.setModel(textOfOneTD);
                    } else if( j == 11) {
                        currVehicle.setDamageTypeText(textOfOneTD);
                    }
                }

                listVehicle.add(currVehicle);
            }
        }

        return listVehicle;
    }


    public void displaySizeOfVehicleList(List<Vehicle> listVehicle) {

        // Added this short method, as I have it in both Challenge02.java and Challenge05.java

        StringBuilder traceMsg = new StringBuilder( 100 );
        traceMsg.append( "Len of listVehicle is " )
                .append( listVehicle.size() );
        System.out.println( traceMsg );
    }


}
