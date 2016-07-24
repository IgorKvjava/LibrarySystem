<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="MakeOrder" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <form action="${pageContext.request.contextPath}/command" method="get">
        <table border="1">
            <caption>List books</caption>
            <tr>
                <th><fmt:message key="Title" bundle="${lang}"/></th>
                <th><fmt:message key="Author" bundle="${lang}"/></th>
                <th><fmt:message key="Publisher" bundle="${lang}"/></th>
                <th><fmt:message key="PublicationDate" bundle="${lang}"/></th>
                <th><fmt:message key="NumberPages" bundle="${lang}"/></th>
                <th><fmt:message key="Choice" bundle="${lang}"/>S</th>
            </tr>
            <c:forEach items="${booksList}" var="booksListElem">
                <tr>
                    <td>${booksListElem.title}</td>
                    <td>${booksListElem.author}</td>
                    <td>${booksListElem.publisher}</td>
                    <td>${booksListElem.publicationDate}</td>
                    <td>${booksListElem.numberPages}</td>
                    <td>
                        <p>
                            <input type="checkbox" name="bookId" value="${booksListElem.id}"/> ${booksListElem.status}
                        </p>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p><fmt:message key="MakeOrder" bundle="${lang}"/>:</p>
        <p>
            <input type="hidden" name="do" value="CheckedBooks"/>
            <input type="submit"  value="<fmt:message key="Choice" bundle="${lang}"/>"/>
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
