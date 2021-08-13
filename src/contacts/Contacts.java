package contacts;

import util.Input;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

//    private static boolean executeUserChoice(int choice){
//        boolean continueRunningApp = true;
//
//        switch(choice){
//            case 1:
//                System.out.println("\n");
//                Path dataFile = Paths.get(directory, filename);
//                List<String> usersContactList = Files.readAllLines(dataFile);
//                for (String line : usersContactList) {
//                    System.out.println(line);
//                }
//                break;
//            case 2:
//                System.out.println("\n");
//                viewMusiciansByGenre("jazz");
//                System.out.println("\n");
//                break;
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
//            case 5:
//                System.out.println("Good bye");
//                continueRunningApp = false;
//                break;
//
//        }
//
//        return continueRunningApp;
//
//    }

}
