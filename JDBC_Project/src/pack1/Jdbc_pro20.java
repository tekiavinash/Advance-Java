package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Jdbc_pro20 
{
	String driver="oracle.jdbc.OracleDriver";
	String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser="system";
	String dbPwd="avinash";
	String sqlQuery1="update trainseatavailability set Available_Seats=Available_Seats-1 where Train_Id=? and Journey_Date=? and class=? and Available_seats>0";
	String sqlQuery2="insert into bookingdetails values(?,?,?,?,?)";
	String sqlQuery3="select payment_status from customerpayment where customar_id=?";
	String sqlQuery4="update bookingdetails set status='Payment-Confirmed' where customar_id=?";
	
	void meth1()
	{
		System.out.println("Implementing Transaction Management\n");
		
		try
		{
			Connection con=DriverManager.getConnection(dbURL, dbUser, dbPwd);
			System.out.println("Database Connected");
			
			System.out.println("getAutoCommit():"+con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("getAutoCommit():"+con.getAutoCommit());
			
			PreparedStatement pstmt1=con.prepareStatement(sqlQuery1);
			pstmt1.setString(1, "12345");
			pstmt1.setString(2, "2024-10-10");
			pstmt1.setString(3, "Sleeper");
			
			int rowCount1=pstmt1.executeUpdate();
			if(rowCount1==0)
			{
				throw new SQLException("There are NO Seats");
			}
			System.out.println("Seat is Locked But Not Yet Confirmed!!!");
			Savepoint sp1=con.setSavepoint();
			
			
			PreparedStatement pstmt2=con.prepareStatement(sqlQuery2);
			pstmt2.setString(1, "B101");
			pstmt2.setString(2, "12345");
			pstmt2.setString(3, "C123");
			pstmt2.setInt(4, 20);
			pstmt2.setString(5, "Pending-Payment");
			
			int rowCount2=pstmt2.executeUpdate();
			if(rowCount2==0)
			{
				throw new SQLException("Booking record NOT Created");
			}
			System.out.println("Booking record Created & waiting for Payment status");
			
			
			PreparedStatement pstmt3=con.prepareStatement(sqlQuery3);
			pstmt3.setString(1,"C123");
			ResultSet rs=pstmt3.executeQuery();
			String status="Failed";
			if(rs.next())
			{
				status=rs.getString(1);
				if(status.equals("success"))
				{
					PreparedStatement pstmt4=con.prepareStatement(sqlQuery4);
					pstmt4.setString(1, "C123");
					int rowCount3=pstmt4.executeUpdate();
					if(rowCount3==0)
					{
						throw new SQLException("Payment Failed");
					}
					System.out.println("Seat Confirmed");
					System.out.println("Ticket generated!!!");
					con.commit();
					System.out.println("Save-Points Released");
				}
				else
				{
					System.out.println("Payment NOT Done!!!");
					System.out.println("Transaction rolledback to last savepoint");
					con.rollback(sp1);
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
		new Jdbc_pro20().meth1();		
	}
}
