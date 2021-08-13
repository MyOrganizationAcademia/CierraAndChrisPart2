package contacts;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Contacts {

    public static void returnMenuDisplay() {
        String choices = "What would you like to do?\n" +
                "\n" +
                "1 - View all contacts\n" +
                "2 - Add a new contact\n" +
                "3 - Search a contact by her name\n" +
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


    public static boolean executeUserChoice(int choice) throws IOException {
        boolean continueRunningApp = true;
        String directory = "src/contacts";
        String filename = "contacts.txt";
        ArrayList<String> contact = new ArrayList<String>();
        Path dataFile = Paths.get(directory, filename);


        switch(choice){
            case 1:
                System.out.println("\n");
                List<String> usersContactList = Files.readAllLines(dataFile);
                for (String line : usersContactList) {
                    System.out.println(line);
                }
                break;
            case 2:
                System.out.println("\nEnter a new name and phone number: ");
                Input addName = new Input();
                Input addNumber = new Input();
                contact.add(addName.getString() + " | " + addNumber.getString()); // Used getString method from input.java
                Files.write(dataFile, contact, StandardOpenOption.APPEND);
                break;
//            case 3:
//                System.out.println("\n");
//                viewMusiciansByGenre("blues");
//                System.out.println("\n");
//                break;
//            case 4:
//                System.out.println("\n");
//                viewMusiciansByGenre("rock");
//                System.out.println("\n");
//                break;
            case 3:
                System.out.println("Good bye");
                continueRunningApp = false;
                break;

        }

        return continueRunningApp;

    }

}
