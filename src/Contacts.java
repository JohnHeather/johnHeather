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

        Scanner scanner = new Scanner(System.in);
        int userInput;

        try {

        System.out.printf("Welcome to my contacts" + " \n" +
                "<--------------------------------->" + " \n" +
                "1. View contacts." + " \n" +
                "2. Add a new contact." + " \n" +
                "3. Search a contact by name." + " \n" +
                "4. Delete an existing contact." + " \n" +
                "5. Exit." + " \n" +
                "<-------------------------------->");

        userInput = input.nextInt(); //input for user option
        if(userInput > 5 || userInput < 1){
            System.out.println("Please enter an option from 1 to 5!\n");
            openMenu();
        }


        }





    }

    do{

    }while ()



}
