import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Project2 implements ActionListener
{
JFrame f;
JLabel l1,l2,id;
JButton b1,b2,b3;
public Project2()
{
f=new JFrame("Project");
//f.setBackground(Color.red);
f.setLayout(null);

Color mycolor = Color.decode("#D3D3D3");

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/social.png"));
Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel l1=new JLabel(i3);

l1.setBounds(70,175,510,310);
f.add(l1);

b1=new JButton("Manage Employee");
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);

b1.setBounds(190,490,250,40);
b1.addActionListener(this);
f.add(b1);

JLabel g=new JLabel("Social Media");
g.setBounds(220,140,300,40);
g.setFont(new Font("serif",Font.PLAIN,30));
g.setForeground(mycolor);
f.add(g);

ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/adver.jpg"));
Image i5=i4.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
ImageIcon i6=new ImageIcon(i5);
JLabel l2=new JLabel(i6);

l2.setBounds(680,175,510,310);
f.add(l2);

b2=new JButton("Manage Employee");
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);

b2.setBounds(798,490,250,40);
b2.addActionListener(this);
f.add(b2);

b3 = new JButton("Home");
b3.setBackground(mycolor);
b3.setForeground(Color.WHITE);
//b3.setBorder(new LineBorder(Color.BLACK));
b3.addActionListener(this);
b3.setBounds(1200,600,100,30);
f.add(b3);

JLabel g1=new JLabel("T.V Addvertise");
g1.setBounds(820,140,400,40);
g1.setFont(new Font("serif",Font.PLAIN,30));
g1.setForeground(mycolor);
f.add(g1);


JLabel lid=new JLabel("Projects Under Digital Department : ");
lid.setBounds(20,0,500,100);
lid.setFont(new Font("Harrington",Font.PLAIN,20));
lid.setForeground(Color.BLACK);
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
 new details();

}
if(ae.getSource()==b2)
{
 f.setVisible(false);
 new details();

}
if(ae.getSource()==b3)
{
	f.setVisible(false);
	new Departments();
}
}

/*public static void main(String[] args)
{
Project2 p=new Project2();
}*/
}