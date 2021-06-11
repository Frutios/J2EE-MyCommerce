<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 08/06/2021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show product by Id</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
        <p>${product.name}</p>
        <p>${product.content}</p>
        <p>${product.price}</p>
</body>
</html>
