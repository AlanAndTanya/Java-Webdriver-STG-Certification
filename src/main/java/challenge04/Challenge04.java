package challenge04;

import java.util.HashMap;

public class Challenge04 {

    final int MAX_LEVELS_ON_HASH_MAP = 30;


    public int findFibonacciValue( int whichOrder ) {
        //  example: for the 9th order of the sequence, we should get 21.
        int result = 0;

        // For this challenge, we are going to write a class that display the fibonacci sequence up to a
        // certain number. If I want the fibonacci for the 9 order of the sequence, I should see 21. Keep
        // your function to calculate the fibonacci sequence separate from the test file.
        //
        // However, to add additional challenge to this challenge, instead of displaying the number 21, I
        // want the string representation of twenty one. This will require you to use string concatenation to
        // print out the string.

        if( whichOrder < 0 ) {
            result = -1;
        }
        else if( whichOrder == 0 )  {
            result = 0;
        }
        else if( whichOrder > MAX_LEVELS_ON_HASH_MAP ) {
            result = -333;  // some negative number to show an out-of-bounds error.
        }
        else {
            int currSum = 0;
            // True, I could have created the logic to find the values.
            HashMap<Integer, Integer> valuesActual = createMapOfLevelAndValue();

            int oneActual = valuesActual.get( whichOrder );

            result = oneActual;
        }

        return result;
    }



    public HashMap<Integer, Integer> createMapOfLevelAndValue() {

        // added 1, as the map is ZERO based.
        HashMap< Integer, Integer> levelsAndFibValues = new HashMap<>( MAX_LEVELS_ON_HASH_MAP + 1);

        // note: the values were calculated in Excel, the edited to fit this hashMap. Could have used an array.

        //  contents: level number, then value.
        levelsAndFibValues.put( 1, 0 );
        levelsAndFibValues.put( 2, 1 );
        levelsAndFibValues.put( 3, 1 );
        levelsAndFibValues.put( 4, 2 );
        levelsAndFibValues.put( 5, 3 );
        levelsAndFibValues.put( 6, 5 );
        levelsAndFibValues.put( 7, 8 );
        levelsAndFibValues.put( 8, 13 );
        levelsAndFibValues.put( 9, 21 );
        levelsAndFibValues.put( 10, 34 );
        levelsAndFibValues.put( 11, 55 );
        levelsAndFibValues.put( 12, 89 );
        levelsAndFibValues.put( 13, 144 );
        levelsAndFibValues.put( 14, 233 );
        levelsAndFibValues.put( 15, 377 );
        levelsAndFibValues.put( 16, 610 );
        levelsAndFibValues.put( 17, 987 );
        levelsAndFibValues.put( 18, 1597 );
        levelsAndFibValues.put( 19, 2584 );
        levelsAndFibValues.put( 20, 4181 );
        levelsAndFibValues.put( 21, 6765 );
        levelsAndFibValues.put( 22, 10946 );
        levelsAndFibValues.put( 23, 17711 );
        levelsAndFibValues.put( 24, 28657 );
        levelsAndFibValues.put( 25, 46368 );
        levelsAndFibValues.put( 26, 75025 );
        levelsAndFibValues.put( 27, 121393 );
        levelsAndFibValues.put( 28, 196418 );
        levelsAndFibValues.put( 29, 317811 );
        levelsAndFibValues.put( 30, 514229 );

        return levelsAndFibValues;
    }


    @Deprecated
    // Replaced by numberToWord.
    public String convertNumberToTextString( int whatNumber ) {
        String result = "";

        // given, and return.
        // 13 - thirteen
        // 144 - one hundred forty four
        // 7408 - seven thousand four hundred eight

        String whatNumberAsString = String.valueOf( whatNumber );
        StringBuilder sourceAsString = new StringBuilder( whatNumberAsString );

        // so 13 will be 31, and 123456 will be 654321
        StringBuilder reverseSource  = sourceAsString.reverse();

        final int ONE_MILLION = 1_000_000;   // yes, java 8 allows underscore.
        final int ONE_HUNDRED_THOUSAND = 100_000;
        final int TEN_THOUSAND = 10_000;
        final int ONE_THOSAND = 1_000;
        final int ONE_HUNDRED = 100;
        final int TEN = 10;

        String digitNames[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        int currDigit = 0;
        String currUnitName = "";
        String currDigitName = "";
        String fullText = "";
        String collectThousands = "";  // given 782,200, get 782.  given 2244, get 2.

        if( whatNumber >= ONE_MILLION ) {
            currDigit = reverseSource.charAt(6);  // as stringBuilder is ZERO-based.
            if( currDigit > 0 ) {
                currUnitName = (currDigit > 0 ? " million " : "");
                currDigitName = digitNames[currDigit];
                fullText += currDigitName + " " + currUnitName;
            }
        }

        return result;
    }



    public String numberToWord( int number ) {
        // Give credit where credit is due.  From "https://codippa.com/how-to-convert-number-to-words-in-java/"
        //
        // variable to hold string representation of number
        String words = "";
        String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };
        String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        if (number == 0) {
            return "zero";
        }

        // add minus before conversion if the number is less than 0
        if (number < 0) { // convert the number to a string
            String numberStr = "" + number;
            // remove minus before the number
            numberStr = numberStr.substring(1);
            // add minus before the number and convert the rest of number
            return "minus " + numberToWord(Integer.parseInt(numberStr));
        }

        // check if number is divisible by 1 million
        if ((number / 1000000) > 0) {
            words += numberToWord(number / 1000000) + " million ";
            number %= 1000000;
        }

        // check if number is divisible by 1 thousand
        if ((number / 1000) > 0) {
            words += numberToWord(number / 1000) + " thousand ";
            number %= 1000;
        }

        // check if number is divisible by 1 hundred
        if ((number / 100) > 0) {
            words += numberToWord(number / 100) + " hundred ";
            number %= 100;
        }

        if (number > 0) {
            // check if number is within teens
            if (number < 20) {
                // fetch the appropriate value from unit array
                words += unitsArray[number];
            } else {
                // fetch the appropriate value from tens array
                words += tensArray[number / 10];
                if ((number % 10) > 0) {
                    // 2019-08-11  I removed the add of a DASH.
                    words += " " + unitsArray[number % 10];
                }
            }
        }

        return words;
    }


    public boolean isTextAnInt( String source ) {

        try {
            int myInt = Integer.parseInt( source );
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

}
