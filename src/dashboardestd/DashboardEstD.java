package dashboardestd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;

public class DashboardEstD extends JFrame {

    ArrayList<Institucion> inst = new ArrayList<>();

    JSplitPane jsplit;
    JButton jButtones;
    JPanel izq, panelBut, panelYear, panelUni, panel2, panel3, panel4, panelDep, panel6, panelMun, panelForm, panel9,
            der, panelEsp, panelArec, panelNivForm, panelGrad;
    JPanel panel_graf1, panel_graf2, panel_graf3, panel_graf4, panel_graf5, panel_graf6, panel_graf7, panel_graf8,
            panel_graf9, panel_graf10cal, panelPro;// cambiar por ChartPanel
    JComboBox<String> jcpUni, jcpYear, jcP2, jcpDep, jcP5, jcpMun, jcpForm, jcPro, jcEsp, jcArec, jcNivForm, jcGrad;
    JCheckBox jck1_P2, jck2_P2, jckPriv, jckOfic, jck3_P3, jck1_P4, jck2_P4, jck1_sem, jck2_sem, jckPreg, jckPosg,
            jckHom, jckMuj;
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
                ImageIcon imageIcon = new ImageIcon(
                        "C:\\Users\\USER\\Documents\\NetBeansProjects\\ESTRUCTURA DE DATOS\\DashboardEstD\\src\\imagenes\\luna.jpg");
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        izq.setLayout(null);

        JComponent topTextArea = new JTextArea(
                "PROGRAMADORES \n Santiago Martinez Serna.\n Laura Sofica Toro. \n Santiago Santacruz Cuellar\n\n GRAFICAS EGRESADOS COLOMBIA: Seleccione datos a consultar\n ");
        topTextArea.setOpaque(false);
        topTextArea.setForeground(Color.white);
        topTextArea.setFocusable(false);
        ((JTextArea) topTextArea).setLineWrap(true);
        ((JTextArea) topTextArea).setWrapStyleWord(true);
        topTextArea.setBounds(10, 0, 400, 100);
        izq.add(topTextArea);

        // ----------------------- Area de graficas -----------------------------

        der = new JPanel();
        der.setLayout(null);
        der.setPreferredSize(new Dimension(1500, 1500)); // tamaño del jpanel der para mostrar las graficas
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
        jcpYear.setBounds(15, 17, 100, 25);// coord con respecto al panel panelUni
        panelYear.add(jcpYear);
        izq.add(panelYear);

        jcpYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedYear = (String) jcpYear.getSelectedItem();
                // Llamar al método correspondiente cuando se seleccione un año
                eventojcpYear();

