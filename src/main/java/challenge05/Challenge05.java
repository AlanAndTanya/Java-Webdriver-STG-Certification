package challenge05;

import common.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Challenge05 {


    public Map<String, Integer> findListOfDamageTypeText(List<Vehicle> sourceList ) {

        Map<String, Integer> unsortedHashMap = new HashMap<>();

        int sizeList = sourceList.size();

        int[] damageTypeCounts = new int[5];

        int indexForRearEnd = 0;
        int indexForFrontEnd = 1;
        int indexForMinorDent = 2;   // really is "MINOR DENT/SCRATCHES"
        int indexForUnderCarriage = 3;
        int indexForMisc = 4;    // Any other types can be grouped into one of MISC.

        // NOTE: I could have used an Enumeration.
        final String DAMAGE_REAR_END = "REAR END";
        final String DAMAGE_FRONT_END = "FRONT END";
        final String DAMAGE_MINOR_DENT = "MINOR DENT/SCRATCHES";
        final String DAMAGE_UNDERCARRIAGE = "UNDERCARRIAGE";
        final String DAMAGE_MISC = "MISC, or all other types";


        for (int i = 0; i < sizeList; i++) {
            Vehicle oneVeh = sourceList.get(i);
            String damageType = oneVeh.getDamageTypeText();

            if( damageType == null ) {
                String traceMsg = "Found a null value in damageText when lotId= " + oneVeh.getLotNumber();
                System.out.println( traceMsg );
            }

            switch (damageType) {
                case DAMAGE_REAR_END:
                    damageTypeCounts[indexForRearEnd] += 1;
                    break;
                case DAMAGE_FRONT_END:
                    damageTypeCounts[indexForFrontEnd] += 1;
                    break;
                case DAMAGE_MINOR_DENT:
                    damageTypeCounts[indexForMinorDent] += 1;
                    break;
                case DAMAGE_UNDERCARRIAGE:
                    damageTypeCounts[indexForUnderCarriage] += 1;
                    break;
                default:
                    damageTypeCounts[indexForMisc] += 1;
                    break;
            }
        }

        unsortedHashMap.put(DAMAGE_REAR_END, damageTypeCounts[indexForRearEnd]);
        unsortedHashMap.put(DAMAGE_FRONT_END, damageTypeCounts[indexForFrontEnd]);
        unsortedHashMap.put(DAMAGE_MINOR_DENT, damageTypeCounts[indexForMinorDent]);
        unsortedHashMap.put(DAMAGE_UNDERCARRIAGE, damageTypeCounts[indexForUnderCarriage]);
        unsortedHashMap.put(DAMAGE_MISC, damageTypeCounts[indexForMisc]);

        return unsortedHashMap;
    }

}
