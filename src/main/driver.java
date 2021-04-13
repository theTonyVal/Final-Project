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
    private static Cpu amd = new Cpu("ryzen5-3600", 400.0, 10, "34536c");
    private static Cpu intel = new Cpu("i5-9600k", 400.0, 10, "25252c");
    private static Gpu nvidia = new Gpu("2060rtx", 500.0, 10, "56345g");
    private static Gpu radeon = new Gpu("6600x", 800.0, 10, "89234g");
    private static Ram hyperX = new Ram("hyperx", 100.0, 10, "25891r");
    private static Misc keyBoard = new Misc ("qwerty", 100.0, 10, "64533k");

    public static ArrayList<Item> invent = new ArrayList<Item>();
    public static text text = new text("store.csv");

    //initializes the Login GUI which will start the main GUI if a login is accepted.
    public static void main(String[] args) throws IOException
    {    	
    	lGui = new LoginGUI();
    }

}