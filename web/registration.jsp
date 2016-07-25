<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="Registration" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <c:if test="${requestScope.incorrectLogin}">
        <c:out value="fill all filed"/>
    </c:if>
    <form action="${pageContext.request.contextPath}/command" method="post">
        <p>
            <label><fmt:message key="Your" bundle="${lang}"/> <fmt:message key="LOGIN" bundle="${lang}"/>:<br></label>
            <input type="text" name="login" value="" size="15" maxlength="15"/>
        </p>
        <h1> ${login_used}</h1>
        <p>
            <input type="hidden" name="do" value="SingIn"/>
            <input type="submit" name="do" value="<fmt:message key="SignUp" bundle="${lang}"/>"/>
        </p>
    </form>
</div>
</body>
</html>
