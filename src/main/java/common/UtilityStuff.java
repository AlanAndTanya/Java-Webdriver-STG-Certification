package common;

import java.util.Map;

public class UtilityStuff {


    public void printMap(Map<String, Integer> map, String reportName ) {
        System.out.println( "****  For " + reportName + " **********************************" );
        System.out.println( "****  Found " + map.size() + " entries.");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
        System.out.println();
    }


    public void printMapStringString(Map<String, String> map, String reportName ) {
        System.out.println( "****  For " + reportName + " **********************************" );
        System.out.println( "****  Found " + map.size() + " entries.");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
        System.out.println();
    }


    public void displayLengthAndContents(String studyThis) {
        // wrote the same stuff in multiple places as I learned some techniques.

        System.out.println( "var studyThis has " + studyThis.length() +
                " characters, and contains [[[" + studyThis + "]]]" );
    }


}
