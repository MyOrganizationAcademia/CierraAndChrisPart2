package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String getString() {
//        System.out.println("Please enter a string: ");
        String userString = scanner.next();
        return userString;
    }

    public boolean yesNo() {
        System.out.println("Would you like to continue, yes or no? ");
        boolean userSaidYes = scanner.next().toLowerCase().contains("y");

        if (userSaidYes) {
            return true;
        } else {
            return false;
        }
    }


    public int getInt(int min, int max) {
        System.out.println("Please enter an integer between 0 and 15: ");
        // Ry's way for the Exception exercise
        int userInput;

        try {
            userInput = Integer.valueOf(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("Sorry, that is not an integer between 0 and 15.");
            return getInt(min, max);
        }

        if (userInput >= min && userInput <= max) {
//            System.out.println(userInput + " is in the range!");
        } else {
            System.out.println("Sorry, that is not an integer between 0 and 15.");
            return getInt(min, max);
        }
        return userInput;
    }

    public int getInt() {
        System.out.print("Please enter any integer: ");
        String s = getString();

        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            System.out.println("Sorry, that is not an integer.");
            return getInt();
        }
//        int usersInteger = scanner.nextInt();
    }

    public double getDouble(double min, double max) {
        System.out.println("Please enter a number with a decimal between -10.5 and 10.5: ");
        double userInput = scanner.nextDouble();
        if (userInput >= min && userInput <= max) {
            System.out.println(userInput + " is in the range!");
        } else {
            System.out.println(userInput + " is not in the range, try again.");
            return getDouble(min, max);
        }
        return userInput;
    }

    public double getDouble() {
        System.out.println("Please enter any number with a decimal: ");
        String s = getString();

        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.out.println("Sorry, that is not a number with a decimal.");
            return getDouble();
        }
//        double userDoubleInput = scanner.nextDouble();
//        return userDoubleInput;
    }

    public int getBinary() {
        System.out.println("Enter a binary number: ");
        try {
            return Integer.valueOf(this.getString(), 2);
        } catch (NumberFormatException e) {
            System.out.println("That is not a binary number.");
            return getBinary();
        }
    }

    public int getHex() {
        System.out.println("Enter a hexadecimal: ");
        try {
            return Integer.valueOf(this.getString(), 16);
        } catch (NumberFormatException e) {
            System.out.println("That is not a hexadecimal.");
            return getHex();
        }
    }
}




