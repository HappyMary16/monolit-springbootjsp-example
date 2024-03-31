<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>View cats</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<a href="/">Головне меню</a>
<table>
    <thead>
    <tr>
        <th>Імʼя</th>
        <th>Поведінка</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cats}" var="cat">
        <tr>
            <td>${cat.name}</td>
            <td>${cat.behaviour}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>