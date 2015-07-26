function deleteUser(id) {

    window.alert("删除后该用户不能再登录，但其基本信息不会删掉");

    $.ajax({
        url: '/web/users/' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function () {
            window.location.reload();
        }
    })
}

function updateUser() {

    var form = $('#updateUserInfoForm');
    var id = $('#idInput').val();

    form.submit(function (ev) {
        $.ajax({
            type: "PUT",
            url: "/web/users/" + id,
            data: form.serialize()

        }).done(function () {
            window.location = "http://localhost:8080/web/employees";
        });

        ev.preventDefault();
    });
}

$(function () {

    $('.update').on('click', function () {
        var id = $(this).data('id');
        var userName = $(this).data('user-name');
        var password = $(this).data('password');
        var employeeName = $(this).data('employee-name');
        var employeeEmail = $(this).data('employee-email');
        var employeePosition = $(this).data('employee-position');
        var employeeGender = $(this).data('employee-gender');
        var employeeId = $(this).data('employee-id');

        $('input[name=id]').val(id);
        $('input[name=userName]').val(userName);
        $('input[name=password]').val(password);
        $('input[name=name]').val(employeeName);
        $('input[name=email]').val(employeeEmail);
        $('input[name=position]').val(employeePosition);
        $('input[name=gender]').val(employeeGender);
        $('input[name=employeeId]').val(employeeId);

        $('#updateForm').show();
    });
});







