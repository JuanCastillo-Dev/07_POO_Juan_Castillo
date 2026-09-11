package vallegrande.edu.pe.miperfil.model;

public class Perfil {
    private String nombre;
    private String carrera;
    private String semestre;
    private String datoAdicional; //

    public Perfil(String nombre, String carrera, String semestre, String datoAdicional){
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.datoAdicional = datoAdicional;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCarrera(){
        return carrera;
    }

    public String getSemestre(){
        return semestre;
    }

    public String getDatoAdicional(){
        return datoAdicional;
    }

    public String obtenerPresentacion(){
        return "Hola, soy " + nombre +
                "\nCarrera: " + carrera +
                "\nSemestre: " + semestre +
                "\nMe gusta: " + datoAdicional;
    }
}