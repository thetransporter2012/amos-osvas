<jsp:include page="header.jsp" />

<h1>Open Source Vulnerability Assessment Service</h1>
<h2>The AMOS-Project, Group 3</h2>

<p>This tool is intended to aggregate several databases containing vulnerabilities of software components. The aim is to have one single webservice to access all databases at once.</p>

<center>
<h3>Please sign in to continue</h3>
<form action="index" method="post">
    <table>
        <tr>
            <td> Username  : </td><td> <input name="user" size=20 type="text" /> </td> 
        </tr>
        <tr>
            <td> Password  : </td><td> <input name="pass" size=20 type="password" /> </td> 
        </tr>
    </table>
	<input type="submit" value="login" />
</form>

</center>

   
</script>
<jsp:include page="footer.jsp" />
