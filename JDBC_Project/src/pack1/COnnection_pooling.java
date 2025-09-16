package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class COnnection_pooling 
{
	String dbURL,dbUname,dbPwd;
	
	Vector<Connection> v=new Vector<Connection>();

	public COnnection_pooling(String dbURL, String dbUname, String dbPwd) 
	{
		super();
		this.dbURL = dbURL;
		this.dbUname = dbUname;
		this.dbPwd = dbPwd;
	}
	void con_Initialization()
	{
		System.out.println("Initializing Connection_Pool");
		System.out.println("Connectio pool is Emplty\n");
		while(v.size()<5)
		{
			try
			{
				Connection con=DriverManager.getConnection(dbURL, dbUname, dbPwd);
				v.addElement(con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		for(Object o:v)
		{
			System.out.println(o);
		}		
	}
	Connection con_Acquisition()
	{
		System.out.println("Assigining a Connectio Object");
		Connection con=v.get(0);
		v.remove(0);
		return con;		
	}
	void con_ReturnConnectionObject(Connection con)
	{
		System.out.println("Adding Connection Object back into Connectio Pool");
		v.addElement(con);
		System.out.println("--------------------");
		for(Object o:v)
		{
			System.out.println(o);
		}
		System.out.println("--------------------");
	}
}
