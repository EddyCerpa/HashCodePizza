import java.util.ArrayList;

import Parser.ParserIn;
import Parser.ProblemEntry;
import Tipos.Pizza;
import Tipos.Position;
import Tipos.Slice;
import Utils.PizzaUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola!");
		System.out.println("Hola");

		ParserIn parser = new ParserIn();
        ProblemEntry data = parser.parseEntryFile("medium.in");
		System.out.println("Pizza parsed!");
		Pizza pizza = data.getPizza();
		//System.out.println(pizza);
		test(pizza);
	}

	public static void test(Pizza pizza) {
		/*Slice slice = PizzaUtils.cutSliceFromPizza(pizza, new Position(0, 0), new Position(1, 1));
		System.out.println(slice.getSize());
		if(PizzaUtils.isSliceValid(slice, slice.getSize(), 2))
			System.out.println("Es válido");
		else
			System.out.println("No es válido");*/
		
		ArrayList<String> array1 = new ArrayList<String>();
		array1.add("hola");
		array1.add("adios");
		
		for(String s : array1)
			System.out.println(s);
		
		System.out.println("original");
		
		ArrayList<String> array2 = new ArrayList<String>();
		array2.add("test2");
		array2.add("test2");
		
		array1.addAll(array2);
		
		for(String s : array1)
			System.out.println(s);
	}
}