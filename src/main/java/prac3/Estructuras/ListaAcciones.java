package prac3.Estructuras;

import prac3.Accion.Accion;
import prac3.Accion.Charla;
import prac3.Accion.Demostracion;

public class ListaAcciones {
    private Accion[] listaAcciones; // lista de acciones
    private int nElem; // numero de elementos de la lista acciones

    /**
     * Constructor de la clase LlistaAccions
     * 
     * @param numeroAcciones - numero total de acciones para saber de que size hacer
     *                       la lista
     * @return - lista de acciones del size que entra por parametro
     */
    public ListaAcciones(int numeroAcciones) {
        this.listaAcciones = new Accion[numeroAcciones];
        nElem = 0;
    }

    /**
     * Metodo que ingresa una accion que se pase por parametro en la ultima posicion
     * de la lista
     * 
     * @param accion - accion que hay que add
     * @return - la lista modificada
     */
    public void addAccion(Accion accion) {
        if (nElem < this.listaAcciones.length) {
            listaAcciones[nElem] = accion.copia();
            nElem++;
        }
    }

    /**
     * Getter de la variable nElem
     * 
     * @return - numero de acciones que tenemos en la lista
     */
    public int getNumeroAcciones() {
        return this.nElem;
    }

    /**
     * 
     * @param indice
     * @return
     */
    public Accion getAccionEnXIndice(int indice) {
        return this.listaAcciones[indice].copia();// habia un copia lo he quitado un momento (carla)
    }

    /**
     * 
     * @param indice
     * @return
     */
    public Accion getAccionEnXIndiceSinCopia(int indice) {
        return this.listaAcciones[indice];// habia un copia lo he quitado un momento (carla)
    }

    /**
     * Metodo que hace una copia de una lista de acciones
     * 
     * @return - variable nuevaLista, que es esta copia de la lista
     */
    public ListaAcciones copia() {
        int sizeLista = this.listaAcciones.length;
        ListaAcciones nuevaLista = new ListaAcciones(sizeLista);

        for (int i = 0; i < sizeLista; i++) {
            nuevaLista.listaAcciones[i] = listaAcciones[i].copia();
        }
        return nuevaLista;
    }

    /**
     * Metodo ToString de la llista de acciones
     * 
     * @return - lista con todas las acciones
     */
    public String toString() {
        String stringDeLaLista = "";

        for (int i = 0; i < nElem; i++) {
            stringDeLaLista = stringDeLaLista + "La accion " + (i + 1) + " es:\n" + listaAcciones[i].toString() + "\n";
        }

        return stringDeLaLista;
    }

    /**
     * Metodo que retorna una sublista con el tipo de accion que se desee.
     * 
     * @param tipoAccion - Filtro para el tipo de la accion
     * @return - Lista con todas las acciones con el filtro aplicado.
     */
    public ListaAcciones accionesSegunTipo(String tipoAccion) {
        ListaAcciones sublistaSegunTipoAccion = new ListaAcciones(this.nElem);

        for (int i = 0; i < this.nElem; i++) {
            if (tipoAccion.equalsIgnoreCase("Ambos")) {
                sublistaSegunTipoAccion.addAccion(this.listaAcciones[i]);
            } else {
                if (this.listaAcciones[i].getTipoAccion().equals(tipoAccion)) {
                    sublistaSegunTipoAccion.addAccion(this.listaAcciones[i]);
                }
            }
        }
        return sublistaSegunTipoAccion;
    }

    /**
     * Metodo que obtiene y muestra una lista de acciones de una asociacion en
     * concreto.
     * 
     * @param
     * @param
     */
    public static ListaAcciones accionesDeXAsociacion(ListaAcciones listaTodasAcciones, String asociacionConcreta) {
        ListaAcciones listaAccionesFinal = new ListaAcciones(listaTodasAcciones.getNumeroAcciones());
        boolean asociacionEncontrada = false;
        for (int i = 0; i < listaTodasAcciones.nElem; i++) {
            int x = 0;
            while ((!(asociacionEncontrada))
                    && (x < listaTodasAcciones.getAccionEnXIndice(i).getAsociacionesInvolucradas().length)) {
                if (listaTodasAcciones.getAccionEnXIndice(i).getAsociacionesInvolucradas()[x]
                        .equals(asociacionConcreta)) {
                    asociacionEncontrada = true;
                    listaAccionesFinal.addAccion(listaTodasAcciones.getAccionEnXIndice(i));
                } else {
                    x++;
                }
            }
            asociacionEncontrada = false;
        }
        return listaAccionesFinal;
    }

