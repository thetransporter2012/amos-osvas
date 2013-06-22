import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.*;
public class LogInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/index.jsp")
            .forward(request, response);
    }

	public static final String[][] info = {{"Dirk", "AMOS"},
											{"Bosch", "AMOS"},
											{"Dominik", "AMOS"},
											{"Martin", "AMOS"},
											{"Radi", "AMOS"}};
											
	public static boolean check (String user, String pass){
		for (int i = 0; i < info.length; i++){
			if (user.equals(info[i][0])){
				if(pass.equals(info[i][1])){
					return true;
				} 
			}
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
		if(check(user, pass) == true) {
            
            request.getRequestDispatcher("/WEB-INF/homepage.jsp")
            .forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>"); 
			out.println("<html><head>");
			out.println("<title>" + "The AMOS Project, Group 3 - Open Source Vulnerability Assessment Service" + "</title></head>");
			out.println("<body>");
			out.println("<h1>" + "The AMOS Project, Group 3 - Open Source Vulnerability Assessment Service" + "</h1>");
			out.println("<a>Invalid password, please try again!</a>");
			out.println("</body></html>");
			//out.println(user);
			//out.println(pass);
			//out.println(check(user, pass));
		}
	}
}
