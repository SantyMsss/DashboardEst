package dashboardestd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class DashboardEstD extends JFrame{
    

    JSplitPane jsplit;
    JButton jButtones;
    JPanel izq, panelBut, panelYear,panelUni, panel2,panel3,panel4,panelDep,panel6,panelMun,panelForm,panel9,der;
    JPanel panel_graf1, panel_graf2, panel_graf3, panel_graf4, panel_graf5, panel_graf6, panel_graf7, panel_graf8, panel_graf9, panel_graf10cal;// cambiar por ChartPanel
    JComboBox<String> jcpUni,jcpYear,jcP2,jcpDep,jcP5,jcpMun,jcpForm;
    JCheckBox jck1_P2, jck2_P2,jck1_P3,jck2_P3,jck3_P3,jck1_P4,jck2_P4;
    JLabel jlImagen1, jlImagen2;
    
    public DashboardEstD() {
        super("Ejemplo de JSplitPane");
        setSize(1200, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearGUI();
        setVisible(true);
    }
    
    private void crearGUI() {
        izq = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\ESTRUCTURA DE DATOS\\DashboardEstD\\src\\imagenes\\luna.jpg");
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        izq.setLayout(null);

        JComponent topTextArea = new JTextArea("PROGRAMADORES \n Santiago Martinez Serna.\n Laura Sofica Toro. \n Santiago Santacruz Cuellar\n\n GRAFICAS EGRESADOS COLOMBIA: Seleccione datos a consultar\n ");
        topTextArea.setOpaque(false);
        topTextArea.setForeground(Color.white);
        topTextArea.setFocusable(false);
        ((JTextArea) topTextArea).setLineWrap(true);
        ((JTextArea) topTextArea).setWrapStyleWord(true);
        topTextArea.setBounds(10, 0, 400, 100);
        izq.add(topTextArea);

        
        
        //----------------------- Area de graficas -----------------------------

        der = new JPanel();
        der.setLayout(null);
        der.setPreferredSize(new Dimension(2000, 2000)); // tamaño del jpanel der para mostrar las graficas       
        der.setBackground(Color.BLACK);

        // Resto del código (paneles de gráficos, etc.)
     
        
        panelYear = new JPanel();// jpanel para opciones de consulta
        panelYear.setLayout(null);
        panelYear.setBackground(Color.WHITE);
        panelYear.setBounds(10, 150, 120, 50);// coord con respecto al panel izq
        panelYear.setBorder(new TitledBorder("Año"));
        jcpYear = new JComboBox<>();
        jcpYear.addItem("2022");
        jcpYear.addItem("2021");
        jcpYear.addItem("2020");
        jcpYear.setBounds(15, 17, 100, 25);//coord con respecto al panel panelUni
        panelYear.add(jcpYear);        
        izq.add(panelYear);
        
        jcpYear.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        eventojcpYear(); // Llamar al método correspondiente cuando se seleccione un año
    }
});
        
        panelDep= new JPanel();// jpanel para opciones de consulta
        panelDep.setLayout(null);
        panelDep.setBackground(Color.WHITE);
        panelDep.setBounds(140, 150, 130, 50);// coord con respecto al panel izq
        panelDep.setBorder(new TitledBorder("Departamento"));
        jcpDep = new JComboBox<>();
        jcpDep.addItem("Bogota D.C");
        jcpDep.addItem("Amazonas");
        jcpDep.addItem("Antioquia");
        jcpDep.addItem("Atlantico");
        jcpDep.addItem("Boyaca");
       
        // Falta por agregar deptartamentos 
        jcpDep.addItem("ETC...");
        jcpDep.setBounds(15, 17, 100, 25);//coord con respecto al panel panelUni
        panelDep.add(jcpDep);        
        izq.add(panelDep);
        
        panelMun= new JPanel();// jpanel para opciones de consulta
        panelMun.setLayout(null);
        panelMun.setBackground(Color.WHITE);
        panelMun.setBounds(280, 150, 130, 50);// coord con respecto al panel izq
        panelMun.setBorder(new TitledBorder("Municipio"));
        jcpMun = new JComboBox<>();
        jcpMun.addItem("Cali");
        jcpMun.addItem("Armenia");
        jcpMun.addItem("Neiva");
        jcpMun.addItem("Palmira");
        jcpMun.addItem("Bello");
       
        // Falta por agregar municipios
        jcpMun.addItem("ETC...");
        jcpMun.setBounds(15, 17, 100, 25);//coord con respecto al panel panelUni
        panelMun.add(jcpMun);        
        izq.add(panelMun);
        
        
        
        panelUni = new JPanel();// jpanel para opciones de consulta
        panelUni.setLayout(null);
        panelUni.setBackground(Color.WHITE);
        panelUni.setBounds(10, 210, 260, 50);// coord con respecto al panel izq
        panelUni.setBorder(new TitledBorder("IES"));
        jcpUni = new JComboBox<>();
        jcpUni.addItem("Unidad Central Del Valle Del Cauca");
        jcpUni.addItem("Universidad Catoica");
        jcpUni.addItem("Escuela De Logistica");
        jcpUni.setBounds(15, 17, 240, 25);//coord con respecto al panel panelUni
        panelUni.add(jcpUni);        
        izq.add(panelUni);
        
        panelForm = new JPanel();// jpanel para opciones de consulta
        panelForm.setLayout(null);
        panelForm.setBackground(Color.WHITE);
        panelForm.setBounds(280, 210, 260, 50);// coord con respecto al panel izq
        panelForm.setBorder(new TitledBorder("Caracter"));
        jcpForm = new JComboBox<>();
        jcpForm.addItem("Inst tecnica profesional");
        jcpForm.addItem("Inst tecnica"); 
        jcpForm.addItem("Institucion Universitaria");
          jcpForm.addItem("Universidad");
        jcpForm.setBounds(15, 17, 240, 25);//coord con respecto al panel panelUni
        panelForm.add(jcpForm);        
        izq.add(panelForm);
        
        //-------------------------inicio checkbox------------------------------------
        
        panel4 = new JPanel();// jpanel para opciones de consulta
        panel4.setLayout(null);
        panel4.setBackground(Color.WHITE);
        panel4.setBounds(280, 270, 260, 50);// coord con respecto al panel izq
        panel4.setBorder(new TitledBorder("Sector IES"));
        jck1_P3 = new JCheckBox("PRIVADA");
        jck1_P3.setBounds(15, 17, 100, 25);//coord con respecto al panel2
        jck2_P3 = new JCheckBox("OFICIAL");
        jck2_P3.setBounds(120, 17, 100, 25);//coord con respecto al panel2
        panel4.add(jck1_P3);
        panel4.add(jck2_P3);
        izq.add(panel4);
        jcpYear.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        eventojcpYear(); // Llamar al método correspondiente cuando se seleccione un año
    }
});
        panel3 = new JPanel();// jpanel para opciones de consulta
        panel3.setLayout(null);
        panel3.setBackground(Color.WHITE);
        panel3.setBounds(10, 330, 260, 50);// coord con respecto al panel izq
        panel3.setBorder(new TitledBorder("Nivel Academico"));
        jck1_P3 = new JCheckBox("Pregrado");
        jck1_P3.setBounds(15, 17, 100, 25);//coord con respecto al panel2
        jck3_P3 = new JCheckBox("Posgrado");
        jck3_P3.setBounds(120, 17, 100, 25);//coord con respecto al panel2
        panel3.add(jck1_P3);
        panel3.add(jck3_P3);
        izq.add(panel3);
        
        panel9 = new JPanel();// jpanel para opciones de consulta
        panel9.setLayout(null);
        panel9.setBackground(Color.WHITE);
        panel9.setBounds(280, 330, 260, 50);// coord con respecto al panel izq
        panel9.setBorder(new TitledBorder("P O S"));
        jck1_P4 = new JCheckBox("Principal");
        jck1_P4.setBounds(15, 17, 100, 25);//coord con respecto al panel2
        jck2_P4 = new JCheckBox("Seleccional");
        jck2_P4.setBounds(120, 17, 100, 25);//coord con respecto al panel2
        panel9.add(jck1_P4);
        panel9.add(jck2_P4);
        izq.add(panel9);
        
        panel2 = new JPanel();// jpanel para opciones de consulta
        panel2.setLayout(null);
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(10, 270, 260, 50);// coord con respecto al panel izq
        panel2.setBorder(new TitledBorder("Sexo"));
        jck1_P2 = new JCheckBox("Hombre");
        jck1_P2.setBounds(15, 17, 100, 25);//coord con respecto al panel2
        jck2_P2 = new JCheckBox("Mujer");
        jck2_P2.setBounds(120, 17, 100, 25);//coord con respecto al panel2
        panel2.add(jck1_P2);
        panel2.add(jck2_P2);
        izq.add(panel2);
        
        
        
        //-----------------------Creación de JButtons-----------------------------
        
        /*
        // BOTON GRAF HOMXMUJ
        panelBut = new JPanel();
        panelBut.setLayout(null);
        panelBut.setBackground(Color.WHITE);
        panelBut.setBounds(10, 270, 260, 50);
        panelBut.setBorder(new TitledBorder("Grafico"));
        jButtones = new JButton("Hombres vs Mujeres");
        jButtones.setBounds(15, 17, 240, 25);
        panelBut.add(jButtones);
        izq.add(panelBut);  // Cambiar panelForm por panelBut
                    jButtones.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eventoHombresxMujeres();
                }
            });
                  
           // BOTON GRAF PREGVSPOSG         
           panelBut = new JPanel();
            panelBut.setLayout(null);
            panelBut.setBackground(Color.WHITE);
            panelBut.setBounds(10, 330, 260, 50);
            panelBut.setBorder(new TitledBorder("Grafico"));
            jButtones = new JButton("Pregrado vs Posgrado");
            jButtones.setBounds(15, 17, 240, 25);
            panelBut.add(jButtones);
            izq.add(panelBut);  // Cambiar panelForm por panelBut
                        jButtones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eventoPregxPosg();
                    }
                });
               
                // BOTON GRAF OFICVSPRIV          
           panelBut = new JPanel();
            panelBut.setLayout(null);
            panelBut.setBackground(Color.WHITE);
            panelBut.setBounds(10, 390, 260, 50);
            panelBut.setBorder(new TitledBorder("Grafico"));
            jButtones = new JButton("Oficial vs Privada");
            jButtones.setBounds(15, 17, 240, 25);
            panelBut.add(jButtones);
            izq.add(panelBut);  // Cambiar panelForm por panelBut
                        jButtones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eventoOficxPriv();
                    }
                });          
                        
             // BOTON xCARACTER         
           panelBut = new JPanel();
            panelBut.setLayout(null);
            panelBut.setBackground(Color.WHITE);
            panelBut.setBounds(10, 450, 260, 50);
            panelBut.setBorder(new TitledBorder("Grafico"));
            jButtones = new JButton("Caracter Instituciones");
            jButtones.setBounds(15, 17, 240, 25);
            panelBut.add(jButtones);
            izq.add(panelBut);  // Cambiar panelForm por panelBut
                        jButtones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eventoxCaracter();
                    }
                }); 
              
             panelBut = new JPanel();
            panelBut.setLayout(null);
            panelBut.setBackground(Color.WHITE);
            panelBut.setBounds(10, 510, 260, 50);
            panelBut.setBorder(new TitledBorder("Grafico"));
            jButtones = new JButton("Por Departamentos");
            jButtones.setBounds(15, 17, 240, 25);
            panelBut.add(jButtones);
            izq.add(panelBut);  // Cambiar panelForm por panelBut
                        jButtones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eventoxDepto();
                    }
                });     
        */
                        
                       
                       

        
        
        //-----------------------------------------------DESARROLLO GRAFICAS--------------------------------------------------------------
      
        der = new JPanel();
        der.setLayout(null);
        der.setPreferredSize(new Dimension(2000, 2000));//tamaño del jpanel der para mostrar las graficas       
        der.setBackground(Color.BLACK);
        
        panel_graf1 = new JPanel();// esto seria el ChartPanel de la grafica 1
        panel_graf1.setLayout(null);
        panel_graf1.setBackground(Color.WHITE);        
        panel_graf1.setBounds(10, 10, 512, 512);        
        der.add(panel_graf1);
        
        panel_graf2 = new JPanel();// esto seria el ChartPanel de la grafica 2
        panel_graf2.setLayout(null);
        panel_graf2.setBackground(Color.LIGHT_GRAY);        
        panel_graf2.setBounds(532, 10, 512, 512);
        der.add(panel_graf2);
        
        panel_graf3 = new JPanel();// esto seria el ChartPanel de la grafica 3
        panel_graf3.setLayout(null);
        panel_graf3.setBackground(Color.CYAN);        
        panel_graf3.setBounds(10, 532, 512, 512);
        der.add(panel_graf3);
        
        panel_graf4 = new JPanel();// esto seria el ChartPanel de la grafica 4
        panel_graf4.setLayout(null);
        panel_graf4.setBackground(Color.YELLOW);        
        panel_graf4.setBounds(532, 532, 512, 512);
        der.add(panel_graf4);
        
        panel_graf5 = new JPanel();// esto seria el ChartPanel de la grafica 4
        panel_graf5.setLayout(null);
        panel_graf5.setBackground(Color.RED);        
        panel_graf5.setBounds(10, 1064, 512, 512);
        der.add(panel_graf5);
        
        /*
        .....
        anadir tantos ChartPanel como graficas a mostrar
        .....
        */
        
        JScrollPane js = new JScrollPane(der);

        jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, izq, js);
        jsplit.setOneTouchExpandable(true);
        jsplit.setDividerLocation(550);

        add(jsplit);

        // Agrega listeners a los JComboBox o JCheckBox según sea necesario
        
        
    }
    
    
    public void eventojcpYear() {
    FuncionArchivo funcionArchivo = new FuncionArchivo();

    String selectedYear = (String) jcpYear.getSelectedItem();
    switch (selectedYear) {
        case "2020":
            funcionArchivo.Leer_Archivo("2020comas.csv");
            break;
        case "2021":
            funcionArchivo.Leer_Archivo("2021comas.csv");
            break;
        case "2022":
            funcionArchivo.Leer_Archivo("2022comas.csv");
            break;
        default:
            throw new AssertionError();
    }

    // Llamar a los métodos que generan los gráficos
    generarTodosLosGraficos(funcionArchivo);
}

