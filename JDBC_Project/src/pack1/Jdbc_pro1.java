package pack1;

import java.sql.DriverManager;
import java.sql.Connection;

public class Jdbc_pro1 
{
	void getConnection()
	{
		String driver="oracle.jdbc.OracleDriver";
		String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
		String dbuname="system";
		String dbpwd="avinash";
		
		System.out.println("Connection our java program to database:");
		
		try 
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(dbURL,dbuname,dbpwd);
			System.out.println("\nConnection Created");
			con.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		Jdbc_pro1 obj=new Jdbc_pro1();
		obj.getConnection();
	}
}
