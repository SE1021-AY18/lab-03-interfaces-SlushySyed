import java.text.DecimalFormat;

/**
 * Bolt Parts
 * @author Syed Faiz
 * @version 1.0
 */
public class Bolt implements Part{

    private DecimalFormat costFormat = new DecimalFormat("$0.00");
    private DecimalFormat weightFormat = new DecimalFormat("0.###");
    /**
     * How many pounds the bolt weighs?
     */
    public static final double LBS_MULTIPLIER = 0.05;
    /**
     * How the price should be calculated?
     */
    public static final double USD_MULTIPLIER = 1.00;
    private double diameterInches;
    private double lengthInches;

    /**
     * Default constructor
     * @param diameterInches Diameter of the bolt
     * @param lengthInches Length of the bolt
     */
    public Bolt(double diameterInches, double lengthInches){
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }

    /**
     * Returns the cost of the bolt
     * @return cost of the bolt
     */
    public double getCost(){
        return USD_MULTIPLIER * diameterInches * lengthInches;
    }

    /**
     * Returns the name of the bolt
     * @return name of the bolt
     */
    public String getName(){
        return diameterInches + "x" + lengthInches + " bolt";
    }

    /**
     * Returns the weight of the bolt
     * @return weight of the bolt
     */
    public double getWeight(){
        return LBS_MULTIPLIER * (diameterInches * diameterInches) * lengthInches;
    }

    /**
     * Prints the formatted output for a bolt and its belongings
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Diameter: " + diameterInches + " inches");
        System.out.println("Length: " + lengthInches + " inches");
        System.out.println("Cost: " + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();
    }
}