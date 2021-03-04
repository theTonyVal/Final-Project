package src;

import java.util.ArrayList;
import src.item.*;

public class inventory {

    public String path = "object.dat";

    public text text = new text(path);
    private ArrayList<item> invent = new ArrayList<>();

    public inventory(ArrayList<item> _invent)
    {
        invent = _invent;
    }

    public void addItem(item item)
    {
        invent.add(item);
    }

    public void removeItem(item i)
    {
        invent.remove(i);
    }

    public void write()
    {
        for (item c : invent)
            text.writeObj(c);
    }

    public void read()
    {
        text.readObj();
    }

    public item getItem(int i)
    {
        return invent.get(i);
    }

    public void PrintInv()
    {
        System.out.print("\n");
        for (int c = 0; c < invent.size(); c++)
        {
            System.out.println(invent.get(c));
        }
    }

    public String toString()
    {
        return invent.toString();
    }
}