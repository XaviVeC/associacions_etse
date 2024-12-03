package prac3.integrants;

//Clase base 
public abstract class Membre {

    //DADES
    private String nom; // Nombre del miembro 
    private String alias;// Alias del membre 
    private String correu;// Correo electronico del miembro 
    private int diaAlta, mesALta, anyAlta; // Fecha en la que se da de alta 
    private int diaBaixa, mesBaixa, anyBaixa; // Fecha en la que se da de baja 

    //MÉTODES
    
    /**
     * Metodo constructor de la clase Membre
     * @param nom - Nombre del miembro
     * @param alias - Alias del nombre del miembro
     * @param correu - Correo del miembro
     * @param diaAlta - Dia en el que se dio de alta
     * @param mesALta - Mes en el que se dio de alta
     * @param anyAlta - Año en el que se dio de alta
     * @param diaBaixa - Dia en el que se dio de baja
     * @param mesBaixa - Mes en el que se dio de baja
     * @param anyBaixa - Año en el que se dio de baja
     * @return - Constructor Membre
     */
    public Membre (String nom, String alias, String correu, int diaAlta, int mesALta, int anyAlta, int diaBaixa, int mesBaixa, int anyBaixa){
        this.nom = nom;
        this.alias = alias;
        this.correu = correu;
        this.diaAlta = diaAlta;
        this.mesALta = mesALta;
        this.anyAlta = anyAlta;
        this.diaBaixa = diaBaixa;
        this.mesBaixa = mesBaixa;
        this.anyBaixa = anyBaixa;

        
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
    public String getDataAlta(){
        return diaAlta+ "/" +mesALta+ "/" +anyAlta;
    }

    /**
     * Getter de la fecha exacta en la que se dio de baja
     * @return - dia, mes y año en el que se dio de baja
     */
    public String getDataBaixa(){
        return diaBaixa+ "/" +mesBaixa+ "/" +anyBaixa;
    }

    /**
     * Getter del dia que se dio de alta
     * @return - variable diaAlta
     */
    public int getDiaAlta(){
        return diaAlta;
    }

    /**
     * Getter del mes en el que se dio de alta
     * @return - variable mesAlta
     */
    public int getMesAlta(){
        return mesALta;
    }

    /**
     * Getter del año en el que se dio de alta
     * @return - variable anyAlta
     */
    public int getAnyAlta(){
        return anyAlta;
    }

    /**
     * Getter del dia que se dio de baja
     * @return - variable diaBaixa
     */
    public int getDiaBaixa(){
        return diaBaixa;
    }

    /**
     * Getter del mes en el que se dio de baja
     * @return - variable mesBaixa
     */
    public int getMesBaixa(){
        return mesBaixa;
    }

    /**
     * Getter del año en el que se dio de baja
     * @return - variable anyBaixa
     */
    public int getAnyBaixa(){
        return anyBaixa;
    }

    /**
     * Metodo que da de alta a un miembro, lo unico que hace es guardar la fecha que se le pasa en los parametros del alta
     * @param diaAlta - dia en el que se quiere dar de alta
     * @param mesALta - mes en el que se quiere dar de alta
     * @param anyAlta - año en el que se quiere dar de alta
     */
    public void DonarDeAlta(int diaAlta, int mesALta, int anyAlta){
        //Comprobar que el membre no esta ja donat de alta
        if (this.diaAlta == 0 && this.mesALta == 0 && this.anyAlta == 0){
            this.diaAlta = diaAlta;
            this.mesALta = mesALta;
            this.anyAlta = anyAlta;
        }
    }

    /**
     * Metodo que da de baja a un miembro, lo unico que hace es guardar la fecha que se le pasa en los parametros de la baja
     * @param diaBaixa - dia en que se quiere dar de baja
     * @param mesBaixa - mes en que se quiere dar de baja
     * @param anyBaixa - año en que se quiere dar de baja
     */
    public void DonarDeBaixa(int diaBaixa, int mesBaixa, int anyBaixa){
        //Comprobar que el membre esta donat de Alta 
        if (this.diaAlta != 0 && this.mesALta != 0 && this.anyAlta != 0){
            //Comprobar que no estiga donat de baixa 
            if(this.diaBaixa == 0 && this.mesBaixa == 0 && this.anyBaixa == 0){
                this.diaBaixa = diaBaixa;
                this.mesBaixa = mesBaixa;
                this.anyBaixa = anyBaixa;
            }  
        }
    }





    
}
