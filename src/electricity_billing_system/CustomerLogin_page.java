package electricity_billing_system;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CustomerLogin_page extends JFrame {
    
    
     private JPanel panel;
     private Container c;
    private ImageIcon img;
    private JButton btn,btn2;
    private JLabel jl3,jl1,jl2,jl;
    private JTextField tx1;
    private JPasswordField pf;
   
    private Connection cn;
    private Statement stm;
    private Font f,f1;
    CustomerLogin_page(){
        
   
        initcomponents();
    }
    
  public void  initcomponents(){
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.WHITE);
    
      img=new ImageIcon(getClass().getResource("s2.jpg"));
      this.setIconImage(img.getImage());
      f=new Font("Arial",Font.BOLD,18);
       f1=new Font("Arial",Font.BOLD,22);
      
      jl1=new JLabel();
      jl1.setOpaque(true);
      jl1.setText("Already a member??");
      jl1.setBackground(Color.PINK);
      jl1.setBounds(170,50,250,50);
      jl1.setFont(f1);
      c.add(jl1);
      
       jl2=new JLabel("Customer Id");
       jl2.setOpaque(true);
         jl2.setBackground(Color.PINK);
      jl2.setBounds(60,150,130,30);
      jl2.setFont(f);
      c.add(jl2);
      
      jl3=new JLabel("Passward");
       jl3.setOpaque(true);
         jl3.setBackground(Color.PINK);
      jl3.setBounds(60,200,100,30);
      jl3.setFont(f);
      c.add(jl3);
      
      tx1=new JTextField();
      tx1.setOpaque(true);
      tx1.setBounds(200,150,100,30);
      c.add(tx1);
      
      pf=new JPasswordField();
      pf.setOpaque(true);
      pf.setBounds(200,210,100,30);
      c.add(pf);
      
      btn=new JButton("Login");
      btn.setFont(f);
      btn.setBounds(250,300,120,50);
      c.add(btn);
        btn.addActionListener(new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
              try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/customers","root","");
			stm=(Statement) cn.createStatement();
			if(e.getSource()==btn)
			{
				String name=tx1.getText();
				String pass= new String(pf.getPassword());
				String sql="SELECT * FROM customer_details WHERE Customer_Id='"+name+"' and Customer_Password='"+pass+"'";
				//Statement stm=cn.createStatement();
				ResultSet set=stm.executeQuery(sql);	
				if(set.next())
				{
					  Customer_choiceItem frame=new Customer_choiceItem();
                                     frame.setVisible(true);
        
                                        frame.setBounds(50,50,660,500);
                                           frame.setTitle("Frame Title");

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					setVisible(false);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"sorry you pressed cancle button.....!");
				setVisible(false);
			}
		}
              catch(Exception er)
		{
			er.printStackTrace();
		}
		
	}
    
      });
  img=new ImageIcon(getClass().getResource("s2.jpg"));
      this.setIconImage(img.getImage());
      
        jl=new JLabel(img);
        jl.setBounds(15,25,img.getIconWidth(),img.getIconHeight());
        c.add(jl);
        
        panel=new JPanel();
        panel.setBounds(20,150,600,100);
        panel.setBackground(Color.yellow);
      c.add(panel);}
  
  
    public static void main(String[] args) {
        
        CustomerLogin_page frame=new CustomerLogin_page();
        frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,660,500);
        frame.setTitle("Frame Title");
        
        
        
      }}
       
    


