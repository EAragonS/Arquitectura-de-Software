package Server;

/**
 *
 * @author ellysxd
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModeloVotaciones {
    
    private String label1;
    private String label2;
    private String label3;
    private int resultados1;
    private int resultados2;
    private int resultados3;

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public String getLabel3() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3 = label3;
    }

    public int getResultados1() {
        return resultados1;
    }

    public void setResultados1(int resultados1) {
        this.resultados1 = resultados1;
    }

    public int getResultados2() {
        return resultados2;
    }

    public void setResultados2(int resultados2) {
        this.resultados2 = resultados2;
    }

    public int getResultados3() {
        return resultados3;
    }

    public void setResultados3(int resultados3) {
        this.resultados3 = resultados3;
    }
    
    // Método para incrementar el conteo de votos para la opción seleccionada
    public void registrarVoto(int opcion) {
        String opcionLabel = ""; // Guardará el label correspondiente

        switch (opcion) {
            case 1:
                resultados1++;
                opcionLabel = label1;
                break;
            case 2:
                resultados2++;
                opcionLabel = label2;
                break;
            case 3:
                resultados3++;
                opcionLabel = label3;
                break;
            default:
                System.err.println("Opción de voto no válida");
                return;
        }
        actualizarLogVotaciones(opcionLabel); // Llamada al log con el label correcto
    }
    
    private void actualizarLogVotaciones(String opcionLabel) {
        String archivo = "logvotaciones.txt";
        StringBuilder contenidoPrevio = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenidoPrevio.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {
            // Escribir los resultados actuales usando los labels
            bw.write(label1 + ": " + resultados1 + "\n");
            bw.write(label2 + ": " + resultados2 + "\n");
            bw.write(label3 + ": " + resultados3 + "\n");
            bw.write("\n--- Registro de votaciones ---\n");

            int indice = contenidoPrevio.indexOf("--- Registro de votaciones ---");
            if (indice != -1) {
                bw.write(contenidoPrevio.substring(indice + "--- Registro de votaciones ---".length() + 1));
            }

            // Agregar el nuevo registro de voto con fecha y hora
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHora = dtf.format(LocalDateTime.now());
            bw.write("[" + fechaHora + "] " + opcionLabel + "\n");

        } catch (IOException e) {
            System.err.println("Error al actualizar el archivo: " + e.getMessage());
        }
    }

 
    public void cambiarNombreOpciones() {
        //String archivo = "/Users/Usuario/OneDrive/Escritorio/opciones.txt"; // Reemplaza con la ruta correcta del archivo
        String archivo = "opciones.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            setLabel1(br.readLine());
            setLabel2(br.readLine());
            setLabel3(br.readLine());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    public void obtenerResultadosVotaciones() {
     String archivo = "logvotaciones.txt";

     try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
         String line;
         int lineCount = 0;

         // Leer solo las primeras tres líneas
         while ((line = br.readLine()) != null && lineCount < 3) {
             String[] partes = line.split(":");

             if (partes.length == 2) {
                 int resultado = Integer.parseInt(partes[1].trim()); // Tomar el valor después de ':'

                 // Asignar a resultados1, resultados2, o resultados3 según la línea
                 switch (lineCount) {
                     case 0:
                         resultados1 = resultado;
                         break;
                     case 1:
                         resultados2 = resultado;
                         break;
                     case 2:
                         resultados3 = resultado;
                         break;
                 }
                 lineCount++;
             }
         }
     } catch (IOException e) {
         System.err.println("Error al leer el archivo: " + e.getMessage());
     } catch (NumberFormatException e) {
         System.err.println("Error al convertir el número: " + e.getMessage());
     }
    } 
    
}
