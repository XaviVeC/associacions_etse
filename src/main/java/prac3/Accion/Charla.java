package prac3.Accion;

import prac3.Estructuras.Fecha;

public class Charla extends Accion {
    private final int MAXIMO_INSTRUCTORES = 3; // Limite maximo de las personas que imparten la charla
    private Fecha fechaRealizacion; // Fecha en la que se realiza o está prevista la charla
    private String[] instructoresCharla = new String[MAXIMO_INSTRUCTORES];
    private int[] valoraciones; // Vector de valoraciones de la charla
    private int numeroDeAsistentes; // Numero de personas que asistieron.
    private int indiceValoraciones; // Indice de las valoraciones realizadas para guardar el tamaño del vector

    /**
     * Constructor para las charlas que ya estan valoradas
     * 
     * @param indiceFichero            - Indice que se lee en el ficher
     * @param nombreAccion             - Nombre de la charla
     * @param asociacionesInvolucradas - Asociaciones organizadoras
     * @param organizadorResponsable   - Organizadores de la charla
     * @param fechaRealizacion         - Fechas en la que se ha hecho la charla
     * @param instructoresCharla       - Instructores que impartieron la charla
     * @param numeroDeAsistentes       - Numero de asistentes
     * @param valoraciones             - Lista de las valoraciones
     * @param numeroValoraciones       - Numero de valorciones (max. una por
     *                                 asistente)
     */
    public Charla(int indiceFichero, String nombreAccion, String[] asociacionesInvolucradas,
            String organizadorResponsable, Fecha fechaRealizacion, String[] instructoresCharla,
            int[] valoraciones, int numeroDeAsistentes, int numeroValoraciones) {

        super(indiceFichero, "Charla", nombreAccion, asociacionesInvolucradas, organizadorResponsable);
        this.fechaRealizacion = fechaRealizacion;
        this.instructoresCharla = instructoresCharla;
        this.numeroDeAsistentes = numeroDeAsistentes;
        this.valoraciones = new int[numeroDeAsistentes];

        if (numeroValoraciones != 0) {
            for (int i = 0; i < numeroValoraciones; i++) {
                this.valoraciones[i] = valoraciones[i];
            }
        }

        indiceValoraciones = numeroValoraciones;
    }

    /**
     * Getter de los instructores de la charla
     * 
     * @return - tabla de String con los alias de los instructores de la charla
     */
    public String[] getInstructoresCharla() {
        return instructoresCharla;
    }

    /**
     * Getter de la fecha en la que se hace la charla
     * 
     * @return - variable fechaRealizacion
     */
    public Fecha getFecha() {
        return fechaRealizacion;
    }

    /**
     * Getter de las valoraciones de la charla
     * 
     * @return - tabla de enteros con las valoraciones que se le han puesto a la
     *         charla
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * Getter del numero de asistentes de la charla
     * 
     * @return - variable numeroDeAsistentes
     */
    public int getNumeroAsistentes() {
        return numeroDeAsistentes;
    }

    /**
     * Getter del indice de las valoraciones realizadas
     * 
     * @return - variable indiceValoraciones
     */
    public int getIndiceValoraciones() {
        return indiceValoraciones;
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

        if (this.numeroDeAsistentes != 0) {
            aux = aux + "\t\t\tAsistieron un total de " + this.numeroDeAsistentes + " personas.\n";
        }

        if (this.indiceValoraciones != 0) {
            aux = aux + "\t\t\tLas valoraciones fueron\n";

            for (int index = 0; index < indiceValoraciones; index++) {
                aux = aux + "\t\t\t\tValoracion " + (index + 1) + ": " + valoraciones[index] + "\n";
            }
        } else {
            aux = aux + "\t\t\tLa charla no ha sido valorada\n";
        }

        if (this.indiceValoraciones < this.numeroDeAsistentes) {
            aux = aux + "\t\t\tPuedes valorar la charla (para valorar introduce un 14).\n";
        }

        return aux;
    }

    /**
     * Metodo copia
     * 
     * @return - copia de la instancia
     */
    public Charla copia() {
        return (new Charla(this.indiceFichero, this.nombreAccion, this.asociacionesInvolucradas,
                this.organizadorResponsable, this.fechaRealizacion, this.instructoresCharla,
                this.valoraciones, this.numeroDeAsistentes, this.indiceValoraciones));
    }

    /**
     * Metodo para valorar una charla
     * 
     * @param valoracion - Numero de la valoracion del 1 al 10
     */
    public void hacerValoracion(int valoracion) {
        if (this.indiceValoraciones < this.numeroDeAsistentes && (valoracion > 0 && valoracion <= 10)) {
            valoraciones[this.indiceValoraciones] = valoracion;
            this.indiceValoraciones++;
        }
    }

    /**
     * Metodo que retorna la media de las valoraciones
     * 
     * @return - Media de las valoraciones
     */
    public double mediaValoraciones() {
        double acumulado = 0.0;
        if (this.indiceValoraciones > 0) {
            for (int i = 0; i < this.indiceValoraciones; i++) {
                acumulado += this.valoraciones[i];
            }
        }
        return acumulado / this.indiceValoraciones;
    }

}