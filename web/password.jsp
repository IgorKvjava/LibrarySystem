<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter password</title>
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
    <form action="login" method="post">
        <p>
            <label>Your login -${login}<br></label>
        </p>
        <label>Your password:<br></label>
        <input type="text" name="password" value="" size="15" maxlength="15"/>
        </p>
        <input type="hidden" name="login" value="${login}">

        <p>
            <input type="submit" name="do" value="SingPass"/>
        </p>
    </form>
</div>
</body>
</html>
