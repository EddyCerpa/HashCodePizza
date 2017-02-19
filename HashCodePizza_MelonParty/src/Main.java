import Parser.ParserIn;
import Parser.ParserOut;
import Parser.ProblemEntry;
import Tipos.Pizza;
import Tipos.Position;
import Tipos.Slice;
import Tipos.dataNode.StatusNode;
import Utils.Slicer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Main {


    static HashSet<Integer> duplicatedNodes = new HashSet<>();
    static int nodosDuplicados=0;

    public static void main(String[] args) {

        ProblemEntry data = ParserIn.parseEntryFile("small.in");

        /*Pizza pizzaData= data.pizza;

        Pizza pizza1 = pizzaData.clone();
        Pizza pizza2 = pizzaData.clone();

        ArrayList<Slice> slices1 = new ArrayList<Slice>();
        slices1.add(new Slice(new Position(0,0),new Position(1,1),5,4));

        ArrayList<Slice> slices2 = new ArrayList<Slice>();
        slices2.add(new Slice(new Position(0,0),new Position(1,1),5,4));

        System.out.println("HCP1: "+pizza1.hashCode());
        System.out.println("HCP2: "+pizza2.hashCode());

        StatusNode node1 = new StatusNode(0,pizza1,slices1);
        StatusNode node2 = new StatusNode(0,pizza2,slices2);
        System.out.println("HCN1: "+node1.hashCode());
        System.out.println("HCN2: "+node2.hashCode());

*/



        StatusNode solution = calculePizzaSlicesFIRSTINDEPTH(data);
        //StatusNode solution = calculePizzaSlicesFIRSTINAMPLITUDE(data);

        ParserOut.generateOutputFile("small.out", solution);
        System.out.println("Solution finded!");
        System.out.println("Nodos duplicados: "+nodosDuplicados);

    }

    public static StatusNode calculePizzaSlicesFIRSTINDEPTH(ProblemEntry data){



        /**
         * Take pizza from data
         */
        Pizza pizza = data.getPizza();


        /**
         * Create an arraylist with all the nodes
         */
        ArrayList<StatusNode> nodeList = new ArrayList<>();
        ArrayList<StatusNode> auxAL;
        nodeList.add(new StatusNode(0,pizza,new ArrayList<Slice>()));


        Iterator<StatusNode> itr;
        StatusNode nodeAux=null;

        while(!nodeList.isEmpty()){
            itr = nodeList.iterator();

            System.out.println("Nodes at the list " + nodeList.size() + System.lineSeparator());

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
                /**
                 * Check if this node can not generate a new valid solution
                 */
                else if(nodeAux.needIngredients()){
                    /**
                     * Remove without expanding
                     */
                    nodeList.remove(nodeAux);

                }
                else{

                    /**
                     * Remove node from list
                     */
                    nodeList.remove(nodeAux);

                    /**
                     * Call for new nodes by expanding the first one
                     */
                    auxAL = Slicer.generateSlicers(nodeAux);

                    /**
                     * Check if the obtained nodes are already procesated
                     */
                    checkRepeatedNodes(auxAL);

                    /**
                     * After it, inser those not repeated nodes
                     */
                    nodeList.addAll(0,auxAL);
                }
            }
        }

        return null;

    }

    public static StatusNode calculePizzaSlicesFIRSTINAMPLITUDE(ProblemEntry data){
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
            itr = nodeList.iterator();

            System.out.println("Nodes at the list " + nodeList.size() + System.lineSeparator());

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
                /**
                 * Check if this node can not generate a new valid solution
                 */
                else if(nodeAux.needIngredients()){
                    /**
                     * Remove without expanding
                     */
                    nodeList.remove(nodeAux);

                }
                else{
                    /**
                     * Remove node from list
                     */
                    nodeList.remove(nodeAux);

                    /**
                     * Call for new nodes by expanding the first one
                     */
                    nodeList.addAll(Slicer.generateSlicers(nodeAux));
                }
            }
        }

        return null;

    }

    /**
     * Check if the subList with nodes have some node repeated
     *
     * @param list
     */
    public static void checkRepeatedNodes(ArrayList<StatusNode> list){
        //TODO Fix hash bug: Too many collides for a small problem
        Iterator<StatusNode> itr;
        StatusNode nodeAux=null;
        ArrayList<StatusNode> listNotRemoved = (ArrayList<StatusNode>) list.clone();
        int hashNodeAux=0;
        itr = listNotRemoved.iterator();

        /**
         * Iterate the whole list
         */
        while(itr.hasNext()) {
            /*get the slice*/
            nodeAux = itr.next();
            /*get the hash from the node*/
            hashNodeAux = nodeAux.hashCode();
            /*Check if its duplicated*/
            if (duplicatedNodes.contains(hashNodeAux)) {
                //System.out.println("Nodo duplicado");
                nodosDuplicados++;
                /*remove node*/
                list.remove(nodeAux);
            } else {
                /*If not, add this node to the hashlist*/
                duplicatedNodes.add(hashNodeAux);
            }
        }

    }

}

