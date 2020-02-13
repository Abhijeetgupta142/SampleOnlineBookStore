package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class ViewBooksServlet extends GenericServlet {
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
		String fname = (String)sct.getAttribute("fname");
		try {
			PreparedStatement ps = con.prepareStatement("select * from book17");
			ResultSet rs = ps.executeQuery();
			pw.println("WELCOME" +fname+ "<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Link1.html");
			rd.include(req, res);
			pw.println("<br>---Book Details---");
			while(rs.next()) {
				pw.println("<br>" +rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getFloat(4)+"&nbsp&nbsp"+rs.getInt(5));
			}
		}catch(Exception e) {}	
	}
}
