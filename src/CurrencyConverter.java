import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {

    private List<String> availableConversions = new ArrayList<>();
    private Map<String,Double> conversionMap;


    /**
     * Constructor function.
     */
    public CurrencyConverter() {
        //All units centered around the Euro.

            //Reads the ECB CSV file that contains
            // up-to-date exchange rates. Euro added
            // manually.
        ECBReader conversions = new ECBReader();
        this.conversionMap = conversions.conversionsMap;
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
    public void convert(Double amt, String code1,
                        String code2) {
            //Definition of variables used.
        Double firstMult;
        Double secMult;
        amt = amt*100;

            //Try-catch that will tell you if an input
            // is invalid, nested in a while loop to
            // allow the user to retry.
        while(true) {
            try {
                firstMult = this.conversionMap.get(code1) * 100;
                secMult = this.conversionMap.get(code2) * 100;
                amt = ((amt / firstMult) * secMult) / 100;
                System.out.printf("%.2f", amt);
                break;
            } catch (NullPointerException ex) {
                System.out.println("Invalid currency code.");
            } catch (Exception ex) {
                System.out.println("uh oh, add this to the exception list");
                System.out.println(ex);
            }
        }
    }











}