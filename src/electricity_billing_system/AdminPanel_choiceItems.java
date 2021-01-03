
package electricity_billing_system;



import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminPanel_choiceItems extends JFrame{
     private Container c;
     private JButton btn1,btn2,btn3,btn4,btn5;
    private JLabel jl;
   private JPanel panel;
    private ImageIcon img;
    private Font f,f1;
      AdminPanel_choiceItems(){
        initcomponents();
    }
    
  public void  initcomponents(){
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.WHITE);
      
       f=new Font("Arial",Font.BOLD,18);
        f1=new Font("Arial",Font.BOLD,22);
       jl=new JLabel("Slect Only One Item");
          jl.setOpaque(true);
          jl.setBackground(Color.PINK);
      jl.setBounds(190,30,200,30);
      jl.setFont(f1);
      c.add(jl);
  
    
      btn1=new JButton("Registration");
      btn1.setFont(f);
         btn1.setBackground(Color.WHITE);
      btn1.setBounds(50,150,150,50);
      c.add(btn1);
      
      btn2=new JButton("View Customers");
      btn2.setFont(f);
      btn2.setBounds(230,150,180,50);
      c.add(btn2);
     
      btn3=new JButton("Calculate Bill");
      btn3.setFont(f);
      btn3.setBounds(430,150,150,50);
      c.add(btn3);
      
      /*btn4=new JButton("Update Per Unit Cost");
      btn4.setFont(f);
      btn4.setBounds(100,220,230,50);
      c.add(btn4);*/
     
      btn5=new JButton("Logout");
      btn5.setFont(f);
      btn5.setBounds(200,220,200,50);
      c.add(btn5);
       
      btn1.addActionListener(new ActionListener(){
          
           public void actionPerformed(ActionEvent e) {
              
               Admin_RegistrationPage_of_customers frame=new Admin_RegistrationPage_of_customers();
                frame.setVisible(true);
          frame.setBounds(100,100,650,800);
           
            }
 }
       ) ;
      btn5.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
            
              JOptionPane.showMessageDialog(null,"Confirm Logout??" );
              
          
              AdminLogin_page frame= new AdminLogin_page();
              frame.setVisible(true);
              frame.setBounds(50,50,660,500);
                //System.exit(0);
              
              }
      }
      );
      
    
      btn2.addActionListener(new ActionListener(){
        
          public void actionPerformed(ActionEvent e) {
         
                Admin_ViewCustomerDetails frame=new  Admin_ViewCustomerDetails();
                frame.setVisible(true);

                frame.setBounds(50,50,850,550);
                frame.setTitle("Frame");
        }
          
      });
       btn3.addActionListener(new ActionListener(){
        
          public void actionPerformed(ActionEvent e) {
              
           Admin_CalculateBill frame=new Admin_CalculateBill();
           frame.setVisible(true);
           frame.setBounds(100,100,650,800);
           frame.setTitle("Frame Title");
       }
          
      });
       img=new ImageIcon(getClass().getResource("s2.jpg"));
       this.setIconImage(img.getImage());
      
        jl=new JLabel(img);
        jl.setBounds(15,25,img.getIconWidth(),img.getIconHeight());
        c.add(jl);
        
        panel=new JPanel();
        panel.setBounds(20,150,600,100);
        panel.setBackground(Color.WHITE);
      c.add(panel);
      
  }
    
    public static void main(String[] args) {
                AdminPanel_choiceItems frame=new AdminPanel_choiceItems();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(50,50,660,500);
                frame.setTitle("Frame");
    
    }
}
