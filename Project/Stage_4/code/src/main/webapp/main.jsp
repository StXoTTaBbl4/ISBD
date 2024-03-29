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
            <div id="available-info-body"></div>
            <button id="available-info-change-button" class="button">Change</button>
            <button id="available-info-save-button" class="button">Save</button>
            <div id="available-info-error"></div>
        </div>
        <div id="sidebar">
            <div id="sidebar-header">
                Menu
            </div>
            <div id="sidebar-buttons">
                <button id="sidebar-button-main" class="button sidebar-button">Main</button><br>
                <button id="sidebar-button-info" class="button sidebar-button">Info</button><br>
                <button id="sidebar-button-address" class="button sidebar-button">Addresses</button><br>
                <button id="sidebar-button-workers" class="button sidebar-button">Workers</button>
                <button id="sidebar-button-case" class="button sidebar-button">Case Info</button><br>
                <button id="sidebar-button-receive" class="button sidebar-button">Receive</button>
                <button id="sidebar-button-logout" class="button sidebar-button">Logout</button>
            </div>
        </div>
    </div>
</body>
<script src="JS/jquery-3.7.1.min.js"></script>
<script src="JS/main.js"></script>
<script src="JS/data.js"></script>
</html>