$(document).ready(function (){
    //Потому что слава костылям, и потому что мне лень разбираться почему свойство hidden не работает
    //Скорее всего что-то в стилях, но meh
    $('#available-info-save-button').hide()
    console.log(localStorage.getItem("personID"));
    fetch_personal_data();
});

$('#sidebar-button-logout').on('click', function (){
    localStorage.removeItem("personID");
    window.location.replace("login.jsp");
});

$('#available-info-change-button').on('click', function () {
    $('#available-info-change-button').hide();
    $('#available-info-save-button').show();
    $('#available-info-body').html("")
    for (let i = 1; i <= 5; i++) {
        $('<input>').attr({
            type: 'text',
            id: 'input'+i,
            placeholder: (i === 1 ? 'Name' :
                i === 2 ? 'Second Name' :
                i === 3 ? 'Phone Number' :
                i === 4 ? 'Passport ID' : 'Address')
            }).appendTo('#available-info-body');
        $('<br>').appendTo('#available-info-body');
    }
});

$('#available-info-save-button').on('click', function (){
    let error = $('#available-info-error');
    error.html("");
    let data = []
    for (let i = 1; i < 6; i++){
        let buff = $('#input'+ i).val();
        if (buff !== ''){
            data[i-1] = buff;
        }else{
            error.html("<p style='color: #D74632'>All fields must be filled!</p>");
            return;
        }
    }

    let reg = /^[\d-]+$/;
    if (!reg.test(data[2]) || data[2].length !==12){
        error.html("<p style='color: #D74632'>Phone number must contain only numbers and '-'</p>");
        return;
    }
    reg = /^[A-Z]{2}\d{7}$/
    $('#available-info-change-button').show();
    $('#available-info-save-button').hide();
    //Даешь хардкод
    let obj = {"personId":localStorage.getItem("personID"),
        "name":data[0],
        "secondName":data[1],
        "phoneNumber":data[2],
        "passportId":data[3],
        "address":data[4]}
    send_updated_data(obj);
});

function insert_person_info(json){
    $('#available-info-body').html("<span>Name: " + json.name + "</span>" +
        "<br><span>Second name: "+ json.secondName + "</span>" +
        "<br><span>Phone number: " + json.phoneNumber+ "</span>" +
        "<br><span>Passport ID: " + json.passportId+ "</span>" +
        "<br><span>Address: " + json.address+ "</span>");
}

function fetch_personal_data() {
    $.ajax({
        url: 'bodies-info-servlet',
        type: "GET",
        headers: {
            'Accept': 'text/html',
        },
        data: "personID="+localStorage.getItem("personID"),
        dataType: "html",

        success(msg){
            let obj = JSON.parse(msg);
            localStorage.setItem("toWhomId", obj.toWhomId)
            console.log(msg);
            insert_person_info(obj);
        },
        error(msg){
            console.log(msg);
        }
    });
}

function send_updated_data(obj){
    $.ajax({
        url: 'bodies-info-servlet',
        type: "POST",
        headers: {
            'Accept': 'text/html',
        },
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json",
        success(msg){
        },
        error(msg){
        }
    });
}