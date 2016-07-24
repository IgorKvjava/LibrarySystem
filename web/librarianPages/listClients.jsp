<%@include file="/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<html>
<head>
    <title>List Clients</title>
    <style type="text/css">
        .block {
            width: 90%;
            background: #ccc;
            padding: 50px 50px 50px 50px;
            border: solid 1px black;
            float: inherit;
        }
    </style>
</head>
<body>
<div class="block">
    <table border="1">
        <P>
        <form action="${pageContext.request.contextPath}/librarianPages/mainLibrarianPage.jsp">
            <button type="submit" >Main page</button>
        </form>
        </P>        <caption>Personal table</caption>
        <tr>
            <th>id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Abonnement</th>
            <th>Contact Information</th>
            <th>Login</th>
            <th>Password</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${usersList}" var="usersListElem">
            <tr>
                <td>${usersListElem.id}</td>
                <td><input type="text" name="fist_name" value="${usersListElem.firstName}"/></td>
                <td><input type="text" name="last_name" value="${usersListElem.lastName}"/></td>
                <td><input type="text" name="abonnement" value="${usersListElem.abonnement}"/></td>
                <td><input type="text" name="contact_information" value="${usersListElem.contactInformation}"/></td>
                <td><input type="text" name="login" value="${usersListElem.login}"/></td>
                <td><input type="text" name="password" value="${usersListElem.password}"/></td>
                <td><input type="text" name="isLibrarian" value="${usersListElem.isLibrarian}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
