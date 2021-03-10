package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    private int c = 0;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    public GUI() {

        frame = new JFrame();

        JButton button = new JButton("Click me");
        button.addActionListener(this);

        label = new JLabel("Number of clicks: 0");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test");
        frame.repaint();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c++;
        label.setText("Number of clicks: " + c);
    }

}