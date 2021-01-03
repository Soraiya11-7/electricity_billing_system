package electricity_billing_system;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class  Admin_ViewCustomerDetails extends JFrame {
    
    
     private JPanel panel;
     private Container c;
    private ImageIcon img;
    private JButton btn,btn2;
    private JLabel jl,jl1,jl2;
    private JTextField tx1;
    private  DefaultTableModel model;      
    private JTable tbl;
    private Font f,f1;
    private String[]columns={"Name","Contact No","Email Id","Address"};

    private ArrayList<ArrayList<String>> rows;
    private JScrollPane scroll;
    private Statement stm;
    Admin_ViewCustomerDetails(){

        initcomponents();
    }
    
  public void initcomponents(){
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.LIGHT_GRAY);
    
      img=new ImageIcon(getClass().getResource("s2.jpg"));
      this.setIconImage(img.getImage());
      f=new Font("Arial",Font.BOLD,18);
       f1=new Font("Arial",Font.BOLD,22);
       jl1=new JLabel();
      jl1.setOpaque(true);
      jl1.setText("Customer Details");
      jl1.setBounds(170,50,250,50);
      jl1.setFont(f1);
      c.add(jl1);
      
      /*tbl=new JTable();*/
      model= new  DefaultTableModel();
      tbl = new JTable(model);
      
      model.setColumnIdentifiers(columns);
      Statement stm = new DBConnection().stm;
        try{
            String sql="SELECT * FROM customer_details";//         
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<String> temp = new ArrayList<>();
                while(rs.next()){
                  temp.add(new String(rs.getString("Name")));
                  temp.add(rs.getString("Contact_No"));
                  temp.add(rs.getString("Address"));
                  temp.add(rs.getString("Email"));
                  model.addRow(new Object[]{rs.getString("Name"), rs.getString("Contact_No"), rs.getString("Address"), rs.getString("Email")});

                  System.out.println(temp);
                  temp.clear();
              }
            System.out.println("data displayed");
        }catch(Exception e){
            System.out.println("data not displayed");
            e.printStackTrace();
    }
        
      tbl.setModel(model);
      tbl.setFont(f);
      tbl.setSelectionBackground(Color.yellow);
      tbl.setBackground(Color.WHITE);
      tbl.setRowHeight(30);
      scroll=new JScrollPane(tbl);
      scroll.setBounds(20,130,800,265);
      c.add(scroll);  
  }
 public static void main(String[] args) {
         Admin_ViewCustomerDetails frame=new  Admin_ViewCustomerDetails();
        frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,850,500);
        frame.setTitle("Frame");
    
    }
}