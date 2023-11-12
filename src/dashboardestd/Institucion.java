
package dashboardestd;


public class Institucion {
    String nombre, ciudad, genero;
    int tipo; //1-> OFICIAL, 2-> PRIVADO
    int caracter;

    public Institucion(String nombre, String ciudad, int tipo, int caracter, String genero) {
        this.nombre = nombre;
         this.genero = genero;
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

    public String getGenero() {
        return genero;
    }

    public int getCaracter() {
        return caracter;
    }

    
    
    
}
