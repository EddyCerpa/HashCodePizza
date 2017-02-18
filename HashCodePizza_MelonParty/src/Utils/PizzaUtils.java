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
}
