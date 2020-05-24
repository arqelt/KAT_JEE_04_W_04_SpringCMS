<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arqelt
  Date: 22.05.2020
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
<form>
    <tbody>
    <tr>
        <td><a href="/article/add/">Add Article</a></td>
    </tr>
    </tbody>
    <tbody>
        <c:forEach items="${articles}" var="article">
        <tr>
            <td><c:out value="${article.title}"/></td>
            <td><c:out value="${article.content}"/></td>
            <td><c:out value="${article.created}"/></td>
            <td><c:out value="${article.updated}"/></td>
            <td><a href="/article/edit/${article.id}">Edit Article</a></td>
            <td><a href="/article/delete/${article.id}">Delete Article</a></td>
        </tr>
        </c:forEach>
    </tbody>
</form>
</body>
</html>
