package prac3.Accion;

import prac3.Estructuras.Fecha;

public class Charla extends Accion {
    private final int MAXIMO_INSTRUCTORES = 3; // Limite maximo de las personas que imparten la charla
    private Fecha fechaRealizacion; // Fecha en la que se imparte la charla
    private String[] instructoresCharla = new String[MAXIMO_INSTRUCTORES]; // Instructores de la charla
    private int[] valoraciones; // Vector de valoraciones de la charla
    private int numeroDeAsistentes; // Numero de personas que asistieron a la charla
    private int sumaValoraciones;
    private int indiceValoraciones;

    /**
     * Constructor de la classe Charla para una charla que ya se ha dado
     * 
     * @param indiceFichero
     * @param tipoAccion
     * @param nombreAccion
     * @param asociacionesInvolucradas
     * @param organizadorResponsable
     * @param fechaRealizacion
     * @param instructoresCharla
     * @param numeroDeAsistentes
     */
    public Charla(int indiceFichero, String tipoAccion, String nombreAccion, String[] asociacionesInvolucradas,
            String organizadorResponsable, Fecha fechaRealizacion, String[] instructoresCharla,
            int numeroDeAsistentes) {
        super(indiceFichero, tipoAccion, nombreAccion, asociacionesInvolucradas, organizadorResponsable);
        this.fechaRealizacion = fechaRealizacion;
        this.instructoresCharla = instructoresCharla;
        if (numeroDeAsistentes < 0) {
            this.numeroDeAsistentes = -999;
        } else {
            this.numeroDeAsistentes = numeroDeAsistentes;
        }
        this.valoraciones = new int[numeroDeAsistentes];
        indiceValoraciones = 0;
    }




    public Charla(int indiceFichero, String tipoAccion, String nombreAccion, String[] asocInvol, 
                  String organizadorResponsable, Fecha fechaRealizacion, String[] instructoresCharla) {
        super(indiceFichero, tipoAccion, nombreAccion, asocInvol, organizadorResponsable);
        this.fechaRealizacion = fechaRealizacion;
        this.instructoresCharla = instructoresCharla;
        this.numeroDeAsistentes = 0;
        this.valoraciones = new int[numeroDeAsistentes];
        indiceValoraciones = 0;
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
    public Fecha getFecha() {
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
     * @return 
     */
    public int getIndiceValoraciones (){
        return indiceValoraciones;
    }

    /**
     * @return 
     */
    public int getSumaValoraciones(){
        return sumaValoraciones;

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
        if (this.valoraciones != null) {
            for (int index = 0; index < valoraciones.length; index++) {
                aux = aux + "\t\t\t\tValoracion " + (index + 1) + ": " + valoraciones[index] + "\n";
            }
        }
        return aux;
    }

    /**
     * Metodo copia
     * 
     * @return - copia de la instancia
     */
    public Charla copia() {
        return (new Charla(this.indiceFichero, this.tipoAccion, this.nombreAccion, this.asociacionesInvolucradas,
                this.organizadorResponsable,
                this.fechaRealizacion, this.instructoresCharla, this.numeroDeAsistentes));
    }

    /**
     * Método para hacer una valoracion de la charla 
     * 
     */
    public void hacerValoracion(int valoracion){
        if(this.indiceValoraciones < this.numeroDeAsistentes)
        {
            valoraciones[this.indiceValoraciones] = valoracion;
            this.sumaValoraciones += valoracion;
            this.indiceValoraciones++;
        }
    }
   
    
}