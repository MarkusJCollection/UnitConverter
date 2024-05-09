public class WeightConverter {
    // Define conversion multipliers for different weight units
    private int KG_MULT = 1;
    private int POUNDS_MULT = 2;

    // Constructor initializes conversion multipliers
    public WeightConverter() {
        // Set multipliers based on a common weight unit (kilograms)
        KG_MULT = 1;
        POUNDS_MULT = 2; // For example, 1 kilogram = 2 pounds
    }

    // Method to convert weight from one unit to another
    public double convert(double numInput, String firstUnit, String secondUnit) {
        int multiplier = getMultiplier(firstUnit);
        double convertedValue = (numInput * multiplier) / getMultiplier(secondUnit);
        return Math.round(convertedValue * 100.0) / 100.0; // Round to 2 decimal places
    }

    // Method to get the multiplier for a given unit
    private int getMultiplier(String unit) {
        switch (unit.toUpperCase()) {
            case "KG":
                return KG_MULT;
            case "POUNDS":
                return POUNDS_MULT;
            default:
                System.out.println("Unsupported weight unit: " + unit);
                return 1; // Return 1 as default multiplier
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        WeightConverter converter = new WeightConverter();
        double result = converter.convert(10, "kg", "pounds");
        System.out.println("Result: " + result);
    }
}