package pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/crs")
public class CustomerRegistrationServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		CustomerBean cbean = new CustomerBean();
		
		cbean.setuName(req.getParameter("uname"));
		cbean.setuPassword(req.getParameter("cpwd"));
		cbean.setuFirstName(req.getParameter("cfname"));
		cbean.setuLastName(req.getParameter("clname"));
		cbean.setuAddress(req.getParameter("caddr"));
		cbean.setuMailId(req.getParameter("cmail"));
		cbean.setuPhone(req.getParameter("cphone"));
		
		CustomerRegisterDAO crDAO = new CustomerRegisterDAO();
		int rowCount = crDAO.insertCustomerData(cbean);
		
		if(rowCount>0)
		{
			req.setAttribute("msg","Data Inserted Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("CustomerRegister.jsp");
			rd.forward(req, res);
		}
	}
}