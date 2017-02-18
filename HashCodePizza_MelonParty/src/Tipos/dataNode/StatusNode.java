package Tipos.dataNode;

import Tipos.Pizza;
import Tipos.Slice;

/**
 * Created by aloarte on 18/02/17.
 *
 */
public class StatusNode {

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Pizza getCurrentPizza() {
        return currentPizza;
    }

    public void setCurrentPizza(Pizza currentPizza) {
        this.currentPizza = currentPizza;
    }

    public Slice[] getCurrentSlicesCutted() {
        return currentSlicesCutted;
    }

    public void setCurrentSlicesCutted(Slice[] currentSlicesCutted) {
        this.currentSlicesCutted = currentSlicesCutted;
    }

    public boolean isPizzaAlreadySliced() {
        return pizzaAlreadySliced;
    }

    public void setPizzaAlreadySliced(boolean pizzaAlreadySliced) {
        this.pizzaAlreadySliced = pizzaAlreadySliced;
    }

    /**
     * Node number for its identification
     */
    private int nodeNumber;

    /**
     * Current pizza status
     */
    private Pizza currentPizza;

    /**
     * Slices already cutted from the pizza
     */
    private Slice[] currentSlicesCutted;

    /**
     * Boolean flag. True if the pizza dont have any more slices to cut
     */
    private boolean pizzaAlreadySliced;

    /**
     * Constructor
     */
    public StatusNode(int node, Pizza pizza, Slice[] slices){
        this.nodeNumber=node;
        this.currentPizza=pizza;
        this.currentSlicesCutted=slices;
        pizzaAlreadySliced = false;

    }

    /**
     * Check if the node has correct info
     *
     * @return  true if the status is correct
     */
    public boolean isNodeCorrect(){
        int numTomatoesInSlices=0, numMushroomsInSlices=0;
        if(currentPizza != null && currentSlicesCutted != null){
            /*
             * Get the number of ingredients of all slices in this node
             */
            for(int i=0;i<currentSlicesCutted.length;i++){
                numTomatoesInSlices += currentSlicesCutted[i].getTomatoes();
                numMushroomsInSlices += currentSlicesCutted[i].getMushroom();
            }

            return (((numTomatoesInSlices + currentPizza.getCurrentTomatoes())==currentPizza.getTotalTomatoes())
                    && ((numMushroomsInSlices + currentPizza.getCurrentMushrooms())==currentPizza.getTotalMushrooms()));
        }
        else{
            return false;
        }
    }



}