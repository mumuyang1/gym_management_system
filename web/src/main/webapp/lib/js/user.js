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

function updateUser(id) {

    var frm = $('#updateUserInfoForm');

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




