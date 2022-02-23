


$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();	
		//countries/findById/?id=1	
		var href= $(this).attr('href');		
		$.get(href, function(invoice, status){
			$('#idEdit').val(invoice.id);
			$('#ddlClientEdit').val(invoice.clientid);			
			
			var invoiceDate = invoice.invoiceDate.substr(0,10);
			$('#invoiceDateEdit').val(invoiceDate);
			$('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
			$('#remarksEdit').val(invoice.remarks);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(invoice, status){
			$('#idDetails').val(invoice.id);
			$('#ddlClientDetails').val(invoice.clientid);			
			
			var invoiceDate = invoice.invoiceDate.substr(0,10);
			$('#invoiceDateDetails').val(invoiceDate);
			$('#ddlInvoiceStatusDetails').val(invoice.invoicestatusid);
			$('#remarksDetails').val(invoice.remarks);
			$('#lastModifiedByDetails').val(invoice.lastModifiedBy);
			$('#lastModifiedDateDetails').val(invoice.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();		
	});	
});