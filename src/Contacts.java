
import java.util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
//import java.util.Scanner;


public class Contacts {

    protected String names;
    protected int phoneNumber;

    public Contacts(String names, int phoneNumber) {
        this.names = names;
        this.phoneNumber = phoneNumber;

    }

    public static void main(String[] args) {

//        int userInput;
        String directory = "data";
        String filenmae = "PhoneBook.txt";

//        createFileIfNotExists(dirctory, filenmae);

        ArrayList<String> items = makeList();
    }


        public static void createFileIfNotExists (String directory, String filename){

            Path dataDirectory = Path.get(directory);
            Path dataFile = Path.get(directory, filenmae);
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


        public static ArrayList<String> makeList() {
            ArrayList<String> list = new ArrayList<>();
            Input input = new Input();
            String item;

            do {
                item = input.getString("Welcome to my contacts\" + \" \\n\" +\n" +
                        "                    \"<--------------------------------->\" + \" \\n\" +\n" +
                        "                    \"1. View contacts.\" + \" \\n\" +\n" +
                        "                    \"2. Add a new contact.\" + \" \\n\" +\n" +
                        "                    \"3. Search a contact by name.\" + \" \\n\" +\n" +
                        "                    \"4. Delete an existing contact.\" + \" \\n\" +\n" +
                        "                    \"5. Exit.\" + \" \\n\" +\n" +
                        "                    \"<--------------------------------> ");
                list.add(item);
            } while(input.yesNo(" Would you like to enter another contact? "));

            return list;



    }


}
