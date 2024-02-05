<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
    <link href="CSS/buttons.css" rel="stylesheet" type="text/css"/>
    <title>ИСБД</title>
</head>
<body>
    <header>
        <a id="header-name">
            Morgue website
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
                Your data:
            </div>
            <div id="available-info-body">

            </div>
            <button id="available-info-change-button" class="button">Change</button>
        </div>
        <div id="sidebar">
            <div id="sidebar-header">
                Menu
            </div>


        </div>
    </div>
</body>
<script src="JS/jquery-3.7.1.min.js"></script>
<script src="JS/main.js"></script>
</html>