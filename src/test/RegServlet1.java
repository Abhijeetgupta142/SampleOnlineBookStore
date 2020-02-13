package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class RegServlet1 extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		String fName = req.getParameter("fname");
		String lName = req.getParameter("lname");
		UserRegBean urb = new UserRegBean();
		urb.setUname(uName);
		urb.setPword(pWord);
		urb.setFname(fName);
		urb.setLname(lName);
		ServletContext sct = this.getServletContext();
		sct.setAttribute("regBean", urb);
		RequestDispatcher rd = req.getRequestDispatcher("Register2.html");
		rd.forward(req, res);
	}
}
