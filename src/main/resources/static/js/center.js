


$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();	
		//countries/findById/?id=1	
		var href= $(this).attr('href');		
		$.get(href, function(center, status){
			var acDate = center.acquisitionDate.substr(0,10);
			$('#txtAcquisitionDateEdit').val(acDate);
			$('#txtDescriptionEdit').val(center.description);
			$('#ddlEmployeeEdit').val(center.employeeid);
			$('#txtFuelCapacityEdit').val(center.fuelCapacity);
			$('#txtIdEdit').val(center.id);
			$('#ddlLocationEdit').val(center.locationid);
			$('#txtNameEdit').val(center.name);
			$('#txtNetWeightEdit').val(center.netWeight);
			$('#txtPowerEdit').val(center.power);
			var regDate = center.registrationDate.substr(0,10);
			$('#txtRegistrationDateEdit').val(regDate);
			$('#txtRemarksEdit').val(center.remarks);
			$('#ddlCenterMakeEdit').val(center.centermakeid);		
			$('#ddlCenterModelEdit').val(center.centermodelid);			
			$('#txtCenterNumberEdit').val(center.centerNumber);			
			$('#ddlCenterStatusEdit').val(center.centerstatusid);			
			$('#ddlCenterTypeEdit').val(center.centertypeid);	
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerType, status){
			$('#idDetails').val(centerType.id);
			$('#descriptionDetails').val(centerType.description);
			$('#detailsDetails').val(centerType.details);
			$('#lastModifiedByDetails').val(centerType.lastModifiedBy);
			$('#lastModifiedDateDetails').val(centerType.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();		
	});	
	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #centerPhoto').attr('src', href);
		$('#photoModal').modal();		
	});		
});