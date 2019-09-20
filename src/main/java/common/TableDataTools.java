package common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TableDataTools {


    public Map<String, Integer> findListAndCountOfVehicles(List<Vehicle> sourceList ) {

        Map< String, Integer> unsortedHashMap = new HashMap<>();

        int sizeList = sourceList.size();

        for( int i = 0; i < sizeList; i++ )  {
            Vehicle oneVeh = sourceList.get( i );
            String vehModel = oneVeh.getModel();

            boolean isOnList = unsortedHashMap.containsKey( vehModel );
            if( isOnList ) {
                int currCount = unsortedHashMap.get( vehModel );
                int newCount = currCount + 1;
                unsortedHashMap.replace( vehModel, currCount, newCount );
            } else {
                unsortedHashMap.put( vehModel, 1 );
            }
        }

        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(unsortedHashMap);

        return sortedMap;
    }


    public int findCountOfOneMakeOnList( List<Vehicle> sourceList, String searchForMake ) {

        int results = 0;

        if( searchForMake == null ) {
            return 0;
        }

        int sizeList = sourceList.size();

        for( int i = 0; i < sizeList; i++ )  {
            Vehicle oneVeh = sourceList.get( i );
            String vehMake = oneVeh.getMake();

            if( vehMake.equalsIgnoreCase( searchForMake )) {
                results += 1;
            }
        }

         return results;
    }

}
