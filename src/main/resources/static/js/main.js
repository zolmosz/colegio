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

  $('.datepicker').datepicker({
    format: 'dd/mm/yyyy',  // Formato de fecha que deseas usar
    autoclose: true,
    todayHighlight: true,
    orientation: "bottom auto"  // Para ajustar la posición del calendario
  });

  const timePicker = new tempusDominus.TempusDominus(document.getElementById('timepicker'), {
    display: {
      components: {
        calendar: false, // Desactiva el calendario para que solo muestre la hora
        clock: true,
        hours: true,
        minutes: true,
        seconds: false  // Puedes activar los segundos si los necesitas
      },
      theme: 'bootstrap' // Usa el tema Bootstrap para combinar con SB-Admin 2
    },
    localization: {
      format: 'HH:mm'  // Formato de hora
    }
  });

});