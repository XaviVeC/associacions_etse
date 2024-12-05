package prac3.accions;
import prac3.estructures.Data;

public class Xerrada extends Accio {
    private final int MAXIMO_INSTRUCTORES = 3; // Limite maximo de las personas que imparten la charla
    private Data fechaRealizacion; // Fecha en la que se imparte la charla
    private String[] instructoresCharla = new String[MAXIMO_INSTRUCTORES]; // Instructores de la charla
    private int[] valoraciones; // Vector de valoraciones de la charla
    private int numeroDeAsistentes; // Numero de personas que asistieron a la charla

    /**
     * 
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
    public void aniadirValoracion(int valoracion, int indiceAsistente) {
        if (valoraciones.length < this.numeroDeAsistentes) {
            this.valoraciones[indiceAsistente] = valoracion;
        }
    }

    /**
     * Metodo toString 
     * @return texto con los datos de la charla
     */
    public String toString(){
        String aux = "Nombre de la charla: " + this.getNombreAccion() + "\n" +
                     "Asociaciones involucradas: " + this.getAsociacionesInvolucradas().toString() + "\n" +
                     "Organizador responsable: " + this.getOrganizadorResponsable() + "\n" +
                     "Fecha de la celebracion: " + fechaRealizacion.toString() + "\n" + "Numero de asistentes: " + this.numeroDeAsistentes + "\n";

        for(int i = 0; i < this.instructoresCharla.length; i++)
        {
            aux = aux + "El instructor "+ (i+1) +"es" + this.instructoresCharla[i].toString() + "\n";
        }
        
        for(int i = 0; i < this.valoraciones.length; i++)
        {
            aux = aux + "La valoracion numero "+ (i+1) +" es " + this.valoraciones[i] + "\n";
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
