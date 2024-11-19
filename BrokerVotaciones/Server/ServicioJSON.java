package Server;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ServicioJSON {
    private ModeloVotaciones modelo;
    private Gson gson;

    public ModeloVotaciones getModelo() {
        return modelo;
    }    

    public ServicioJSON() {
        modelo = new ModeloVotaciones();
        gson = new Gson();
        modelo.cambiarNombreOpciones(); // Inicializa los nombres de opciones
        modelo.obtenerResultadosVotaciones(); // Obtiene los resultados actuales
        
    }

    // Servicio: contar
    public String contar() {
        JsonObject respuesta = new JsonObject();
        respuesta.addProperty("servicio", "contar");
        JsonArray opciones = new JsonArray();

        JsonObject opcion1 = new JsonObject();
        opcion1.addProperty("nombre", modelo.getLabel1());
        opcion1.addProperty("votos", modelo.getResultados1());
        opciones.add(opcion1);

        JsonObject opcion2 = new JsonObject();
        opcion2.addProperty("nombre", modelo.getLabel2());
        opcion2.addProperty("votos", modelo.getResultados2());
        opciones.add(opcion2);

        JsonObject opcion3 = new JsonObject();
        opcion3.addProperty("nombre", modelo.getLabel3());
        opcion3.addProperty("votos", modelo.getResultados3());
        opciones.add(opcion3);

        respuesta.add("opciones", opciones);
        return gson.toJson(respuesta);
    }
    

    // Servicio: votar
    public String votar(String jsonSolicitud) {
        try {
            // Parsear la solicitud JSON
            JsonObject solicitud = gson.fromJson(jsonSolicitud, JsonObject.class);
    
            // Verificar si el formato es correcto
            if (!solicitud.has("variable1")) {
                return generarRespuestaError("Formato de solicitud inválido");
            }
    
            String producto = solicitud.get("variable1").getAsString();
    
            // Buscar el índice del producto en los datos del modelo
            int opcion = getOptionFromLabel(producto);
            if (opcion == -1) {
                return generarRespuestaError("Producto no encontrado");
            }
    
            // Registrar el voto para la opción encontrada
            modelo.registrarVoto(opcion);
    
            // Crear la respuesta
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("servicio", "votar");
            respuesta.addProperty("producto", producto);
            respuesta.addProperty("votos_actualizados", getVotosFromOption(opcion));
            return gson.toJson(respuesta);
    
        } catch (Exception e) {
            // Capturar cualquier error inesperado
            return generarRespuestaError("Error al procesar solicitud: " + e.getMessage());
        }
    }
    

    // Servicio: registrar
    public String registrar(String evento, String fecha) {
        JsonObject respuesta = new JsonObject();
        respuesta.addProperty("servicio", "registrar");
        respuesta.addProperty("evento", evento);
        respuesta.addProperty("fecha", fecha);
        respuesta.addProperty("status", "registrado");
        return gson.toJson(respuesta);
    }

    // Servicio: listar
    public String listar() {
        JsonObject respuesta = new JsonObject();
        respuesta.addProperty("servicio", "listar");
        JsonArray eventos = new JsonArray();

        String archivo = "logvotaciones.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("[") && linea.contains("]")) {
                    JsonObject evento = new JsonObject();
                    evento.addProperty("detalle", linea);
                    eventos.add(evento);
                }
            }
        } catch (IOException e) {
            return generarRespuestaError("Error al listar eventos: " + e.getMessage());
        }

        respuesta.add("eventos", eventos);
        return gson.toJson(respuesta);
    }

    // Métodos auxiliares
    private int getOptionFromLabel(String label) {
        if (label.equals(modelo.getLabel1())) return 1;
        if (label.equals(modelo.getLabel2())) return 2;
        if (label.equals(modelo.getLabel3())) return 3;
        return -1;
    }

    private int getVotosFromOption(int opcion) {
        return switch (opcion) {
            case 1 -> modelo.getResultados1();
            case 2 -> modelo.getResultados2();
            case 3 -> modelo.getResultados3();
            default -> 0;
        };
    }

    public String generarRespuestaError(String mensaje) {
        JsonObject respuesta = new JsonObject();
        respuesta.addProperty("servicio", "error");
        respuesta.addProperty("mensaje", mensaje);
        return gson.toJson(respuesta);
    }
}
