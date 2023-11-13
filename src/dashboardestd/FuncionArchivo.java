package dashboardestd;

/*
INDICE DE LOS DATOS: 
universidad;id sector ies; id caracter; caracter; código del departamento (ies); departamento de domicilio de la ies;código del municipio (ies);municipio de domicilio de la ies; código snies del programa; programa académico; id nivel académico;nivel académico;id nivel de formación;nivel de formación; id metodología;metodología;id área;área de conocimiento;id cine campo especifico;desc cine campo especifico;id sexo;sexo;año;semestre;graduados     
UNIVERSIDAD NACIONAL DE COLOMBIA,1,4,Universidad,11,BogotáD.C.,11001,BogotáD.C,1,INGENIERIA AGRONOMICA,1,PREGRADO,6,Universitaria,1,Presencial,8,Ingeniería arquitectura urbanismo y afines,81,Agropecuario,1,Hombre,2020,1,29

Token 0: UNIVERSIDAD NACIONAL DE COLOMBIA
Token 1: 1
Token 2: 4
Token 3: Universidad
Token 4: 11
Token 5: Bogot�D.C.
Token 6: 11001
Token 7: Bogot�D.C
Token 8: 1
Token 9: INGENIERIA AGRONOMICA
Token 10: 1
Token 11: PREGRADO
Token 12: 6
Token 13: Universitaria
Token 14: 1
Token 15: Presencial
Token 16: 8
Token 17: Ingenier�a arquitectura urbanismo y afines
Token 18: 81
Token 19: Agropecuario
Token 20: 1
Token 21: Hombre
Token 22: 2020
Token 23: 1
Token 24: 29

*/
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class FuncionArchivo {
    


    ArrayList<Institucion> inst = new ArrayList<>();
    private Map<String, Integer> datosAcumulativos;
    private List<Institucion> InstitucionList;


    public FuncionArchivo() {
        // Inicializar datos acumulativos
        datosAcumulativos = new HashMap<>();
    }

    public void cargarDatos(List<Institucion> datos) {
        this.InstitucionList = datos;
    }


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
                    inst.add(new Institucion(
                            tokens[0], // Nombre
                            tokens[5], // Departamento
                            Integer.parseInt(tokens[1]), // Tipo
                            Integer.parseInt(tokens[2]), // Caracter
                            tokens[21], // Género
                            tokens[11], // Nivel Académico
                            tokens[23], // Semestre
                            Integer.parseInt(tokens[24])// Graduados
                            ,tokens[9] // Programa Academico
                            ,tokens[15] // Metodologia
                            ,tokens[17] // Area de conocimiento
                            ,tokens[7] // Municipio
                            ,tokens[13] // Nivel de formacion
                            
                    ));
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
    
    
    // ----------------------- LISTAR -------------------------------
    public void listar(){
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);
            System.out.println((i+1) + " " + obj.getGraduados());
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
    
    //----------------------------------DESARROLLO GRAFICAS -----------------------------------------------------------------
     public ChartPanel generarGraficoHombresMujeres() {
        int hom = 0, mujer = 0;

        // Lógica para contar hombres y mujeres 
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);

            switch (obj.genero) {
                case "Hombre":
                    hom++;
                    break;
                case "Mujer":
                    mujer++;
                    break;
            }
        }

        System.out.println("Hombres: " + hom);
        System.out.println("Mujeres: " + mujer);

        DefaultCategoryDataset dataset = createGeneroDataset(hom, mujer);

        JFreeChart chart = ChartFactory.createBarChart(
                "GRÁFICO DE HOMBRES VS MUJERES EN EL AÑO ELEGIDO",
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
        dataset.addValue(hombres, "HOMBRE", "GENERO");
        dataset.addValue(mujeres, "MUJER", "GENERO");
        return dataset;
    }
    

       public ChartPanel generarGraficoPregPosg() {
            int preg = 0, posg = 0;

            // Lógica para contar hombres y mujeres
            for (int i = 0; i < inst.size(); i++) {
                Institucion obj = inst.get(i);

                switch (obj.nivacademico) {
                    case "PREGRADO":
                    case "1":
                        preg++;
                        break;
                    case "POSGRADO":
                    case "2":
                        posg++;
                        break;
                }
            }

            System.out.println("Pregrado: " + preg);
            System.out.println("Posgrado: " + posg);

            DefaultPieDataset dataset = createTipoUniDataset(preg, posg);

            JFreeChart chart = ChartFactory.createPieChart(
                    "GRÁFICO DE PREGRADO VS POSGRADO EN EL AÑO ELEGIDO",
                    dataset,
                    true,
                    true,
                    false);

            // Ajustes visuales del gráfico
            chart.setBackgroundPaint(new Color(120, 180, 255));
            Font titleFont = new Font("SansSerif", Font.BOLD, 18);
            chart.getTitle().setFont(titleFont);


            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
             plot.setSectionPaint("Pregrado", Color.WHITE);
            plot.setSectionPaint("Posgrado", Color.BLACK);

            // Crear el panel del gráfico
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(512, 512));

            return chartPanel;
        }

        private DefaultPieDataset createTipoUniDataset(int pregrado, int posgrado) {
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Pregrado", pregrado);
            dataset.setValue("Posgrado", posgrado);

            return dataset;
        }
        
        



        public ChartPanel generarGraficoOficxPriv() {
            int Ofic = 0, Priv = 0;

            // Lógica para contar oficiales y privadas
            for (int i = 0; i < inst.size(); i++) {
                Institucion obj = inst.get(i);

                switch (obj.tipo) {
                    case 1:
                        Ofic++;
                        break;
                    case 2:
                        Priv++;
                        break;
                }
            }

            System.out.println("Oficial: " + Ofic);
            System.out.println("Privada: " + Priv);

            DefaultPieDataset dataset = createTipoOficxPriv(Ofic, Priv);

            JFreeChart chart = ChartFactory.createRingChart(
                    "GRÁFICO DE OFICIALES VS PRIVADAS EN EL AÑO ELEGIDO",
                    dataset,
                    true,
                    true,
                    false);

            // Ajustes visuales del gráfico
            chart.setBackgroundPaint(new Color(90, 180, 255));
            Font titleFont = new Font("SansSerif", Font.BOLD, 18);
            chart.getTitle().setFont(titleFont);

            RingPlot plot = (RingPlot) chart.getPlot();
            plot.setSectionPaint("Oficial", Color.BLACK);
            plot.setSectionPaint("Privada", Color.RED);

            // Crear el panel del gráfico
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(512, 512));

            return chartPanel;
        }

            private DefaultPieDataset createTipoOficxPriv(int oficial, int privada) {
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Oficial", oficial);
            dataset.setValue("Privada", privada);

            return dataset;
        }
            
            
        public ChartPanel generarGraficoxCaracter() {
        int Univ = 0, InstUniv = 0, InstTecn = 0, InstTecProf = 0;

        // Lógica para contar características
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);

            switch (obj.caracter) {
                case 1:
                    InstTecProf++;
                    break;
                case 2:
                    InstTecn++;
                    break;
                case 3:
                    InstUniv++;
                    break;
                case 4:
                    Univ++;
                    break;
            }
        }

        System.out.println("Inst tecnica profesional: " + InstTecProf);
        System.out.println("Inst tecnica: " + InstTecn);
        System.out.println("Institucion Universitaria: " + InstUniv);
        System.out.println("Universidad: " + Univ);

        DefaultCategoryDataset dataset = createDataset(InstTecProf, InstTecn, InstUniv, Univ);

        JFreeChart chart = ChartFactory.createBarChart(
                "GRÁFICO DE CARACTERÍSTICAS DE INSTITUCIONES",
                "TIPO",
                "CANTIDAD",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        // Ajustes visuales del gráfico
        chart.setBackgroundPaint(new Color(120, 180, 255));
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

    private DefaultCategoryDataset createDataset(int instTecProf, int instTecn, int instUniv, int univ) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(instTecProf, "Institución Técnica Profesional", "TIPO");
        dataset.addValue(instTecn, "Institución Técnica", "TIPO");
        dataset.addValue(instUniv, "Institución Universitaria", "TIPO");
        dataset.addValue(univ, "Universidad", "TIPO");
        return dataset;
    }
    
    public ChartPanel generarGraficoxDepto() {
      
      int Amazonas = 0, Antioquia = 0, Arauca = 0, Atlantico = 0, Bogota = 0, Bolivar = 0, Boyaca = 0, Caldas = 0, Caqueta = 0, Casanare = 0, Cauca = 0, Cesar = 0, Choco = 0, Cordoba = 0, Cundinamarca = 0, Guainia = 0, Guaviare = 0, Huila = 0, LaGuajira = 0, Magdalena = 0, Meta = 0, Nariño = 0, NorteDeSantander = 0, Putumayo = 0, Quindio = 0, Risaralda = 0, SanAndresYProvidencia = 0, Santander = 0, Sucre = 0, Tolima = 0, ValleDelCauca = 0, Vaupes = 0, Vichada = 0;

        // Lógica para contar características
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);

            switch (obj.depto) {
                case "Amazonas":
                    Amazonas++;
                    break;
                case "Antioquia":
                    Antioquia++;
                    break;
                case "Arauca":
                    Arauca++;
                    break;
                case "Atlántico":
                    Atlantico++;
                    break;
                case "Bogotá D.C.":
                    Bogota++;
                    break;
                case "Bolívar":
                    Bolivar++;
                    break;
                case "Boyacá":
                    Boyaca++;
                    break;
                case "Caldas":
                    Caldas++;
                    break;
                case "Caquetá":
                    Caqueta++;
                    break;
                case "Casanare":
                    Casanare++;
                    break;
                case "Cauca":
                    Cauca++;
                    break;
                case "Cesar":
                    Cesar++;
                    break;
                case "Chocó":
                    Choco++;
                    break;
                case "Córdoba":
                    Cordoba++;
                    break;
                case "Cundinamarca":
                    Cundinamarca++;
                    break;
                case "Guainía":
                    Guainia++;
                    break;
                case "Guaviare":
                    Guaviare++;
                    break;
                case "Huila":
                    Huila++;
                    break;
                case "La Guajira":
                    LaGuajira++;
                    break;
                case "Magdalena":
                    Magdalena++;
                    break;
                case "Meta":
                    Meta++;
                    break;
                case "Nariño":
                    Nariño++;
                    break;
                case "Norte de Santander":
                    NorteDeSantander++;
                    break;
                case "Putumayo":
                    Putumayo++;
                    break;
                case "Quindío":
                    Quindio++;
                    break;
                case "Risaralda":
                    Risaralda++;
                    break;
                case "San Andrés y Providencia":
                    SanAndresYProvidencia++;
                    break;
                case "Santander":
                    Santander++;
                    break;
                case "Sucre":
                    Sucre++;
                    break;
                case "Tolima":
                    Tolima++;
                    break;
                case "Valle del Cauca":
                    ValleDelCauca++;
                    break;
                case "Vaupés":
                    Vaupes++;
                    break;
                case "Vichada":
                    Vichada++;
                    break;
            }
        }

        // Imprimir resultados
        System.out.println("Amazonas: " + Amazonas);
        System.out.println("Antioquia: " + Antioquia);
        System.out.println("Arauca: " + Arauca);
        System.out.println("Atlántico: " + Atlantico);
        System.out.println("Bogotá D.C.: " + Bogota);
        System.out.println("Bolívar: " + Bolivar);
        System.out.println("Boyacá: " + Boyaca);
        System.out.println("Caldas: " + Caldas);
        System.out.println("Caquetá: " + Caqueta);
        System.out.println("Casanare: " + Casanare);
        System.out.println("Cauca: " + Cauca);
        System.out.println("Cesar: " + Cesar);
        System.out.println("Chocó: " + Choco);
        System.out.println("Córdoba: " + Cordoba);
        System.out.println("Cundinamarca: " + Cundinamarca);
        System.out.println("Guainía: " + Guainia);
        System.out.println("Guaviare: " + Guaviare);
        System.out.println("Huila: " + Huila);
        System.out.println("La Guajira: " + LaGuajira);
        System.out.println("Magdalena: " + Magdalena);
        System.out.println("Meta: " + Meta);
        System.out.println("Nariño: " + Nariño);
        System.out.println("Norte de Santander: " + NorteDeSantander);
        System.out.println("Putumayo: " + Putumayo);
        System.out.println("Quindío: " + Quindio);
        System.out.println("Risaralda: " + Risaralda);
        System.out.println("San Andrés y Providencia: " + SanAndresYProvidencia);
        System.out.println("Santander: " + Santander);
        System.out.println("Sucre: " + Sucre);
        System.out.println("Tolima: " + Tolima);
        System.out.println("Valle del Cauca: " + ValleDelCauca);
        System.out.println("Vaupés: " + Vaupes);
        System.out.println("Vichada: " + Vichada);

        DefaultPieDataset dataset = createDataset(Amazonas, Antioquia, Arauca, Atlantico, Bogota, Bolivar, Boyaca, Caldas, Caqueta, Casanare,
                Cauca, Cesar, Choco, Cordoba, Cundinamarca, Guainia, Guaviare, Huila, LaGuajira, Magdalena, Meta, Nariño, NorteDeSantander,
                Putumayo, Quindio, Risaralda, SanAndresYProvidencia, Santander, Sucre, Tolima, ValleDelCauca, Vaupes, Vichada);

        JFreeChart chart = ChartFactory.createRingChart(
                "GRÁFICO DE DEPARTAMENTOS",
                dataset,
                true,
                true,
                false);

        // Ajustes visuales del gráfico
        chart.setBackgroundPaint(new Color(120, 180, 255));
        Font titleFont = new Font("SansSerif", Font.BOLD, 18);
        chart.getTitle().setFont(titleFont);

        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));

        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(512, 512));

        return chartPanel;
    }

    private DefaultPieDataset createDataset(int... counts) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        String[] departamentos = {"Amazonas", "Antioquia", "Arauca", "Atlántico", "Bogotá D.C.", "Bolívar", "Boyacá", "Caldas", "Caquetá", "Casanare",
                "Cauca", "Cesar", "Chocó", "Córdoba", "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño",
                "Norte de Santander", "Putumayo", "Quindío", "Risaralda", "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca",
                "Vaupés", "Vichada"};

        for (int i = 0; i < counts.length; i++) {
            dataset.setValue(departamentos[i], counts[i]);
        }

        return dataset;
    }


    public ChartPanel generarGrafGradxSemestre() {
        DefaultCategoryDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Graduados por Semestre", // Título del gráfico
                "Semestre", // Etiqueta del eje X
                "Cantidad de Graduados", // Etiqueta del eje Y
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Ajustes visuales del gráfico
        chart.setBackgroundPaint(new Color(120, 180, 255));
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

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            int semestre1 = 0;
            int semestre2 = 0;

            for (Institucion obj : inst) {
                if ("1".equals(obj.getSemestre())) {
                    semestre1 += obj.getGraduados();
                } else if ("2".equals(obj.getSemestre())) {
                    semestre2 += obj.getGraduados();
                }
            }

            dataset.addValue(semestre1, "Cantidad de Graduados", "Semestre 1");
            dataset.addValue(semestre2, "Cantidad de Graduados", "Semestre 2");
        } catch (Exception e) {
            e.printStackTrace(); // Maneja adecuadamente las excepciones según tus necesidades
        }

        return dataset;
    }


    private void eventoGenerarGraficoCombinado() {
        
         

    }

    
    public static void main(String[] args) {
        FuncionArchivo obj = new FuncionArchivo();
        obj.Leer_Archivo("2022comas.csv");
        
     
        
       
        
    }
}
