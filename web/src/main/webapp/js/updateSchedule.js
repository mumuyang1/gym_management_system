$(document).ready(function () {

    var form = $('#updateScheduleInfoForm');
    var id = $('#idInput').val();

    form.submit(function (ev) {
        $.ajax({
            type: "PUT",
            url: "/web/schedules/" + id,
            data: form.serialize()

        }).done(function (data) {
            if (data === "timeNotAvailable") {
                window.alert("时间冲突，请重新选时间");
            }
            window.location = "../";
        });
        ev.preventDefault();
    });

});