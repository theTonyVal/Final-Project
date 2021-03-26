package src.GUIs;

import javax.swing.*;

import src.main.*;
import src.item.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    private JLabel itemLabel, priceLabel, skillLabel, quanLabel, costLabel;
    private JTextField userText;
    private JButton addCart, removeCart, purchase;
	private DefaultListModel<Map<item, Integer>> itemList;
    private JList<Map<item, Integer>> itemJList = new JList<Map<item, Integer>>();
    private JList<item> cartJList = new JList<item>();
    private DefaultListModel<item> cartList;

    public MainGUI() throws IOException {

        inv = invent.read();

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        costLabel = new JLabel("cost");
        costLabel.setBounds(560, 150, 100, 50);
        panel.add(costLabel);
        
        //itemList = new JList<item>(_invent.toArray(new item[0]));
        itemList = new DefaultListModel<Map<item, Integer>>();
        
        for (int c = 0; c < inv.size(); c++)
        {
        	itemList.add(c, inv.get(c));
        }
        
        itemJList.setModel(itemList);
        itemJList.setBounds(10, 50, 500, 500);
        panel.add(itemJList);
        
        cartList = new DefaultListModel<item>();
        cartJList.setModel(cartList);
        cartJList.setBounds(650, 50, 500, 500);
        panel.add(cartJList);
        
        addCart = new JButton("Add to Cart");
        addCart.addActionListener(this);
        addCart.setBounds(525, 500, 100, 50);
        panel.add(addCart);

        purchase = new JButton("Purchase");
        purchase.addActionListener(this);
        purchase.setBounds(525, 325, 100, 50);
        panel.add(purchase);
        
        removeCart = new JButton("Remove from Cart");
        removeCart.addActionListener(this);
        removeCart.setBounds(525, 250, 100, 50);
        panel.add(removeCart);

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
        item i = cartJList.getSelectedValue();

        System.out.print(i);

        for (int c = 0; c < itemList.size(); c++)
        {
            for (item j : itemList.get(c).keySet())
            {
                System.out.print(itemList.get(c));
                if (i.equals(j))
                {
                    System.out.print(i + " " + j);
                    itemList.get(c).put(i, itemList.get(c).get(i)+1);
                    cartList.removeElement(i);
                }

            }
        }

        panel.repaint();
    }

    public void Purchase()
    {
        double total = 0;

        for (int i = 0; i < cartList.size(); i++)
        {
            total += cartList.get(i).price();
        }
        costLabel.setText(Double.toString(total));
        System.out.print(total);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCart)
        {
        	AddtoCart();
        }
        else if (e.getSource() == removeCart)
        {
        	RemoveFromCart();
        }
        else if (e.getSource() == purchase)
        {
            Purchase();
            
        }
    }
}

//JButton substractButton = new JButton( new AbstractAction("substract") { 
//    @Override
//    public void actionPerformed( ActionEvent e ) {
//        // substract Action
//    }
//});


