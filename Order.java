/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author may.th
 */
public class Order {
     JFrame f ;
    JLabel label1,label2,label3,label4;
    JTextField tf1,tf2,tf3;
    JComboBox cb1,cb2,cb3,cb4;
    JRadioButton rb1,rb2;
    ButtonGroup rg;
    JButton b1;
    JPanel p1,p2,p3; 
    String chiken,beef,fish,fries;
    
    Order(  )
    {
        f=new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        f.setTitle("Enter Order");
        
     f.setContentPane(new JLabel(new ImageIcon(getClass().getResource("back.jpg"))));
    TitledBorder titled1 = new TitledBorder("Name of employee");
    p1.setBorder(titled1); 
 titled1 .setTitleFont(new Font("Dialog", Font.BOLD, 20));//الخط 
    TitledBorder titled2 = new TitledBorder("Employee ID");
    p2.setBorder(titled2);
   titled2.setTitleFont(new Font("Dialog", Font.BOLD, 20));//88
    TitledBorder titled3 = new TitledBorder("Menu");
    titled3.setTitleFont(new Font("Dialog", Font.BOLD, 20));//88
    p3.setBorder(titled3);
    
       
    label1 = new JLabel("Chicken");
    Icon burger = new ImageIcon(getClass().getResource("ch.jpg"));//88
    label2 = new JLabel("Beef");
    Icon burger2 = new ImageIcon(getClass().getResource("be.jpg"));//88
    label3 = new JLabel("fish");
    Icon burger3 = new ImageIcon(getClass().getResource("fe.jpg"));//88
    label4 = new JLabel("Fried Fries");
     Icon burger4 = new ImageIcon(getClass().getResource("fr.jpg"));//88
    label1.setIcon(burger);//88
    label2.setIcon(burger2);//88
    label3.setIcon(burger3);//88
    label4.setIcon(burger4);//88
    tf1 = new JTextField(39);
    tf2 = new JTextField(39);
        
        String NoOfOrder[]={"0","1","2","3","4","5"};
        
        cb1=new JComboBox(NoOfOrder);
        cb2=new JComboBox(NoOfOrder);
        cb3=new JComboBox(NoOfOrder);
        cb4=new JComboBox(NoOfOrder);
        
        
        rb1 = new JRadioButton("Take Away");
        rb1.setForeground(Color.red);//لون الخط
        rb2 = new JRadioButton("In Restaurant");
        rb2.setForeground(Color.red);
    
        rg = new ButtonGroup();
    
        b1 = new JButton("add order");
        b1.setBounds(250, 333, 144, 55);
        b1.setForeground(Color.red);//خط الزر
        p1.add(tf1);
        p1.setBounds(150, 50, 500, 70);
        p2.setBounds(150, 130, 500, 70);
        p2.add(tf2);
        p3.setBounds(50, 220, 1000, 300);//88
        b1.setBounds(250,580,100,55);
  
        f.add(p1);
        f.add(p2);
        f.add(p3);
        
        p3.add(label1);
        p3. add(cb1);
  
        p3.add(label2);
        p3.add(cb2);
   
        p3.add(label3);
        p3.add(cb3);
    
        p3.add(label4);
        p3.add(cb4);

        rg.add(rb1);
        rg.add(rb2);
        p3.add(rb1);
        p3.add(rb2);

        f.add(b1);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1100,1000);
        f.setVisible(true);
        
        Color a=Color.YELLOW.darker();
        p1.setBackground(a);
        p2.setBackground(a);
        Color b=Color.GRAY.brighter();
        p3.setBackground(b);
        
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 
                
                if(e.getSource() == b1){
    try 
        {
            Connection con = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Order","root","may12345");

            PreparedStatement ps;
            ps = con.prepareStatement("INSERT INTO bill(OrderNO,id,name,noOfChicken ,noOfBeef ,noOfFish,noOfFries,takeAway) VALUES (?,?,?,?,?,?,?,?)");

            ps.setInt(1,0);
            ps.setString(3, tf1.getText());
            ps.setString(2, tf2.getText());
            
            chiken = cb1.getSelectedItem().toString();
            ps.setString(4, chiken);
            beef = cb2.getSelectedItem().toString();
            ps.setString(5, beef);
            fish = cb3.getSelectedItem().toString();
            ps.setString(6, fish);
            fries = cb4.getSelectedItem().toString();
            ps.setString(7, fries);
      
            String op = null ;
            
            if(rb1.isSelected())
            {
                op =rb1.getText()+"";
                ps.setString(8, op);
            }
            if(rb2.isSelected())
            {
            op =rb2.getText()+"";
            ps.setString(8, op);
            } 
            ps.executeUpdate();
            con.close();
            
            if(chiken=="0" && beef=="0" && fish=="0" && fries=="0"){
                JOptionPane.showMessageDialog(f, "Enter Order !!!!");
            }else{ new  Bill().setVisible(true);}
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        } 
         catch (ClassNotFoundException ex) {   
                        Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                }
               
            }
        });
    
        
    }
    
}
