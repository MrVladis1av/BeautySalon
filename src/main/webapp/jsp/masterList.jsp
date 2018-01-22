<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/22/2018
  Time: 2:32 PM
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
    <c:forEach items="${requestScope.masters}" var="master">
        <div class="col-lg-6 col-sm-6 ">
            <div class="thumbnail">
                <img src="/resources/images/image-placeholder.png" alt="">
                <div class="caption">
                    <h3>Master info</h3>
                    <p>${master.firstName}</p>
                    <p>${master.lastName}</p>
                    <p>${master.level}</p>
                    <p style="height: 40px">${master.description}</p>
                    <p><a href="#" class="btn btn-primary">Action</a> <a href="#" class="btn btn-default">Action</a></p>
                </div>
            </div>
        </div>
    </c:forEach>
    <div class="container">
        <div class="row">
            <div class='col-sm-6'>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker1'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker1').datetimepicker();
                });
            </script>
        </div>
    </div>
</div>
</body>
</html>
