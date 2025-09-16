package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/dis")
public class DisplayServlet extends HttpServlet
{
	public DisplayServlet()
	{
		System.out.println("Servlet Instantiated");
	}
	@Override
	public void init()
	{
		System.out.println("Servlet Intialized");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		System.out.println("Servlet Request Handling Started");
		req.getRequestDispatcher("Display.jsp").forward(req, res);
	}
	@Override
	public void destroy()
	{
		System.out.println("Servlet Destroyed");
	}
}
