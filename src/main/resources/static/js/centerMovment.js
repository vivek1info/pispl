


$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();	
		//countries/findById/?id=1	
		var href= $(this).attr('href');		
		$.get(href, function(centerMovement, status){
			$('#idEdit').val(centerMovement.id);
			$('#ddlCenterEdit').val(centerMovement.vehicleid);
			$('#ddlLocation1Edit').val(centerMovement.locationid1);
			$('#ddlLocation2Edit').val(centerMovement.locationid2);
			
			var date1 = centerMovement.date1.substr(0,10);
			var date2 = centerMovement.date2.substr(0,10);
			$('#date1Edit').val(date1);
			$('#date2Edit').val(date2);
			$('#remarksEdit').val(centerMovement.remarks);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerMovement, status){
			$('#idDetails').val(centerMovement.id);
			$('#ddlCenterDetails').val(centerMovement.centerid);
			$('#ddlLocation1Details').val(centerMovement.locationid1);
			$('#ddlLocation2Details').val(centerMovement.locationid2);
			
			var date1 = centerMovement.date1.substr(0,10);
			var date2 = centerMovement.date2.substr(0,10);
			$('#date1Details').val(date1);
			$('#date2Details').val(date2);
			$('#remarksDetails').val(centerMovement.remarks);
		//	$('#lastModifiedByDetails').val(vehicleMovement.lastModifiedBy);
		//	$('#lastModifiedDateDetails').val(vehicleMovement.lastModifiedDate.substr(0,19).replace("T", " "));
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