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
    public Xerrada(int indiceFichero, String tipoAccion, String nombreAccion, String[] asociacionesInvolucradas,
            String organizadorResponsable, Data fechaRealizacion, String[] instructoresCharla, int[] valoraciones,
            int numeroDeAsistentes) {
        super(indiceFichero, tipoAccion, nombreAccion, asociacionesInvolucradas, organizadorResponsable);
        this.fechaRealizacion = fechaRealizacion;
        this.instructoresCharla = instructoresCharla;
        this.valoraciones = valoraciones;
        if (numeroDeAsistentes < 0) {
            this.numeroDeAsistentes = -999;
        } else {
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
     * Getter de la fecha en la que se hace la charla
     */
    public Data getFecha() {
        return this.fechaRealizacion;
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
     * 
     * @return - Texto con los datos de la charla
     */
    public String toString() {
        String aux = "\t\t\tNombre de la charla: " + this.nombreAccion + "\n" +
                "\t\t\tCodigo de la charla: " + this.codigoAccion + "\n" +
                "\t\t\tFecha de la charla: " + this.fechaRealizacion.toString() + "\n" +
                "\t\t\tOrganizador responsable: " + this.organizadorResponsable + "\n" +
                "\t\t\tLos instructores de la charla son:\n";
        for (int index = 0; index < instructoresCharla.length; index++) {
            aux = aux + "\t\t\t\tInstructor " + (index + 1) + ": " + instructoresCharla[index] + "\n";
        }
        aux = aux + "\t\t\tLas asociaciones que organizaron la charla fueron:\n";
        for (int index = 0; index < asociacionesInvolucradas.length; index++) {
            aux = aux + "\t\t\t\tAsociacion involucrada " + (index + 1) + ": " + this.asociacionesInvolucradas[index]
                    + "\n";
        }

        aux = aux + "\t\t\tAsistieron un total de " + this.numeroDeAsistentes
                + " personas.\n\t\t\tLas valoraciones fueron\n";
        for (int index = 0; index < valoraciones.length; index++) {
            aux = aux + "\t\t\t\tValoracion " + (index + 1) + ": " + valoraciones[index] + "\n";
        }
        return aux;
    }

    /**
     * Metodo copia
     * 
     * @return - copia de la instancia
     */
    public Xerrada copia() {
        return (new Xerrada(this.indiceFichero, this.tipoAccion, this.nombreAccion, this.asociacionesInvolucradas,
                this.organizadorResponsable,
                this.fechaRealizacion, this.instructoresCharla, this.valoraciones, this.numeroDeAsistentes));
    }
}
