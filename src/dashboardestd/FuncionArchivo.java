package dashboardestd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
                    tokens = linea.split(";");
                    inst.add(new Institucion(tokens[0], 
                            tokens[3], 
                            Integer.parseInt(tokens[1]), 
                            Integer.parseInt(tokens[2])));
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
            System.out.println((i+1) + " " + obj.getNombre());
        }
    }
    
    public void estadistica(){
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
    

    
    public static void main(String[] args) {
        FuncionArchivo obj = new FuncionArchivo();
        obj.Leer_Archivo("2020.csv");
        //obj.listar();
        obj.estadistica();
    }

}