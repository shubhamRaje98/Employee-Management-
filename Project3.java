import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Project3 implements ActionListener
{
JFrame f;
JLabel l1,l2,id;
JButton b1,b2,b3;
public Project3()
{
f=new JFrame("Project");
f.setBackground(Color.red);
f.setLayout(null);

Color mycolor1 = Color.decode("#D3D3D3");


ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Testing.jpg"));
Image i2=i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel l1=new JLabel(i3);

l1.setBounds(300,115,720,520);
f.add(l1);

b1=new JButton("Manage Employee");
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);

b1.setBounds(553,630,250,40);
b1.addActionListener(this);
f.add(b1);

b3 = new JButton("Home");
b3.setBackground(mycolor1);
b3.setForeground(Color.WHITE);
//b3.setBorder(new LineBorder(Color.BLACK));
b3.addActionListener(this);
b3.setBounds(1200,600,100,30);
f.add(b3);
/*JLabel g=new JLabel("Testing for all kind of projects");
g.setBounds(400,120,550,40);
g.setFont(new Font("serif",Font.PLAIN,40));
g.setForeground(Color.red);
f.add(g);*/
Color mycolor = Color.decode("#D3D3D3");
JLabel lid=new JLabel("Projects in Testing Department");
lid.setBounds(150,20,1500,100);
lid.setFont(new Font("serif",Font.PLAIN,70));
lid.setForeground(mycolor);
f.add(lid);

Color background = Color.decode("#b19cd9");
f.getContentPane().setBackground(background);
f.setVisible(true);
f.setSize(1360,750);
f.setLocation(0,0);
f.setDefaultCloseOperation(3);

/*while(true){
lid.setVisible(false);
try{
Thread.sleep(500);
}
catch(Exception e){}
lid.setVisible(true);
try{
Thread.sleep(500);
}
catch(Exception e){}

}*/
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
 f.setVisible(false);
 //login l=new login();
 new details();

}
if(ae.getSource() == b3)
{
	f.setVisible(false);
	new Departments();
}

}

/*public static void main(String[] args)
{
Project3 p=new Project3();
}*/
}