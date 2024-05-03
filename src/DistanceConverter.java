import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistanceConverter {

    HashMap<String,Double> conversionMap;
    List<String> availableConversions = new ArrayList<>();


    public DistanceConverter(){
        //All units centered around the inch.

        //Reads the TXT file that contains conversions.
        GenFileReader conversions = new GenFileReader();
        this.conversionMap = conversions.conversionsMapDIS;

        //Foreach loop adding each key entry to a list.
        for(String key : this.conversionMap.keySet()){
            this.availableConversions.add(key);
        }

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
            firstMult = this.conversionMap.get(code1);
            secMult = this.conversionMap.get(code2);

            amt = ((amt / firstMult) * secMult);
            return String.format("%.2f", amt);
        } catch (NullPointerException ex) {
            return "Invalid distance unit.";
        } catch (Exception ex) {
            System.out.println("uh oh, add this to the exception list");
            return ex.toString();
        }
    }




    public void availableConversions(){
        //Definition of variables used.
        String output = "";
        int counter = 1;

        //Row count defined as a variable for easily
        // deciding how many rows should be displaed.
        int rowCount = 4;

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
