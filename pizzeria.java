import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class pizzeria extends JFrame implements ActionListener ,ItemListener
  {
    JPanel p1,p2,p3,p4; 
    JLabel title; // panles'layout is GridBagLayout 
    //p1 componants'layout is gridlayout 
    JLabel name,phone,address,email,city,branch;
    JTextField nameText,phoneText,addressText,emailText; 
    JComboBox b,c; 
    //p2 componants' layout is GridBagLayout 
    JLabel qty, item,pr1,pr2; //fist row 
    JLabel pepperoni,cheese,veg,chickenW,fries,soda,water; // items and catagories
    JTextField qp,qc,qv,qcw,qf,qs,qw;// textfild for quanty 
    JTextField p1p,p1c,p1v,p1cw,p1f,p1s,p1w; // for unit pric 
    JTextField p2p,p2c,p2v,p2cw,p2f,p2s,p2w; // sub totall 
    //p3 componants' layout is gridlayout 
    JLabel total, tax; 
    JTextField totalText,taxText; 
    JButton order , exit, clear, sum; 
    
    	
    Connection conn= Jconnection.conDB();
    ResultSet rs = null;
    PreparedStatement ps = null;
    String sql="";
     
    
    public pizzeria()
    {
       // p1
        p1= new JPanel();
        //p1.setSize(300, 300);
        name= new JLabel("Customer Name:");
        nameText= new JTextField(5); 
        phone= new JLabel("Customer Phone:");
        phoneText= new JTextField(5);
        address= new JLabel("Customer Address:");
        addressText= new JTextField(5); 
        email= new JLabel("Customer Email:");
        emailText= new JTextField(5);
        city= new JLabel("Choose your City:");
        c= new JComboBox();
        sql="select * from city";// popultion for the city combobox
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                c.addItem(rs.getString("city_name"));
            }
        }
        catch(Exception ex){}
        c.addItemListener(this);
      
        branch= new JLabel("Choose nearest Branch:");
        b= new JComboBox();
        p1.setLayout(new GridLayout(3,9));
        p1.add(name); p1.add(nameText);
        p1.add(phone);p1.add(phoneText);
        p1.add(address);p1.add(addressText);
        p1.add(email);p1.add(emailText);
        p1.add(city);p1.add(c);
        p1.add(branch);p1.add(b);
        
        //p2 
        //labels
        p2= new JPanel(); 
        qty= new JLabel(" Qty  ");
        item= new JLabel(" Menu ");
        pr1= new JLabel(" Unit Price ");
        pr2= new JLabel(" Sub Total");
        pepperoni= new JLabel("Pepperoni ");
        cheese= new JLabel("Cheese");
        veg=  new JLabel("Vegetable ");
        chickenW= new JLabel("Chicken Wings");
        fries= new JLabel("Fries");
        soda= new JLabel("Soda");
        water= new JLabel("water");
       
        // textfield for Q 
        qp= new JTextField(2); 
        qc= new JTextField(2); 
        qv= new JTextField(2); 
        qcw= new JTextField(2);
        qf= new JTextField(2); 
        qs= new JTextField(2); 
        qw= new JTextField(2);
        
         // textfield for unit price  
        p1p= new JTextField(3); 
        p1c= new JTextField(3); 
        p1v= new JTextField(3); 
        p1cw= new JTextField(3);
        p1f= new JTextField(3); 
        p1s= new JTextField(3); 
        p1w= new JTextField(3);
        
         // textfield for sub price  
        p2p= new JTextField(3); 
        p2c= new JTextField(3); 
        p2v= new JTextField(3); 
        p2cw= new JTextField(3);
        p2f= new JTextField(3); 
        p2s= new JTextField(3); 
        p2w= new JTextField(3);
        // adding everthing to the panel
        p2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0; gbc.gridy = 0; p2.add(item,gbc);gbc.gridx = 1; gbc.gridy = 0; p2.add(qty,gbc);
        gbc.gridx = 2; gbc.gridy = 0; p2.add(pr1,gbc); gbc.gridx = 3; gbc.gridy = 0; p2.add(pr2,gbc);
        gbc.gridx = 0; gbc.gridy = 2; p2.add(pepperoni,gbc);gbc.gridx = 1; gbc.gridy = 2; p2.add(qp,gbc);//1
        gbc.gridx = 2; gbc.gridy = 2; p2.add(p1p,gbc);gbc.gridx = 3; gbc.gridy = 2; p2.add(p2p,gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; p2.add(cheese,gbc);gbc.gridx = 1; gbc.gridy = 3; p2.add(qc,gbc);//2
        gbc.gridx = 2; gbc.gridy = 3; p2.add(p1c,gbc);gbc.gridx = 3; gbc.gridy = 3; p2.add(p2c,gbc);
        
        gbc.gridx = 0; gbc.gridy = 4; p2.add(veg,gbc);gbc.gridx = 1; gbc.gridy = 4; p2.add(qv,gbc);//3
        gbc.gridx = 2; gbc.gridy = 4; p2.add(p1v,gbc);gbc.gridx = 3; gbc.gridy = 4; p2.add(p2v,gbc);
        
        gbc.gridx = 0; gbc.gridy = 5; p2.add(chickenW,gbc);gbc.gridx = 1; gbc.gridy = 5; p2.add(qcw,gbc);//4
        gbc.gridx = 2; gbc.gridy = 5; p2.add(p1cw,gbc);gbc.gridx = 3; gbc.gridy = 5; p2.add(p2cw,gbc);
        
        gbc.gridx = 0; gbc.gridy = 6; p2.add(fries,gbc);gbc.gridx = 1; gbc.gridy = 6; p2.add(qf,gbc);//5
        gbc.gridx = 2; gbc.gridy = 6; p2.add(p1f,gbc);gbc.gridx = 3; gbc.gridy = 6; p2.add(p2f,gbc);
        
        gbc.gridx = 0; gbc.gridy = 7; p2.add(soda,gbc);gbc.gridx = 1; gbc.gridy = 7; p2.add(qs,gbc);//6
        gbc.gridx = 2; gbc.gridy = 7; p2.add(p1s,gbc);gbc.gridx = 3; gbc.gridy = 7; p2.add(p2s,gbc);
        
        gbc.gridx = 0; gbc.gridy = 8; p2.add(water,gbc);gbc.gridx = 1; gbc.gridy = 8; p2.add(qw,gbc);//7
        gbc.gridx = 2; gbc.gridy = 8; p2.add(p1w,gbc);gbc.gridx = 3; gbc.gridy = 8; p2.add(p2w,gbc); 
        
        //p3
        p3=new JPanel();
        tax= new JLabel("Tax paid");
        total= new JLabel("Total Price");
        taxText=new JTextField(4);
        totalText=new JTextField(4);
        order= new JButton(" Order ");
        order.addActionListener(this);
        exit=new JButton(" Exit ");
        exit.addActionListener(this);
        clear=new JButton(" Clear ");
        clear.addActionListener(this);
        sum=new JButton(" Sum Up ");
        sum.addActionListener(this);
        p3.setLayout(new GridLayout(4,2));
        p3.add(tax);p3.add(taxText);
        p3.add(total);p3.add(totalText);
        p3.add(clear);p3.add(exit);
        p3.add(sum);p3.add(order);
        // p4 
          p4= new JPanel();
         title= new JLabel();
         title.setIcon(new ImageIcon("C:/Users/DELL/Documents/NetBeansProjects/orderSystem/src/PizzaLogo2.png"));
         p4.setLayout(new BorderLayout());
         p4.add(title,BorderLayout.CENTER);

        
        //adding everything to the frame
        setLayout(new BorderLayout());
        Border RedBorder1 = new LineBorder(Color.RED);
        p1.setBorder(BorderFactory.createTitledBorder(RedBorder1,"Customer information "));
        p2.setBorder(BorderFactory.createTitledBorder(RedBorder1,"Menu"));
        p3.setBorder(BorderFactory.createTitledBorder(RedBorder1,"Order Summary"));
        
        
        p1.setBackground(new Color(255,255,204));
        p2.setBackground(new Color(255,255,204));
        p3.setBackground(new Color(255,255,204));
        p4.setBackground(new Color(255,255,204));
        
        
       
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
        add(p3,BorderLayout.EAST);
        add(p4,BorderLayout.CENTER);
        
        


    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exit)
		{
			System.exit(0);
        

		} 
         if(e.getSource()==clear)
		{
			nameText.setText(" ");
			phoneText.setText(" ");
			addressText.setText(" ");
			emailText.setText(" ");
                        taxText.setText(" ");
			totalText.setText(" ");
			qp.setText(" ");p1p.setText(" ");p2p.setText(" ");
                        qc.setText(" ");p1c.setText(" ");p2c.setText(" ");
                        qv.setText(" ");p1v.setText(" ");p2v.setText(" ");
                        qcw.setText(" ");p1cw.setText(" ");p2cw.setText(" ");
                        qf.setText(" ");p1f.setText(" ");p2f.setText(" ");
                        qs.setText(" ");p1s.setText(" ");p2s.setText(" ");
                        qw.setText(" ");p1w.setText(" ");p2w.setText(" ");
                        
                } 
          
          if(e.getSource()==sum)
          { 
           //double t,u,s=0;
           double ordersum=0;
           int q;
              // calcutation there is no just retival of the items prices and cal culation might ne a function for easy cal
              if (!qp.getText().isEmpty())
              {
                  double u1=getUnitPrice("Pepperoni");
                  p1p.setText(Double.toString(u1));
                  int q1=Integer.parseInt(qp.getText());
                  double s1=subPrice(q1,u1);
                  p2p.setText(Double.toString(s1));
                   ordersum=ordersum+s1;
              } 
               if (!qc.getText().isEmpty())
              {
                  double u2=getUnitPrice("Cheese");
                  p1c.setText(Double.toString(u2));
                  int q2=Integer.parseInt(qc.getText());
                  double s2=subPrice(q2,u2);
                  p2c.setText(Double.toString(s2));
                   ordersum=ordersum+s2;
              }
               if (!qv.getText().isEmpty())
              {
                  double u3=getUnitPrice("Vegetable");
                  p1v.setText(Double.toString(u3));
                  int q3=Integer.parseInt(qv.getText());
                  double s3=subPrice(q3,u3);
                  p2v.setText(Double.toString(s3));
                   ordersum=ordersum+s3;
              } 
               if (!qcw.getText().isEmpty())
              {
                  double u4=getUnitPrice("Chicken Wings");
                  p1cw.setText(Double.toString(u4));
                  int q4=Integer.parseInt(qcw.getText());
                  double s4=subPrice(q4,u4);
                  p2cw.setText(Double.toString(s4));
                   ordersum=ordersum+s4;
              }
               if (!qf.getText().isEmpty())
              {
                  double u5=getUnitPrice("Fries");
                  p1f.setText(Double.toString(u5));
                  int q5=Integer.parseInt(qf.getText());
                  double s5=subPrice(q5,u5);
                  p2f.setText(Double.toString(s5));
                   ordersum=ordersum+s5;
              }
               if (!qs.getText().isEmpty())
              {
                  double u6=getUnitPrice("Soda");
                  p1s.setText(Double.toString(u6));
                  int q6=Integer.parseInt(qs.getText());
                  double s6=subPrice(q6,u6);
                  p2s.setText(Double.toString(s6));
                   ordersum=ordersum+s6;
              }
               if (!qw.getText().isEmpty())
              {
                  double u7=getUnitPrice("Water");
                  p1w.setText(Double.toString(u7));
                  int q7=Integer.parseInt(qw.getText());
                  double s7=subPrice(q7,u7);
                  p2w.setText(Double.toString(s7));
                   ordersum=ordersum+s7;
              } 
               DecimalFormat df2 = new DecimalFormat("#.##");
               double totalT=totalwTax(ordersum);
                totalText.setText(df2.format(totalT));
                double taxPaid=taxP(totalT,ordersum);
                
                taxText.setText(df2.format(taxPaid));
             
          }
          if(e.getSource()==order)
          {
              // inserting the customer info first id(auto gen in DB)-name-phone-address-email
              try{
             theQuery("insert into customer (name,phone,address,email) values('"+nameText.getText()+"','"+phoneText.getText()+"','"+addressText.getText()+"','"+emailText.getText()+"')");
         }
         catch(Exception ex){}
              // inserting order placed table order placed id(auto)- branch id- ordertime-food ready(null)-customer id -diell adrees-TotalP
              String cus= getCustomerId(nameText.getText());
              String br= getBranchId((String) b.getSelectedItem());//branch 
            
              try{
             theQuery("insert into order_placed (branch_id,ordertime,customer_id,delivery_address,price) values('"+br+"','"+getDateTime()+"','"+cus+"','"+addressText.getText()+"','"+totalText.getText()+"')");
         }
         catch(Exception ex){}
              
              // inserting order in table for the food order in id - order placed id- menu item id(multi value)-qty(multi value)- TotalP
              // if statement ot get the id of item and store it in a var same as the sum up in the end we add everything 
              String opId= getOrderPlacedId(cus);
              if (!qp.getText().isEmpty())
              {
                  String itemD=getmenuItemsId("Pepperoni");  //Pepperoni
                  try{
             theQuery("insert into order_in (order_placed_id,menu_items_id,quantity,sub_price) values('"+opId+"','"+itemD+"','"+qp.getText()+"','"+p2p.getText()+"')");
         }
         catch(Exception ex){}
              } 
               if (!qc.getText().isEmpty())
              {
                  String itemD=getmenuItemsId("Cheese");
                  try{
             theQuery("insert into order_in (order_placed_id,menu_items_id,quantity,sub_price) values('"+opId+"','"+itemD+"','"+qc.getText()+"','"+p2c.getText()+"')");
         }
         catch(Exception ex){}
              }
              
                if (!qv.getText().isEmpty())
              {
                  String itemD=getmenuItemsId("Vegetable");
                  try{
             theQuery("insert into order_in (order_placed_id,menu_items_id,quantity,sub_price) values('"+opId+"','"+itemD+"','"+qv.getText()+"','"+p2v.getText()+"')");
         }
         catch(Exception ex){}
              } 
               if (!qcw.getText().isEmpty())
              {
                  String itemD=getmenuItemsId("Chicken Wings");
                  try{
             theQuery("insert into order_in (order_placed_id,menu_items_id,quantity,sub_price) values('"+opId+"','"+itemD+"','"+qcw.getText()+"','"+p2cw.getText()+"')");
         }
         catch(Exception ex){}
              } 
                if (!qf.getText().isEmpty())
              {
                 String itemD=getmenuItemsId("Fries");
                  try{
             theQuery("insert into order_in (order_placed_id,menu_items_id,quantity,sub_price) values('"+opId+"','"+itemD+"','"+qf.getText()+"','"+p2f.getText()+"')");
         }
         catch(Exception ex){}
              } 
                 if (!qs.getText().isEmpty())
              {
                 String itemD=getmenuItemsId("Soda");
                  try{
             theQuery("insert into order_in (order_placed_id,menu_items_id,quantity,sub_price) values('"+opId+"','"+itemD+"','"+qs.getText()+"','"+p2s.getText()+"')");
         }
         catch(Exception ex){}
              } 
                  if (!qw.getText().isEmpty())
              {
                  String itemD=getmenuItemsId("Water");
                  try{
             theQuery("insert into order_in (order_placed_id,menu_items_id,quantity,sub_price) values('"+opId+"','"+itemD+"','"+qw.getText()+"','"+p2w.getText()+"')");
         }
         catch(Exception ex){}
              } 
               
              
               JOptionPane.showMessageDialog(null,"order complete you order number is "+cus);
               
               
               
          }
          
        
        
    } 
    
     public void itemStateChanged(ItemEvent event)
     {
         if(event.getSource()==c)
         {
             if(c.getSelectedItem().equals("Jubail"))
             { b.removeAllItems();
                 getBranch("1");}
             else if(c.getSelectedItem().equals("Dammam"))
             { b.removeAllItems();
                 getBranch("2");}
             else if(c.getSelectedItem().equals("riyadh"))
             { b.removeAllItems();
                 getBranch("3");}
    
         }
     } 
     
     public void getBranch(String id)
     {
          try{
           ps = conn.prepareStatement("select * from branch where city_id=?");
           ps.setString(1,id);
           rs = ps.executeQuery();
            while(rs.next())
            {
                b.addItem(rs.getString("address"));
            }
        }
        catch(Exception ex){}
     } 
     
     public double subPrice(int q,double up)
     {
         double sp= q*up;
         return sp; 
     }
    public double getUnitPrice (String item)
    {
         double uPrice = 0;
         try{
         Statement state= conn.createStatement();
         sql="select * from menu_items where name_item='"+item+"'";
         rs= state.executeQuery(sql);
         while(rs.next())
         {
             uPrice=rs.getDouble("price");
         }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
         
         return uPrice ;
    }
    
      public double totalwTax(double totalp)
      {
          double t= 1.03;
          double total= totalp*t;
          return total; 
      }
      public double taxP(double TwT, double totalp)
      {
          double tp= TwT-totalp;
          return tp;
      } 
     public void theQuery(String query)
     {
         Statement st = null;
      try{
          
          st = conn.createStatement();
          st.executeUpdate(query);
          //JOptionPane.showMessageDialog(null,"Query Executed");
          System.out.println("Done");
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
     } 
     
     public String getCustomerId(String name)
     { 
         String id="";
         try{
         Statement state= conn.createStatement();
         sql="select * from customer where name='"+name+"'";
         rs= state.executeQuery(sql);
         while(rs.next())
         {
             id=rs.getString("customer_id");
         }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
         return id;
     }
     
     public String getDateTime()
     {
         String DT="";
         SimpleDateFormat sdt= new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
         Date date= new Date();
         DT= sdt.format(date);
         return DT; 
     }
     
     public String getBranchId(String address)
     { 
         String id="";
         try{
         Statement state= conn.createStatement();
         sql="select * from branch where address='"+address+"'";
         rs= state.executeQuery(sql);
         while(rs.next())
         {
             id=rs.getString("branch_id");
         }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
         return id;
     }
     public String getOrderPlacedId(String customer)
     { 
         String id="";
         try{
         Statement state= conn.createStatement();
         sql="select * from  order_placed where customer_id='"+customer+"'";
         rs= state.executeQuery(sql);
         while(rs.next())
         {
             id=rs.getString("order_placed_id");
         }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
         return id;
     } 
     
     public String getmenuItemsId(String item)
     { 
         String id="";
         try{
         Statement state= conn.createStatement();
          sql="select * from menu_items where name_item='"+item+"'";
        ResultSet re= state.executeQuery(sql);
         while(re.next())
         {
             id=re.getString("menu_items_id");
         }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
         return id;
     }
     
     
     
                
   
}
