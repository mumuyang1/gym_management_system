function deleteASchedule(id) {

    $.ajax({
        url: '/web/schedules/' + id,
        type: 'DELETE',
        dataType: 'text'
    }).done(function () {
        window.location.reload();
    });
}