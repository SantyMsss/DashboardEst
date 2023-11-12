package dashboardestd;

/*
INDICE DE LOS DATOS: 
universidad; sector ies; id caracter; caracter; código del departamento (ies); departamento de domicilio de la ies;código del municipio (ies);municipio de domicilio de la ies; código snies del programa; programa académico; id nivel académico;nivel académico;id nivel de formación;nivel de formación; id metodología;metodología;id área;área de conocimiento;id cine campo especifico;desc cine campo especifico;id sexo;sexo;año;semestre;graduados     
"UNIVERSIDAD NACIONAL DE COLOMBIA;1;4;Universidad;11;Bogotá D.C.;11001;""Bogotá; D.C."";1;INGENIERIA AGRONOMICA;1;PREGRADO;6;Universitaria;1;Presencial;8;""Ingeniería; arquitectura; urbanismo y afines"";81;Agropecuario;1;Hombre;2020;1;29"

*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class FuncionArchivo {


    ArrayList<Institucion> inst = new ArrayList<>();

    public void Leer_Archivo(String nomFile) {
        FileReader fr = null;
        boolean error = false;
        try {
            fr = new FileReader(nomFile);
        } catch (Exception e) {
            error = true;
            System.out.println(e);
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String tokens[];
            int fila = 1;
            try {
                while ((linea = br.readLine()) != null) {
                    //System.out.println(fila + " - " + linea);
                    tokens = linea.split(",");
                    inst.add(new Institucion(tokens[0], tokens[3], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[23]));
                    fila++;
                }
            } catch (Exception e) {
                System.out.println("Error en la fila = " + fila + "\n" + e);
            }
            try {
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }// if(!error)
    }
    
    public void listar(){
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);
            System.out.println((i+1) + " " + obj.getGenero());
        }
    }
    
    public void estadisticaUni(){
        int nacional = 0, uceva = 0, univalle = 0, antioquia = 0;
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);
            switch (obj.nombre) {
                case "UNIVERSIDAD NACIONAL DE COLOMBIA":   nacional++;                  
                    break;
                case "UNIDAD CENTRAL DEL VALLE DEL CAUCA":   uceva++;                  
                    break;
                case "UNIVERSIDAD DEL VALLE":   univalle++;                  
                    break;
                case "UNIVERSIDAD DE ANTIOQUIA":   antioquia++;                  
                    break;
            }
        }
        System.out.println(nacional);
        System.out.println(uceva);
        System.out.println(univalle);         
        System.out.println(antioquia);
        
    }
    
    
     public ChartPanel generarGraficoHombresMujeres() {
        int hom = 0, mujer = 0;

        // Lógica para contar hombres y mujeres 
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);

            switch (obj.genero) {
                case "Hombre":
                case "1":
                    hom++;
                    break;
                case "Mujer":
                case "2":
                    mujer++;
                    break;
            }
        }

        System.out.println("Hombres: " + hom);
        System.out.println("Mujeres: " + mujer);

        DefaultCategoryDataset dataset = createGeneroDataset(hom, mujer);

        JFreeChart chart = ChartFactory.createBarChart(
                "GRÁFICO DE HOMBRES Y MUJERES",
                "GÉNERO",
                "CANTIDAD",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        // Ajustes visuales del gráfico
        chart.setBackgroundPaint(new Color(255, 151, 120));
        Font titleFont = new Font("SansSerif", Font.BOLD, 18);
        chart.getTitle().setFont(titleFont);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));

        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));

        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(512, 512));

        return chartPanel;
    }

    private DefaultCategoryDataset createGeneroDataset(int hombres, int mujeres) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(hombres, "HOMBRE", "CANTIDAD");
        dataset.addValue(mujeres, "MUJER", "CANTIDAD");
        return dataset;
    }
        
    
    public static void main(String[] args) {
        FuncionArchivo obj = new FuncionArchivo();
        obj.Leer_Archivo("2020comas.csv");
       // obj.listar();
        //obj.estadisticaUni();
       
        
    }

}