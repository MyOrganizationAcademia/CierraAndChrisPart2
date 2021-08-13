package util;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
//        System.out.println("Type Something: ");
        String userString = scanner.nextLine();
        return userString;
    }

    public boolean yesNo() {
//        System.out.println("Select (y/n):");
        String userAnswer = scanner.next();
        scanner.nextLine();
        return userAnswer.equals("y");
    }


    public int getInt(int min, int max) {
        System.out.println("Give me an integer between " + min + " and " + max + ": ");
        int userInt;

        try {
            userInt = Integer.valueOf(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("That is not an integer!");
            return getInt(min, max);
        }

        if (userInt < min || userInt > max) {
            System.out.println("Invalid input! Try again!");
            return getInt(min, max);
        } else {
//            System.out.println("That's a valid integer.");
            return userInt;
        }
    }

    public int getInt() {
        System.out.println("Give me an integer: ");
        try {
            return Integer.valueOf(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("That is not an integer!");
            return getInt();
        }
    }

    public double getDouble(double min, double max) {
        System.out.println("Give me an decimal: ");
        double userDouble;

        try {
            userDouble = Double.valueOf(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("That is not a double!");
            return getDouble(min, max);
        }

        if (userDouble < min || userDouble > max) {
            System.out.println("Try again!");
            return getDouble(min, max);
        } else {
            System.out.println("That's a valid decimal.");
            return userDouble;
        }
    }

    public double getDouble() {
        System.out.println("Give me a decimal: ");
        try {
            return Double.valueOf(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("That is not a double!");
            return getDouble();
        }
    }

    // BONUS FOR EXCEPTIONS EXERCISE

    public int getBinary() {
        System.out.println("Enter a binary number:");
        try {
            return Integer.valueOf(this.getString(), 2);
        } catch (NumberFormatException e) {
            System.out.println("That is not a binary number!");
            return getBinary();
        }
    }

    public int getHex() {
        System.out.println("Enter hex:");
        try {
            return Integer.valueOf(this.getString(), 16);
        } catch (NumberFormatException e) {
            System.out.println("That is not a double!");
            return getHex();
        }
    }


}
