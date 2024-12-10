package prac3.estructures;
import prac3.estructures.Data;
import prac3.accions.Accio;
import prac3.accions.Xerrada;

public class LlistaAccions {
    private Accio[] listaAcciones; // lista de acciones
    private int nElem; // numero de elementos de la lista acciones

    /**
     * Constructor de la clase LlistaAccions
     * 
     * @param numeroAcciones - numero total de acciones para saber de que size hacer
     *                       la lista
     * @return - lista de acciones del size que entra por parametro
     */
    public LlistaAccions(int numeroAcciones) {
        this.listaAcciones = new Accio[numeroAcciones];
        nElem = 0;
    }

    /**
     * Metodo que ingresa una accion que se pase por parametro en la ultima posicion
     * de la lista
     * 
     * @param accion - accion que hay que add
     * @return - la lista modificada
     */
    public void addAccion(Accio accion) {
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
    public Accio getAccionEnXIndice(int indice) {
        return this.listaAcciones[indice].copia();
    }

    /**
     * Metodo que hace una copia de una lista de acciones
     * 
     * @return - variable nuevaLista, que es esta copia de la lista
     */
    public LlistaAccions copia() {
        int sizeLista = this.listaAcciones.length;
        LlistaAccions nuevaLista = new LlistaAccions(sizeLista);

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

    // ES LA DE SALAT, estoy mirando si puede estar bien
    // ya te digo que no, asi mirandola por encima
    // OK, AUN ASI CREO Q HIZO YA EL EJECUTABLE EN EL MAIN
    public static LlistaAccions accionesSegunTipo(LlistaAccions listaTodasAcciones, String tipoAccion) {
        LlistaAccions sublistaSegunTipoAccion = new LlistaAccions(listaTodasAcciones.getNumeroAcciones());

        for (int i = 0; i < listaTodasAcciones.getNumeroAcciones(); i++) {
            if (tipoAccion.equals("Ambos")) {
                sublistaSegunTipoAccion.addAccion(listaTodasAcciones.getAccionEnXIndice(i));
            } else {
                if (listaTodasAcciones.getAccionEnXIndice(i).getTipoAccion().equals(tipoAccion)) {
                    sublistaSegunTipoAccion.addAccion(listaTodasAcciones.getAccionEnXIndice(i));
                }   
            }
        }
        return sublistaSegunTipoAccion;
    }


    /**
     * Metodo que obtiene y muestra una lista de acciones de una asociacion en concreto.
     * @param 
     * @param 
     */
    public static LlistaAccions accionesDeXAsociacion (LlistaAccions listaTodasAcciones, String asociacionConcreta){
        LlistaAccions listaAccionesFinal = new LlistaAccions(listaTodasAcciones.getNumeroAcciones());
        boolean asociacionEncontrada = false;
        for (int i = 0; i < listaTodasAcciones.nElem; i++){
            int x = 0;
            while ((!(asociacionEncontrada)) && (x < listaTodasAcciones.getAccionEnXIndice(i).getAsociacionesInvolucradas().length)) {
                if (listaTodasAcciones.getAccionEnXIndice(i).getAsociacionesInvolucradas()[x].equals(asociacionConcreta)){
                    asociacionEncontrada = true;
                    listaAccionesFinal.addAccion(listaTodasAcciones.getAccionEnXIndice(i));
                }
                else{
                    x++;
                }
            }
            asociacionEncontrada = false;
        }
        return listaAccionesFinal;
    }


    // Obtener y mostrar la lista de charlas que se llevan a término en una franja
    // de fechas
    // indicada por teclado

    public static LlistaAccions sublistaCharlasEnRangoFechas(LlistaAccions listaTodasLasAccines, Data limiteInferior, Data limiteSuperior){
        LlistaAccions sublistaCharlas = accionesSegunTipo(listaTodasLasAccines, "Charla");
        LlistaAccions sublistaCharlasSegunRango = new LlistaAccions(sublistaCharlas.nElem);
        for (int i = 0; i < sublistaCharlas.nElem; i++) {
            if (sublistaCharlas.listaAcciones[i].getFecha().compararFechas(limiteInferior) > 0 && sublistaCharlas.listaAcciones[i].getFecha().compararFechas(limiteSuperior) < 2) {
                sublistaCharlasSegunRango.addAccion(sublistaCharlas.listaAcciones[i]);//ejecuta el mio a ver si va porfa
            } 
        }
        return sublistaCharlasSegunRango;
    }




    
    






























}
