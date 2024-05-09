import java.util.Scanner;
public class Main {
/*
    There are 3 types of conversion the company needs to plan:
    1. Distances - km,mi,etc.        CENTERED AROUND METER
    2. Weights - kg,lb,etc.          CENTERED AROUND ????
    3. Currency - USD,EUR,etc.       CENTERED AROUND EURO

    We need an app which asks what conversion needs
    to be made from the above 3 choices.

    Asks for the first value & measurement to be converted
    (i.e. 12 lbs. or 1200 YEN) then
    provides a list of choices based on that to convert to
    (if just one option – this step can be skipped)
    and performs and outputs the conversion value.

    It would then ask if the user wants a new conversion and
    restart at the beginning if they state yes (close if not).
 */

//Global functions.
    static Scanner scan = new Scanner(System.in);
    static CurrencyConverter currencyConverter = new CurrencyConverter();
    static DistanceConverter distanceConverter = new DistanceConverter();
    static WeightConverter weightConverter = new WeightConverter();
    static UserInput input = new UserInput();
    static DisplayFunction displayFunc = new DisplayFunction();


    /**
     * Function used to ask what conversion the user would like,
     * and allows inputs.
     * @return Returns the output of their conversion.
     */
    public static String askConvert(){
            //Initialization of an output variable.
        String output;
            //Switch statement based on the different cases of integers,
            // which tie directly to number of conversion programs
            // implemented.
        displayFunc.displayAvailableFunctions();
        int choice = displayFunc.askUserChoice();
        displayFunc.displayFunction(choice);
        switch(choice){
            case 1:
                //Currency Converter
                while(true){
                        //Lists the table of available currency conversions.
                    currencyConverter.availableConversions();
                        //Function to ask user what they'd like to input.
                    input.askUser();

                        //Try-catch that checks mainly the starting value to see
                        // whether it is valid.
                    try{
                        output = currencyConverter.convert(Double.parseDouble(input.userChoice[0])
                                ,input.userChoice[1],input.userChoice[2]);
                    }catch(NumberFormatException ex){
                        output = "Error, starting value must be a number.";
                    }catch(Exception ex){
                        output = "Error, "+ex;
                    }

                        //If the output contains the phrase error
                        // then the error is printed and allows
                        // the user to retry their conversion.
                    if(output.contains("Error")){
                            //All catches for invalid inputs contain in some way 'Error'.
                        System.out.println(output+"\n");
                    }else{
                            //If no error is found then the while loop
                            // is exited and the output is returned.
                        return output;
                    }
                }
          case 3:
              //Distance Converter.
              while(true){
                    //Lists the table of available currency conversions.
                  distanceConverter.availableConversions();

                    //Function to ask user what they'd like to input.
                  input.askUser();

                      //Try-catch that checks mainly the starting value to see
                      // whether it is valid.
                  try{
                      output = distanceConverter.convert(Double.parseDouble(input.userChoice[0])
                              ,input.userChoice[1],input.userChoice[2]);
                  }catch(NumberFormatException ex){
                      output = "Error, starting value must be a number.";
                  }catch(Exception ex){
                      output = "Error, "+ex;
                  }

                      //If the output contains the phrase error
                      // then the error is printed and allows
                      // the user to retry their conversion.
                  if(output.contains("Error")){
                        //All catches for invalid inputs contain in some way 'Error'.
                      System.out.println(output+"\n");
                  }else{
                        //If no error is found then the while loop
                        // is exited and the output is returned.
                      return output;
                  }
              }
            case 2:
                //Weight Converter.
                while(true){
                        //Lists the table of available currency conversions.
                    System.out.println("""
                            kg      pounds""");
                        //Function to ask user what they'd like to input.
                    input.askUser();
                        //Try-catch that checks mainly the starting value to see
                        // whether it is valid.
                    try{
                        output = String.format("%s %s is equal to %.2f %s",input.userChoice[0],
                                input.userChoice[1],weightConverter.convert(Double.parseDouble(input.userChoice[0])
                                ,input.userChoice[1],input.userChoice[2]),input.userChoice[2]);
                    }catch(NumberFormatException ex){
                        output = "Error, starting value must be a number.";
                    }catch(Exception ex){
                        output = "Error, "+ex;
                    }

                    //If the output contains the phrase error
                    // then the error is printed and allows
                    // the user to retry their conversion.
                    if(output.contains("Error")){
                        //All catches for invalid inputs contain in some way 'Error'.
                        System.out.println(output+"\n");
                    }else{
                        //If no error is found then the while loop
                        // is exited and the output is returned.
                        return output;
                    }
                }
            default:
                //Other options, shouldn't be reached since the
                // user input itself has a check to see if the value
                // is valid.
                System.out.println("Error.");
        }
        return null;
    }


    /**
     * Function called to ask if a user would like to continue.
     * @return Returns a boolean value for use in loops, if yes then the return is true.
     */
    public static boolean askContinue(){
        System.out.println("Would you like to continue? (Y/N) ");
        String userIn = scan.nextLine();
        return(userIn.equalsIgnoreCase("y") || userIn.toLowerCase().contains("yes"));
    }


    /**
     * Main function of the program.
     * @param args
     */
    public static void main(String[] args) {
        do{
            System.out.println(askConvert());
        }while(askContinue());
    }
}