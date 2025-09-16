package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_pro12 
{
	//eid,esal,efname.
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	
	void meth1()
	{
		System.out.println("Implementing Updateable on Scrollable ResultSet\n");
		try
		{
			Class.forName(driver);
			Connection con =DriverManager.getConnection(dbURL,dbUser,dbPwd);
			Statement stmt =con.createStatement(1004,1008);
			ResultSet rs=stmt.executeQuery("select Eid,EFname,Esal from Employee");
			while(rs.next())
			{
				String id=rs.getString(1);
				if(id.equals("104"))
				{
					System.out.println("Updating the salary for Employee :"+id);
					rs.updateInt(3, 85000);
					rs.updateRow();
				}
			}	
			System.out.println("Data Updated!!!!");
			
			ResultSet rs2=stmt.executeQuery("select * from Employee");
			rs2.last();
			if(rs2.previous())
				System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getInt(4)+" "+rs2.getString(5));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new Jdbc_pro12().meth1();
	}
}
