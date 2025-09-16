package pack1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Jdbc_pro22 
{
	String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser="system";
	String dbPwd="avinash";
	String sqlQuery="select efname,elname from employee where eid=?";
	String sqlQuery1="select efname,elname from employee where eid=101";
	
	void meth1()
	{
		System.out.println("Implementing Meta Data In JDBC\n");
		
		try
		{
			Connection con=DriverManager.getConnection(dbURL, dbUser, dbPwd);
			System.out.println("************Database Meta Data************\n");
			DatabaseMetaData dmdt=con.getMetaData();
			System.out.println("DatabaseProductName: "+dmdt.getDatabaseProductName());
			System.out.println("\nDatabaseProductVersion: "+dmdt.getDatabaseProductVersion());
			System.out.println("\nDriverName: "+dmdt.getDriverName());
			System.out.println("\nsupportsStoredProcedures: "+dmdt.supportsStoredProcedures());
			PreparedStatement pstmt=con.prepareStatement(sqlQuery);
			pstmt.setString(1, "101");
			ParameterMetaData pmtdt=pstmt.getParameterMetaData();
			System.out.println("\n************Parameter Meta Data************\n");
			System.out.println("getParameterCount():"+pmtdt.getParameterCount());
			System.out.println("getParameterType(int param):"+pmtdt.getParameterType(1));
			System.out.println("getParameterMode(int param):"+pmtdt.getParameterMode(1));
			System.out.println("isNullable(int param):"+pmtdt.isNullable(1));
			
			ResultSet rs=pstmt.executeQuery();
			ResultSetMetaData rsmdt=rs.getMetaData();
			System.out.println("\n************ResultSet Meta Data************\n");
			System.out.println("getColumnCount():"+rsmdt.getColumnCount());
			System.out.println("getColumnName(int column):"+rsmdt.getColumnName(1));
			System.out.println("getColumnDisplaySize(int column):"+rsmdt.getColumnDisplaySize(1));
			System.out.println("isAutoIncrement(int column):"+rsmdt.isAutoIncrement(1));
						
			RowSetFactory rsf=RowSetProvider.newFactory();
			CachedRowSet crs=rsf.createCachedRowSet();
			
			crs.setUrl(dbURL);
			crs.setUsername(dbUser);
			crs.setPassword(dbPwd);
			crs.setCommand(sqlQuery1);
			
			crs.execute();
			
			RowSetMetaData rowSetdt=(RowSetMetaData)crs.getMetaData();
			System.out.println("\n************RowSet Meta Data************\n");
			System.out.println("getColumnCount():"+rowSetdt.getColumnCount());
			System.out.println("getColumnName(int column):"+rowSetdt.getColumnName(2));
			System.out.println("getColumnType(int column):"+rowSetdt.getColumnType(2));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro22().meth1();		
	}
}
