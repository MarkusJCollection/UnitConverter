import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistanceConverter {

    //Class-wide variables that are private with accessor functions,
    // and deal with a list of available conversions and a key:value
    // system for the conversions themselves.
    public final HashMap<String,Double> conversionMap;
    public final List<String> availableConversions = new ArrayList<>();



    /**
     * Constructor function that initializes the available conversions
     * and conversion map.
     */
    public DistanceConverter(){
        //All units centered around the inch.

        //Reads the TXT file that contains conversions.
        GenFileReader conversions = new GenFileReader();
        this.conversionMap = conversions.conversionsMapDIS;


        this.availableConversions.addAll(this.conversionMap.keySet());

    }


    /**
     * Function that will convert a given distance to
     * another unit.
     * @param amt Dollar amount input
     * @param code1 Currency you're converting from.
     * @param code2 Currency you're converting to.
     */
    public String convert(double amt, String code1,
                        String code2) {
        //Definition of variables used.
        double firstMult;
        double secMult;

        //Try-catch that will tell you if an input
        // is invalid.
        try {
            firstMult = this.conversionMap.get(code1.toLowerCase());
            secMult = this.conversionMap.get(code2.toLowerCase());

            double newamt = ((amt / firstMult) * secMult);
            return String.format("%.2f %s is equal to %.2f %s.",
                    amt,code1.toLowerCase(),newamt,code2.toLowerCase());
        } catch (NullPointerException ex) {
                //Given unit not inside hashmap.
            return "Error, invalid distance unit.";
        }catch(NumberFormatException ex) {
                //Gave a letter instead of number.
            return "Error, starting value must be a number.";
        } catch (Exception ex) {
            //Everything else, will add more specific ones as they are found.
            return "Error, "+ex;
        }
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
        int rowCount = 3;

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
}
