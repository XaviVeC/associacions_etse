package prac3.Estructuras;

import prac3.Miembro.Miembro;

public class ListaMiembros {
    private Miembro[] listaMembres; // lista de miembros
    private int nElem; // numero de elementos de la lista miembros

    /**
     * Constructor de la clase LlistaMembres
     * 
     * @param numeroMembres - numero total de miembros para saber de que tamaño
     *                      hacer la lista
     * @return - lista de miembros del tamaño que entra por parametro
     */
    public ListaMiembros(int numeroMembres) {
        this.listaMembres = new Miembro[numeroMembres];
        nElem = 0;
    }

    /**
     * Metodo que añade una miembro que se pase por parametro en la ultima posicion
     * de la lista
     * 
     * @param miembroQueAniadir - miembro que hay que añadir
     * @return - la lista modificada
     */
    public void addMiembro(Miembro miembroQueAniadir) {
        listaMembres[nElem] = miembroQueAniadir.copia();
        nElem++;
    }

    /**
     * Getter de la variable nElem
     * 
     * @return - numero de miembros que tenemos en la lista
     */
    public int getNumeroMembres() {
        return nElem;
    }

    /**
     * Metodo que obtiene el Miembro de una posicion en especifico de la lista
     * pasada por parametro
     * 
     * @param indice - posicion de la lista que queremos obtener
     * @return - miembro que esta en la posicion indice
     */
    public Miembro getMiembroEnXIndice(int indice) {
        return this.listaMembres[indice].copia();
    }

    /**
     * Metodo que hace una copia de una lista de miembros
     * 
     * @return - variable nuevaLista, que es esta copia de la lista
     */
    public ListaMiembros copia() {
        int tamanioLista = this.listaMembres.length;
        ListaMiembros nuevaLista = new ListaMiembros(tamanioLista);

        for (int i = 0; i < tamanioLista; i++) {
            nuevaLista.listaMembres[i] = listaMembres[i].copia();
        }
        return nuevaLista;
    }

    /**
     * Metodo ToString de la lista de miembros
     * 
     * @return - lista con todos las miembros
     */
    public String toString() {
        String stringDeLaLista = "\n";

        for (int i = 0; i < this.nElem; i++) {
            stringDeLaLista = stringDeLaLista + "Los datos del miembro " + (i + 1) + " son:\n"
                    + listaMembres[i].toString() + "\n";
        }

        return stringDeLaLista;
    }

    /**
     * Metodo que crea una lista de miembros de una asociacion concreta
     * 
     * @param nombreAsociacion - variable que indica el nombre de la asociacion
     *                         sobre la que hacer su lista de miembros
     * @return - lista de miembros de la asociacion con ese nombre
     */

    // Me dan el nombre de la asociacion
    // He de mirar en a lista de asociaciones la que tenga el mismo nombre
    // He de mirar la lista de miembros de esa asociacion
    public static ListaMiembros miembrosDeAsociacionConcreta(String nombreAsociacion,
            ListaAsociaciones listaDeLasAsociaciones, ListaMiembros listaDeLosMiembros, String filtro) {
        ListaMiembros listaDeMiembrosDeXAsociacion = new ListaMiembros(listaDeLosMiembros.getNumeroMembres());
        int i = 0;
        boolean asociacionEncontrada = false, miembroDeTipoCorrectoEncontrado = false;
        String nombreTemporalAsociacion;
        while ((i < listaDeLasAsociaciones.getIndiceAsociaciones()) && !(asociacionEncontrada)) {
            nombreTemporalAsociacion = listaDeLasAsociaciones.getLlistaAssociacions()[i].getNombreAsociacion();
            if (nombreTemporalAsociacion.equals(nombreAsociacion)) {
                String aliasMiembro;
                int numeroElementosAsociacion = listaDeLasAsociaciones.getLlistaAssociacions()[i]
                        .getListaMiembrosAsociacion().length;
                for (int x = 0; x < numeroElementosAsociacion; x++) {
                    aliasMiembro = listaDeLasAsociaciones.getLlistaAssociacions()[i].getListaMiembrosAsociacion()[x];
                    int j = 0;
                    while ((!(miembroDeTipoCorrectoEncontrado)) && (j < listaDeLosMiembros.nElem)) {

                        if (listaDeLosMiembros.listaMembres[j].getAlias().equals(aliasMiembro)) {  //Lo he cambiado el getAlias
                            if (filtro.equals("Ambos")) {
                                listaDeMiembrosDeXAsociacion.addMiembro(listaDeLosMiembros.listaMembres[j].copia());
                                miembroDeTipoCorrectoEncontrado = true;
                            } else {
                                if (listaDeLosMiembros.listaMembres[j].getTipoMiembro().equals(filtro)) {
                                    listaDeMiembrosDeXAsociacion.addMiembro(listaDeLosMiembros.listaMembres[j].copia());
                                    miembroDeTipoCorrectoEncontrado = true;
                                } else {
                                    j++;
                                }
                            }

                        } else {

                            j++;
                        }
                    }
                    miembroDeTipoCorrectoEncontrado = false;
                }
                asociacionEncontrada = true;
            } else {
                i++;
            }
        }
        return listaDeMiembrosDeXAsociacion;
    }

