package Tipos;

/**
 * Created by aloarte on 18/02/17.
 *
 *
 */
public class Pizza {

    public enum Ingredient
    {
        MUSHROOM, TOMATOE
    }


    public Ingredient[][] getIncludedIngredients() {
        return includedIngredients;
    }

    public void setIncludedIngredients(Ingredient[][] includedIngredients) {
        this.includedIngredients = includedIngredients;
    }

    public boolean[][] getSlicesTaken() {
        return slicesTaken;
    }

    public void setSlicesTaken(boolean[][] slicesTaken) {
        this.slicesTaken = slicesTaken;
    }

    public int getPizzaRows() {
        return pizzaRows;
    }

    public void setPizzaRows(int pizzaRows) {
        this.pizzaRows = pizzaRows;
    }

    public int getPizzaColumns() {
        return pizzaColumns;
    }

    public void setPizzaColumns(int pizzaColumns) {
        this.pizzaColumns = pizzaColumns;
    }

    public int getCurrentTomatoes() {
        return currentTomatoes;
    }

    public void setCurrentTomatoes(int currentTomatoes) {
        this.currentTomatoes = currentTomatoes;
    }

    public int getCurrentMushrooms() {
        return currentMushrooms;
    }

    public void setCurrentMushrooms(int currentMushrooms) {
        this.currentMushrooms = currentMushrooms;
    }

    private Ingredient [][]     includedIngredients;
    private boolean[][]         slicesTaken;

    /* Pizza size */
    private int                 pizzaRows;
    private int                 pizzaColumns;

    /* Num current ingredients */
    private int                 currentTomatoes;
    private int                 currentMushrooms;

    public int getTotalTomatoes() {
        return totalTomatoes;
    }

    public void setTotalTomatoes(int totalTomatoes) {
        this.totalTomatoes = totalTomatoes;
    }

    public int getTotalMushrooms() {
        return totalMushrooms;
    }

    public void setTotalMushrooms(int totalMushrooms) {
        this.totalMushrooms = totalMushrooms;
    }

    /* Num total  */
    private int                 totalTomatoes;
    private int                 totalMushrooms;


    public Pizza(int tomatoes ,int mushrooms, int row,int column, Ingredient[][] ingredients){
        this.pizzaRows=row;
        this.pizzaColumns=column;
        this.currentTomatoes=tomatoes;
        this.currentMushrooms=mushrooms;
        this.totalTomatoes=tomatoes;
        this.totalMushrooms=mushrooms;
        if(ingredients!=null){
            this.includedIngredients=ingredients;
        }

        /*Inicializa el array*/
        slicesTaken = new boolean[row][column];
    }



}
