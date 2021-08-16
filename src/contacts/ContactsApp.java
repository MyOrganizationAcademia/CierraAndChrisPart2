package contacts;



import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ContactsApp extends Contacts{



    public static void main(String[] args) throws IOException {
        String directory = "src/contacts";
        String filename = "contacts.txt";

        boolean running = true;

        while (running){
            returnMenuDisplay();

            int response = promptUserForChoice();
            running = executeUserChoice(response, directory, filename);

        }



    }

}