// Nuevo método para generar todos los gráficos
private void generarTodosLosGraficos(FuncionArchivo funcionArchivo) {
    eventoHombresxMujeres(funcionArchivo);
    eventoPregxPosg(funcionArchivo);
    eventoOficxPriv(funcionArchivo);
    eventoxCaracter(funcionArchivo);
    eventoxDepto(funcionArchivo);
}

// Métodos de generación de gráficos modificados para aceptar FuncionArchivo como parámetro
public void eventoHombresxMujeres(FuncionArchivo funcionArchivo) {
    ChartPanel chartPanel = funcionArchivo.generarGraficoHombresMujeres();
    actualizarPanelGrafico(panel_graf5, chartPanel);
}

public void eventoPregxPosg(FuncionArchivo funcionArchivo) {
    ChartPanel chartPanel = funcionArchivo.generarGraficoPregPosg();
    actualizarPanelGrafico(panel_graf2, chartPanel);
}

public void eventoOficxPriv(FuncionArchivo funcionArchivo) {
    ChartPanel chartPanel = funcionArchivo.generarGraficoOficxPriv();
    actualizarPanelGrafico(panel_graf3, chartPanel);
}

public void eventoxCaracter(FuncionArchivo funcionArchivo) {
    ChartPanel chartPanel = funcionArchivo.generarGraficoxCaracter();
    actualizarPanelGrafico(panel_graf4, chartPanel);
}

