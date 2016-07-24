<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<html>
<head>
    <title>Recording Board</title>
  <style type="text/css">
        .body {
            font: 14px 'Verdana';
            margin: 0;
            width: 90%;
            background: #ccc;
            padding: 50px 50px 50px 50px;
            border: solid 1px black;
            float: inherit;
        }
    </style>
</head>
<body>
<div class="body">
    <form action="checked" method="get">
        <table border="1">
            <caption>List books</caption>
            <tr>
                <th>Id book</th>
                <th>Status</th>
                <th>Date Issue</th>
                <th>Date Return</th>
                <th>Id user</th>
                <th>Id</th>
            </tr>
            <c:forEach items="${catalogueList}" var="catalogueListElem">
                <tr>
                    <td>${catalogueListElem.idBook}</td>
                    <th>${catalogueListElem.status}</th>
                    <th>${catalogueListElem.dateIssue}</th>
                    <th>${catalogueListElem.dateReturn}</th>
                    <th>${catalogueListElem.idUser}</th>
                    <th>${catalogueListElem.id}</th>

                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>