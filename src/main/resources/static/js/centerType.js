$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerType, status){
			$('#idEdit').val(centerType.id);
			$('#descriptionEdit').val(centerType.description);
			$('#detailsEdit').val(centerType.details);
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
			$('#cityDetails').val(centerType.city);
			$('#addressDetails').val(centerType.address);
			$('#ddlStateDetails').val(centerType.stateid);
			$('#ddlCountryDetails').val(centerType.countryid);
			$('#lastModifiedByDetails').val(centerType.lastModifiedBy);
			$('#lastModifiedDateDetails').val(centerType.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});