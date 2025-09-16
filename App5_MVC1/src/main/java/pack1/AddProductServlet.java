package pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		ProductBean pbean = new ProductBean();
		
		pbean.setpCode(req.getParameter("pCode"));
		pbean.setpName(req.getParameter("pName"));
		pbean.setpCompany(req.getParameter("pCompany"));
		pbean.setpPrice(req.getParameter("pPrice"));
		pbean.setpQty(req.getParameter("pQty"));
		
		AddproductDAO  pDAO = new AddproductDAO ();
		int rowCount = pDAO.insertData(pbean);
		
		if(rowCount>0)
		{
			req.setAttribute("msg", "Data Inserted Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("Addproduct.jsp");
			rd.forward(req, res);
		}
		
	}
}
