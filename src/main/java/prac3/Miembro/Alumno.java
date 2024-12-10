package prac3.Miembro;

import prac3.Estructuras.Fecha;

public class Alumno extends Miembro {

    private String curso;
    private int yearsEtse;
    private boolean graduado; // Variable que indica si el alumno se ha graduado ya o no

    /**
     * Constructor de la clase Alumne.
     * 
     * @param indiceFichero - identificador del Alumno dentro del fichero
     * @param tipoMiembro   - en este caso solo deberia ser Alumne
     * @param nombreMiembro - nombreMiembrobre del alumno
     * @param alias         - alias del alumno
     * @param correoMiembro - correo del alumno
     * @param fechaAlta     - fecha en la que se dio de alta
     * @param fechaBaja     - fecha en la que se dio de baja
     * @param curso         - curso del alumno
     * @param yearsEtse     - anyos cursados en la ETSE
     * @return - Objecto de la clase Alumne.
     */
    public Alumno(int indiceFichero, String tipoMiembro, String nombreMiembro, String alias, String correoMiembro,
            Fecha fechaAlta, Fecha fechaBaja, String curso, int yearsEtse, boolean graduado) {
        super(indiceFichero, tipoMiembro, nombreMiembro, alias, correoMiembro, fechaAlta, fechaBaja);
        this.graduado = graduado;
        this.curso = curso;
        this.yearsEtse = yearsEtse;
    }

    /**
     * Metodo String que imprime los datos de la clase alumno
     */
    public String toString() {
        String aux = "\t\t\tNombre del alumno: " + nombreMiembro + "\n" +
                "\t\t\tAlias: " + alias + "\n" +
                "\t\t\tCorreo electronico alumno: " + correoMiembro + "\n" +
                "\t\t\tData de Alta: " + fechaAlta.toString() + "\n" +
                "\t\t\tData de Baixa: " + fechaBaixa.toString() + "\n" +
                "\t\t\tCurso: " + curso + "\n" +
                "\t\t\tAños en la ETSE: " + yearsEtse + "\n";

        if (graduado) {
            aux = aux + "\t\t\tGraduado con exito\n";
        } else {
            aux = aux + "\t\t\tNo graduado\n";
        }
        return (aux);
    }

    /**
     * Getter de la variable curso
     * 
     * @return - variable curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Getter de la variable anyEtse
     * 
     * @return - variable yearsEtse
     */
    public int getYearsEtse() {
        return yearsEtse;
    }

    /**
     * Modificador de la variable graduado
     */
    public void jaGraduado() {
        graduado = true;
    }

    /**
     * Getter de la variable graduado
     * 
     * @return - variable graduado
     */
    public boolean getGraduado() {
        return graduado;
    }

    /**
     * Metodo que hace una copia de un alumno en concreto
     * 
     * @return - copia de alumno en concreto
     */
    public Alumno copia() {
        Alumno a = new Alumno(getIndiceFichero(), getTipoMiembro(), getnombreMiembro(), getAlias(), getCorreoMiembro(),
                getFechaAlta(), getFechaBaja(), curso, yearsEtse, graduado);
        return a;
    }
}
