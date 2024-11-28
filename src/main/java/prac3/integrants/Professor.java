package prac3.integrants;

public class Professor extends Membre {

    private String departament;
    private int numeroDespatx; 

    public Professor (String nom, String alies, String correu, int diaAlta, int mesALta, int anyAlta, int diaBaixa, int mesBaixa, int anyBaixa,String departament, int numeroDespatx){
        super(nom, alies, correu, diaAlta, mesALta, anyAlta, diaBaixa, mesBaixa, anyBaixa);
        this.departament = departament;
        this.numeroDespatx = numeroDespatx;
      
    }

    public String getDepartament() {
        return departament;
    }

    public int getNumeroDespatx (){
        return numeroDespatx;
    }
   
    public String toString(){
        return ("Nom:" + getNom()+ "\n" +
               "Alias:" + getAlias() +  "\n" +
               "Correu Electrònic:" + getCorreu() + "\n" +
               "Data de Alta:" + getDataAlta() + "\n" +
               "Data de Baixa:" + getDataBaixa() + "\n" +
               "Departament:" + getDepartament() + "\n" +
               "Numero del despatx:" +getNumeroDespatx());
    }

    public Professor copiaProfessor(){
        Professor p = new Professor(getNom(), getAlias(),getCorreu(), getDiaAlta(), getMesAlta(), getAnyAlta(), getDiaBaixa(), getMesBaixa(), getAnyBaixa(),departament,numeroDespatx);
        return p;
    }
}
