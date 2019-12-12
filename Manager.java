import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;

public class Manager extends JFrame implements ActionListener { 
    Connection conn= Jconnection.conDB();
    JPanel p1,p2,p3;
    JButton update;
    JButton auto,back; 
    JTextField dateText; 
    JTable order;
    DefaultTableModel model = new DefaultTableModel();

    public Manager()
    {
        
       /*new changes we still show the orders but we will provide to an auto date updat button insted of  manually updating
        also change the layout of the window  
        copy paste the same methods getDateTime() and theQuery(String query) from pizzeria to update and get date*/
        
        p1= new JPanel();
        //DefaultTableModel model = new DefaultTableModel();
        order= new JTable(model);
        model.addColumn("order_placed_id");
        model.addColumn("branch_id");
        model.addColumn("ordertime");
        model.addColumn("food_ready");
        model.addColumn("customer_id");
        model.addColumn("delivery_address");
        model.addColumn("price");
        Statement st = null;
        ResultSet rs = null;
      try{
          
         st = conn.createStatement();
         rs= st.executeQuery("select * from order_placed");
         while(rs.next())
         {
             String OPid= rs.getString("order_placed_id");
             String Bid= rs.getString("branch_id");
             String ot= rs.getString("ordertime");
             String fr= rs.getString("food_ready");
             String Cid= rs.getString("customer_id");
             String da= rs.getString("delivery_address");
             String p= rs.getString("price");
             String[] contants={OPid,Bid,ot,fr,Cid,da,p};
             
             model.addRow(contants);
         }
         
          
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }


        
                
         JScrollPane sp=new JScrollPane(order); 
         order.setFillsViewportHeight(true);
        // p1.setBackground(new Color(255,51,51));
        p1.setBackground(new Color(255,255,204));
         p1.setLayout(new FlowLayout());
         p1.add(sp);
         
         //p2 is deleted 
         p2= new JPanel();
         dateText= new JTextField("Enter Date ",15);
         update = new JButton(" UPDATE ");
         p2.setBackground(new Color(255,255,204));
         p2.setLayout(new FlowLayout());
         //p2.add(dateText); p2.add(update); 
         
         //p3 
        p3= new JPanel();
        auto= new  JButton(" FOOD READY ");
        auto.addActionListener(this);
        back= new JButton(" BACK ");
        back.addActionListener(this);
        p3.setLayout(new FlowLayout());
        //add(auto,BorderLayout.CENTER);
        p3.setBackground(new Color(255,255,204));
        p3.add(auto);p3.add(back);
      
        
       
        
         setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0; gbc.gridy = 0; add(p1,gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(p2,gbc);
        gbc.gridx = 0; gbc.gridy = 3; add(p3,gbc);
        getContentPane().setBackground(new Color(255,255,204));  

        
    }
    
    
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()==auto)
         {
            /* int rowIndex = 0;
             int colIndex=0;
           if (order.getCellSelectionEnabled())
           {
               order.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                  rowIndex = order.getSelectedRow();
                  colIndex = order.getSelectedColumn();
           } 
              order.setValueAt(getDateTime(), rowIndex, colIndex);
           theQuery("update order_placed set food_ready = '"+getDateTime()+"'where order_placed_id = "+order.getValueAt(rowIndex, 1));*/
          

         }
         
         if(e.getSource()==update)
         {
             
         }
         
         if(e.getSource()==back)
         {
             welcome r= new welcome();
       r.setTitle("Lighting Pizza");
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                r.pack();
                r.setLocationRelativeTo(null);
		r.setVisible(true);
                dispose(); 
         }

     }
    
    
    
    
    /*public static void main(String[]args)
    {
        Manager  r= new Manager();
      
       r.setTitle("Lighting Pizza Manager ");
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                r.pack();
		r.setVisible(true);
                r.setBackground(new Color(255,51,51));
    }*/
    
    
    
    
    public String getDateTime()
     {
         String DT="";
         SimpleDateFormat sdt= new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
         Date date= new Date();
         DT= sdt.format(date);
         return DT; 
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
    
    
}
