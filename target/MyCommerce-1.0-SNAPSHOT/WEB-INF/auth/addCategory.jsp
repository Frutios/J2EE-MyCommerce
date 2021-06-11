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
    <title>Add Category</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<form action="${pageContext.request.contextPath}/auth/addCategory" method="post">

    <label for="categoryName">Category name : </label>
    <input type="text" name="categoryName" id="categoryName">

    <input type="submit" value="Add">
</form>

</body>
</html>
