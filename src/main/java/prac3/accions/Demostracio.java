package prac3.accions;

import prac3.integrants.Membre;
import prac3.integrants.Data;
import prac3.estructures.LlistaAssociacions;

public class Demostracio extends Accio {
    private Data fechaDisenio; // Fecha en la que se creo el disenio de la demostracion
    private boolean demostracionValida; // Da la informacion de si una demostracion que se continua ofreciendo
    private int contadorVecesOfrecida; // Contador de veces que se ha ofrecido una demostracion
    private double costoDemostracion; // Valor de dinero que ha costado crear la demostracion

    public Demostracio(String nombreDemostracion, LlistaAssociacions asociacionesInvolucradas, Membre organizadorResponsable, 
                       int indiceLista, Data fecha, double costoDemostracion) {
        // Atributos de la superclase
        super(nombreDemostracion, asociacionesInvolucradas, organizadorResponsable, indiceLista);
        
        // Atributos de esta subclase
        demostracionValida = true; // Cuando se crea una demostracion, se considera que se empieza a ofrecer en este instante
        contadorVecesOfrecida = 0; // Todavia no se ha ofrecido, ya que se acaba de crear
        this.fechaDisenio = new Data(fecha.getDia(), fecha.getMes(), fecha.getAny()); // Hay que crear una nueva clase Data

        if (costoDemostracion < 0) { 
            this.costoDemostracion = -999; // Si el costo introducido es negativo, se asigna un costo que indica error
        }
        else {
            this.costoDemostracion = costoDemostracion; // Sino, se admite el introducido por parametro
        }
    }

    public boolean getDemostracionValida() {
        return demostracionValida;
    }

    public int getContadorVecesOfrecida() {
        return contadorVecesOfrecida;
    }

    public double getCostoDemostracion() {
        return costoDemostracion;
    }

    public Data getFechaDisenio() {
        return fechaDisenio;
    }

    public void setDemostracionValida(boolean valida) {
        demostracionValida = valida;
    }
}
