package pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Jdbc_pro16 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	Scanner sc=new Scanner(System.in);
	
	void meth1()
	{
		System.out.println("Implementing CallableStatement\n");
		
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(dbURL,dbUser,dbPwd);
			CallableStatement cstmt = con.prepareCall("{call insertData(?,?,?,?,?)}");
			
			System.out.println("Enter Eid:");
			String Eid=sc.nextLine();
			
			System.out.println("Enter EName:");
			String EName=sc.nextLine();
			
			System.out.println("Enter EDesg:");
			String EDesg=sc.nextLine();
			
			System.out.println("Enter EBSal:");
			int EBSal=Integer.parseInt(sc.nextLine());
			
			float ETSal=EBSal+(0.35f*EBSal)+(0.15f*EBSal);
			
			
			cstmt.setString(1,Eid);
			cstmt.setString(2,EName);
			cstmt.setString(3,EDesg);
			cstmt.setInt(4,EBSal);
			cstmt.setFloat(5,ETSal);
			
			
			cstmt.execute();
			
			System.out.println("Data Inserted!!!!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new Jdbc_pro16().meth1();		
	}
}
