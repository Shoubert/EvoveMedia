package movierental;

import java.util.Scanner;

/**
 * Assignment 08: rent three movies and show their details and late fees.
 * Run: java -cp out movierental.Assignment8
 *
 * @author Shoubert Charlotin
 */
public class Assignment8 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number of days late:");
        while (!keyboard.hasNextInt()) {
            if (!keyboard.hasNext()) return;
            keyboard.next();
            System.out.println("Please enter a whole number of days:");
        }
        int daysLate = keyboard.nextInt();

        Movie[] rentals = {
            new Comedy("Men In Black", "PG-13", 123456789, 5),
            new Action("Lord of the Rings: Return of the King", "R", 223456790, 4),
            new Drama("Despicable Me", "G", 243534, 7),
        };

        double total = 0;
        for (int i = 0; i < rentals.length; i++) {
            System.out.println("Rental" + (i + 1) + " details:");
            rentals[i].movieDetails(daysLate);
            total += rentals[i].calcLateFees(daysLate);
        }
        System.out.printf("Total late fees: $%.2f%n", total);
    }
}
