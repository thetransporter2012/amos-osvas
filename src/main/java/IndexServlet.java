import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.*;
import javax.servlet.http.*;

public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/homepage.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
		String user = (String)session.getAttribute("userName");
		if (user == null || user == ""){
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>"); 
			out.println("<html><head>");
			out.println("<title>" + "The AMOS Project, Group 3 - Open Source Vulnerability Assessment Service" + "</title></head>");
			out.println("<body>");
			out.println("<h1>" + "The AMOS Project, Group 3 - Open Source Vulnerability Assessment Service" + "</h1>");
			out.println("<a>You must be logged in to access this functionality!</a>");
			out.println("</body></html>");
			return;
		}
		
		String query = request.getParameter("query");

        Vulnerabilities req = new Vulnerabilities(query);
		
		long startTime = System.currentTimeMillis();
		
        ArrayList<Vulnerability> vulns = req.getVulnerabilities();
        if (null == vulns) {
            response.getWriter().println("Request returned no results");
            long estimatedTime = (System.currentTimeMillis() - startTime);
			response.getWriter().println("(" + estimatedTime + " milliseconds)");
			return;
        }
		/*
        response.getWriter().println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        response.getWriter().println("<?xml-stylesheet href=\"style.xls\" type=\"text/xsl\" ?>");

        response.getWriter().println("<root>");
		*/
        for (Vulnerability v : vulns) {
            ArrayList<VulnerabilityElement> vElements = v.getElements();

            XStream xstream = new XStream();
            String xml = xstream.toXML(v);

            response.getWriter().println(xml);
        }
        //response.getWriter().println("</root>");
		long estimatedTime = (System.currentTimeMillis() - startTime)/1000;
		response.getWriter().println("(" + estimatedTime + " seconds)");
			
    }
}
