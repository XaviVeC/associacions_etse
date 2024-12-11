package prac3.Miembro;

import prac3.Estructuras.Fecha;

public class Alumno extends Miembro {

    private String siglasCarrera; //Siglas de la carrera que cursa
    private int yearsEtse;  //Years que lleva en la ETSE
    private boolean graduado; // Variable que indica si el alumno se ha graduado ya o no

    /**
     * Constructor de la clase Alumne.
     * 
     * @param indiceFichero - identificador del Alumno dentro del fichero
     * @param tipoMiembro   - en este caso solo deberia ser Alumne
     * @param alias         - alias del alumno
     * @param curso         - curso del alumno
     * @param yearsEtse     - anyos en la ETSE
     * @return - Objecto de la clase Alumne.
     */
    public Alumno(int indiceFichero, String tipoMiembro, String alias, int yearsEtse, boolean graduado, String carrera) {
        super(indiceFichero, tipoMiembro, alias);
        this.graduado = graduado;
        this.yearsEtse = yearsEtse;
        this.siglasCarrera = carrera;
    }

    /**
     * Metodo String que imprime los datos de la clase alumno
     */
    public String toString() {
        String aux = "\t\t\tAlias: " + alias + "\n" +
                "\t\t\tCorreo electronico alumno: " + correoMiembro + "\n" +
                "\t\t\tCarrera alumno: " + siglasCarrera + "\n" +
                "\t\t\tAños en la ETSE: " + yearsEtse + "\n";

        if (graduado) {
            aux = aux + "\t\t\tGraduado con exito\n";
        } else {
            aux = aux + "\t\t\tNo graduado\n";
        }
        return (aux);
    }

    /**
     * Getter de la variable siglasCarrera
     * 
     * @return - variable siglasCarrera
     */
    public String getSiglasCarrera() {
        return this.siglasCarrera;
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
     * Getter de la variable graduado
     * 
     * @return - variable graduado
     */
    public boolean getGraduado() {
        return graduado;
    }

    /**
     * Modificador de la variable graduado
     */
    public void accionGraduar() {
        graduado = true;
    }

    /**
     * Metodo que hace una copia de un alumno en concreto
     * 
     * @return - copia de alumno en concreto
     */
    public Alumno copia() {
        Alumno a = new Alumno(indiceFichero, tipoMiembro, alias,
                yearsEtse, graduado, siglasCarrera);
        return a;
    }
}
