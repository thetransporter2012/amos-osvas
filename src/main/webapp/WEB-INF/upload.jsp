<jsp:include page="header.jsp" />

<%
if(null == session.getAttribute("userName")){  
%>
<p>You must be logged in to access this functionality!</p>
<%
} else {
%>

<h1>Upload component list</h1>
<p>To query the database for components please upload a list of components in CSV format including at least the following columns:</p>

<ul>
    <li>Component</li>
    <li>Version</li>
</ul>

<p>The column names must be present in the first row of the file</p>

<form action="uploadFile" enctype="multipart/form-data" method="POST">
	<input type="file" name="file">
	<input type="submit" value="Upload">
</form>

<%
}
%>


<jsp:include page="footer.jsp" />
