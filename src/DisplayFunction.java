import java.util.Scanner;

public class DisplayFunction {
    // Global scanner object
    private Scanner scanner = new Scanner(System.in);

    // Method to display available functions
    public void displayAvailableFunctions() {
        System.out.println("Available functions:");
        System.out.println("1. Currency Converter");
        System.out.println("2. Weight Converter");
        System.out.println("3. Distance Converter");
        System.out.println("4. Exit");
    }

    // Method to ask user for their choice
    public int askUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    // Method to display selected function based on user choice
    public void displayFunction(int choice) {
        switch (choice) {
            case 1:
                CurrencyConverter currencyConverter = new CurrencyConverter();
                System.out.println("Currency Converter selected.");
                // Add your currency conversion logic here
                break;
            case 2:
                WeightConverter weightConverter = new WeightConverter();
                System.out.println("Weight Converter selected.");
                // Add your weight conversion logic here
                break;
            case 3:
                DistanceConverter distanceConverter = new DistanceConverter();
                System.out.println("Distance Converter selected.");
                // Add your distance conversion logic here
                break;
            case 4:
                System.out.println("Exiting program...");
                System.exit(0); // Terminate program
                break;
            default:
                System.out.println("Invalid choice! Please enter a number between 1 and 4.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        DisplayFunction displayFunction = new DisplayFunction();
        while (true) {
            displayFunction.displayAvailableFunctions();
            int choice = displayFunction.askUserChoice();
            displayFunction.displayFunction(choice);
        }
    }
}

