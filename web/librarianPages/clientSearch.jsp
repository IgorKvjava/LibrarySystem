<%@include file="/header.jsp" %>
<html>
<head>
    <title><fmt:message key="User" bundle="${lang}"/> <fmt:message key="Search" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <P>
    <form action="/librarianPages/mainLibrarianPage.jsp">
        <button type="submit"><fmt:message key="MainPage" bundle="${lang}"/></button>
    </form>
    </P>
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


</div>

</body>
</html>
