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
<h1>Welcome to Edit page</h1>
<form action="updateUom" method="post">
<pre>
 ID : <input type="text" name="uomId" value="${uom.uomId}" readonly="readonly"/>
 Type :<select name="uomType">
       <option "-1">-select-</option>
       <c:forEach items="${uomTypes}" var="ob">
        <c:choose>
         <c:when test="${uom.uomType eq ob.key}">
           <option value="${ob.key}" selected="selected">${ob.value}</option>
         </c:when>
         <c:otherwise>
            <option value="${ob.key}">${ob.value}</option>
         </c:otherwise>
        </c:choose>
       </c:forEach>
 </select>
 Model : <input type="text" name="uomModel" value="${uom.uomModel}"/>
 Created : <input type="text" value="${uom.createdDate}" readonly="readonly"/>
 Note : <textarea name="description">
     ${uom.description}
 </textarea>
 <input type="submit" value="update"/>
</pre>
</form>
</body>
</html>