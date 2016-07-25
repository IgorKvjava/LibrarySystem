<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="User" bundle="${lang}"/> <fmt:message key="Search" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <p>
    <form action="/librarianPages/mainLibrarianPage.jsp">
        <button type="submit"><fmt:message key="MainPage" bundle="${lang}"/></button>
    </form>
    </p>
    <table border="1">
        <tr>
            <th>
                <table border="1">
                    <caption><fmt:message key="User" bundle="${lang}"/></caption>
                    <tr>
                        <th><fmt:message key="FirstName" bundle="${lang}"/></th>
                        <th><fmt:message key="LastName" bundle="${lang}"/></th>
                        <th><fmt:message key="Abonnement" bundle="${lang}"/></th>
                    </tr>
                    <tr>
                        <td><input type="text" name="fist_name" value="${client.firstName}"/></td>
                        <td><input type="text" name="last_name" value="${client.lastName}"/></td>
                        <td><input type="text" name="abonnement" value="${client.abonnement}"/></td>
                    </tr>
                </table>
            </th>
            <th>
            <table border="1">
                <caption><fmt:message key="List" bundle="${lang}"/> <fmt:message key="Book" bundle="${lang}"/></caption>
                <tr>
                    <th><fmt:message key="Title" bundle="${lang}"/></th>
                    <th><fmt:message key="Author" bundle="${lang}"/></th>
                    <th><fmt:message key="Publisher" bundle="${lang}"/></th>
                    <th><fmt:message key="PublicationDate" bundle="${lang}"/></th>
                    <th><fmt:message key="NumberPages" bundle="${lang}"/></th>
                    <th><fmt:message key="Choice" bundle="${lang}"/></th>
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
            </th>
        <tr>
    </table>
</div>

</body>
</html>
