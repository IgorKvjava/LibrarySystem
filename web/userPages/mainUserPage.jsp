<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="Welcome" bundle="${lang}"/>: ${firstName} ${lastName}</title>
</head>
<body>
<div class="block">
    <fmt:message key="Welcome" bundle="${lang}"/>: ${firstName} ${lastName}<br>
    <p>
    <form action="<c:url value="/userPages/userEditDataPage.jsp"/>">
        <input type="hidden" name="do" value="profile"/>
        <input type="submit" value="<fmt:message key="PersonalProfile" bundle="${lang}"/>"/>
    </form>
    </p>
    <p>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <label><fmt:message key="Genres" bundle="${lang}"/></label>
        <input type="hidden" name="do" value="choiceGenres"/>
        <input type="submit" value="<fmt:message key="Choice" bundle="${lang}"/>"/>
    </form>

    </p>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <input type="hidden" name="do" value="exit"/>
            <input type="submit" value="<fmt:message key="Exit" bundle="${lang}"/>"/>
        </p>
    </form>
</div>
</body>
</html>
