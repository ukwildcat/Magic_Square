/*
 * Project 2 for CS 1180
 * This program helps a user create a magic square and checks it.
 */
package project2_lawson;

/**
 * Stacey Lawson 
 * 1180L-07
 * Goshtasby
 * Project 2
 */
import java.util.Scanner;

public class Project2_Lawson {

    /**
     * User input to generate square size
     */
    public static void main(String[] args) {
        System.out.print("Let's make a Magic Square! How big should it be? ");
        Scanner input = new Scanner(System.in);

        //Ask user for sqaure size
        int n = input.nextInt();

        //Set parameters for size of square allowed
        if ((n > 0) && (n <= 8) && (n != 2)) {
            System.out.print("Great!" + "\n");
        }
        if ((n == 2) || (n <= 0)) {
            System.out.println("That would violate the laws of mathematics!");
            return;
        }
        if (n > 8) {
            System.out.println("That's huge! Please enter a number less than 9.");
            return;

        }
        //Set up way to end 
        int terminate = 1;
        int square[][] = new int[n][n];
        while (terminate != 0) {

            //Call methods
            displaySquare(n, square);
            inputValues(square, n);
            boolean check = checkSquare(square, n);

            if (check) {
                terminate = 0;
            }

        }
        displaySquare(n, square);
        System.out.print("Victory!\n");

    }//end main method

    /**
     * Display square based on user size input
     */
    public static void displaySquare(int n, int square[][]) {
        System.out.println("The square currently looks like this: ");
        //Set up display of square
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                System.out.printf("%3d", square[r][c]);
            }

            System.out.println();
        }

    }//end displaySquare method

    /**
     * Input values for square by row and column
     */
    public static void inputValues(int square[][], int n) {
        Scanner input = new Scanner(System.in);
        //Ask for values
        System.out.println("Where do you want to put a new value?");
        System.out.print("Row: ");
        int r = input.nextInt();
        System.out.print("Column: ");
        int c = input.nextInt();

        //Ask for value location
        System.out.print("What value should go there? ");
        int value = input.nextInt();

        //Set warning message
        if (value < 0 || value > (n * n)) {
            System.out.print("You can only use numbers between 1 and " + (n * n)
                    + " for this square.");

            //Check for duplicate number
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (value == square[i][j]) {
                        System.out.println("That number has already been used.");
                        return;

                    }
                }
            }
            //Put value in square
            square[r][c] = value;

        }

    }//end input values method

    /*
     *Check rows, columns and both diagonals to see if sums are equal
     */
    public static boolean checkSquare(int[][] square, int n) {
        //Set up a check to compare rows, columns, diagonals to
        int baseSum = 0;
        for (int s = 0; s < n; s++) {
            baseSum += square[0][s];

        }
        //Go through rows and sum values
        int sum = 0;
        for (int row = 0; row < n; row++) {
            sum = 0;
            for (int col = 0; col < n; col++) {
                sum += square[row][col];
            }
            //Check to see if sums are equal and return false if not
            if (baseSum != sum) {
                return false;
            }

        }
        //Go through columns and sum values
        for (int col = 0; col < n; col++) {
            sum = 0;
            for (int row = 0; row < n; row++) {
                sum += square[row][col];
            }

            //Check to see if sums are equal and return false if not
            if (baseSum != sum) {
                return false;
            }
        }
        //Go through 1st diagonal and sum values
        sum = 0;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                if (row == col) {
                    sum += square[row][col];

                }
            }
        }
        //Check to see if sums are equal and return false if not
        if (baseSum != sum) {
            return false;

        }
        //Go through 2nd diagonal and sum values
        sum = 0;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                if (n == 1 + row + col) {
                    sum += square[row][col];
                }
            }
        }
        //Check to see if sums are equal and return false if not
        if (baseSum != sum) {
            return false;

            //Otherwise return true
        } else {
            return true;
        }
    }//end checkSquare method
}
