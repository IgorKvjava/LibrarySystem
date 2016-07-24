<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="LOGIN"/> </title>

</head>
<body>
<div class="block"  >
    <h2>Logon</h2>
    <form action="logon" method="post">
        <p>
            <label>Your login:<br></label>
            <input type="text" name="login" value="" size="15" maxlength="15"/>
        </p>
        <p>
            <label>Your password:<br></label>
            <input type="password" name="password" value="" size="15" maxlength="15"/>
        </p>
        <p>
            <input type="hidden" name="do" value="login"/>
            <input type="submit"  value="Login"/>
        </p>
    </form>
    <form action="/registration.jsp">
        <button type="submit" >Sign up</button>
    </form>
</div>
</body>
</html>
