import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.*;
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/homepage.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");

        Vulnerabilities req = new Vulnerabilities(query);

        ArrayList<Vulnerability> vulns = req.getVulnerabilities();
        if (null == vulns) {
            response.getWriter().println("Request returned no results");
            return;
        }

        for (Vulnerability v : vulns) {
            ArrayList<VulnerabilityElement> vElements = v.getElements();

            XStream xstream = new XStream();
            String xml = xstream.toXML(v);
            response.getWriter().println(xml);
        }
    }
}
