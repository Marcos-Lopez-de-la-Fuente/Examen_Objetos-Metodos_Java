
public class Persona {
    // ATRIBUTOS
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private static int contadorNumeroPersonas;

    // CONSTRUCTORES
    public Persona(String nombre, String primerApellido, String segundoApellido) {
        Persona.contadorNumeroPersonas++;
        setId(Persona.contadorNumeroPersonas);
        setNombre(nombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
    }

    // GETTERS Y SETTERS
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getPrimerApellido() {return primerApellido;}
    public void setPrimerApellido(String primerApellido) {this.primerApellido = primerApellido;}
    public String getSegundoApellido() {return segundoApellido;}
    public void setSegundoApellido(String segundoApellido) {this.segundoApellido = segundoApellido;}

    //toString
    @Override
    public String toString() {
        return " ID: " + id + "\n Nombre: " + nombre + "\n Primer apellido: " + primerApellido + "\n Segundo apellido: " + segundoApellido + "\n\n";
    }
    
}

