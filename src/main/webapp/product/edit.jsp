<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 11/29/2021
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="number" name="id" value="${pEdit.id}">
    <input type="text" name="name" value="${pEdit.name}">
    <input type="number" name="price" value="${pEdit.price}">

    <button>Edit</button>
</form>
</body>
</html>
