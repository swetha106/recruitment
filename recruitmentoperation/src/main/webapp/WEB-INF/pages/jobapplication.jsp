<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <form:form id="regForm"  modelAttribute="job" action="uploadresume" enctype="multipart/form-data"
		method="post">
  		
		<table >
		<tr>
				<td><form:label path="marks">marks</form:label></td>
				<td><form:input   path="marks" name="marks" id="marks" /></td>
			</tr>
			<input type="hidden" path="id"  name="id" value="${usersession.id}">
		
		
			
		<td><form:button id="upload" name="upload">upload</form:button></td>
		
					
		
		</table>
	</form:form>
	
</body>
</html>