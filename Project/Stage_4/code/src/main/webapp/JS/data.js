let header = $('#available-info-header');
let change_button = $('#available-info-change-button');

$('#sidebar-button-main').on('click', function () {
    //Лень богу лени, костыли трону из костылей, !
    location.reload();
});

$('#sidebar-button-info').on('click', function () {
    change_button.hide();
    header.text("Relative's body data:");
    request_rel_body_info();
});

$('#sidebar-button-address').on('click', function () {
    change_button.hide();
    header.text("Addresses data:");
    request_facilities_info();
});

$('#sidebar-button-workers').on('click', function () {
    change_button.hide();
    header.text("Workers data:");
    request_workers_info();
});

// $('#sidebar-button-case').on('click', function () {
//     change_button.hide();
//     header.text("Case info:");
//     $('#available-info-body').html(
//         "<input id='personID' placeholder='personId'/><br>"
//         + "<input id='bodyID' placeholder='bodyId'/><br>"
//         + "<button id='sidebar-button-case-request' class='button'>Request</button>");
// })

$('#sidebar-button-receive').on('click', function () {
    change_button.hide();
    header.text("Body receiving details:");
    request_body_receiving_data();
})

$('#send_receiving_info').on('click', function (){
    //я уже говорил что люблю хардкодить?
    let fields = {
        facility_address: $('#facility_address').val(),
        receiving_date: $('#receiving_date').val(),
        receiver_name: $('#receiver_name').val(),
        receiver_second_name: $('#receiver_second_name').val(),
        receiver_ID: $('#receiver_IDs').val(),
        receiver_phone_number: $('#receiver_phone_number').val(),
        body_treatment_type: $('#body_treatment_type').val(),
        graveyard_order_ID: $('#graveyard_order_ID').val()
    };

})

function request_rel_body_info(){
    $.ajax({
        url: 'rel-info-servlet',
        type: "GET",
        headers: {
            'Accept': 'text/html',
        },
        data: "bodyID="+localStorage.getItem("toWhomId"),
        dataType: "html",

        success(msg){
            console.log(msg)
            insert("available-info-body",JSON.parse(msg))
        },
        error(msg){
            console.log(msg);
        }
    });
}

function request_facilities_info(){
    $.ajax({
        url: 'facilities-servlet',
        type: "GET",
        headers: {
            'Accept': 'text/html',
        },
        dataType: "html",

        success(msg){
            console.log(msg)
            insert("available-info-body",JSON.parse(msg))
        },
        error(msg){
            console.log(msg);
        }
    });
}

function request_workers_info() {
    $.ajax({
        url: 'workers-servlet',
        type: "GET",
        headers: {
            'Accept': 'text/json',
        },
        dataType: "html",

        success(msg){
            console.log(msg)
            insert("available-info-body",JSON.parse(msg))
        },
        error(msg){
            console.log(msg);
        }
    });
}

function request_body_receiving_data(){
    $.ajax({
        url: 'body-receiving-servlet',
        type: "GET",
        headers: {
            'Accept': 'text/json',
        },
        data: "personID="+localStorage.getItem("personID"),
        dataType: "text",

        success(msg){
            console.log(msg)
            insert("available-info-body",JSON.parse(msg))
        },
        error(msg){
            console.log(msg);
            generate_form();

        }
    });

}

function send_body_receiving_data(obj){
    $.ajax({
        url: 'body-receiving-servlet',
        type: "POST",
        headers: {
            'Accept': 'text/html',
        },
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json",
        success(msg){
            console.log(msg)
        },
        error(msg){
            console.log(msg)
        }
    });
}

function generate_form(){
    let available_info_body = $('#available-info-body');
    available_info_body.html("Please fill the data:<br>");
    const fields = [
        'facility_address',
        'receiving_date',
        'receiver_name',
        'receiver_second_name',
        'receiver_ID',
        'receiver_phone_number',
        'body_treatment_type',
        'graveyard_order_ID'
    ];

    // Create input fields for each field
    fields.forEach(field => {
        $('<input>').attr({
            type: 'text',
            id: field,
            name: field,
            placeholder: field.split('_').join(' ') // Replace underscore with space for placeholder
        }).appendTo('#available-info-body');
        available_info_body.append('<br>'); // Line break after each input field
    });

    available_info_body.append($('<button>').attr({
        type: 'button',
        id: 'send_receiving_info',
        class: 'button'
    }).text('Send'));
}

function insert(parentElement, jsonObject){
    $('#'+parentElement).html("");
    for (let i = 1; i <= 5; i++) {
    }
    for (const Key in jsonObject) {
        $('<span>').attr({
            id: Key,
        }).html(Key +": " + jsonObject[Key]).appendTo('#'+parentElement);
        $('<br>').appendTo('#'+parentElement);
    }
}