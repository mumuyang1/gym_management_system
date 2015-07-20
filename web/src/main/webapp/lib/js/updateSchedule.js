$(document).ready(function() {

    var frm = $('#updateScheduleInfoForm');
    var id = $('#idInput').val();
    frm.submit(function (ev) {
        $.ajax({
            type: "PUT",
            url: "/web/courses/" + id,
            data: frm.serialize(),
            success: function (data) {
                if(data === "timeNotAvailable"){
                    window.alert("时间冲突，请重新选时间");
                }
                window.location = "http://localhost:8080/web/courses/";
            }
        });
        ev.preventDefault();
    });
});