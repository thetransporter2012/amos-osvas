import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Upload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Compare() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("get!!");

        String a = (request.getParameter("param1"));
        String b = (request.getParameter("param2"));

        boolean identical = a.compareTo(b) == 0;
        response.getWriter().println(identical);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post!!");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		MultipartRequest multi = new MultipartRequest(request, "\tmp");

		Enumeration files = multi.getFileNames();
		while (files.hasMoreElements()) {
		  String name = (String) files.nextElement();
		  String filename = multi.getFilesystemName(name);
		  String type = multi.getContentType(name);
		  File f = multi.getFile(name);
		  out.println( "name: " + name);
		  out.println( "filename: " + filename);
		  out.println( "type: " + type);
		  if (f != null)
		  {
		    out.println( "f.toString(): " + f.toString());
    		out.println( "f.getName(): " + f.getName());
    		out.println( "f.exists(): " + f.exists());
    		out.println( "f.length(): " + f.length());
    		out.println();
  		  }
		}
    }
}
