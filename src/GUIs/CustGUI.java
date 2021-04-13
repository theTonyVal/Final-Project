package src.GUIs;

import javax.swing.*;
import src.main.*;
import src.item.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class CustGUI implements ActionListener {

	public text text = new text("store.csv");
	
    public static ArrayList<Item> inv = new ArrayList<>();
    public static ArrayList<Item> cart = new ArrayList<>();
    
    public static DefaultListModel<Item> itemList;
    public static DefaultListModel<Item> cartList;
    
    private JList<Item> itemJList, cartJList;
    private JFrame frame;
    private JPanel panel;
    private JLabel itemLabel, priceLabel, skillLabel, quanLabel, costLabel;
    private JButton addCart, removeCart, purchase;
    
    public CustGUI() throws IOException {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        
        inv = text.readInvent();

        itemLabel = new JLabel("items");
        itemLabel.setBounds(10, 20, 100, 25);
        panel.add(itemLabel);

        priceLabel = new JLabel("price");
        priceLabel.setBounds(110, 20, 100, 25);
        panel.add(priceLabel);

        skillLabel = new JLabel("quantity");
        skillLabel.setBounds(210, 20, 100, 25);
        panel.add(skillLabel);

        quanLabel = new JLabel("id");
        quanLabel.setBounds(310, 20, 100, 25);
        panel.add(quanLabel);

        costLabel = new JLabel("cost");
        costLabel.setBounds(560, 150, 100, 50);
        panel.add(costLabel);
        
        itemList = new DefaultListModel<Item>();
        for (int c = 0; c < inv.size(); c++)
        {
        	itemList.add(c, inv.get(c));
        }
        
        System.out.print(itemList);
        
        itemJList = new JList<Item>();
        itemJList.setModel(itemList);
        itemJList.setBounds(10, 50, 500, 500);
        panel.add(itemJList);
        
        cartList = new DefaultListModel<Item>();
        cartJList = new JList<Item>();
        cartJList.setModel(cartList);
        cartJList.setBounds(650, 50, 500, 500);
        panel.add(cartJList);
        
        addCart = new JButton("Add to Cart");
        addCart.addActionListener(this);
        addCart.setBounds(525, 500, 100, 50);
        panel.add(addCart);
        
        removeCart = new JButton("Remove from Cart");
        removeCart.addActionListener(this);
        removeCart.setBounds(525, 250, 100, 50);
        panel.add(removeCart);
        
        purchase = new JButton("Purchase");
        purchase.addActionListener(this);
        purchase.setBounds(525, 325, 100, 50);
        panel.add(purchase);

        frame.repaint();
        frame.setVisible(true);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addCart)
		{
			Item selected = itemJList.getSelectedValue();
			
			String m = selected.getModel();
        	double p = selected.getPrice();
        	int q = selected.getQuantity();
        	String ident = selected.getId();
			
        	if (q > 0)
        	{
	        	if (ident.contains("r"))
	            {
	                Ram tempRam = new Ram(m, p, 1, ident);
	                cartList.add(0, tempRam);
	            }
	            else if (ident.contains("g"))
	            {
	                Gpu tempGpu = new Gpu(m, p, 1, ident);
	                cartList.add(0, tempGpu);
	            }
	            else if (ident.contains("c"))
	            {
	                Cpu tempCpu = new Cpu(m, p, 1, ident);
	                cartList.add(0, tempCpu);
	            }
				
				selected.sell();
				frame.repaint();
        	}
		}
		
		if (e.getSource() == purchase)
		{
			double total = 0;

	        for (int i = 0; i < cartList.size(); i++)
	        {
	            total += cartList.get(i).getPrice();
	        }
	        costLabel.setText(Double.toString(total));
	        System.out.print(total);
	        cartList.clear();
		}
		
		if (e.getSource() == removeCart)
		{
			Item selected = cartJList.getSelectedValue();
			
			for (int c = 0; c < itemList.size(); c++)
			{
				if (selected.getModel().equals(itemList.get(c).getModel()))
				{
					itemList.get(c).setQuantity(itemList.get(c).getQuantity() + 1);
					cartList.removeElement(selected);
				}
			}
			frame.repaint();
		}
		
	}
}
