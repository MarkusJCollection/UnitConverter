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
            // up-to-date exchange rates.
        ECBReader conversions = new ECBReader();
        this.conversionMap = conversions.conversionsMap;
        this.conversionMap.put(" EUR",1.0);
        conversionMap.forEach((key, value) ->{
            this.availableConversions.add(key);
        });
    }

    /**
     * Prints out a formatted list of available conversions.
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


    public void convert(Double amt, String code1,
                        String code2) {
        Double newNum;
        Double firstMult;
        Double secMult;

        amt = amt*100;

        firstMult = this.conversionMap.get(code1)*100;
        secMult = this.conversionMap.get(code2)*100;

        amt = ((amt/firstMult)*secMult)/100;
        System.out.println(amt);




    }











}