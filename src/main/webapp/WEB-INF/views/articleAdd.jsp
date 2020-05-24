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
    <title>Add Article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    Title:
    <form:input path="title"/>
    <form:errors path="title"/>
    Content:
    <form:input path="content"/>
    <form:errors path="content"/>
    Author:
    <form:select itemValue="id" itemLabel="lastName" path="author" items="${authors}"/>
    Categories:
    <form:checkboxes itemValue="id" itemLabel="name" path="categories" items="${categories}"/>
    <form:errors path="categories"/>
    <input type="submit" name="Add"/>
</form:form>
</body>
</html>
