package prac3.Estructuras;

import prac3.Miembro.Alumno;
import prac3.Miembro.Miembro;
import prac3.Asociacion.Asociacion;

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

                        if (listaDeLosMiembros.listaMembres[j].getAlias().equals(aliasMiembro)) { // Lo he cambiado el
                                                                                                  // getAlias
                            if (filtro.equalsIgnoreCase("Ambos")) {
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
     * @param filtro                 - Filtro de tipo de tipo de miembro
     * @param listaTodasAsociaciones - Lista que contiene a las asociaciones donde
     *                               estan los miembros
     * @return - Sublista con los miembros
     */
    public ListaMiembros miembrosActivosAplicandoFiltro(String filtro,
            ListaAsociaciones listaTodasAsociaciones) {
        ListaMiembros sublistaSegunFiltro = new ListaMiembros(this.nElem);
        String miembroAuxiliar;
        String[] miembrosDeLaAsociacion;
        boolean miembroActivoEncontrado = false;
        int indiceBusquedaAsociacion = 0, indiceMiembrosEnAsociacion = 0;
        Asociacion asociacionAuxiliar;
        Fecha[] fechasBajaMiembrosAsociacion;
        for (int i = 0; i < this.nElem; i++) {
            miembroAuxiliar = this.listaMembres[i].getAlias();
            while (!miembroActivoEncontrado
                    && (indiceBusquedaAsociacion < listaTodasAsociaciones.getIndiceAsociaciones())) {
                asociacionAuxiliar = listaTodasAsociaciones.getElementoListaAsociacion(indiceBusquedaAsociacion);
                miembrosDeLaAsociacion = asociacionAuxiliar.getListaMiembrosAsociacion();
                fechasBajaMiembrosAsociacion = asociacionAuxiliar.getFechasBaja();
                while (!miembroActivoEncontrado && (indiceMiembrosEnAsociacion < miembrosDeLaAsociacion.length)) {
                    if ((miembroAuxiliar.equals(miembrosDeLaAsociacion[indiceMiembrosEnAsociacion]))
                            && (fechasBajaMiembrosAsociacion[indiceMiembrosEnAsociacion].getyear() == 9999)) {
                        miembroActivoEncontrado = true;
                        if (filtro.equalsIgnoreCase("Ambos")) {
                            sublistaSegunFiltro.addMiembro(this.listaMembres[i]);
                        } else {
                            if (this.listaMembres[i].getTipoMiembro().equals(filtro)) {
                                sublistaSegunFiltro.addMiembro(this.listaMembres[i]);
                            }
                        }
                    } else {
                        indiceMiembrosEnAsociacion++;
                    }
                }
                indiceMiembrosEnAsociacion = 0;
                if (!miembroActivoEncontrado) {
                    indiceBusquedaAsociacion++;
                }
            }
            miembroActivoEncontrado = false;
            indiceBusquedaAsociacion = 0;

        }
        return sublistaSegunFiltro;
    }

    /**
     * Metodo que comprueba si existe el miembro en la lista que se le pase
     * 
     * @param alias              - Alias del miembro
     * @param listaTodosMiembros - Lista en la que se comprueba
     * @return - retorna el numero del indice en la que se encuentra, o un -1 si no
     *         existe
     */
    public int miembroExistente(String alias) {
        boolean existente = false;
        int i = 0;
        int codigoMiembro = -1;

        while ((!existente) && (i < this.nElem)) {
            if (alias.equals(this.listaMembres[i].getAlias())) {
                existente = true;
                codigoMiembro = i;
            } else {
                i++;
            }
        }
        return codigoMiembro;
    }

    /**
     * Metodo que devuelve el miembro que esta en mas asociaciones, en caso de que
     * haya empate, devuelve el que lleve mas tiempo en alguna de ellas.
     * 
     * @param listaTodasAsociaciones - variable con la lista de todas las
     *                               asociaciones
     * @param listaTodosMiembros     - variable con la lista de todos los miembros
     * @return - miembro que esta en mas asociaciones, en caso de empate, el que es
     *         mas antiguo en alguna de ellas
     */
    public Miembro miembroEnMasAsociaciones(ListaAsociaciones listaTodasAsociaciones,
            ListaMiembros listaTodosMiembros) {
        int[] vectorNumeroVecesMiembro = new int[listaTodosMiembros.nElem];
        int indiceMiembrosUnaAsoc;
        int indiceListaMiembros;
        boolean miembroEncontrado;

        // Creación del vector en el que guardo en cuantas asociaciones esta cada
        // miembro
        for (int indiceAsociaciones = 0; indiceAsociaciones < listaTodasAsociaciones
                .getIndiceAsociaciones(); indiceAsociaciones++) {
            indiceMiembrosUnaAsoc = 0;
            while (indiceMiembrosUnaAsoc < listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones)
                    .getListaMiembrosAsociacion().length) {
                indiceListaMiembros = 0;
                miembroEncontrado = false;
                while ((indiceListaMiembros < listaTodosMiembros.getNumeroMembres()) && !(miembroEncontrado)) {
                    if (listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones)
                            .getListaMiembrosAsociacion()[indiceMiembrosUnaAsoc]
                            .equals(listaTodosMiembros.getMiembroEnXIndice(indiceListaMiembros).getAlias())) {
                        vectorNumeroVecesMiembro[indiceListaMiembros]++;
                        miembroEncontrado = true;
                    } else {
                        indiceListaMiembros++;
                    }
                }
                indiceMiembrosUnaAsoc++;
            }
        }
        // Busqueda del miembro que tenga el numero mas grande sin pasarse de tres
        int indiceMiembroActivo = 0;
        for (int indiceVector = 0; indiceVector < vectorNumeroVecesMiembro.length; indiceVector++) {
            if (vectorNumeroVecesMiembro[indiceVector] > 3) {
                vectorNumeroVecesMiembro[indiceVector] = 0;
            } else {
                if (vectorNumeroVecesMiembro[indiceVector] > vectorNumeroVecesMiembro[indiceMiembroActivo]) {
                    indiceMiembroActivo = indiceVector;
                } else {
                    // Comprobación de fechasAlta para ver cual es mas antiguo en alguna de ellas
                    if (vectorNumeroVecesMiembro[indiceVector] == vectorNumeroVecesMiembro[indiceMiembroActivo]) {
                        Fecha fechaSarita = listaTodosMiembros.listaMembres[indiceVector]
                                .fechaMasAnteriorDeMiembro(listaTodasAsociaciones);
                        Fecha fechaPedrito = listaTodosMiembros.listaMembres[indiceMiembroActivo]
                                .fechaMasAnteriorDeMiembro(listaTodasAsociaciones);
                        if (fechaSarita.compararFechas(fechaPedrito) == 0) {
                            indiceMiembroActivo = indiceVector;
                        }
                    }
                }
            }
        }
        return listaTodosMiembros.getMiembroEnXIndice(indiceMiembroActivo);
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
     * Metodo que comprueba si un miembro esta en tres o mas asociaciones
     * 
     * @param listaTodasAsociaciones - lista de todas las asociaciones
     * @param aliasMiembroAComprobar - alias del miembro que queremos comprobar
     * @return - booleano que indica si esta en alguna asociacion o no
     */
    public boolean miembroPerteneceATresAsociaciones(ListaAsociaciones listaTodasAsociaciones,
            String aliasMiembroAComprobar) {
        boolean siEstaEnMasDeTres = false;
        int vecesQueEsta = 0;
        int indiceAsociacion = 0;
        int indiceMiembroDeUnaAsoc;
        while (!(siEstaEnMasDeTres) && (indiceAsociacion < listaTodasAsociaciones.getIndiceAsociaciones())) {
            indiceMiembroDeUnaAsoc = 0;
            while ((indiceMiembroDeUnaAsoc < listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociacion)
                    .getListaMiembrosAsociacion().length) && (vecesQueEsta < 3)) {
                if (listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociacion)
                        .getListaMiembrosAsociacion()[indiceMiembroDeUnaAsoc].equals(aliasMiembroAComprobar)) {
                    vecesQueEsta++;
                    if (vecesQueEsta > 2) {
                        siEstaEnMasDeTres = true;
                    }
                }
                indiceMiembroDeUnaAsoc++;
            }
            indiceAsociacion++;
        }
        return siEstaEnMasDeTres;
    }

    /**
     * Metodo que hace una lista de titulaciones en base a los miembros, sin repetir
     * titulaciones
     * 
     * @param listaTodosMiembros - variable donde estan todos los miembros
     * @param listaMiembros      - variable donde estan los miembros sobre los que
     *                           trabajamos
     * @return - lista de las titulaciones de los miembros de listaMiembros sin
     *         repeticion
     */
    public static String[] titulacionesEnBaseAListaMiembros(ListaMiembros listaTodosMiembros, String[] listaMiembros) {
        String[] listaTitulacionesConRepeticiones = new String[listaMiembros.length];
        int indiceMiembrosTotales;
        Alumno instanciaAlumno;
        for (int index = 0; index < listaMiembros.length; index++) {
            indiceMiembrosTotales = 0;
            boolean hecho = false;
            while ((indiceMiembrosTotales < listaTodosMiembros.getNumeroMembres()) && !(hecho)) {
                if (listaTodosMiembros.getMiembroEnXIndice(indiceMiembrosTotales).getAlias()
                        .equals(listaMiembros[index])) {
                    if (listaTodosMiembros.listaMembres[indiceMiembrosTotales] instanceof Alumno) {
                        instanciaAlumno = (Alumno) listaTodosMiembros.listaMembres[indiceMiembrosTotales];
                        listaTitulacionesConRepeticiones[index] = instanciaAlumno.getSiglasCarrera();
                        hecho = true;
                    } else {
                        indiceMiembrosTotales++;
                    }
                } else {
                    indiceMiembrosTotales++;
                }
            }
        }
        // desplazo los titulos para que no haya null de por medio ni en el primero
        for (int i = 0; i < listaTitulacionesConRepeticiones.length; i++) {
            if (listaTitulacionesConRepeticiones[i] == null) {
                while (listaTitulacionesConRepeticiones[i] == null) {
                    for (int j = i + 1; j < listaTitulacionesConRepeticiones.length; j++) {
                        listaTitulacionesConRepeticiones[j - 1] = listaTitulacionesConRepeticiones[j];
                    }
                }
            }
        }

        int titSinRepeticion = 1;
        int indiceFinal;
        boolean igual;
        String[] listaTitulosDefinitiva = new String[titSinRepeticion];
        listaTitulosDefinitiva[0] = listaTitulacionesConRepeticiones[0];
        for (int index = 1; index < titSinRepeticion + 1; index++) {
            for (int indicetitComprobando = 1; indicetitComprobando < listaTitulacionesConRepeticiones.length; indicetitComprobando++) {
                indiceFinal = indicetitComprobando - 1;
                igual = false;
                while ((!(igual)) && (indiceFinal >= 0)
                        && (listaTitulacionesConRepeticiones[indicetitComprobando] != null)) {
                    if (listaTitulacionesConRepeticiones[indicetitComprobando]
                            .equals(listaTitulacionesConRepeticiones[indiceFinal])) {
                        igual = true;
                    } else {
                        indiceFinal--;
                    }
                }
                if (!(igual)) {
                    listaTitulosDefinitiva[index] = listaTitulacionesConRepeticiones[indicetitComprobando];
                }
            }
        }
        return listaTitulosDefinitiva;
    }

}