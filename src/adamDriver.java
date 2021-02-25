package src;

import java.util.ArrayList;
import java.io.IOException;

public class adamDriver {
    public static ArrayList<item> _invent = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        cpu amd = new cpu(3, "000", "amd", 100.0, "ryzen-5-3600");
        //cpu intel = new cpu(4, "001", "intel", 100.0, "i5-9600k");

        inventory invent = new inventory(_invent);
        invent.addItem(amd);
    }
}
