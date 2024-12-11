package prac3.Miembro;
import prac3.Estructuras.Fecha;
import prac3.Estructuras.ListaAsociaciones;
//Clase base 
public abstract class Miembro {

    //DADES
    protected int indiceFichero; // Identificador dentro del fichero
    protected String tipoMiembro; // indica si es Professor o Alumne
    protected String alias;// Alias del membre 
    protected String correoMiembro;// Correo electronico del miembro 
    //MÉTODES
    
    /**
     * Metodo constructor de la clase Membre
     * @param indiceFichero - identificador dentro del fichero
     * @param tipoMiembro - si es Alumne o Professor
     * @param alias - Alias del nombreMiembrobre del miembro
     * @param correoMiembro - Correo del miembro
     * @return - Constructor Membre
     */
    public Miembro (int indiceFichero, String tipoMiembro, String alias){
        this.indiceFichero = indiceFichero;
        this.tipoMiembro = tipoMiembro;
        this.alias = alias;
        this.correoMiembro = alias + "@urv.cat";
    }

    /**
     * Getter de la variable indiceFiechero
     * @return - variable indiceFichero
     */
    public int getIndiceFichero() {
        return indiceFichero;
    }

    /**
     * Getter de la variable tipoMiembro
     * @return - variable tipoMiembro
     */
    public String getTipoMiembro() {
        return tipoMiembro;
    }

    /**
     * Getter de la variable alias
     * @return - variable alias
     */
    public String getAlias(){
        return alias;
    }

    /**
     * Getter de la variable correoMiembro
     * @return - variable correoMiembro
     */
    public String getCorreoMiembro(){
        return correoMiembro;
    }

    
    /**
     * Metodo que hace una copia de un miembro
     * @return - miembro copiado
     */
    public abstract Miembro copia();

    /**
     * Metodo imprime los datos de un miembro en concreto
     * @return - datos de un miembro en concreto por pantalla
     */
    public abstract String toString();


    public abstract String getSiglasCarrera();



    /**
     * Metodo que busca la fechaAlta mas antigua de un miembro
     * @param miembroSobreElQueBuscar - variable del miembro
     * @return - variable fechaAnterior
     */
    public Fecha fechaMasAnteriorDeMiembro (ListaAsociaciones listaTodasAsociaciones){
        Fecha fechaAnterior = null;
        int indiceListaMiembrosAsociacion;
        boolean hecho;
        for (int indiceAsociaciones = 0; indiceAsociaciones < listaTodasAsociaciones.getIndiceAsociaciones(); indiceAsociaciones++) {
            indiceListaMiembrosAsociacion = 0;
            hecho = false;
            while ((indiceListaMiembrosAsociacion < listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones).getListaMiembrosAsociacion().length) && (!hecho)) {
                if (listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones).getListaMiembrosAsociacion()[indiceListaMiembrosAsociacion].equals(alias)) {
                    if (listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones).getFechasBaja()[indiceListaMiembrosAsociacion].getDia() == 99) {
                        if (fechaAnterior == null) {
                            fechaAnterior = listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones).getFechasAlta()[indiceListaMiembrosAsociacion].copia();
                            hecho = true;
                        }
                        else{
                            if (fechaAnterior.compararFechas(listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones).getFechasAlta()[indiceListaMiembrosAsociacion]) == 2) {
                                fechaAnterior = listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones).getFechasAlta()[indiceListaMiembrosAsociacion].copia();
                            }
                            else{
                                if(fechaAnterior.compararFechas(listaTodasAsociaciones.getElementoListaAsociacion(indiceAsociaciones).getFechasAlta()[indiceListaMiembrosAsociacion]) != 2){
                                    hecho = true;
                                }
                            }
                        }
                    }
                    else{
                        hecho = true;
                    }
                }
                else{
                    indiceListaMiembrosAsociacion++;
                }
            }
            
        }
        return fechaAnterior;
    }
}
