package archive;

import java.io.IOException;
import java.util.ArrayList;
import src.item.*;
import src.main.*;

public class inventory2 {
    
    public String path = "store.csv";
    public text text = new text(path);
    public static ArrayList<Item> inventory = new ArrayList<Item>();

    public inventory2(ArrayList<Item> invent)
    {
        inventory = invent;
    }
    
    public void write() throws IOException
    {
        text.writeInvent(inventory);
    }

    public ArrayList<Item> read() throws IOException
    {
        return text.readInvent();
    }
}
