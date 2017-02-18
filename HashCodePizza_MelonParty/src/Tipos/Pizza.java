package Tipos;

/**
 * Created by p4r4d0x on 18/02/17.
 */
public class Pizza {

    public enum Ingredient
    {
        MUSHROOM, TOMATOE
    }


    Ingredient [][]     includedIngredients;
    boolean[][]         slicesTaken;

    /* Pizza size */
    int                 pizzaRows;
    int                 pizzaColumns;

    /* Num ingredients */
    int                 currentTomatoes;
    int                 currentMushrooms;


    public Pizza(int tomatoes ,int mushrooms, int row,int column, Ingredient[][] ingredients){
        this.pizzaRows=row;
        this.pizzaColumns=column;
        this.currentTomatoes=tomatoes;
        this.currentMushrooms=mushrooms;
        if(ingredients!=null){
            this.includedIngredients=ingredients;
        }

        /*Inicializa el array*/
        slicesTaken = new boolean[row][column];
    }



}
