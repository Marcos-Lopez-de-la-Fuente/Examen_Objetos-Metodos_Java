
import java.util.ArrayList;

public class Plaza {
    // ATRIBUTOS
    private static int contadorId;
    private int id;
    private char tipo;
    private boolean adjudicada;
    private Persona persona;

    // CONSTRUCTORES
    public Plaza(char tipo) {
        Plaza.contadorId++;
        setId(Plaza.contadorId);
        setTipo(tipo);
        setAdjudicada(false);
        setPersona(null);
    }

    //Setters y Getters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public char getTipo() {return tipo;}
    public void setTipo(char tipo) {this.tipo = tipo;}
    public boolean isAdjudicada() {return adjudicada;}
    public void setAdjudicada(boolean adjudicada) {this.adjudicada = adjudicada;}
    public Persona getPersona() {return persona;}
    public void setPersona(Persona persona) {this.persona = persona;}
    
    @Override
	public String toString() {
		return "Plaza [id=" + id + ", tipo=" + tipo + ", adjudicada=" + adjudicada + ", persona=" + persona + "]";
	}

    //M�todos
    public static void adjudicarPlazas(ArrayList<Plaza> plazas, ArrayList<Persona> personas){    
        for (int index = 0; index < plazas.size(); index++) {
            int puntosPlaza = 0;
            int diasPlaza = 0;
            Persona encontrado = null;
            int numeroEncontrado = -1;
            for (int j = 0; j < personas.size(); j++) {
                if (plazas.get(index).getTipo() == 'D' && personas.get(j) instanceof Docente && ((Docente) personas.get(j)).getPuntos() > puntosPlaza) {
                    puntosPlaza = (int) ((Docente) personas.get(j)).getPuntos();
                    encontrado = personas.get(j);
                    numeroEncontrado = j;
                } else if (plazas.get(index).getTipo() == 'S' && personas.get(j) instanceof Sanitario && ((Sanitario)personas.get(j)).getDiastrabajados() > diasPlaza) {
                    diasPlaza = (int) ((Sanitario) personas.get(j)).getDiastrabajados();
                    encontrado = personas.get(j);
                    numeroEncontrado = j;
                }
            }
            boolean personaEncontrada = false;
            for (int n = 0; n < plazas.size(); n++) {
                if (plazas.get(n).getPersona() == encontrado) {
                    personaEncontrada = true;
                }
            }
            if (!personaEncontrada) {
                plazas.get(index).setPersona(encontrado);
                plazas.get(index).setAdjudicada(true);
            }
            if (numeroEncontrado != -1) {
            	personas.remove(numeroEncontrado);
            }
        }
    }

    public static void mostrarAdjudicaciones(ArrayList<Plaza> plazas){
        System.out.println("Sanitarios: ");
        for (int i = 0; i < plazas.size(); i++) {
            if(plazas.get(i).getTipo() == 'S') {
                System.out.println(plazas.get(i).toString());
            }
        }
        System.out.println("=====================");
        System.out.println("Docentes");
        for (int i = 0; i < plazas.size(); i++) {
            if(plazas.get(i).getTipo() == 'D') {
                System.out.println(plazas.get(i).toString());
            }
        }
    }

	public static void simularAdjudicacion() {
        Sanitario sanitario1 = new Sanitario("Marcos", "L�pez", "Fuente", "Biologia", 40);
        Sanitario sanitario2 = new Sanitario("Juan", "Perez", "Pepe", "Ciencias", 50);
        Sanitario sanitario3 = new Sanitario("Miquel", "Aba", "Rafel", "Historia", 60);
        
        Docente docente1 = new Docente("Miguel", "Marcos", "Nazco","Literatura", 7.7);
        Docente docente2 = new Docente("Alba", "Melissa", "Pepe","Ciencias", 7.1);
        Docente docente3 = new Docente("Manel", "Marcos", "Marc","Historia", 3.6);
        
        Plaza plaza1 = new Plaza('S');
        Plaza plaza2 = new Plaza('S');
        Plaza plaza3 = new Plaza('D');
        Plaza plaza4 = new Plaza('D');
        Plaza plaza5 = new Plaza('D');
        Plaza plaza6 = new Plaza('D');
        Plaza plaza7 = new Plaza('D');

        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add((Persona)sanitario1);
        personas.add((Persona)sanitario2);
        personas.add((Persona)sanitario3);
        personas.add((Persona)docente1);
        personas.add((Persona)docente2);
        personas.add((Persona)docente3);
        
        ArrayList<Plaza> plazas = new ArrayList<Plaza>();
        plazas.add(plaza1);
        plazas.add(plaza2);
        plazas.add(plaza3);
        plazas.add(plaza4);
        plazas.add(plaza5);
        plazas.add(plaza6);
        plazas.add(plaza7);
        

        adjudicarPlazas(plazas, personas);
        mostrarAdjudicaciones(plazas);
    }

    public static void main(String[] args) {
        simularAdjudicacion();
    }
}
