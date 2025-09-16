package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO 
{
	public int deleteProduct(String pCode)
	{
		int rowCount=0;
		try
		{
			Connection con = DBConnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("delete from product where PCODE=?");
			pstmt.setString(1, pCode);
			rowCount = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}
}
