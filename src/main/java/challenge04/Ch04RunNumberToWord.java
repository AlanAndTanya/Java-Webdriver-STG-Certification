package challenge04;

import java.util.Scanner;

public class Ch04RunNumberToWord {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Challenge04 oneChallenge04 = new Challenge04();
            boolean keepLooping = true;

            while( keepLooping ) {
                System.out.println("\nPlease type a number (max of 9 digits), or 'q' to quit.");

                // read the number
                // number = scanner.next();
                String scannerText = scanner.next();
                boolean fromIsNumeric = oneChallenge04.isTextAnInt(scannerText);
                if (!fromIsNumeric) {
                    keepLooping = false;
                } else {
                    int localInt = Integer.parseInt(scannerText);

                    if (localInt == 0) {
                        System.out.println("Number in words: Zero");
                    } else {
                        System.out.println("Number in words: " + oneChallenge04.numberToWord(localInt));
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
