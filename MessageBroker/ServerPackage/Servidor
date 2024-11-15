package Server;

import java.io.*;
import java.net.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Servidor {
    private static final int PORT = 12345; // Puerto de escucha
    private ServicioJSON servicioJSON;

    public Servidor() {
        servicioJSON = new ServicioJSON();
    }

    public void iniciar() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado en el puerto " + PORT);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    String request = in.readLine();
                    String response = procesarSolicitud(request);

                    out.println(response);
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private String procesarSolicitud(String solicitudJSON) {
        Gson gson = new Gson();
        JsonObject solicitud = gson.fromJson(solicitudJSON, JsonObject.class);
        String servicio = solicitud.get("servicio").getAsString();

        return switch (servicio) {
            case "contar" -> servicioJSON.contar();
            case "votar" -> {
                String producto = solicitud.get("variable1").getAsString();
                yield servicioJSON.votar(producto);
            }
            case "registrar" -> {
                String evento = solicitud.get("valor1").getAsString();
                String fecha = solicitud.get("valor2").getAsString();
                yield servicioJSON.registrar(evento, fecha);
            }
            case "listar" -> servicioJSON.listar();
            default -> servicioJSON.generarRespuestaError("Servicio no encontrado");
        };
    }

    public static void main(String[] args) {
        // Inicializamos el servidor
        Servidor servidor = new Servidor();

        // Prueba para mostrar JSON de salida de la operación "contar"
        String jsonContar = servidor.servicioJSON.contar();
        System.out.println("JSON de salida para la operación 'contar': " + jsonContar);

        // Iniciar el servidor en modo escucha (comentado mientras se prueba)
        // servidor.iniciar();
    }
}
