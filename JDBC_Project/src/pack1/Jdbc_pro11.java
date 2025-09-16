package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_pro11 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	void meth1()
	{
		System.out.println("Implementing Scrollable-ResultSet\n");
		try
		{
			Class.forName(driver);
			Connection con =DriverManager.getConnection(dbURL,dbUser,dbPwd);
			Statement stmt =con.createStatement(1004,1007);
			ResultSet rs=stmt.executeQuery("select*from Employee");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			
			System.out.println("--------------------------");
			rs.last();
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			System.out.println("--------------------------");
			//rs.afterLast();
			while(rs.previous())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			
			System.out.println("----------------------------");
			rs.beforeFirst();
			if(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			
			System.out.println("---------------------");
			rs.first();
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			System.out.println("---------------------");
			rs.absolute(2);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			System.out.println("---------------------");
			rs.absolute(-5);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			System.out.println("---------------------");
			rs.relative(1);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			System.out.println("---------------------");
			rs.relative(-1);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro11().meth1();		
	}
}
