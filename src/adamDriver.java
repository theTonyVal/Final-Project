package src;

import java.util.ArrayList;
import java.io.IOException;

public class adamDriver {
    public static ArrayList<item> _invent = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        cpu amd = new cpu(0, 001, "amd", 100.0, "ryzen 5 3600");
        //cpu test = new cpu(1, 002, "test", 0.0, "test");

        inventory invent = new inventory(_invent);
        invent.addItem(amd);

        System.out.println(invent);
    }
}
