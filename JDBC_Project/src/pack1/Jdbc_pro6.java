package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro6
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	String sqlQuery1="delete from Employee where Eid=106";
	String sqlQuery2 = "select*from Employee";
	
	Scanner sc=new Scanner(System.in);
	void deleteData()
	{
		System.out.println("Deleting the data from database");
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbURL,dbUser,dbPwd);
			Statement stm = con.createStatement();
			System.out.println("if you want to Delete Data from database (Yes/No):");
			switch(sc.next())
			{
				case "Yes":
					int rowCount=0;
					rowCount=stm.executeUpdate(sqlQuery1);
					ResultSet rs=stm.executeQuery(sqlQuery2);
					if(rowCount>0)
					{
						System.out.println("Data Deleted");
						while(rs.next())
						{
							System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
						}
					}
					else
					{
						System.out.println("There is no Record found");
					}
					
					break;
				case "No":
					System.out.println("Data is Not Deleted");
					System.out.println("Than you!!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		  Jdbc_pro6 obj= new Jdbc_pro6();
		  obj.deleteData();
	}
}
