//
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.*;
//
//
//public class Contacts {
//
//    protected String names;
//    protected String phoneNumber;
//
//    public Contacts(String names, String phoneNumber) {
//        this.names = names;
//        this.phoneNumber = phoneNumber;
//
//    }
//
//    public static void main(String[] args) {
//
//
//        String directory = "My PhoneBook";
//        String filename = "Contacts.txt";
//
//        createFileIfNotExists(directory, filename);
//
//        ArrayList<String> items = makeList();
//        System.out.println(items);
//
//        try {
//            writeListToFile(items, directory, filename);
//        } catch(IOException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            readLines(directory, filename);
//        } catch(IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//        public static void createFileIfNotExists (String directory, String filename){
//
//            Path dataDirectory = Paths.get(directory);
//            Path dataFile = Paths.get(directory, filename);
//            try {
//                if (Files.notExists(dataDirectory)) {
//                    Files.createDirectories(dataDirectory);
//                }
//
//                if (Files.notExists(dataFile)) {
//                    Files.createFile(dataFile);
//                }
//            } catch(IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    public static void writeListToFile(ArrayList<String> list, String directory, String filename) throws IOException {
//        Path filepath = Paths.get(directory, filename);
//        Files.write(filepath, list, StandardOpenOption.APPEND);
//    }
//
//    public static void readLines(String directory, String filename) throws IOException{
//
//        Path filePath = Paths.get(directory, filename);
//
//        List<String> list = Files.readAllLines(filePath);
//
//        for(String item : list) {
//            System.out.println(item);
//        }
////
//    }
//
//        public static ArrayList<String> makeList() {
//            ArrayList<String> list = new ArrayList<>();
//            Input input = new Input();
//            String item;
//
//            do {
//
//
//                int swValue;
//                System.out.println("|   MENU SELECTION DEMO    |");
//                System.out.println("| Options:                 |");
//                System.out.println("|        1. Option 1       |");
//                System.out.println("|        2. Option 2       |");
//                System.out.println("|        3. Exit           |");
//
//
//                item = input.getString("                       Welcome to my contacts " + " \n" +
//                        "                    <------- Select A Option ------->" + " \n" +
//                        "                   | 1. View contacts.              | " + "\n" +
//                        "                   | 2. Add a new contact.          | " + "\n" +
//                        "                   | 3. Search a contact by name.   |" + " \n" +
//                        "                   | 4. Delete an existing contact. |" + " \n" +
//                        "                   | 5. Exit.                       |" + "\n" +
//                        "                    <--------------------------------> ");
////
//////                // Switch construct
////                switch (item) {
////                    case 1:
////                        System.out.println("1. View contacts.");
////                        break;
////                    case 2:
////                        System.out.println("Option 2 selected");
////                        break;
////                    case 3:
////                        System.out.println("Exit selected");
////                        break;
////                    case 4:
////                        System.out.println("Exit selected");
////                        break;
////                    default 5:
////                        System.out.println("Invalid selection");
////                        break; // This break is not really necessary
////                }
//
//
////                list.add(item);
//            } while(input.yesNo(" Would you like to enter another contact? "));
//
//            return list;
//
//
//
//    }
//
//
//}
///-----------------------------------------------






import java.io.*;
        import java.util.*;

public class Contacts {

    protected String names;
    protected String phoneNumber;

    public Contacts(String names, String phoneNumber) {
        this.names = names;
        this.phoneNumber = phoneNumber;

    }

    public static void main(String args[]) throws IOException {
        Contact contact;
        contact = new Contact();
        int action = 0;

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        while (action != 6) {

            System.out.println("                                       Welcome to Contact List. "
                    + "<--------------> What would you like to do? \n");

            System.out.println("                             __________________________________________________________   " + "\n"
                    + "                                1. Add a New Contact.                                                           " + "\n"
                    + "                                2. Go to Contact List                                      " + "\n"
                    + "                                3. Retrieve a person's information by last name                " + "\n"
                    + "                                4. Retrieve a person's information by email address            " + "\n"
                    + "                                5. Retrieve all people who live in a given zip code            " + "\n"    /* add a delete feature remove this option*/
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

                        File file = new File("PhoneBook.txt");



                        // If file doesn't exists, then create it.
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        try (PrintWriter output = new PrintWriter(new FileWriter("PhoneBook.txt", true))) {
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
                    File file = new File("PhoneBook.txt");

                    // Sort contacts and print to console
                    try {

                        Scanner scanner = new Scanner(file);

                        // Before printing, add each line to a sorted set. by Seth
                        // Copeland
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
                        BufferedReader bf = new BufferedReader(new FileReader("PhoneBook.txt"));

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
                        BufferedReader bf = new BufferedReader(new FileReader("PhoneBook.txt"));

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
                        BufferedReader bf = new BufferedReader(new FileReader("PhoneBook.txt"));

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
                    +  " |  " + phone + " | |  " + notes;
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

                File file = new File("PhoneBook.txt");

                // If file doesn't exists, then create it.
                if (!file.exists()) {
                    file.createNewFile();
                }

                try (PrintWriter output = new PrintWriter(new FileWriter(
                        "PhoneBook.txt", true))) {
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