package prac3.integrants;

public class Alumne extends Membre {

    private String curs;
    private int anysEtse;
    private boolean graduat; // Variable que indica si el alumno se ha graduado ya o no 

    /**
     * Constructor de la clase Alumne.
     * @param nom - nombre del alumno
     * @param alias - alias del alumno
     * @param correu - correo del alumno
     * @param diaAlta - dia que se dio de baja el alumno
     * @param mesALta - mes que se dio de alta el alumno
     * @param anyAlta - año que se dio de alta el alumno
     * @param diaBaixa - dia que se dio de baja el alumno
     * @param mesBaixa - mes que se dio de baja el alumno
     * @param anyBaixa - año que se dio de baja el alumno 
     * @param curs - curso del alumno
     * @param anysEtse - anyos cursados en la ETSE
     * @return - Objecto de la clase Alumne.
     */
    public Alumne (String nom, String alias, String correu, int diaAlta, int mesALta, int anyAlta, int diaBaixa, int mesBaixa, int anyBaixa, String curs, int anysEtse){
        super(nom, alias, correu, diaAlta, mesALta, anyAlta, diaBaixa, mesBaixa, anyBaixa);
        this.graduat = false;
        this.curs = curs;
        this.anysEtse = anysEtse;
    }

    /**
     * Metodo String que imprime los datos de la clase alumno
     */
    public String toString (){
        return("Nom:" + getNom()+ "\n" +
               "Alias:" + getAlias() +  "\n" +
               "Correu Electrònic:" + getCorreu() + "\n" +
               "Data de Alta:" + getDataAlta() + "\n" +
               "Data de Baixa:" + getDataBaixa() + "\n" +
               "Curs:" + getCurs() + "\n" +
               "Anys a l'Etse:" + getAnysEtse() + "\n" +
               "Graduat:" + getGraduat());
    }
    
    /**
     * Getter de la variable curs
     * @return - variable curs
     */
    public String getCurs (){
        return curs;
    }

    /**
     * Getter de la variable anyEtse
     * @return - variable anysEtse
     */
    public int getAnysEtse (){
        return anysEtse;
    }

    /**
     * Modificador de la variable graduat
     */
    public void JaGraduat(){
        graduat = true;
    }

    /**
     * Getter de la variable graduat
     * @return - variable graduat
     */
    public boolean getGraduat(){
        return graduat;
    }

    /**
     * Metodo que hace una copia de un alumno en concreto
     * @return - copia de alumno en concreto
     */
    public Alumne copiaAlumne(){
        Alumne a = new Alumne(getNom(),getAlias(), getCorreu(), getDiaAlta(),getMesAlta(), getAnyAlta(), getDiaBaixa(), getMesBaixa(), getAnyBaixa(), curs, anysEtse);
        return a;
    }
}

