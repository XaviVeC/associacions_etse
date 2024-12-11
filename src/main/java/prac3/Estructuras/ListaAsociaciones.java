package prac3.Estructuras;

import prac3.Asociacion.Asociacion;

public class ListaAsociaciones {
    private Asociacion[] listaAsociaciones;
    private int nElem;

    /**
     * Constructor de la clase LlistaAssociacions
     * 
     * @param numeroAsociaciones - numero total de acciones para saber de que tamaño
     *                           hacer la lista
     * @return - lista de acciones del tamaño que entra por parametro
     */
    public ListaAsociaciones(int numeroAsociaciones) {
        this.listaAsociaciones = new Asociacion[numeroAsociaciones];
        nElem = 0;
    }

    /**
     * Metodo que añade una asociacion que se pase por parametro en la ultima
     * posicion de la lista
     * 
     * @param asociacionQueAniadir - asociacion que hay que añadir
     */
    public void addAsociacion(Asociacion asociacionQueAniadir) {
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

    public Asociacion getElementoListaAsociacion(int indice) {
        return this.listaAsociaciones[indice];
    }

    /**
     * Getter de la lista de asociaciones
     * 
     * @return - variable listaAsociaciones
     */
    public Asociacion[] getLlistaAssociacions() {
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

     
    /**
     * Metodo que modifica la listaDeMiembros que componen una asociacion, de la posicion de la lista asociaciones que corresponda
     * @param alias - nuevo alias a añadir
     * @param nombreAsociacion - la nombre asociacion a la que se le modifica la lista de miembros
     * @param listaTodasAsociaciones - lista que contiene las asociaciones
     */
    public void addMiembroEnAsociacionExistente(String alias, String nombreAsociacion, ListaAsociaciones listaTodasAsociaciones) {
        boolean encontrado = false;
        int i = 0;
        Asociacion auxiliar;

        while ((!encontrado) && (i < listaTodasAsociaciones.getIndiceAsociaciones())) {
            if (listaTodasAsociaciones.getElementoListaAsociacion(i).getNombreAsociacion().equals(nombreAsociacion)) {
                auxiliar = listaTodasAsociaciones.getElementoListaAsociacion(i);
                auxiliar.addMiembroEnAsociacion(alias); // Miembro añadido en la asociacion que toca
                encontrado = true;
            }
            else
            {
                i++;
            }
        }
    }


    /**
     * Metodo que comprueba si existe una asociacion con el mismo nombre que el que pasa por parametro
     * @param nombreAsociacion - variable con el nombre de la asociacion a comprobar
     * @param listaTodasAsociaciones - variable que lleva la lista de todas las asociaciones
     * @return - siExiste, true -> si que hay una igual, false -> no hay ninguna igual
     */
    public static boolean existeAsociacionMismoNombre (String nombreAsociacion, ListaAsociaciones listaTodasAsociaciones){
        boolean siExiste = false;
        int indiceAsociaciones = 0;

        while (indiceAsociaciones < listaTodasAsociaciones.getIndiceAsociaciones()) {
            if (listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones).getNombreAsociacion().equals(nombreAsociacion)){
                siExiste = true;
            }
            else{
                indiceAsociaciones++;
            }
        }
        return siExiste;
    }
    
    //Metodo que comprueba si el miembro a comprobar esta en la asociacion
    public boolean estaElMiembroEnLaAsociacion (String alias, Asociacion asociacion){
        boolean siEsta = false;
        for (int index = 0; index < asociacion.getListaMiembrosAsociacion().length; index++) {
            if (asociacion.getListaMiembrosAsociacion()[index].equals(alias)) {
                siEsta = true;
            }
        }
        return siEsta;
    }



}

    

    
