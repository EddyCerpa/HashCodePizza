package Utils;

import Tipos.Pizza;
import Tipos.Position;
import Tipos.Slice;
import Tipos.dataNode.StatusNode;

/**
 * Created by aloarte on 18/02/17.
 *
 */
public class PizzaUtils {
	
	/**
	 * return first free position in a pizza
	 * @param node
	 * @return
	 */
	public static Position getFirstCorrectPosition(StatusNode node) {
		if(!node.isPizzaAlreadySliced()) {
			Pizza pizza = node.getCurrentPizza();
			for(int i = 0; i < pizza.getPizzaRows(); i++)
				for(int j = 0; j < pizza.getPizzaColumns(); j++)
					if(!pizza.getSlicesTaken()[i][j])
						return new Position(i, j);
		}
		return new Position(-1, -1);
	}


    /**
     * Returns if the slice is valid checking the size of the slice and if the min number of ingredients is correct
     *
     * @param slice             Slice
      * @param sliceSize        Max size of the slice ( H value )
     * @param minIngredients    Min number of each ingredient ( L value )
     * @return
     */
    public static boolean isSliceValid(Slice slice, int sliceSize, int minIngredients){

        /**
         * Check if the size is less equals than the max size
         */

        return (
                /**
                 * Check the size of the slice
                 */
                (slice.getSize()<=sliceSize)

                    &&
                /**
                 * Check the ingredients
                 */
                ((slice.getMushroom()>= minIngredients) && (slice.getMushroom()>= minIngredients)));

    }
    
    /**
     * Cut a slice from a pizza with a init and start position.
     * @param pizza Pizza to cut.
     * @param ini Initial position.
     * @param end End position.
     * @return
     */
    public static Slice cutSliceFromPizza(Pizza pizza, Position ini, Position end) {
    	// If is not into the bounds return a null object.
    	if(!checkOutOfBounds(pizza.getPizzaRows(), pizza.getPizzaColumns(), ini, end))
    		return null;
    	int m = 0, t = 0;
    	for(int i = ini.getRow(); i <= end.getRow(); i++) {
    		for(int j = ini.getColumn(); j <= end.getColumn(); j++) {
    			// If the slice is already cut return a null object.
    			if(pizza.getSlicesTaken()[i][j])
    				return null;
    			if(pizza.getIncludedIngredients()[i][j] == Pizza.Ingredient.MUSHROOM)
    				m++;
    			else if(pizza.getIncludedIngredients()[i][j] == Pizza.Ingredient.TOMATOE)
    				t++;
    		}
    	}
    	return new Slice(ini, end, t, m);
    }
    
    /**
     *
     * @param sliceIni Initial slice position.
     * @param sliceEnd Final slice position.
     * @return True if is not out of bounds, false if is out of bounds. 
     */
    public static boolean checkOutOfBounds(int pizzaRows, int pizzaCols, Position sliceIni, Position sliceEnd) {
    	return 0 <= sliceIni.getRow() && 0 <= sliceIni.getColumn() &&
    		   pizzaRows >= sliceEnd.getRow() && pizzaCols >= sliceEnd.getColumn();
    }

    /**
     * Return the pizza object obtained by params with the positions marked as "cutted" that the slice has
     *
     * @param uncuttedPizza A pizza without the positions marked
     * @param cuttedSlice   A slice from the pizza
     * @return              The param pizza with the position marked as "cutted"
     */
    public static Pizza getCuttedPizzaFromSlice(Pizza uncuttedPizza, Slice cuttedSlice){
        /**
         * Get initial and end positions
         */
        Position ini = cuttedSlice.getPositionIni();
        Position end = cuttedSlice.getPositionEnd();
        /**
         * Clone the uncutted pizza to handle a new one
         */
        Pizza retPizza = uncuttedPizza.clone();
        /**
         * Iterate from the slice positions those positions in the pizza
         */
        for(int i = ini.getRow(); i <= end.getRow(); i++) {
            for(int j = ini.getColumn(); j <= end.getColumn(); j++) {
                /**
                 * Mark value as taken
                 */
                retPizza.getSlicesTaken()[i][j] = true;
                /**
                 * Decrease ingredient from pizza
                 */
                retPizza.decreaseIngredient(uncuttedPizza.getIncludedIngredients()[i][j]);

                }
            }

        return retPizza;
    }
}
