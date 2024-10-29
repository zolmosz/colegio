/**
 * 
 */
// Función para obtener los datos desde el backend y almacenarlos en sessionStorage
function storeInSessionStorage() {
    fetch('/')
        .then(response => response.json())
        .then(userdata => {
            // Almacenar los datos en sessionStorage
            sessionStorage.setItem('myData', JSON.stringify(userdata));
            console.log('Datos almacenados en sessionStorage:', userdata);
        })
        .catch(error => console.error('Error al obtener los datos:', error));
}

// Llamar a la función cuando se carga la página
window.addEventListener("load", storeInSessionStorage, false);