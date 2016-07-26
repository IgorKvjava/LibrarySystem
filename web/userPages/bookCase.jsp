<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="ListBooks" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <form action="checked" method="get">
        <table border="1">
            <caption><fmt:message key="ListBooks" bundle="${lang}"/></caption>
            <tr>
                <th><fmt:message key="Title" bundle="${lang}"/></th>
                <th><fmt:message key="Author" bundle="${lang}"/></th>
                <th><fmt:message key="DateIssue" bundle="${lang}"/></th>
                <th><fmt:message key="DateReturn" bundle="${lang}"/></th>
                <th><fmt:message key="Status" bundle="${lang}"/></th>
                <th><fmt:message key="OrderStatus" bundle="${lang}"/></th>
            </tr>
            <c:forEach items="${booksList}" var="booksListElem">
                <tr>
                    <th>${booksListElem.title}</th>
                    <th>${booksListElem.author}</th>
                    <th>${booksListElem.dateIssue}</th>
                    <th>${booksListElem.dateReturn}</th>
                    <th><fmt:message key="${booksListElem.statuss}" bundle="${lang}"/></th>
                    <th><fmt:message key="${booksListElem.orderStatuss}" bundle="${lang}"/></th>
                </tr>
            </c:forEach>
        </table>
    </form>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <label><fmt:message key="Genres" bundle="${lang}"/></label>
        <input type="hidden" name="do" value="choiceGenres"/>
        <input type="submit" value="<fmt:message key="Choice" bundle="${lang}"/>"/>
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