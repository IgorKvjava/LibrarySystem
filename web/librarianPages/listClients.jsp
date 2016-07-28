<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="List" bundle="${lang}"/> <fmt:message key="User" bundle="${lang}"/> </title>
</head>
<body>
<div class="block">
    <table border="1">
        <p>
        <form action="${pageContext.request.contextPath}/librarianPages/mainLibrarianPage.jsp">
            <button type="submit"><fmt:message key="MainPage" bundle="${lang}"/></button>
        </form>
        </p>
        <caption><fmt:message key="List" bundle="${lang}"/> <fmt:message key="User" bundle="${lang}"/></caption>
        <tr>
            <th><fmt:message key="ID" bundle="${lang}"/></th>
            <th><fmt:message key="FirstName" bundle="${lang}"/></th>
            <th><fmt:message key="LastName" bundle="${lang}"/></th>
            <th><fmt:message key="Abonnement" bundle="${lang}"/></th>
            <th><fmt:message key="ContactInformation" bundle="${lang}"/></th>
            <th><fmt:message key="LOGIN" bundle="${lang}"/></th>
            <th><fmt:message key="Password" bundle="${lang}"/></th>
            <th><fmt:message key="Status" bundle="${lang}"/></th>
        </tr>
        <c:forEach items="${usersList}" var="usersListElem">
            <tr>
                <td>${usersListElem.id}</td>
                <td><input type="text" name="fist_name" value="${usersListElem.firstName}" size="15"/>  </td>
                <td><input type="text" name="last_name" value="${usersListElem.lastName}" size="15"/> </td>
                <td><input type="text" name="abonnement" value="${usersListElem.abonnement}" size="15"/> </td>
                <td><input type="text" name="contact_information" value="${usersListElem.contactInformation}" size="15"/> </td>
                <td><input type="text" name="login" value="${usersListElem.login}" size="15"/> </td>
                <td><input type="text" name="password" value="${usersListElem.password}" size="15"/> </td>
                <td><input type="text" name="isLibrarian" value="${usersListElem.isLibrarian}" size="15"/> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
