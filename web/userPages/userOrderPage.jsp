<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="Genres" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <fmt:message key="Genres" bundle="${lang}"/><br>
    <form action="${pageContext.request.contextPath}/command" method="post">
        <p>
            <select name="idGenre">
            <c:forEach items="${genresList}" var="genresListElem">
                <option  value="${genresListElem.id}"> <fmt:message key="${genresListElem.genre}" bundle="${lang}"/> </option>
            </c:forEach>
        </select>
        </p>
        <p>
            <input type="hidden" name="do" value="choiceGenre"/>
            <input type="submit" value="<fmt:message key="Choice" bundle="${lang}"/>">
        </p>
    </form>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <input type="hidden" name="do" value="mainUserPage"/>
            <input type="submit" value="<fmt:message key="MainPage" bundle="${lang}"/>"/>
        </p>
    </form>
</div>
</body>
</html>
