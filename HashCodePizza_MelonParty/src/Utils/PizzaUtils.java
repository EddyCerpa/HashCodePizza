package Utils;

import Tipos.Pizza;
import Tipos.Position;
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
}
