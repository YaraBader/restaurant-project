package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JFrame{
    
    private JLabel  label1;
    private JButton button1;
    
    public Welcome() {
        super("Burger Resturant");
        setLayout(new FlowLayout());
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("back.jpg"))));
        
        label1 = new JLabel("Welcome to Burger Resturant");
        label1.setBounds(135, 188, 600, 66);
        label1.setFont(new Font("Serif", Font.BOLD, 44));//88 الخط  
        label1.setForeground(Color.YELLOW);
        add(label1);

        button1 = new JButton("Menu");
        button1.setBounds(250, 333, 144, 55);
        button1.setBackground(Color.YELLOW );// لون الزر
        button1.setForeground(Color.red);//خط الزر
        add(button1);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        setVisible(true);
    
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
                new  Order();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
    
}
