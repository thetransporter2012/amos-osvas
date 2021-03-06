<!DOCTYPE html>
<html lang="en">
  
  <head>
    <meta charset="utf-8">
	<base href="${pageContext.request.contextPath}/WEB-INF">
    <title>The AMOS Project, Group 3 - Open Source Vulnerability Assessment Service</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="css/bootstrap.css" rel="stylesheet">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="ico/favicon.png">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="index">AMOS-OSVAS</a>
			
		<%
		if (session.getAttribute( "userName" ) != null){
		%>
	
		 <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="homepage">Home</a></li>
              <li><a href="upload">Upload</a></li>
			</ul>
         </div><!--/.nav-collapse -->
		 <div class="nav-collapse collapse" >
		    <ul class="nav" style="text-align:right">
			  <li><a href = "index">Hello <%= session.getAttribute( "userName" ) %>, Log out</a></li>
		    </ul>
		 </div>
		 
		<%
		}
		%> 
		 
        </div>
      </div>
    </div>

    <div class="container">
