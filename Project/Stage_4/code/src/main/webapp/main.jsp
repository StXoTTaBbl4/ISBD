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
    <div id="wrapper">
        <div id="available-info">
            <div id="available-info-header">
                Доступные для вас записи:
            </div>
            <div id="available-info-body">
                <div class="available-info-personal">
                    <span>Имя:</span>
                    <span>Фамилия:</span>
                    <span>Паспорт:</span>
                </div>
            </div>
        </div>
        <div id="sidebar">123</div>
    </div>
<span id="search-button"></span>
<span id="account-button"></span>


</body>
<script src="JS/jquery-3.7.1.min.js"></script>
<script src="JS/main.js"></script>
</html>