                jcpYear.setEnabled(false);

            }

        });

        panelDep = new JPanel();// jpanel para opciones de consulta
        panelDep.setLayout(null);
        panelDep.setBackground(Color.WHITE);
        panelDep.setBounds(140, 150, 130, 50);// coord con respecto al panel izq
        panelDep.setBorder(new TitledBorder("Departamento"));
        jcpDep = new JComboBox<>();
        jcpDep.addItem("BogotaD.C");
        jcpDep.addItem("Amazonas");
        jcpDep.addItem("Antioquia");
        jcpDep.addItem("Atlantico");
        jcpDep.addItem("Arauca");
        jcpDep.addItem("Boyaca");
        jcpDep.addItem("Caldas");
        jcpDep.addItem("Caqueta");
        jcpDep.addItem("Cauca");
        jcpDep.addItem("Cesar");
        jcpDep.addItem("Choco");
        jcpDep.addItem("Cordoba");
        jcpDep.addItem("Guainia");
        jcpDep.addItem("Guaviare");
        jcpDep.addItem("Huila");
        jcpDep.addItem("La Guajira");
        jcpDep.addItem("Magdalena");
        jcpDep.addItem("Meta");
        jcpDep.addItem("Nariño");
        jcpDep.addItem("Norte de Santander");
        jcpDep.addItem("Putumayo");
        jcpDep.addItem("Quindio");
        jcpDep.addItem("Risaralda");
        jcpDep.addItem("San Andres y Providencia");
        jcpDep.addItem("Santander");
        jcpDep.addItem("Sucre");
        jcpDep.addItem("Tolima");
        jcpDep.addItem("Valle del Cauca");
        jcpDep.addItem("Vaupes");
        jcpDep.addItem("Vichada");
        jcpDep.setBounds(15, 17, 100, 25);// coord con respecto al panel panelUni
        panelDep.add(jcpDep);
        izq.add(panelDep);
        jcpDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dep = 0;

                String selectedDepto = (String) jcpDep.getSelectedItem();

                jcpDep.setEnabled(false);

            }

        });

        panelMun = new JPanel();// jpanel para opciones de consulta
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

        jcpMun.addItem("ETC...");
        jcpMun.setBounds(15, 17, 100, 25);// coord con respecto al panel panelUni
        panelMun.add(jcpMun);
        izq.add(panelMun);
        jcpMun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedMun = (String) jcpMun.getSelectedItem();

                jcpMun.setEnabled(false);

            }
        });

        panelUni = new JPanel();// jpanel para opciones de consulta
        panelUni.setLayout(null);
        panelUni.setBackground(Color.WHITE);
        panelUni.setBounds(10, 210, 260, 50);// coord con respecto al panel izq
        panelUni.setBorder(new TitledBorder("IES"));
        jcpUni = new JComboBox<>();
        jcpUni.addItem("UNIDAD CENTRAL DEL VALLE DEL CAUCA");
        jcpUni.addItem("UNIVERSIDAD NACIONAL DE COLOMBIA");
        jcpUni.addItem("UNIVERSIDAD DEL VALLE");
        jcpUni.addItem("UNIVERSIDAD DE ANTIOQUIA");
        jcpUni.addItem("UNIVERSIDAD INDUSTRIAL DE SANTANDER");
        jcpUni.addItem("UNIVERSIDAD DE LOS ANDES");
        jcpUni.addItem("UNIVERSIDAD DE CALDAS");
        jcpUni.addItem("UNIVERSIDAD DEL CAUCA");
        jcpUni.addItem("UNIVERSIDAD DE PAMPLONA");
        jcpUni.addItem("UNIVERSIDAD DEL ATLANTICO");
        jcpUni.addItem("UNIVERSIDAD DE LA SABANA");
        jcpUni.addItem("UNIVERSIDAD DE CORDOBA");
        jcpUni.addItem("UNIVERSIDAD EAFIT");
        jcpUni.addItem("UNIVERSIDAD DEL TOLIMA");
        jcpUni.addItem("UNIVERSIDAD DEL QUINDIO");
        jcpUni.addItem("UNIVERSIDAD DE SAN BUENAVENTURA");
        jcpUni.addItem("UNIVERSIDAD DE LIBRE");
        jcpUni.addItem("UNIVERSIDAD DE CARTAGENA");
        jcpUni.addItem("UNIVERSIDAD DE NARIÑO");
        jcpUni.addItem("UNIVERSIDAD ANTONIO NARIÑO");
        jcpUni.addItem("UNIVERSIDAD NACIONAL ABIERTA Y A DISTANCIA UNAD");
        jcpUni.addItem("ESCUELA SUPERIOR DE ADMINISTRACION PUBLICA ESAP");
        jcpUni.addItem("UNIVERSIDAD DE CUNDINAMARCA");
        jcpUni.addItem("INSTITUCION UNIVERSITARIA ANTONIO JOSE CAMACHO");
        jcpUni.addItem("INSTITUTO TECNOLOGICO METROPOLITANO");
        jcpUni.addItem("FUNDACION UNIVERSITARIA ESUMER");
        jcpUni.addItem("CORPORACION UNIFICADA NACIONAL DE EDUCACION SUPERIOR CUN");
        jcpUni.addItem("SERVICIO NACIONAL DE APRENDIZAJE SENA");
        jcpUni.addItem("FUNDACION UNIVERSITARIA DE CIENCIAS DE LA SALUD");
        jcpUni.addItem("INSTITUCION UNIVERSITARIA COMANDO DE EDUCACION Y DOCTRINA CEDOC DEL EJERCITO NACIONAL");
        jcpUni.addItem("FUNDACION UNIVERSITARIA LUIS AMIGO");
        jcpUni.addItem("FUNDACION UNIVERSITARIA DEL AREA ANDINA");
        jcpUni.addItem("INSTITUCION UNIVERSITARIA BELLAS ARTES Y CIENCIAS DE BOLIVAR");
        jcpUni.addItem("UNIVERSIDAD DE MEDELLIN");
        jcpUni.addItem("UNIVERSIDAD TECNOLOGICA DE BOLIVAR");
        jcpUni.addItem("DIRECCION NACIONAL DE ESCUELAS");
        jcpUni.addItem("POLITECNICO GRANCOLOMBIANO");
        jcpUni.addItem("TECNOLOGICO DE ANTIOQUIA");
        jcpUni.setBounds(15, 17, 240, 25);// coord con respecto al panel panelUni
        panelUni.add(jcpUni);
        izq.add(panelUni);
        jcpUni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedUni = (String) jcpUni.getSelectedItem();

                jcpUni.setEnabled(false);

            }
        });

        panelForm = new JPanel();// jpanel para opciones de consulta
        panelForm.setLayout(null);
        panelForm.setBackground(Color.WHITE);
        panelForm.setBounds(280, 210, 260, 50);// coord con respecto al panel izq
        panelForm.setBorder(new TitledBorder("Caracter"));
        jcpForm = new JComboBox<>();
        jcpForm.addItem("Universidad");
        jcpForm.addItem("Institucion Tecnologica");
        jcpForm.addItem("Institucion Universitaria/Escuela Tecnologica");
        jcpForm.addItem("Institucion Tecnica Profesional");


       

       
        jcpForm.setBounds(15, 17, 240, 25);// coord con respecto al panel panelUni
        panelForm.add(jcpForm);
        izq.add(panelForm);
        jcpForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedCaracter = (String) jcpForm.getSelectedItem();

                jcpForm.setEnabled(false);

            }
        });

        panelPro = new JPanel();// jpanel para opciones de consulta
        panelPro.setLayout(null);
        panelPro.setBackground(Color.WHITE);
        panelPro.setBounds(280, 390, 260, 50);// coord con respecto al panel izq
        panelPro.setBorder(new TitledBorder("Programa Academico"));
        jcPro = new JComboBox<>();
        jcPro.addItem("INGENIERIA AGRONOMICA");
        jcPro.addItem("MEDICINA VETERINARIA");
        jcPro.addItem("ZOOTECNIA");
        jcPro.addItem("DISENO GRAFICO");
        jcPro.addItem("CINE Y TELEVISION");
        jcPro.addItem("ENFERMERIA");
        jcPro.addItem("MEDICINA");
        jcPro.addItem("ODONTOLOGIA");
        jcPro.addItem("FISIOTERAPIA");
        jcPro.addItem("NUTRICION Y DIETETICA");
        jcPro.addItem("PSICOLOGIA");
        jcPro.addItem("ARQUITECTURA");
        jcPro.addItem("INGENIERIA CIVIL");
        jcPro.addItem("INGENIERIA ELECTRONICA");
        jcPro.addItem("INGENIERIA DE SISTEMAS");
        jcPro.addItem("INGENIERIA MECANICA");
        jcPro.addItem("INGENIERIA INDUSTRIAL");
        jcPro.addItem("INGENIERIA ELECTRICA");
        jcPro.addItem("TERAPIA OCUPACIONAL");
        jcPro.addItem("BACTERIOLOGIA");
        jcPro.addItem("ADMINISTRACION DE EMPRESAS");
        jcPro.addItem("CONTADURIA PUBLICA");
        jcPro.addItem("TRABAJO SOCIAL");
        jcPro.addItem("DERECHO");
        jcPro.addItem("ECONOMIA");
        jcPro.addItem("FILOSOFIA");
        jcPro.addItem("SOCIOLOGIA");
        jcPro.addItem("ANTROPOLOGIA");
        jcPro.addItem("HISTORIA");
        jcPro.addItem("ADMINISTRACION DE EMPRESAS");
        jcPro.addItem("FILOLOGIA E IDIOMAS");
        jcPro.addItem("INGENIERIA AGRICOLA");
        jcPro.addItem("INGENIERIA AGROINDUSTRIAL");
        jcPro.addItem("INGENIERIA DE ALIMENTOS");
        jcPro.addItem("ESTADISTICA");
        jcPro.addItem("MATEMATICAS");
        jcPro.addItem("FISICA");
        jcPro.addItem("QUIMICA");
        jcPro.addItem("BIOLOGIA");
        jcPro.addItem("GEOLOGIA");
        jcPro.addItem("INGENIERIA AMBIENTAL");
        jcPro.addItem("INGENIERIA SANITARIA");
        jcPro.addItem("FARMACIA");
        jcPro.addItem("ESPECIALIDAD EN CIRUGIA PEDIATRICA");
        jcPro.addItem("ESPECIALIDAD EN CIRUGIA PLASTICA");
        jcPro.addItem("ESPECIALIDAD EN CIRUGIA GENERAL");
        jcPro.addItem("ESPECIALIDAD EN CIRUGIA CARDIOVASCULAR");
        jcPro.addItem("ESPECIALIDAD EN CIRUGIA MAXILOFACIAL");
        jcPro.addItem("ESPECIALIDAD EN MEDICINA FISICA Y REHABILITACION");
        jcPro.addItem("ESPECIALIDAD EN MEDICINA INTERNA");
        jcPro.addItem("ESPECIALIDAD EN ENDOCRINOLOGIA");
        jcPro.addItem("ESPECIALIDAD EN GASTROENTEROLOGIA");
        jcPro.addItem("ESPECIALIDAD EN GERIATRIA");
        jcPro.addItem("ESPECIALIDAD EN HEMATOLOGIA");
        jcPro.addItem("ESPECIALIDAD EN NEFROLOGIA");
        jcPro.addItem("ESPECIALIZACION EN CIENCIA Y TECNOLOGIA DE ALIMENTOS");
        jcPro.addItem("MAESTRIA EN GENETICA HUMANA");
        jcPro.addItem("MAESTRIA EN CIENCIAS - MATEMATICAS");
        jcPro.addItem("MAESTRIA EN CIENCIAS - FISICA");
        jcPro.addItem("DOCTORADO EN CIENCIAS - QUIMICA");
        jcPro.addItem("ARTES PLASTICAS");


        




        jcPro.setBounds(15, 17, 240, 25);// coord con respecto al panel panelUni
        panelPro.add(jcPro);
        izq.add(panelPro);
        jcPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedProgAcademico = (String) jcPro.getSelectedItem();

                jcPro.setEnabled(false);

            }
        });

        panelEsp = new JPanel();// jpanel para opciones de consulta
        panelEsp.setLayout(null);
        panelEsp.setBackground(Color.WHITE);
        panelEsp.setBounds(280, 450, 260, 50);// coord con respecto al panel izq
        panelEsp.setBorder(new TitledBorder("Campo especifico"));
        jcEsp = new JComboBox<>();
        jcEsp.addItem("Agropecuario");
        jcEsp.addItem("Veterinaria");
        jcEsp.addItem("Salud");
        jcEsp.addItem("Artes"); 
        jcEsp.addItem("Ciencias sociales y del comportamiento");
        jcEsp.addItem("Humanidades (Excepto idiomas)");
        jcEsp.addItem("Derecho");
        jcEsp.addItem("Idiomas");
        jcEsp.addItem("Ingeniería y profesiones afines");
        jcEsp.addItem("Ciencias biologicas y afines");
        jcEsp.addItem("Ciencias físicas");
        jcEsp.addItem("Matematicas y estadistica");






        // Falta por agregar campos especificos
        jcEsp.setBounds(15, 17, 240, 25);// coord con respecto al panel panelUni
        panelEsp.add(jcEsp);
        izq.add(panelEsp);
        jcEsp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedCampoEsp = (String) jcEsp.getSelectedItem();

                jcEsp.setEnabled(false);

            }
        });

        panelArec = new JPanel();// jpanel para opciones de consulta
        panelArec.setLayout(null);
        panelArec.setBackground(Color.WHITE);
        panelArec.setBounds(280, 510, 260, 50);// coord con respecto al panel izq
        panelArec.setBorder(new TitledBorder("Area de conocimiento"));
        jcArec = new JComboBox<>();
        jcArec.addItem("Ingenieria arquitectura urbanismo y afines");
        jcArec.addItem("Agronomia veterinaria y afines");
        jcArec.addItem("Ciencias de la salud");
        jcArec.addItem("Ciencias de la educacion");
        jcArec.addItem("Matematicas y ciencias naturales");
        jcArec.addItem("Ciencias sociales y humanas");
        jcArec.addItem("ECONOMIA administracion contaduria y afines");
        jcArec.addItem("Bellas artes");
        jcArec.setBounds(15, 17, 240, 25);// coord con respecto al panel panelUni
        panelArec.add(jcArec);
        izq.add(panelArec);
        jcArec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedAreaConoc = (String) jcArec.getSelectedItem();

                jcArec.setEnabled(false);

            }
        });

        panelNivForm = new JPanel();// jpanel para opciones de consulta
        panelNivForm.setLayout(null);
        panelNivForm.setBackground(Color.WHITE);
        panelNivForm.setBounds(10, 450, 260, 50);// coord con respecto al panel izq
        panelNivForm.setBorder(new TitledBorder("Nivel de formacion"));
        jcNivForm = new JComboBox<>();
        jcNivForm.addItem("Universitaria");
        jcNivForm.addItem("Maestria");
        jcNivForm.addItem("Especializacion medico quirurgica");
        jcNivForm.addItem("Especializacion universitaria");
        jcNivForm.addItem("Doctorado");
        jcNivForm.addItem("Tecnologico");
        jcNivForm.addItem("Formacion tecnica profesional");
        jcNivForm.setBounds(15, 17, 240, 25);// coord con respecto al panel panelUni
        panelNivForm.add(jcNivForm);
        izq.add(panelNivForm);
        jcNivForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedNivFormacion = (String) jcNivForm.getSelectedItem();

                jcNivForm.setEnabled(false);

            }
        });

        panelGrad = new JPanel();// jpanel para opciones de consulta
        panelGrad.setLayout(null);
        panelGrad.setBackground(Color.WHITE);
        panelGrad.setBounds(10, 510, 260, 50);// coord con respecto al panel izq
        panelGrad.setBorder(new TitledBorder("Tener en cuenta Graduados"));
        jcGrad = new JComboBox<>();
        jcGrad.addItem("Si");
        jcGrad.addItem("No");
        jcGrad.setBounds(15, 17, 240, 25);// coord con respecto al panel panelUni
        panelGrad.add(jcGrad);
        izq.add(panelGrad);
        jcGrad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedOpcGraduados = (String) jcGrad.getSelectedItem();

                jcGrad.setEnabled(false);

            }
        });

        // -------------------------inicio checkbox------------------------------------

        panel4 = new JPanel();// jpanel para opciones de consulta
        panel4.setLayout(null);
        panel4.setBackground(Color.WHITE);
        panel4.setBounds(280, 270, 260, 50);// coord con respecto al panel izq
        panel4.setBorder(new TitledBorder("Sector IES"));
        jckPriv = new JCheckBox("PRIVADA");
        jckPriv.setBounds(15, 17, 100, 25);// coord con respecto al panel2
        jckOfic = new JCheckBox("OFICIAL");
        jckOfic.setBounds(120, 17, 100, 25);// coord con respecto al panel2
        panel4.add(jckPriv);
        panel4.add(jckOfic);
        izq.add(panel4);
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Desmarcar el otro JCheckBox si se selecciona uno
                    String iesPriv = (String) jckPriv.getText();
                    String iesOfi = (String) jckOfic.getText();
                    if (e.getItem().equals(jckPriv)) {
                        jckOfic.setSelected(false);
                    } else if (e.getItem().equals(jckOfic)) {
                        jckPriv.setSelected(false);
                    }
                    ((JCheckBox) e.getItem()).setEnabled(false);
                }
            }
        };

        jckPriv.addItemListener(itemListener);
        jckOfic.addItemListener(itemListener);

        panel3 = new JPanel();// jpanel para opciones de consulta
        panel3.setLayout(null);
        panel3.setBackground(Color.WHITE);
        panel3.setBounds(10, 330, 260, 50);// coord con respecto al panel izq
        panel3.setBorder(new TitledBorder("Nivel Academico"));
        jckPreg = new JCheckBox("Pregrado");
        jckPreg.setBounds(15, 17, 100, 25);// coord con respecto al panel2
        jckPosg = new JCheckBox("Posgrado");
        jckPosg.setBounds(120, 17, 100, 25);// coord con respecto al panel2
        panel3.add(jckPreg);
        panel3.add(jckPosg);
        izq.add(panel3);

        ItemListener itemListenerPanel3 = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Desmarcar el otro JCheckBox si se selecciona uno
                    String NivPreg = (String) jckPreg.getText();
                    String NivPosg = (String) jckPosg.getText();

                    if (e.getItem().equals(jckPreg)) {
                        jckPosg.setSelected(false);
                    } else if (e.getItem().equals(jckPosg)) {
                        jckPreg.setSelected(false);
                    }
                    ((JCheckBox) e.getItem()).setEnabled(false);
                }
            }
        };

        jckPreg.addItemListener(itemListenerPanel3);
        jckPosg.addItemListener(itemListenerPanel3);

        panel6 = new JPanel();// jpanel para opciones de consulta
        panel6.setLayout(null);
        panel6.setBackground(Color.WHITE);
        panel6.setBounds(10, 390, 260, 50);// coord con respecto al panel izq
        panel6.setBorder(new TitledBorder("Semestre de Graduacion"));
        jck1_sem = new JCheckBox("1");
        jck1_sem.setBounds(15, 17, 100, 25);// coord con respecto al panel2
        jck2_sem = new JCheckBox("2");
        jck2_sem.setBounds(120, 17, 100, 25);// coord con respecto al panel2
        panel6.add(jck1_sem);
        panel6.add(jck2_sem);
        izq.add(panel6);

        ItemListener itemListenerPanel6 = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Desmarcar el otro JCheckBox si se selecciona uno

                    String sem1 = (String) jck1_sem.getText();
                    String sem2 = (String) jck2_sem.getText();

                    if (e.getItem().equals(jck1_sem)) {
                        jck2_sem.setSelected(false);
                    } else if (e.getItem().equals(jck2_sem)) {
                        jck1_sem.setSelected(false);
                    }
                    ((JCheckBox) e.getItem()).setEnabled(false);
                }
            }
        };

        jck1_sem.addItemListener(itemListenerPanel6);
        jck2_sem.addItemListener(itemListenerPanel6);

        panel9 = new JPanel();// jpanel para opciones de consulta
        panel9.setLayout(null);
        panel9.setBackground(Color.WHITE);
        panel9.setBounds(280, 330, 260, 50);// coord con respecto al panel izq
        panel9.setBorder(new TitledBorder("Metodologia"));
        jck1_P4 = new JCheckBox("Presencial");
        jck1_P4.setBounds(15, 17, 100, 25);// coord con respecto al panel2
        jck2_P4 = new JCheckBox("Distancia");
        jck2_P4.setBounds(120, 17, 100, 25);// coord con respecto al panel2
        panel9.add(jck1_P4);
        panel9.add(jck2_P4);
        izq.add(panel9);

        ItemListener itemListenerPanel9 = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    String metPres = (String) jck1_P4.getText();
                    String metDist = (String) jck2_P4.getText();
                    // Desmarcar el otro JCheckBox si se selecciona uno
                    if (e.getItem().equals(jck1_P4)) {
                        jck2_P4.setSelected(false);
                    } else if (e.getItem().equals(jck2_P4)) {
                        jck1_P4.setSelected(false);
                    }
                    ((JCheckBox) e.getItem()).setEnabled(false);
                }
            }
        };

        jck1_P4.addItemListener(itemListenerPanel9);
        jck2_P4.addItemListener(itemListenerPanel9);

        panel2 = new JPanel();// jpanel para opciones de consulta
        panel2.setLayout(null);
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(10, 270, 260, 50);// coord con respecto al panel izq
        panel2.setBorder(new TitledBorder("Sexo"));
        jckHom = new JCheckBox("Hombre");
        jckHom.setBounds(15, 17, 100, 25);// coord con respecto al panel2
        jckMuj = new JCheckBox("Mujer");
        jckMuj.setBounds(120, 17, 100, 25);// coord con respecto al panel2
        panel2.add(jckHom);
        panel2.add(jckMuj);
        izq.add(panel2);

        ItemListener itemListenerPanel2 = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    String sexoHom = (String) jckHom.getText();
                    String sexoMuj = (String) jckMuj.getText();

                    // Desmarcar el otro JCheckBox si se selecciona uno
                    if (e.getItem().equals(jckHom)) {
                        jckMuj.setSelected(false);
                    } else if (e.getItem().equals(jckMuj)) {
                        jckHom.setSelected(false);
                    }

                    ((JCheckBox) e.getItem()).setEnabled(false);
                }
            }
        };

        jckHom.addItemListener(itemListenerPanel2);
        jckMuj.addItemListener(itemListenerPanel2);

        // -----------------------Creación de JButtons-----------------------------

        /*
         * // BOTON GRAF HOMXMUJ
         * panelBut = new JPanel();
         * panelBut.setLayout(null);
         * panelBut.setBackground(Color.WHITE);
         * panelBut.setBounds(10, 270, 260, 50);
         * panelBut.setBorder(new TitledBorder("Grafico"));
         * jButtones = new JButton("Hombres vs Mujeres");
         * jButtones.setBounds(15, 17, 240, 25);
         * panelBut.add(jButtones);
         * izq.add(panelBut); // Cambiar panelForm por panelBut
         * jButtones.addActionListener(new ActionListener() {
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * eventoHombresxMujeres();
         * }
         * });
         * 
         * // BOTON GRAF PREGVSPOSG
         * panelBut = new JPanel();
         * panelBut.setLayout(null);
         * panelBut.setBackground(Color.WHITE);
         * panelBut.setBounds(10, 330, 260, 50);
         * panelBut.setBorder(new TitledBorder("Grafico"));
         * jButtones = new JButton("Pregrado vs Posgrado");
         * jButtones.setBounds(15, 17, 240, 25);
         * panelBut.add(jButtones);
         * izq.add(panelBut); // Cambiar panelForm por panelBut
         * jButtones.addActionListener(new ActionListener() {
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * eventoPregxPosg();
         * }
         * });
         * 
         * // BOTON GRAF OFICVSPRIV
         * panelBut = new JPanel();
         * panelBut.setLayout(null);
         * panelBut.setBackground(Color.WHITE);
         * panelBut.setBounds(10, 390, 260, 50);
         * panelBut.setBorder(new TitledBorder("Grafico"));
         * jButtones = new JButton("Oficial vs Privada");
         * jButtones.setBounds(15, 17, 240, 25);
         * panelBut.add(jButtones);
         * izq.add(panelBut); // Cambiar panelForm por panelBut
         * jButtones.addActionListener(new ActionListener() {
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * eventoOficxPriv();
         * }
         * });
         * 
         * // BOTON xCARACTER
         * panelBut = new JPanel();
         * panelBut.setLayout(null);
         * panelBut.setBackground(Color.WHITE);
         * panelBut.setBounds(10, 450, 260, 50);
         * panelBut.setBorder(new TitledBorder("Grafico"));
         * jButtones = new JButton("Caracter Instituciones");
         * jButtones.setBounds(15, 17, 240, 25);
         * panelBut.add(jButtones);
         * izq.add(panelBut); // Cambiar panelForm por panelBut
         * jButtones.addActionListener(new ActionListener() {
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * eventoxCaracter();
         * }
         * });
         * 
         * panelBut = new JPanel();
         * panelBut.setLayout(null);
         * panelBut.setBackground(Color.WHITE);
         * panelBut.setBounds(10, 510, 260, 50);
         * panelBut.setBorder(new TitledBorder("Grafico"));
         * jButtones = new JButton("Por Departamentos");
         * jButtones.setBounds(15, 17, 240, 25);
         * panelBut.add(jButtones);
         * izq.add(panelBut); // Cambiar panelForm por panelBut
         * jButtones.addActionListener(new ActionListener() {
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * eventoxDepto();
         * }
         * });
         */

        // BOTON GRAF PREGVSPOSG
        panelBut = new JPanel();
        panelBut.setLayout(null);
        panelBut.setBackground(Color.WHITE);
        panelBut.setBounds(10, 600, 260, 50);
        panelBut.setBorder(new TitledBorder("Grafico Combinado"));
        jButtones = new JButton("Graficar");
        jButtones.setBounds(15, 17, 240, 25);
        panelBut.add(jButtones);
        izq.add(panelBut); // Cambiar panelForm por panelBut
        jButtones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eventoGenerarGraficoCombinado();

            }
        });

        panelBut = new JPanel();
        panelBut.setLayout(null);
        panelBut.setBackground(Color.WHITE);
        panelBut.setBounds(280, 600, 260, 50);
        panelBut.setBorder(new TitledBorder("Limpiar Botones"));
        jButtones = new JButton("Limpiar");
        jButtones.setBounds(15, 17, 240, 25);
        panelBut.add(jButtones);
        izq.add(panelBut); // Cambiar panelForm por panelBut
        jButtones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eventoLimpiar();

            }
        });

        // -----------------------------------------------DESARROLLO
        // GRAFICAS--------------------------------------------------------------

        der = new JPanel();
        der.setLayout(null);
        der.setPreferredSize(new Dimension(2000, 2000));// tamaño del jpanel der para mostrar las graficas
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

        panel_graf6 = new JPanel();// esto seria el ChartPanel de la grafica 4
        panel_graf6.setLayout(null);
        panel_graf6.setBackground(Color.DARK_GRAY);
        panel_graf6.setBounds(532, 1064, 512, 512);
        der.add(panel_graf6);

        panel_graf7 = new JPanel();// esto seria el ChartPanel de la grafica 4
        panel_graf7.setLayout(null);
        panel_graf7.setBackground(Color.GREEN);
        panel_graf7.setBounds(1054, 10, 512, 512);
        der.add(panel_graf7);

        /*
         * .....
         * anadir tantos ChartPanel como graficas a mostrar
         * .....
         */

        JScrollPane js = new JScrollPane(der);

        jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, izq, js);
        jsplit.setOneTouchExpandable(true);
        jsplit.setDividerLocation(550);

        add(jsplit);

    }

    public void eventoLimpiar() {
        // Reiniciar JComboBox
        jcpYear.setSelectedIndex(0);
        jcpDep.setSelectedIndex(0);
        jcpMun.setSelectedIndex(0);
        jcpUni.setSelectedIndex(0);
        jcpForm.setSelectedIndex(0);
        jcPro.setSelectedIndex(0);
        jcEsp.setSelectedIndex(0);
        jcArec.setSelectedIndex(0);
        jcNivForm.setSelectedIndex(0);
        jcGrad.setSelectedIndex(0);

        // Habilitar JComboBox nuevamente
        jcpYear.setEnabled(true);
        jcpDep.setEnabled(true);
        jcpMun.setEnabled(true);
        jcpUni.setEnabled(true);
        jcpForm.setEnabled(true);
        jcPro.setEnabled(true);
        jcEsp.setEnabled(true);
        jcArec.setEnabled(true);
        jcNivForm.setEnabled(true);
        jcGrad.setEnabled(true);

        // Desmarcar JCheckBox
        jckPriv.setSelected(false);
        jckOfic.setSelected(false);
        jckPreg.setSelected(false);
        jckPosg.setSelected(false);
        jck1_sem.setSelected(false);
        jck2_sem.setSelected(false);
        jck1_P4.setSelected(false);
        jck2_P4.setSelected(false);
        jckHom.setSelected(false);
        jckMuj.setSelected(false);

        // Habilitar JCheckBox nuevamente
        jckPriv.setEnabled(true);
        jckOfic.setEnabled(true);
        jckPreg.setEnabled(true);
        jckPosg.setEnabled(true);
        jck1_sem.setEnabled(true);
        jck2_sem.setEnabled(true);
        jck1_P4.setEnabled(true);
        jck2_P4.setEnabled(true);
        jckHom.setEnabled(true);
        jckMuj.setEnabled(true);
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
        eventoxSemyGrad(funcionArchivo);

    }

    // Métodos de generación de gráficos modificados para aceptar FuncionArchivo
    // como parámetro
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

    public void eventoxSemyGrad(FuncionArchivo funcionArchivo) {
        ChartPanel chartPanel = funcionArchivo.generarGrafGradxSemestre();
        actualizarPanelGrafico(panel_graf6, chartPanel);
    }

    // Nuevo método para actualizar el panel de gráfico
    private void actualizarPanelGrafico(JPanel panelGrafico, ChartPanel chartPanel) {
        panelGrafico.removeAll();
        panelGrafico.setLayout(new BorderLayout());
        panelGrafico.add(chartPanel, BorderLayout.CENTER);
        panelGrafico.revalidate();
        panelGrafico.repaint();
    }

    public void eventojcpUni() {

    }

    public void eventojcpDep() {

    }

    public void eventojcpMun() {

    }

    public void eventojcpForm() {

    }

    public void eventoHombresxMujeres() {
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

        ChartPanel chartPanel = funcionArchivo.generarGraficoxDepto();

        // Limpiar el panel y agregar el nuevo gráfico
        panel_graf1.removeAll();
        panel_graf1.setLayout(new BorderLayout()); // Usar un BorderLayout
        panel_graf1.add(chartPanel, BorderLayout.CENTER);
        panel_graf1.revalidate();
        panel_graf1.repaint();

    }

    private void eventoGenerarGraficoCombinado() {

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

        String selectedCampoEsp = (String) jcEsp.getSelectedItem();
        String selectedMun = (String) jcpMun.getSelectedItem();
        String selectedNivForm = (String) jcNivForm.getSelectedItem();
        String selectedDepto = (String) jcpDep.getSelectedItem();
        String selectedUni = (String) jcpUni.getSelectedItem();
        String selectedCaracter = (String) jcpForm.getSelectedItem();
        String selectedProgAcademico = (String) jcPro.getSelectedItem();
        String selectedAreaConoc = (String) jcArec.getSelectedItem();

        // Llama al método que genera el gráfico
        ChartPanel chartPanel = funcionArchivo.generarGraficoCampoEspecifico(selectedCampoEsp, selectedMun,
                selectedNivForm, selectedDepto, selectedUni, selectedCaracter, selectedProgAcademico, selectedAreaConoc);

        // Limpia el panel de gráficos antes de agregar uno nuevo
        panel_graf7.removeAll();
        panel_graf7.setLayout(new BorderLayout()); // Usar un BorderLayout
        panel_graf7.add(chartPanel, BorderLayout.CENTER);
        panel_graf7.revalidate();
        panel_graf7.repaint();

    }

    public static void main(String[] args) {
        DashboardEstD v = new DashboardEstD();
    }
}
