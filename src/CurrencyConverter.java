import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {

    private final List<String> availableConversions = new ArrayList<>();
    private Map<String,Double> conversionMap;


    /**
     * Constructor function.
     */
    public CurrencyConverter() {
        //All units centered around the Euro.

            //Reads the ECB CSV file that contains
            // up-to-date exchange rates. Euro added
            // manually.
        GenFileReader conversions = new GenFileReader();
        this.conversionMap = conversions.conversionsMapCUR;
        this.conversionMap.put("EUR",1.0);

            //Foreach loop adding each key entry to a list.
        for(String key : this.conversionMap.keySet()){
            this.availableConversions.add(key);
        }

        //????? Look into later to understand what this is
        //this.conversionMap.forEach((key, value) -> {
        //    this.availableConversions.add(key);
        //});
    }


    /**
     * Prints a list of available conversions in a table.
     */
    public void availableConversions(){
            //Definition of variables used.
        String output = "";
        int counter = 1;

            //Row count defined as a variable for easily
            // deciding how many rows should be displaed.
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
            amt = ((amt / firstMult) * secMult) / 100;
            return String.format("%.2f", amt);
        } catch (NullPointerException ex) {
            System.out.println("Invalid currency code.");
            return null;
        } catch (Exception ex) {
            System.out.println("uh oh, add this to the exception list");
            System.out.println(ex);
            return null;
        }
    }











}