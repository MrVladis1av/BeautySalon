<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
    <title>Title</title>
</head>
<body>
    <div class="container" style="border: 1px solid black">
        <div class="col-lg-8">
            <p>Hello User!</p>
            <p>Your first name: <c:out value="${sessionScope.currentUser.firstName}"/></p>
            <p>Your last name: <c:out value="${sessionScope.currentUser.lastName}"/></p>
            <p>Your Email: <c:out value="${sessionScope.currentUser.email}"/></p>
        </div>
    </div>
</body>
</html>
