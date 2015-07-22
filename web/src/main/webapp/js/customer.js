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


function updateCustomer() {

    var form = $('#updateCustomerForm');
    var id = $('#idInput').val();

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

$(function () {

    $('.update').on('click', function () {
        var id = $('.update').data('id');
        var name = $('.update').data('name');

        $('input[name=customerId]').val(id);
        $('input[name=customerName]').val(name);

        $('#updateCustomerForm').show();
    });
});