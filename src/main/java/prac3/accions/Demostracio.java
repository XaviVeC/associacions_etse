package prac3.accions;

import prac3.estructures.Data;


public class Demostracio extends Accio {
    private Data fechaDesign; // Fecha en la que se creo el disenio de la demostracion
    private boolean demostracionValida; // Da la informacion de si una demostracion que se continua ofreciendo
    private int contadorVecesOfrecida; // Contador de veces que se ha ofrecido una demostracion
    private double costoDemostracion; // Valor de dinero que ha costado crear la demostracion

    /**
     * Constructor de la classe Demostracio
     * @param indiceFichero - indice de la lista total de demostraciones existentes
     * @param tipoAccion - Especifiamos el tipo de accion que es
     * @param nombreAccion - nombre/titulo de la demostracion
     * @param asociacionesInvolucradas - asociaciones que estan involucradas en la demostracion
     * @param organizadorResponsable - miembro organizador de la demostracion
     * @param fechaDesign - fecha en la que se creo el disenio de la asociacion
     * @param costoDemostracion - costo de crear la asociacion
     */
    public Demostracio(int indiceFichero, String tipoAccion, String nombreAccion, String[] asociacionesInvolucradas, String organizadorResponsable, 
                       Data fechaDesign, double costoDemostracion) {
        // Atributos de la superclase
        super(indiceFichero, tipoAccion, nombreAccion, asociacionesInvolucradas, organizadorResponsable);
        
        // Atributos de esta subclase
        this.demostracionValida = true; // Cuando se crea una demostracion, se considera que se empieza a ofrecer en este instante
        this.contadorVecesOfrecida = 0; // Todavia no se ha ofrecido, ya que se acaba de crear
        this.fechaDesign = new Data(fechaDesign.getDia(), fechaDesign.getMes(), fechaDesign.getAnio()); // Hay que crear una nueva clase Data

        if (this.costoDemostracion < 0) { 
            this.costoDemostracion = -999; // Si el costo introducido es negativo, se asigna un costo que indica error
        }
        else {
            this.costoDemostracion = costoDemostracion; // Sino, se admite el introducido por parametro
        }
    }

    /**
     * Getter de si la demostracion es valida o no
     * @return - variable demostracionValida
     */
    public boolean getEstadoDemostracion() {
        return this.demostracionValida;
    }

    /**
     * Getter del contador de veces que se ha ofrecido la demostracion
     * @return - variable contadorVecesOfrecida
     */
    public int getVecesOfrecida() {
        return this.contadorVecesOfrecida;
    }

    /**
     * Getter del costo de la demostracion
     * @return - variable costoDemostracion
     */
    public double getCostoDemostracion() {
        return this.costoDemostracion;
    }

    /**
     * Getter de la fecha en la que se disenio la demostracion
     * @return - variable fechaDisenio
     */
    public Data getFechaDesign() {
        return this.fechaDesign;
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
     * @return - Texto con los datos de la demostracion
     */
    public String toString() {
        String aux = "Nombre de la demostracion: " + this.nombreAccion + "\n" +
        "Codigo de la demostracion: " + this.getCodigoAccion() + "\n" +
        "Fecha del design: " + fechaDesign.toString() + "\n" + 
        "Costo de la demostracion: " +this.costoDemostracion+ "\n" +
        "Veces que se ha ofrecido la demostracion: " +this.contadorVecesOfrecida+ "\n";

        if(this.demostracionValida == true)
        {
            aux = aux + "Estado demostracion: Disponible\n";
        }
        else{
            aux = aux + "Estado demostracion: No disponible\n";
        }

        aux = aux + "Organizador responsable: " + this.organizadorResponsable +"\n";
        
        for (int index = 0; index < asociacionesInvolucradas.length; index++) {
            aux = aux + "Asociacion involucrada "+ (index + 1)+ ": " + this.asociacionesInvolucradas[index] + "\n";
        }

        return aux;
    }

    /**
     * Metodo copia
     * @return - copia de la instancia
     */
    public Demostracio copia() {
        return (new Demostracio(this.indiceFichero, this.tipoAccion, this.nombreAccion, this.asociacionesInvolucradas, this.organizadorResponsable, 
                                this.fechaDesign, this.costoDemostracion));
    }
}
