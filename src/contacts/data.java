package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class data {

    public static void main(String[] args) throws IOException {

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

        List<String> usersContactList = Files.readAllLines(dataFile);

        for (String line : usersContactList) {
            System.out.println(line);
        }
    }

}
