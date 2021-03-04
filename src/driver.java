package src;

import java.util.ArrayList;
import java.io.IOException;
import src.account.Login;
import src.item.*;

public class driver {
    public static ArrayList<item> _invent = new ArrayList<>();
    public static inventory inv = new inventory(_invent);

    private static Login l = new Login();

    private static cpu cpu = new cpu("ryzen5-3600", 400.0, 5, 4);

    public static void main(String[] args) throws IOException
    {
        inv.addItem(cpu);
        inv.write();
        inv.read();


    }

}
