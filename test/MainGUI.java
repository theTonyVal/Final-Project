package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.account.*;

public class MainGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel searchLabel;
    private JTextField userText;
    private JButton button;

    public MainGUI() {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

        searchLabel = new JLabel("Search");
        searchLabel.setBounds(10, 20, 100, 25);
        panel.add(searchLabel);

        userText = new JTextField(80);
        userText.setBounds(70, 20, 200, 25);
        panel.add(userText);

        button = new JButton("Search");
        button.setBounds(300, 20, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        frame.repaint();
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        new MainGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String search = userText.getText().strip();
        
        if (search.trim().equals(""))
            System.out.println("Enter something into textfield to search");
        else
            System.out.println(search);
        
    }
}


