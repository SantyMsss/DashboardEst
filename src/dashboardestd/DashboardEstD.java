package dashboardestd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class DashboardEstD extends JFrame{

    JSplitPane jsplit;
    JPanel izq, panel0,panel1, panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9,der;
    JPanel panel_graf1, panel_graf2, panel_graf3, panel_graf4;// cambiar por ChartPanel
    JComboBox<String> jcP1,jcP0,jcP2,jcP3,jcP5,jcP6,jcP7;
    JCheckBox jck1_P2, jck2_P2,jck1_P3,jck2_P3,jck3_P3,jck1_P4,jck2_P4;
    JLabel jlImagen1, jlImagen2;
    
    public DashboardEstD(){
        super("Ejemplo de JSplitPane");
        setSize(1200, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);// ventana maximizada
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        crearGUI();
        setVisible(true);
    }
    
    private void crearGUI() {        
        //------------------- Area de control de consulta ----------------------
        
          izq = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carga la imagen de fondo desde una ruta local
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\ESTRUCTURA DE DATOS\\DashboardEstD\\src\\imagenes\\luna.jpg");
                // Dibuja la imagen de fondo
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        izq.setLayout(null);
        
             JTextArea topTextArea = new JTextArea("PROGRAMADORES \n Santiago Martinez Serna.\n Laura Sofica Toro. \n Santiago Santacruz Cuellar\n\n GRAFICAS EGRESADOS COLOMBIA: Seleccione datos a consultar\n ");
             
        topTextArea.setOpaque(false); // Hacer el fondo transparente
        topTextArea.setForeground(Color.white);
        topTextArea.setEditable(false); // No editable
        topTextArea.setLineWrap(true); // Salto de línea automático
        topTextArea.setWrapStyleWord(true); // Salto de línea en palabras
        topTextArea.setBounds(10, 0, 400, 100); // Ajusta las coordenadas y el tamaño según tus necesidades
        izq.add(topTextArea);
        
        
        //----------------------- Area de graficas -----------------------------

        der = new JPanel();
        der.setLayout(null);
        der.setPreferredSize(new Dimension(2000, 2000)); // tamaño del jpanel der para mostrar las graficas       
        der.setBackground(Color.BLACK);

        // Resto del código (paneles de gráficos, etc.)
     
        
        panel0 = new JPanel();// jpanel para opciones de consulta
        panel0.setLayout(null);
        panel0.setBackground(Color.WHITE);
        panel0.setBounds(10, 150, 120, 50);// coord con respecto al panel izq
        panel0.setBorder(new TitledBorder("Año"));
        jcP0 = new JComboBox<>();
        jcP0.addItem("2022");
        jcP0.addItem("2021");
        jcP0.addItem("2020");
        jcP0.setBounds(15, 17, 100, 25);//coord con respecto al panel panel1
        panel0.add(jcP0);        
        izq.add(panel0);
        
        panel5= new JPanel();// jpanel para opciones de consulta
        panel5.setLayout(null);
        panel5.setBackground(Color.WHITE);
        panel5.setBounds(140, 150, 130, 50);// coord con respecto al panel izq
        panel5.setBorder(new TitledBorder("Departamento"));
        jcP3 = new JComboBox<>();
        jcP3.addItem("Bogota D.C");
        jcP3.addItem("Amazonas");
        jcP3.addItem("Antioquia");
        jcP3.addItem("Atlantico");
        jcP3.addItem("Boyaca");
       
        // Falta por agregar deptartamentos 
        jcP3.addItem("ETC...");
        jcP3.setBounds(15, 17, 100, 25);//coord con respecto al panel panel1
        panel5.add(jcP3);        
        izq.add(panel5);
        
        panel7= new JPanel();// jpanel para opciones de consulta
        panel7.setLayout(null);
        panel7.setBackground(Color.WHITE);
        panel7.setBounds(280, 150, 130, 50);// coord con respecto al panel izq
        panel7.setBorder(new TitledBorder("Municipio"));
        jcP6 = new JComboBox<>();
        jcP6.addItem("Cali");
        jcP6.addItem("Armenia");
        jcP6.addItem("Neiva");
        jcP6.addItem("Palmira");
        jcP6.addItem("Bello");
       
        // Falta por agregar municipios
        jcP6.addItem("ETC...");
        jcP6.setBounds(15, 17, 100, 25);//coord con respecto al panel panel1
        panel7.add(jcP6);        
        izq.add(panel7);
        
        
        
        panel1 = new JPanel();// jpanel para opciones de consulta
        panel1.setLayout(null);
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(10, 210, 260, 50);// coord con respecto al panel izq
        panel1.setBorder(new TitledBorder("IES"));
        jcP1 = new JComboBox<>();
        jcP1.addItem("Unidad Central Del Valle Del Cauca");
        jcP1.addItem("Universidad Catoica");
        jcP1.addItem("Escuela De Logistica");
        jcP1.setBounds(15, 17, 240, 25);//coord con respecto al panel panel1
        panel1.add(jcP1);        
        izq.add(panel1);
        
        panel8 = new JPanel();// jpanel para opciones de consulta
        panel8.setLayout(null);
        panel8.setBackground(Color.WHITE);
        panel8.setBounds(280, 210, 260, 50);// coord con respecto al panel izq
        panel8.setBorder(new TitledBorder("Nivel de Formacion"));
        jcP7 = new JComboBox<>();
        jcP7.addItem("Universitaria");
        jcP7.addItem("Doctorado");
        jcP7.addItem("Especializacion Tecnico Profesional");
        jcP7.setBounds(15, 17, 240, 25);//coord con respecto al panel panel1
        panel8.add(jcP7);        
        izq.add(panel8);
        
        panel4 = new JPanel();// jpanel para opciones de consulta
        panel4.setLayout(null);
        panel4.setBackground(Color.WHITE);
        panel4.setBounds(10, 390, 260, 50);// coord con respecto al panel izq
        panel4.setBorder(new TitledBorder("Metodologia "));
        jcP2 = new JComboBox<>();
        jcP2.addItem("Presencial");
         jcP2.addItem("Presencial-Virtual");
        jcP2.addItem("Distancia");
        jcP2.addItem("Distancia tradicional");
        jcP2.addItem("Distancia virtual");
        jcP2.setBounds(15, 17, 240, 25);//coord con respecto al panel panel1
        panel4.add(jcP2);        
        izq.add(panel4);
        
         
        panel6 = new JPanel();// jpanel para opciones de consulta
        panel6.setLayout(null);
        panel6.setBackground(Color.WHITE);
        panel6.setBounds(10, 450, 260, 50);// coord con respecto al panel izq
        panel6.setBorder(new TitledBorder("Carrera "));
        jcP5 = new JComboBox<>();
        jcP5.addItem("Ingenieria Sistemas");
         jcP5.addItem("Administracion de Empresas");
        jcP5.addItem("Actividad Fisica y Deporte");
        jcP5.addItem("Arte");
        jcP5.addItem("Tecnoogia En Logistica");
        jcP5.setBounds(15, 17, 240, 25);//coord con respecto al panel panel1
        panel6.add(jcP5);        
        izq.add(panel6);
        
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
    }
    
    
    public void eventojcp0() 
    {
        
        
    }
    
    
    public void eventojcp1() 
    {
        
        
    }
    
    
    public void eventojcp2() 
    {
        
        
    }
    
    
    
    public static void main(String[] args) {
         DashboardEstD v = new DashboardEstD ();
    }
}
