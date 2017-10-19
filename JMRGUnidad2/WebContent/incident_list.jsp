<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incident List</title>
</head>
<body>
	<table border="1">
		<tr>
		<th>
			<form action="IncidentController">
				<input type="submit" name="btn_new"
				value="New"/>
			</form>
		</th>
		<th>IncidentId</th>
		<th>ParentId</th>
		<th>Search</th>
		<th>Name</th>
		<th>Year</th>
		</tr>
		<c:forEach var="incident" items="${incidents}">
		<tr>
		<td>
		<form action="IncidentController">
			<input type="hidden" name="incidentId" value="${incident.incidentId}"/>
			<input type="submit" name="btn_edit" value="Edit"/>
			<input type="submit" name="btn_delete"value="Delete"/>
		</form>
		</td>
			<td>${incident.incidentId}</td>
			<td>${incident.parentId}</td>
			<td>${incident.searchId}</td>
			<td>${incident.name}</td>
			<td>${incident.year}</td>
		</tr>
		</c:forEach> <!-- Etiqueta de la libreria jstl -->
	</table>
</body>
</html>
