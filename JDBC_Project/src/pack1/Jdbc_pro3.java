package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.TreeSet;

public class Jdbc_pro3 
{
	void meth1()
	{
		String driver="oracle.jdbc.OracleDriver";
		String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
		String dbUser="system";
		String dbPwd="avinash";
		String sqlQuery="select*from Employee";
		
		System.out.println("Connecting our java program to database");
		 TreeSet<String> ts = new TreeSet<String>();
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(dbURL,dbUser,dbPwd);
			System.out.println("Connection Created\n");
			Statement stm=con.createStatement();
			ResultSet rs = stm.executeQuery(sqlQuery);
			System.out.println("Printing the Employeeid in Ascending order");
			while(rs.next())
			{
				ts.add(rs.getString(1));
			}
			System.out.println("Data:"+ts);
			Iterator<String> i=ts.descendingIterator();
			while(i.hasNext())
			{
				System.out.print(i.next()+" ");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro3().meth1();		
	}

}
