package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class LoginServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException ,IOException{
		String Submit = req.getParameter("submit");
		if(Submit.equals("Admin")) {
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, res);
		}else
		{
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
			rd.forward(req, res);
		}
	}
}
