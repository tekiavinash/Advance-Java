package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro9 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	String sqlQuery1="select*from ";
	String sqlQuery2="insert into Library values('106','Mother India','Katherine Mayo')";
	String sqlQuery3="delete from Library where Bookid=106";
	
	Scanner sc=new Scanner(System.in);
	
	Connection testConnect()
	{
		Connection con=null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(dbURL,dbUser,dbPwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	void meth1()
	{
		System.out.println("Reteriving the data from the table");
		System.out.println("Enter the table name:");
		String tName=sc.next();
		try
		{
			Connection con=testConnect();
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery1.concat(tName));
			if(rs==null)
			{
				System.out.println("There is no table with the name "+tName);
			}
			else
			{
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));					
				}
			}
		}
		catch(SQLSyntaxErrorException ssee)
		{
			System.out.println("There is no table with the name "+tName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	void meth2()
	{
		System.out.println("Inserting the data into database");
		System.out.println("Enter Bookid:");
		String Bookid=sc.nextLine();
		
		System.out.println("Enter Bookname:");
		String Bookname=sc.nextLine();
		
		System.out.println("Enter author:");
		String Author=sc.nextLine();
		
		try
		{
			Connection con=testConnect();
			Statement stm=con.createStatement();
			int rowCount=stm.executeUpdate("insert into Library values('"+Bookid+"','"+Bookname+"','"+Author+"')");
			if(rowCount>0)
			{
				System.out.println("Data Inserted");
				meth1();
			}
			else
			{
				System.out.println("Data is NOT Inserted");
			}
		}
		catch(SQLIntegrityConstraintViolationException sicve)
		{
			System.out.println("Duplicate Eid's are not allowed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	void meth3()
	{
		System.out.println("Deleting the Data From the database");
		System.out.println("Enter Bookid:");
		String Bookid=sc.nextLine();
		
		try
		{
			Connection con=testConnect();
			Statement stm=con.createStatement();
			int rowCount=stm.executeUpdate("delete from Library where Bookid='"+Bookid+"'");
			if(rowCount>0)
			{
				System.out.println("Data Deleted");
				meth1();
			}
			else
			{
				System.out.println("There is NO record with Bookid "+Bookid);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		Jdbc_pro9 obj= new Jdbc_pro9();	
		//obj.meth1();
		//obj.meth2();
		obj.meth3();
	}
}
