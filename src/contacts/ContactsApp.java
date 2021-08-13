package contacts;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ContactsApp {

    private static String returnMenuDisplay() {
        String choices = "What would you like to do?\n" +
                "\n" +
                "1 - View all contacts\n" +
                "2 - Add a new contact\n" +
                "3 - Search a contact by her name\n" +
                "4 - Delete an existing contact\n" +
                "5 - Exit\n";

        return choices;
    }

    private static int promptUserForChoice(){
        Input input = new Input();
        System.out.println("Enter your choice: ");
        int response = input.getInt(1,5);
        return response;
    }


    private static boolean executeUserChoice(int choice){
        boolean continueRunningApp = true;

        switch(choice){
            case 1:
                System.out.println("\n");
                for (String line : usersContactList) {
                    System.out.println(line);
                }
                break;
            case 2:
                System.out.println("\n");
                viewMusiciansByGenre("jazz");
                System.out.println("\n");
                break;
            case 3:
                System.out.println("\n");
                viewMusiciansByGenre("blues");
                System.out.println("\n");
                break;
            case 4:
                System.out.println("\n");
                viewMusiciansByGenre("rock");
                System.out.println("\n");
                break;
            case 5:
                System.out.println("Good bye");
                continueRunningApp = false;
                break;

        }

        return continueRunningApp;

    }

    public static void main(String[] args) throws IOException {
        System.out.println(returnMenuDisplay());
        String directory = "src/contacts";
        String filename = "contacts.txt";

        ArrayList<String> contact = new ArrayList<String>();

        contact.add("Cierra Smith | 1234567890");
        contact.add("Chris Alvarez | 1234567899");

        Path dataFile = Paths.get(directory, filename);

        // If the file does not exist, create the file
        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        Files.write(dataFile, contact, StandardOpenOption.APPEND);

//        List<String> usersContactList = Files.readAllLines(dataFile);

//        for (String line : usersContactList) {
//            System.out.println(line);
//        }
    }


}
