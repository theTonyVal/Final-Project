package src.main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import src.item.*;

public class text {

    private File path;

    public text(String _path)
    {
        path = new File(_path);
    }

    public void writeInvent(ArrayList<item> itemList) throws IOException
    {
        FileWriter csv = new FileWriter(path);
        
        for (item i : itemList)
        {
            csv.append(String.join(",", i.toString()));
            csv.append("\n");
        }

        csv.flush();
        csv.close();
    }

    public ArrayList<item> readInvent() throws IOException
    {
        BufferedReader csv = new BufferedReader(new FileReader(path));
        ArrayList <item> items = new ArrayList<item>();


        String row = csv.readLine();
        while (row != null)
        {
            String[] temp = row.split(",");

            if (temp[3].contains("r"))
            {
                ram tempRam = new ram(temp[0], Double.valueOf(temp[1]), Integer.valueOf(temp[2]), temp[3]);
                items.add(tempRam);
            }
            else if (temp[3].contains("g"))
            {
                gpu tempGpu = new gpu(temp[0], Double.valueOf(temp[1]), Integer.valueOf(temp[2]), temp[3]);
                items.add(tempGpu);
            }
            else if (temp[3].contains("c"))
            {
                cpu tempCpu = new cpu(temp[0], Double.valueOf(temp[1]), Integer.valueOf(temp[2]), temp[3]);
                items.add(tempCpu);
            }

            row = csv.readLine();
        }
        csv.close();

        return items;
    }

}
