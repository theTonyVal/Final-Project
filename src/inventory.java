package src;

import java.util.ArrayList;
import java.io.File;

public class inventory {

    public File store = new File("store.txt");
    public text text = new text(store);
    private ArrayList<item> invent = new ArrayList<>();

    public inventory(ArrayList<item> _invent)
    {
        invent = _invent;
    }

    public void addItem(item i)
    {
        invent.add(i);
        text.write(invent);
    }

    public void removeItem(item i)
    {
        invent.remove(i);
        text.write(invent);
    }

    public item getItem(int i)
    {
        return invent.get(i);
    }

    public String toString()
    {
        return invent.toString();
    }
}