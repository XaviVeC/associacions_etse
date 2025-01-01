package prac3.juegosDePruebaIndividuales;
import prac3.Accion.Charla;
import prac3.Estructuras.Fecha;

public class mainCharla {
    public static void main(String[] args) {
        
        // CONSTRUCTOR DE CHARLA Y LO COMPROBAMOS CON EL toString
        System.out.println("Se creará una asociación y se mostrará por el terminal:");
        int indiceFichero = 15;
        String nombreAccion = "NewCharla";
        String[] asociacionesInvolucradas = { "DaciasSandero", "CarneForever" };
        String organizadorResponsable = "Esteban";
        Fecha fechaRealizacion = new Fecha(1, 1, 2025);
        String[] instructoresCharla = { "salat", "daniel", "adria" };
        int[] valoraciones = { 2, 5, 10 }; // Vector de valoraciones de la charla
        int numeroDeAsistentes = 5;
        int indiceValoraciones = 3;
        Charla ch1 = new Charla(indiceFichero, nombreAccion, asociacionesInvolucradas, organizadorResponsable, fechaRealizacion, instructoresCharla, valoraciones, numeroDeAsistentes, indiceValoraciones);
        System.out.println(ch1.toString());
        // GETTER instructoresCharla
        System.out.println("Se probará el getter de los instructores de la charla:");
        for (int i = 0; i < ch1.getInstructoresCharla().length; i++) {
            System.out.println("\t" + ch1.getInstructoresCharla()[i]);
        }
        // GETTER Fecha
        System.out.println("Se probará el getter de la fecha de la charla:");
        System.out.println("\tFecha de la charla: " + ch1.getFecha().toString());
        // GETTER Valoraciones
        System.out.println("Se probará el getter de las valoraciones de la charla:");
        for (int i = 0; i < ch1.getIndiceValoraciones(); i++) {
            System.out.println("\t" + ch1.getValoraciones()[i]);
        }
        // GETTER numeroAsistentes
        System.out.println("Se probará el getter del número de asistentes a la charla:");
        System.out.println("\tAsistieron un total de: " + ch1.getNumeroAsistentes());

        // GETTER indiceValoraciones
        System.out.println("Se probará el getter del número de valoraciones hechas a la charla:");
        System.out.println("\tLa cantidad de valoraciones que se hicieron son: " + ch1.getIndiceValoraciones());

        // COMPROBAR COPIA
        Charla ch1_copia = ch1.copia();
        System.out.println("Se probará el método copia de una charla:");
        System.out.println(ch1_copia.toString());

        // COMPROBAR hacerValoracion
        System.out.println("Se probará el método que añade una valoración a la charla:");
        ch1.hacerValoracion(8);
        System.out.println(ch1_copia.toString());

        // COMPROBAR mediaValoraciones
        System.out.println("Se probará el método que calcula la media de las valoraciones de la charla:");
        System.out.println("\tLa media de las valoraciones de la charla es: " +ch1_copia.mediaValoraciones());
    }
}
