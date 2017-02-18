package Parser;

import Tipos.Pizza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Capa on 14/2/17.
 */
public class ParserIn {
    public ParserIn(){

    }

    public Pizza parsePizzaFile(String infile){
        Pizza pizza = null;
        try (BufferedReader br = new BufferedReader(new FileReader(infile))){
            //Parse conditions
            String line = br.readLine();
            String[] items = line.split(" ");

            int rows = Integer.parseInt(items[0]);
            int columns = Integer.parseInt(items[1]);
            int L = Integer.parseInt(items[2]);
            int H = Integer.parseInt(items[3]);

            // Create array
            Pizza.Ingredient[][] ingredients = new Pizza.Ingredient[rows][columns];

            int tomatoes = 0, mushrooms = 0;
            // Parse pizza rows
            for (int i = 0; i < rows; i++) {
                line = br.readLine();
                for (int j = 0; j < columns; j++) {
                    if(line.charAt(j)=='M'){
                        ingredients[i][j] = Pizza.Ingredient.MUSHROOM;
                        mushrooms++;
                    }else{
                        ingredients[i][j] = Pizza.Ingredient.TOMATOE;
                        tomatoes++;
                    }
                }
            }

            pizza = new Pizza(tomatoes, mushrooms, rows, columns, ingredients);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return pizza;
    }
}
