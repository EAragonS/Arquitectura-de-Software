package Client;

public class Controlador {
    private Vista ui;
    private GestorJSON gestor;
    private ModeloGraficas modeloGraficas;

    public Controlador(Vista ui, GestorJSON gestor) {
        this.ui = ui;
        this.gestor = gestor;
        this.modeloGraficas = new ModeloGraficas(); // Instancia del modelo de gráficas
        configurarEventos();
    }

    public void iniciarVotaciones() {
        gestor.iniciarVotaciones();

        // Actualiza los JLabels en la vista con los resultados
        ui.getLabelOp1().setText(gestor.getNombreOpcion(0));
        ui.getLabelOp2().setText(gestor.getNombreOpcion(1));
        ui.getLabelOp3().setText(gestor.getNombreOpcion(2));
        ui.getResultados1().setText(String.valueOf(gestor.getVotosOpcion(0)));
        ui.getResultados2().setText(String.valueOf(gestor.getVotosOpcion(1)));
        ui.getResultados3().setText(String.valueOf(gestor.getVotosOpcion(2)));

        // Actualiza las gráficas con los datos iniciales
        actualizarGraficas();
    }

    private void configurarEventos() {
        ui.getBtnOp1().addActionListener(e -> {
            gestor.registrarVoto(1);
            actualizarResultados();
        });

        ui.getBtnOp2().addActionListener(e -> {
            gestor.registrarVoto(2);
            actualizarResultados();
        });

        ui.getBtnOp3().addActionListener(e -> {
            gestor.registrarVoto(3);
            actualizarResultados();
        });
    }

    private void actualizarResultados() {
        ui.getResultados1().setText(String.valueOf(gestor.getVotosOpcion(0)));
        ui.getResultados2().setText(String.valueOf(gestor.getVotosOpcion(1)));
        ui.getResultados3().setText(String.valueOf(gestor.getVotosOpcion(2)));

        // Actualiza las gráficas con los datos más recientes
        actualizarGraficas();
    }

    private void actualizarGraficas() {
        int votos1 = gestor.getVotosOpcion(0);
        int votos2 = gestor.getVotosOpcion(1);
        int votos3 = gestor.getVotosOpcion(2);

        String opcion1 = gestor.getNombreOpcion(0);
        String opcion2 = gestor.getNombreOpcion(1);
        String opcion3 = gestor.getNombreOpcion(2);

        // Actualiza la gráfica de barras
        modeloGraficas.graficarBarras(votos1, votos2, votos3, opcion1, opcion2, opcion3, ui.getPanelBarras());

        // Actualiza la gráfica de pastel
        modeloGraficas.graficarPastel(votos1, votos2, votos3, opcion1, opcion2, opcion3, ui.getPanelPastel());
    }
}
