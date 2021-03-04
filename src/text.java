package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import src.item.*;

public class text {

    private String path;

    public text(String _path)
    {
        path = _path;
    }

    public void writeObj(item item)
    {
        try (FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

        // write object to file
        oos.writeObject(item);
        System.out.println("Item successfully written");

        } catch (IOException ex) {
        ex.printStackTrace();
        }
    }

    public void readObj()
    {
        try (FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis)) {

        // read object from file
        item user = (item) ois.readObject();

        // print object
        System.out.print(user);

        } catch (IOException | ClassNotFoundException ex) {
        ex.printStackTrace();
        }
    }

}
