package pack1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Jdbc_pro2 
{
	void meth1()
	{
		System.out.println("Implementing Statement Interface");
		
		String driver="oracle.jdbc.OracleDriver";
		String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
		String dbUname="system";
		String dbUpwd="avinash";
		String sqlQuery="select*from Employee";
		
		System.out.println("Connection our java program to database");
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(dbURL,dbUname,dbUpwd);
			System.out.println("Connection created");
			Statement stm=con.createStatement();
			ResultSet rs =stm.executeQuery(sqlQuery);//executeQuery() is used for selection group commands:
			System.out.println("REterving the data from th ResultSet");
			while(rs.next()) 
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	public static void main(String[] args) 
	{
		Jdbc_pro2 obj=new Jdbc_pro2();
		obj.meth1();
	}
}
