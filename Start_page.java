//package employee;
//import Employee.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;


public class Start_page
{
	public static void main(String[] args)
	{
        new Page();
	}
}

class Page implements ActionListener
{
	JFrame f; 
	JLabel l1,id;
	JButton b,b1,b2;
	public Page()
	{
		f = new JFrame("EMS | Welcome");
		//f.setBackground(Color.blue);
		f.setResizable(false);
		f.setLayout(null);
       
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/comp2.png"));
		Image i2 = i1.getImage().getScaledInstance(1400,700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setLayout(null);
		l1.setBounds(0,0,1400,705);
		f.add(l1);

		ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo5.png"));
		Image logo1 = logo.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon logo2 = new ImageIcon(logo1);
		JLabel lo = new JLabel(logo2);
		lo.setLayout(null);
		lo.setBounds(630,250,100,100);
		l1.add(lo);

		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/continue.png"));
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp2.png"));

	//	JLabel l2 = new JLabel();
	//	l2.setBounds(0,0,1400,750);
       // l1.add(l2);
       // b1 = new JButton(l2);	

		b= new JButton(ic);
		Color myColor = Color.decode("#FFFFFF");
		Color myColor1 = Color.decode("#87ceeb");
		b.setBackground(myColor);
		b.setForeground(Color.BLACK);
		b.setBorder(null);

		b.setBounds(1200,600,100,40);
		b.addActionListener(this);

		b1 = new JButton("Employee Login");
		b1.setBackground(myColor);
		b1.setBackground(Color.BLACK);
		b1.setBounds(1170,530,150,40);
		b1.addActionListener(this);
		b1.setBorder(null);

		id=new JLabel();
		id.setBounds(0,0,1360,750);
		id.setLayout(null);

		JLabel lid = new JLabel("Employee Management System");
		lid.setBounds(550,320,300,100);
		lid.setFont(new Font("Harrington",Font.BOLD,15));
		
		lid.setForeground(Color.BLACK);
		id.add(lid);
	    id.add(b);
	    id.add(b1);
		l1.add(id);

		f.getContentPane().setBackground(Color.WHITE);

		f.setVisible(true);
		f.setSize(1400,750);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setLocation(50,50);

		while(true)
		{
			lid.setVisible(false);
			b.setBackground(myColor1);
			b1.setBackground(myColor1);
			try{
				Thread.sleep(500);

			}
			catch(Exception e){
			}
			lid.setVisible(true);
			b.setBackground(myColor);
			b1.setBackground(myColor);
			try
			{
				Thread.sleep(500);
	 		}
			catch(Exception e)
			{
			}
		}
	}
	public void actionPerformed(ActionEvent ae)
     {	 
     	if(ae.getSource()==b)
     	{
     	   System.out.println("Button is clicked");
     	   f.setVisible(false);
     	   new Login_page();
        }
        if(ae.getSource()==b1)
        {
        	new EmpLog();
        }
        
     }	
	
}
