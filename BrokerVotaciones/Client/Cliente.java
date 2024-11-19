package Client;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Crear instancia de GestorJSON
            GestorJSON gestor = new GestorJSON();

            // Crear instancia de la Vista
            Vista vista = new Vista();

            // Crear instancia del Controlador y pasar Vista y GestorJSON
            Controlador controlador = new Controlador(vista, gestor);

            // Solicitar resultados iniciales al iniciar
            controlador.iniciarVotaciones();

            // Mostrar la vista
            vista.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al iniciar el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
