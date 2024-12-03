package prac3.integrants;

public class Professor extends Membre {

    private String departament; // si es DEIM o DEEEA
    private int numeroDespatx; // numero de su despacho


    /**
     * Metodo Constructor de la clase Professor
     * @param nom - Nombre del profesor
     * @param alies - Alias del profesor
     * @param correu - Correo del profesor
     * @param dataAlta - Fecha en la que se dio de alta
     * @param dataBaixa - Fecha en la que se dio de baja
     * @param departament - Si es DEIM o DEEEA
     * @param numeroDespatx - Numero de despacho del profesor
     * @return - Constructor de profesor
     */
    public Professor (String nom, String alies, String correu, Data dataAlta, Data dataBaixa,String departament, int numeroDespatx){
        super(nom, alies, correu, dataAlta, dataBaixa);
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
        Professor p = new Professor(getNom(), getAlias(),getCorreu(), getDataAlta(), getDataBaixa(),departament,numeroDespatx);
        return p;
    }
}
