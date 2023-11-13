package dashboardestd;

public class Institucion {
    String nombre, depto, municipio, genero, nivacademico, semestre, progacademico, metodología, areaconoc, nivformacion;
    int tipo; // 1-> OFICIAL, 2-> PRIVADO
    int caracter;
    int graduados;
     // Nueva variable para representar la cantidad de graduados

    public Institucion(String nombre, String depto, int tipo, int caracter, String genero, String nivacademico, String semestre, int graduados, String progacademico, String metodología, String areaconoc, String municipio, String nivformacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.depto = depto;
        this.nivacademico = nivacademico;
        this.tipo = tipo;
        this.caracter = caracter;
        this.semestre = semestre;
        this.graduados = graduados; // Inicializa la variable graduados
        this.progacademico = progacademico;
        this.metodología = metodología; // Inicializa la variable metodología
        this.areaconoc = areaconoc; // Inicializa la variable areaconoc
        this.municipio = municipio;
        this.nivformacion = nivformacion;
    }

    public String getNivformacion() {
        return nivformacion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getAreaconoc() {
        return areaconoc;
    }

    public String getMetodología() {
        return metodología;
    }

    public String getProgacademico() {
        return progacademico;
    }

    public String getDepto() {
        return depto;
    }

    public String getNivacademico() {
        return nivacademico;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getNombre() {
        return nombre;
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

    public int getGraduados() {
        return graduados;
    }
}
