package src.GUIs;

import javax.swing.*;
import src.main.*;
import src.item.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;

public class AdminGUI implements ActionListener{
    
    private ArrayList<Item> itemList = new ArrayList<Item>();
    public text text = new text("store.csv");
    private JFrame frame;
    private JPanel panel;
    private JList<Item> list = new JList<Item>();
    private JTextField model;
    private JTextField price;
    private JTextField quantity;
    private JTextField id;
    private JButton addItem;
    private DefaultListModel<Item> itemModel;
    private JButton editItem;
    private JButton removeItem;
    private JLabel total;
    private JLabel totalLabel;

    //Initializes and creates the GUI for editing the database.
    public AdminGUI() throws IOException
    {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(panel);

        panel.setLayout(null);
        
        itemList = text.readInvent();
        System.out.println(itemList);
                
        itemModel = new DefaultListModel<Item>();
        for (int i = 0; i < itemList.size(); i++)
        {
            itemModel.addElement(itemList.get(i));
        }
        list.setModel(itemModel);        
        list.setBounds(10, 11, 297, 539);
        panel.add(list);
        
        addItem = new JButton("Add Item");
        addItem.setBounds(317, 45, 89, 23);
        addItem.addActionListener(this);
        panel.add(addItem);
        
        model = new JTextField();
        model.setBounds(317, 11, 166, 23);
        panel.add(model);
        model.setColumns(10);
        
        price = new JTextField();
        price.setBounds(493, 11, 86, 22);
        panel.add(price);
        price.setColumns(10);
        
        quantity = new JTextField();
        quantity.setColumns(10);
        quantity.setBounds(589, 11, 86, 22);
        panel.add(quantity);
        
        id = new JTextField();
        id.setBounds(685, 11, 89, 23);
        panel.add(id);
        id.setColumns(10);
        
        editItem = new JButton("Edit");
        editItem.setBounds(416, 45, 89, 23);
        editItem.addActionListener(this);
        panel.add(editItem);
        
        removeItem = new JButton("Remove");
        removeItem.setBounds(515, 45, 89, 23);
        removeItem.addActionListener(this);
        panel.add(removeItem);
        
        total = new JLabel(updateTotal(itemList));
        total.setFont(new Font("Tahoma", Font.PLAIN, 15));
        total.setBounds(382, 171, 101, 23);
        panel.add(total);
        
        totalLabel = new JLabel("Total:");
        totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totalLabel.setBounds(317, 171, 101, 23);
        panel.add(totalLabel);
        
        frame.repaint();
        frame.setVisible(true);
    }
 
    //Deals with all the actions performed when interacting with the GUI.
    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.print("action!");
    	
        if (e.getSource() == addItem)
        {
        	try
        	{
	        	String m = model.getText();
	        	double p = Double.valueOf(price.getText());
	        	int q = Integer.valueOf(quantity.getText());
	        	String ident = id.getText();
	        	
	        	if (ident.contains("r"))
	            {
	                Ram tempRam = new Ram(m, p, q, ident);
	                itemModel.add(itemModel.size(), tempRam);
	                itemList.add(tempRam);
	            }
	            else if (ident.contains("g"))
	            {
	                Gpu tempGpu = new Gpu(m, p, q, ident);
	                itemModel.add(itemModel.size(), tempGpu);
	                itemList.add(tempGpu);
	            }
	            else if (ident.contains("c"))
	            {
	                Cpu tempCpu = new Cpu(m, p, q, ident);
	                itemModel.add(itemModel.size(), tempCpu);
	                itemList.add(tempCpu);
	            }
	            else
	            {
	            	Misc tempMisc = new Misc(m, p, q, ident);
	            	itemModel.add(itemModel.size(), tempMisc);
	            	itemList.add(tempMisc);
	            }
	        	text.writeInvent(itemList);
	        	total.setText(updateTotal(itemList));
	        	clearText();
	        	
	        	frame.repaint();
        	}
        	catch (Exception ex) {
        		System.out.print("option was left open");
        	}
        }
        
        if (e.getSource() == editItem)
        {
        	Item selected = list.getSelectedValue();
        	
        	try
        	{	
	        	if (!model.getText().isBlank())
	        	{
	        		String m = model.getText();
	        		selected.setModel(m);
	        	}
	        	if (!price.getText().isBlank())
	        	{
	        		double p = Double.valueOf(price.getText());
	        		selected.setPrice(p);
	        	}
	        	if (!quantity.getText().isBlank())
	        	{
	        		int q = Integer.valueOf(quantity.getText());
	        		selected.setQuantity(q);
	        	}
	        	if (!id.getText().isBlank())
	        	{
	        		String ident = id.getText();
	        		selected.setId(ident);
	        	}
	        	
	        	System.out.println(itemList);
	        	text.writeInvent(itemList);
	        	total.setText(updateTotal(itemList));
	        	clearText();
	        	
	        	frame.repaint();
        	}
        	catch (Exception ex) {
        		System.out.print(ex);
        	}
        }
        
        if (e.getSource() == removeItem)
        {
        	try {
        		Item selected = list.getSelectedValue();
            	itemModel.removeElement(selected);
            	itemList.remove(selected);
				text.writeInvent(itemList);
				
				total.setText(updateTotal(itemList));
				
				frame.repaint();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
        }
        
    }
    
    private String updateTotal(ArrayList<Item> arr)
    {
    	double totalCount = 0.0;
    	
    	for (Item i : arr)
    	{
    		totalCount += i.getPrice() * i.getQuantity();
    	}
    	
    	return Double.toString(totalCount);
    }
    
    private void clearText()
    {
    	model.setText("");
    	price.setText("");
    	quantity.setText("");
    	id.setText("");
    }
}
