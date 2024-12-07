package prac3.estructures;
import prac3.associacions.Associacio;
public class LlistaAssociacions {
    private Associacio[] listaAsociaciones;
    private int nElem;


    /**
     * Constructor de la clase LlistaAssociacions
     * @param numeroAsociaciones - numero total de acciones para saber de que tamaño hacer la lista
     * @return - lista de acciones del tamaño que entra por parametro
     */
    public LlistaAssociacions (int numeroAsociaciones){
        this.listaAsociaciones = new Associacio[numeroAsociaciones];
        nElem = 0;
    }
    /**
     * Metodo que añade una asociacion que se pase por parametro en la ultima posicion de la lista
     * @param asociacionQueAniadir - asociacion que hay que añadir
     */
    public void addAsociacion (Associacio asociacionQueAniadir){
        if (nElem < listaAsociaciones.length) {
            listaAsociaciones[nElem] = asociacionQueAniadir.copia();
            nElem++;
        }
    }

    /**
     * Getter de la variable indiceAsociaciones
     * @return - variable indiceAsociaciones
     */
    public int getIndiceAsociaciones() {
        return this.nElem;
    }

    /**
     * Getter de la lista de asociaciones
     * @return - variable listaAsociaciones
     */
    public Associacio[] getLlistaAssociacions() { 
        return this.listaAsociaciones;
    }

    /**
     * toString de la list de asociaciones
     * @return Un String con toda la informacion de todas las asociaciones
     */
    public String toString(){
        String aux = "\n";
        for (int i = 0; i < listaAsociaciones.length; i++) {
            aux = aux + "Datos de la asociacion " + (i + 1) + ":\n" + listaAsociaciones[i].toString() + "\n";
        }
        return aux;
    }

    
}