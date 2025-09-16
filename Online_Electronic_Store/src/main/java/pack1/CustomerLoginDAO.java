package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO
{
	public CustomerBean checkCustomerLogin(String cUsername,String cPassword)
	{
		CustomerBean cbean=null;
		try
		{
			Connection con = DBConnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("select*from customer where uname=? and pword=?");
			pstmt.setString(1, cUsername);
			pstmt.setString(2, cPassword);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				cbean = new CustomerBean();
				cbean.setuName(rs.getString(1));
				cbean.setuPassword(rs.getString(2));
				cbean.setuFirstName(rs.getString(3));
				cbean.setuLastName(rs.getString(4));
				cbean.setuAddress(rs.getString(5));
				cbean.setuMailId(rs.getString(6));
				cbean.setuPhone(rs.getString(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cbean;
	}
}