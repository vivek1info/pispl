$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerMake, status){
			$('#idEdit').val(centerMake.id);
			$('#descriptionEdit').val(centerMake.description);
			$('#detailsEdit').val(centerMake.details);
		});					
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerMake, status){
			$('#idDetails').val(centerMake.id);
			$('#descriptionDetails').val(centerMake.description);
			$('#detailsDetails').val(centerMake.details);			
			$('#lastModifiedByDetails').val(centerMake.lastModifiedBy);
			$('#lastModifiedDateDetails').val(centerMake.lastModifiedDate.substr(0,19).replace("T", " "));
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