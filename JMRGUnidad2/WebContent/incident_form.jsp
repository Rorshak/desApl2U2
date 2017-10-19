<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
</head>
<body> 
  <form action="IncidentController">
   <label>Parent:</label></br>
  	<input type="text" name="parentId" value="${incident.parentId}"/></br>
  <label>Search:</label></br>
  	<input type="text" name="searchId" value="${incident.searchId}"/></br>
  	<label>Name:</label></br>
  	<input type="text" name="name" value="${incident.name}"/></br>
  	<label>Year:</label></br>
  	  	<input type="number" name="year" value="${incident.year}"/></br>
<input type="submit" name="btn_save" value="Save"/>
  </form>
</body>
</html>