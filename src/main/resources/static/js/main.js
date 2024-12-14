/**
 * 
 */
$(document).ready(function() {
	
	$('#deleteModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Botón que abrió el modal
        var countryId = button.data('userid'); // Capturamos el valor de data-userid
        var modulo = button.data('modulo');
        var opcion = button.data('opcion');
		
        // Actualizamos el enlace "Eliminar" dentro del modal con el ID capturado
        var modal = $(this);
        if (modulo != null){
          modal.find('#delRef').attr('href', '/views/'+modulo+'/'+opcion+'/eliminar/' + countryId);
        }else{
          modal.find('#delRef').attr('href', '/views/'+opcion+'/eliminar/' + countryId);
        }
    });

  $('#verDocModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Botón que abrió el modal
        var tipDoc = button.data('tipodoc'); // Capturamos el valor de data-userid
        var imgDoc = button.data('imgdoc');
		
        if (tipDoc === 'regCiv') {
          tipDoc = 'Registro Civil de Nacimiento';
        }
        // Actualizamos el enlace "Ver Documento" dentro del modal con el ID capturado
        var modal = $(this);
        modal.find('#tipoDocRef').text(tipDoc);
        modal.find('#imgDocRef').attr('src', imgDoc);
        
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

function nextStep(step,percent) {
  document.querySelectorAll('.form-step').forEach(el => el.classList.add('d-none'));
  document.getElementById('step' + step).classList.remove('d-none');
  document.getElementById('progressBar').style.width = (step * percent) + '%';
}

function prevStep(step,percent) {
  nextStep(step,percent);
}



