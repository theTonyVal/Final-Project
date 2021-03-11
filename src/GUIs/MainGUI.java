package src.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import src.inventory;
import src.account.*;
import src.item.*;

public class MainGUI implements ActionListener {

    public static ArrayList<item> _invent = new ArrayList<>();
    public static inventory inv = new inventory(_invent);

    private static cpu amd = new cpu("ryzen5-3600", 400.0, 5, 4);
    private static cpu intel = new cpu("i5-9600k", 400.0, 5, 5);
    private static gpu nvidia = new gpu("2060rtx", 500.0, true, 4);

    private JFrame frame;
    private JPanel panel;
    private JLabel itemLabel, priceLabel, skillLabel, quanLabel;
    private JTextField userText;
    private JButton button;
    private JList itemList;

    public MainGUI() {

        _invent = inv.read();

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

        itemLabel = new JLabel("items");
        itemLabel.setBounds(10, 20, 100, 25);
        panel.add(itemLabel);

        priceLabel = new JLabel("price");
        priceLabel.setBounds(110, 20, 100, 25);
        panel.add(priceLabel);

        skillLabel = new JLabel("skill");
        skillLabel.setBounds(210, 20, 100, 25);
        panel.add(skillLabel);

        quanLabel = new JLabel("quantity");
        quanLabel.setBounds(310, 20, 100, 25);
        panel.add(quanLabel);

        itemList = new JList<item>(_invent.toArray(new item[0]));
        itemList.setBounds(10, 50, 500, 500);
        panel.add(itemList);

        frame.repaint();
        frame.setVisible(true);
        
    }

    public void getItems() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // String search = userText.getText().strip();
        
        // if (search.trim().equals(""))
        //     System.out.println("Enter something into textfield to search");
        // else
        //     System.out.println(search);
        
    }
}


