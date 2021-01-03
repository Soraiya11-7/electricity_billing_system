
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
import javax.swing.JPanel;


public class Home_Page extends JFrame {
    private Container c;
    private ImageIcon img;
    private JButton btn1,btn2;
    private JLabel jl;
    private JPanel panel;
    private Font f;
    Home_Page(){
        initcomponents();
    }
    
  public void  initcomponents(){
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.WHITE);
    img=new ImageIcon(getClass().getResource("s2.jpg"));
      this.setIconImage(img.getImage());
      
        jl=new JLabel(img);
        jl.setBounds(15,25,img.getIconWidth(),img.getIconHeight());
        c.add(jl);
        
        panel=new JPanel();
        panel.setBounds(20,150,600,100);
        panel.setBackground(Color.yellow);
         f=new Font("Arial",Font.BOLD,18);
     
      btn1=new JButton("ADMIN");
      btn1.setFont(f);
      btn1.setBounds(150,200,150,150);
      btn2=new JButton("Customer");
      btn2.setFont(f);
      btn2.setBounds(330,200,180,150);
     
      
      btn1.addActionListener(new ActionListener(){
          
          public void actionPerformed(ActionEvent ae) {
               AdminLogin_page frame= new AdminLogin_page();  
          frame.setVisible(true);
          frame.setBounds(100,100,650,490);
          }
          
           }
      );
       btn2.addActionListener(new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
              
               CustomerLogin_page frame=new CustomerLogin_page();
        frame.setVisible(true);
        
        frame.setBounds(50,50,660,500);
        frame.setTitle("Frame Title");
             }
      }
      
       );
       
      
      panel.add(btn1);
      panel.add(btn2);
        c.add(panel);
       }
  public static void main(String[] args) {
        
        
        Home_Page frame=new Home_Page();
        frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,660,500);
        frame.setTitle("Frame Title");
        
        
    }
    
}
