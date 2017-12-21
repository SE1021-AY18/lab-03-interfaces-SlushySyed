/*
* SE1021
* Winter 2017
* FIle purpose: Work with
* Name: Syed Faiz
*Created: 12/18/17
*/
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Creates assemblies of one or more parts
 * @author Syed Faiz
 * @version 1.0
 */
public class Assembly implements Part {

    /**
     * The fee that is applied for each additional part
     */
    public static final double USD_PER_SUB_PART = 0.25;
    private final DecimalFormat weightFormat = new DecimalFormat("0.###");
    private final DecimalFormat costFormat = new DecimalFormat("$0.00");
    private ArrayList<Part> subParts = new ArrayList();
    private String name;

    /**
     * Default Constructor
     * @param name Name of the assembly
     */
    public Assembly(String name){
        this.name = name;
    }

    /**
     * Adds a new Part object to the ArrayList
     * @param part New part being added
     */
    public void addPart(Part part){
        subParts.add(part);
    }

    /**
     * Returns the name of an assembly
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the cost, for each part in an assembly there is an additional
     * $0.25 fee for each part
     * @return cost
     */
    public double getCost(){
        double cost = subParts.size() * USD_PER_SUB_PART;  //Adds the fee for number of parts
        for(Part part : subParts){
            cost += part.getCost();  //Adds on every cost for each part of the assembly
        }
        return cost;
    }

    /**
     * Returns the weight of an assembly
     * @return weight
     */
    public double getWeight(){
        double weight = 0;
        for(Part part : subParts){
            weight += part.getWeight();
        }
        return weight;
    }

    /**
     * Prints off a formatted version of the assembly
     */
    public void printBillOfMaterials(){
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");

        for(Part part : subParts){
            System.out.println("Part: " + part.getName());
            System.out.println("Cost: " + costFormat.format(part.getCost()));
            System.out.println("Weight: " + weightFormat.format(part.getWeight()) + " lbs");
            System.out.println();
        }

        System.out.println("Total cost: " + costFormat.format(getCost()));
        System.out.println("Total weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();

        for(Part part : subParts){
            part.printBillOfMaterials();
        }
    }
}