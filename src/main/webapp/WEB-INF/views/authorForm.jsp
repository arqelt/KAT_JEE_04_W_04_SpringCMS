<%--
  Created by IntelliJ IDEA.
  User: arqelt
  Date: 20.05.2020
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<form>
    <tbody>
    <tr>
        <td><a href="/author/add">Add Author</a></td>
    </tr>
    </tbody>
    <tbody>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td><c:out value="${author.firstName}"/></td>
            <td><c:out value="${author.lastName}"/></td>
            <td><a href="/author/edit/${author.id}"/>Edit Author</td>
            <td><a href="/author/delete/${author.id}"/>Delete Author</td>
        </tr>
    </c:forEach>
    </tbody>
</form>

</body>
</html>
