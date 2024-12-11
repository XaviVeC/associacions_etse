package prac3.Accion;

import prac3.Estructuras.Fecha;

public class Demostracion extends Accion {
    private Fecha fechaCreacion; // Fecha en la que se creo el disenio de la demostracion
    private boolean demostracionValida; // Da la informacion de si una demostracion que se continua ofreciendo
    private int contadorVecesOfrecida; // Contador de veces que se ha ofrecido una demostracion
    private double costoDemostracion; // Valor de dinero que ha costado crear la demostracion

    /**
     * Constructor de la classe Demostracio
     * 
     * @param indiceFichero            - indice de la lista total de demostraciones
     *                                 existentes
     * @param tipoAccion               - Especifiamos el tipo de accion que es
     * @param nombreAccion             - nombre/titulo de la demostracion
     * @param asociacionesInvolucradas - asociaciones que estan involucradas en la
     *                                 demostracion
     * @param organizadorResponsable   - miembro organizador de la demostracion
     * @param fechaCreacion            - fecha en la que se creo la demostracion
     * @param costoDemostracion        - costo de crear la asociacion
     * @param estadoDemostracion       - demostracion activa o no activa
     * @param vecesOfrecida            - Cuantas veces se ofrecio la demostracion
     */
    public Demostracion(int indiceFichero, String tipoAccion, String nombreAccion, String[] asociacionesInvolucradas,
            String organizadorResponsable,
            Fecha fechaCreacion, double costoDemostracion, boolean estadoDemostracion, int vecesOfrecida) {
        // Atributos de la superclase
        super(indiceFichero, tipoAccion, nombreAccion, asociacionesInvolucradas, organizadorResponsable);

        // Atributos de esta subclase
        this.demostracionValida = estadoDemostracion; // Cuando se crea una demostracion, se considera que se empieza a
                                                      // ofrecer en este instante
        this.contadorVecesOfrecida = vecesOfrecida; // Todavia no se ha ofrecido, ya que se acaba de crear
        this.fechaCreacion = new Fecha(fechaCreacion.getDia(), fechaCreacion.getMes(), fechaCreacion.getyear()); // Hay
                                                                                                                // que
                                                                                                                // crear
                                                                                                                // una
                                                                                                                // nueva
                                                                                                                // clase
                                                                                                                // Data

        if (this.costoDemostracion < 0) {
            this.costoDemostracion = -999; // Si el costo introducido es negativo, se asigna un costo que indica error
        } else {
            this.costoDemostracion = costoDemostracion; // Sino, se admite el introducido por parametro
        }
    }

    /**
     * Getter de si la demostracion es valida o no
     * 
     * @return - variable demostracionValida
     */
    public boolean getEstado() {
        return this.demostracionValida;
    }

    /**
     * Getter del contador de veces que se ha ofrecido la demostracion
     * 
     * @return - variable contadorVecesOfrecida
     */
    public int getVecesOfrecida() {
        return this.contadorVecesOfrecida;
    }

    /**
     * Getter del coste de una demostracion
     * 
     * @return - variable costoDemostracion
     */
    public double getCoste() {
        return this.costoDemostracion;
    }
    /**
     * Getter de la fecha de creacion
     */
    public Fecha getFecha() {
        return this.fechaCreacion;
    }

    /**
     * Getter del costo de la demostracion
     * 
     * @return - variable costoDemostracion
     */
    public double getCostoDemostracion() {
        return this.costoDemostracion;
    }
    
//nada porque no hay
    public int getNumeroAsistentes() {
        return 0;
    }
    /**
     * Getter de la fecha en la que se disenio la demostracion
     * 
     * @return - variable fechaDisenio
     */
    public Fecha getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * Metodo que inhabilita una demostracion
     */
    public void deshabilitarDemostracion() {
        this.demostracionValida = false;
    }

    /**
     * Metodo que rehabilita una demostracion que ha sido inhabilitada anteriormente
     */
    public void habilitarDemostracion() {
        this.demostracionValida = true;
    }

    /**
     * Metodo que aumenta el contador de veces que se ha ofrecido una demostracion
     */
    public void ofrecidaDeNuevo() {
        this.contadorVecesOfrecida++;
    }

    /**
     * Metodo toString
     * 
     * @return - Texto con los datos de la demostracion
     */
    public String toString() {
        String aux = "\t\t\tNombre de la demostracion: " + this.nombreAccion + "\n" +
                "\t\t\tCodigo de la demostracion: " + this.codigoAccion + "\n" +
                "\t\t\tFecha de la creacion: " + fechaCreacion.toString() + "\n" +
                "\t\t\tCosto de la demostracion: " + this.costoDemostracion + "\n" +
                "\t\t\tVeces que se ha ofrecido la demostracion: " + this.contadorVecesOfrecida + "\n";

        if (this.demostracionValida == true) {
            aux = aux + "\t\t\tEstado demostracion: Disponible\n";
        } else {
            aux = aux + "\t\t\tEstado demostracion: No disponible\n";
        }

        aux = aux + "\t\t\tOrganizador responsable: " + this.organizadorResponsable + "\n" +
                "\t\t\tLas asociaciones involucradas son:\n";

        for (int index = 0; index < asociacionesInvolucradas.length; index++) {
            aux = aux + "\t\t\t\tAsociacion " + (index + 1) + " --> " + this.asociacionesInvolucradas[index] + "\n";
        }

        return aux;
    }

    /**
     * Metodo copia
     * 
     * @return - copia de la instancia
     */
    public Demostracion copia() {
        return (new Demostracion(this.indiceFichero, this.tipoAccion, this.nombreAccion, this.asociacionesInvolucradas,
                this.organizadorResponsable,
                this.fechaCreacion, this.costoDemostracion, this.demostracionValida, this.contadorVecesOfrecida));
    }



}
