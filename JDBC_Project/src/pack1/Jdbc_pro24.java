package pack1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_pro24
{
	String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser="system";
	String dbPwd="avinash";
   
   String sqlQuery1="insert into mydata2 values (?,?)";
   String sqlQuery2="select File_Data from mydata2 where id=?";
   
    void meth1()
    {
    	System.out.println("Inserting Text File as CLOB into database");
	    try
	    {
	       Connection con = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		    PreparedStatement pstm = con.prepareStatement(sqlQuery1);
		    System.out.println("Database connected Successfully!!!\n");
		    pstm.setString(1, "103");    
		    BufferedReader br = new BufferedReader(new FileReader("C:\\java\\tables.txt"));    
		    pstm.setClob(2, br);    
	   
		    int rowCount = pstm.executeUpdate();
		    if (rowCount == 0)    
		    throw new SQLException("Insert operation failed, no rows affected.");    
		    System.out.println("Text file inserted as CLOB successfully");
	    }
	    catch (Exception e)
	    {
	    e.printStackTrace();
	    }
   }
   void meth2()
   {
       System.out.println("Reteriving Data from database");
       
       try
       {
           Connection con=DriverManager.getConnection(dbURL, dbUser, dbPwd);
           System.out.println("Database connected Successfully!!!\n");
           PreparedStatement pstm=con.prepareStatement(sqlQuery2);
           pstm.setString(1, "101");
           ResultSet rs=pstm.executeQuery();
           if(rs.next())
           {
               Clob b=rs.getClob(1);
               Reader data=b.getCharacterStream();
               BufferedReader br=new BufferedReader(data);
               FileWriter fw=new FileWriter("C:\\java\\tables2.txt");
               String line;
               while((line=br.readLine())!=null)
               {
                   fw.write(line);
                   fw.write("\n");
               }
               br.close();
               fw.close();
               System.out.println("Clob data Reterived");
           }
           else
           {
               throw new SQLException("Invalid Id");
           }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
   public static void main(String[] args)
   {
       Jdbc_pro24 obj=new Jdbc_pro24();        
       obj.meth1();
       obj.meth2();
   }
}
