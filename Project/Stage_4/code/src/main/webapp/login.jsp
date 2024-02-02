<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ИСБД-Логин</title>
    <link href="CSS/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<form>
    <label for="login">Login</label>
    <input type="text" id="login" name="login" required>
    <label for="password">Password</label>
    <input type="password" id="password" name="password" required>
    <br>
    <button id="login-button" type="button">Enter</button>
</form>
<div id="error"></div>

</body>
<script src="JS/jquery-3.7.1.min.js"></script>
<script src="JS/login.js"></script>
</html>

