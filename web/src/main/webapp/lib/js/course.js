function deleteASchedule(id){
    $.ajax({
        url: '/web/courses/' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function () {
            window.location.reload();
        }
    })
}