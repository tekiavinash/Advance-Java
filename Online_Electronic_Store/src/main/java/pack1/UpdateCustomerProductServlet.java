package pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Buy")
public class UpdateCustomerProductServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException,NumberFormatException
	{
		HttpSession session = req.getSession();
		if(session == null)
		{
			session.setAttribute("msg", "Session Expired!!!");
			RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.html");
			rd.forward(req, res);
		}
		else
		{
			String pCode = (String)req.getParameter("pcode");
			//System.out.println(pCode);
			
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("ProductsList");
			ProductBean pb=null;
			
			Iterator<ProductBean> i = al.iterator();
			while(i.hasNext())
			{
				pb = i.next();
				if(pCode.toString().equals(pb.getpCode()))
				{
					break;
				}
			}
			String pQty = req.getParameter("pqty").trim();
			String rqNo = req.getParameter("rqNo").trim();
			System.out.println(rqNo);
			
			int pqty1 = Integer.valueOf(pQty);
			
			int rQno = Integer.parseInt(rqNo);
			int Qty = pqty1-rQno;
			
			String PQTY = Integer.toString(Qty);
			//System.out.println(PQTY);
			pb.setpQuantity(PQTY);
			
			int rowCount = new UpdateCustomerProductDAO().updateCustomerProduct(pb);
			
			if(rowCount>0)
			{
				//System.out.println("*********************");
				RequestDispatcher rd = req.getRequestDispatcher("OrdereConfirmed.jsp");
				rd.forward(req, res);
			}
			else
			{
				System.out.println("Data NOT inserted");
			}
		}
	}
}