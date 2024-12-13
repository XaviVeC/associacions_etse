package prac3.Asociacion;
import prac3.Estructuras.Fecha;

public class Asociacion {
    private String nombreAsociacion; 
    private String correoContactoAsociacion; // Correo de contacto de la asociacion
    private String[] titulacionesAsociacion; 
    private String[] listaMiembrosAsociacion; 
    private Fecha[] fechasAlta, fechasBaja; 
    private String[] personasEnCargos; // 0-> Presidente; 1 -> Secretario; 2 -> Tesorero
    
    /**
     * Constructor de la clase Associacio
     * @param nombre - nombre de la asociacion
     * @param titulaciones - Lista de informacion de las titulaciones (GEB, GEI, GESST...)
     * @param listaMiembros - Listado de los miembros de la asociacion
     * @param persCargos - Nombre de las personas en los cargos correspondientes
     * @param fechaAlta - Lista de las fechas de alta de los miembros de la asociacion.
     * @param fechaBaja - Lista de las fechas de baja de los miembros de la asociacion.
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
     * @return - variable nombreAsociacion
     */
    public String getNombreAsociacion() {
        return nombreAsociacion;
    }

    /**
     * Getter del correo de contacto de la asociacion
     * @return - variable correoContactoAsociacion
     */
    public String getCorreoContactoAsociacion() {
        return correoContactoAsociacion;
    }

    /**
     * Getter de la lista de titulaciones de la asociacion
     * @return - variable titulacionesAsociacion
     */
    public String[] getTitulacionesAsociacion() {
        return titulacionesAsociacion;
    }

    /**
     * Getter de la lista de los miembros de la asociacion
     * @return - variable listaMiembrosAsociacion
     */
    public String[] getListaMiembrosAsociacion() {
        return listaMiembrosAsociacion;
    }

    /**
     * Getter de la lista de personas que ocupan los cargos altos
     * @return - variable personasEnCargos
     */
    public String[] getPersonasEnCargo() {
        return personasEnCargos;
    }

    /**
     * Getter de la lista de las fechas de alta de los miembros
     * @return - variable personasEnCargos
     */
    public Fecha[] getFechasAlta() {
        return fechasAlta;
    }

    /**
     * Getter de la lista de las fechas de baja de los miembros.
     * @return - variable personasEnCargos
     */
    public Fecha[] getFechasBaja() {
        return fechasBaja;
    }

    /**
     * Metodo que realiza una copia de una associacion en concreto
     * @return - copia de la instancia
     */
    public Asociacion copia() {
        return (new Asociacion(nombreAsociacion, titulacionesAsociacion, listaMiembrosAsociacion, personasEnCargos, fechasAlta, fechasBaja));
    }

    /**
     * toString del contenido de una asociacion
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
     * Metodo para ingresar un nuevo miembro dentro de una asociacion. 
     * En el caso que ya exista este alias en esta Asociacion no se añadira de nuevo
     * @param alias - nuevo alias a ingresar
     * @param fechaAlta - fecha en la que se da de alta el miembro en la asociacion
     * @param fechaBaja - se pasa por parametro la fecha 99/99/9999 ya que al darse de alta no hay intencion de darse de baja
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
            // Se crean nuevas tablas para los miembros de la asociacion i las fechas de alta y baja con un espacio mas que antes
            String[] nuevaLista = new String[listaMiembrosAsociacion.length + 1]; 
            Fecha[] nuevaListaFechaAlta = new Fecha[listaMiembrosAsociacion.length + 1];
            Fecha[] nuevaListaFechaBaja = new Fecha[listaMiembrosAsociacion.length + 1];
            
            // Se rellenan estas fechas con la informacion que ya tenian anteriormente, y se deja el ultimo espacio vacio
            for (int i = 0; i < listaMiembrosAsociacion.length; i++) {
                nuevaLista[i] = listaMiembrosAsociacion[i]; 
                nuevaListaFechaAlta[i] = fechasAlta[i];
                nuevaListaFechaBaja[i] = fechasBaja[i];
            }
            
            // Se rellena el ultimo espacio con los datos del nuevo miembro que se quiere inscribir en la asociacion
            nuevaLista[nuevaLista.length - 1] = alias;
            nuevaListaFechaAlta[nuevaLista.length - 1] = fechaAlta;
            nuevaListaFechaBaja[nuevaLista.length - 1] = fechaBaja;
            
            // Se guardan los atributos con la informacion nueva
            this.listaMiembrosAsociacion = nuevaLista;
            this.fechasAlta = nuevaListaFechaAlta;
            this.fechasBaja = nuevaListaFechaBaja;  
        }
    }
}
