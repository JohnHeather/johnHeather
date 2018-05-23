
import java.util.Scanner;


public class Input {

    //--- scope ---  type ----  name ----\\

    private Scanner scanner;


    // ------------CONSTRUCTOR--------- \\

    public Input() {

        this.scanner = new Scanner(System.in).useDelimiter("\n");
    }



    public String getString() {

        return scanner.nextLine();
    }


    public String getString(String prompt) {
        System.out.println(prompt);
        return getString();

    }





    public boolean yesNo() {
        String answer = scanner.nextLine();  // null
        // auto-boxing => value (string) -> wrap it in a an object -> new String("y").equalsIgnoreCase()
        return "y".equals(answer) || "yes".equalsIgnoreCase(answer);
    }


    // This method is for prompting this user for to continue

    public boolean yesNo(String prompt){
        System.out.println(prompt);
        return yesNo();
    }




    //  This method is for prompting the user for the int

    public int getInt() {
        String input = getString();

        try {
            return Integer.valueOf(input);

        } catch (NumberFormatException e) {
            System.out.println("Must input an integer. ");
            return getInt();
        }
    }


  // this method is for the user input validation for the int

    public int getInt(int min, int max) throws Exception {
        int value = getInt();
        if (value < min || value > max) {
            System.out.printf("Enter a number between %d and %d%n", min, max);
            return getInt(min, max);
        }
        return value;

    }


    ///         This method is for prompting the user for double


    public double getDouble() {
        String input = getString();
        try {
            return Double.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println("Input must be a number.");
            return getDouble();
        }
    }

    //       This method is for validating the user input for double

    public double getDouble(double min, double max) {
        System.out.printf("Enter a number between %f and %f%n", min, max);
        double value = getDouble();
        if (value < min || value > max) {
            return getDouble(min, max);
        }
        return value;
    }



}

