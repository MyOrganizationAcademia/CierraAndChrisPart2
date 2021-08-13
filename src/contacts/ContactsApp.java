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



    public static void main(String[] args) throws IOException {

        boolean running = true;

        while (running){
            System.out.println(returnMenuDisplay());

            int response = promptUserForChoice();
//            running = executeUserChoice(response);

        }



    }
}
