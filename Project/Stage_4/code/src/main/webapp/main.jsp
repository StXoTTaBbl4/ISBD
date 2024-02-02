<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ИСБД</title>
    <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <a id="header-name">
        Сайт морга
        </a>
        <br>
        <a id="header-time">
        <%SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        out.println(formatter.format(Calendar.getInstance().getTime()));
        %>
        </a>
    </header>
<span id="search-button"></span>
<span id="account-button"></span>


</body>
</html>