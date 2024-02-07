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

$('#sidebar-button-case').on('click', function () {
    change_button.hide();
    header.text("Case info:");

})

$('#sidebar-button-receive').on('click', function () {
    change_button.hide();
    header.text("Body receiving details:");

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

//TODO add button case info, for additional_info and case_info data