package prac3.estructures;

import prac3.associacions.Associacio;
import prac3.integrants.Membre;

public class LlistaAssociacions {
    private Associacio[] listaAsociaciones;
    private int nElem;

    /**
     * Constructor de la clase LlistaAssociacions
     * 
     * @param numeroAsociaciones - numero total de acciones para saber de que tamaño
     *                           hacer la lista
     * @return - lista de acciones del tamaño que entra por parametro
     */
    public LlistaAssociacions(int numeroAsociaciones) {
        this.listaAsociaciones = new Associacio[numeroAsociaciones];
        nElem = 0;
    }

    /**
     * Metodo que añade una asociacion que se pase por parametro en la ultima
     * posicion de la lista
     * 
     * @param asociacionQueAniadir - asociacion que hay que añadir
     */
    public void addAsociacion(Associacio asociacionQueAniadir) {
        if (nElem < listaAsociaciones.length) {
            listaAsociaciones[nElem] = asociacionQueAniadir.copia();
            nElem++;
        }
    }

    /**
     * Getter de la variable indiceAsociaciones
     * 
     * @return - variable indiceAsociaciones
     */
    public int getIndiceAsociaciones() {
        return this.nElem;
    }

    public Associacio getElementoListaAsociacion(int indice) {
        return this.listaAsociaciones[indice];
    }

    /**
     * Getter de la lista de asociaciones
     * 
     * @return - variable listaAsociaciones
     */
    public Associacio[] getLlistaAssociacions() {
        return this.listaAsociaciones;
    }

    /**
     * toString de la list de asociaciones
     * 
     * @return Un String con toda la informacion de todas las asociaciones
     */
    public String toString() {
        String aux = "\n";
        for (int i = 0; i < nElem; i++) {
            aux = aux + "Datos de la asociacion " + (i + 1) + ":\n" + listaAsociaciones[i].toString() + "\n";
        }
        return aux;
    }

    public void addMiembroEnAsociacion(String alias, Associacio asociacionDondeUnirse, 
                                       LlistaAssociacions listaTodasAsociaciones, LlistaMembres listaTodosMiembros) {
        Membre membreAuxiliar;

        for (int i = 0; i < listaTodosMiembros.getNumeroMembres(); i ++) {
            if (alias.equals(listaTodosMiembros.getMiembroEnXIndice(i).getAlias())) {
                membreAuxiliar = listaTodosMiembros.getMiembroEnXIndice(i).copia();
            }
        }
        
        for (int i = 0; i < listaTodasAsociaciones.getIndiceAsociaciones(); i++) {

        }
    }

}