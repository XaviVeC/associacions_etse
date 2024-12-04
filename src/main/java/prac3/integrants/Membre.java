package prac3.integrants;
//Clase base 
public class Membre {

    //DADES
    private String nom; // Nombre del miembro 
    private String alias;// Alias del membre 
    private String correu;// Correo electronico del miembro 
    private Data dataAlta; // Fecha en la que se da de alta 
    private Data dataBaixa; // Fecha en la que se da de baja

    //MÉTODES
    
    /**
     * Metodo constructor de la clase Membre
     * @param nom - Nombre del miembro
     * @param alias - Alias del nombre del miembro
     * @param correu - Correo del miembro
     * @param dataAlta - Fecha en la que se dio de alta
     * @param dataBaixa - Fecha en la que se dio de baja
     * @return - Constructor Membre
     */
    public Membre (String nom, String alias, String correu, Data dataAlta, Data dataBaixa){
        this.nom = nom;
        this.alias = alias;
        this.correu = correu;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;

    }

    /**
     * Getter de la variable nom
     * @return - variable nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de la variable alias
     * @return - variable alias
     */
    public String getAlias(){
        return alias;
    }

    /**
     * Getter de la variable correu
     * @return - variable correu
     */
    public String getCorreu(){
        return correu;
    }

    /**
     * Getter de la fecha exacta en la que se dio de alta
     * @return - dia, mes y año en el que se dio de alta
     */
    public Data getDataAlta(){
        return dataAlta;
    }

    /**
     * Getter de la fecha exacta en la que se dio de baja
     * @return - dia, mes y año en el que se dio de baja
     */
    public Data getDataBaixa(){
        return dataBaixa;
    }

    /**
     * Metodo que da de alta a un miembro, lo unico que hace es guardar la fecha que se le pasa en los parametros del alta
     * @param diaAlta - dia en el que se quiere dar de alta
     * @param mesALta - mes en el que se quiere dar de alta
     * @param anyAlta - año en el que se quiere dar de alta
     */
    public void DonarDeAlta(Data dataAlta){
        //Comprobar que el membre no esta ja donat de alta
        if (this.dataAlta == null){
            this.dataAlta = dataAlta;
        }
    }

    /**
     * Metodo que da de baja a un miembro, lo unico que hace es guardar la fecha que se le pasa en los parametros de la baja
     * @param diaBaixa - dia en que se quiere dar de baja
     * @param mesBaixa - mes en que se quiere dar de baja
     * @param anyBaixa - año en que se quiere dar de baja
     */
    public void DonarDeBaixa(Data dataBaixa){
        //Comprobar que el membre esta donat de Alta 
        if ((this.dataAlta != null) && (this.dataBaixa == null)){
            //Comprobar que no estiga donat de baixa 
            this.dataBaixa = dataBaixa;  
        }
    }
    

    public Membre copiaMembre(){
        Membre membreCopiat = new Membre(getNom(),getAlias(),getCorreu(),getDataAlta(),getDataBaixa());
        return membreCopiat;
    }



    
}
