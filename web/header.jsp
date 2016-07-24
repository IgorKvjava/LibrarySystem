<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale" value="${not empty locale ? locale : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${sessionScope.setLocale}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <title></title>
    <style type="text/css">
        body {
            text-align: center;
            vertical-align: middle;
        }

        .block {
            width: 20%;
            background: #fc0;
            padding: 5px;
            border: solid 1px black;
            text-align: center;
            vertical-align: middle;
            display: inline-block;
            align-items: center;
            margin: auto;
            /* */
        }
    </style>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/" method="post">
        <input type="hidden" name="language" value="ru_RU"/>
        <input type="hidden" name="do" value="changeLanguage"/>
        <input type="submit" value= <fmt:message key="RUS"/>>

        <form action="${pageContext.request.contextPath}/" method="post">
            <input type="hidden" name="language" value="en_US"/>
            <input type="hidden" name="do" value="changeLanguage"/>
            <input type="submit" value= <fmt:message key="ENG"/>>
        </form>
    </form>
</div>
</body>
</html>
