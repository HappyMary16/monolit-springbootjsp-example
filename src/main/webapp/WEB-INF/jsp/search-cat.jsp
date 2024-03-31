<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search for cat</title>
</head>
<body>
<a href="/">Головне меню</a>
<c:if test="${catFound}">
    <div>Кота знайдено:</div>
    <div>Імʼя: ${foundCat.name}</div>
    <div>Поведінка: ${foundCat.behaviour}</div>
</c:if>

<c:url var="search_cat_url" value="/cats/search"/>
<form:form action="${search_cat_url}" method="get" modelAttribute="cat">
    <form:label path="name">Name: </form:label>
    <form:input type="text" path="name"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>