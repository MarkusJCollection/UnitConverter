public class CurrencyConverter {

    private int USD_MULT;
    private int EUR_MULT;
    private int GBP_MULT;
    private int AUD_MULT;
    private int CAD_MULT;
    private int JPY_MULT;
    private String[] availableConversions = {"USD","EUR","CAD",
            "GBP","AUD","JPY"};


    /**
     * Constructor function.
     */
    public CurrencyConverter() {
        //All units centered around the U.S. dollar.

        USD_MULT = 100;
        EUR_MULT = 92;
        GBP_MULT = 79;
        AUD_MULT = 152;
        CAD_MULT = 135;
        JPY_MULT = 15165;

    }

    /**
     * Accessor method for available currency conversions.
     * @return Returns the available units of conversion.
     */
    public String availableConversions(){
        return this.availableConversions();
    }
    private int multiplierFinder(String unitInput){
        switch(unitInput.toUpperCase()){
            case "EUR":
                return EUR_MULT;
            case "GBP":
                return GBP_MULT;
            case "AUD":
                return AUD_MULT;
            case "CAD":
                return CAD_MULT;
            case "JPY":
                return JPY_MULT;
            default:
                return USD_MULT;

        }
    }


    public double Convert(double numInput, String firstUnit,
                             String secondUnit){
        return ((numInput*100)/multiplierFinder(firstUnit)
                *multiplierFinder(secondUnit))/100;
    }

    public double USDto(double numInput, String unit){
        return ((numInput*100)*
                ((USD_MULT)/multiplierFinder(unit)))/100;
    }



}
