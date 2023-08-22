package socket;

import cache.CacheInit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase utilizada para crear el socket principal de la aplicación
 * Es la puerta de entrada para las peticiones de la aplicación.
 */
public class SocketInit {

    private final static CacheInit cacheInit = CacheInit.getInstance();
    private final static int PUERTO_SERVIDOR = 35000;

    /**
     * Metodo que implementa la clase ServerSocket y que abre un puerto de escucha para
     * recibir peticiones externas.
     */
    public static void socketInitialize() {
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO_SERVIDOR);
            System.out.println("Servidor escuchando en el puerto :"+ PUERTO_SERVIDOR);
            boolean running = true;

            while(running) {
                try {
                    Socket clientSocket = serverSocket.accept();

                    System.out.println("Recibiendo... ");

                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    String response = "";
                    String inputLine, outputLine;

                    while ((inputLine = in.readLine()) != null) {
            
                        if (inputLine.startsWith("GET /?name=")){
                            inputLine = inputLine.replace("GET /name=", "");
                            inputLine = inputLine.replace(" HTTP/1.1", "");
                            response = inputLine;
                        }
                        //response= GET /?name=asd
                        

                        if (!in.ready()) {
                            break;
                        }
                    }
                    
                   

                    outputLine = "HTTP/1.1 200 \r\n" +
                            "Content-Type: application/json \r\n" +
                            "Access-Control-Allow-Origin: * \r\n" +
                            "\r\n" +
                            getPeliculaByName(response);

                    out.println(outputLine);

                    out.close();
                    in.close();
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error al recibir información: "+ e.getMessage());
                    System.exit(1);
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("No se puede abrir la conexión en el puerto "+ PUERTO_SERVIDOR + " : "+ e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Metodo utilizado para hacer el llamado de la clase Cache y buscar una pelicula por nombre
     * @param response Parametro que contiene el nombre de la pelicula a buscar
     * @return La respuesta con la información de la pelicula. Es agnostico de si la devolvió la caché, o el servicio externo.
     */
    private static String getPeliculaByName(String response){
        return cacheInit.buscarPeliculaPorNombre(response.replace("GET /?name=", ""));
    }
}
