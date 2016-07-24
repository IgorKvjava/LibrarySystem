<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <style type="text/css">
        body {
            text-align: center;
            vertical-align: middle;
        }

        .blockIndex {
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
<div>
    <fmt:setLocale value="${locale}"/>
    <fmt:setBundle basename="ua.kvelinskiy.Translated" var="lang"/>
    <table>
        <th>
            <form action="${pageContext.request.contextPath}/command" method="post">
                <input type="hidden" name="language" value="ru"/>
                <input type="hidden" name="do" value="changeLanguage"/>
                <input type="submit" value="<fmt:message key="RUS" bundle="${lang}"/>"/>
            </form>
        </th>
        <th>
            <form action="${pageContext.request.contextPath}/command" method="post">
                <input type="hidden" name="language" value="en"/>
                <input type="hidden" name="do" value="changeLanguage"/>
                <input type="submit" value="<fmt:message key="ENG" bundle="${lang}"/>"/>
            </form>
        </th>
    </table>

</div>
</body>
</html>
