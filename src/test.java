

import java.io.*;
import java.util.*;

public class test {

    public static void main(String args[]) throws IOException {
        Contact contact;
        contact = new Contact();
        int action = 0;

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        while (action != 6) {

            System.out.println("                         Welcome to Contact List. "
                    + "<--------------> What would you like to do? \n");

            System.out.println("                             __________________________________________________________   " + "\n"
                    + "                                1. Add a New Contact.                                                           " + "\n"
                    + "                                2. Go to Contact List                                      " + "\n"
                    + "                                3. Retrieve a person's information by last name                " + "\n"
                    + "                                4. Edit Contacts            " + "\n"
                    + "                                5. Delete Contacts            " + "\n"    /* add a delete feature remove this option*/
                    + "                                6. Exit                                                         " + "\n"
                    + "                             __________________________________________________________   " + "\n");

            Scanner reader = new Scanner(System.in);
            reader.useDelimiter("\n");
            action = reader.nextInt();

            if (action <= 0 || action > 6) {
                System.out.println("Invalid selection. ");

            }

            switch (action) {

                case 1: {

                    System.out.println("\nEnter Contact Last Name:");
                    String lastname = reader.next();
                    if (lastname == null) {
                        System.out.println("\nInvalid entry. ");
                        break;
                    } else {
                        contact.setLastName(lastname.toLowerCase());
                    }
                    System.out.println("Enter Contact First Name: ");
                    String firstname = reader.next();
                    contact.setFirstName(firstname.toLowerCase());
                    System.out.println("Enter Contact Phone Number: ");
                    String phone = reader.next();
                    contact.setPhone(phone.toLowerCase());
                    System.out.println("Enter Contact Notes: ");
                    String notes = reader.next();
                    contact.setNotes(notes.toLowerCase());

                    contacts.add(contact);

                    try {

                        Contact c = contact;

                        File file = new File("contactlist.csv");



                        // If file doesn't exists, then create it.
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        try (PrintWriter output = new PrintWriter(new FileWriter("contactlist.csv", true))) {
                            output.printf("%s\r\n", c);
                        } catch (Exception e) {
                        }

                        System.out.println("Your contact has been saved.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                break;


                case 2: {

                    int counter = 0;
                    String line = null;

                    // Location of file to read
                    File file = new File("contactlist.csv");

                    // Sort contacts and print to console
                    try {

                        Scanner scanner = new Scanner(file);


                        Set<String> lines = new TreeSet<>();
                        while (scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            lines.add(line);
                            counter++;

                        }

                        // Print sorted contacts to console.
                        for (String fileLine : lines) {
                            String outlook = fileLine.substring(0, 1).toUpperCase()
                                    + fileLine.substring(1);
                            System.out.println(outlook);

                        }


                        scanner.close();

                    } catch (FileNotFoundException e) {

                    }
                    System.out.println("\n" + counter + " contacts in records.");

                }

                break;


                case 3:

                    try {
                        System.out.println("\nEnter the last"
                                + "name to search for: ");
                        String searchterm = reader.next();

                        // Open the file as a buffered reader
                        BufferedReader bf = new BufferedReader(new FileReader("contactlist.csv"));

                        // Start a line count and declare a string to hold our
                        // current line.
                        int linecount = 0;
                        String line;

                        // Let the user know what we are searching for
                        System.out.println("Searching for " + searchterm
                                + " in file...");
                        // Loop through each line, putting the line into our line
                        // variable.
                        boolean noMatches = true;
                        while ((line = bf.readLine()) != null) {
                            // Increment the count and find the index of the word.
                            linecount++;
                            int indexfound = line.indexOf(searchterm.toLowerCase());

                            // If greater than -1, means we found a match.
                            if (indexfound > -1) {
                                System.out.println("\nContact was FOUND\n"
                                        + "\nContact " + linecount + ": " + line);
                                noMatches = false;
                            }

                        }

                        // Close the file after done searching
                        bf.close();
                        if (noMatches) {
                            System.out.println("\nNO MATCH FOUND.\n");
                        }
                    } catch (IOException e) {
                        System.out.println("IO Error Occurred: " + e.toString());
                    }

                    break;


                case 4:

                    try {
                        System.out.println("\nEnter the email "
                                + "address to search for: ");
                        String searchterm = reader.next();

                        // Open the file as a buffered reader
                        BufferedReader bf = new BufferedReader(new FileReader("contactlist.csv"));

                        // Start a line count and declare a string to hold our
                        // current line.
                        int linecount = 0;
                        String line;

                        // Let the user know what we are searching for
                        System.out.println("\nSearching for " + searchterm
                                + " in file...");

                        // Loop through each line, put the line into our line
                        // variable.
                        boolean noMatches = true;
                        while ((line = bf.readLine()) != null) {

                            // Increment the count and find the index of the word
                            linecount++;
                            int indexfound = line.indexOf(searchterm.toLowerCase());

                            // If greater than -1, means we found a match
                            if (indexfound > -1) {
                                System.out.println("\nContact was FOUND\n"
                                        + "\nContact " + linecount + ": " + line);
                                noMatches = false;
                            }

                        }
                        // Close the file after done searching
                        bf.close();
                        if (noMatches) {
                            System.out.println("\nNO MATCH FOUND.\n");
                        }

                    } catch (IOException e) {
                        System.out.println("IO Error Occurred: " + e.toString());
                    }

                    break;


                case 5:

                    try {
                        System.out.println("\nWould you like to delete a contact: ");
                        String searchterm = reader.next();

                        // Open the file as a buffered reader
                        BufferedReader bf = new BufferedReader(new FileReader("contactlist.csv"));

                        // Start a line count and declare a string to hold our
                        // current line.
                        int linecount = 0;
                        String line;

                        // Let the user know what we are searching for
                        System.out.println("\nSearching for " + searchterm
                                + " in file...");

                        // Loop through each line, stashing the line into our line
                        // variable.
                        boolean noMatches = true;
                        while ((line = bf.readLine()) != null) {

                            // Increment the count and find the index of the word.

                            linecount++;
                            int indexfound = line.indexOf(searchterm.toLowerCase());

                            // If greater than -1, means we found a match.
                            if (indexfound > -1) {
                                System.out.println("\nContact was FOUND\n"
                                        + "\nContact " + linecount + ": " + line);
                                noMatches = false;
                            }
                        }
                        // Close the file after done searching
                        bf.close();
                        if (noMatches) {
                            System.out.println("\nNO MATCH FOUND.\n");
                        }
                    } catch (IOException e) {
                        System.out.println("IO Error Occurred: " + e.toString());
                    }

                    break;
            }
        }
    }


    public static class Contact {
        private String lastname, firstname, phone,
                notes;

        public Contact(String lastnamename, String firstname, String address,
                       String city, String zip, String email, String phone, String notes,
                       String lastname) {
            this.lastname = lastname;
            this.firstname = firstname;

            this.phone = phone;
            this.notes = notes;
        }

        public Contact() {

        }

        // overrides the default Object method
        public String toString() {
            System.out.println(" Contacts ");
            return "Name   |  PhoneNumber  |  Notes " + "\n" +
                    "<------------------------------->" + "\n" +
                    lastname + ", " + firstname + " |"
                    +  " |  " + phone + " | " + notes;
        }

        /*
         * Sets the value for lastname to "s".
         */
        public void setLastName(String sLast) {
            lastname = sLast;
        }

        /*
         * Returns the value of lastname.
         */
        public String getLastName() {
            return lastname;
        }

        /*
         * Sets the value for firstname to "a".
         */
        public void setFirstName(String sFirst) {
            firstname = sFirst;
        }

        /*
         * Returns the value of firstname.
         */
        public String getFirstName() {
            return firstname;
        }


        /*
         * Sets the value for phone to "e".
         */
        public void setPhone(String phoneNum) {
            phone = phoneNum;
        }

        /*
         * Returns the value of phone.
         */
        public String getPhone() {
            return phone;
        }

        /*
         * Sets the value for notes to "g".
         */
        public void setNotes(String note) {
            notes = note;
        }

        /*
         * Returns the value of notes.
         */
        public String getNotes() {
            return notes;
        }

        public void read() {

        }

        static void write() {

            try {
                Contact contact;
                contact = new Contact();
                Contact c = contact;

                File file = new File("contactlist.csv");

                // If file doesn't exists, then create it.
                if (!file.exists()) {
                    file.createNewFile();
                }

                try (PrintWriter output = new PrintWriter(new FileWriter(
                        "contactlist.csv", true))) {
                    output.printf("%s\r\n", c);
                } catch (Exception e) {
                }

                System.out.println("Your contact has been saved.");
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}