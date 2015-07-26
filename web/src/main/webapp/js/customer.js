function deleteCustomer(id) {
    $.ajax({
        url: '/web/customers/' + id,
        type: 'DELETE',
        dataType: 'text'
    }).done(function () {
        window.location.reload();
    })
}

function updateCustomer() {

    var form = $('#updateCustomerForm');
    var id = $('#idInput').val();

    form.submit(function (ev) {
        $.ajax({
            type: "PUT",
            url: "/web/customers/" + id,
            data: form.serialize()
        }).done(function() {
            window.location = "http://localhost:8080/web/customers";
        });
        ev.preventDefault();
    });
}

$(function () {

    $('.update').on('click', function () {
        var id = $(this).data('id');
        var name = $(this).data('name');
        var coachId = $(this).data('coach-id');

        $('input[name=customerId]').val(id);
        $('input[name=customerName]').val(name);
        $('input[name=coachId]').val(coachId);

        $('#updateCustomerForm').show();
        $('#updateText').show();
    });
});