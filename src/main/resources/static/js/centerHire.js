


$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();	
		//countries/findById/?id=1	
		var href= $(this).attr('href');		
		$.get(href, function(centerHire, status){
			$('#idEdit').val(centerHire.id);
			$('#ddlClientEdit').val(centerHire.clientid);			
			
			var dateIn = centerHire.dateIn.substr(0,10);
			var dateOut = centerHire.dateOut.substr(0,10);
			$('#dateInEdit').val(dateIn);
			$('#dateOutEdit').val(dateOut);
			
			$('#timeInEdit').val(centerHire.timeIn);
			$('#timeOutEdit').val(centerHire.timeOut);
			
			$('#ddlLocationEdit').val(centerHiree.locationid);
			$('#priceEdit').val(centerHire.price);
			$('#remarksEdit').val(centerHire.remarks);
			$('#ddlVehicleEdit').val(centerHire.vehicleid);			
		});					
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerHire, status){
			$('#idDetails').val(centerHire.id);
			$('#ddlClientDetails').val(centerHire.clientid);
			
			var dateIn = centerHire.dateIn.substr(0,10);
			var dateOut = centerHire.dateOut.substr(0,10);
			$('#dateInDetails').val(centerHire.dateIn);
			$('#dateOutDetails').val(centerHire.dateOut);
			$('#ddlLocationDetails').val(centerHire.locationid);
			$('#priceDetails').val(centerHire.price);
			$('#remarksDetails').val(centerHire.remarks);
			$('#ddlVehicleDetails').val(centerHire.vehicleid);
			$('#lastModifiedByDetails').val(centerHire.lastModifiedBy);
			$('#lastModifiedDateDetails').val(centerHire.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		});			
		$('#detailsModal').modal();		
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();		
	});	
	});