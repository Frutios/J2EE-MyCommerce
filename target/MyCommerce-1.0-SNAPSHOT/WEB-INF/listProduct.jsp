<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 08/06/2021
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
    <table>
        <c:forEach items="${products}" var="p">
            <tr>
                <td style="border: 1px solid brown"><c:out value="${p.name}"/></td>
                <td style="border: 1px solid brown"><c:out value="${p.content}"/></td>
                <td style="border: 1px solid brown"><c:out value="${p.price}"/></td>
                <td style="border: 1px solid brown">
                    <a href="${pageContext.request.contextPath}/auth/removeProduct?id=${p.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
