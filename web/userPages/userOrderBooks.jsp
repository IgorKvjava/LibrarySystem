<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<html>
<head>
    <title>Order Books</title>
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
    <form action="checked" method="get">
        <table border="1">
            <caption>List books</caption>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Publication date</th>
                <th>Number pages</th>
                <th>Selecting-in</th>
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
        <p>Make order from selected book:</p>
        <p>
            <input type="hidden" name="do" value="CheckedBooks"/>
            <input type="submit"  value="CheckedBooks"/>
        </p>
    </form>
</div>
</body>
</html>
