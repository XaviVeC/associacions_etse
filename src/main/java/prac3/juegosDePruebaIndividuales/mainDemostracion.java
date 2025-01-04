package prac3.juegosDePruebaIndividuales;

import prac3.Accion.Demostracion;
import prac3.Estructuras.Fecha;

public class mainDemostracion {
    public static void main(String[] args) {
        // CONSTRUCTOR DE demostracion Y LO COMPROBAMOS CON EL toString
        System.out.println("Se creará una demostracion y se mostrará por el terminal:");
        int indiceFichero = 15;
        String nombreAccion = "Newdemostracion";
        String[] asociacionesInvolucradas = { "DaciasSandero", "CarneForever" };
        String organizadorResponsable = "Esteban";
        Fecha fechaRealizacion = new Fecha(1, 1, 2025);
        int costoDemostracion = 1000;
        boolean estadoDemostracion = true;
        int vecesOfrecida = 3;
        Demostracion demo1 = new Demostracion(indiceFichero, nombreAccion, asociacionesInvolucradas,
                organizadorResponsable, fechaRealizacion, costoDemostracion, estadoDemostracion, vecesOfrecida);
        System.out.println(demo1.toString());

        // GETTER estado
        System.out.println("Se probará el getter del estado de la demostración:");
        System.out.println("\tEstá activa la demostración? " + demo1.getEstado());

        // GETTER vecesOfrecida
        System.out.println("Se probará el getter de las veces que se ha ofrecido la demostración:");
        System.out.println("\tVeces que se ha ofrecido la demostración: " + demo1.getVecesOfrecida());

        // GETTER coste
        System.out.println("Se probará el getter del coste de la demostración:");
        System.out.println("\tCoste de la demostración: " + demo1.getCoste());

        // GETTER fecha
        System.out.println("Se probará el getter de la fecha de la demostración:");
        System.out.println("\tFecha de la demostración: " + demo1.getFecha().toString());

        // COMPROBACIÓN MÉTODO deshabilitarDemostracion
        System.out.println("Se probará que el método que desactiva la demostración funciona:");
        demo1.deshabilitarDemostracion();
        System.out.println("\tEstá activa la demostración? " + demo1.getEstado());

        // COMPROBACIÓN MÉTODO habilitarDemostracion
        System.out.println("Se probará que el método que activa la demostración funciona:");
        demo1.habilitarDemostracion();
        System.out.println("\tEstá activa la demostración? " + demo1.getEstado());

        // COMPROBACIÓN MÉTODO ofrecidaDeNuevo
        System.out
                .println("Se probará que el método que aumenta las veces que se ha ofrecido la demostración funciona:");
        demo1.ofrecidaDeNuevo();
        System.out.println("\tVeces que se ha ofrecido la demostración: " + demo1.getVecesOfrecida());

        // COMPROBAR COPIA
        Demostracion demo1_copia = demo1.copia();
        System.out.println("Se probará que la copia se efectua correctamente:");
        System.out.println("Demostracion inicial");
        System.out.println(demo1.toString());
        System.out.println("Demostracion copiada");
        System.out.println(demo1_copia.toString());
    }
}
