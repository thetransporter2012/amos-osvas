<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<!-- 
 - Copyright (c) 2013 by The AMOS project, Group 3, http://osr.cs.fau.de/2013/04/17/the-2013-amos-projects-start-today/
 -
 - This file is part of the AMOS OSVAS application.
 -
 - This program is free software: you can redistribute it and/or modify
 - it under the terms of the GNU Affero General Public License as
 - published by the Free Software Foundation, either version 3 of the
 - License, or (at your option) any later version.
 -
 - This program is distributed in the hope that it will be useful, 
 - but WITHOUT ANY WARRANTY; without even the implied warranty of
 - MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 - GNU Affero General Public License for more details.
 -
 - You should have received a copy of the GNU Affero General Public
 - License along with this program. If not, see
 - <http://www.gnu.org/licenses/>.
 -->
<html>
<body bgcolor="#E6E6FA">
<h1>Open Source Vulnerability Assessment Service</h1>
<h2>AMOS SS13 Project 3</h2>
<h3>University Erlangen-Nürnberg</h3>

<p>Give the name and the version here:</p>
<form method="post">
  Software name: <input type="text" name="name"><br>
	Version: <select value="version">
		<option value="option1">Option 1</option>
		<option value="option2">Option 2</option>
		<option value="...">...</option>
	</select><br><br>
	<button type = "submit" 
			value = "Search"
			width = "100"
			style="height:25px; width:60px"
			id = "Search"
			class = "Search">Search</button> 
	<button type = "submit" 
			value = "I feel lucky"
			width = "100"
			style="height:25px; width:100px"
			id = "iFeelLucky"
			class = "iFeelLucky">I feel lucky!</button>
</form>
</body>
</html>