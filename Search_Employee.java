import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class Search_Employee implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l,l5;
    JButton b,b2;
    String ids;
    JComboBox c1;

    Search_Employee(){
        f=new JFrame("search");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/view.png"));
        Image i = img.getImage().getScaledInstance(660,270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i);
        l5.setIcon(i3);


        l=new JLabel("Employee Id : ");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.white);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1); 
        l5.add(l);
        f.add(l5);

        /*t=new JTextField();
        t.setBounds(240,50,220,30);
        l5.add(t);*/

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l5.add(b);


        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        //**************************************************
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

            c1.setBounds(240, 50, 220, 30);

 

            l5.add(c1);

            //rs.close();

        } catch (Exception e) {
            System.out.println("Exception!");

        }

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==c1){
            f.setVisible(false);
            JComboBox cb = (JComboBox)ae.getSource();
            //String id = (String)cb.getSelectedItem();
            new Update_Employee((String)cb.getSelectedItem());
        }

    }
    
    public static void main(String[]ar){
        new Search_Employee();
    } 	
}