package prac3.integrants;
import prac3.estructures.Data;
//Clase base 
public abstract class Membre {

    //DADES
    protected int indiceFichero; // Identificador dentro del fichero
    protected String tipoMiembro; // indica si es Professor o Alumne
    protected String nombreMiembro; // nombre del miembro 
    protected String alias;// Alias del membre 
    protected String correoMiembro;// Correo electronico del miembro 
    protected Data fechaAlta; // Fecha en la que se da de alta 
    protected Data fechaBaixa; // Fecha en la que se da de baja
    //MÉTODES
    
    /**
     * Metodo constructor de la clase Membre
     * @param indiceFichero - identificador dentro del fichero
     * @param tipoMiembro - si es Alumne o Professor
     * @param nombreMiembro - nombreMiembrobre del miembro
     * @param alias - Alias del nombreMiembrobre del miembro
     * @param correoMiembro - Correo del miembro
     * @param fechaAlta - Fecha en la que se dio de alta
     * @param fechaBaixa - Fecha en la que se dio de baja
     * @return - Constructor Membre
     */
    public Membre (int indiceFichero, String tipoMiembro, String nombreMiembro, String alias, String correoMiembro, Data fechaAlta, Data fechaBaixa){
        this.indiceFichero = indiceFichero;
        this.tipoMiembro = tipoMiembro;
        this.nombreMiembro = nombreMiembro;
        this.alias = alias;
        this.correoMiembro = correoMiembro;
        this.fechaAlta = fechaAlta;
        this.fechaBaixa = fechaBaixa;

    }

    /**
     * Getter de la variable indiceFiechero
     * @return - variable indiceFichero
     */
    public int getIndiceFichero() {
        return indiceFichero;
    }

    /**
     * Getter de la variable tipoMiembro
     * @return - variable tipoMiembro
     */
    public String getTipoMiembro() {
        return tipoMiembro;
    }

    /**
     * Getter de la variable nombreMiembro
     * @return - variable nombreMiembro
     */
    public String getnombreMiembro() {
        return nombreMiembro;
    }

    /**
     * Getter de la variable alias
     * @return - variable alias
     */
    public String getAlias(){
        return alias;
    }

    /**
     * Getter de la variable correoMiembro
     * @return - variable correoMiembro
     */
    public String getCorreoMiembro(){
        return correoMiembro;
    }

    /**
     * Getter de la fecha exacta en la que se dio de alta
     * @return - fecha en el que se dio de alta
     */
    public Data getFechaAlta(){
        return fechaAlta;
    }

    /**
     * Getter de la fecha exacta en la que se dio de baja
     * @return - fecha en el que se dio de baja
     */
    public Data getFechaBaja(){
        return fechaBaixa;
    }
    
    /**
     * Metodo que hace una copia de un miembro
     * @return - miembro copiado
     */
    public abstract Membre copia();

    /**
     * Metodo imprime los datos de un miembro en concreto
     * @return - datos de un miembro en concreto por pantalla
     */
    public abstract String toString();


    

    //Funcion buscar miembro a partir de alias
    //Esta, 
    //SI no esta




}