    /**
     * Metodo que retorna una sublista de charlas, pero que se encuentran dentro de
     * un rango de fechas.
     * 
     * @param limiteInferior - Fecha del limite inferior
     * @param limiteSuperior - Fecha del limite superior
     * @return - Lista de charlas dentro del rango de fechas
     */
    public ListaAcciones sublistaCharlasEnRangoFechas(Fecha limiteInferior, Fecha limiteSuperior) {
        ListaAcciones sublistaCharlas = this.accionesSegunTipo("Charla");
        ListaAcciones sublistaCharlasSegunRango = new ListaAcciones(sublistaCharlas.nElem);
        for (int i = 0; i < sublistaCharlas.nElem; i++) {
            if (sublistaCharlas.listaAcciones[i].getFecha().compararFechas(limiteInferior) > 0
                    && sublistaCharlas.listaAcciones[i].getFecha().compararFechas(limiteSuperior) < 2) {
                sublistaCharlasSegunRango.addAccion(sublistaCharlas.listaAcciones[i]);
            }
        }
        return sublistaCharlasSegunRango;
    }

    /**
     * Metodo que comprueba si una nombre ya esta dentro de una lista de charlas.
     * OPCION DE MENU 9
     * 
     * @param nombreCharla - Nombre de la charla que se quiere comprobar si ya esta
     *                     en la lista.
     * @return - Retorna true si ya esta en la lista o false si no esta.
     */
    public boolean existeCharla(String nombreCharla) {
        boolean repetida = false;
        int i = 0;
        ListaAcciones listaCharlas = this.accionesSegunTipo("Charla");
        while ((!repetida) && (i < listaCharlas.nElem)) {
            if (listaCharlas.listaAcciones[i].getNombreAccion().equals(nombreCharla)) {
                repetida = true;
            } else {
                i++;
            }
        }
        return repetida;
    }

    /**
     * Metodo que filtra las demostraciones segun un booleano que se le pasa por
     * parametro.
     * Se utiliza para la opcion 11 del menu.
     * 
     * @param opcionFiltro - Elegimos si queremos las demostraciones activas o las
     *                     que ya no lo estan.
     * @return - Retorna una lista con las demostraciones pasadas por filtro.
     */
    public ListaAcciones listaDemostracionesFiltradasSegunEstado(boolean opcionFiltro) {
        ListaAcciones listaDemostraciones = accionesSegunTipo("Demostracion");
        ListaAcciones listaDemostracionesFiltradas = new ListaAcciones(listaDemostraciones.nElem);
        // es un recorrido de la lista desde la que se ejecuta
        for (int index = 0; index < listaDemostraciones.nElem; index++) {
            // enfoque de instanceof
            if (listaDemostraciones.listaAcciones[index] instanceof Demostracion) {
                Demostracion instanciaDemostracion = (Demostracion) listaDemostraciones.listaAcciones[index];
                // en el caso que el estado sea igual al del filtro
                if (instanciaDemostracion.getEstado() == opcionFiltro) {
                    // se hara un add a la sublista "demostracionesFiltradas" que hemos creado
                    listaDemostracionesFiltradas.addAccion(instanciaDemostracion);
                }
            }
        }
        return listaDemostracionesFiltradas;
    }

    /**
     * Metodo que se llama desde una listaAcciones, y retorna el coste total de
     * todas las demostraciones.
     * Se utiliza para la opcion 11 del menu.
     * 
     * @return - Coste total de las demostraciones de una listaAcciones
     */
    public double costeTotalDemostraciones() {
        double acumulado = 0.0;
        Demostracion instanciaDemostracion;
        for (int i = 0; i < this.nElem; i++) {
            if (this.listaAcciones[i] instanceof Demostracion) {
                instanciaDemostracion = (Demostracion) this.listaAcciones[i];
                acumulado += instanciaDemostracion.getCoste();
            }
        }
        return acumulado;
    }

    /**
     * 
     * @param numeroAsistentes
     * @return
     */
    public ListaAcciones listaCharlasMasXAsistentes(int numeroAsistentes) {
        ListaAcciones listaCharlas = accionesSegunTipo("Charla");
        ListaAcciones charlasMasXAsistentes = new ListaAcciones(listaCharlas.nElem);
        Charla instanciaDeCharla;
        for (int i = 0; i < listaCharlas.nElem; i++) {
            if (listaCharlas.listaAcciones[i] instanceof Charla) {
                instanciaDeCharla = (Charla) listaCharlas.listaAcciones[i];
                if (instanciaDeCharla.getNumeroAsistentes() > numeroAsistentes) {
                    charlasMasXAsistentes.addAccion(instanciaDeCharla);
                }
            }

        }
        return charlasMasXAsistentes;
    }

