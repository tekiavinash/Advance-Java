package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateCustomerProductDAO 
{
    public int updateCustomerProduct(ProductBean pb) 
    {
        int rowCount = 0;
        try 
        {
            Connection con = DBConnect.getCon();
            PreparedStatement pstmt = con.prepareStatement("update product set PQTY=? where PCODE=?");
            pstmt.setString(1, pb.getpQuantity());
            pstmt.setString(2, pb.getpCode());
            rowCount = pstmt.executeUpdate();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }

        return rowCount;
    }
}