package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;

public class text {

    private File path;

    public text(String _path)
    {
        path = new File(_path);
    }

    public void writeObj(ArrayList<Map<item, Integer>> itemList)
    {
        try (FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

        // write object to file
        for (Map<item, Integer> i : itemList) {
            oos.writeObject(i);
            System.out.println("Item successfully written");
        }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeHash(ArrayList<Map<item, Integer>> itemList) throws IOException
    {
        FileWriter writer;

        writer = new FileWriter(path, true);  //True = Append to file, false = Overwrite

        for (Map<item, Integer> i : itemList)
        {
            System.out.println(i.keySet());
            System.out.println(i.values());
            writer.write(i.keySet().toString());
            writer.write(",");
            writer.write(i.values().toString());
        }

        // for (int i = 0; i < itemList.size(); i++) { 
        //     Map<item, Integer> map = itemList.get(i);
        //     item j = (item) map.keySet();
        //     System.out.println(j);
        //     //writer.write(itemList.get(i).toString());
        //     //writer.write(",");
        // }

        writer.close();
    }

    //help: https://stackoverflow.com/questions/20068383/convert-csv-values-to-a-hashmap-key-value-pairs-in-java

    public void readHash() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("store.dat"));
        String line = br.readLine();
        Map<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<Map<item, Integer>> aList = new ArrayList<>();
        String str[] = line.split(",");

        for (String i : str)
        {
            System.out.println(i);
        }

        br.close();
    }

    public ArrayList<Map<item, Integer>> readObj()
    {
        ArrayList<Map<item, Integer>> items = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis)) {

        // read object from file
        for (int i = 0; i < path.length(); i++) {
            Object obj = ois.readObject();
            items.add((Map<item, Integer>)obj);
        }

        // print object
        System.out.print("recieved : " + items);

        return items;

        } catch (IOException | ClassNotFoundException ex) {
            // ex.printStackTrace();
            return items;
        }
    }

}
