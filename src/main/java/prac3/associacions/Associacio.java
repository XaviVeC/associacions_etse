package prac3.associacions;


public class Associacio {
    private String nombreAsociacion; // Nombre de la asociacion
    private String correoContactoAsociacion; // Correo de contacto de la asociacion
    private String[] titulacionesAsociacion; // Informacion de las titulaciones de la ETSE de la asociacion (GEB, GEI, GESST...)
    private String[] listaMiembrosAsociacion; // Listado de miembros de la asociacion
    private String[] personasEnCargos; // Nombre de las personas en los cargos correspondientes de la aasociacion
                                                       // 0-> President; 1 -> Secretario; 2 -> Tesorero

    /**
     * Constructor de la clase Associacio
     * @param nombre - nombre de la asociacion
     * @param correo - correo de contacto de la asociacion
     * @param titulaciones - Lista de informacion de las titulaciones
     * @param listaMiembros - Listado de los miembros de la asociacion
     * @param persCargos - Nombre de las personas en los cargos correspondientes
     */
    public Associacio(String nombre, String correo, String[] titulaciones, String[] listaMiembros, String[] persCargos) {
        nombreAsociacion = nombre;
        correoContactoAsociacion = correo;
        titulacionesAsociacion = titulaciones;
        listaMiembrosAsociacion = listaMiembros;
        personasEnCargos = persCargos;
    
    }

    /**
     * Getter del nombre de la asociacion
     * @return - variable nombreAsociacion
     */
    public String getNombreAsociacion(){
        return nombreAsociacion;
    }
    
    /**
     * Getter del correo de contacto de la asociacion
     * @return - variable correoContactoAsociacion
     */
    public String getCorreoContactoAsociacion(){
        return correoContactoAsociacion;
    }
    
    /**
     * Getter de la lista de titulaciones de la asociacion
     * @return - variable titulacionesAsociacion
     */
    public String[] getTitulacionesAsociacion(){
        return titulacionesAsociacion;
    }

    /**
     * Getter de la lista de los miembros de la asociacion
     * @return - variable listaMiembrosAsociacion
     */
    public String[] getListaMiembrosAsociacion(){
        return listaMiembrosAsociacion;
    }

    /**
     * Getter de la lista de personas que ocupan los cargos altos.
     * @return - variable personasEnCargos
     */
    public String[] getPersonasEnCargo(){
        return personasEnCargos;
    }

    /**
     * Metodo que realiza una copia de una associacion en concreto
     * @return - variable asociacionCopia
     */
    public Associacio copia(){
        Associacio asociacionCopia = new Associacio(nombreAsociacion, correoContactoAsociacion, titulacionesAsociacion, listaMiembrosAsociacion, personasEnCargos);
        return asociacionCopia;
    }

    /**
     * toString del contenido de una asociacion
     * @return retorna el contenido de una asociacion en String
     */
    public String toString()
    {
        String aux = "\t\t\tNombre de la asociacion: " + nombreAsociacion +"\n" +
            "\t\t\tCorreo de la asociacion: " + correoContactoAsociacion +"\n"+
            "\t\t\tLas titulaciones involucradas son:\n";

        for (int i = 0; i < titulacionesAsociacion.length; i++) {
            aux = aux + "\t\t\t\tTitulacion " + (i + 1)+ ": "+ titulacionesAsociacion[i] + "\n";
        }
        aux = aux + "\t\t\tLos miembros son:\n";
        for (int i = 0; i < listaMiembrosAsociacion.length; i++) {
            aux = aux + "\t\t\t\tMiembro " + (i + 1)+ ": "+ listaMiembrosAsociacion[i] + "\n";
        }
        aux = aux + "\t\t\tLos cargos son:\n\t\t\t\tPresidente --> " + personasEnCargos[0] +"\n\t\t\t\tSecretario --> " + personasEnCargos[1] +"\n\t\t\t\tTesorero --> " + personasEnCargos[2] + "\n";
        
        return aux;
    }
}
