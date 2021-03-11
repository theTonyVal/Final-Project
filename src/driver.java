package src;

import java.util.ArrayList;
import java.io.IOException;
import src.account.*;
import src.item.*;
import src.GUIs.*;

public class driver {

    private static LoginGUI lGui;
    private static MainGUI mGui;

    public static ArrayList<item> _invent = new ArrayList<>();
    public static inventory inv = new inventory(_invent);

    private static cpu amd = new cpu("ryzen5-3600", 400.0, 5, 4);
    private static cpu intel = new cpu("i5-9600k", 400.0, 5, 5);
    private static gpu nvidia = new gpu("2060rtx", 500.0, true, 4);

    public static void main(String[] args) throws IOException
    {
        _invent.add(amd);
        _invent.add(intel);
        _invent.add(nvidia);
        inv.write();

        lGui = new LoginGUI();
    }

}