    /**
     * OPCION 3 DEL MENU
     * Metodo que genera una sublista de miembros activos, aplicando un filtro si se
     * desea
     * 
     * @param listaDeLosMiembros - Lista que contiene a todos los miembros
     * @param filtro             - Filtro
     * @return - Sublista con los miembros
     */
    public static ListaMiembros miembrosActivosAplicandoFiltro(ListaMiembros listaDeTodosLosMiembros, String filtro) {
        ListaMiembros sublistaSegunFiltro = new ListaMiembros(listaDeTodosLosMiembros.getNumeroMembres());

        for (int i = 0; i < listaDeTodosLosMiembros.getNumeroMembres(); i++) {
            if (listaDeTodosLosMiembros.getMiembroEnXIndice(i).getFechaBaja().getyear() == 9999) {
                if (filtro.equals("Ambos")) {
                    sublistaSegunFiltro.addMiembro(listaDeTodosLosMiembros.getMiembroEnXIndice(i).copia());
                } else {
                    if (listaDeTodosLosMiembros.listaMembres[i].getTipoMiembro().equals(filtro)) {
                        sublistaSegunFiltro.addMiembro(listaDeTodosLosMiembros.getMiembroEnXIndice(i).copia());
                    }
                }
            }
        }
        return sublistaSegunFiltro;
    }

    public boolean miembroExistente(String alias, ListaMiembros listaTodosMiembros) {
        boolean existente = false;
        int i = 0;

        while ((!existente) && (i < listaTodosMiembros.getNumeroMembres())) {
            if (alias.equals(listaTodosMiembros.getMiembroEnXIndice(i).getAlias())) {
                existente = true;
            } else {
                i++;
            }
        }

        return existente;
    }

    /**
     * ACABAR AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
     * 
     * Calcular la persona que participa en mas asociaciones (RECORDAR QUE COMO
     * MAXIMO 3).
     * Si hay empate la que lleva mas tiempo en alguna de ellas. Si hay empate tmb,
     * qualquiera de las empatadas.
     */

    public Miembro personaEnMasAsociaciones(ListaAsociaciones listaTodasAsociaciones,
            ListaMiembros listaTodosMiembros) {
        Miembro miembroEnMasAsociaciones = null;
        int [] vectorNumeroVecesMiembro = new int [listaTodosMiembros.getNumeroMembres()];
        
        
        for (int indiceAsociaciones = 0; indiceAsociaciones < listaTodasAsociaciones.getIndiceAsociaciones(); indiceAsociaciones++) {
            
        }

        return miembroEnMasAsociaciones;
    }




    /**
     * Metodo que comprueba si un miembro pasado por parametro esta en alguna
     * asociacion
     * 
     * @param listaTodasAsociaciones - lista de todas las asociaciones
     * @param aliasMiembroAComprobar - alias del miembro que queremos comprobar
     * @return - booleano que indica si esta en alguna asociacion o no
     */
    public boolean estaElMiembroEnAlgunaAsociacion(ListaAsociaciones listaTodasAsociaciones,
            String aliasMiembroAComprobar) {
        boolean siEsta = false;
        int indiceAsociacion = 0;
        int indiceMiembroDeUnaAsoc;
        while (!(siEsta) && (indiceAsociacion < listaTodasAsociaciones.getIndiceAsociaciones())) {
            indiceMiembroDeUnaAsoc = 0;
            while ((indiceMiembroDeUnaAsoc < listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociacion)
                    .getListaMiembrosAsociacion().length) && !(siEsta)) {
                if (listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociacion)
                        .getListaMiembrosAsociacion()[indiceMiembroDeUnaAsoc].equals(aliasMiembroAComprobar)) {
                    siEsta = true;
                } else {
                    indiceMiembroDeUnaAsoc++;
                }
            }
            indiceAsociacion++;
        }
        return siEsta;
    }

    /**
     * Metodo que comprueba si un miembro esta en mas de tres asociaciones
     * 
     * @param listaTodasAsociaciones - lista de todas las asociaciones
     * @param aliasMiembroAComprobar - alias del miembro que queremos comprobar
     * @return - booleano que indica si esta en alguna asociacion o no
     */
    public boolean elMiembroEstaEnMasDeTresAsociaciones(ListaAsociaciones listaTodasAsociaciones,
            String aliasMiembroAComprobar) {
        boolean siEstaEnMasDeTres = false;
        int vecesQueEsta = 0;
        int indiceAsociacion = 0;
        int indiceMiembroDeUnaAsoc;
        while (!(siEstaEnMasDeTres) && (indiceAsociacion < listaTodasAsociaciones.getIndiceAsociaciones())) {
            indiceMiembroDeUnaAsoc = 0;
            while ((indiceMiembroDeUnaAsoc < listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociacion)
                    .getListaMiembrosAsociacion().length) && (vecesQueEsta > 3)) {
                if (listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociacion)
                        .getListaMiembrosAsociacion()[indiceMiembroDeUnaAsoc].equals(aliasMiembroAComprobar)) {
                    vecesQueEsta++;
                    if (vecesQueEsta > 3) {
                        siEstaEnMasDeTres = true;
                    }
                }
                indiceMiembroDeUnaAsoc++;
            }
            indiceAsociacion++;
        }
        return siEstaEnMasDeTres;
    }



    //public String[] titulacionesEnBaseAListaMiembros (ListaMiembros listaTodosMiembros){

  //  }

}