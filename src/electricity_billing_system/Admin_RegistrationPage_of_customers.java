package electricity_billing_system;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Admin_RegistrationPage_of_customers extends JFrame {
    
    private Container c;
    private ImageIcon img;
    private JButton btn1,btn2;
    private JLabel jl;
     private JLabel jl3,jl1,jl2,jl4,jl5,jl6,jl7,jl8,jl9,jl10,j11;
    private JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7;
    private JPasswordField pf;
    private Font f,f1;
 private Statement stm;
    Admin_RegistrationPage_of_customers(){
        initcomponents();
        
    }
    
  public void  initcomponents(){
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.LIGHT_GRAY);
      f=new Font("Arial",Font.BOLD,18);
       f1=new Font("Arial",Font.BOLD,22);
       jl1=new JLabel("Customer id");
      
      jl1.setBounds(60,110,170,50);
      jl1.setFont(f1);
      c.add(jl1);
      
       jl2=new JLabel("Register!!");
      
      jl2.setBounds(220,20,250,50);
      jl2.setFont(f1);
      c.add(jl2);
      
      jl3=new JLabel("Password");
      
      jl3.setBounds(60,160,130,50);
      jl3.setFont(f1);
      c.add(jl3);
      
      tx1=new JTextField();
      tx1.setOpaque(true);
      tx1.setBounds(220,120,150,30);
      tx1.setFont(f1);
      c.add(tx1);
      
      pf=new JPasswordField("");
      pf.setOpaque(true);
      pf.setBounds(220,170,150,30);
      c.add(pf);
      
       jl4=new JLabel("Personal Details");
       jl4.setOpaque(true);
      jl4.setBounds(150,210,250,30);
      jl4.setFont(f1);
      jl4.setBackground(Color.WHITE);
      c.add(jl4); 
      jl5=new JLabel("Customer Name");
      
      jl5.setBounds(60,250,220,50);
      jl5.setFont(f1);
      c.add(jl5);
      
       tx2=new JTextField();
      tx2.setOpaque(true);
      tx2.setBounds(230,260,150,30);
       tx2.setFont(f1);
      c.add(tx2);
     jl6=new JLabel("Service No");
      
      jl6.setBounds(60,310,150,50);
      jl6.setFont(f1);
      c.add(jl6);
      
      tx3=new JTextField();
       tx3.setOpaque(true);
       tx3.setBounds(230,310,150,30);
        tx3.setFont(f1);
      c.add( tx3);
      
      
      jl7=new JLabel("Contact No");
      jl7.setBounds(60,370,200,60);
      jl7.setFont(f1);
      c.add(jl7);
      
      tx4=new JTextField();
      tx4.setOpaque(true);
      tx4.setBounds(230,370,150,30);
       tx4.setFont(f1);
      c.add(tx4);
      
      jl8=new JLabel("Email Id");
      jl8.setBounds(60,430,100,50);
      jl8.setFont(f1);
      c.add(jl8);
      
      tx5=new JTextField();
       tx5.setOpaque(true);
       tx5.setBounds(230,430,250,30);
        tx5.setFont(f1);
      c.add( tx5);
      
      jl9=new JLabel("Address");
      
      jl9.setBounds(60,490,100,50);
      jl9.setFont(f1);
      c.add(jl9);
      
      tx6=new JTextField();
      tx6.setOpaque(true);
      tx6.setBounds(230,490,150,30);
       tx6.setFont(f1);
      c.add(tx6);
      
       
      btn1=new JButton("Register Now");
      btn1.setFont(f1);
      btn1.setBounds(200,580,250,50);
      c.add(btn1);
       btn1.addActionListener(new ActionListener() {
        
          public void actionPerformed(ActionEvent e) {
              if(e.getSource()==btn1)
		{ 
			String Customer_Id =tx1.getText();
			String Name=tx2.getText();
			String Service_No=tx3.getText();
			String Contact_No=tx4.getText();
			String Email=tx5.getText();
			String Address=tx6.getText();
			String Customer_Password=pf.getText();
			try
			{
				DBConnection db=new DBConnection();
				String q="insert into customer_details(Customer_Id, Service_No, Name, Contact_No, Address, Email,Customer_Password) values(?,?,?,?,?,?,?)";
                                PreparedStatement ps = db.cn.prepareStatement(q);
                                ps.setString(1, Customer_Id);
                                ps.setString(2, Service_No);
                                ps.setString(3, Name);
                                ps.setString(4, Contact_No);
                                ps.setString(5, Address);
                                ps.setString(6, Email);
                                ps.setString(7, Customer_Password);
				
                                ps.executeUpdate();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Customer data inserted......");
                        setVisible(false);
		}
		if(e.getSource()==btn1)
		{
 AdminPanel_choiceItems frame=new AdminPanel_choiceItems();
        frame.setVisible(true);
        frame.setBounds(50,50,660,500);
        frame.setTitle("Frame");
    		}     // dispose();  
             }});
   }
    
    
    public static void main(String[] args) {
      Admin_RegistrationPage_of_customers frame=new Admin_RegistrationPage_of_customers();
           frame.setVisible(true);
          frame.setBounds(100,100,650,800);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        frame.setTitle("Frame Title");
    }
}

