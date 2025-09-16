package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;

public class Jdbc_pro19 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd = "avinash";
	
	void meth1()
	{
		System.out.println("Meth1() called");
		try
		{
			Connection con=DriverManager.getConnection(dbURL, dbUser, dbPwd);
			
			System.out.println("getAutoCommit():"+con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("getAutoCommit():"+con.getAutoCommit());
			
			Savepoint sp1=con.setSavepoint();
			
			Savepoint sp2=con.setSavepoint();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{		
		new Jdbc_pro19().meth1();
	}
}
