

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Contacts {

    protected String names;
    protected String phoneNumber;

    public Contacts(String names, String phoneNumber) {
        this.names = names;
        this.phoneNumber = phoneNumber;

    }

    public static void main(String[] args) {


        String directory = "My PhoneBook";
        String filename = "Contacts.txt";

        createFileIfNotExists(directory, filename);

        ArrayList<String> items = makeList();
        System.out.println(items);

        try {
            writeListToFile(items, directory, filename);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            readLines(directory, filename);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

        public static void createFileIfNotExists (String directory, String filename){

            Path dataDirectory = Paths.get(directory);
            Path dataFile = Paths.get(directory, filename);
            try {
                if (Files.notExists(dataDirectory)) {
                    Files.createDirectories(dataDirectory);
                }

                if (Files.notExists(dataFile)) {
                    Files.createFile(dataFile);
                }
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
    public static void writeListToFile(ArrayList<String> list, String directory, String filename) throws IOException {
        Path filepath = Paths.get(directory, filename);
        Files.write(filepath, list, StandardOpenOption.APPEND);
    }

    public static void readLines(String directory, String filename) throws IOException{

        Path filePath = Paths.get(directory, filename);

        List<String> list = Files.readAllLines(filePath);

        for(String item : list) {
            System.out.println(item);
        }

    }

        public static ArrayList<String> makeList() {
            ArrayList<String> list = new ArrayList<>();
            Input input = new Input();
            String item;

            do {


                int swValue;
                System.out.println("|   MENU SELECTION DEMO    |");
                System.out.println("| Options:                 |");
                System.out.println("|        1. Option 1       |");
                System.out.println("|        2. Option 2       |");
                System.out.println("|        3. Exit           |");
                swValue = Keyin.inInt(" Select option: ");


                item = input.getString("                       Welcome to my contacts " + " \n" +
                        "                    <------- Select A Option ------->" + " \n" +
                        "                   | 1. View contacts.              | " + "\n" +
                        "                   | 2. Add a new contact.          | " + "\n" +
                        "                   | 3. Search a contact by name.   |" + " \n" +
                        "                   | 4. Delete an existing contact. |" + " \n" +
                        "                   | 5. Exit.                       |" + "\n" +
                        "                    <--------------------------------> ");
//
//                // Switch construct
                switch (item) {
                    case 1:
                        System.out.println("1. View contacts.");
                        break;
                    case 2:
                        System.out.println("Option 2 selected");
                        break;
                    case 3:
                        System.out.println("Exit selected");
                        break;
                    case 4:
                        System.out.println("Exit selected");
                        break;
                    default:5:
                        System.out.println("Invalid selection");
                        break; // This break is not really necessary
                }


//                list.add(item);
            } while(input.yesNo(" Would you like to enter another contact? "));

            return list;



    }


}
