function deleteCustomer(id) {
    $.ajax({
        url: '/web/customers/' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function () {
            window.location.reload();
        }
    })
}


function updateCustomer(id) {

    var form = $('#updateCustomerForm');
    form.submit(function (ev) {
        $.ajax({
            type: "PUT",
            url: "/web/customers/" + id,
            data: form.serialize(),
            success: function (data) {
                window.location = "http://localhost:8080/web/customers";
            }
        });
        ev.preventDefault();
    });
}
