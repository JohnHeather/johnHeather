

import java.io.*;


public class Contacts {
    public static void min(String[] args) {

    }

        private String lastname, firstname, phone,
                notes;

        public contact(String firstname,
                        String phone, String notes,
                        String lastname) {
            this.lastname = lastname;
            this.firstname = firstname;

            this.phone = phone;
            this.notes = notes;
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

//        public void read() {
//
//        }
//
//        static void write() {
//
//            try {
//                Contact contact;
//                contact = new Contact();
//                Contact c = contact;
//
//                File file = new File("PhoneBook.txt");
//
//                // If file doesn't exists, then create it.
//                if (!file.exists()) {
//                    file.createNewFile();
//                }
//
//                try (PrintWriter output = new PrintWriter(new FileWriter(
//                        "PhoneBook.txt", true))) {
//                    output.printf("%s\r\n", c);
//                } catch (Exception e) {
//                }
//
//                System.out.println("Your contact has been saved.");
//            }
//
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void listSearch() {
//
//        }
    }
}