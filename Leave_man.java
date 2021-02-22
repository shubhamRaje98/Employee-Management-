import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class Leave_man implements ActionListener
{
	static JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6;
    static String status="Not Applicable";
    String ids,e_id;
    JButton b1,b2,b3,b4;
    JComboBox c1;

    public Leave_man()
    {
        
    	f=new JFrame("Apply for Leave");
        f.setBackground(Color.white);
        f.setLayout(null);

        Color mycolor = Color.decode("#add8e6");
        Color m = Color.decode("#FF0099");

        l1 = new JLabel();
        l1.setBounds(0,0,1370,740);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/leave.png"));
        Image i = i1.getImage().getScaledInstance(1370,740,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i);
        l1.setIcon(i3);
        f.add(l1);

        l2 = new JLabel("Enter Your Name : ");
        l2.setBounds(450,70,300,40);
        l2.setFont(new Font("Harrington",Font.BOLD,20));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
 
        t1 = new JTextField();
        t1.setBounds(680,75,200,30);
        t1.setBorder(null);
        l1.add(t1);

        l3 = new JLabel("Number of day's : ");
        l3.setBounds(450,150,300,40);
        l3.setFont(new Font("Harrington",Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        t2 = new JTextField();
        t2.setBounds(680,153,100,30);
        t2.setBorder(null);
        l1.add(t2);

        l4 = new JLabel("From : ");
        l4.setBounds(450,230,200,30);
        l4.setFont(new Font("Harrington",Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        l4.setBorder(null);
        l1.add(l4);

        t3 = new JTextField("YYYY-MM-DD");
        t3.setBounds(540,230,100,30);
        t3.setBorder(null);
        l1.add(t3);

        l5 = new JLabel("To : ");
        l5.setBounds(680,230,200,30);
        l5.setFont(new Font("Harrington",Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        l5.setBorder(null);
        l1.add(l5);

        t4 = new JTextField("YYYY-MM-DD");
        t4.setBounds(740,230,100,30);
        t4.setBorder(null);
        l1.add(t4);

        l6 = new JLabel("Post :");
        l6.setBounds(850,150,200,30);
        l6.setFont(new Font("Harrington",Font.BOLD,20));
        l6.setForeground(Color.BLACK);
        l6.setBorder(null);
        l1.add(l6);
 
        t5 = new JTextField();
        t5.setBounds(940,150,100,30);
        t5.setBorder(null);
        l1.add(t5);

      /*  l7 = new JLabel("Emp_ID : ");
        l7.setBounds(70,70,200,40);
        l7.setFont(new Font("Harrington",Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);

        t6 = new JTextField();
        t6.setBounds(200,75,100,30);
        t6.setBorder(null);
        l1.add(t6);
      */
       /* l9 = new JLabel(stat);
        l9.setBounds(1170,70,200,40);
        l9.setFont(new Font("Harrington",Font.BOLD,20));
        l9.setForeground(Color.BLACK);
        l1.add(l9); */

        b1=new JButton("Apply");
        b1.setBounds(450,360,150,50);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(mycolor);
        b1.setForeground(m);    
        b1.setFocusPainted(false);
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("Cancle");
        b2.setBounds(750,360,150,50);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(mycolor);
        b2.setForeground(m);    
        b2.setFocusPainted(false);
        b2.addActionListener(this);
        l1.add(b2);

        //*******************************
        try {
            
            conn con = new conn();
            String str = "select emp_id from employee";
            ResultSet rs = con.s.executeQuery(str);

            Vector v = new Vector();

            while (rs.next()) {

                ids = rs.getString(1);

                v.add(ids);

            }

            c1 = new JComboBox(v);
            c1.addActionListener(this);

            c1.setBounds(20,70,220,30);

 

            l1.add(c1);

            //rs.close();

        } catch (Exception e) {
            System.out.println("Exception!");

        }
        //**************************************

        //********************
       
 //****************************
       //    System.out.println(e_id);
       /*l8 = new JLabel("Leave Status : ");
        l8.setBounds(950,70,200,40);
        l8.setFont(new Font("Harrington",Font.BOLD,20));
        l8.setForeground(Color.BLACK);
        l1.add(l8);*/

        f.setVisible(true);
        f.setDefaultCloseOperation(3);
      //  f.setResizable(false);
        f.setSize(1370,740);
        f.setLocation(0,0);

    }


    public void actionPerformed(ActionEvent ae)
    {
        String bb = t1.getText();
        String c = t5.getText();
        String d = t2.getText();
        String e = t3.getText();
        String ff = t4.getText(); 
        
        if(ae.getSource()==c1){
            //f.setVisible(false);
            JComboBox cb = (JComboBox)ae.getSource();
            //String id = (String)cb.getSelectedItem();
            e_id = (String)cb.getSelectedItem();
            System.out.println(e_id + "is employeeId");
            try{ 
             System.out.println(e_id);   
             conn con = new conn();
             String str = "select L_status from leaveData where emp_id = '"+e_id+"'";
             ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){
               
                status = rs.getString("L_status");
                
            }
            JOptionPane.showMessageDialog(null,"Your Leave Status is : "+status);
            status = "Not Applicable";
        }catch(Exception ce){
            ce.printStackTrace();
        }
        System.out.println(status+" is status"); 

        }
        //String a=e_id;
        
        if(ae.getSource() == b1)
        {
            try{
                conn cc = new conn();
                String q = "insert into leaveData(emp_id,name,post,numD,fromD,toD) values('"+e_id+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
            
        }

    }    
    public static void main(String args[])
    {
    	new Leave_man();
        f.validate();
    }



}