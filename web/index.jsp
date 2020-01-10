<%--
  Created by IntelliJ IDEA.
  User: adammendak
  Date: 05/01/2020
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<% Object result = request.getAttribute("result"); %>
    <div class="container">
        <p align="center">
            <b>Producent wiadomości dla tematu JNDI Name - jms/ATJTopic</b>
        </p>
        <form method="GET" action="produce">
            <div class="form-group">
                <label for="messageValue">Teskst wiadomości:</label>
                <input type="text" class="form-control" id="messageValue" name="value" required>
            </div>
            <button type="submit" class="btn btn-primary">Ślij!</button>
        </form>
    </div>
    <table class="table">
        <tr>
            <td>
                <p align="center">
                    <b><%= Objects.isNull(result) ? "" : String.valueOf(result) %></b>
                </p>
            </td>
        </tr>
    </table>
</body>
</html>
