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
        //All units centered around the U.S. dollar.
        ECBReader conversions = new ECBReader();
        this.conversionMap = conversions.conversionsMap;
        conversionMap.forEach((key, value) ->{
            this.availableConversions.add(key);
        });
    }

    /**
     * Accessor method for available currency conversions.
     * @return Returns the available units of conversion.
     */
    public void availableConversions(){
        System.out.println(this.availableConversions);
    }






}