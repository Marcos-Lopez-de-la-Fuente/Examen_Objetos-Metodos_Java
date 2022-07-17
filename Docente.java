
public class Docente extends Persona {
    //Atributos
    private String titulacion;
    private double puntos;
    
    //Constructores
    public Docente(String nombre, String primerApellido, String segundoApellido, String titulacion, double puntos) {
        super(nombre, primerApellido, segundoApellido);
        this.puntos = puntos;
        this.titulacion = titulacion;
    }
    
    //Setters y Getters
    public String getTitulacion() {return titulacion;}
    public void setTitulacion(String titulacion) {this.titulacion = titulacion;}
    public double getPuntos() {return puntos;}
    public void setPuntos(double puntos) {this.puntos = puntos;}
    
    //toString
    @Override
    public String toString() {
        return super.toString() + " Titulaci�n: " + titulacion + "\n Puntos: " + puntos + "\n\n";
    }

}
