<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/scripts.jsp"/>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="col-lg-8"
         style="border: 1px solid #0deaff;background-color: #edf0f4;border-radius: 5px; margin: 10% auto;">
        <div class="row">
            <h3 style="margin:20px auto"><fmt:message key="registration" bundle="${rb}"/></h3>
        </div>
        <hr style="border: 2px solid #eeeeee; margin: 10px"/>
        <div class="row">
            <div class="col-sm-12 col-lg-12" data-effect="slide-right">
                <form class="form-horizontal" action="/MainController" method="POST">
                    <div class="form-group">
                        <label for="firstName" class="col-lg-2 control-label">First name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="firstName" placeholder="First name"
                                   name="firstname" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-lg-2 control-label">Last name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="lastName" placeholder="Last name"
                                   name="lastname" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="chooseLevel" class="col-lg-2 control-label">Master level</label>
                        <div class="col-lg-6">
                            <select class="form-control" id="chooseLevel" name="level">
                                <option value="beginner">Beginner</option>
                                <option value="middle">Middle</option>
                                <option value="master">Master</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber" class="col-lg-2 control-label">Phone number</label>
                        <div class="col-lg-6">
                            <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="+38 (999) 999-99-99"
                                   required>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp"
                                   placeholder="Email" name="e_mail" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="inputPassword" placeholder="Password"
                                   name="password" required>
                        </div>
                    </div>
                    <c:if test="${requestScope.isError}">
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <p style="color: red">${requestScope.errorMessage}</p>
                            </div>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="hidden" name="command" value="CREATE_MASTER">
                            <button type="submit" class="btn btn-default">Create master</button>
                            <a href="/index.jsp" style="float: right">To home</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
