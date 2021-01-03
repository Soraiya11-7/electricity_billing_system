
package electricity_billing_system;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Customer_showBill extends JFrame{
    
    
       private JPanel panel;
     private Container c;
    private ImageIcon img;
    private JButton btn,btn2;
    private JLabel jl,jl1,jl2;
    private JTextField t1,t2,t3,t4,tx1;
     private  DefaultTableModel model;      
    private JTable tbl;
    private Font f,f1;
    private String[]columns={"Customer Id","Name","Address","Month","Amount","status"};
    private String[]rows=new String[6];
    private JScrollPane scroll;
       private Connection cn;
    private Statement stm;
 private JComboBox  Month_name ;
     Customer_showBill(){
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
      jl1=new JLabel("Bill Number");
      jl1.setBounds(60,50,150,50);
      jl1.setFont(f);
      c.add(jl1);
      
      tx1=new JTextField();
      tx1.setOpaque(true);
      tx1.setBounds(230,50,150,30);
      c.add(tx1);
      
      jl2=new JLabel("Month");
      jl2.setBounds(60,90,100,50);
      jl2.setFont(f1);
      c.add(jl2);
       String month[ ] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
             Month_name = new  JComboBox( month);
              Month_name .setBounds(230,90,170,40);
              Month_name .setFont(f);
              Month_name .setEditable(true);
             c.add(  Month_name );
             
       btn=new JButton("View Bill");
       btn.setFont(f);
       btn.setBounds(250,170,120,50);
       c.add(btn);
      
       jl1=new JLabel();
      jl1.setOpaque(true);
      jl1.setText("Customer Bill Details");
      jl1.setBackground(Color.PINK);
      jl1.setBounds(250,250,250,50);
      jl1.setFont(f1);
      c.add(jl1);
      tbl=new JTable();
      
       model= new  DefaultTableModel();
      tbl = new JTable(model);
      
      model.setColumnIdentifiers(columns);
      
      tbl.setModel(model);
      tbl.setFont(f);
      tbl.setSelectionBackground(Color.yellow);
      tbl.setBackground(Color.WHITE);
      tbl.setRowHeight(30);
      scroll=new JScrollPane(tbl);
      scroll.setBounds(10,350,1200,100);
      c.add(scroll);
      btn.addActionListener(new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {   if(e.getSource()==btn)
		{ 
			String Service_No =tx1.getText();
			String Month= (String) Month_name.getSelectedItem();
                         {
               
             DBConnection db=new DBConnection();
      Statement stm = new DBConnection().stm;
        try{
            String sql="SELECT*  FROM customer_details where Service_No='"+Service_No+"' && Month='"+Month+"'";//         
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<String> temp = new ArrayList<>();
                while(rs.next()){
                  temp.add(new String(rs.getString("Name")));
                  temp.add(rs.getString("Contact_No"));
                  temp.add(rs.getString("Address"));
                  temp.add(rs.getString("Email"));
                  temp.add(rs.getString("Bill_Amount"));
                  temp.add(rs.getString("Status_Paid_Not_Paid"));
                  System.out.println(rs.getString("Name"));
                  model.addRow(new Object[]{rs.getString("Name"), rs.getString("Contact_No"), rs.getString("Address"), rs.getString("Email"),rs.getString("Bill_Amount"),rs.getString("Status_Paid_Not_Paid")});

                  System.out.println(temp);
                  temp.clear();
              }
            System.out.println("data displayed");
        }catch(Exception exc ){
            System.out.println("data not displayed");
            exc.printStackTrace();
    }}}}});
       
      }
    public static void main(String[] args) {
        
          Customer_showBill frame=new Customer_showBill();
           frame.setVisible(true);
          frame.setBounds(100,100,1300,700);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        frame.setTitle("Frame Title");
        
    }
    
    
    
    
    
    
    
}
