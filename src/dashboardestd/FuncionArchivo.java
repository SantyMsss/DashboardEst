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
                    // System.out.println(fila + " - " + linea);
                    tokens = linea.split(",");
                    inst.add(new Institucion(
                            tokens[0], // Nombre
                            tokens[5], // Departamento
                            Integer.parseInt(tokens[1]), // Tipo
                            tokens[3], // Caracter
                            tokens[21], // Género
                            tokens[11], // Nivel Académico
                            tokens[23], // Semestre
                            Integer.parseInt(tokens[24])// Graduados
                            , tokens[9] // Programa Academico
                            , tokens[15] // Metodologia
                            , tokens[17] // Area de conocimiento
                            , tokens[7] // Municipio
                            , tokens[13] // Nivel de formacion
                            , tokens[22] // Año
                            , tokens[19] // Descampoesp

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
        } // if(!error)
    }

    // ----------------------- LISTAR -------------------------------
    public void listar() {
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);
            System.out.println((i + 1) + " " + obj.getMunicipio());
        }
    }

    public void estadisticaUni() {
        int nacional = 0, uceva = 0, univalle = 0, antioquia = 0;
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);
            switch (obj.nombre) {
                case "UNIVERSIDAD NACIONAL DE COLOMBIA":
                    nacional++;
                    break;
                case "UNIDAD CENTRAL DEL VALLE DEL CAUCA":
                    uceva++;
                    break;
                case "UNIVERSIDAD DEL VALLE":
                    univalle++;
                    break;
                case "UNIVERSIDAD DE ANTIOQUIA":
                    antioquia++;
                    break;
            }
        }
        System.out.println(nacional);
        System.out.println(uceva);
        System.out.println(univalle);
        System.out.println(antioquia);

    }

    // ----------------------------------DESARROLLO GRAFICAS
    // -----------------------------------------------------------------
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

    private DefaultCategoryDataset createGeneroDataset(int hombres, int mujeres) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(hombres, "HOMBRE", "GENERO");
        dataset.addValue(mujeres, "MUJER", "GENERO");
        return dataset;
    }

    public ChartPanel generarGraficoPregPosg() {
        
        int pregrado = 0, posgrado = 0;
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);

            switch (obj.nivacademico) {
                case "PREGRADO":
                case "1":
                    pregrado++;
                    break;
                case "POSGRADO":
                case "2":
                    posgrado++;
                    break;
            }
        }

        System.out.println("Pregrado: " + pregrado);
        System.out.println("Posgrado: " + posgrado);

        // Crear el dataset
        CategoryDataset dataset = createTipoUniDataset(pregrado, posgrado);

        // Crear el gráfico de líneas
        JFreeChart chart = ChartFactory.createLineChart(
                "GRÁFICO DE PREGRADO VS POSGRADO EN EL AÑO ELEGIDO",
                "Nivel Académico",
                "Cantidad",
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
        plot.getRenderer().setSeriesPaint(0, Color.RED);  // Línea de Pregrado
        plot.getRenderer().setSeriesPaint(1, Color.BLACK);  // Línea de Posgrado

        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(512, 512));

        return chartPanel;
    }

    private CategoryDataset createTipoUniDataset(int pregrado, int posgrado) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(pregrado, "Cantidad", "Pregrado");
        dataset.addValue(posgrado, "Cantidad", "Posgrado");

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
                case "Universidad":
                    InstTecProf++;
                    break;
                case "Institucion Tecnologica":
                    InstTecn++;
                    break;
                case "Institucion Universitaria/Escuela Tecnologica":
                    InstUniv++;
                    break;
                case "Institucion Tecnica Profesional":
                    Univ++;
                    break;
            }
        }

        System.out.println("Inst tecnica profesional: " + InstTecProf);
        System.out.println("Inst tecnica: " + InstTecn);
        System.out.println("Institucion Universitaria/Escuela Tecnologica: " + InstUniv);
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
        dataset.addValue(instTecProf, "Institucion Tecnica Profesional", "TIPO");
        dataset.addValue(instTecn, "Institucion Tecnica", "TIPO");
        dataset.addValue(instUniv, "Institucion Universitaria", "TIPO");
        dataset.addValue(univ, "Universidad", "TIPO");
        return dataset;
    }

    public ChartPanel generarGraficoxDepto() {

        int Amazonas = 0, Antioquia = 0, Arauca = 0, Atlantico = 0, Bogota = 0, Bolivar = 0, Boyaca = 0, Caldas = 0,
                Caqueta = 0, Casanare = 0, Cauca = 0, Cesar = 0, Choco = 0, Cordoba = 0, Cundinamarca = 0, Guainia = 0,
                Guaviare = 0, Huila = 0, LaGuajira = 0, Magdalena = 0, Meta = 0, Nariño = 0, NorteDeSantander = 0,
                Putumayo = 0, Quindio = 0, Risaralda = 0, SanAndresYProvidencia = 0, Santander = 0, Sucre = 0,
                Tolima = 0, ValleDelCauca = 0, Vaupes = 0, Vichada = 0;

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
                case "Atlantico":
                    Atlantico++;
                    break;
                case "BogotaD.C":
                    Bogota++;
                    break;
                case "Bolivar":
                    Bolivar++;
                    break;
                case "Boyacá":
                    Boyaca++;
                    break;
                case "Caldas":
                    Caldas++;
                    break;
                case "Caqueta":
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
                case "Choco":
                    Choco++;
                    break;
                case "Cordoba":
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
                case "San Andres y Providencia":
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
        System.out.println("BogotáD.C: " + Bogota);
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

        DefaultPieDataset dataset = createDataset(Amazonas, Antioquia, Arauca, Atlantico, Bogota, Bolivar, Boyaca,
                Caldas, Caqueta, Casanare,
                Cauca, Cesar, Choco, Cordoba, Cundinamarca, Guainia, Guaviare, Huila, LaGuajira, Magdalena, Meta,
                Nariño, NorteDeSantander,
                Putumayo, Quindio, Risaralda, SanAndresYProvidencia, Santander, Sucre, Tolima, ValleDelCauca, Vaupes,
                Vichada);

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
        String[] departamentos = { "Amazonas", "Antioquia", "Arauca", "Atlántico", "BogotáD.C", "Bolívar", "Boyacá",
                "Caldas", "Caquetá", "Casanare",
                "Cauca", "Cesar", "Chocó", "Córdoba", "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira",
                "Magdalena", "Meta", "Nariño",
                "Norte de Santander", "Putumayo", "Quindío", "Risaralda", "San Andrés y Providencia", "Santander",
                "Sucre", "Tolima", "Valle del Cauca",
                "Vaupés", "Vichada" };

        for (int i = 0; i < counts.length; i++) {
            dataset.setValue(departamentos[i], counts[i]);
        }

        return dataset;
    }

    public ChartPanel generarGrafGradxSemestre() {
        
        CategoryDataset dataset = createDataset();

        // Crear el gráfico de barras apiladas en 3D
        JFreeChart chart = ChartFactory.createStackedBarChart3D(
                "GRADUADOS POR SEMESTRE", // Título del gráfico
                "Semestre", // Etiqueta del eje x
                "Cantidad de Graduados", // Etiqueta del eje y
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);

        // Ajustes visuales del gráfico
        chart.setBackgroundPaint(new Color(120, 180, 255));
        Font titleFont = new Font("SansSerif", Font.BOLD, 18);
        chart.getTitle().setFont(titleFont);

        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(512, 512));

        return chartPanel;
    }

    private CategoryDataset createDataset() {
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
    
    
    public ChartPanel generarGraficoGeneral(String campoEspecifico, String campoMunicipio, String campoNivForm, String campoDepto, String campoUni, 
    String campoCaracter, String campoProgAcad, String campoAreaConoc,  boolean esPrivadaSeleccionada, boolean esOficialSeleccionada, boolean PregSelected, boolean PosgSelected,
    boolean PsemSelected, boolean SsemSelected, boolean metPres, boolean metDis, boolean HomSelected, boolean MujSelected, String campoGrad) {
        int countCampoEspecifico = 0, countMun = 0, countNivForm = 0, countDepto = 0, countUni = 0, countCaracter = 0, countProgAcad = 0, countAreaConoc = 0;
        int countTipoOfi = 0, countTipoPriv = 0;
        int countPosg = 0, countPreg = 0;
        int countPsem = 0, countSsem = 0;
        int countMetPres = 0, countMetDis = 0;
        int countHom = 0, countMuj = 0;
        int countGrad = 0;
    
    
        // Lógica para contar según el campo específico seleccionado
        for (int i = 0; i < inst.size(); i++) {
            Institucion obj = inst.get(i);
    
            
            if (obj.descampoesp.equals(campoEspecifico)) {
                countCampoEspecifico++;
               
                
            }
             if (obj.municipio.equals(campoMunicipio)) {
                countMun++;

            }

            if (obj.nivformacion.equals(campoNivForm)) {
                countNivForm++;

            }
            if (obj.depto.equals(campoDepto)) {
                countDepto++;

            }
            if (obj.nombre.equals(campoUni)) {
                countUni++;

            }
            if (obj.caracter.equals(campoCaracter)) {
                countCaracter++;

            }
            if (obj.progacademico.equals(campoProgAcad)) {
                countProgAcad++;

            }

            if(obj.areaconoc.equals(campoAreaConoc)){
                countAreaConoc++;
            }

            if (esOficialSeleccionada && obj.tipo == 1) {
                countTipoOfi++;
            } else if (esPrivadaSeleccionada && obj.tipo == 2) {
                countTipoPriv++;
            }

            if (PregSelected && obj.nivacademico.equals("PREGRADO")) {
                countPreg++;
            } else if (PosgSelected && obj.nivacademico.equals("POSGRADO")) {
                countPosg++;
            }

            if (PsemSelected && obj.semestre.equals("1")) {
                countPsem++;
            } else if (SsemSelected && obj.semestre.equals("2")) {
                countSsem++;
            }

            if (metPres && obj.metodología.equals("Presencial")) {
                countMetPres++;
            } else if (metDis && obj.metodología.equals("Distancia (tradicional)")) {
                countMetDis++;
            }

            if (HomSelected && obj.genero.equals("Hombre")) {
                countHom++;
            } else if (MujSelected && obj.genero.equals("Mujer")) {
                countMuj++;
            }
            
            if ("Si".equals(campoGrad)) {
                countGrad += obj.graduados;
            }



        }
    
        System.out.println("Campo Específico (" + campoEspecifico + "): " + countCampoEspecifico);
        System.out.println("Municipio (" + campoMunicipio + "): " + countMun);
        System.out.println("Nivel de Formación (" + campoNivForm + "): " + countNivForm);
        System.out.println("Departamento (" + campoDepto + "): " + countDepto);
        System.out.println("Universidad (" + campoUni + "): " + countUni);
        System.out.println("Caracter (" + campoCaracter + "): " + countCaracter);
        System.out.println("Programa Académico (" + campoProgAcad + "): " + countProgAcad);
        System.out.println("Area de Conocimiento (" + campoAreaConoc + "): " + countProgAcad);
        System.out.println("Tipo Oficial: " + countTipoOfi);
        System.out.println("Tipo Privada: " + countTipoPriv);
        System.out.println("Nivel Académico Pregrado: " + countPreg);
        System.out.println("Nivel Académico Posgrado: " + countPosg);
        System.out.println("Semestre 1: " + countPsem);
        System.out.println("Semestre 2: " + countSsem);
        System.out.println("Metodología Presencial: " + countMetPres);
        System.out.println("Metodología Distancia: " + countMetDis);
        System.out.println("Hombres: " + countHom);
        System.out.println("Mujeres: " + countMuj);
        System.out.println("Graduados: " + countGrad);

    
        DefaultPieDataset dataset = createCampoEspecificoDataset(countCampoEspecifico, countMun, countNivForm, countDepto, countUni, countCaracter, countProgAcad, countAreaConoc, 
        countTipoOfi, countTipoPriv, countPreg, countPosg, countPsem, countSsem, countMetPres, countMetDis, countHom, countMuj, countGrad);
    
        JFreeChart chart = ChartFactory.createPieChart(
                "GRÁFICO VARIABLE",
                dataset,
                true,
                true,
                false);
    
        // Ajustes visuales del gráfico
        chart.setBackgroundPaint(new Color(144, 238, 144));
        Font titleFont = new Font("SansSerif", Font.BOLD, 18);
        chart.getTitle().setFont(titleFont);
    
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
    
        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(512, 512));
    
        // Aquí podrías mostrar el chartPanel en tu interfaz o realizar cualquier otra acción necesaria
        // ...
    
        return chartPanel;
    }
    
    private DefaultPieDataset createCampoEspecificoDataset(int countCampoEspecifico, int countMun, int countNivForm, int countDepto, int countUni, int countCaracter, int countProgAcad, int countAreaConoc, int countTipoOfi, int countTipoPriv, 
    int countPreg, int countPosg, int countPsem, int countSsem, int countMetPres, int countMetDis, int countHom, int countMuj, int countGrad) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Campo Específico", countCampoEspecifico);
        dataset.setValue("Municipio", countMun);
        dataset.setValue("Nivel de Formación", countNivForm);
        dataset.setValue("Departamento", countDepto);
        dataset.setValue("Universidad", countUni);
        dataset.setValue("Caracter", countCaracter);
        dataset.setValue("Programa Académico", countProgAcad);
        dataset.setValue("Area de Conocimiento", countAreaConoc);
        dataset.setValue("Tipo Oficial", countTipoOfi);
        dataset.setValue("Tipo Privada", countTipoPriv);
        dataset.setValue("Nivel Académico Pregrado", countPreg);
        dataset.setValue("Nivel Académico Posgrado", countPosg);
        dataset.setValue("Semestre 1", countPsem);
        dataset.setValue("Semestre 2", countSsem);
        dataset.setValue("Metodología Presencial", countMetPres);
        dataset.setValue("Metodología Distancia", countMetDis);
        dataset.setValue("Hombres", countHom);
        dataset.setValue("Mujeres", countMuj);
        dataset.setValue("Graduados", countGrad);

        

    
        return dataset;
    }


    public static void main(String[] args) {
        FuncionArchivo obj = new FuncionArchivo();
        obj.Leer_Archivo("2020comas.csv");
        obj.listar();
        

    }
}
