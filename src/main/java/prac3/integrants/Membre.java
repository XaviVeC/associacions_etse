package prac3.integrants;
//Clase base 
public class Membre {

    //DADES
    private String nombreMiembro; // nombreMiembrobre del miembro 
    private String alias;// Alias del membre 
    private String correoMiembro;// Correo electronico del miembro 
    private Data fechaAlta; // Fecha en la que se da de alta 
    private Data fechaBaixa; // Fecha en la que se da de baja

    //MÉTODES
    
    /**
     * Metodo constructor de la clase Membre
     * @param nombreMiembro - nombreMiembrobre del miembro
     * @param alias - Alias del nombreMiembrobre del miembro
     * @param correoMiembro - Correo del miembro
     * @param fechaAlta - Fecha en la que se dio de alta
     * @param fechaBaixa - Fecha en la que se dio de baja
     * @return - Constructor Membre
     */
    public Membre (String nombreMiembro, String alias, String correoMiembro, Data fechaAlta, Data fechaBaixa){
        this.nombreMiembro = nombreMiembro;
        this.alias = alias;
        this.correoMiembro = correoMiembro;
        this.fechaAlta = fechaAlta;
        this.fechaBaixa = fechaBaixa;

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
     * @return - dia, mes y año en el que se dio de alta
     */
    public Data getFechaAlta(){
        return fechaAlta;
    }

    /**
     * Getter de la fecha exacta en la que se dio de baja
     * @return - dia, mes y año en el que se dio de baja
     */
    public Data getFechaBaja(){
        return fechaBaixa;
    }

    /**
     * Metodo que da de alta a un miembro, lo unico que hace es guardar la fecha que se le pasa en los parametros del alta
     * @param fechaAlta - variable fechaAlta
     */
    public void donarDeAlta(Data fechaAlta){
        //Comprobar que el membre no esta ja donat de alta
        if (this.fechaAlta == null){
            this.fechaAlta = fechaAlta;
        }
    }

    /**
     * Metodo que da de baja a un miembro, lo unico que hace es guardar la fecha que se le pasa en los parametros de la baja
     * @param fechaBaixa - variable fechaBaixa
     */
    public void donarDeBaixa(Data fechaBaixa){
        //Comprobar que el membre esta donat de Alta 
        if ((this.fechaAlta != null) && (this.fechaBaixa == null)){
            //Comprobar que no estiga donat de baixa 
            this.fechaBaixa = fechaBaixa;  
        }
    }
    

    public Membre copia(){
        Membre membreCopiat = new Membre(getnombreMiembro(),getAlias(),getCorreoMiembro(),getFechaAlta(),getFechaBaja());
        return membreCopiat;
    }



    
}
