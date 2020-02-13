package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class UserLoginServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String Uname = req.getParameter("uname");
		String Pword = req.getParameter("pword");
		try {
			PreparedStatement ps = con.prepareStatement("select * from usertab17 where uname = ? and pass = ?");
			ps.setString(1, Uname);
			ps.setString(2, Pword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pw.println("WELCOME:" +rs.getString(3));
				ServletContext sct = this.getServletContext();
				sct.setAttribute("fname", rs.getString(3));
				RequestDispatcher rd = req.getRequestDispatcher("Link2.html");
				rd.include(req, res);
			}else {
				pw.println("Invalid uname or pword<br>");
				RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
				rd.include(req, res);
			}
		}catch(Exception e) {}
	}
}
