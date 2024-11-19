package Server;

import java.io.*;
import java.net.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Servidor {
    private static final int PORT = 5000;
    private ServicioJSON servicioJSON;

    public Servidor() {
        servicioJSON = new ServicioJSON();
    }

    public void iniciar() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado en el puerto " + PORT);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    String request = in.readLine();
                    if (request != null) {
                        String response = procesarSolicitud(request);
                        out.println(response);
                    } else {
                        out.println(servicioJSON.generarRespuestaError("Solicitud vacía"));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private String procesarSolicitud(String solicitudJSON) {
        Gson gson = new Gson();
        try {
            JsonObject solicitud = gson.fromJson(solicitudJSON, JsonObject.class);
            String servicio = solicitud.get("servicio").getAsString();
    
            return switch (servicio) {
                case "contar" -> servicioJSON.contar();
                case "votar" -> servicioJSON.votar(solicitudJSON); // Pasar solicitud completa
                case "registrar" -> {
                    String evento = solicitud.get("valor1").getAsString();
                    String fecha = solicitud.get("valor2").getAsString();
                    yield servicioJSON.registrar(evento, fecha);
                }
                case "listar" -> servicioJSON.listar();
                default -> servicioJSON.generarRespuestaError("Servicio no encontrado: " + servicio);
            };
        } catch (Exception e) {
            return servicioJSON.generarRespuestaError("Error al procesar solicitud: " + e.getMessage());
        }
    }
    

    public void probarServicios() {
        System.out.println("Prueba de servicios:");
    
        // Prueba del servicio 'contar'
        System.out.println("\n--- Servicio: Contar ---");
        System.out.println(servicioJSON.contar());
    
        // Prueba del servicio 'votar'
        System.out.println("\n--- Servicio: Votar (voto para el primer producto) ---");
        System.out.println(servicioJSON.votar("ProductoEjemplo"));
    
        // Prueba del servicio 'registrar'
        System.out.println("\n--- Servicio: Registrar ---");
        System.out.println(servicioJSON.registrar("Evento de prueba", "2024-11-17 10:00:00"));
    
        // Prueba del servicio 'listar'
        System.out.println("\n--- Servicio: Listar ---");
        System.out.println(servicioJSON.listar());
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciar();
        // Prueba de servicios
        servidor.probarServicios();
    }
}
