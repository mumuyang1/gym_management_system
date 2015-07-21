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




