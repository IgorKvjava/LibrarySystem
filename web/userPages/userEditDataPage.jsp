<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <form action="edit" method="get">
        <table border="1">
            <caption>Personal data</caption>
            <tr>
                <th>id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Abonnement</th>
                <th>Contact Information</th>
                <th>Login</th>
                <th>Password</th>
            </tr>
            <tr>
                <td>${id}
                </td>
                <td><input type="text" name="first_name" value="${firstName}"/>
                </td>
                <td><input type="text" name="last_name" value="${lastName}"/>
                </td>
                <td>${abonnement}
                </td>
                <td><input type="text" name="contact_information" value="${contactInformation}"/>
                </td>
                <td>${login}
                </td>
                <td><input type="text" name="password" value="${password}" size="5" maxlength="15"/>
                </td>
            </tr>
        </table>
        <p>
            <input type="submit" name="do" value="edit"/>
        </p>
    </form>
    <form action="${pageContext.request.contextPath}/" method="get">
        <p>
            <input type="submit" name="do" value="exit"/>
        </p>
    </form>
</div>
</body>
</html>
