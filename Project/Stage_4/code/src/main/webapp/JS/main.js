import {fetch_personal_data, send_updated_data} from "./functions.js";

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
        let Enter;
        $('<input>').attr({
            type: 'text',
            id: 'input'+i,
            placeholder: (i === 1 ? 'Name' : i === 2 ? 'Second Name' : i === 3 ? 'Phone Number' : i === 4 ? 'Passport ID' : 'Address')
            }).appendTo('#available-info-body');
        $('<br>').appendTo('#available-info-body');
    }
    let obj = {"personId":5,
        "name":"Olivia",
        "secondName":"Davis",
        "phoneNumber":"777-888-9999",
        "passportId":"IJ7779999",
        "address":"567 Maple Dr",
        "toWhomId":5}
});

$('#available-info-save-button').on('click', function (){

});