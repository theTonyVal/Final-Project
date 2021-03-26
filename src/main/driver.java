package src.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.print.event.PrintEvent;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;
import src.GUIs.*;
import src.item.*;

import java.io.IOException;

public class driver {

    private static LoginGUI lGui;
    private static MainGUI mGui;

    public static ArrayList<Map<item, Integer>> _invent = new ArrayList<>();
    public static inventory inv;

    public static Map<item, Integer> map = new HashMap<item, Integer>();
    public static Map<item, Integer> map2 = new HashMap<item, Integer>();
    public static Map<item, Integer> map3 = new HashMap<item, Integer>();
    public static Map<item, Integer> map4 = new HashMap<item, Integer>();
    public static Map<item, Integer> map5 = new HashMap<item, Integer>();

    private static cpu amd = new cpu("ryzen5-3600", 400.0, 5, 10);
    private static cpu intel = new cpu("i5-9600k", 400.0, 5, 10);
    private static gpu nvidia = new gpu("2060rtx", 500.0, true, 10);
    private static gpu radeon = new gpu("6600x", 800.0, true, 10);
    private static ram hyperX = new ram("hyperx", 100.0, 1200.0, 10);

    public static void main(String[] args) throws IOException
    {
        map.put(nvidia, nvidia.quantity());
        _invent.add(map);
        map2.put(amd, amd.quantity());
        _invent.add(map2);
        map3.put(intel, intel.quantity());
        _invent.add(map3);
        map4.put(radeon, radeon.quantity());
        _invent.add(map4);
        map5.put(hyperX, hyperX.quantity());
        _invent.add(map5);


        inv = new inventory(_invent);
        inv.write();
        
        lGui = new LoginGUI();
    }

}
