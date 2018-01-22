<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/17/2018
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="a" uri="auth" %>

        <div class="col-sm-12 col-lg-12">
            <nav class="navbar navbar-default" style="margin-bottom: 0px" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/index.jsp">
                        <img src="/resources/images/scissor.png" width="30" height="30" alt="">
                    </a>
                </div>
                <div class="collapse navbar-collapse navbar-ex1-collapse" >
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/index.jsp"><fmt:message key="nav.home" bundle="${rb}"/> <span
                                    class="sr-only">(current)</span></a>
                        </li>
                        <li>
                            <a href="#"><fmt:message key="nav.masters" bundle="${rb}"/></a>
                        </li>
                        <a:if-user role="admin">
                            <li>
                                <a href="/jsp/admin/commentList.jsp">Comments list</a>
                            </li>
                        </a:if-user>
                        <li class="nav-item dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Choose language
                                <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/MainController?command=LOCALIZATION&language=English"
                                       onclick="history.back()">English</a>
                                </li>
                                <li><a href="/MainController?command=LOCALIZATION&language=Ukrainian">Ukrainian</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <a:if-user role="none">
                            <li>
                                <a href="/jsp/login.jsp">Sign in</a>
                            </li>
                            <li>
                                <a href="/jsp/registration.jsp">Sign up</a>
                            </li>
                        </a:if-user>
                        <a:if-user role="user">
                            <li>
                                <a href="/jsp/user/userPage.jsp">User page</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hello,
                                    <c:out value="${sessionScope.currentUser.firstName}"/>
                                    <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/jsp/user/userPage.jsp">User page</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/MainController?command=LOG_OUT">Log out</a></li>
                                </ul>
                            </li>
                        </a:if-user>
                        <a:if-user role="admin">
                            <li class="nav-item dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hello,
                                    <c:out value="${sessionScope.currentUser.firstName}"/>
                                    <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/jsp/admin/adminPage.jsp">Admin page</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/MainController?command=LOG_OUT">Log out</a></li>
                                </ul>
                            </li>
                        </a:if-user>
                        <a:if-user role="master">
                            <li class="nav-item dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hello,
                                    <c:out value="${sessionScope.currentUser.firstName}"/>
                                    <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/jsp/master/masterPage.jsp">Master page</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/MainController?command=LOG_OUT">Log out</a></li>
                                </ul>
                            </li>
                        </a:if-user>
                    </ul>
                </div>
            </nav>
        </div>


<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <ul class="navbar-nav mr-auto">
        <a class="navbar-brand" href="/index.jsp">
            <img src="/resources/images/scissor.png" width="30" height="30" alt="">
        </a>

        <li class="nav-item">
            <a class="nav-link" href="/index.jsp"><fmt:message key="nav.home" bundle="${rb}"/> <span
                    class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#"><fmt:message key="nav.masters" bundle="${rb}"/></a>
        </li>
        <a:if-user role="admin">
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/admin/commentList.jsp">Comments list</a>
            </li>
        </a:if-user>
        <li class="nav-item dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown</a>
            <ul class="dropdown-menu">
                <li><a href="/MainController?command=LOCALIZATION&language=English" onclick="history.back()">English</a>
                </li>
                <li><a href="/MainController?command=LOCALIZATION&language=Ukrainian">Ukrainian</a></li>
            </ul>
        </li>
        &lt;%&ndash;<c:if test="${sessionScope.currentUser.role }">
            <a class="nav-link" href="#">Role test</a>
        </c:if>&ndash;%&gt;

    </ul>
    <ul class="nav navbar-nav navbar-right">
        <a:if-user role="none">
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/login.jsp">Sign in</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/registration.jsp">Sign up</a>
            </li>
        </a:if-user>
        <a:if-user role="user">
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/user/userPage.jsp">User page</a>
            </li>
            <li class="nav-item ">
                <div class="btn-group">
                    <button class="btn dropdown-toggle btn-default" data-toggle="dropdown">Hello <c:out
                            value="${sessionScope.currentUser.firstName}"/></button>
                    <ul class="dropdown-menu">
                        <li><a href="/jsp/user/userPage.jsp">User page</a></li>
                        <li><a href="/MainController?command=LOG_OUT">Log out</a></li>
                        <li class="divider"></li>
                    </ul>
                </div>
            </li>
        </a:if-user>
        <a:if-user role="admin">
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/admin/adminPage.jsp">Admin page</a>
            </li>
        </a:if-user>
    </ul>

</nav>--%>
