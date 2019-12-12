import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
public class welcome extends JFrame implements ActionListener {
    JPanel p1,p2,p3;
    // p1 componants 
    JLabel text,pic; 
    //p2 componats  
     JLabel text2,text3;    
    JTextField orderNum; 
    // p3 componants 
    JButton newOrder,showOder,manger; 
    Connection conn= Jconnection.conDB();
    public welcome()
    { 
        
        //conn=Jconnection.conDB();
       
        // p1 has the logo and some welcomming text
        p1= new JPanel();
        text= new JLabel("  Welcome To Lighting Pizza Where Is The Best Pizza   ");
        text.setForeground(Color.RED);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);
        pic= new JLabel();
        pic.setIcon(new ImageIcon("C:/Users/DELL/Documents/NetBeansProjects/orderSystem/src/PizzaLogo2.png"));
        pic.setHorizontalAlignment(JLabel.CENTER);
        p1.setLayout(new BorderLayout());
        p1.add(text,BorderLayout.CENTER); p1.add(pic,BorderLayout.NORTH); 
        p1.setBackground(new Color(255,255,204));
        // p2 has lable info about the button
        p2= new JPanel();
        text2= new JLabel("    Already ordered? Check on your order by");
        text2.setForeground(Color.RED);
        text2.setHorizontalAlignment(JLabel.CENTER);
        text2.setVerticalAlignment(JLabel.CENTER); //entering your order number below
        text3= new JLabel("    entering your order number below");
        text3.setForeground(Color.RED);
        text3.setHorizontalAlignment(JLabel.CENTER);
        text3.setVerticalAlignment(JLabel.CENTER); //
        orderNum= new JTextField(4);
        p2.setBackground(new Color(255,255,204));
        p2.setLayout(new GridLayout(3,1));
        p2.add(text2);
        p2.add(text3);
        p2.add(orderNum);
        
       //p3
        p3= new JPanel();
        newOrder=new JButton(" New Order ");
        newOrder.addActionListener(this);
        showOder=new JButton(" Show Order ");
        showOder.addActionListener(this);
        manger= new JButton(" Go To Manager ");
        manger.addActionListener(this);
        p3.setLayout(new GridLayout(1,2));
        p3.add(showOder); p3.add(newOrder);
        p3.add(manger); 
        p3.setBackground(new Color(255,255,204));
        
        //adding panels to frame 
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
        
        
    }
     ResultSet rs = null;
     PreparedStatement ps = null;
   public void actionPerformed(ActionEvent e)
   {
        if(e.getSource()==newOrder)
        {
            
       pizzeria p= new pizzeria();
      
       p.setTitle("Lighting Pizza");
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//p.setSize(480,400);
                p.pack();
                p.setLocationRelativeTo(null);
		p.setVisible(true);
                dispose();
        } 
        
        if(e.getSource()==showOder)
        {
             String fr="";
             try{
           ps = conn.prepareStatement("select * from order_placed where customer_id=?");
           //ps.setString(5,orderNum.getText());
           ps.setString(1,orderNum.getText());
           rs = ps.executeQuery();
           
           while(rs.next())
           {
               fr=rs.getString("food_ready");  
           }
           if(!fr.isEmpty())
                   JOptionPane.showMessageDialog(null, "your order is ready and it's on the way ");
              
                   
           }catch(Exception ex){
              //JOptionPane.showMessageDialog(null, ex.getMessage());
              JOptionPane.showMessageDialog(null,"sorry, your order is not ready yet ");
           }
                     } 
        
                if(e.getSource()==manger)
                {
                    String user = JOptionPane.showInputDialog(null, "user");
		String password = JOptionPane.showInputDialog(null, "password");

		if ("Manager".equals(user) && "pizza".equals(password)) {
                Manager  r= new Manager();
                r.setTitle("Lighting Pizza Manager ");
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                r.pack();
                r.setLocationRelativeTo(null);
		r.setVisible(true);
                dispose();

		}else {
			JOptionPane.showMessageDialog(null, "login failed");
		}
                }

        
        
   }
    public static void main(String[]args)
    {
      
        welcome r= new welcome();
       r.setTitle("Lighting Pizza");
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                r.pack();
                r.setLocationRelativeTo(null);
		r.setVisible(true);
                
                
    }
}
