import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class Contacts {

    protected String names;
    private int phoneNumber;

    public Contacts(String names, int phoneNumber) {
        this.names = names;
        this.phoneNumber = phoneNumber;

    }







    public static void main(String[] args){

        System.out.printf("Welcome to my contacts" + " \n" +
                "<--------------------------------->" + " \n" +
                "1. View contacts." + " \n" +
                "2. Add a new contact." + " \n" +
                "3. Search a contact by name." + " \n" +
                "4. Delete an existing contact." + " \n" +
                "5. Exit." + " \n" +
                "<-------------------------------->");

    }


}
