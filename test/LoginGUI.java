package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.account.*;

public class LoginGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel userLabel, passwordLabel, success;
    private JTextField userText;
    private JButton button;
    private JPasswordField passwordText;
    private Login l = new Login();

    public LoginGUI() {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165 ,25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.repaint();
        frame.setVisible(true);
        
    }

    public static void main(String[] args)
    {
        new LoginGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();

        System.out.print(user + ", " + password);
        
        l.LogIn(user, password);
    }
}
