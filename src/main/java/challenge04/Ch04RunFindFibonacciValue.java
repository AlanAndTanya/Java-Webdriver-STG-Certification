package challenge04;

import java.util.Scanner;

public class Ch04RunFindFibonacciValue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Challenge04 oneChallenge04 = new Challenge04();

            boolean keepLooping = true;

            while( keepLooping ) {
                System.out.println( "\n\nEnter a level number to find it's FibonacciValue.  Max of 30, or any text to quit: ");

                String scannerText = scanner.next();
                boolean fromIsTextAnInt = oneChallenge04.isTextAnInt(scannerText);
                if (! fromIsTextAnInt ) {
                    keepLooping = false;
                }
                else {
                    int number = Integer.parseInt( scannerText );
                    if (number < 0) {
                        System.out.print("Please enter a positive number between 0 and 30.");
                    } else if (number > 30) {
                        System.out.print("Currently, we show up to the 30th level.");
                    } else {
                        int textToDisplay = oneChallenge04.findFibonacciValue(number);
                        System.out.print("For level, " + number + ", its Fibonacci Value is " + textToDisplay);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
        }

        // close the reader
        scanner.close();
    }

}
