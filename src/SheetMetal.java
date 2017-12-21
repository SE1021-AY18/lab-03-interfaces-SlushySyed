import java.text.DecimalFormat;

/**
 * Sheet Metal Object
 * @author Syed Faiz
 * @version 1.0
 */
public class SheetMetal implements Part {

    private DecimalFormat costFormat = new DecimalFormat("$0.00");
    private DecimalFormat weightFormat = new DecimalFormat("0.###");
    /**
     * Determines how much each will weigh
     */
    public static final double LBS_MULTIPLIER = 0.1;
    /**
     * Determines the cost of each
     */
    public static final double USD_MULTIPLIER = 0.5;
    private double thicknessInches;
    private double lengthInches;
    private double widthInches;

    /**
     * Default Constructor
     * @param lengthInches Length
     * @param widthInches Width
     * @param thicknessInches Height
     */
    public SheetMetal(double lengthInches, double widthInches, double thicknessInches){
        this.thicknessInches = thicknessInches;
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
    }

    /**
     * Returns the cost
     * @return cost of the sheet
     */
    public double getCost(){
        return USD_MULTIPLIER * thicknessInches * lengthInches * widthInches;
    }

    /**
     * Returns the name
     * @return name of the sheet
     */
    public String getName(){
        return lengthInches + "x" + widthInches + "x" + thicknessInches + " sheet";
    }

    /**
     * Returns the weight
     * @return weight of the sheet
     */
    public double getWeight(){
        return LBS_MULTIPLIER * thicknessInches * lengthInches * widthInches;
    }

    /**
     * Prints the formatted output for the sheet
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Length: " + lengthInches + " inches");
        System.out.println("Width: " + widthInches + " inches");
        System.out.println("Thickness " + thicknessInches + " inches");
        System.out.println("Cost: " + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();
    }
}