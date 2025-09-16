package pack1;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Jdbc_pro14 
{
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd = "avinash";
	String sqlQuery= "select*from Employee";
	
	void meth1()
	{
		System.out.println("Implementing JdbcRowSet Interface:\n");
		try
		{
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet jrs = rsf.createJdbcRowSet();
			jrs.setUrl(dbURL);
			jrs.setUsername(dbUser);
			jrs.setPassword(dbPwd);
			jrs.setCommand(sqlQuery);
			jrs.execute();
			
			while(jrs.next())
			{
				System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			}
			
			System.out.println("**************************************");
			jrs.afterLast();
			while(jrs.previous())
			{
				System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));

			}
			
			System.out.println("**************************************");
			jrs.beforeFirst();
			while(jrs.next())
			{
				System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro14().meth1();		
	}
}
