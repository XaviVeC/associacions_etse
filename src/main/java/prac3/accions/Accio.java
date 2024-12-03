package prac3.accions;
import prac3.integrants.Membre;
import prac3.estructures.LlistaAssociacions;

public abstract class Accio {
    //3 primeras letras asociacion, seguidas de tres numeros a partir del 100.
    protected String codigoAccion;

    private String nombreAccion;
    //Asociaciones organizadoras de la accion
    private LlistaAssociacions asociacionesInvolucradas;
    //Miembro organizador de la accion
    private Membre organizadorResponsable;

    /**
     * Metodo del constructor de la clase accion
     * @param codigoAccion - Codigo que identifica la accion, 3 primeras letras nombre y 3 numeros
     * @param nombreAccion - Nombre que identifica la accion
     * @param asociacionesInvolucradas - Lista de asociaciones involucradas en la accion
     * @param organizadorResponsable - Responsable de la organización de la accion
     */
    public Accio (String nombreAccion, LlistaAssociacions asociacionesInvolucradas, Membre organizadorResponsable){
        this.nombreAccion = nombreAccion;
        this.asociacionesInvolucradas = asociacionesInvolucradas;
        this.organizadorResponsable = organizadorResponsable;




    }


    private static String generarCodigoAccion(String nombreAccion){
        
    }



    
    

}
