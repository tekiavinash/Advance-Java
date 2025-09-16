package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro5
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	String sqlQuery1="insert into Employee values('108','Raj','Shekhar',65000,'Nrt')";
	String sqlQuery2 = "select*from Employee";
	
	Scanner sc=new Scanner(System.in);
	void InsertData()
	{
		System.out.println("Inserting the data into database");
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbURL,dbUser,dbPwd);
			Statement stm = con.createStatement();
			int rowCount=0;
			rowCount=stm.executeUpdate(sqlQuery1);
			if(rowCount>0) 
			{
				System.out.println("Data Inserted");
				System.out.println("If you want to see the data (Yes/No):");
				switch(sc.next())
				{
					case "Yes":
						ResultSet rs=stm.executeQuery(sqlQuery2);
						while(rs.next())
						{
							System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
						}
						break;
					case "No":
						System.out.println("Thank You!!!");
						break;
				}
			}
			else
			{
				System.out.println("Data Not Inserted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		  Jdbc_pro5 obj= new Jdbc_pro5();
		  obj.InsertData();
	}
}
