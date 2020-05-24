<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arqelt
  Date: 16.05.2020
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<table>
    <tbody>
    <c:forEach items="${categories}" var="category">
    <tr>
        <td><a href="<c:url value="article/byCategory/${category.id}"/>">
                <c:out value="${category.title}"/>
            </a>
        </td>

    </tr>
    </c:forEach>
    </tbody>
    <a href="category/all">Categories</a>
    <br>
    <a href="author/all">Authors</a>
    <br>
    <a href="article/all">Articles</a>
    <br>
</table>
</body>
</html>
