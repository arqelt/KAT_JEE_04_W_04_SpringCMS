<%--
  Created by IntelliJ IDEA.
  User: arqelt
  Date: 19.05.2020
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
    <form:form method="post" modelAttribute="category">
        Name:
        <form:input path="name"/>
        <form:errors path="name"/>
        Description:
        <form:input path="description" />
        <input type="submit" name="Edit">
    </form:form>
</body>
</html>
