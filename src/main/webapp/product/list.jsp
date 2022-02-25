<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 11/29/2021
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lisss</h1>
<a href="/products?action=create">Create New </a>
<c:forEach items='${requestScope["danhSach"]}' var="sp">
    <h2>${sp.id},${sp.name},${sp.price}
        <a href="/products?action=edit&id=${sp.id}">Edit</a>
        <a href="/products?action=delete&id=${sp.id}">Delete</a>
        <a href="/products?action=view&id=${sp.id}">view</a>
    </h2>
</c:forEach>
<a href="/products?action=findByName">Find relative</a>
<a href="/products?action=findByPrice">Find price</a>

</body>
</html>
