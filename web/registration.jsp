<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registration</title>
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
    <c:if test="${requestScope.incorrectLogin}">
        <c:out value="fill all filed"/>
    </c:if>
    <form action="login" method="post">
        <p>
            <label>Your login:<br></label>
            <input type="text" name="login" value="" size="15" maxlength="15"/>
        </p>

        <h1> ${login_used}
        </h1>

        <p>
            <input type="submit" name="do" value="SingIn"/>
        </p>
    </form>
</div>
</body>
</html>
