package src.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import src.item.*;

public class inventory {

    public String path = "store.dat";
    public text text = new text(path);
    
    public ArrayList<Map<Item, Integer>> invent = new ArrayList<>();

   public inventory(ArrayList<Map<Item, Integer>> _invent)
   {
       invent = _invent;
   }

   public void addItem(Map<Item, Integer> item)
   {
       invent.add(item);
   }

   public void removeItem(Item i)
   {
       invent.remove(i);
   }

   public void write() throws IOException
   {
       text.writeObj(invent);
   }

   public ArrayList<Map<Item, Integer>> read() throws IOException
   {
       invent = text.readObj();
       return invent;
   }

   public Map<Item, Integer> getItem(int i)
   {
       return invent.get(i);
   }
   
   @Override
public String toString()
   {
       return invent.toString();
   }

}