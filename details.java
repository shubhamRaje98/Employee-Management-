import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class details  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5;

    details(){
        f=new JFrame("Employee Detail");
        f.setBackground(Color.white);
        f.setLayout(null);
   
        Color mycolor = Color.decode("#BDB76B");
        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        Image i = i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i);
        l1.setIcon(i3);
        f.add(l1);

        l2 = new JLabel("Employee Details");
        l2.setBounds(250,20,300,40);
        l2.setFont(new Font("Harrington",Font.BOLD,20));
        Color m= Color.decode("#FF0099"); 
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        b1=new JButton("Add");
        b1.setBounds(140,100,150,60);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(mycolor);
        b1.setForeground(m);    
        b1.setFocusPainted(false);
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("View");
        b2.setBounds(420,100,150,60);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(mycolor);
        b2.setForeground(m);
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(140,210,150,60);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setForeground(m);
        b3.setBackground(mycolor);
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(420,210,150,60);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.setForeground(m); 
        b4.setBackground(mycolor);
        b4.addActionListener(this);
        l1.add(b4);
         
        b5=new JButton("Manage Leaves");
        b5.setBounds(260,320,180,60);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.setForeground(m); 
        b5.setBackground(mycolor);
        b5.addActionListener(this);
        l1.add(b5);

        f.setVisible(true);
        f.setResizable(false);
        f.setSize(700,500);
        f.setLocation(320,180);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_Employee();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new View_Employee();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Remove_Employee();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new Search_Employee();
        }
        if(ae.getSource()==b5){
            f.setVisible(false);
            new SearchLeave();
        }
    }

    public static void main(String[ ] arg){
        details d = new details();
    }
}