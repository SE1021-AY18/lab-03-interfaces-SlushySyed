import java.text.DecimalFormat;

/**
 * Nut
 * @author Syed Faiz
 * @version 1.0
 */
public class Nut implements Part {
    private DecimalFormat costFormat = new DecimalFormat("$0.00");
    private DecimalFormat weightFormat = new DecimalFormat("0.###");
    private double diameterInches;
    /**
     * Determines the weight of each part
     */
    public static final double LBS_MULTIPLIER = 0.01;
    /**
     * Determines the cost of each part
     */
    public static final double USD_MULTIPLIER = 0.5;

    /**
     * Default contructor
     * @param diameterInches diameter of the bolt
     */
    public Nut(double diameterInches){
        this.diameterInches = diameterInches;
    }

    /**
     * Returns the cost
     * @return cost of the nut
     */
    public double getCost(){
        return USD_MULTIPLIER * diameterInches;
    }

    /**
     * Returns the name
     * @return name of the nut
     */
    public String getName(){
        return diameterInches + " inch nut";
    }

    /**
     * Returns the weight
     * @return weight of the nut
     */
    public double getWeight(){
        return LBS_MULTIPLIER * (diameterInches * diameterInches);
    }

    /**
     * Prints off the formatted output of the nut
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Diameter: " + diameterInches + " inches");
        System.out.println("Cost: " + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();
    }
}