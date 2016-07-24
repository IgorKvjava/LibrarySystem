<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<html>
<head>
    <title>Main librarian page</title>
    <style type="text/css">
        .block {
            width: 90%;
            background: #ccc;
            padding: 50px 50px 50px 50px;
            border: solid 1px black;
            float: inherit;
        }
    </style>
</head>
<body>
<div class="block">
    <form action="list_clients" method="get">
        <p>
            <input type="submit" name="do" value="listClients"/>
        </p>
    </form>
    <form action="client_search" method="get">
        <p>
            <label>Enter client abonnement:<br></label>
            <input type="text" name="abonnement" value="" size="15" maxlength="15"/>
            <input type="submit" name="do" value="clientSearch"/>
        </p>
    </form>

    <form action="${pageContext.request.contextPath}/" method="get">
        <p>
            <input type="submit" name="do" value="exit"/>
        </p>
    </form>
    <label>Request Status -${requestStatus}<br></label>
</div>
</body>
</html>
