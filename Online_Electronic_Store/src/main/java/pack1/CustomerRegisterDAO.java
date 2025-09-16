package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegisterDAO 
{
	public int insertCustomerData(CustomerBean cb)
	{
		int rowCount=0;
		Connection con=DBConnect.getCon();
		try
		{
			PreparedStatement pstmt=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			
			pstmt.setString(1, cb.getuName());
			pstmt.setString(2, cb.getuPassword());
			pstmt.setString(3, cb.getuFirstName());
			pstmt.setString(4, cb.getuLastName());
			pstmt.setString(5, cb.getuAddress());
			pstmt.setString(6, cb.getuMailId());
			pstmt.setString(7, cb.getuPhone());
			rowCount=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return rowCount;
	}
}
