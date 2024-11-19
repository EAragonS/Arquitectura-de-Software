package Client;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorJSON {

    private final String brokerIP = "187.155.104.33"; // Cambia por la IP del broker
    private final int brokerPort = 6000;

    // Almacena temporalmente los datos recibidos
    private String[] nombres;
    private int[] votos;

    public GestorJSON() {
        this.nombres = new String[3]; // Ajusta según el número de opciones
        this.votos = new int[3];
    }

    public void iniciarVotaciones() {
        JsonObject solicitud = new JsonObject();
        solicitud.addProperty("servicio", "contar");

        imprimirSolicitud(solicitud);
        JsonObject respuesta = enviarYRecibir(solicitud);

        if (respuesta != null) {
            procesarRespuestaContar(respuesta);
        }
    }

    public void registrarVoto(int opcion) {
        JsonObject solicitud = new JsonObject();
        solicitud.addProperty("servicio", "votar");
        solicitud.addProperty("variables", 1);
        solicitud.addProperty("variable1", nombres[opcion - 1]);
        solicitud.addProperty("valor1", 1);

        imprimirSolicitud(solicitud);
        JsonObject respuesta = enviarYRecibir(solicitud);

        if (respuesta != null) {
            procesarRespuestaVotar(respuesta);
        }
    }

    // Abre una nueva conexión para enviar la solicitud y recibir la respuesta
    private JsonObject enviarYRecibir(JsonObject solicitud) {
        try (Socket socket = new Socket(brokerIP, brokerPort);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Enviar solicitud
            out.println(solicitud.toString());

            // Recibir respuesta
            String respuesta = in.readLine();
            if (respuesta != null) {
                return JsonParser.parseString(respuesta).getAsJsonObject();
            } else {
                System.err.println("Respuesta vacía del broker.");
            }

        } catch (Exception e) {
            System.err.println("Error al comunicarse con el broker: " + e.getMessage());
        }
        return null;
    }

    private void procesarRespuestaContar(JsonObject respuesta) {
        JsonArray opciones = respuesta.getAsJsonArray("opciones");
        for (int i = 0; i < opciones.size(); i++) {
            JsonObject opcion = opciones.get(i).getAsJsonObject();
            nombres[i] = opcion.get("nombre").getAsString();
            votos[i] = opcion.get("votos").getAsInt();
        }
    }

    private void procesarRespuestaVotar(JsonObject respuesta) {
        // Log de la respuesta del servicio "votar"
        System.out.println("Respuesta recibida del broker: " + respuesta.toString());

        // Después de registrar el voto, actualiza los datos solicitando nuevamente "contar"
        JsonObject solicitudActualizar = new JsonObject();
        solicitudActualizar.addProperty("servicio", "contar");

        imprimirSolicitud(solicitudActualizar);
        JsonObject respuestaActualizar = enviarYRecibir(solicitudActualizar);

        if (respuestaActualizar != null) {
            procesarRespuestaContar(respuestaActualizar);
        }
    }

    private void imprimirSolicitud(JsonObject solicitud) {
        System.out.println("Solicitud enviada al broker: " + solicitud.toString());
    }

    public String getNombreOpcion(int index) {
        return nombres[index];
    }

    public int getVotosOpcion(int index) {
        return votos[index];
    }
}
