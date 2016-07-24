<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Search</title>
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
    <P>
    <form action="/librarianPages/mainLibrarianPage.jsp">
        <button type="submit">Main page</button>
    </form>
    </P>
    <table border="1">
        <caption>Client</caption>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Abonnement</th>
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
