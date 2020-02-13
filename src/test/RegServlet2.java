package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class RegServlet2 extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		String ADDR = req.getParameter("addr");
		long PhNo = Long.parseLong(req.getParameter("phno"));
		String MailID = req.getParameter("mailid");
		ServletContext sct = this.getServletContext();
		UserRegBean urb = (UserRegBean)sct.getAttribute("regBean");
		urb.setAddr(ADDR);
		urb.setPhno(PhNo);
		urb.setMailid(MailID);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("User Registration Details are Valid");
		pw.println("<a href = 'vdetails'> ClickHere </a>");
		pw.println("To View the Details");
	}
}