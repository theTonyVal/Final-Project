package src.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import src.inventory;
import src.account.*;
import src.item.*;
import src.*;

public class MainGUI implements ActionListener {

    public static ArrayList<Map<item, Integer>> inv = new ArrayList<>();
    public static ArrayList<item> _cart = new ArrayList<>();
    
    public static inventory invent = new inventory(inv);
    public static Cart cart = new Cart(_cart);

    private static cpu amd = new cpu("ryzen5-3600", 400.0, 5, 4);
    private static cpu intel = new cpu("i5-9600k", 400.0, 5, 5);
    private static gpu nvidia = new gpu("2060rtx", 500.0, true, 4);

    private JFrame frame;
    private JPanel panel;
    private JLabel itemLabel, priceLabel, skillLabel, quanLabel;
    private JTextField userText;
    private JButton addCart;
	private DefaultListModel<Map<item, Integer>> itemList;
    private JList<Map<item, Integer>> itemJList = new JList<Map<item, Integer>>();
    private JList<item> cartJList = new JList<item>();
    private DefaultListModel<item> cartList;

    public MainGUI() throws IOException {

        inv = invent.read();
        System.out.print(inv);

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(1200, 600);
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
        
        //itemList = new JList<item>(_invent.toArray(new item[0]));
        itemList = new DefaultListModel<Map<item, Integer>>();
        
        for (int c = 0; c < inv.size(); c++)
        {
        	itemList.add(c, inv.get(c));
        }
        
        System.out.print(itemList);
        
        itemJList.setModel(itemList);
        itemJList.setBounds(10, 50, 500, 500);
        panel.add(itemJList);
        
        cartList = new DefaultListModel<item>();
        cartJList.setModel(cartList);
        cartJList.setBounds(650, 50, 500, 500);
        panel.add(cartJList);
        
        addCart = new JButton("Add to Cart");
        addCart.addActionListener(
        		new ActionListener() {
        		    public void actionPerformed(ActionEvent e) {
        		      AddtoCart();
        		    }
        		  });
        addCart.setBounds(525, 500, 100, 50);
        panel.add(addCart);

        frame.repaint();
        frame.setVisible(true);
        
    }

    public void AddtoCart()
    {
        Map<item, Integer> selected = itemJList.getSelectedValue();
        int quantity = 0;

        for (int i : selected.values())
        {
            quantity = i;
        }

        if (quantity != 0)
        {
            Set<item> temp = selected.keySet();
            for (item i : temp)
            {
                cartList.add(0, i);
                selected.put(i, selected.get(i)-1);
            }
            panel.repaint();
        }
    }

    public void RemoveFromCart()
    {
        
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

//JButton substractButton = new JButton( new AbstractAction("substract") { 
//    @Override
//    public void actionPerformed( ActionEvent e ) {
//        // substract Action
//    }
//});


