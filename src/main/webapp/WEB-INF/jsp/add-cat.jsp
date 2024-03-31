<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a cat</title>
</head>
<body>
<a href="/">Головне меню</a>
<c:if test="${addCatSuccess}">
    <div>Successfully added Cat with name: ${savedCat.name}</div>
</c:if>

<c:url var="add_cat_url" value="/cats"/>
<form:form action="${add_cat_url}" method="post" modelAttribute="cat">
    <form:label path="name">Name: </form:label>
    <form:input type="text" path="name"/>

    <form:label path="behaviour">Behaviour: </form:label>
    <form:select type="text" path="behaviour">
        <form:option value="CALM">Calm</form:option>
        <form:option value="CRAZY">Creazy</form:option>
        <form:option value="NORMAL">Normal</form:option>
    </form:select>

    <input type="submit" value="submit"/>
</form:form>
</body>
</html>