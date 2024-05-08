import java.util.Scanner;

public class UserInput {
    //Java class that contains many user-input related functions.


        //Global scanner function.
    public Scanner sc = new Scanner(System.in);

        //Initialization of variables used.
    public String[] userChoice = {null, null, null};
    private final String[] converterList = {"Currency Converter",
            "Distance Converter", "Weight Converter"};



    /**
     * Function that will ask for a number.
     * @return Returns the scanned entry line.
     */
    public String askNum(){
        System.out.println("Please enter the value you'd like to convert.");
        return sc.nextLine();
    }
    /**
     * Function that will ask for a starting unit.
     * @return Returns the scanned entry line.
     */
    public String askFROMConversion(){
        System.out.println("Please enter the starting unit.");
        return sc.nextLine();
    }
    /**
     * Function that will ask for an ending unit.
     * @return Returns the scanned entry line.
     */
    public String askTOConversion(){
        System.out.println("Please enter your desired ending unit.");
        return sc.nextLine();
    }


    /**
     * Function that will ask which converter the user
     * would like to use.
     * @return Returns an valid int value.
     */
    public int askWhich(){
            //Number of options initialized as 0.
        int numOfOptions = 0;
        while(true) {
                //While true function used to give the user a second
                // chance if their first input was invalid.

                //Prints out list of available conversions from the
                // class' array.
            System.out.println("Which converter would you like to use?");
            for (int i = 0; i < this.converterList.length; i++) {
                System.out.printf("%d: %s\n", i + 1, this.converterList[i]);
                numOfOptions = i + 1;
            }

                //Try-catch that looks for invalid inputs and will
                // give an error while allowing the user to try again.
            try {
                int optionPicked = Integer.parseInt(sc.nextLine());

                    //If-else seeing if the option is valid.
                if (optionPicked <= numOfOptions && optionPicked > 0) {
                    return optionPicked;
                } else {
                    System.out.printf("Invalid choice, must be 1-%d.\n", numOfOptions);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid choice, must be a number.");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }


    /**
     * Function combining the three asks into one, and
     * inputting them into the userChoice array.
     */
    public void askUser(){
        this.userChoice[0] = askNum();
        this.userChoice[1] = askFROMConversion();
        this.userChoice[2] = askTOConversion();
    }


    /**
     * Unnecessary constructor function that may have future use.
     */
    public UserInput(){
    }


    /**
     * Allows for override testing, mainly for testing converters.
     * @param num Test number choice.
     * @param c1 Test first unit choice.
     * @param c2 Test second unit choice.
     */
    public UserInput(String num, String c1, String c2){
        this.userChoice[0] = num;
        this.userChoice[1] = c1;
        this.userChoice[2] = c2;
    }
}