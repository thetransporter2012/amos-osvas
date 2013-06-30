
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
import com.thoughtworks.xstream.*;
import javax.servlet.http.*;


/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "Upload";
    private static String uploadFilePath;
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // checks if the request actually contains upload file
        
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
		
		if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
 
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;
         
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        uploadFilePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(uploadFilePath);
 
                        // saves the file on disk
                        item.write(storeFile);
                        request.setAttribute("message",
                            "Upload erfolgreich abgeschlossen!");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
       
        
        //file is uploaded, the path is uploadFilePath
       
        
        String[] queries = null;
    	try {
			queries = Main.getTitles(uploadFilePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    	Vulnerabilities[] vulns = new Vulnerabilities[queries.length];
		for (int i = 0; i < queries.length; i++){
			String query = request.getParameter(queries[i]);
			vulns[i] = new Vulnerabilities(query);
		}
		
		if (null == vulns || vulns.length == 0) {
            response.getWriter().println("Request returned no results");
            return;
        }

		ArrayList<Vulnerability> vList = vulns[0].getVulnerabilities();
		
		for (int i = 1; i < vulns.length; i++){
			vList.addAll(vulns[i].getVulnerabilities());
		}
		
        for (Vulnerability v : vList) {
            ArrayList<VulnerabilityElement> vElements = v.getElements();

            XStream xstream = new XStream();
            String xml = xstream.toXML(v);
            response.getWriter().println(xml);
        }
    	
    	
    	
    	
    	
    	
    	
    	
        
        
        // redirects client to message page
      //getServletContext().getRequestDispatcher("/message.jsp").forward(
        //       request, response);
		//PrintWriter out = response.getWriter();
		//	out.println("everything is allright!"); 
    }
}
