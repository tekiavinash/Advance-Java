package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro7
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	//String sqlQuery1="insert into Employee values('107','Raj','Shekhar',65000,'Nrt')";
	//String sqlQuery2 = "select*from Employee";
	
	Scanner sc=new Scanner(System.in);
	void InsertData()
	{
		System.out.println("Inserting the data into database ar runtime");
		
		System.out.println("Enter your EmpId:");
		String empId=sc.nextLine();
		System.out.println("Enter your EmpFName:");
		String empFName=sc.nextLine();
		System.out.println("Enter your EmpLName:");
		String empLName=sc.nextLine();
		System.out.println("Enter your EmpSal:");
		int empSal=Integer.parseInt(sc.nextLine());
		System.out.println("Enter your EmpAddress:");
		String empAddress=sc.nextLine();
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbURL,dbUser,dbPwd);
			Statement stm = con.createStatement();
			int rowCount=stm.executeUpdate("insert into Employee values('"+empId+"','"+empFName+"','"+empLName+"','"+empSal+"','"+empAddress+"')");
			if(rowCount>0)
			{
				System.out.println("Data Inserted");
				
			}				
			else
			{
				System.out.println("Data not Inserted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		  Jdbc_pro7 obj= new Jdbc_pro7();
		  obj.InsertData();
	}
}

