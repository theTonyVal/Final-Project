package src.GUIs;

import javax.swing.*;

import src.main.*;
import src.item.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainGUI implements ActionListener{
    
    private ArrayList<item> itemList = new ArrayList<item>();
    private inventory inv = new inventory(itemList);
    
    private JFrame frame;
    private JPanel panel;
    private JLabel modelLabel;
    private JLabel modelLabel_1;
    private JLabel modelLabel_2;
    private JLabel modelLabel_3;

    public MainGUI() throws IOException
    {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(panel);

        panel.setLayout(null);

        itemList = inv.read();
        System.out.println(itemList);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 85, 764, 120);
        panel_1.setLayout(null);
        panel.add(panel_1);
        
        modelLabel = new JLabel(itemList.get(0).model());
        modelLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel.setLocation(292, 40);
        modelLabel.setSize(108, 32);
        panel_1.add(modelLabel);
        
        modelLabel_1 = new JLabel(Double.toString(itemList.get(0).price()));
        modelLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_1.setBounds(449, 42, 85, 29);
        panel_1.add(modelLabel_1);
        
        modelLabel_2 = new JLabel(Integer.toString(itemList.get(0).quantity()));
        modelLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_2.setBounds(626, 39, 85, 35);
        panel_1.add(modelLabel_2);
        
        modelLabel_3 = new JLabel(itemList.get(0).id());
        modelLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_3.setBounds(174, 40, 108, 32);
        panel_1.add(modelLabel_3);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBounds(10, 216, 764, 120);
        panel.add(panel_1_1);
        
        JLabel modelLabel_4 = new JLabel(itemList.get(1).model());
        modelLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_4.setBounds(292, 40, 108, 32);
        panel_1_1.add(modelLabel_4);
        
        JLabel modelLabel_1_1 = new JLabel(Double.toString(itemList.get(1).price()));
        modelLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_1_1.setBounds(449, 42, 85, 29);
        panel_1_1.add(modelLabel_1_1);
        
        JLabel modelLabel_2_1 = new JLabel(Integer.toString(itemList.get(1).quantity()));
        modelLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_2_1.setBounds(626, 39, 85, 35);
        panel_1_1.add(modelLabel_2_1);
        
        JLabel modelLabel_3_1 = new JLabel(itemList.get(1).id());
        modelLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_3_1.setBounds(174, 40, 108, 32);
        panel_1_1.add(modelLabel_3_1);
        
        JPanel panel_1_2 = new JPanel();
        panel_1_2.setLayout(null);
        panel_1_2.setBounds(10, 348, 764, 120);
        panel.add(panel_1_2);
        
        JLabel modelLabel_5 = new JLabel(itemList.get(2).model());
        modelLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_5.setBounds(292, 40, 108, 32);
        panel_1_2.add(modelLabel_5);
        
        JLabel modelLabel_1_2 = new JLabel(Double.toString(itemList.get(2).price()));
        modelLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_1_2.setBounds(449, 42, 85, 29);
        panel_1_2.add(modelLabel_1_2);
        
        JLabel modelLabel_2_2 = new JLabel(Integer.toString(itemList.get(2).quantity()));
        modelLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_2_2.setBounds(626, 39, 85, 35);
        panel_1_2.add(modelLabel_2_2);
        
        JLabel modelLabel_3_2 = new JLabel(itemList.get(2).id());
        modelLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        modelLabel_3_2.setBounds(174, 40, 108, 32);
        panel_1_2.add(modelLabel_3_2);

        frame.repaint();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
