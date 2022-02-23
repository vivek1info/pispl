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
		$.get(href, function(jobTitle, status){
			$('#idDetails').val(jobTitle.id);
			$('#descriptionDetails').val(jobTitle.description);
			$('#detailsDetails').val(jobTitle.details);
			$('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
			$('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substr(0,19).replace("T", " "));
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