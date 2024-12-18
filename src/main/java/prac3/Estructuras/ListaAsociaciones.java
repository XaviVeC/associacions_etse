package prac3.Estructuras;

import prac3.Asociacion.Asociacion;
import prac3.Miembro.Miembro;
import prac3.Miembro.Alumno;

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
     * Metodo que modifica la listaDeMiembros que componen una asociacion, de la
     * posicion de la lista asociaciones que corresponda
     * 
     * @param alias                  - nuevo alias a añadir
     * @param nombreAsociacion       - la nombre asociacion a la que se le modifica
     *                               la lista de miembros
     * @param listaTodasAsociaciones - lista que contiene las asociaciones
     */
    public void addMiembroEnAsociacionExistente(String alias, String nombreAsociacion,
            ListaAsociaciones listaTodasAsociaciones,
            Fecha fechaAlta) {
        boolean encontrado = false;
        int i = 0;
        Asociacion auxiliar;
        Fecha fechaBaja = new Fecha(99, 99, 9999);

        while ((!encontrado) && (i < listaTodasAsociaciones.getIndiceAsociaciones())) {
            if (listaTodasAsociaciones.getElementoListaAsociacion(i).getNombreAsociacion().equals(nombreAsociacion)) {
                auxiliar = listaTodasAsociaciones.getElementoListaAsociacion(i);
                auxiliar.addMiembroEnAsociacion(alias, fechaAlta, fechaBaja); // Miembro añadido en la asociacion que
                                                                              // toca
                encontrado = true;
            } else {
                i++;
            }
        }
    }

    /**
     * Metodo que comprueba si existe una asociacion con el mismo nombre que el que
     * pasa por parametro
     * 
     * @param nombreAsociacion       - variable con el nombre de la asociacion a
     *                               comprobar
     * @param listaTodasAsociaciones - variable que lleva la lista de todas las
     *                               asociaciones
     * @return - siExiste, true -> si que hay una igual, false -> no hay ninguna
     *         igual
     */
    public boolean existeAsociacion(String nombreAsociacion) {
        boolean siExiste = false;
        int indiceAsociaciones = 0;

        while (indiceAsociaciones < this.nElem && !siExiste) {
            if (this.listaAsociaciones[indiceAsociaciones].getNombreAsociacion().equals(nombreAsociacion)) {
                siExiste = true;
            } else {
                indiceAsociaciones++;
            }
        }
        return siExiste;
    }

    /**
     * Metodo que comprueba si el miembro esta activo en la asociacion
     * 
     * @param alias      - Alias del miembro a comprobar
     * @param asociacion - Asociacion en la que se va a añadir el miembro
     * @return - true si esta, false si no esta
     */
    public boolean estaElMiembroActivoEnLaAsociacion(String alias, Asociacion asociacion) {
        boolean siEsta = false;
        for (int index = 0; index < asociacion.getListaMiembrosAsociacion().length; index++) {
            if (asociacion.getListaMiembrosAsociacion()[index].equals(alias)
                    && asociacion.getFechasBaja()[index].getyear() == 9999) {
                siEsta = true;
            }
        }
        return siEsta;
    }

    /**
     * Metodo que comprueba si el miembro esta activo en la asociacion
     * 
     * @param alias      - Alias del miembro a comprobar
     * @param asociacion - Asociacion en la que se va a añadir el miembro
     * @return - true si esta, false si no esta
     */
    public boolean alumnoHaEstadoEnLaAsociacion(String alias, Asociacion asociacion, ListaMiembros listaTodosLosMiembros) {
        boolean siEsta = false;
        boolean esAlumno = false;
        int indiceBusquedaAlumno = 0;

        while (!esAlumno && indiceBusquedaAlumno < listaTodosLosMiembros.getNumeroMembres()) {
            if (listaTodosLosMiembros.getMiembroEnXIndice(indiceBusquedaAlumno).getAlias().equals(alias) && listaTodosLosMiembros.getMiembroEnXIndice(indiceBusquedaAlumno) instanceof Alumno) {
                esAlumno = true;
            }
            else
            {
                indiceBusquedaAlumno++;
            }
        }
        indiceBusquedaAlumno = 0;

        if (esAlumno) {
            while (!siEsta && indiceBusquedaAlumno < asociacion.getListaMiembrosAsociacion().length) {
                if (asociacion.getListaMiembrosAsociacion()[indiceBusquedaAlumno].equals(alias)) {
                    siEsta = true;
                } else {
                    indiceBusquedaAlumno++;
                }
            }
        }

        return siEsta;
    }

    /**
     * 
     * @param nombreMiembro
     * @param nombresAsociaciones
     * @return
     */
    public boolean existeMiembroEnListaAsociaciones(String nombreMiembro, String[] nombresAsociaciones) {
        boolean siEsta = false;
        boolean asociacionEncontrada = false;
        int i = 0, j = 0;

        while ((!siEsta) && (i < nombresAsociaciones.length)) {
            while ((!asociacionEncontrada) && (j < this.nElem)) {
                if (this.listaAsociaciones[j].getNombreAsociacion().equals(nombresAsociaciones[i])) {
                    asociacionEncontrada = true;

                } else {
                    j++;
                }
            }
            if (estaElMiembroActivoEnLaAsociacion(nombreMiembro, this.getElementoListaAsociacion(j))) {
                siEsta = true;
            } else {
                i++;
                asociacionEncontrada = false;
                j = 0;
            }

        }

        return siEsta;
    }

}
