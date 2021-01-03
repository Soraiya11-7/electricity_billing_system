 
package electricity_billing_system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Customer_choiceItem extends JFrame{
     private Container c;
     private JButton btn1,btn2,btn3,btn4,btn5;
    private JLabel jl;
  
    private Font f,f1;
      Customer_choiceItem(){
        initcomponents();
    }
    
  public void  initcomponents(){
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.LIGHT_GRAY);
      
       f=new Font("Arial",Font.BOLD,18);
        f1=new Font("Arial",Font.BOLD,22);
       jl=new JLabel("Slect Only One Item");
      jl.setBounds(190,20,200,100);
      jl.setFont(f1);
      c.add(jl);
  
    
      btn1=new JButton("View Bill");
      btn1.setFont(f);
      btn1.setBounds(50,150,150,50);
      c.add(btn1);
      
      btn2=new JButton("Feedback");
      btn2.setFont(f);
      btn2.setBounds(230,150,180,50);
      c.add(btn2);
     
      btn3=new JButton("Logout");
      btn3.setFont(f);
      btn3.setBounds(430,150,150,50);
      c.add(btn3);
      
     
       
      btn1.addActionListener(new ActionListener(){
          
           public void actionPerformed(ActionEvent e) {
              
               Customer_showBill frame=new  Customer_showBill ();
                frame.setVisible(true);
          frame.setBounds(100,100,1260,800);
           
            }
 }
       ) ;
     
      btn2.addActionListener(new ActionListener(){
        
          public void actionPerformed(ActionEvent e) {
          
          Feedback_of_customer frame=new Feedback_of_customer();
           frame.setVisible(true);
          frame.setBounds(100,100,850,600);

            }
          
      });
       btn3.addActionListener(new ActionListener(){
        
          public void actionPerformed(ActionEvent e) {
           JOptionPane.showMessageDialog(null,"Confirm Logout??" );
              
          
               CustomerLogin_page frame= new  CustomerLogin_page();
              frame.setVisible(true);
              frame.setBounds(50,50,660,500);
              
              
              
              
            }
          
      });
      
  }
    
    public static void main(String[] args) {
        
        
        
     Customer_choiceItem frame=new Customer_choiceItem();
        frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,660,500);
        frame.setTitle("Frame");
    
    }
}