    /**
     * Metodo que te hace una busqueda de las charlas en las que esta un miembro en
     * concreto
     * 
     * @param listaTodosMiembros       - lista de todos los miembros
     * @param listaTodasAcciones       - lista de todas las acciones
     * @param aliasMiembroQueComprobar - alias del miembro que queremos comprobar
     * @return - lista de las charlas en las que participa el miembro que pasa por
     *         parametro
     */
    public ListaAcciones listaCharlasDeXMiembro(ListaMiembros listaTodosMiembros, String aliasMiembroQueComprobar) {
        ListaAcciones listaCharlas = this.accionesSegunTipo("Charla");
        ListaAcciones listaCharlasDefinitiva = new ListaAcciones(listaCharlas.nElem);
        for (int i = 0; i < listaCharlas.nElem; i++) {
            if (listaCharlas.listaAcciones[i].getOrganizadorResponsable().equals(aliasMiembroQueComprobar)) {
                listaCharlasDefinitiva.addAccion(listaCharlas.listaAcciones[i]);
            }
        }
        return listaCharlasDefinitiva;
    }

    /**
     * Metodo que comprueba si una charla esta en la lista o no en base a su nombre
     * 
     * @param listaDeTodasLasAcciones - lista de todas las acciones
     * @param nombreCharla            - nombre de la charla en la que buscamos
     * @return - = true = si que esta la charla, false = no esta la charla
     */
    public boolean estaLaCharlaEnLaListaDeAcciones(ListaAcciones listaDeTodasLasAcciones, String nombreCharla) {
        int indice = 0;
        boolean siEsta = false;
        while (!siEsta && indice < listaDeTodasLasAcciones.getNumeroAcciones()) {
            if (listaDeTodasLasAcciones.getAccionEnXIndice(indice).getNombreAccion().equals(nombreCharla)) {
                siEsta = true;
            } else {
                indice++;
            }
        }
        return siEsta;
    }

    /**
     * Método para eliminar una Accion que sea anterior a la fecha
     */

    public void eliminarAccionPorFecha(Fecha fecha) {
        for (int i = 0; i < nElem; i++) {
            if (listaAcciones[i].getFecha().equals(fecha)) {
                for (int j = i; j < nElem; j++) {
                    listaAcciones[j] = listaAcciones[j + 1];
                }
                listaAcciones[nElem - 1] = null;
                nElem--;
            }
        }
    }

    /**
     * OPCION 15 DEL MENU
     * Metodo que retorna la charla con mejor media de valoraciones, en el caso de
     * que dos valoraciones tengan la misma media, se queda con la que tenga más
     * valoraciones,
     * en caso de enpate se queda con la que sea.
     * 
     * @return - La charla con mejores valoraciones
     */
    public Charla charlaMejorValorada() {
        ListaAcciones listaDeLasCharlas = this.accionesSegunTipo("Charla");
        Charla charlaConMejorValoracion = (Charla) listaDeLasCharlas.listaAcciones[0];
        Charla charlaAComparar;
        for (int i = 1; i < listaDeLasCharlas.nElem; i++) {
            charlaAComparar = (Charla) listaDeLasCharlas.listaAcciones[i];
            if (charlaAComparar.mediaValoraciones() >= charlaConMejorValoracion.mediaValoraciones()) {
                if (charlaAComparar.mediaValoraciones() == charlaConMejorValoracion.mediaValoraciones()) {
                    if (charlaAComparar.getIndiceValoraciones() > charlaConMejorValoracion.getIndiceValoraciones()) {
                        charlaConMejorValoracion = charlaAComparar;
                    }
                } else {
                    charlaConMejorValoracion = charlaAComparar;
                }
            }
        }
        return charlaConMejorValoracion;
    }

    /**
     * OPCION 14 DEL MENU
     * Metodo para valorar la charla cuyo nombre se pasa por parametro, junto a la
     * valoracion.
     * 
     * @param nombreCharla - Nombre de la charla que se va a valorar
     * @param valoracion   - Valoracion
     * @return - Codigo del resultado 0 --> valorada correctamente, 1 --> No se ha
     *         encontrado la charla, 2 --> No se pueden poner mas valoraciones, 
     *         3 --> valor de valoracion incorrecto
     */
    public int valorarXCharla(String nombreCharla, int valoracion) {
        boolean charlaEncontrada = false;
        int indiceBusqueda = 0;
        int codigoResultado = 1;
        while (indiceBusqueda < this.nElem && !charlaEncontrada) {
            if ((this.listaAcciones[indiceBusqueda] instanceof Charla)
                    && (this.listaAcciones[indiceBusqueda].getNombreAccion().equals(nombreCharla))) {
                charlaEncontrada = true;
                Charla castinCharla = (Charla) this.listaAcciones[indiceBusqueda];
                if (castinCharla.getIndiceValoraciones() < castinCharla.getNumeroAsistentes()) {
                    if (valoracion > 0 && valoracion <= 10) {
                        castinCharla.hacerValoracion(valoracion);
                        codigoResultado = 0;
                    } else {
                        codigoResultado = 3;
                    }
                } else {
                    codigoResultado = 2;
                }
            } else {
                indiceBusqueda++;
            }

        }
        return codigoResultado;
    }

}
