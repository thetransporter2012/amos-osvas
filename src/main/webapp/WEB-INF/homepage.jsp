<jsp:include page="header.jsp" />

<%
if(null == session.getAttribute("userName")){  
%>
<p>You must be logged in to access this functionality!</p>
<%
} else {
%>


<h1>Open Source Vulnerability Assessment Service</h1>
<h2>The AMOS-Project, Group 3</h2>

<p>This tool is intended to aggregate several databases containing vulnerabilities of software components. The aim is to have one single webservice to access all databases at once.</p>
<p>Currently implemented are the following databases:</p>

<ul>
    <li><a href="http://www.osvdb.org/">Open Source Vulnerability Database</a>
        <p>They did not want to provide us with a working API? We built one based on HTML-parsing!</p>
    </li>
</ul>

<p>The following databases could be integrated in the future:</p>

<ul>
    <li>http://cvedetails.com/</li>
    <li>http://nvd.nist.gov/</li>
    <li>http://portal.cert.dfn.de/</li>
</ul>

<h3>Try out yourself</h3>
<p>Type in a query to search for:</p>
<form action="homepage" method="POST">
    <input type="text" value="" placeholder="Cisco" name="query" />
    <input type="submit" />
</form>
<script>
   
</script>


<%
}
%>


<jsp:include page="footer.jsp" />
