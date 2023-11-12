
package dashboardestd;


public class Institucion {
    String nombre, depto, genero, nivacademico;
    int tipo; //1-> OFICIAL, 2-> PRIVADO
    int caracter;

    public Institucion(String nombre, String depto, int tipo, int caracter, String genero, String nivacademico) {
        this.nombre = nombre;
         this.genero = genero;
        this.depto = depto;
        this.nivacademico = nivacademico;
        this.tipo = tipo;
        this.caracter = caracter;
       
    }

    public String getNivacademico() {
        return nivacademico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getdepto() {
        return depto;
    }

    public int getTipo() {
        return tipo;
    }

    public String getGenero() {
        return genero;
    }

    public int getCaracter() {
        return caracter;
    }

    
    
    
}
