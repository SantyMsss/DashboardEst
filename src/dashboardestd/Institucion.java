
package dashboardestd;


public class Institucion {
    String nombre, ciudad;
    int tipo; //1-> OFICIAL, 2-> PRIVADO
    int caracter;

    public Institucion(String nombre, String ciudad, int tipo, int caracter) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.caracter = caracter;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTipo() {
        return tipo;
    }

    public int getCaracter() {
        return caracter;
    }

    
    
    
}
