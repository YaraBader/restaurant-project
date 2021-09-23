package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Bill extends JFrame {
    JLabel label1 ,label2 ,label3;
    JTextArea ta;
    JTextField tf1 , tf2 ,tf3;
    JPanel panel0,panel1  ,panel2 , panel3 , panel4;
    Bill()
    {
        super("Order Bill");
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("back.jpg"))));
        panel0 = new JPanel();
        panel0.setLayout(null);
        panel0.setBounds(50, 50, 500, 500);
        
        label1 =new JLabel("name of Emplyee :"); 
        label1.setFont(new Font("Dialog", Font.BOLD, 20));
        label1.setBounds(60, 30, 200, 70);
        tf1 = new JTextField(22);
        tf1.setBounds(250, 55, 200, 25);
        
        label2 =new JLabel("ID of Emplyee :");  
        label2.setFont(new Font("Dialog", Font.BOLD, 20));
        label2.setBounds(60, 90, 200, 70);
        tf2 = new JTextField(23);
        tf2.setBounds(250, 115, 200, 25);
        

        label3 =new JLabel("NO of Order :");  
        label3.setFont(new Font("Dialog", Font.BOLD, 20));
        label3.setBounds(60, 150, 200, 70);
        tf3 = new JTextField(23);
        tf3.setBounds(250, 175, 200, 25);

        panel0.add(label1 );
        panel0.add(tf1);
        panel0. add(label2);
        panel0. add(tf2);
        panel0. add(label3);
        panel0. add(tf3);
    
        panel0.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), " Order Summery"));
        
        ta = new JTextArea();
        ta.setEditable(false);
        ta.setBounds(60, 220, 380, 200);
        ta.setFont(new Font("SansSerif",Font.PLAIN,20));
        panel0.add(ta);
        
        add(panel0);
        Welcome newWel ;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000,900);
        panel0.setBackground(Color.GRAY);
  
        JButton buttonExit = new JButton("done");
        buttonExit.setBackground(Color.LIGHT_GRAY);
        buttonExit.setForeground(Color.red);
        buttonExit.setMnemonic(KeyEvent.VK_C);
        buttonExit.setBounds(220,600, 144, 55);
        add(buttonExit);
        buttonExit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            String query = "SELECT * FROM bill ORDER by OrderNO DESC LIMIT 1 ";
            con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Order","root","may12345"); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                int OrderNO = rs.getInt(1);
                int id =rs.getInt(2);
                String name=rs.getString(3);
                int noOfChicken= rs.getInt(4);
                int noOfBeef=rs.getInt(5);
                int noOfFish=rs.getInt(6);
                int noOfFries=rs.getInt(7);
                String takeAway=rs.getString(8);
                
                tf1.setText(name);
                tf2.setText(""+id);
                tf3.setText(""+OrderNO);
                ta.append("\n"+"   Chicken Burger: "+noOfChicken+"\n"+"   Beef Burger : "+noOfBeef+"\n"+"   Fish Burger "+noOfFish+"\n"+"   Fries :"+
                    noOfFries+"\n   Order Status: "+takeAway+"\n   Thank you...");
            }
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    Welcome newWel;
    
}
