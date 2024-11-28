package prac3.integrants;

//Clase base 
public abstract class Membre {

    //DADES
    private String nom; // Nom del membre 
    private String alias;// Alias del membre 
    private String correu;//Correu electrònic del membre 
    private int diaAlta, mesALta, anyAlta; // Data en la que es dona de alta 
    private int diaBaixa, mesBaixa, anyBaixa; // Data en la que es dona de baixa 

    //MÉTODES 
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

    public String getNom() {
        return nom;
    }

    public String getAlias(){
        return alias;
    }

    public String getCorreu(){
        return correu;
    }

    public String getDataAlta(){
        return diaAlta+ "/" +mesALta+ "/" +anyAlta;
    }

    public String getDataBaixa(){
        return diaBaixa+ "/" +mesBaixa+ "/" +anyBaixa;
    }

    public int getDiaAlta(){
        return diaAlta;
    }

    public int getMesAlta(){
        return mesALta;
    }

    public int getAnyAlta(){
        return anyAlta;
    }

    public int getDiaBaixa(){
        return diaBaixa;
    }

    public int getMesBaixa(){
        return mesBaixa;
    }

    public int getAnyBaixa(){
        return anyBaixa;
    }

    public void DonarDeAlta(int diaAlta, int mesALta, int anyAlta){
        //Comprobar que el membre no esta ja donat de alta
        if (this.diaAlta == 0 && this.mesALta == 0 && this.anyAlta == 0){
            this.diaAlta = diaAlta;
            this.mesALta = mesALta;
            this.anyAlta = anyAlta;
        }
    }

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
