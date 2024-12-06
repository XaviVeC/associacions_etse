package prac3.accions;
import prac3.estructures.Data;

public class Xerrada extends Accio {
    private final int MAXIMO_INSTRUCTORES = 3; // Limite maximo de las personas que imparten la charla
    private Data fechaRealizacion; // Fecha en la que se imparte la charla
    private String[] instructoresCharla = new String[MAXIMO_INSTRUCTORES]; // Instructores de la charla
    private int[] valoraciones; // Vector de valoraciones de la charla
    private int numeroDeAsistentes; // Numero de personas que asistieron a la charla

    /**
     * Constructor de la classe Xerrada
     * @param indiceFichero 
     * @param tipoAccion
     * @param nombreAccion
     * @param asociacionesInvolucradas
     * @param organizadorResponsable
     * @param fechaRealizacion
     * @param instructoresCharla
     * @param valoraciones
     * @param numeroDeAsistentes
     */
    public Xerrada(int indiceFichero, String tipoAccion, String nombreAccion, String[] asociacionesInvolucradas, String organizadorResponsable, Data fechaRealizacion, String[] instructoresCharla, int[] valoraciones, int numeroDeAsistentes) {
        super(indiceFichero, tipoAccion, nombreAccion, asociacionesInvolucradas, organizadorResponsable);
        this.fechaRealizacion = fechaRealizacion;
        this.instructoresCharla = instructoresCharla;
        this.valoraciones = valoraciones;
        if (numeroDeAsistentes < 0) {
            this.numeroDeAsistentes = -999;
        }
        else {
            this.numeroDeAsistentes = numeroDeAsistentes;
        }
    }

    /**
     * 
     * @return
     */
    public Data getFechaRealizacion() {
        return fechaRealizacion;
    }

    /**
     * 
     * @return
     */
    public String[] getInstructoresCharla() {
        return instructoresCharla;
    }

    /**
     * 
     * @return
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * 
     * @return
     */
    public int getNumeroAsistentes() {
        return numeroDeAsistentes;
    }

    /**
     * 
     * @param valoracion
     * @param indiceAsistente
     */
    public void addValoracion(int valoracion, int indiceAsistente) {
        if (valoraciones.length < this.numeroDeAsistentes) {
            this.valoraciones[indiceAsistente] = valoracion;
        }
    }

    /**
     * Metodo toString 
     * @return - Texto con los datos de la charla
     */
    public String toString() {
        String aux = "Nombre de la charla: " + this.nombreAccion + "\n" +
        "Codigo de la charla: " + this.getCodigoAccion() + "\n" +
        "Fecha de la charla: " + this.fechaRealizacion.toString() + "\n" + 
        "Organizador responsable: " + this.organizadorResponsable +"\n" +
        "el resto de involucrados fueron: ";
        for (int index = 0; index < instructoresCharla.length; index++) {
            aux = aux + "Instructor " + (index + 1) + ": " + instructoresCharla[index] + "\n";
        }
        aux = aux + "Las asociaciones que organizaron la charla fueron:\n";
        for (int index = 0; index < asociacionesInvolucradas.length; index++) {
            aux = aux + "Asociacion involucrada "+ (index + 1)+ ": " + this.asociacionesInvolucradas[index] + "\n";
        }

        aux = aux + "Asistieron un total de " + this.numeroDeAsistentes + " personas, y las valoraciones fueron\n";
        for (int index = 0; index < valoraciones.length; index++) {
            aux = aux + "Valoracion " + (index + 1) + ": " + valoraciones[index] + "\n";
        }
        return aux;
    }

    /**
     * Metodo copia
     * @return - copia de la instancia
     */
    public Xerrada copia() {
        return (new Xerrada(this.indiceFichero, this.tipoAccion, this.nombreAccion, this.asociacionesInvolucradas, this.organizadorResponsable,
                            this.fechaRealizacion, this.instructoresCharla, this.valoraciones, this.numeroDeAsistentes));
    }
}
