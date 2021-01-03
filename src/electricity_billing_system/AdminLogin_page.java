
package electricity_billing_system;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin_page extends JFrame{
    
    private Container c;
    private JLabel jl,jl1,jl2,jl3;
    private Font f,f1;
    private JPanel panel;
    private ImageIcon img;
    private JTextField tx1;
    private JPasswordField pf; 
    private JButton btn;
     private Connection cn;
    private Statement stm;
    AdminLogin_page()
    {
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/customers","root","");
			stm=(Statement) cn.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}   ImgP();   
      
      }
    public void ImgP()
    {
      c=this.getContentPane();  
      c.setLayout(null);
      c.setBackground(Color.WHITE);
      
      f=new Font("Arial",Font.BOLD,18);
      f1=new Font("Arial",Font.BOLD,20); 
      
      jl1=new JLabel("Login Page of Admin");
      jl1.setOpaque(true);
      jl1.setBackground(Color.PINK);
      jl1.setBounds(200,35,200,50);
      jl1.setFont(f1);
     
      
      jl2=new JLabel("User Name");
      jl2.setOpaque(true);
      jl2.setBackground(Color.PINK);
      jl2.setBounds(60,155,100,30);
      jl2.setFont(f);
     
      
      jl3=new JLabel("Passward");
      jl3.setOpaque(true);
      jl3.setBackground(Color.PINK);
      jl3.setBounds(60,210,100,30);
      jl3.setFont(f);
      
      
      tx1=new JTextField();
      tx1.setOpaque(true);
      tx1.setBounds(170,150,150,30);
     
      
      pf=new JPasswordField();
      pf.setOpaque(true);
      pf.setBounds(170,210,150,30);
     
      
      btn=new JButton("Login");
      btn.setFont(f);
      btn.setBounds(250,300,120,50);
      
      c.add(jl1);
      c.add(jl2);
      c.add(jl3);
      c.add(tx1);
      c.add(btn);
      c.add(pf);
     
      
       btn.addActionListener(new ActionListener(){
          
           public void actionPerformed(ActionEvent e) {
               String s1=tx1.getText();
           String s2=pf.getText();
           if(s1.equals("Sa") && s2.equals("123")){
               AdminPanel_choiceItems frame=new AdminPanel_choiceItems();
                frame.setVisible(true);
          frame.setBounds(100,100,650,500);
           }
           else{
               JOptionPane.showMessageDialog(null, "Invalid Username or Password");
           }
            }   }
       ) ;
         img=new ImageIcon(getClass().getResource("s2.jpg"));
         this.setIconImage(img.getImage());
      
        jl=new JLabel(img);
        jl.setBounds(15,25,img.getIconWidth(),img.getIconHeight());
        c.add(jl);
        
        panel=new JPanel();
        panel.setBounds(20,150,600,100);
        panel.setBackground(Color.yellow);
        c.add(panel);
        
    }  public static void main(String[] args) {
        AdminLogin_page frame= new AdminLogin_page();
        frame.setVisible(true);
        frame.setBounds(50,50,640,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Selected Frame");
        frame.setResizable(false);
        
   }}


    