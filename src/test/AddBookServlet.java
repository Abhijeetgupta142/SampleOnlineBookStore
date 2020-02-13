package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class AddBookServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		String bCode = req.getParameter("bCode");
		String bName = req.getParameter("bName");
		String bAuthor = req.getParameter("bAuthor");
		float bPrice = Float.parseFloat(req.getParameter("bPrice"));
		int bQty = Integer.parseInt(req.getParameter("bQty"));
		BookBean bb = new BookBean();
		bb.setbCode(bCode);
		bb.setbName(bName);
		bb.setbAuthor(bAuthor);
		bb.setbPrice(bPrice);
		bb.setbQty(bQty);
		req.setAttribute("bean", bb);
		RequestDispatcher rd = req.getRequestDispatcher("update");
		rd.forward(req, res);
	}
}
