package prac3.integrants;
import prac3.estructures.Data;

public class Professor extends Membre {

    private String departamento; // si es DEIM o DEEEA
    private int numeroDespacho; // numero de su despacho


    /**
     * Metodo Constructor de la clase Professor
     * @param indiceFichero - Indice en el que esta el Profesor dentro del fichero
     * @param tipoMiembro - En este caso solo seria profesor
     * @param nom - Nombre del profesor
     * @param alies - Alias del profesor
     * @param correu - Correo del profesor
     * @param dataAlta - Fecha en la que se dio de alta
     * @param dataBaixa - Fecha en la que se dio de baja
     * @param departament - Si es DEIM o DEEEA
     * @param numeroDespacho - Numero de despacho del profesor
     * @return - Constructor de profesor
     */
    public Professor (int indiceFichero, String tipoMiembro, String nom, String alies, String correu, Data dataAlta, Data dataBaixa,String departamento, int numeroDespacho){
        super(indiceFichero, tipoMiembro, nom, alies, correu, dataAlta, dataBaixa);
        this.departamento = departamento;
        this.numeroDespacho = numeroDespacho;
      
    }

    /**
     * Getter de la variable departamento
     * @return - variable departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Getter de la variable numeroDespacho
     * @return - variable numeroDespacho
     */
    public int getNumeroDespacho (){
        return numeroDespacho;
    }
   
    /**
     * Metodo String que imprime todos los datos del objeto profesor
     */
    public String toString (){
        return ("Nom:" + this.getnombreMiembro()+ "\n" +
               "Alias:" + this.getAlias() +  "\n" +
               "Correu Electrònic:" + this.getCorreoMiembro() + "\n" +
               "Fecha de Alta:" + this.getFechaAlta() + "\n" +
               "Fecha de Baja:" + this.getFechaBaja() + "\n" +
               "Departamento:" + this.getDepartamento() + "\n" +
               "Numero del despacho:" + this.getNumeroDespacho());
    }

    /**
     * Metodo que crea una copia de un profesor
     * @return - copia de un profesor
     */
    public Professor copia(){
        Professor p = new Professor(getIndiceFichero(), getTipoMiembro(), getnombreMiembro(), getAlias(),getCorreoMiembro(), getFechaAlta(), getFechaBaja(),getDepartamento(),getNumeroDespacho());
        return p;
    }
}
