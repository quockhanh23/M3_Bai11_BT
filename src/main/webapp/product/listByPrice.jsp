<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 11/30/2021
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Id, Name, Price</h1>
<c:forEach items='${ListPrice}' var="sp">
    <h2>${sp.id},${sp.name},${sp.price}</h2>
</c:forEach>
</body>
</html>
