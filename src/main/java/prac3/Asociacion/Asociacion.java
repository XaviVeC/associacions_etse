package prac3.Asociacion;
import prac3.Estructuras.Fecha;

public class Asociacion {
    private String nombreAsociacion; // Nombre de la asociacion
    private String correoContactoAsociacion; // Correo de contacto de la asociacion
    private String[] titulacionesAsociacion; // Informacion de las titulaciones de la ETSE de la asociacion (GEB, GEI,
                                             // GESST...)
    private String[] listaMiembrosAsociacion; // Listado de miembros de la asociacion
    private String[] personasEnCargos; // Nombre de las personas en los cargos correspondientes de la aasociacion
                                       // 0-> President; 1 -> Secretario; 2 -> Tesorero
    private Fecha[] fechasAlta, fechasBaja;

    /**
     * Constructor de la clase Associacio
     * 
     * @param nombre        - nombre de la asociacion
     * @param titulaciones  - Lista de informacion de las titulaciones
     * @param listaMiembros - Listado de los miembros de la asociacion
     * @param persCargos    - Nombre de las personas en los cargos correspondientes
     * @param fechaAlta     - Lista de las fechas de alta de los miembros de la asociacion.
     * @param fechaBaja     - Lista de las fechas de baja de los miembros de la asociacion.
     */
    public Asociacion(String nombre, String[] titulaciones, String[] listaMiembros, String[] persCargos, Fecha[] fechaAlta, Fecha[] fechaBaja) {
        nombreAsociacion = nombre;
        correoContactoAsociacion = nombre + "@asociaciones.urv.cat";
        titulacionesAsociacion = titulaciones;
        listaMiembrosAsociacion = listaMiembros;
        personasEnCargos = persCargos;
        this.fechasAlta = fechaAlta;
        this.fechasBaja = fechaBaja;


    }

    /**
     * Getter del nombre de la asociacion
     * 
     * @return - variable nombreAsociacion
     */
    public String getNombreAsociacion() {
        return nombreAsociacion;
    }

    /**
     * Getter del correo de contacto de la asociacion
     * 
     * @return - variable correoContactoAsociacion
     */
    public String getCorreoContactoAsociacion() {
        return correoContactoAsociacion;
    }

    /**
     * Getter de la lista de titulaciones de la asociacion
     * 
     * @return - variable titulacionesAsociacion
     */
    public String[] getTitulacionesAsociacion() {
        return titulacionesAsociacion;
    }

    /**
     * Getter de la lista de los miembros de la asociacion
     * 
     * @return - variable listaMiembrosAsociacion
     */
    public String[] getListaMiembrosAsociacion() {
        return listaMiembrosAsociacion;
    }

    /**
     * Getter de la lista de personas que ocupan los cargos altos.
     * 
     * @return - variable personasEnCargos
     */
    public String[] getPersonasEnCargo() {
        return personasEnCargos;
    }


    /**
     * Getter de la lista de las fechas de alta de los miembros
     * 
     * @return - variable personasEnCargos
     */
    public Fecha[] getFechasAlta() {
        return fechasAlta;
    }

    /**
     * Getter de la lista de las fechas de baja de los miembros.
     * 
     * @return - variable personasEnCargos
     */
    public Fecha[] getFechasBaja() {
        return fechasBaja;
    }

    /**
     * Metodo que realiza una copia de una associacion en concreto
     * 
     * @return - variable asociacionCopia
     */
    public Asociacion copia() {
        Asociacion asociacionCopia = new Asociacion(nombreAsociacion, titulacionesAsociacion, listaMiembrosAsociacion,
                personasEnCargos, fechasAlta, fechasBaja);
        return asociacionCopia;
    }

    /**
     * toString del contenido de una asociacion
     * 
     * @return retorna el contenido de una asociacion en String
     */
    public String toString() {
        String aux = "\t\t\tNombre de la asociacion: " + nombreAsociacion + "\n" +
                "\t\t\tCorreo de la asociacion: " + correoContactoAsociacion + "\n" +
                "\t\t\tLas titulaciones involucradas son:\n";

        for (int i = 0; i < titulacionesAsociacion.length; i++) {
            aux = aux + "\t\t\t\tTitulacion " + (i + 1) + ": " + titulacionesAsociacion[i] + "\n";
        }
        aux = aux + "\t\t\tLos miembros son:\n";
        for (int i = 0; i < listaMiembrosAsociacion.length; i++) {
            aux = aux + "\t\t\t\tMiembro " + (i + 1) + ": " + listaMiembrosAsociacion[i] + " con fecha de alta de " + fechasAlta[i].toString();
            if (fechasBaja[i].getDia() != 99) {
                aux = aux + " se dio de baja el " + fechasBaja[i].toString() + "\n";
            }
            else{
                aux = aux + "\n";
            }
        }
        aux = aux + "\t\t\tLos cargos son:\n\t\t\t\tPresidente --> " + personasEnCargos[0] + "\n\t\t\t\tSecretario --> "
                + personasEnCargos[1] + "\n\t\t\t\tTesorero --> " + personasEnCargos[2] + "\n";

        return aux;
    }

    /**
     * Metodo para ingresar un nuevo miembro dentro de una asociacion. Para ello
     * creamos una nueva String[], con el contenido ue tenia, mas el nuevo alias
     * En el caso de que ya exista este aias en esta Asociacion no pasará nada.
     * @param alias - nuevo alias a ingresa
     */
    public void addMiembroEnAsociacion(String alias, Fecha fechaAlta, Fecha fechaBaja) {
        boolean encontrado = false;
        int indice = 0;
        while (!encontrado && (indice < listaMiembrosAsociacion.length)) {
            if (alias.equals(listaMiembrosAsociacion[indice])) {
                encontrado = true;
            } else {
                indice++;
            }
        }

        if (!encontrado) {
            
            String[] nuevaLista = new String[listaMiembrosAsociacion.length + 1];
            Fecha[] nuevaListaFechaAlta = new Fecha[listaMiembrosAsociacion.length + 1];
            Fecha[] nuevaListaFechaBaja = new Fecha[listaMiembrosAsociacion.length + 1];
            for (int i = 0; i < listaMiembrosAsociacion.length; i++) {
                nuevaLista[i] = listaMiembrosAsociacion[i];
                nuevaListaFechaAlta[i] = fechasAlta[i];
                nuevaListaFechaBaja[i] = fechasBaja[i];
            }
            nuevaLista[nuevaLista.length - 1] = alias;
            nuevaListaFechaAlta[nuevaLista.length - 1] = fechaAlta;
            nuevaListaFechaBaja[nuevaLista.length - 1] = fechaBaja;
            this.listaMiembrosAsociacion = nuevaLista;
            this.fechasAlta = nuevaListaFechaAlta;
            this.fechasBaja = nuevaListaFechaBaja;  
        }
    }
}
