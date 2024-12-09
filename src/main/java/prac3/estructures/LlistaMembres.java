package prac3.estructures;

import prac3.integrants.Alumne;
import prac3.integrants.Membre;
// import prac3.associacions.Associacio;
import prac3.integrants.Professor;
import prac3.estructures.LlistaAssociacions;
import prac3.associacions.Associacio;
import prac3.ficheros.LlegirFitxers;

public class LlistaMembres {
    private Membre[] listaMembres; // lista de miembros
    private int nElem; // numero de elementos de la lista miembros

    /**
     * Constructor de la clase LlistaMembres
     * @param numeroMembres - numero total de miembros para saber de que tamaño hacer la lista
     * @return - lista de miembros del tamaño que entra por parametro
     */
    public LlistaMembres(int numeroMembres) {
        this.listaMembres = new Membre[numeroMembres];
        nElem = 0;
    }

    /**
     * Metodo que añade una miembro que se pase por parametro en la ultima posicion
     * de la lista
     * @param miembroQueAniadir - miembro que hay que añadir
     * @return - la lista modificada
     */
    public void addmiembro(Membre miembroQueAniadir) {
        listaMembres[nElem] = miembroQueAniadir;
        nElem++;
    }

    /**
     * Getter de la variable nElem
     * @return - numero de miembros que tenemos en la lista
     */
    public int getnumeroMembres() {
        return nElem;
    }

    /**
     * Metodo que obtiene el Miembro de una posicion en especifico de la lista pasada por parametro
     * @param indice - posicion de la lista que queremos obtener
     * @return - miembro que esta en la posicion indice
     */
    public Membre getmiembroEnXIndice(int indice) {
        return this.listaMembres[indice].copia();
    }

    /**
     * Metodo que hace una copia de una lista de miembros
     * @return - variable nuevaLista, que es esta copia de la lista
     */
    public LlistaMembres copia() {
        int tamanioLista = this.listaMembres.length;
        LlistaMembres nuevaLista = new LlistaMembres(tamanioLista);

        for (int i = 0; i < tamanioLista; i++) {
            nuevaLista.listaMembres[i] = listaMembres[i].copia();
        }
        return nuevaLista;
    }

    /**
     * Metodo ToString de la lista de miembros
     * @return - lista con todos las miembros
     */
    public String toString() {
        String stringDeLaLista = "\n";

        for (int i = 0; i < this.nElem; i++) {
            stringDeLaLista = stringDeLaLista + "Los datos del miembro "+ (i + 1) + " son:\n"+listaMembres[i].toString() + "\n";
        }

        return stringDeLaLista;
    }

    /** FALTA ACABAR PORQUE NO SE COMO HACERLO !!!!!!!!!!!!!!!!
     * 
     * 
     * Metodo que crea una lista de miembros de una asociacion concreta
     * @param nombreAsociacion - variable que indica el nombre de la asociacion sobre la que hacer su lista de miembros
     * @return - lista de miembros de la asociacion con ese nombre
     */

     // Me dan el nombre de la asociacion
     // He de mirar en a lista de asociaciones la que tenga el mismo nombre
     // He de mirar la lista de miembros de esa asociacion
    public LlistaMembres miembrosDeAsociacionConcreta (String nombreAsociacion){
        LlistaAssociacions listaAsociacionesTotal = new LlistaAssociacions(nElem);
        LlegirFitxers.LeerFicheroAsociaciones("Asociaciones.csv", listaAsociacionesTotal, nElem);
        LlistaMembres listaDeTodosMiembros = new LlistaMembres(100);
        LlegirFitxers.LeerFicheroMiembros("Membres.csv", listaDeTodosMiembros, 100);
        LlistaMembres listaDefinitiva = new LlistaMembres(nElem);
        int  j = 0; 
        int x = 0;
        for (int i = 0; i < listaAsociacionesTotal.getIndiceAsociaciones(); i++) {
            if (listaAsociacionesTotal.listaAsociciones[i].getNombreAsociacion().equalsIgnoreCase(nombreAsociacion)){
                while (){//quiero separar por guiones, el guion indica cambio de indice
                    listaDefinitiva.listaMembres[x].nombreMiembro = listaAsociacionesTotal.listaAsociaciones[i].getnombreMiembro();
                }
            }
        }
       
    }

}

    

