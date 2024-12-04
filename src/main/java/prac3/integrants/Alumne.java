package prac3.integrants;
import prac3.estructures.Data;
public class Alumne extends Membre {

    private String curso;
    private int aniosEtse;
    private boolean graduado; // Variable que indica si el alumno se ha graduado ya o no 

    /**
     * Constructor de la clase Alumne.
     * @param nombreMiembro - nombreMiembrobre del alumno
     * @param alias - alias del alumno
     * @param correoMiembro - correo del alumno
     * @param fechaAlta - fecha en la que se dio de alta
     * @param fechaBaja - fecha en la que se dio de baja
     * @param curso - cursoo del alumno
     * @param aniosEtse - anyos cursoados en la ETSE
     * @return - Objecto de la clase Alumne.
     */
    public Alumne (String nombreMiembro, String alias, String correoMiembro, Data fechaAlta, Data fechaBaja, String curso, int aniosEtse, boolean graduado){
        super(nombreMiembro, alias, correoMiembro, fechaAlta, fechaBaja);
        this.graduado = graduado;
        this.curso = curso;
        this.aniosEtse = aniosEtse;
    }

    /**
     * Metodo String que imprime los datos de la clase alumno
     */
    public String toString(){
        return("nombreMiembro:" + getnombreMiembro()+ "\n" +
               "Alias:" + getAlias() +  "\n" +
               "correoMiembro Electrònic:" + getCorreoMiembro() + "\n" +
               "Data de Alta:" + getFechaAlta() + "\n" +
               "Data de Baixa:" + getFechaBaja() + "\n" +
               "curso:" + getCurso() + "\n" +
               "Anys a l'Etse:" + getAniosEtse() + "\n" +
               "graduado:" + getGraduado());
    }
    
    /**
     * Getter de la variable curso
     * @return - variable curso
     */
    public String getCurso (){
        return curso;
    }

    /**
     * Getter de la variable anyEtse
     * @return - variable aniosEtse
     */
    public int getAniosEtse (){
        return aniosEtse;
    }

    /**
     * Modificador de la variable graduado
     */
    public void jaGraduado(){
        graduado = true;
    }

    /**
     * Getter de la variable graduado
     * @return - variable graduado
     */
    public boolean getGraduado(){
        return graduado;
    }

    /**
     * Metodo que hace una copia de un alumno en concreto
     * @return - copia de alumno en concreto
     */
    public Alumne copia(){
        Alumne a = new Alumne(getnombreMiembro(),getAlias(), getCorreoMiembro(), getFechaAlta(), getFechaBaja(), curso, aniosEtse, graduado);
        return a;
    }
}

