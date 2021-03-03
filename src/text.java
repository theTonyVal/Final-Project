package src;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import src.item.*;

public class text {
    
    private File file;
    private String data;

    public text(File _file)
    {
        file = _file;
    }

    public void write(ArrayList<item> invent)
    {
        try 
        {
            FileWriter fw = new FileWriter(file);
            
            fw.write(invent.toString());

            fw.close();
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred while writing");
            e.printStackTrace();
        }
    }

    public String read()
    {
        try
        {
            Scanner scan = new Scanner(file);
            data = scan.nextLine();
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while reading");
            e.printStackTrace();
        }

        return data;
    }

    public void writeObj(item item)
    {
        try (FileOutputStream fos = new FileOutputStream("object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

        // write object to file
        oos.writeObject(item);

        } catch (IOException ex) {
        ex.printStackTrace();
        }
    }

}
