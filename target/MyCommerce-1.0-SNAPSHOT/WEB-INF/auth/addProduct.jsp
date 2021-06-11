<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 09/06/2021
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<form action="${pageContext.request.contextPath}/auth/basicInsert" method="post">

    <label for="productCategory">Categories : </label>
    <select name="productCategory" id="productCategory">
        <option value="">--Please choose a category--</option>
        <c:forEach items="${categoryList}" var="cat">
            <option value="${cat.id}">${cat.name}</option>
        </c:forEach>
    </select>
    <label for="productName">Product name : </label>
    <input type="text" name="productName" id="productName">

    <label for="productContent">Product content : </label>
    <input type="text" name="productContent" id="productContent">

    <label for="productPrice">Product price : </label>
    <input type="number" step="0.1" min="0.0" name="productPrice" id="productPrice">

    <input type="submit" value="Add">
</form>
<span>${error}</span>

</body>
</html>
