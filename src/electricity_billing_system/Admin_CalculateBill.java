
package electricity_billing_system;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Admin_CalculateBill extends JFrame{
    
    
       private Container c;
    private ImageIcon img;
    private JButton btn1,btn2;
    private JLabel jl;
     private JLabel jl3,jl1,jl2,jl4,jl5,jl6,jl7,jl8,jl9,jl10,j11;
    private JTextField tx1,tx2,t1,t2,t3,t4,t5;
    private JPasswordField pf;
    private Font f,f1;
     private JComboBox Month_name;
     private JTextArea name,view_info;
 private Connection cn;
    private Statement stm;
    Admin_CalculateBill(){
          
                
        try{
                        Class.forName("com.mysql.jdbc.Driver");
			cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/customers","root","");
			stm=(Statement) cn.createStatement();      }
        catch(Exception e){
            
            e.printStackTrace();
        }
        initcomponents();
        
    }
    
  public void  initcomponents(){
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.LIGHT_GRAY);
      f=new Font("Arial",Font.BOLD,18);
       f1=new Font("Arial",Font.BOLD,22);
      
     
       jl2=new JLabel("Calculate Bill");
      
      jl2.setBounds(220,20,250,50);
      jl2.setFont(f1);
      c.add(jl2);
        
      jl1=new JLabel("Consumer No");
      /*jl1.setOpaque(true);
      jl1.setText("Already a member??");*/
      jl1.setBounds(60,110,200,50);
      jl1.setFont(f1);
      c.add(jl1);
      
      
       tx2=new JTextField();
      tx2.setOpaque(true);
      tx2.setBounds(230,120,150,30);
       tx2.setFont(f1);
      c.add(tx2);
      
       btn1=new JButton("Scearch");
      btn1.setFont(f1);
      btn1.setBounds(200,170,150,50);
      c.add(btn1);
     
      jl5=new JLabel("Customer Name");
      jl5.setBounds(60,250,190,50);
      jl5.setFont(f1);
      c.add(jl5);
      name = new JTextArea();
        name.setBounds(260,250,190,40);
        name.setForeground(Color.CYAN);
      
        name.setFont(f);       
        c.add( name); 
      
      jl6=new JLabel("Bill Number");
      
      jl6.setBounds(60,310,150,50);
      jl6.setFont(f1);
      c.add(jl6);
      
      t1=new JTextField();
      t1.setOpaque(true);
      t1.setBounds(260,310,150,40);
        t1.setFont(f1);
      c.add(t1);
      
      jl8=new JLabel("Month");
      jl8.setBounds(60,370,100,50);
      jl8.setFont(f1);
      c.add(jl8);
       String month[ ] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
             Month_name = new  JComboBox( month);
             Month_name.setBounds(260,370,170,40);
             Month_name.setFont(f);
             Month_name.setEditable(true);
             c.add( Month_name);
      jl3=new JLabel("Unit Consumed");
      jl3.setBounds(60,420,190,50);
      jl3.setFont(f1);
      c.add(jl3);
      
      t3=new JTextField();
      t3.setOpaque(true);
      t3.setBounds(260,420,120,40);
      t3.setFont(f1);
      c.add(t3);
     
      jl7=new JLabel("1 kilowatt-hour(kWh) cost");
      jl7.setBounds(60,480,280,50);
      jl7.setFont(f1);
      c.add(jl7);
      
      t4=new JTextField();
      t4.setOpaque(true);
      t4.setBounds(350,480,120,40);
      t4.setFont(f1);
      c.add(t4);
      
      jl4=new JLabel("Bill Amount");
      jl4.setBounds(60,550,190,50);
      jl4.setFont(f1);
      c.add(jl4);
      
       t5 = new JTextField();
       t5.setBounds(260,550,200,40);  
       t5.setFont(f1);   
       t5.setEnabled(false);
       c.add( t5);
             
       btn2=new JButton("Calculate");
       btn2.setFont(f1);
       btn2.setBounds(200,620,150,50);
       c.add(btn2);
       btn1.addActionListener(new ActionListener(){
      
           public void actionPerformed(ActionEvent e){
                if(e.getSource()==btn1)
        {
                 String Consumer_No = tx2.getText();
               
            try
            {
               
                 String sql="SELECT * FROM customer_details where Customer_Id='"+Consumer_No+"'";//         
                   ResultSet rset2;
                     rset2 = cn.createStatement().executeQuery(sql);
                    
                while(rset2.next())
                {
                    name.setText(""+rset2.getString("Name"));
                    t1.setText(""+rset2.getString("Service_No")); }
            }
            catch(Exception exc)
            {
                exc.printStackTrace();
            }
        }
           }
      }
      );
         
    
       btn2.addActionListener(new ActionListener(){
          
           public void actionPerformed(ActionEvent e) {
                double num1= Integer.parseInt((t3.getText().length()>0)?t3.getText():"0");
                 double num2= Integer.parseInt((t4.getText().length()>0)?t4.getText():"0");
    
               String s1=t3.getText();
               String s2=t4.getText();
             if(e.getSource()==btn2){
             
               if(s1.isEmpty()|| s2.isEmpty()){
               JOptionPane.showMessageDialog(null,"Please enter a value ");
           }
          else
        
        {
              t5.setText(String.valueOf(num1*num2)); 
              double Amount = Double.valueOf(t5.getText());
	      String Consumer_No = tx2.getText();
             
			try
			{
				DBConnection db=new DBConnection();
		
                        String q = "UPDATE customer_details SET Bill_Amount = ? WHERE Customer_Id=?";
                                PreparedStatement ps = db.cn.prepareStatement(q);
                                ps.setDouble(1, Amount);
                                ps.setString(2, Consumer_No);
                               
                                ps.executeUpdate();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Customer Amount inserted......");
                        setVisible(false);  }}  
        }        
       }
       ) ;  }
 
    public static void main(String[] args) {
        
          Admin_CalculateBill frame=new Admin_CalculateBill();
           frame.setVisible(true);
          frame.setBounds(100,100,650,800);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setTitle("Frame Title");}
   
      }
              
        
    
    
   