import Parser.ParserIn;
import Tipos.Pizza;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola!");
		System.out.println("Hola");

		ParserIn parser = new ParserIn();
		Pizza pizza = parser.parsePizzaFile("test.in");
		System.out.println("Pizza parsed!");



	}

}
