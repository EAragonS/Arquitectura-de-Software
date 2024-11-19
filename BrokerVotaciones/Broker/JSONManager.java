package Broker;

import com.google.gson.JsonObject;

public class JSONManager {

    // Crear una solicitud genérica con variables dinámicas
    public JsonObject crearSolicitud(String servicio, JsonObject variables) {
        JsonObject json = new JsonObject();
        json.addProperty("servicio", servicio);
        json.add("variables", variables); // Añadir las variables como un objeto JSON
        return json;
    }

    // Método auxiliar para crear solicitudes registrar
    public JsonObject crearSolicitudRegistrar(String ip, int puerto, String nombreServicio, int numParametros) {
        JsonObject variables = new JsonObject();
        variables.addProperty("servidor", ip);
        variables.addProperty("puerto", puerto);
        variables.addProperty("servicio", nombreServicio);
        variables.addProperty("parametros", numParametros);
        return crearSolicitud("registrar", variables);
    }

    // Método auxiliar para crear solicitudes listar
    public JsonObject crearSolicitudListar(String palabra) {
        JsonObject variables = new JsonObject();
        variables.addProperty("palabra", palabra);
        return crearSolicitud("listar", variables);
    }

    // Método auxiliar para crear solicitudes ejecutar
    public JsonObject crearSolicitudEjecutar(String servicio, String param, String valor) {
        JsonObject variables = new JsonObject();
        variables.addProperty("servicio", servicio);
        variables.addProperty(param, valor); // Parámetro dinámico
        return crearSolicitud("ejecutar", variables);
    }

    // Mostrar y analizar respuesta JSON
    public void mostrarRespuesta(JsonObject respuesta) {
        if (respuesta.has("error")) {
            System.err.println("Error en la respuesta: " + respuesta.get("error").getAsString());
        } else {
            System.out.println("Respuesta procesada correctamente: " + respuesta.toString());
        }
    }

    // Método para mostrar la solicitud enviada
    public void mostrarSolicitud(JsonObject solicitud) {
        System.out.println("Solicitud procesada: " + solicitud.toString());
    }

} 
