<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome ${firstName} ${lastName}</title>
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
    <p>
    <form action="<c:url value="/userPages/userEditDataPage.jsp"/>">
        <button type="submit">Edit data</button>
    </form>
    </p>

    <p>
        <form action="orders" method="get">
        <label>Book genres<br></label>
    <input type="submit" name="do" value="order"/>
    </form >

    </p>
    <form action="${pageContext.request.contextPath}/" method="get">
        <p>
            <input type="submit" name="do" value="exit"/>
        </p>
    </form>
</div>
</body>
</html>
