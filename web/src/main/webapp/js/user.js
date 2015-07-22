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

    var frm = $('#updateUserInfoForm');
    var id = $('#idInput').val();

    frm.submit(function (ev) {
        $.ajax({
            type: "PUT",
            url: "/web/users/" + id,
            data: frm.serialize(),
            success: function (data) {
                window.location = "http://localhost:8080/web/employees";
            }
        });
        ev.preventDefault();
    });
}

$(function () {

    $('.update').on('click', function () {
        var id = $('.update').data('id');
        var userName = $('.update').data('user-name');
        var password = $('.update').data('password');
        var employeeName = $('.update').data('employee-name');
        var employeeEmail = $('.update').data('employee-email');
        var employeePosition = $('.update').data('employee-position');
        var employeeGender = $('.update').data('employee-gender');
        var employeeId = $('.update').data('employee-id');

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







