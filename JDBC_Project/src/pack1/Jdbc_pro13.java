package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc_pro13 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	
	
	void meth1()
	{
		System.out.println("Implementing Scrollable ResultSet by using PreparedStatement:\n");
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(dbURL,dbUser,dbPwd);
			PreparedStatement stmt=con.prepareStatement("select*from Employee",1004,1007);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			
			System.out.println("-----------------------------");
			rs.last();
			if(rs.previous())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
		
			System.out.println("-----------------------------");
			rs.first();
			if(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			System.out.println("-----------------------------");
			rs.afterLast();
			if(rs.previous())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			System.out.println("-----------------------------");
			rs.beforeFirst();
			if(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			System.out.println("-----------------------------");
			rs.absolute(3);
			while(rs.previous())
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			System.out.println("-----------------------------");
			rs.relative(2);
			if(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro13().meth1();		
	}
}
