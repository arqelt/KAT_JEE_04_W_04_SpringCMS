<%--
  Created by IntelliJ IDEA.
  User: arqelt
  Date: 19.05.2020
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
    <form>
        <tbody>
        <a href="/category/add">Add Category</a>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td><c:out value="${category.name}" /></td>
                <td><c:out value="${category.description}" /></td>
                <td><a href="/category/edit/${category.id}"/>Edit</td>
                <td><a href="/category/delete/${category.id}"/>Delete</td>
            </tr>
        </c:forEach>
        </tbody>
    </form>
</body>
</html>
