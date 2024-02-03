$('#login-button').on('click', function (){
    let login = $('#login').val();
    let password = $('#password').val();
    console.log("преошибка")
    if (login.length === 0 || password.length === 0){
        console.log("ошибка")
        $('#error').html("<p style='color: #D74632'>Enter login and password!</p>")
        return;
    }

    let obj = {login, password}

    console.log(obj)
    $.ajax({
        url: 'auth-servlet',
        type: "POST",
        headers: {
            'Accept': 'text/html',
        },
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json",

        success(msg){
            console.log("personID:" + msg)
            localStorage.setItem("personID", msg)
            window.location.replace("main.jsp")
        },
        error(msg){
            console.log(msg)
            $('#error').html("<p style='color: #D74632'>Login or password is incorrect!</p>")
        }
    });
});

