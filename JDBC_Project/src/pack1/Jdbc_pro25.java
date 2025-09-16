package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro25 
{
	String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser="system";
	String dbPwd="avinash";
	
	Scanner sc=new Scanner(System.in);
	
	void meth1()
	{
		System.out.println("Implementing Batch Processing:\n");
		
		try
		{
			Connection con=DriverManager.getConnection(dbURL, dbUser, dbPwd);
			Statement stmt=con.createStatement();
			
			System.out.println("How Many SQL Queries you want to add to the batch:");
			int no_Queries=Integer.parseInt(sc.nextLine());
			
			for(int i=1;i<=no_Queries;i++)
			{
				System.out.println("Enter your"+i+"query!!");
				stmt.addBatch(sc.nextLine());
			}
			System.out.println("\n All the Queries are added to the batch");
			
			int arr[]=stmt.executeBatch();
			
			for(int x:arr)
			{
				System.out.println("*******"+x+"*******");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro25().meth1();		
	}
}
