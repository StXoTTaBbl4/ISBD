$('#login-button').on('click', function (){
    sendData()
});

function sendData(){
    let login = $('#login').val();
    let password = $('#password').val();
    let obj = {login, password}

    console.log(obj)
    $.ajax({
        url: 'auth-servlet',
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json",

        success(msg){
            if(msg !== 'not_found'){
                localStorage.setItem('logged', 't')
            }
            console.log(msg);
        },
        error(msg){
            console.log(msg)
        }
    });
}