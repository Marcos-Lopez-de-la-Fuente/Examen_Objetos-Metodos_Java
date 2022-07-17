
public class Sanitario extends Persona{
    //Atributos
    private String especialidad;
    private int diastrabajados;

    //Constructores
    public Sanitario(String nombre, String primerApellido, String segundoApellido, String especialidad, int diasTrabajados){
        super(nombre, primerApellido, segundoApellido);
        this.especialidad = especialidad;
        this.diastrabajados = diasTrabajados;
    }

    //Setters y Getters
    public String getEspecialidad() {return especialidad;}
    public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}
    public int getDiastrabajados() {return diastrabajados;}
    public void setDiastrabajados(int diastrabajados) {this.diastrabajados = diastrabajados;}

    //toString
    @Override
    public String toString() {
        return super.toString() + " Epecialidad: " + especialidad + "\n Dias trabajados: " + diastrabajados + "\n\n";
    }
    
}