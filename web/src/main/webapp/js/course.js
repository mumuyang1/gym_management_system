function deleteCourse(id) {

    $.ajax({
        url: '/web/courses/' + id,
        type: 'DELETE',
        dataType: 'text'
    }).done(function () {
        window.location.reload();
    });
}

function updateCourse() {

    var form = $('#updateCourseForm');
    var id = $("#idInput").val();

    form.submit(function (ev) {
        $.ajax({
            type: "PUT",
            url: "/web/courses/" + id,
            data: form.serialize()
        }).done(function () {

            window.location = "http://localhost:8080/web/courses";
        });
        ev.preventDefault();
    });
}

$(function () {

    $('.courseTable').on('click', function () {
        var id = $(this).data('course-id');
        var name = $(this).data('course-name');

        $('input[name=id]').val(id);
        $('input[name=name]').val(name);

        $('#updateCourseForm').show();
    });
});