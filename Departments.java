import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Departments implements ActionListener
{
 JFrame f;
 JLabel id,l1,l2,l3;
 JButton b1,b2,b3;
 //public int key = 0;

public Departments()
 {
  f=new JFrame("Departments");
  f.setBackground(Color.red);
  f.setLayout(null);
  
  ImageIcon ima = new ImageIcon("logo5.png"); //sets icons of frame
  f.setIconImage(ima.getImage());

  ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/comp2.png"));
  Image im2 = im1.getImage().getScaledInstance(1400,700,Image.SCALE_DEFAULT);
  ImageIcon im3 = new ImageIcon(im2);
  JLabel lm1 = new JLabel(im3);
  lm1.setLayout(null);
  lm1.setBounds(0,0,1400,705);
  f.add(lm1);


  ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo5.png"));
  Image logo1 = logo.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
  ImageIcon logo2 = new ImageIcon(logo1);
  JLabel lo = new JLabel(logo2);
  lo.setLayout(null);
  lo.setBounds(630,250,100,100);
  lm1.add(lo);

  ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Development_1.jpg"));
  Image i2=i1.getImage().getScaledInstance(400,210,Image.SCALE_DEFAULT);
  ImageIcon i3=new ImageIcon(i2);
  JLabel l1=new JLabel(i3);
  l1.setBounds(70,100,410,220);
  lm1.add(l1);

b1=new JButton("Click to enter");
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.setBounds(200,350,150,40);
b1.addActionListener(this);
lm1.add(b1);

ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/Digital.jpeg"));
Image i5=i4.getImage().getScaledInstance(400,210,Image.SCALE_DEFAULT);
ImageIcon i6=new ImageIcon(i5);
JLabel l2=new JLabel(i6);
l2.setBounds(880,100,410,220);
lm1.add(l2);

b2=new JButton("Click to enter");
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.setBounds(1020,350,150,40);
b2.addActionListener(this);
lm1.add(b2);

ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/Testing_1.jpg"));
Image i8=i7.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);
ImageIcon i9=new ImageIcon(i8);
JLabel l3=new JLabel(i9);
l3.setBounds(490,425,410,220);
lm1.add(l3);

b3=new JButton("Click to enter");
b3.setBackground(Color.BLACK);
b3.setForeground(Color.WHITE);
b3.setBounds(600,645,150,30);
b3.addActionListener(this);
lm1.add(b3);

id=new JLabel();
id.setBounds(0,0,1360,750);
id.setLayout(null);

//JLabel lid=new JLabel("Departments in Company");
//lid.setBounds(255,20,1500,100);
//lid.setFont(new Font("serif",Font.PLAIN,70));
//lid.setForeground(Color.red);
//id.add(lid);

/*JLabel g=new JLabel("Development");
g.setBounds(170,120,300,40);
g.setFont(new Font("serif",Font.PLAIN,40));
g.setForeground(Color.black);
id.add(g);

JLabel g1=new JLabel("Digital Marketing");
g1.setBounds(810,120,300,40);
g1.setFont(new Font("serif",Font.PLAIN,40));
g1.setForeground(Color.black);
id.add(g1);

JLabel g2=new JLabel("Testing");
g2.setBounds(532,383,300,40);
g2.setFont(new Font("serif",Font.PLAIN,40));
g2.setForeground(Color.black);
id.add(g2);

id.add(b1);
lm1.add(id);
*/

//f.getContentPane().setBackground(Color.WHITE);
f.setVisible(true);
f.setSize(1360,750);
f.setLocation(0,0);
f.setDefaultCloseOperation(3);

/*
while(true)
{
 lo.setVisible(false);
try
{
 Thread.sleep(500);
}
catch(Exception e){}
lo.setVisible(true);
try
{
 Thread.sleep(500);
}
catch(Exception e){}
} */

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
  System.out.println("B1 is clicked");
  int key = 1;
  System.out.println(key);
  f.setVisible(false);
  new Project1();
}

if(ae.getSource()==b2)
{
  f.setVisible(false);
  int key = 2;
  Project2 p=new Project2();
  System.out.println("B2 is clicked");
}

if(ae.getSource()==b3)
{
  f.setVisible(false);
  int key = 3;
  Project3 p=new Project3();
  System.out.println("B3 is clicked");

}
}

/*public static void main(String[] args)
  {
   Departments f=new Departments();
  }*/
}