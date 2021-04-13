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

    //constructor for the text object. Takes in a parameter for the path to the file it writes to.
    public text(String _path)
    {
        path = new File(_path);
    }

    //Writes the ArrayList of items to the .csv file (spreadsheet)
    public void writeInvent(ArrayList<Item> itemList) throws IOException
    {
        FileWriter csv = new FileWriter(path);
        
        for (Item i : itemList)
        {
            csv.append(String.join(",", i.csvString()));
            csv.append("\n");
        }

        csv.flush();
        csv.close();
    }

    //Reads an ArrayList of items from the .csv file and organizes each item into different objects
    public ArrayList<Item> readInvent() throws IOException
    {
        BufferedReader csv = new BufferedReader(new FileReader(path));
        ArrayList <Item> items = new ArrayList<Item>();


        String row = csv.readLine();
        while (row != null)
        {
            String[] temp = row.split(",");

            if (temp[3].contains("r"))
            {
                Ram tempRam = new Ram(temp[0], Double.valueOf(temp[1]), Integer.valueOf(temp[2]), temp[3]);
                items.add(tempRam);
            }
            else if (temp[3].contains("g"))
            {
                Gpu tempGpu = new Gpu(temp[0], Double.valueOf(temp[1]), Integer.valueOf(temp[2]), temp[3]);
                items.add(tempGpu);
            }
            else if (temp[3].contains("c"))
            {
                Cpu tempCpu = new Cpu(temp[0], Double.valueOf(temp[1]), Integer.valueOf(temp[2]), temp[3]);
                items.add(tempCpu);
            }
            else
            {
            	Misc tempMisc = new Misc(temp[0], Double.valueOf(temp[1]), Integer.valueOf(temp[2]), temp[3]);
            	items.add(tempMisc);
            }

            row = csv.readLine();
        }
        csv.close();

        return items;
    }

}
