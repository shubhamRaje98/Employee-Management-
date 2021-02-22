import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Print_Leave implements ActionListener{
    JFrame f;
    JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id9,id10,id11,id12,id13,id14,id15,id16,id17,lab,aid11,aid12;
    String e_id,name,numD,fromD,toD,post,emp_id;
    int quan;
    JButton b1,b2;
    ImageIcon icon;

    Print_Leave(String e_id){
        try{
            conn con = new conn();
            String str = "select * from leaveData where emp_id = '"+e_id+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){
                name = rs.getString("name");
                post = rs.getString("post");
                numD = rs.getString("numD");
                fromD = rs.getString("fromD");
                toD = rs.getString("toD");
                emp_id = rs.getString("emp_id");
                quan = Integer.parseInt(e_id);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
 
        f=new JFrame("Leave Application");
        f.setVisible(true);
        f.setSize(595,730);
        f.setLocation(380,0);
        f.setDefaultCloseOperation(3);
        f.setBackground(Color.white);
        f.setLayout(null);


        id9=new JLabel();
        id9.setBounds(0,0,595,642);
        id9.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/white.jpg"));
        Image imsc = img.getImage().getScaledInstance(595,642,Image.SCALE_DEFAULT);
        id9.setIcon(img);

        id8 = new JLabel("Details");
        id8.setBounds(50,10,250,30);
        f.add(id8);
        id8.setFont(new Font("serif",Font.BOLD,25));
        id9.add(id8);
        f.add(id9);

        id = new JLabel("Employee Id: ");
        id.setBounds(50,70,180,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);

        aid = new JLabel(e_id);
        aid.setBounds(330,70,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);

        id1 = new JLabel("Name: ");
        id1.setBounds(50,120,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);

        aid1 = new JLabel(name);
        aid1.setBounds(330,120,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);

  
        id2 = new JLabel("Post "); 
        id2.setBounds(50,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2);

        aid2 = new JLabel(post);
        aid2.setBounds(330,170,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);

        id3= new JLabel("Days of leave :");
        id3.setBounds(50,220,200,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id3);

        aid3= new JLabel(numD);
        aid3.setBounds(330,220,300,30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid3);


        id4= new JLabel("From date : ");  
        id4.setBounds(50,270,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id4);

        aid4= new JLabel(fromD);
        aid4.setBounds(330,270,300,30); 
        aid4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid4);

        
        id5= new JLabel("To : ");
        id5.setBounds(50,320,200,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id5);

        aid5= new JLabel(toD);
        aid5.setBounds(330,320,300,30);
        aid5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid5);
        
        b1=new JButton("Accept");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,520,100,30);
        b1.addActionListener(this);
        id9.add(b1);

        b2=new JButton("Reject");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,520,100,30);
        b2.addActionListener(this);
        id9.add(b2);


    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            try{
                conn cc = new conn();
                String ac = "Accepted";
                System.out.println(quan + " is eid");
                String q = "update leaveData set L_status = 'Accepted'" + "where emp_id = '"+quan+"'";
                cc.s.executeUpdate(q);
                //JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                //f.setVisible(false);
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
            JOptionPane.showMessageDialog(null,"Leave accepted");

            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            try{
                conn cc = new conn();
                String re = "Rejected";
                String q = "update leaveData set L_status = 'Rejected'" + "where emp_id='"+quan+"'";
                cc.s.executeUpdate(q);
                //JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                //f.setVisible(false);
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            JOptionPane.showMessageDialog(null,"Leave rejected");
            //new View_Employee();
        }
    }
}
    public static void main(String[] args){
        new Print_Leave("Print Data");
    }

}