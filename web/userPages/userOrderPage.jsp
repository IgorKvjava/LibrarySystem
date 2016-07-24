<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<html>
<head>
    <title>Order page</title>
    <style type="text/css">
        .body {
            font: 14px 'Verdana';
            margin: 0;
            width: 90%;
            background: #ccc;
            padding: 50px 50px 50px 50px;
            border: solid 1px black;
            float: inherit;
        }
    </style>
</head>
<body>
<div class="body">
    Genres <br>
    <form action="genres" method="post">
        <p><select name="idGenre">
            <c:forEach items="${genresList}" var="genresListElem">
                <option  value="${genresListElem.id}"> ${genresListElem.genre}</option>
            </c:forEach>
        </select></p>
        <p><input type="submit" name="do" value="orderGenre"></p>
    </form>
</div>
</body>
</html>
