package Parser;

import Tipos.Pizza;

/**
 * Created by Capa on 18/2/17.
 */
public class ProblemEntry {
    /**
     * Maximum number of slice size
     */
    public static int H;
    /**
     * Minimum number of T and M in a slice
     */
    public static int L;
    public Pizza pizza;

    public ProblemEntry(Pizza pizza) {
        this.pizza = pizza;
    }
    
    public Pizza getPizza() {
    	return this.pizza;
    }
}
