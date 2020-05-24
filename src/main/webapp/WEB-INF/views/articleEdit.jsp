<%--
  Created by IntelliJ IDEA.
  User: arqelt
  Date: 19.05.2020
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <form:input path="title"/>
    <form:errors path="title"/>
    <form:input path="content"/>
    <form:errors path="content"/>
    <form:select itemValue="id" itemLabel="lastName" path="author" items="${authors}"/>
    <form:checkboxes itemValue="id" itemLabel="name" path="categories" items="${categories}"/>
    <form:errors path="categories"/>
    <input type="submit" name="Edit">
</form:form>
</body>
</html>
