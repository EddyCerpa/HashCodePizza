package Utils;

import Parser.ProblemEntry;
import Tipos.Pizza;
import Tipos.Position;
import Tipos.Slice;
import Tipos.dataNode.StatusNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p4r4d0x on 18/02/17.
 */
public class Slicer {
    public Slicer() {
    }

    /**
     *
     * @param node Current state of the algorithm
     * @return Array of nodes branched from the receiving node
     */
    public static List<StatusNode> generateSlicers(StatusNode node){

        List<StatusNode> ret = new ArrayList<>();
        List<Position> slicePosition;

        Position ini = PizzaUtils.getFirstCorrectPosition(node);

        Pizza pizza = node.getCurrentPizza();
        Pizza pizzaAux;
        int rows = pizza.getPizzaRows();
        int columns = pizza.getPizzaColumns();
        int nodeNumber = node.getNodeNumber();
        Slice slice;

        int min = ProblemEntry.L*2;

        while(min<=ProblemEntry.H){

            slicePosition = generateSlicePosition(ini, min, rows, columns);
            for (Position slicePos: slicePosition) {
                slice = PizzaUtils.cutSliceFromPizza(pizza, ini, slicePos);

                if((slice != null)&& (PizzaUtils.isSliceValid(slice, ProblemEntry.H, ProblemEntry.L))){
                    //Create node
                    pizzaAux = PizzaUtils.getCuttedPizzaFromSlice(pizza,slice);
                    ArrayList<Slice> slices = (ArrayList<Slice>)(node.getCurrentSlicesCutted()).clone();
                    slices.add(slice);
                    ret.add(new StatusNode(++nodeNumber, pizzaAux, slices));
                }
            }
            min++;
        }


        return ret;
    }

    /**
     *
     * @param ini From this generate possibles slices
     * @param size Size of the slices to generate
     * @param rows Edge rows
     * @param columns  Edge columns
     * @return Array of second positions of possibles slices
     */
    public static List<Position> generateSlicePosition(Position ini, int size, int rows, int columns){
        ArrayList<Position> ret = new ArrayList<>();
        int mid = size+1/2;
        int n = size;
        int d=1,c;

        do{
            c = n/d;
            if(n%d==0 && d+ini.getRow()<=rows && c+ini.getColumn()<=columns){
                ret.add(new Position(d-1+ini.getRow(),c-1+ini.getColumn()));
            }
            d++;

        }while(d<=n);


        return ret;
    }


}
