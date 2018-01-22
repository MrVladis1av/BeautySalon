<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/18/2018
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>

<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"></c:import>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="col-lg-8"
         style="border: 1px solid #0deaff;background-color: #edf0f4;border-radius: 5px; margin: 10% auto;">
        <div class="row">
            <h3 style="margin:20px auto"><fmt:message key="login" bundle="${rb}"/></h3>
        </div>
        <hr style="border: 2px solid #eeeeee; margin: 10px"/>
        <div class="row">
            <div class="col-sm-12 col-lg-12" data-effect="slide-right">
                <form class="form-horizontal" action="/MainController" method="POST">
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp"
                                   placeholder="Email" name="e_mail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="inputPassword" placeholder="Password"
                                   name="password">
                        </div>
                    </div>
                    <c:if test="${requestScope.isError}">
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <p style="color: red">${requestScope.errorMessage}</p>
                            </div>
                        </div>
                    </c:if>
                    <div class="col-lg-offset-2 col-lg-10">
                        <label>
                            <a href="registration.jsp">Create account</a>
                        </label>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="hidden" name="command" value="AUTHORIZATION">
                            <button type="submit" class="btn btn-default">Sign in</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
