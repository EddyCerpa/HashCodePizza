import Parser.ParserIn;
import Parser.ProblemEntry;
import Tipos.Pizza;
import Tipos.Slice;
import Tipos.dataNode.StatusNode;
import Utils.Slicer;

import java.util.ArrayList;


    public class Main {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            System.out.println("Hola!");
            System.out.println("Hola");

            ParserIn parser = new ParserIn();
            ProblemEntry data = parser.parseEntryFile("small.in");
            System.out.println("Pizza parsed!");
            Pizza pizza = data.getPizza();
            //System.out.println(pizza);
            Slicer.generateSlicers(new StatusNode(0,pizza,new ArrayList<Slice>()));
        }


    }
