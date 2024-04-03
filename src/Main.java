import java.util.Scanner;
public class Main {
/*
    There are 3 types of conversion the company needs to plan:
    1. Distances - km,mi,etc
    2. Weights - kg,lb,etc
    3. Currency - USD,EUR,etc

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

//Global scanner function.
    static Scanner scan = new Scanner(System.in);




//Main program
    public static void main(String[] args) {
        CurrencyConverter currencyConverter = new CurrencyConverter();

        double output = currencyConverter.Convert(2,"USD","EUR");
        System.out.println(output);


    }










}