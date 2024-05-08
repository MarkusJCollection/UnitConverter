import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class CurrencyConverter {

    //Class-wide variables that are private with accessor functions,
    // and deal with a list of available conversions and a key:value
    // system for the conversions themselves.
    private final List<String> availableConversions = new ArrayList<>();
    private final HashMap<String,Double> conversionMap;



    /**
     * Constructor function that initializes the available conversions
     * and conversion map.
     */
    public CurrencyConverter() {
        //All units centered around the Euro.

            //Reads the ECB CSV file that contains
            // up-to-date exchange rates. Euro added
            // manually.
        GenFileReader conversions = new GenFileReader();
        this.conversionMap = conversions.conversionsMapCUR;
        this.conversionMap.put("EUR",1.0);

        this.availableConversions.addAll(this.conversionMap.keySet());


        //????? Look into later to understand what this is, completely unnecessary.
        //this.conversionMap.forEach((key, value) -> {
        //    this.availableConversions.add(key);
        //});
    }


    /**
     * Accessor function that prints a table of available conversions.
     */
    public void availableConversions(){
            //Definition of variables used.
        String output = "";
        int counter = 1;

            //Row count defined as a variable for easily
            // deciding how many rows should be displayed.
        int rowCount = 8;

            //Foreach loop going through every entry of
            // available conversions.
        for(String entry : this.availableConversions){
                //Each run the entry is added to the output.
            output+= entry+"\t\t";
                //Counter to keep track of how many items
                // have been added to a row.
            if(counter == rowCount){
                output += "\n";
                counter = 0;
            }
            counter++;
        }
        System.out.println(output);
    }


    /**
     * Function that will convert a given dollar amount
     * from one currency to another.
     * @param amt Dollar amount input
     * @param code1 Currency you're converting from.
     * @param code2 Currency you're converting to.
     */
    public String convert(double amt, String code1,
                        String code2) {
            //Definition of variables used.
        double firstMult;
        double secMult;
        amt = amt*100;


        //Try-catch that will tell you if an input
        // is invalid.
        try {
            firstMult = this.conversionMap.get(code1.toUpperCase()) * 100;
            secMult = this.conversionMap.get(code2.toUpperCase()) * 100;
            double newamt = ((amt / firstMult) * secMult) / 100;
            return String.format("%.2f %s is equal to %.2f %s.",
                    amt/100,code1.toUpperCase(),newamt,code2.toUpperCase());
        } catch (NullPointerException ex) {
                //Currency code not listen in hashmap.
            return "Error, invalid currency code.";
        }catch(NumberFormatException ex) {
                //Inputting a letter instead of number.
            return "Error, starting value must be a number.";
        } catch (Exception ex) {
                //Everything else, will add more specific ones as they are found.
            return "Error, "+ex;
        }
    }
}