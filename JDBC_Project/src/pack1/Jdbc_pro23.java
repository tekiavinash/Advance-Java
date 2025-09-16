package pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_pro23 
{
	String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser="system";
	String dbPwd="avinash";
	
	String sqlQuery="insert into mydata values(?,?)";
	String sqlQuery1="select pic_data from mydata where id=?";
	
	void meth1()
	{
		System.out.println("Inserting Image into DataBase");
		try
		{
			Connection con =DriverManager.getConnection(dbURL,dbUser,dbPwd);
			PreparedStatement pstmt=con.prepareCall(sqlQuery);
			pstmt.setString(1, "103");
			
			FileInputStream fis=new FileInputStream("C:\\Users\\saima\\OneDrive\\Pictures\\clg idcard.jpg");
			pstmt.setBlob(2, fis,fis.available());
			
			int rowCount=pstmt.executeUpdate();
			if(rowCount==0)
				throw new SQLException("Check the Code!!!!");
			System.out.println("Image Inserted Successfully!!!!\n");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void meth2()
	{
		System.out.println("Reterving Image into DataBase");
		try
		{
			Connection con =DriverManager.getConnection(dbURL,dbUser,dbPwd);
	
			
			PreparedStatement pstmt1=con.prepareStatement(sqlQuery1);
			pstmt1.setString(1, "103");
			ResultSet rs=pstmt1.executeQuery();
			if(rs.next())
			{
				Blob b=rs.getBlob(1);
				byte arr[]=b.getBytes(1, (int)b.length());
				FileOutputStream fos=new FileOutputStream("C:\\Users\\saima\\OneDrive\\Pictures\\clg idcard3.jpg");
				fos.write(arr);
				System.out.println("Image retervied");
				fos.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		Jdbc_pro23 obj=new Jdbc_pro23();		
		obj.meth1();
		obj.meth2();
	}
}
