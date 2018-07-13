<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to UOM Data Page!!</h1>
<table border="1">
<tr>
	<th>ID</th><th>TYPE</th><th>UOM</th><th>Created</th><th>Last Modified</th><th>Notes</th>
</tr>
<c:forEach items="${uoms}" var="uom">
<tr>
<td><c:out value="${uom.uomId}"/></td>
<td><c:out value="${uom.uomType}"/></td>
<td><c:out value="${uom.uomModel}"/></td>
<td><c:out value="${uom.createdDate}"/></td>
<td><c:out value="${uom.lastModifiedDate}"/></td>
<td><c:out value="${uom.description}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>


