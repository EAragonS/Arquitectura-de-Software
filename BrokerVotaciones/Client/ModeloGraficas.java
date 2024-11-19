/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Usuario
 */
public class ModeloGraficas {

    public ModeloGraficas() {
    }
    
    public void graficarBarras(int num1, int num2, int num3, String opcion1, String opcion2, String opcion3, JPanel panelBarras){
       DefaultCategoryDataset datos = new DefaultCategoryDataset();
       
       datos.setValue(num1, "votos", opcion1);
       datos.setValue(num2, "votos", opcion2);
       datos.setValue(num3, "votos", opcion3);
       
       JFreeChart graficoBarras = ChartFactory.createBarChart3D(
               "Votaciones de productos",
               "Opciones",
               "Votos",
               datos,
               PlotOrientation.VERTICAL,
               true,
               true,
               false
       );
       ChartPanel panel = new ChartPanel(graficoBarras);
       panel.setMouseWheelEnabled(true);
       panel.setPreferredSize(new Dimension(240,180));
       
       panelBarras.removeAll();
       panelBarras.setLayout(new BorderLayout());
       panelBarras.add(panel, BorderLayout.NORTH);
       panelBarras.revalidate();
       panelBarras.repaint();
    }
    
    public void graficarPastel(int num1, int num2, int num3, String opcion1, String opcion2, String opcion3, JPanel panelPastel){
        DefaultPieDataset datos = new DefaultPieDataset();
        
        datos.setValue(opcion1, num1);
        datos.setValue(opcion2, num2);
        datos.setValue(opcion3, num3);
        
        JFreeChart graficoPastel = ChartFactory.createPieChart(
                "Votaciones de productos",
                datos,
                true,
                true,
                false
        );
        ChartPanel panel = new ChartPanel(graficoPastel);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(240, 180));
        
        panelPastel.removeAll();
        panelPastel.setLayout(new BorderLayout());
        panelPastel.add(panel, BorderLayout.NORTH);
        panelPastel.revalidate();
        panelPastel.repaint();
    }

    
}
