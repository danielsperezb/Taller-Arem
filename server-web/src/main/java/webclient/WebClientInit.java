package webclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Clase que implementa la logica para los llamados al servicio externo
 */
public class WebClientInit {

    public static String BASE_URL_API = "http://www.omdbapi.com/?";
    public static String API_KEY = "d7a49338";
    public static String NAME_PARAMETER = "t=";
    public static String API_KEY_PARAMETER = "&apiKey=";

    /**
     * Metodo encargado de generar la BASE URL final y hacer la peticion HTTP al servicio externo
     * @param nombre El nombre de la pelicula a buscar
     * @return un String que representa la respuesta del servidor. Esta respuesta puede ser negativa (si no se encuentran peliculas)
     * o positiva con la información de la pelicula
     */
    public String buscarPeliculaApiExterna(String nombre){
        String finalUrl = BASE_URL_API + NAME_PARAMETER + nombre + API_KEY_PARAMETER + API_KEY;
        String finalResponse = "";
        try {
            URL url = new URL(finalUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                finalResponse = response.toString();
            } else {
                return "La API externa no está funcionando correctamente!";
            }
        } catch (MalformedURLException e) {
            System.out.println("La URL generada, está malformada: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al abrir la conexión web hacía el cliente externo: "+ e.getMessage());
        }
        return finalResponse;
    }


}
