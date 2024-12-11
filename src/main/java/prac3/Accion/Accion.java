package prac3.Accion;

import prac3.Estructuras.Fecha;
public abstract class Accion {
    //3 primeras letras asociacion, seguidas de tres numeros a partir del 100.
    protected String codigoAccion;
    protected String tipoAccion;
    protected String nombreAccion;
    //Asociaciones organizadoras de la accion
    protected String[] asociacionesInvolucradas;
    //Miembro organizador de la accion
    protected String organizadorResponsable;
    protected int indiceFichero;

    /**
     * Metodo del constructor de la clase accion
     * @param tipoAccion - Si es Demostracio o Xerrada
     * @param nombreAccion - Nombre que identifica la accion
     * @param asociacionesInvolucradas - Lista de asociaciones involucradas en la accion
     * @param organizadorResponsable - Responsable de la organizacion de la accion
     * @param indiceFichero - Numero para generar el codigo
     */
    public Accion (int indiceFichero, String tipoAccion, String nombreAccion, String[] asociacionesInvolucradas, String organizadorResponsable){
        this.nombreAccion = nombreAccion;
        this.tipoAccion = tipoAccion;
        this.asociacionesInvolucradas = asociacionesInvolucradas;
        this.organizadorResponsable = organizadorResponsable;
        codigoAccion = generarCodigoAccion(asociacionesInvolucradas[0], indiceFichero);
    }

    /**
     * Metodo que crea el codigo a partir del indice de la lista y el nombre
     * @param numero - Codigo que identifica la accion, 3 primeras letras nombre y 3 numeros
     * @param nombreAsociacion - Nombre que identifica la accion
     */
    private static String generarCodigoAccion(String nombreAsociacion, int numero){
        return nombreAsociacion.substring(0, 3) + (numero + 100);
    }

    /**
     * Getter de la variable codigoAccion
     * @return - variable codigoAccion
     */
    public String getCodigoAccion() {
        return codigoAccion;
    }

    /**
     * Getter de la variable nombreAccion
     * @return - variable nombreAccion
     */
    public String getNombreAccion() {
        return nombreAccion;
    }

    public String getTipoAccion(){
        return tipoAccion;
    }


    /** Getter de la variable organizadorResponsable
     * @return - variable organizadorResponsable
     */
    public String getOrganizadorResponsable() {
        return organizadorResponsable;
    }

    /**
     * Getter de la variable asociacionesInvolucradas
     * @return - variable asociacionesInvolucradas
     */
    public String[] getAsociacionesInvolucradas() {
        return asociacionesInvolucradas;
    }

    public abstract Accion copia(); // Lo dejamos vacio
    public abstract String toString(); // Lo dejamos vacio
    public abstract Fecha getFecha(); //para manejar las fechas de las clases hijas

}
