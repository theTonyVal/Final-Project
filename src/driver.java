package src;

import java.util.ArrayList;
import java.io.IOException;
import src.account.Login;
import src.item.*;

public class driver {
    public static ArrayList<item> _invent = new ArrayList<>();
    public static inventory inv = new inventory(_invent);

    private static Login l = new Login();

    private static cpu amd = new cpu("ryzen5-3600", 400.0, 5, 4);
    private static cpu intel = new cpu("i5-9600k", 400.0, 5, 5);
    private static gpu nvidia = new gpu("2060rtx", 500.0, true, 4);

    public static void main(String[] args) throws IOException
    {
        l.LogIn();
        inv.addItem(amd);
        amd.sell();
        inv.addItem(intel);
        inv.addItem(nvidia);
        System.out.println(inv);
        nvidia.sell();
        inv.write();
        inv.read();
    }

}
