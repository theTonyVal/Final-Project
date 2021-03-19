package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.print.event.PrintEvent;

import src.GUIs.LoginGUI;
import src.GUIs.MainGUI;
import src.item.cpu;
import src.item.gpu;
import src.item.item;

import java.io.IOException;

public class driver {

    private static LoginGUI lGui;
    private static MainGUI mGui;

    public static ArrayList<Map<item, Integer>> _invent = new ArrayList<>();
    public static inventory inv;
    public static Map map = new HashMap<item, Integer>();

    private static cpu amd = new cpu("ryzen5-3600", 400.0, 5, 4);
    private static cpu intel = new cpu("i5-9600k", 400.0, 5, 5);
    private static gpu nvidia = new gpu("2060rtx", 500.0, true, 4);

    public static void main(String[] args) throws IOException
    {
        map.put(nvidia, nvidia.quantity());
        _invent.add(map);
        inv = new inventory(_invent);
        inv.write();
        
        lGui = new LoginGUI();
    }

}
