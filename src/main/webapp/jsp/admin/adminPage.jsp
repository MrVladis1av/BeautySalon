<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <title>Title</title>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
</head>
<body>
<div class="container" style="border: 1px solid black">
    <div class="col-lg-8">
        <p class="h3">Hello, <c:out value="${sessionScope.currentUser.firstName}"/>
            <c:out value="${sessionScope.currentUser.lastName}"/></p>
        <p class="h3">Email: <c:out value="${sessionScope.currentUser.email}"/></p>
        <p class="h3">Your role: <c:out value="${sessionScope.currentUser.role}"/></p>
    </div>
    <div class="col-lg-8">
        <a class="h3" href="/jsp/admin/masterCreation.jsp">Create master</a>
    </div>
</div>
</body>
</html>
