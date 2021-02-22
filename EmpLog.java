import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EmpLog implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JPasswordField p1;
	JButton b;
	Dimension screenSize;
	public EmpLog()
	{
		f = new JFrame("Employee Login");
		Color background = Color.decode("#add8e6");
		f.getContentPane().setBackground(background);
		f.setResizable(false);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp2.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(410,40,150,140);
        f.add(l3);

        l1 = new JLabel("Enter the master password : ");
		l1.setFont(new Font("serif",Font.BOLD,18));
		l1.setBounds(110,50,300,20);
		f.add(l1);

		l2 = new JLabel("Password : ");
	 	l2.setFont(new Font("serif",Font.BOLD,18));
		l2.setBounds(20,110,140,20);
		f.add(l2);

		/*t1 = new JTextField();
		t1.setBorder(null);
		t1.setBounds(170,45,200,25);
		//t1.setBackground(Color.decode("#7785cb"));
		f.add(t1);*/

		p1 = new JPasswordField();
		p1.setBounds(170,105,200,25);
		p1.setBorder(null);
		f.add(p1);

		b = new JButton("Login");
		b.setFont(new Font("serif",Font.BOLD,14));
		b.setBackground(Color.decode("#000000"));
		b.setForeground(Color.WHITE);
		b.setBounds(200,200,100,30);
		b.addActionListener(this);
		f.add(b);



        f.setLayout(null);
        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(370,250);
       // f.setResizable(false);
        //f.setExtendedState(MAXIMIZED_BOTH);
        //f.pack();
       // screenSize = new Dimension(500, 400);
        f.setPreferredSize(screenSize);
       // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        public void actionPerformed(ActionEvent ae)
    {
            
            if(ae.getSource() == b)
		{
		try
		{
			conn c1 = new conn();
			//String u = t1.getText();
			String v = new String(p1.getPassword());
			//int n = (int)t1.getText();

			String q = "select emp_id,E_pass from employee where E_pass='"+v+"';";
			ResultSet rs = c1.s.executeQuery(q);
			if(rs.next())
			{
				//JOptionPane.showMessageDialog(null,"Login successful!\n");
				new Leave_man();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid login");
			}
        }
        catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
	public static void main(String[] args)
        {
           new EmpLog();
        }
}
