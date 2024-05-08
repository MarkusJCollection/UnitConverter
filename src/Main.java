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
    static UserInput input = new UserInput();


    /*

     */
    public static String ask(){
        String output;
        switch(input.askWhich()){
            case 1:
                while(true){
                    currencyConverter.availableConversions();
                    input.askUser();
                    try{
                        output = currencyConverter.convert(Double.parseDouble(input.userChoice[0])
                                ,input.userChoice[1],input.userChoice[2]);
                    }catch(NumberFormatException ex){
                        output = "Error, starting value must be a number.";
                    }catch(Exception ex){
                        output = "Error, "+ex;
                    }

                    if(output.contains("Error")){
                        System.out.println(output+"\n");
                    }else{
                        return output;
                    }
                }
          case 2:
              while(true){
                  distanceConverter.availableConversions();
                  input.askUser();
                  try{
                      output = distanceConverter.convert(Double.parseDouble(input.userChoice[0])
                              ,input.userChoice[1],input.userChoice[2]);
                  }catch(NumberFormatException ex){
                      output = "Error, starting value must be a number.";
                  }catch(Exception ex){
                      output = "Error, "+ex;
                  }

                  if(output.contains("Error")){
                      System.out.println(output+"\n");
                  }else{
                      return output;
                  }
              }
            case 3:
                return "Not implemented.";
            default:
                System.out.println("Error.");
        }
        return null;
    }




//Main program
    public static void main(String[] args) {
        System.out.println(ask());
    }
}