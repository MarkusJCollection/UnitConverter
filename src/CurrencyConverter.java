public class CurrencyConverter {
    String[] availableConversions = {"USD","EUR","CAD","GBP",
                                        "AUD","JPY"};

    //All units centered around the U.S. dollar.
    int USD_MULT = 100;
    int EUR_MULT = 92;
    int GBP_MULT = 79;
    int AUD_MULT = 152;
    int CAD_MULT = 135;
    int JPY_MULT = 15165;

    private int multiplierFinder(String unitInput){
        switch(unitInput){
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
        double conversionOutput = ((numInput*100)/multiplierFinder(firstUnit)
                *multiplierFinder(secondUnit))/100;
        return conversionOutput;






    }
}
