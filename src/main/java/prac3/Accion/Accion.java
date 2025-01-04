package prac3.Accion;

import prac3.Estructuras.Fecha;

public abstract class Accion {

    protected String codigoAccion; // 3 primeras letras asociacion, seguidas de tres numeros a partir del 100.
    protected String tipoAccion; // tipo de la acción, "demostracion" o "charla"
    protected String nombreAccion; // nombre de la acción
    protected String[] asociacionesInvolucradas; // nombres de las asociaciones involucradas
    protected String organizadorResponsable; // nombre del organizador
    protected int indiceFichero; // indice para crear el "codigoAccion"

    /**
     * Metodo del constructor de la clase accion
     * 
     * @param tipoAccion               - Si es Demostracio o Xerrada
     * @param nombreAccion             - Nombre que identifica la accion
     * @param asociacionesInvolucradas - Lista de asociaciones involucradas en la
     *                                 accion
     * @param organizadorResponsable   - Responsable de la organizacion de la accion
     * @param indiceFichero            - Numero para generar el codigo
     */
    public Accion(int indiceFichero, String tipoAccion, String nombreAccion, String[] asociacionesInvolucradas,
            String organizadorResponsable) {
        this.nombreAccion = nombreAccion;
        this.tipoAccion = tipoAccion;
        this.asociacionesInvolucradas = asociacionesInvolucradas;
        this.organizadorResponsable = organizadorResponsable;
        this.indiceFichero = indiceFichero;
        codigoAccion = generarCodigoAccion(asociacionesInvolucradas[0], indiceFichero);
    }

    /**
     * Metodo que crea el codigo a partir del indice de la lista y el nombre
     * 
     * @param numero           - Codigo que identifica la accion, 3 primeras letras
     *                         nombre y 3 numeros
     * @param nombreAsociacion - Nombre que identifica la accion
     */
    private static String generarCodigoAccion(String nombreAsociacion, int numero) {
        return nombreAsociacion.substring(0, 3) + (numero + 100);
    }

    /**
     * Getter de la variable codigoAccion
     * 
     * @return - variable codigoAccion
     */
    public String getCodigoAccion() {
        return codigoAccion;
    }

    /**
     * Getter de la variable indiceFichero
     * 
     * @return
     */
    public int getIndiceFichero() {
        return indiceFichero;
    }

    /**
     * Getter de la variable nombreAccion
     * 
     * @return - variable nombreAccion
     */
    public String getNombreAccion() {
        return nombreAccion;
    }

    /**
     * Getter de la variable tipoAccion
     * 
     * @return - variable tipoAccion
     */
    public String getTipoAccion() {
        return tipoAccion;
    }

    /**
     * Getter de la variable organizadorResponsable
     * 
     * @return - variable organizadorResponsable
     */
    public String getOrganizadorResponsable() {
        return organizadorResponsable;
    }

    /**
     * Getter de la variable asociacionesInvolucradas
     * 
     * @return - variable asociacionesInvolucradas
     */
    public String[] getAsociacionesInvolucradas() {
        return asociacionesInvolucradas;
    }

    /**
     * Se deja vacio para que se haga la copia segun si es charla o demostracion
     * 
     * @return - copia de la accion
     */
    public abstract Accion copia();

    /**
     * Se deja vacio para que se haga el toString segun si es charla o demostracion
     * 
     * @return - informacion de la accion en forma de String
     */
    public abstract String toString();

    /**
     * Para manejar las fechas de las clases hijas
     * 
     * @return - fecha que se necesite de la clase hija
     */
    public abstract Fecha getFecha();
}
