/**
 * Interface for creating parts
 * @author Syed Faiz
 * @version 1.0
 */
public interface Part {
    /**
     * Gets the cost
     * @return cost
     */
    double getCost();

    /**
     * Gets the name
     * @return name
     */
    String getName();

    /**
     * Gets the weight
     * @return weight
     */
    double getWeight();

    /**
     * Prints off the facts of the part cost and weight
     */
    void printBillOfMaterials();
}