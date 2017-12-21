import java.text.DecimalFormat;

/**
 * Duplicates an objects
 * @author Syed Faiz
 * @version 1.0
 */
public class Duplicate implements Part {

    private final DecimalFormat weightFormat = new DecimalFormat("0.###");
    private final DecimalFormat costFormat = new DecimalFormat("$0.00");
    /**
     * Reduction factor for five or more parts
     */
    public static final double REDUCTION_FACTOR1 = 0.95;
    /**
     * Reduction factor for ten or more parts
     */
    public static final double REDUCTION_FACTOR2 = 0.9;
    /**
     * Threshold for first price reduction
     */
    public static final int USD_THRESHOLD1 = 5;
    /**
     * Threshold for second price reduction
     */
    public static final int USD_THRESHOLD2 = 10;
    private Part identicalPart;
    private int numDuplicates;

    /**
     * Default contructor
     * @param identicalPart The part being duplicated
     * @param numDuplicates The number of duplicates
     */
    public Duplicate(Part identicalPart, int numDuplicates){
        this.identicalPart = identicalPart;
        this.numDuplicates = numDuplicates;
    }

    /**
     * Returns the cost of the duplicate
     * @return cost price of the duplicate
     */
    public double getCost(){
        if(numDuplicates < USD_THRESHOLD1){
            return identicalPart.getCost() * numDuplicates;
        }else if(numDuplicates < USD_THRESHOLD2){
            return identicalPart.getCost() * REDUCTION_FACTOR1 * numDuplicates;
        }else{
            return identicalPart.getCost() * REDUCTION_FACTOR2 * numDuplicates;
        }
    }

    /**
     * Returns the formatted name of the duplicate
     * @return name formatted correctly
     */
    public String getName(){
        return numDuplicates + " " + identicalPart.getName() + "s";
    }

    /**
     * Returns the weight of the duplicates
     * @return weight of all parts
     */
    public double getWeight(){
        return identicalPart.getWeight() * numDuplicates;
    }

    /**
     * Prints off the formatted prompt for assemblies of
     * duplicate parts
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Duplicate part: " + identicalPart.getName());
        System.out.println("Copies: " + numDuplicates);
        System.out.println("Individual Cost: " + costFormat.format(identicalPart.getCost()));
        System.out.println("Individual Weight: " +
                weightFormat.format(identicalPart.getWeight()) + " lbs");
        System.out.println();
        System.out.println("Total cost: " + costFormat.format(getCost()));
        System.out.println("Total weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();
        identicalPart.printBillOfMaterials();
    }
}