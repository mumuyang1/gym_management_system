function deleteASchedule(id){
    $.ajax({
        url: '/web/schedules/' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function () {
            window.location.reload();
        }
    })
}