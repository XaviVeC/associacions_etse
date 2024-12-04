package prac3.accions;
import prac3.integrants.Membre;
import prac3.estructures.LlistaAssociacions;

public abstract class Accio {
    //3 primeras letras asociacion, seguidas de tres numeros a partir del 100.
    protected String codigoAccion;

    protected String nombreAccion;
    //Asociaciones organizadoras de la accion
    protected LlistaAssociacions asociacionesInvolucradas;
    //Miembro organizador de la accion
    protected Membre organizadorResponsable;
    protected int indiceLista;

    /**
     * Metodo del constructor de la clase accion
     * @param codigoAccion - Codigo que identifica la accion, 3 primeras letras nombre y 3 numeros
     * @param nombreAccion - Nombre que identifica la accion
     * @param asociacionesInvolucradas - Lista de asociaciones involucradas en la accion
     * @param organizadorResponsable - Responsable de la organizacion de la accion
     * @param indiceLista - Numero para generar el codigo
     */
    public Accio (String nombreAccion, LlistaAssociacions asociacionesInvolucradas, Membre organizadorResponsable, int indiceLista){
        this.nombreAccion = nombreAccion;
        this.asociacionesInvolucradas = asociacionesInvolucradas;
        this.organizadorResponsable = organizadorResponsable;
        codigoAccion = generarCodigoAccion(nombreAccion, indiceLista);
    }

    /**
     * Metodo que crea el codigo a partir del indice de la lista y el nombre
     * @param codigoAccion - Codigo que identifica la accion, 3 primeras letras nombre y 3 numeros
     * @param nombreAccion - Nombre que identifica la accion
     */
    private static String generarCodigoAccion(String nombreAccion, int numero){
        return nombreAccion.substring(0, 3) + (numero + 100);
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

    /**
     * Getter de la variable organizadorResponsable
     * @return - variable organizadorResponsable
     */
    public Membre getOrganizadorResponsable() {
        return organizadorResponsable;
    }

    /**
     * Getter de la variable asociacionesInvolucradas
     * @return - variable asociacionesInvolucradas
     */
    public LlistaAssociacions getAsociacionesInvolucradas() {
        return asociacionesInvolucradas;
    }

    public abstract Accio copia(); // Lo dejamos vacio
    public abstract String toString(); // Lo dejamos vacio
}
