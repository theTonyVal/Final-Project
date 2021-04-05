package src.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import src.main.*;
import src.GUIs.*;
import src.item.*;

import java.io.IOException;

public class driver {

    private static LoginGUI lGui;

    //A few variables used to test if the GUI was functioning
    private static cpu amd = new cpu("ryzen5-3600", 400.0, 10, "34536c");
    private static cpu intel = new cpu("i5-9600k", 400.0, 10, "25252c");
    private static gpu nvidia = new gpu("2060rtx", 500.0, 10, "56345g");
    private static gpu radeon = new gpu("6600x", 800.0, 10, "89234g");
    private static ram hyperX = new ram("hyperx", 100.0, 10, "25891r");

    public static ArrayList<item> invent = new ArrayList<item>();
    public static text text = new text("store.csv");

    //initializes the Login GUI which will start the main GUI if a login is accepted.
    public static void main(String[] args) throws IOException
    {
    	lGui = new LoginGUI();
    }

}