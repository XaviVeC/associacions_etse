package prac3.estructures;
import prac3.integrants.Membre;

public class LlistaMembres {
    private Membre[] listaMembres; // lista de miembros
    private int nElem; // numero de elementos de la lista miembros

    /**
     * Constructor de la clase LlistaMembres
     * 
     * @param numeroMembres - numero total de miembros para saber de que tamaño
     *                      hacer la lista
     * @return - lista de miembros del tamaño que entra por parametro
     */
    public LlistaMembres(int numeroMembres) {
        this.listaMembres = new Membre[numeroMembres];
        nElem = 0;
    }

    /**
     * Metodo que añade una miembro que se pase por parametro en la ultima posicion
     * de la lista
     * 
     * @param miembroQueAniadir - miembro que hay que añadir
     * @return - la lista modificada
     */
    public void addMiembro(Membre miembroQueAniadir) {
        listaMembres[nElem] = miembroQueAniadir;
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
    public Membre getMiembroEnXIndice(int indice) {
        return this.listaMembres[indice].copia();
    }

    /**
     * Metodo que hace una copia de una lista de miembros
     * 
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
     * FALTA ACABAR PORQUE NO SE COMO HACERLO !!!!!!!!!!!!!!!!
     * 
     * 
     * Metodo que crea una lista de miembros de una asociacion concreta
     * 
     * @param nombreAsociacion - variable que indica el nombre de la asociacion
     *                         sobre la que hacer su lista de miembros
     * @return - lista de miembros de la asociacion con ese nombre
     */

    // Me dan el nombre de la asociacion
    // He de mirar en a lista de asociaciones la que tenga el mismo nombre
    // He de mirar la lista de miembros de esa asociacion
    public static LlistaMembres miembrosDeAsociacionConcreta(String nombreAsociacion,
            LlistaAssociacions listaDeLasAsociaciones, LlistaMembres listaDeLosMiembros, String filtro) {
        LlistaMembres listaDeMiembrosDeXAsociacion = new LlistaMembres(listaDeLosMiembros.getNumeroMembres());
        int i = 0;
        boolean asociacionEncontrada = false, miembroDeTipoCorrectoEncontrado = false;
        String nombreTemporalAsociacion;
        while ((i < listaDeLasAsociaciones.getIndiceAsociaciones()) && !(asociacionEncontrada)) {
            nombreTemporalAsociacion = listaDeLasAsociaciones.getLlistaAssociacions()[i].getNombreAsociacion();
            if (nombreTemporalAsociacion.equals(nombreAsociacion)) {
                String nombreMiembro;
                int numeroElementosAsociacion = listaDeLasAsociaciones.getLlistaAssociacions()[i]
                        .getListaMiembrosAsociacion().length;
                for (int x = 0; x < numeroElementosAsociacion; x++) {
                    nombreMiembro = listaDeLasAsociaciones.getLlistaAssociacions()[i].getListaMiembrosAsociacion()[x];
                    int j = 0;
                    while ((!(miembroDeTipoCorrectoEncontrado)) && (j < listaDeLosMiembros.nElem)) {

                        if (listaDeLosMiembros.listaMembres[j].getnombreMiembro().equals(nombreMiembro)) {
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

    public static LlistaMembres miembrosActivos(LlistaMembres listaDeLosMiembros, String filtro) {
        LlistaMembres sublistaSegunFiltro = new LlistaMembres(listaDeLosMiembros.getNumeroMembres());

        for (int i = 0; i < listaDeLosMiembros.getNumeroMembres(); i++) {
            if (listaDeLosMiembros.getMiembroEnXIndice(i).getFechaBaja().getyear() == 9999) {
                if (filtro.equals("Ambos")) {
                    sublistaSegunFiltro.addMiembro(listaDeLosMiembros.getMiembroEnXIndice(i).copia());
                } else {
                    if (listaDeLosMiembros.listaMembres[i].getTipoMiembro().equals(filtro)) {
                        sublistaSegunFiltro.addMiembro(listaDeLosMiembros.getMiembroEnXIndice(i).copia());
                    }
                }
            }
        }   
        return sublistaSegunFiltro;
    }

    public boolean miembroExistente(String alias, LlistaMembres listaTodosMiembros) {
        boolean existente = false;
        int i = 0;

        while ((!existente) && (i < listaTodosMiembros.getNumeroMembres())) {
            if (alias.equals(listaTodosMiembros.getMiembroEnXIndice(i).getAlias())) {
                existente = true;
            }
            else {
                i++;
            }
        }

        return existente;
    }














    
}