public void eventoxDepto(FuncionArchivo funcionArchivo) {
    ChartPanel chartPanel = funcionArchivo.generarGraficoxDepto();
    actualizarPanelGrafico(panel_graf1, chartPanel);
}

// Nuevo método para actualizar el panel de gráfico
private void actualizarPanelGrafico(JPanel panelGrafico, ChartPanel chartPanel) {
    panelGrafico.removeAll();
    panelGrafico.setLayout(new BorderLayout());
    panelGrafico.add(chartPanel, BorderLayout.CENTER);
    panelGrafico.revalidate();
    panelGrafico.repaint();
}

    
    
    public void eventojcpUni() 
    {
        
        
    }
    
    


     public void eventoHombresxMujeres() {
    FuncionArchivo funcionArchivo = new FuncionArchivo();
    
      String selectedYear = (String) jcpYear.getSelectedItem();
        switch (selectedYear) {
            case "2020": funcionArchivo.Leer_Archivo("2020comas.csv"); 
                break;
             case "2021": funcionArchivo.Leer_Archivo("2021comas.csv"); 
                break;
             case "2022": funcionArchivo.Leer_Archivo("2022comas.csv"); 
                break;
            default:
                throw new AssertionError();
        }
    
    ChartPanel chartPanel = funcionArchivo.generarGraficoHombresMujeres();

    // Limpiar el panel y agregar el nuevo gráfico
    panel_graf5.removeAll();
    panel_graf5.setLayout(new BorderLayout()); // Usar un BorderLayout
    panel_graf5.add(chartPanel, BorderLayout.CENTER);
    panel_graf5.revalidate();
    panel_graf5.repaint();
}
     
     public void eventoPregxPosg() {
    FuncionArchivo funcionArchivo = new FuncionArchivo();
    
      String selectedYear = (String) jcpYear.getSelectedItem();
        switch (selectedYear) {
            case "2020": funcionArchivo.Leer_Archivo("2020comas.csv"); 
                break;
             case "2021": funcionArchivo.Leer_Archivo("2021comas.csv"); 
                break;
             case "2022": funcionArchivo.Leer_Archivo("2022comas.csv"); 
                break;
            default:
                throw new AssertionError();
        }
    
    ChartPanel chartPanel = funcionArchivo.generarGraficoPregPosg();

    // Limpiar el panel y agregar el nuevo gráfico
    panel_graf2.removeAll();
    panel_graf2.setLayout(new BorderLayout()); // Usar un BorderLayout
    panel_graf2.add(chartPanel, BorderLayout.CENTER);
    panel_graf2.revalidate();
    panel_graf2.repaint();
}
     
      public void eventoOficxPriv() {
    FuncionArchivo funcionArchivo = new FuncionArchivo();
    
      String selectedYear = (String) jcpYear.getSelectedItem();
        switch (selectedYear) {
            case "2020": funcionArchivo.Leer_Archivo("2020comas.csv"); 
                break;
             case "2021": funcionArchivo.Leer_Archivo("2021comas.csv"); 
                break;
             case "2022": funcionArchivo.Leer_Archivo("2022comas.csv"); 
                break;
            default:
                throw new AssertionError();
        }
    
    ChartPanel chartPanel = funcionArchivo.generarGraficoOficxPriv();

    // Limpiar el panel y agregar el nuevo gráfico
    panel_graf3.removeAll();
    panel_graf3.setLayout(new BorderLayout()); // Usar un BorderLayout
    panel_graf3.add(chartPanel, BorderLayout.CENTER);
    panel_graf3.revalidate();
    panel_graf3.repaint();
}
      
      
      public void eventoxCaracter() {
    FuncionArchivo funcionArchivo = new FuncionArchivo();
    
      String selectedYear = (String) jcpYear.getSelectedItem();
        switch (selectedYear) {
            case "2020": funcionArchivo.Leer_Archivo("2020comas.csv"); 
                break;
             case "2021": funcionArchivo.Leer_Archivo("2021comas.csv"); 
                break;
             case "2022": funcionArchivo.Leer_Archivo("2022comas.csv"); 
                break;
            default:
                throw new AssertionError();
        }
    
    ChartPanel chartPanel = funcionArchivo.generarGraficoxCaracter();

    // Limpiar el panel y agregar el nuevo gráfico
    panel_graf4.removeAll();
    panel_graf4.setLayout(new BorderLayout()); // Usar un BorderLayout
    panel_graf4.add(chartPanel, BorderLayout.CENTER);
    panel_graf4.revalidate();
    panel_graf4.repaint();
}
      
       public void eventoxDepto() {
    FuncionArchivo funcionArchivo = new FuncionArchivo();
    
      String selectedYear = (String) jcpYear.getSelectedItem();
        switch (selectedYear) {
            case "2020": funcionArchivo.Leer_Archivo("2020comas.csv"); 
                break;
             case "2021": funcionArchivo.Leer_Archivo("2021comas.csv"); 
                break;
             case "2022": funcionArchivo.Leer_Archivo("2022comas.csv"); 
                break;
            default:
                throw new AssertionError();
        }
    
    ChartPanel chartPanel = funcionArchivo.generarGraficoxDepto();

    // Limpiar el panel y agregar el nuevo gráfico
    panel_graf1.removeAll();
    panel_graf1.setLayout(new BorderLayout()); // Usar un BorderLayout
    panel_graf1.add(chartPanel, BorderLayout.CENTER);
    panel_graf1.revalidate();
    panel_graf1.repaint();
}

    
    public static void main(String[] args) {
         DashboardEstD v = new DashboardEstD ();
    }
}