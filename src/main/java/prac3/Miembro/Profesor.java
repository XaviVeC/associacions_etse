package prac3.Miembro;
import prac3.Estructuras.Fecha;

public class Profesor extends Miembro {

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
    public Profesor (int indiceFichero, String tipoMiembro, String nom, String alies, String correu, Fecha dataAlta, Fecha dataBaixa,String departamento, int numeroDespacho){
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
        return ("\t\t\tNombre profesor: " + nombreMiembro+ "\n" +
               "\t\t\tAlias: " + alias +  "\n" +
               "\t\t\tCorro electronico : " + correoMiembro + "\n" +
               "\t\t\tFecha de Alta: " + fechaAlta.toString() + "\n" +
               "\t\t\tFecha de Baja: " + fechaBaixa.toString() + "\n" +
               "\t\t\tDepartamento: " + departamento + "\n" +
               "\t\t\tNumero del despacho: " + numeroDespacho);
    }

    /**
     * Metodo que crea una copia de un profesor
     * @return - copia de un profesor
     */
    public Profesor copia(){
        Profesor p = new Profesor(getIndiceFichero(), getTipoMiembro(), getnombreMiembro(), getAlias(),getCorreoMiembro(), getFechaAlta(), getFechaBaja(),getDepartamento(),getNumeroDespacho());
        return p;
    }
}
