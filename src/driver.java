package src;

import java.util.ArrayList;
import java.io.IOException;
import src.item.*;
import src.account.*;

public class driver {
    public static ArrayList<item> _invent = new ArrayList<>();
    private static Login l = new Login();

    public static void main(String[] args) throws IOException
    {
        l.LogIn();
    }
}
