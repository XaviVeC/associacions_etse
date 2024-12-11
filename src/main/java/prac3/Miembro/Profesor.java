package prac3.Miembro;

public class Profesor extends Miembro {

    private String departamento; // si es DEIM o DEEEA
    private int numeroDespacho; // numero de su despacho


    /**
     * Metodo Constructor de la clase Professor
     * @param indiceFichero - Indice en el que esta el Profesor dentro del fichero
     * @param tipoMiembro - En este caso solo seria profesor
     * @param alias - Alias del profesor
     * @param correu - Correo del profesor
     * @param dataAlta - Fecha en la que se dio de alta
     * @param dataBaixa - Fecha en la que se dio de baja
     * @param departament - Si es DEIM o DEEEA
     * @param numeroDespacho - Numero de despacho del profesor
     * @return - Constructor de profesor
     */
    public Profesor (int indiceFichero, String tipoMiembro, String alias, String departamento, int numeroDespacho){
        super(indiceFichero, tipoMiembro, alias);
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
        return ("\t\t\tAlias: " + alias +  "\n" +
               "\t\t\tCorro electronico : " + correoMiembro + "\n" +
               "\t\t\tDepartamento: " + departamento + "\n" +
               "\t\t\tNumero del despacho: " + numeroDespacho);
    }

    /**
     * Metodo que crea una copia de un profesor
     * @return - copia de un profesor
     */
    public Profesor copia(){
        Profesor p = new Profesor(indiceFichero, tipoMiembro, alias, departamento, numeroDespacho);
        return p;
    }


    public String getSiglasCarrera(){
        return null;
    }
}
