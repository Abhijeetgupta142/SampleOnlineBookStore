package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class UpdateBookServlet extends GenericServlet {
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		BookBean bb = (BookBean)req.getAttribute("bean");
		ServletContext sct = this.getServletContext();
		String fname = (String)sct.getAttribute("fname");
		try {
			PreparedStatement ps = con.prepareStatement("insert into book17 values(?,?,?,?,?)");
			ps.setString(1, bb.getbCode());
			ps.setString(2, bb.getbName());
			ps.setString(3, bb.getbAuthor());
			ps.setFloat(4, bb.getbPrice());
			ps.setInt(5, bb.getbQty());
			int k = ps.executeUpdate();
			if(k>0) {
				pw.println("WELCOME" +fname+ "<br>");
				RequestDispatcher rd = req.getRequestDispatcher("Link1.html");
				rd.include(req, res);
				pw.println("<br> Book Data Updated Successfully...");
			}
		}catch(Exception e) {}
		
	}
}
