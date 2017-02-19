package Parser;

import Tipos.Slice;
import Tipos.dataNode.StatusNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Capa on 19/2/17.
 */
public class ParserOut {
    public ParserOut() {
    }

    public static void generateOutputFile(String fileName, StatusNode solution){
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            ArrayList<Slice> slices = solution.getCurrentSlicesCutted();

            writer.write(slices.size()+System.lineSeparator());

            for(Slice slice: solution.getCurrentSlicesCutted()){
                writer.write(slice.toStringSolution()+System.lineSeparator());
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
