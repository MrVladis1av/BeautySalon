<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/9/2018
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="resources/components/i18n.jsp" %>
<%@ taglib prefix="a" uri="auth" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"></c:import>
    <c:import url="resources/components/navigation.jsp"></c:import>
    <title>Title</title>
    <style>
        body,
        html {
            height: 100%;
            overflow-x: hidden
        }

        footer {
            border-top: 1px solid #ddd;
            padding: 30px;
            margin-top: 50px;
            flex: 0 0 auto;
        }

        .row > [class*=col-] {
            margin-bottom: 40px
        }

        .navbar-container {
            position: relative;
            min-height: 100px
        }

        .navbar.navbar-fixed-bottom,
        .navbar.navbar-fixed-top {
            position: absolute;
            top: 50px;
            z-index: 0
        }

        .navbar.navbar-fixed-bottom .container,
        .navbar.navbar-fixed-top .container {
            max-width: 90%
        }

        .form-inline input[type=password],
        .form-inline input[type=text],
        .form-inline select {
            width: 180px
        }
    </style>
</head>
<body>
<div class="container" style="height: 100%; margin-top: 100px;">
    <a href="jsp/test.jsp">Test page</a>
    <form cass="form-horizontal" action="../MainController" method="GET">
        <button type="submit" class="btn btn-primary" name="command" value="MASTER_LIST">
            MasterList
        </button>
    </form>
    <p class="h3">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
</div>
<footer class="text-center">
    <div class="credits">
        ©2018 Vlad Stetsenko
    </div>
</footer>
</body>
</html>
