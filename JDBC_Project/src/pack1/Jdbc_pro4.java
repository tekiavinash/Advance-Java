package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class Jdbc_pro4
{
	void meth1()
	{
		String driver = "oracle.jdbc.OracleDriver";
		String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbUser = "system";
		String dbPwd ="avinash";
		String sqlQuery = "select*from Employee";
		
		HashMap<String,Integer> hm= new HashMap<String,Integer>();		
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(dbURL,dbUser,dbPwd);
			System.out.println("Connection Created");
			Statement stm=con.createStatement();
			ResultSet rs = stm.executeQuery(sqlQuery);
			System.out.println("Reterving thr EId And ESal by using HashMap:");
			while(rs.next())
			{
				hm.put(rs.getString(1),rs.getInt(4));
			}
			System.out.println("Data:"+hm);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new Jdbc_pro4().meth1();		
	}
}
