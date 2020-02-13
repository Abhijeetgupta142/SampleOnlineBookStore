package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class FinalRegServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ServletContext sct = this.getServletContext();
		UserRegBean urb = (UserRegBean) sct.getAttribute("regBean");
		try {
			PreparedStatement ps = con.prepareStatement("insert into Users values(?,?,?,?,?,?,?)");
			ps.setString(1, urb.getUname());
			ps.setString(2, urb.getPword());
			ps.setString(3, urb.getFname());
			ps.setString(4, urb.getLname());
			ps.setString(5, urb.getAddr());
			ps.setLong(6, urb.getPhno());
			ps.setString(7, urb.getMailid());
			int k = ps.executeUpdate();
			if(k>0) {
				pw.println("User Registration Successful...<br>");
				RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
				rd.include(req, res);
			}
		}catch(Exception e) {}
		
	}
}
