import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class Man_leave implements ActionListener 
{
	JTable table;
	JFrame f;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4,t5;
	JCheckBox c1;

	public Man_leave()
	{
		f = new JFrame("Manage leaves");
		c1 = new JCheckBox();
		String[] columnNames = {"Emp_Id","Emp_Name","Post","Attendence in last 30 days"};
        conn con = new conn();
            String str = "select emp_id,name,post,fromD,toD,numD from leaveData";
            ResultSet rs = con.s.executeQuery(str);

            Vector v = new Vector();

            while (rs.next()) {

                String id = String.valueOf(rs.getInt("emp_id"));
                String name = rs.getString("name");
                String post = rs.getString("post");
                String from = rs.getString("fromD");
                String to = rs.getString("toD");
                String num = String.valueOf(rs.getInt("numD"));

                String tbData[] = {id,name,post,from,to,num}; 
                DefaultTableModel tbModel = (DefaultTableModel)table.getModel();
                tbModel.addRow(tbData);

             //   v.add(ids);

            }

        Object[][] data = {
            {"1001","Shubham shejaval","CEO","23"},
            {"1002","Ashutosh Sharma","CEO","23"},
            {"1003","Aditya Sherkhane","CEO","23"},
            {"1004","Ayush Shinde","CEO","23"},
            {"1005","Sagar Kore","CEO","23"}

        };
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(580,200));
        table.setFillsViewportHeight(true);
        JScrollPane scrollpane = new JScrollPane(table);
        f.add(scrollpane);   

        f.setDefaultCloseOperation(3);
        f.setSize(800,500);
        f.setLocation(300,30);
        f.setVisible(true);

	}
	public void actionPerformed(ActionEvent ae)
	{

	}
	public static void main(String args[])
	{
		Man_leave ml = new Man_leave();
	}
}
