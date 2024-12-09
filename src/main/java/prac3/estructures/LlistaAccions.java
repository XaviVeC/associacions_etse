package prac3.estructures;
import prac3.accions.Accio;

public class LlistaAccions {
    private Accio [] listaAcciones;     // lista de acciones
    private int nElem;                  // numero de elementos de la lista acciones

    /**
     * Constructor de la clase LlistaAccions
     * @param numeroAcciones - numero total de acciones para saber de que size hacer la lista
     * @return - lista de acciones del size que entra por parametro
     */
    public LlistaAccions (int numeroAcciones){
        this.listaAcciones = new Accio[numeroAcciones];
        nElem = 0;
    }

    /**
     * Metodo que ingresa una accion que se pase por parametro en la ultima posicion de la lista
     * @param accion - accion que hay que add
     * @return - la lista modificada
     */
    public void addAccion (Accio accion){
        if (nElem < this.listaAcciones.length) {
            listaAcciones[nElem] = accion.copia();
            nElem++;
        }
    }
    
    /**
     * Getter de la variable nElem
     * @return - numero de acciones que tenemos en la lista
     */
    public int getNumeroAcciones (){
        return this.nElem;
    }

    /**
     * 
     * @param indice
     * @return
     */
    public Accio getAccionEnXIndice(int indice){
        return this.listaAcciones[indice].copia();
    }

    /**
     * Metodo que hace una copia de una lista de acciones
     * @return - variable nuevaLista, que es esta copia de la lista
     */
    public LlistaAccions copia () {
        int sizeLista = this.listaAcciones.length;
        LlistaAccions nuevaLista = new LlistaAccions(sizeLista);

        for (int i = 0; i < sizeLista; i++) {
            nuevaLista.listaAcciones[i] = listaAcciones[i].copia();
        }
        return nuevaLista;
    }

    /**
     * Metodo ToString de la llista de acciones
     * @return - lista con todas las acciones
     */
    public String toString() {
        String stringDeLaLista = "";

        for (int i = 0; i < this.listaAcciones.length; i++) {
            stringDeLaLista = stringDeLaLista + "La accion "  + (i+1) + " es:\n"+listaAcciones[i].toString() + "\n";
        }

        return stringDeLaLista;
    }





}
