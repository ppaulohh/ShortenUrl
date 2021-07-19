$(document).ready(function (){
    $("button").click(function (){
        $.ajax({
            type: "POST",
            url: 'http://localhost:8080/shrink',
            data: $("#urlinput").val(),
            contentType: "application/json; charset=utf-8",
            success: function (data){ $("#shorturltext").val(data); }
        });
    });
    setTimeout(function() {
        $.ajax({
            type: "GET",
            url : 'http://localhost:8080/show',
            contentType: "application/json; charset=utf-8",
    }, 1000);


    })
});


