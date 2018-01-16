<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/9/2018
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<sql:query var="rs" dataSource="jdbc/beauty_saloon">
    select iduser,first_name, password from user
</sql:query>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="row" items="${rs.rows}">
    Id ${row.iduser} First name ${row.first_name}  Pass ${row.password}<br/>
</c:forEach>
</body>
</html>
