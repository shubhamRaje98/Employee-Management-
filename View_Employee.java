import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;   
import java.sql.*;
import java.util.Vector;

class View_Employee implements ActionListener{

    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;
    String ids;
    JComboBox c1;
    String str;

    View_Employee(){
        f=new JFrame("View");
        f.setBackground(Color.green);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/view.png"));
        l1.setIcon(img);


        l2=new JLabel("Employee Id : ");
        l2.setVisible(true);
        l2.setBounds(10,60,250,30);
        l2.setForeground(Color.white);
        Font F1 = new Font("serif",Font.BOLD,30);
        l2.setFont(F1); 
        l1.add(l2);
        f.add(l1);


        /*t=new JTextField();
        t.setBounds(250,60,220,30);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
        t.setBorder(border);
        l1.add(t); */
        
        b=new JButton("Search");
        b.setBounds(100,150,100,30);
        b.addActionListener(this);
        l1.add(b);

        try {
            
            conn con = new conn();
            
            str = "select emp_id from employee";

            /*else if(key == 2)
            {
               str = "select emp_id from employee where Dept_name='Digital Marketing'";
            }
            else if(key == 3)
            {
               str = "select emp_id from employee where Dept_name='Software Testing'";
            } */
            ResultSet rs = con.s.executeQuery(str);

            Vector v = new Vector();

            while (rs.next()) {

                ids = rs.getString(1);

                v.add(ids);

            }

            c1 = new JComboBox(v);
            c1.addActionListener(this);

            c1.setBounds(240, 60, 220, 35);

 

            l1.add(c1);

            //rs.close();

        } catch (Exception e) {
            System.out.println("Exception!"+e);
            //System.out.println(key);

        }

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l1.add(b2);
        f.setDefaultCloseOperation(3); 
        f.setSize(500,270);
        f.setLocation(450,250);
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
            Print_Data p=new Print_Data((String)cb.getSelectedItem());
        }

    }

    public static void main(String[]ar){
        View_Employee v=new View_Employee();
    }
}   