package Utils;

import Parser.ProblemEntry;
import Tipos.Pizza;
import Tipos.Position;
import Tipos.Slice;
import Tipos.dataNode.StatusNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by p4r4d0x on 18/02/17.
 */
public class Slicer {
    public Slicer() {
    }
    public static List<StatusNode> generateSlicers(StatusNode node){

        List<StatusNode> ret = new ArrayList<StatusNode>();
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

    public static List<Position> generateSlicePosition(Position ini, int size, int rows, int columns){
        ArrayList<Position> ret = new ArrayList<Position>();
        int mid = size+1/2;
        int n = size;
        int d=1,c;

        do{
            c = n/d;
            if(n%d==0 && d+ini.getRow()<=rows && c+ini.getColumn()<=columns){
                ret.add(new Position(d-1+ini.getRow(),c-1+ini.getColumn()));
            }
            d++;
            //TODO It is not necessary to verify further than mid
        }while(d<=n);


        return ret;
    }


}
