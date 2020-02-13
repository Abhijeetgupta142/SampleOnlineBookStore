package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class AdminLoginServlet extends GenericServlet {
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		try {
			PreparedStatement ps = con.prepareStatement("select * from AdminTab17 where uname =? and pword=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ServletContext sct = this.getServletContext();
				sct.setAttribute("fname", rs.getString(3));
				pw.println("WELCOME:" +rs.getString(3) + "<br>" );
				RequestDispatcher rd = req.getRequestDispatcher("Link1.html");
				rd.include(req, res);
			}
		}catch(Exception e) {}
	}
}
