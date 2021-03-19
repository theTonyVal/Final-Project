package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class inventory {

    public String path = "store.dat";
    public text text = new text(path);
    
    public ArrayList<Map<item, Integer>> invent = new ArrayList<>();

   public inventory(ArrayList<Map<item, Integer>> _invent)
   {
       invent = _invent;
   }

   public void addItem(Map<item, Integer> item)
   {
       invent.add(item);
   }

   public void removeItem(item i)
   {
       invent.remove(i);
   }

   public void write() throws IOException
   {
       text.writeObj(invent);
   }

   public ArrayList<Map<item, Integer>> read() throws IOException
   {
       invent = text.readObj();
       return invent;
   }

   public Map<item, Integer> getItem(int i)
   {
       return invent.get(i);
   }
   
   @Override
public String toString()
   {
       return invent.toString();
   }

}