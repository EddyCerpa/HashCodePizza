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
        ProblemEntry data = parser.parseEntryFile("test.in");
		System.out.println("Pizza parsed!");
		Pizza pizza = data.getPizza();
		System.out.println(pizza);
		test(pizza);
	}

	public static void test(Pizza pizza) {
		Slice slice = new Slice(new Position(0, 0), new Position(1, 1), 3, 0);
		System.out.println(slice.getSize());
		if(PizzaUtils.isSliceValid(slice, slice.getSize(), 1))
			System.out.println("Es válido");
		else
			System.out.println("No es válido");
	}
}
