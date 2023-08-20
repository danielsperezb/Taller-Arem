const contenedorPelicula = document.getElementById("info-pelicula");

async function obtenerInfoPelicula(){
    const nombrePelicula = document.getElementById("nombrePelicula");

    if( nombrePelicula.value != '' && nombrePelicula.value != undefined ){
        const url = "http://localhost:35000/?name="+nombrePelicula.value;
        const respuesta = await fetch(url, {
            method: "GET",
            headers: {
                "Accept": "application/json"
            }
        });
        const infoPeliculas = await respuesta.json();

        let contenedorInfo = "";
        if( !infoPeliculas.Error ){    
            contenedorInfo += `
                        <div class="card" style="width: 18rem;">
                            <img src="${infoPeliculas.Poster}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">${infoPeliculas.Title}</p>
                                <p class="card-text">${infoPeliculas.Plot}</p>
                                <span class="badge bg-secondary">${infoPeliculas.imdbRating}</span></h6>
                            </div>
                        </div>`
    
        } else {
            contenedorInfo += `
                <div class="card text-bg-danger mb-3" style="max-width: 18rem;">
                    <div class="card-header">Error!</div>
                    <div class="card-body">
                        <h5 class="card-title">Pelicula no encontrada!</h5>
                        <p class="card-text">Lo sentimos, la pelicula que has intentando buscar no ha sido encontrada en la base de datos.</p>
                    </div>
                </div>`          
        }

        contenedorPelicula.innerHTML = contenedorInfo;
    } else {
        alert('Para buscar la informacíón de la pelicula, escriba en el input')
    }
}

const button = document.getElementById("btnBuscarPelicula");

button.addEventListener("click", obtenerInfoPelicula)