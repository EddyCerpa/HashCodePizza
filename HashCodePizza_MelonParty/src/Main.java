import Parser.ParserIn;
import Parser.ParserOut;
import Parser.ProblemEntry;
import Tipos.Pizza;
import Tipos.Slice;
import Tipos.dataNode.StatusNode;
import Utils.Slicer;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {

        ProblemEntry data = ParserIn.parseEntryFile("small.in");
        StatusNode solution = calculePizzaSlices(data);
        ParserOut.generateOutputFile("small.out", solution);
        System.out.println("Solution finded!");

    }

    public static StatusNode calculePizzaSlices(ProblemEntry data){
        /**
         * Take pizza from data
         */
        Pizza pizza = data.getPizza();


        /**
         * Create an arraylist with all the nodes
         */
        ArrayList<StatusNode> nodeList = new ArrayList<>();
        nodeList.add(new StatusNode(0,pizza,new ArrayList<Slice>()));

        Iterator<StatusNode> itr;
        StatusNode nodeAux=null;

        while(!nodeList.isEmpty()){
            itr = null;
            itr = nodeList.iterator();

            if(itr.hasNext()){
                /**
                 * Extract the first node of the list
                 */
                nodeAux=itr.next();
                /**
                 * Check if this node is solution
                 */
                if(nodeAux.isNodeASolution()){
                    /*
                    * If the solution is found, return;
                    * */
                    return nodeAux;

                }
                else{
                    /**
                     * Remove node from list
                     */
                    nodeList.remove(nodeAux);

                    /**
                     * Call for a new nodes by expanding the first one
                     */
                    nodeList.addAll(0,Slicer.generateSlicers(nodeAux));
                }
            }
        }

        return null;

    }

}

