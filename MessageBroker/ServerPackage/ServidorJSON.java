package Server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ServicioJSON {
    private ModeloVotaciones modelo;
    private Gson gson;

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
        respuesta.addProperty("respuestas", 3);
        respuesta.addProperty("respuesta1", modelo.getLabel1());
        respuesta.addProperty("valor1", modelo.getResultados1());
        respuesta.addProperty("respuesta2", modelo.getLabel2());
        respuesta.addProperty("valor2", modelo.getResultados2());
        respuesta.addProperty("respuesta3", modelo.getLabel3());
        respuesta.addProperty("valor3", modelo.getResultados3());
        return gson.toJson(respuesta);
    }

    // Servicio: votar
    public String votar(String producto) {
        int opcion = getOptionFromLabel(producto);
        if (opcion == -1) return generarRespuestaError("Producto no encontrado");

        modelo.registrarVoto(opcion);
        JsonObject respuesta = new JsonObject();
        respuesta.addProperty("servicio", "votar");
        respuesta.addProperty("respuestas", 1);
        respuesta.addProperty("respuesta1", producto);
        respuesta.addProperty("valor1", getVotosFromOption(opcion));
        return gson.toJson(respuesta);
    }

    // Servicio: registrar
    public String registrar(String evento, String fecha) {
        // Lógica para registrar un evento en bitácora. Ejemplo simple de respuesta
        JsonObject respuesta = new JsonObject();
        respuesta.addProperty("servicio", "registrar");
        respuesta.addProperty("respuestas", 1);
        respuesta.addProperty("respuesta1", "eventos");
        respuesta.addProperty("valor1", 200); // Placeholder del número de eventos
        return gson.toJson(respuesta);
    }

    // Servicio: listar
    public String listar() {
        JsonObject respuesta = new JsonObject();
        respuesta.addProperty("servicio", "listar");
        respuesta.addProperty("respuestas", 3); // Cantidad de eventos
        respuesta.addProperty("respuesta1", "evento1");
        respuesta.addProperty("valor1", "Fecha y detalle del evento");
        // Agrega los eventos necesarios
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
