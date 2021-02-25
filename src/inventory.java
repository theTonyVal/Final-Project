package src;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class inventory {

    public File store = new File("store.txt");
    private ArrayList<item> invent = new ArrayList<>();

    public inventory(ArrayList<item> _invent)
    {
        invent = _invent;
    }

    public void addItem(item i)
    {
        try 
        {
            FileWriter fw = new FileWriter(store);
            
            invent.add(i);
            fw.write(toString());

            fw.close();
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void removeItem(item i)
    {
        invent.remove(i);
    }

    public String toString()
    {
        return invent.toString();
    }
}