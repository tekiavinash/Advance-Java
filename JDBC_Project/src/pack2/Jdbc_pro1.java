package pack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc_pro1 
{
	String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser="system";
	String dbPwd="avinash";
	
	String sqlQuery1="select balance from accounts where account_id=? for update";
	String sqlQuery2="update accounts set balance=balance - ? where account_id=?";
	String sqlQuery3="update accounts set balance=balance + ? where account_id=?";
	
	public void transferMoney(int senderId, int receiverId,double amount)
	{
		System.out.println("implementing the Transaction between two persons:\n");
		try
		{
			Connection con=DriverManager.getConnection(dbURL, dbUser, dbPwd);
			con.setAutoCommit(false);
			
			PreparedStatement pstmt1=con.prepareStatement(sqlQuery1);
			PreparedStatement pstmt2=con.prepareStatement(sqlQuery2);
			PreparedStatement pstmt3=con.prepareStatement(sqlQuery3);
			
			pstmt1.setInt(1, senderId);
			ResultSet rs=pstmt1.executeQuery();
			
			if(rs.next())
			{
				double senderBalance=rs.getDouble("balance");
				if(senderBalance>=amount)
				{
					pstmt2.setDouble(1,amount);
					pstmt2.setInt(2, senderId);
					pstmt2.executeUpdate();
					
					pstmt3.setDouble(1, amount);
					pstmt3.setInt(2, receiverId);
					pstmt3.executeUpdate();
					
					
					con.commit();
					System.out.println("Money transferred successfully.\n");
					
				}
				else
				{
					con.rollback();
					
					System.out.println("Insufficient balance.\n");
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
		Jdbc_pro1 obj=new Jdbc_pro1();
		obj.transferMoney(1234567890,2135647890, 2000);
	}
}
