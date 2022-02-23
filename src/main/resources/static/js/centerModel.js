$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerModel, status){
			$('#idEdit').val(centerModel.id);
			$('#descriptionEdit').val(centerModel.description);
			$('#detailsEdit').val(centerModel.details);
		});					
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(centerModel, status){
			$('#idDetails').val(centerModel.id);
			$('#descriptionDetails').val(centerModel.description);
			$('#detailsDetails').val(centerModel.details);
			$('#createdByDetails').val(centerModel.createdBy);
			$('#createdDateDetails').val(centerModel.createdDate.substr(0,19).replace("T"," "));
			$('#lastModifiedByDetails').val(centerModel.lastModifiedBy);
			$('#lastModifiedDateDetails').val(centerModel.lastModifiedDate.substr(0,19).replace("T", " "));
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