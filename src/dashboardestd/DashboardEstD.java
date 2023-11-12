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
    JButton jbHombrexMujeres;
    JPanel izq, panelBut1, panelYear,panelUni, panel2,panel3,panel4,panelDep,panel6,panelMun,panelForm,panel9,der;
    JPanel panel_graf1, panel_graf2, panel_graf3, panel_graf4;// cambiar por ChartPanel
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
        panelForm.setBorder(new TitledBorder("Nivel de Formacion"));
        jcpForm = new JComboBox<>();
        jcpForm.addItem("Universitaria");
        jcpForm.addItem("Doctorado"); 
        jcpForm.addItem("Especializacion Tecnico Profesional");
        jcpForm.setBounds(15, 17, 240, 25);//coord con respecto al panel panelUni
        panelForm.add(jcpForm);        
        izq.add(panelForm);
        
        //Creación de JButton
        //Creación de JButton
        panelBut1 = new JPanel();
        panelBut1.setLayout(null);
        panelBut1.setBackground(Color.WHITE);
        panelBut1.setBounds(10, 270, 260, 50);
        panelBut1.setBorder(new TitledBorder("Graduados"));
        jbHombrexMujeres = new JButton("Hombres x Mujeres");
        jbHombrexMujeres.setBounds(15, 17, 240, 25);
        panelBut1.add(jbHombrexMujeres);
        izq.add(panelBut1);  // Cambiar panelForm por panelBut1
                    jbHombrexMujeres.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eventoHombresxMujeres();
                }
            });

        
        
        //-----------------------------------------------DESARROLLO GRAFICAS--------------------------------------------------------------
       
        



   
        
        //----------------------- Area de graficas -----------------------------
        
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
    
    
    public void eventojcpYear() 
    {
      String selectedYear = (String) jcpYear.getSelectedItem();
    // Realizar acciones basadas en el año seleccionado
    // Por ejemplo, imprimirlo en la consola
     
        
    }
    
    
    public void eventojcpUni() 
    {
        
        
    }
    
    


     public void eventoHombresxMujeres() {
    FuncionArchivo funcionArchivo = new FuncionArchivo();
    funcionArchivo.Leer_Archivo("2020comas.csv"); // Asegúrate de proporcionar la ruta correcta del archivo

    ChartPanel chartPanel = funcionArchivo.generarGraficoHombresMujeres();

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
