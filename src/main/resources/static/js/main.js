/**
 * 
 */
$(document).ready(function() {
//	$('.dataTable .delBtn').on('click', function(event) {
//		event.preventDefault();
//		var href = $(this).attr('href');
//		$('#deleteModal #delRef').attr('href', href);
//		$('#deleteModal').modal();
//	});
	
	$('#deleteModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Botón que abrió el modal
        var countryId = button.data('userid'); // Capturamos el valor de data-userid
        var opcion = button.data('opcion');
		
        // Actualizamos el enlace "Eliminar" dentro del modal con el ID capturado
        var modal = $(this);
        modal.find('#delRef').attr('href', '/views/'+opcion+'/eliminar/' + countryId);
    });
});