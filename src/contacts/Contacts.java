package contacts;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Contacts {
    String directory = "src/contacts";
    String filename = "contacts.txt";

    public static void returnMenuDisplay() {
        String choices = "What would you like to do?\n" +
                "\n" +
                "1 - View all contacts\n" +
                "2 - Add a new contact\n" +
                "3 - Search a contact by name\n" +
                "4 - Delete an existing contact\n" +
                "5 - Exit\n";

        System.out.println(choices);
    }

    public static int promptUserForChoice(){
        Input input = new Input();
        int response = input.getInt(1,5);
        System.out.println(response);
        return response;
    }

    private static void viewAllContacts(Path dataFile) throws IOException {
        System.out.println("Name | Phone number");
        System.out.println("--------------");
        List<String> usersContactList = Files.readAllLines(dataFile);
        for (String line : usersContactList) {
            System.out.println(line.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3"));
        }
    }

    private static void addNewContact(Path dataFile) throws IOException {
        List<String> contact = new ArrayList<>();
        Input inputName = new Input();
        Input inputNumber = new Input();

        contact.add(inputName.getString() + " | " + inputNumber.getString()); // Used getString method from input.java
        Files.write(dataFile, contact, StandardOpenOption.APPEND);
    }

    private static void viewByContactName(Path dataFile) throws IOException {
        Input input = new Input();
        List<String> usersContactList = Files.readAllLines(dataFile);
        String contactToView = input.getString().toLowerCase(); // toLowerCase fixes case sensitivity

        for (String contact : usersContactList) {
            boolean ans = contact.contains(contactToView);
            if(ans){
                System.out.println(contact);
            }
        }
    }

    private static void removeContact(Path dataFile) throws IOException {
        Input input = new Input();
        List<String> usersContactList = Files.readAllLines(dataFile);
        String contactToView = input.getString().toLowerCase(); // toLowerCase fixes case sensitivity

        for (String contact : usersContactList) {
            boolean ans = contact.contains(contactToView);
            if(ans){
                usersContactList.remove(contact);
                Files.write(dataFile, usersContactList);
            }
        }
    }


    public static boolean executeUserChoice(int choice, String directory, String filename) throws IOException {
        boolean continueRunningApp = true;

        Path dataFile = Paths.get(directory, filename);


        switch(choice){
            case 1:
                System.out.println("\n");
                viewAllContacts(dataFile);
                break;
            case 2:
                System.out.println("\nEnter a new name and phone number: ");
                addNewContact(dataFile);
                break;
            case 3:
                System.out.println("\nEnter a name you want to search: ");
                viewByContactName(dataFile);
                break;
            case 4:
                System.out.println("\nEnter a name you want to remove: ");
                removeContact(dataFile);
                break;
            case 5:
                System.out.println("Okay, good-bye.");
                continueRunningApp = false;
                break;

        }

        return continueRunningApp;

    }

}
