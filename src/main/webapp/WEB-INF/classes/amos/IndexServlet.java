import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Compare() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = (request.getParameter("param1"));
		String b = (request.getParameter("param2"));
	
		boolean identical = a.compareTo(b) == 0;
		response.getWriter().println(identical);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}