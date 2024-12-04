package prac3.associacions;

import prac3.integrants.Membre;

public class Associacio {
    private String nombreAsociacion; // Nombre de la asociacion
    private String correoContactoAsociacion; // Correo de contacto de la asociacion
    private String[] titulacionesAsociacion; // Informacion de las titulaciones de la ETSE (GEB, GEI, GESST...)
    private Membre[] listaMiembrosAsociacion;
    private Membre[] personasEnCargos = new Membre[3]; // 0-> President; 1 -> Secretario; 2 -> Tesorero

    /**
     * 
     * @param nombre
     * @param correo
     * @param titulaciones
     * @param listaMiembros
     * @param persCargos
     */
    public Associacio(String nombre, String correo, String[] titulaciones, Membre[] listaMiembros, Membre[] persCargos) {
        nombreAsociacion = nombre;
        correoContactoAsociacion = correo;
        titulacionesAsociacion = titulaciones;
        listaMiembrosAsociacion = listaMiembros;
        personasEnCargos = persCargos;
    
    }

    /**
     * @return - Variable del nombre de la Asociación
     */
    public String getNombreAsociacion(){
        return nombreAsociacion;
    }
    
    /**
     * @return - Variable del correo de contacto de la Asociación
     */
    public String getCorreoContactoAsociacion(){
        return correoContactoAsociacion;
    }
    
    /**
     * @return - Variable de la titulación de la Asocia
     */
    public String[] getTitulacionesAsociacion(){
        return titulacionesAsociacion;
    }

    /**
     * @return - Variable 
     */
    public Membre[] getListaMiembrosAsociacion(){
        return listaMiembrosAsociacion;
    }

    /**
     * @return - Variable 
     */
    public Membre[] getPersonasEnCargo(){
        return personasEnCargos;
    }
}
