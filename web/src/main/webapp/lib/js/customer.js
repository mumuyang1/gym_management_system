function deleteCustomer(id){
    $.ajax({
        url: '/web/customers/' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function () {
            window.location.reload();
        }
    })
}