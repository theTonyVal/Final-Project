package src;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.io.IOException;
import src.item.*;

public class driver {
    public static ArrayList<item> _invent = new ArrayList<>();
    //private static Login l = new Login();

    private static cpu cpu = new cpu("ryzen5-3600", 400.0, 5, 4);

    public static void main(String[] args) throws IOException
    {
        writeObj(cpu);
    }

    public static void writeObj(item item)
    {
        try (FileOutputStream fos = new FileOutputStream("object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

        // write object to file
        oos.writeObject(item);
        System.out.print("Item successfully written");

        } catch (IOException ex) {
        ex.printStackTrace();
        }
    }
}
