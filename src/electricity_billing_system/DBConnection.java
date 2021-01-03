
package electricity_billing_system;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
    public Connection cn;
    Statement stm;
     public DBConnection()
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
		}
	}
	public static void main(String s[])
	{
		new DBConnection();
	}
}