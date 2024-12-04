package prac3.estructures;
import prac3.accions.Accio;

public class LlistaAccions {
    private Accio [] listaAcciones;     // lista de acciones
    private int nElem;                  // numero de eelementos de la lista acciones

    /**
     * Constructor de la clase LlistaAccions
     * @param numeroAcciones - numero total de acciones para saber de que tamaño hacer la lista
     * @return - lista de acciones del tamaño que entra por parametro
     */
    public LlistaAccions (int numeroAcciones){
        this.listaAcciones = new Accio[numeroAcciones];
        nElem = 0;
    }

    /**
     * Metodo que añade una accion que se pase por parametro en la ultima posicion de la lista
     * @param accionQueAniadir - accion que hay que añadir
     * @return - la lista modificada
     */
    public void aniadirAccion (Accio accionQueAniadir){
        listaAcciones[nElem] = accionQueAniadir;
        nElem++;
    }

    /**
     * Getter de la variable nElem
     * @return - numero de acciones que tenemos en la lista
     */
    public int getNumeroAcciones (){
        return nElem;
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
        int tamanioLista = this.listaAcciones.length;
        LlistaAccions nuevaLista = new LlistaAccions(tamanioLista);

        for (int i = 0; i < tamanioLista; i++) {
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

        for (int i = 0; i < this.nElem; i++) {
            stringDeLaLista = stringDeLaLista + listaAcciones[i].toString() + "\n";
        }

        return stringDeLaLista;
    }
}
