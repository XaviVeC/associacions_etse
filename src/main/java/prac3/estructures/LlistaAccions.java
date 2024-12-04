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
        nElem = numeroAcciones;
    }

    /**
     * Metodo que añade una accion que se pase por parametro en la ultima posicion de la lista
     * @param accionQueAñadir - accion que hay que añadir
     * @return - la lista modificada
     */
    public void añadirAccion (Accio accionQueAñadir){
        listaAcciones[nElem] = accionQueAñadir;
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
     * Metodo que hace una copia de una lista de acciones
     * @return - variable nuevaLista, que es esta copia de la lista
     */
    public LlistaAccions copiaLlistaAccions () {
        int tamañoLista = this.listaAcciones.length;
        LlistaAccions nuevaLista = new LlistaAccions(tamañoLista);

        for (int i = 0; i < tamañoLista; i++) {
            nuevaLista.listaAcciones[i] = listaAcciones[i].copia();
        }
        return nuevaLista;
    }


    /**
     * Metodo ToString de la llista de acciones
     * @return - lista con todas las acciones
     */
    public String ToStringLlistaAccions() {
        String stringDeLaLista = "";

        for (int i = 0; i < this.nElem; i++) {
            stringDeLaLista = stringDeLaLista + listaAcciones[i].toString() + "\n";
        }

        return stringDeLaLista;
    }


}
