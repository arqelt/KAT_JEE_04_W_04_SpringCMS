<%--
  Created by IntelliJ IDEA.
  User: arqelt
  Date: 23.05.2020
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Drafts</title>
</head>
<body>
<form>
    <tbody>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td><c:out value="${article.title}"/></td>
            <td><c:out value="${article.content}"/></td>
            <td><c:out value="${article.created}"/></td>
            <td><c:out value="${article.updated}"/></td>
            <td><a href="/draft/edit/${article.id}">Edit Draft</a></td>
            <td><a href="/draft/delete/${article.id}"></a>Delete Draft</td>
        </tr>
    </c:forEach>
    </tbody>
</form>
</body>
</html>
