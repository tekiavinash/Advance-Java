package pack1;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Jdbc_pro15 
{
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd = "avinash";
	String sqlQuery= "select Eid,EFname,Esal from Employee";
	
	void meth1()
	{
		System.out.println("Implementing Cached RowSet\n");
		try
		{
			RowSetFactory rsf= RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(dbURL);
			crs.setUsername(dbUser);
			crs.setPassword(dbPwd);
			crs.setCommand(sqlQuery);
			crs.execute();
			
			while(crs.next())
			{
				String id=crs.getString(1);
				if(id.equals("101"))
				{
					System.out.println("Updating the salary for Employee :"+id);
					crs.updateInt(3, 35000);
					crs.updateRow();
				}
			}
			//crs.acceptChanges();
			System.out.println("Data Updated!!!!\n");
			
			
			System.out.println("***************************");
			crs.beforeFirst();
			while(crs.next())
			{
				if(crs.getString(1).equals("101"))
				{
					System.out.println(crs.getString(1)+" "+crs.getString(2)+" "+crs.getInt(3));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new Jdbc_pro15().meth1();
	}
}
