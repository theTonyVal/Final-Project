package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import src.item.*;

public class text {

    private File path;

    public text(String _path)
    {
        path = new File(_path);
    }

    public void writeObj(ArrayList<item> itemList)
    {
        try (FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

        // write object to file
        for (item i : itemList) {
            oos.writeObject(i);
            System.out.println("Item successfully written");
        }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<item> readObj()
    {
        ArrayList<item> items = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis)) {

        // read object from file
        for (int i = 0; i < path.length(); i++) {
            Object obj = ois.readObject();
            items.add((item)obj);
        }

        // print object
        System.out.print("recieved : " + items);

        return items;

        } catch (IOException | ClassNotFoundException ex) {
            //ex.printStackTrace();
            return items;
        }
    }

}
