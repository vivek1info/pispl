$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerStatus, status){
			$('#idEdit').val(centerStatus.id);
			$('#descriptionEdit').val(centerStatus.description);
			$('#detailsEdit').val(centerStatus.details);
		});					
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerStatus, status){
			$('#idDetails').val(centerStatus.id);
			$('#descriptionDetails').val(centerStatus.description);
			$('#lastModifiedByDetails').val(centerStatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(centerStatus.lastModifiedDate.substr(0,19).replace("T", " "));
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