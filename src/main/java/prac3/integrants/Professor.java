package prac3.integrants;

public class Professor extends Membre {

    private String departament; // si es DEIM o DEEEA
    private int numeroDespatx; // numero de su despacho


    /**
     * Metodo Constructor de la clase Professor
     * @param nom - Nombre del profesor
     * @param alies - Alias del profesor
     * @param correu - Correo del profesor
     * @param diaAlta - Dia en que se dio de alta el profesor
     * @param mesALta - Mes en que se dio de alta el profesor
     * @param anyAlta - Año en que se dio de alta el profesor
     * @param diaBaixa - Dia en que se dio de baja el profesor
     * @param mesBaixa - Mes en que se dio de baja el profesor
     * @param anyBaixa - Año en que se dio de baja el profesor
     * @param departament - Si es DEIM o DEEEA
     * @param numeroDespatx - Numero de despacho del profesor
     * @return - Constructor de profesor
     */
    public Professor (String nom, String alies, String correu, int diaAlta, int mesALta, int anyAlta, int diaBaixa, int mesBaixa, int anyBaixa,String departament, int numeroDespatx){
        super(nom, alies, correu, diaAlta, mesALta, anyAlta, diaBaixa, mesBaixa, anyBaixa);
        this.departament = departament;
        this.numeroDespatx = numeroDespatx;
      
    }

    /**
     * Getter de la variable departament
     * @return - variable departament
     */
    public String getDepartament() {
        return departament;
    }

    /**
     * Getter de la variable numeroDespatx
     * @return - variable numeroDespatx
     */
    public int getNumeroDespatx (){
        return numeroDespatx;
    }
   
    /**
     * Metodo String que imprime todos los datos del objeto profesor
     */
    public String toString(){
        return ("Nom:" + getNom()+ "\n" +
               "Alias:" + getAlias() +  "\n" +
               "Correu Electrònic:" + getCorreu() + "\n" +
               "Data de Alta:" + getDataAlta() + "\n" +
               "Data de Baixa:" + getDataBaixa() + "\n" +
               "Departament:" + getDepartament() + "\n" +
               "Numero del despatx:" +getNumeroDespatx());
    }

    /**
     * Metodo que crea una copia de un profesor
     * @return - copia de un profesor
     */
    public Professor copiaProfessor(){
        Professor p = new Professor(getNom(), getAlias(),getCorreu(), getDiaAlta(), getMesAlta(), getAnyAlta(), getDiaBaixa(), getMesBaixa(), getAnyBaixa(),departament,numeroDespatx);
        return p;
    }
}
