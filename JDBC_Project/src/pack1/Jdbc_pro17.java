package pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class Jdbc_pro17 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd = "avinash";

	Scanner sc = new Scanner(System.in);
	
	void meth1()
	{
		System.out.println("Implementing Callable Statement\n");
		
		try
		{
			Connection con = DriverManager.getConnection(dbURL,dbUser,dbPwd);
			CallableStatement cstmt = con.prepareCall("{call reteriveData(?,?,?,?,?)}");
			
			
			System.out.println("Enter Eid:");
			String Eid=sc.next();
			
			cstmt.setString(1, Eid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.INTEGER);
			cstmt.registerOutParameter(5,Types.FLOAT);
			
			
			cstmt.execute();
			
			System.out.println("*******Employe Data*******");
			
			System.out.println("EmpId:"+Eid);
			System.out.println("EmpName:"+cstmt.getString(2));
			System.out.println("EmpDesg:"+cstmt.getString(3));
			System.out.println("EmpBSal:"+cstmt.getInt(4));
			System.out.println("EmpTSal:"+cstmt.getFloat(5));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro17().meth1();		
	}
}
