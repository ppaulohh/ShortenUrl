$(document).ready(function (){
    $("button").click(function (){
        $.ajax({
            type: "POST",
            url: 'http://localhost:8080/shrink',
            data: JSON.stringify({"fullUrl": $("#urlinput").val()}),
            contentType: "application/json; charset=utf-8",
            success: function (data){
                $("#shorturltext").val(data.shortenedUrl);
            }
        });
    });
});