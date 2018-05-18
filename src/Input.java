import java.util.Scanner;

public class Input {


    private Scanner scanner;

    public Input() {

        scanner = new Scanner(System.in);
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
        return "y".equalsIgnoreCase(answer) || "yes".equalsIgnoreCase(answer);
    }

    public boolean yesNo(String prompt){
        System.out.println(prompt);
        return yesNo();
    }


    public int getInt(int min, int max) throws Exception {
        int value = getInt();
        if (value < min || value > max) {
            System.out.printf("Enter a number between %d and %d%n", min, max);
            return getInt(min, max);
        }
        return value;

    }

    public int getInt() {
        String input = getString();

        try {
            return Integer.valueOf(input);

        } catch (NumberFormatException e) {
            System.out.println("Must input an integer. ");
            return getInt();
        }
    }


    public double getDouble(double min, double max) {
        System.out.printf("Enter a number between %f and %f%n", min, max);
        double value = getDouble();
        if (value < min || value > max) {
            return getDouble(min, max);
        }
        return value;
    }

    public double getDouble() {
        String input = getString();
        try {
            return Double.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println("Input must be a number.");
            return getDouble();
        }
    }


}

