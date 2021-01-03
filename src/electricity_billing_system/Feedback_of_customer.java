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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Feedback_of_customer extends JFrame
{     
    JTextArea view_info;
     private JPanel panel;
     private Container c;
    private ImageIcon img;
    private JButton btn,btn2;
    private JLabel jl,jl1,jl2;
    private JTextField tx1;
    private Connection cn;
    private Statement stm;
    private Font f,f1;
    Feedback_of_customer()
    { 
         try{
                        Class.forName("com.mysql.jdbc.Driver");
			cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/customers","root","");
			stm=(Statement) cn.createStatement();
                        
                     
         
        }
        catch(Exception e){
            //System.out.println("data not displayed");
            e.printStackTrace();
        }
        
        
        initcomponents();
    }
    
  public void  initcomponents(){
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.LIGHT_GRAY);
    
      img=new ImageIcon(getClass().getResource("s2.jpg"));
      this.setIconImage(img.getImage());
      f=new Font("Arial",Font.BOLD,18);
       f1=new Font("Arial",Font.BOLD,22);
       jl1=new JLabel();
      jl1.setOpaque(true);
      jl1.setText("FeedBack! ");
      jl1.setBounds(250,50,250,50);
      jl1.setFont(f1);
      c.add(jl1);
      jl2=new JLabel("Service No");
      
      jl2.setBounds(70,170,150,40);
      jl2.setFont(f1);
      c.add(jl2);
      
      tx1=new JTextField();
      tx1.setOpaque(true);
      tx1.setBounds(230,170,120,40);
        tx1.setFont(f1);
      c.add(tx1);
          
    jl2=new JLabel("FeedBack");
      jl2.setBounds(60,230,190,50);
      jl2.setFont(f1);
      c.add(jl2);
     
    
             view_info = new JTextArea();
             view_info.setBounds(190,230,400,200);  
             view_info.setBackground(Color.WHITE);
             view_info.setFont(f);   
            
             c.add( view_info);
             btn = new JButton("Submit");
             btn.setBounds(300,480,100,30);
             btn.setFont(f);
             c.add(btn);
              btn.addActionListener(new ActionListener(){
        
          public void actionPerformed(ActionEvent e) {
              if(e.getSource()==btn)
		{
               String Service_No = tx1.getText();
             String Feedback = view_info.getText();
		     
               if(Service_No.isEmpty()){
                          JOptionPane.showMessageDialog(null,"Please Enter a value");
                }
               else{
                       try
			{
				DBConnection db=new DBConnection();
				String q="insert into customers_feedback(Service_No,Feedback) values(?,?)";
                                PreparedStatement ps = db.cn.prepareStatement(q);
                              ps.setString(1, Service_No);
                                ps.setString(2, Feedback);
                               ps.executeUpdate();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Customer data inserted......");
                        setVisible(false); 
               
                        
               }
             }
         
       
      }}
);
    
    
}
 
     public static void main(String[] args) {
        
          Feedback_of_customer frame=new Feedback_of_customer();
           frame.setVisible(true);
          frame.setBounds(100,100,850,600);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        frame.setTitle("Frame Title");
    
}}
