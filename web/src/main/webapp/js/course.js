function deleteCourse(id) {

    $.ajax({
        url: '/web/courses/' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function () {
            window.location.reload();
        }
    })
}

function updateCourse(id) {
    var form = $('#updateCourseForm');
    form.submit(function (ev) {
        $.ajax({
            type: "PUT",
            url: "/web/courses/" + id,
            data: form.serialize(),
            success: function (data) {
                window.location = "http://localhost:8080/web/courses";
            }
        });
        ev.preventDefault();
    });
}

