function insert_person_info(json){
    let obj = JSON.parse(json);
    $('#available-info-body').html("<div class=\"available-info-personal\"><span>Name: " + obj.name + "</span>" +
        "<br><span>Second name: "+ obj.secondName + "</span>" +
        "<br><span>Phone number: " + obj.phoneNumber+ "</span>" +
        "<br><span>Passport ID: " + obj.passportId+ "</span>" +
        "<br><span>Address: " + obj.address+ "</span></div>");
}

export function fetch_personal_data() {
    $.ajax({
        url: 'bodies-info-servlet',
        type: "GET",
        headers: {
            'Accept': 'text/html',
        },
        data: "personID="+localStorage.getItem("personID"),
        dataType: "html",

        success(msg){
            console.log(msg);
            insert_person_info(msg);
        },
        error(msg){
            console.log(msg);
        }
    });
}

export function send_updated_data() {
}