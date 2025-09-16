package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro8 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	String sqlQuery1="select*from ";
	String sqlQuery2="insert into Employee values('108','Manoj','Kumar',45000,'Nrt')";
	String sqlQuery3="select*from Employee where eid='108'";
	String sqlQuery4="update Employee set ESal=50000 where Ei=108";
	String sqlQuery5="delete from Employee where Eid=105";
	
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
		System.out.println("Inserting the data into Employee Table:");
		try
		{
			Connection con=testConnect();
			Statement stm =con.createStatement();
			
			System.out.println("Enter Eid:");
			String Eid=sc.nextLine();
			
			System.out.println("Enter EFname:");
			String EFname=sc.nextLine();
			
			System.out.println("Enter ELname:");
			String ELname=sc.nextLine();
			
			System.out.println("Enter ESal:");
			int ESal=Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter EAddress:");
			String EAddress=sc.nextLine();
			
			int rowCount = stm.executeUpdate("insert into Employee values('"+Eid+"','"+EFname+"','"+ELname+"',"+ESal+",'"+EAddress+"')");
			if(rowCount>0)
			{
				System.out.println("Data Inserted\n");
				meth1();
			}
			else
			{
				System.out.println("Data is Not Inserted");
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
		System.out.println("Reteriving Specific data from Employee table");
		System.out.println("Enter Eid:");
		String Eid=sc.nextLine();
		try
		{
			Connection con=testConnect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select*from Employee where Eid='"+Eid+"'");
			if(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			else
			{
				System.out.println("There is NO record with Employee id:"+Eid);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void meth4()
	{
		System.out.println("Updating the Specific data:");
		System.out.println("Enter Eid:");
		String Eid=sc.nextLine();
		System.out.println("Enter Updated Salary:");
		int ESal=Integer.parseInt(sc.nextLine());
		
		try
		{
			Connection con=testConnect();
			Statement stm=con.createStatement();
			int rowCount=stm.executeUpdate("update Employee set ESal='"+ESal+"' where Eid='"+Eid+"'");
			if(rowCount>0)
			{
				System.out.println("Data Upated\n");
				meth1();
			}
			else
			{
				System.out.println("There is NO record with "+Eid);
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void meth5()
	{
		System.out.println("Deleting the Specific data:");
		System.out.println("Enter Eid:");
		String Eid=sc.nextLine();
		
		try
		{
			Connection con=testConnect();
			Statement stm=con.createStatement();
			int rowCount=stm.executeUpdate("delete from Employee where Eid='"+Eid+"'");
			if(rowCount>0)
			{
				System.out.println("Data Deleted\n");
				meth1();
			}
			else
			{
				System.out.println("There is NO record with "+Eid);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		 Jdbc_pro8 obj = new Jdbc_pro8();	
		 obj.meth1();
		 //obj.meth2();
		 //obj.meth3();
		//obj.meth4();
		 //obj.meth5();
	}
}
