package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductDAO 
{
public ArrayList<ProductBean> al=new ArrayList<ProductBean>();
	
	
	public ArrayList<ProductBean> reterive()
	{
		try
		{	//ArrayList<EmployeeBean> al=new ArrayList<EmployeeBean>();

			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from product");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				ProductBean eb=new ProductBean();
				
				eb.setpCode(rs.getString(1));
				eb.setpName(rs.getString(2));
				eb.setpCompany(rs.getString(3));
				eb.setpPrice(rs.getString(4));
				eb.setpQty(rs.getString(5));
				
				al.add(eb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(al);
		return al;
	}
}
