package prac3.integrants;

public class Alumne extends Membre {

    private String curs;
    private int anysEtse;
    private boolean graduat; // Per saber si l'alumne s'ha graduat ja o no 

    /**
     * Constructor de la classe Alumne.
     * @param nom - nom de l'alumne
     * @param alias - alias de l'alumne
     * @param correu - correu de l'alumne
     * @param diaAlta - dia que es va donar de baixa l'alumne
     * @param mesALta - mes que es va donar d'alta l'alumne
     * @param anyAlta - any que es va donar d'alta l'alumne
     * @param diaBaixa - dia que es va donar de baixa l'alumne
     * @param mesBaixa - mes en que es dona de baixa l'alumne
     * @param anyBaixa - any en que es dona de baixa l'alumne 
     * @param curs - curs de l'alumne
     * @param anysEtse - anys cursats en la ETSE
     * @return - Objecte de la classe Alumne.
     */
    public Alumne (String nom, String alias, String correu, int diaAlta, int mesALta, int anyAlta, int diaBaixa, int mesBaixa, int anyBaixa, String curs, int anysEtse){
        super(nom, alias, correu, diaAlta, mesALta, anyAlta, diaBaixa, mesBaixa, anyBaixa);
        this.graduat = false;
        this.curs = curs;
        this.anysEtse = anysEtse;
    }

    /**
     * 
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
    
    public String getCurs (){
        return curs;
    }

    public int getAnysEtse (){
        return anysEtse;
    }

    public void JaGraduat(){
        graduat = true;
    }

    public boolean getGraduat(){
        return graduat;
    }

    public Alumne copiaAlumne(){
        Alumne a = new Alumne(getNom(),getAlias(), getCorreu(), getDiaAlta(),getMesAlta(), getAnyAlta(), getDiaBaixa(), getMesBaixa(), getAnyBaixa(), curs, anysEtse);
        return a;
    }
}

