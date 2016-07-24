<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="LOGIN" bundle="${lang}"/>Enter password</title>
</head>
<body>
<div class="block">
    <form action="${pageContext.request.contextPath}/command" method="post">
        <p>
            <label><fmt:message key="Your" bundle="${lang}"/> <fmt:message key="LOGIN" bundle="${lang}"/>: ${login}<br></label>
        </p>
        <label><fmt:message key="Your" bundle="${lang}"/> <fmt:message key="Password" bundle="${lang}"/>:<br></label>
        <input type="text" name="password" value="" size="15" maxlength="15"/>
        </p>
        <input type="hidden" name="login" value="${login}">
        <p>
            <input type="hidden" name="do" value="SingPass"/>
            <input type="submit" value="<fmt:message key="SignUp" bundle="${lang}"/>"/>
        </p>
    </form>
</div>
</body>
</html>
