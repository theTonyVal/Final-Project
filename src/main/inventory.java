package src.main;

import java.io.IOException;
import java.util.ArrayList;
import src.item.*;
import src.main.*;

public class inventory {
    
    public String path = "store.csv";
    public text text = new text(path);
    public static ArrayList<item> inventory = new ArrayList<item>();

    public inventory(ArrayList<item> invent)
    {
        inventory = invent;
    }
    
    public void write() throws IOException
    {
        text.writeInvent(inventory);
    }

    public ArrayList<item> read() throws IOException
    {
        return text.readInvent();
    }
}
