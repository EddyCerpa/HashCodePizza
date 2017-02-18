import Parser.ParserIn;
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
		Pizza pizza = parser.parsePizzaFile("test.in");
		System.out.println("Pizza parsed!");
		System.out.println(pizza);
		test(pizza);
	}

	public static void test(Pizza pizza) {
		Slice slice = new Slice(new Position(0, 0), new Position(1, 2), 3, 0);
		if(PizzaUtils.isSliceValid(slice, slice.getSize(), 2))
			System.out.println("Es válido");
		else
			System.out.println("No es válido");
	}
}
