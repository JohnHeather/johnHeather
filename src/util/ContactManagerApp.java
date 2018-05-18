package util;

import java.io.*;
import java.util.*;


public class ContactManagerApp {


public static void main(String[] args) {
    ContactManagerApp contact;
    contact = new ContactManagerApp();
    int action = 0;

    ArrayList<ContactManagerApp> contacts = new ArrayList<ContactManagerApp>();
    while (action != 6) {
        System.out.println(" ");
        Scanner reader = new Scanner(System.in);
        reader.useDelimiter("\n");
        action = reader.nextInt();

        if ( action <= 0 ||  action > 6) {
            System.out.println("Invalid selection. ");
        }

        switch (action) {
            case 1: {

                System.out.println("\n Enter Contact Last Name: ");

            }

            }
            break;
//
//
//            case 2: {
//
//                System.out.println(" ");
//
//            }
//            break;
//
//            case 3: {
//
//            }
//            break;
//
//            case 4: {
//
//            }
//            break;
//
//            case 5: {
//
//            }
//            break;
//
//            case 6: {
//
//            }
//            break;

    }

}

}
