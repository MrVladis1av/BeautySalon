<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 6:42 PM
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
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-sm-4 ">
            <a href="#" class="thumbnail">
                <img src="../resources/images/image-placeholder.png" alt="">
            </a>
        </div>
        <div class=" col-lg-4">
            <p>Your first name: <c:out value="${sessionScope.currentUser.firstName}"/></p>
            <p>Your last name: <c:out value="${sessionScope.currentUser.lastName}"/></p>
            <p>Your level: <c:out value="${sessionScope.currentUser.level}"/></p>
            <p>Your phone number: <c:out value="${sessionScope.currentUser.phoneNumber}"/></p>
            <p>Your e-mail: <c:out value="${sessionScope.currentUser.email}"/></p>
            <p>Your description </br><c:out value="${sessionScope.currentUser.description}"/></p>
        </div>

        <div class="row">
            <div class='col-sm-6'>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker2'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker2').datetimepicker({
                        locale: 'ru'
                    });
                });
            </script>
        </div>


    </div>
</div>

</body>
</html>
