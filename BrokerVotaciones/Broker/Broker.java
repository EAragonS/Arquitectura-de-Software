package Broker;

import java.io.*;
import java.net.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Broker {

    private static final String SERVER_IP = "127.0.0.1";  // IP del Servidor
    private static final int SERVER_PORT = 5000;          // Puerto del Servidor
    private static final int CLIENT_PORT = 6000;          // Puerto del Broker

    public Broker() {
        // Inicialización del Broker
    }

    // Método principal para iniciar el Broker
    public void iniciar() {
        new Thread(this::escucharCliente).start();
        System.out.println("Broker iniciado y listo para recibir solicitudes de clientes.");
    }

    // Método para escuchar conexiones de clientes
    private void escucharCliente() {
        try (ServerSocket serverSocket = new ServerSocket(CLIENT_PORT)) {
            System.out.println("Broker escuchando clientes en el puerto " + CLIENT_PORT);

            while (true) {
                try (Socket socketCliente = serverSocket.accept();
                    BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                    PrintWriter salidaCliente = new PrintWriter(socketCliente.getOutputStream(), true)) {

                    // Leer solicitud del cliente
                    String solicitudCliente = entradaCliente.readLine();
                    if (solicitudCliente != null) {
                        System.out.println("Solicitud recibida del Cliente: " + solicitudCliente);

                        // Convertir la solicitud a JsonObject
                        JsonObject solicitud = JsonParser.parseString(solicitudCliente).getAsJsonObject();

                        // Verificar el tipo de servicio solicitado
                        if (solicitud.has("servicio")) {
                            String servicio = solicitud.get("servicio").getAsString();
                            
                            // Procesar el servicio basado en su tipo
                            switch (servicio) {
                                case "contar":
                                case "votar":
                                    System.out.println("Servicio '" + servicio + "' detectado.");
                                    String respuestaServidor = procesarSolicitudConServidor(solicitud);

                                    // Enviar la respuesta al cliente
                                    salidaCliente.println(respuestaServidor);
                                    System.out.println("Respuesta enviada al Cliente: " + respuestaServidor);
                                    break;

                                default:
                                    System.err.println("Servicio no reconocido: " + servicio);
                                    salidaCliente.println("{\"error\": \"Servicio no reconocido.\"}");
                                    break;
                            }
                        } else {
                            System.err.println("Solicitud inválida: falta el campo 'servicio'.");
                            salidaCliente.println("{\"error\": \"Solicitud inválida: falta el campo 'servicio'.\"}");
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Error procesando solicitud del Cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el Broker para clientes: " + e.getMessage());
        }
    }



    // Método para procesar una solicitud con el Servidor
    private String procesarSolicitudConServidor(JsonObject solicitud) {
        try (Socket socketServidor = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socketServidor.getInputStream()));
             PrintWriter salidaServidor = new PrintWriter(socketServidor.getOutputStream(), true)) {

            // Enviar solicitud al Servidor
            salidaServidor.println(solicitud.toString());
            System.out.println("Solicitud enviada al Servidor: " + solicitud);

            // Leer la respuesta del Servidor
            String respuestaServidor = entradaServidor.readLine();
            System.out.println("Respuesta recibida del Servidor: " + respuestaServidor);

            return respuestaServidor;

        } catch (IOException e) {
            System.err.println("Error al comunicarse con el Servidor: " + e.getMessage());
            return "{\"error\": \"No se pudo procesar la solicitud con el Servidor.\"}";
        }
    }

    public static void main(String[] args) {
        Broker broker = new Broker();
        broker.iniciar();
    }
}
