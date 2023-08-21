package cache;

import webclient.WebClientInit;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase utilizada que implementa la funcionalidad de la caché de la aplicación.
 *
 */
public class CacheInit {

    private static final String ERROR_MESSAGE = "{\"Response\":\"False\"";

    /**
     * Atributo creado llevar un conteo de cuantas veces se ha llamado a la cache
     */
    private int contador = 0;

    private WebClientInit webClientInit;
    private static CacheInit cacheInit = null;

    public CacheInit(WebClientInit webClientInit){
        this.webClientInit = webClientInit;
    }

    /**
     * Estructura de datos usada para guardar en memoria la información de las peliculas consultadas.
     * Funciona como cache para la aplicación y hace uso de variante ConcurrentHashMap para evitar
     * alterar la integridad de la información cuando se estén ejecutando operaciones concurrentes
     */
    ConcurrentHashMap<String, String> peliculas = new ConcurrentHashMap<>();


    /**
     * Metodo usado para retornar la instancia unica de la clase Cache. Basado en el patrón singleton
     * ya que esperamos tener una sola instancia de esta clase, para todo el ciclo de vida de la aplicación
     * @return una instancia CacheInit unica
     */
    public static CacheInit getInstance(){
        if( cacheInit == null ){
            cacheInit = new CacheInit(new WebClientInit());
        }

        return cacheInit;
    }

    /**
     * Metodo utilizado para buscar una pelicula principalmente en la caché de la aplicación (HashMap)
     * de lo contrario, llama al servicio WebClient para hacer la petición a la external API
     * @param nombre Nombre de la pelicula
     * @return un string que representa la información de la pelicula
     */
    public String buscarPeliculaPorNombre(String nombre){

        if( peliculas.containsKey(nombre) ){
            contador++;
            return peliculas.get(nombre);
        } else {
            String response = webClientInit.buscarPeliculaApiExterna(nombre);
            if (!response.startsWith(ERROR_MESSAGE)){
                peliculas.put(nombre, response);
            }
            //System.out.println("Busca la pelicula en la API");
            //System.out.println(response);
            return response;
        }
    }

    /**
     * Metodo encargado de devolver el valor del atributo contador
     * @return un entero que representa el valor del contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * Metodo encargado de devolver el valor del atributo Peliculas del tipo HashMap
     * @return un hashMap con las peliculas
     */
    public ConcurrentHashMap<String, String> getPeliculas() {
        return peliculas;
    }

}
