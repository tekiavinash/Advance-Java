package pack1;

import java.sql.Connection;
public class Jdbc_pro21
{
	
	String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser="system";
	String dbPwd="avinash";
	
	COnnection_pooling cp=new COnnection_pooling(dbURL,dbUser,dbPwd);
	
	void meth1()
	{
		System.out.println("Implementing Connection Pooling\n");
		
		cp.con_Initialization();
		
		System.out.println("\n*******User-1*******");
		System.out.println("===>"+cp.v.size());
		Connection con1=cp.con_Acquisition();
		System.out.println("Connection Acquired");
		System.out.println("===>"+cp.v.size());
		
		
		System.out.println("\n*******User-2*******");
		System.out.println("===>"+cp.v.size());
		Connection con2=cp.con_Acquisition();
		System.out.println("Connection Acquired");
		System.out.println("===>"+cp.v.size());
		
		
		System.out.println("\n*******User-3*******");
		System.out.println("===>"+cp.v.size());
		Connection con3=cp.con_Acquisition();
		System.out.println("Connection Acquired");
		System.out.println("===>"+cp.v.size());
		
		
		cp.con_ReturnConnectionObject(con1);
		cp.con_ReturnConnectionObject(con2);
		cp.con_ReturnConnectionObject(con3);
	}
	public static void main(String[] args) 
	{
		Jdbc_pro21 obj=new Jdbc_pro21();	
		obj.meth1();
	}
}
