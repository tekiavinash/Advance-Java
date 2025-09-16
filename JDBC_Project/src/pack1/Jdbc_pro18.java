package pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Jdbc_pro18 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd = "avinash";
	
	Scanner sc=new Scanner(System.in);
	
	void meth1()
	{
		System.out.println("Implementing the callableStatement with Functions\n");
		try
		{
			Connection con = DriverManager.getConnection(dbURL, dbUser, dbPwd);
			CallableStatement cstmt = con.prepareCall("{call ?:=ReteriveEmpSal(?)}");
			
			System.out.println("Enter Eid:");
			String Eid=sc.next();
			
			cstmt.registerOutParameter(1, Types.FLOAT);
			cstmt.setString(2, Eid);
			
			cstmt.execute();
			
				System.out.println("*******Employee Details*******");
				System.out.println("EmpId:"+Eid);
				System.out.println("EmpTsal:"+cstmt.getFloat(1));
			
			//con.close();
		}
		catch(SQLException se)
		{
			System.out.println("There is NO Data");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro18().meth1();		
	}
}
