package prac3.juegosDePruebaIndividuales;

import prac3.Asociacion.Asociacion;
import prac3.Estructuras.Fecha;

public class mainAsociacion {
    public static void main(String[] args) {
        // CONSTRUCTOR DE ASOCIACION Y LO COMPROBAMOS CON toString
        System.out.println("Se creará una asociación y se mostrará por el terminal:");
        String[] miembrosAsociacion = { "salat", "daniel", "adria" };
        String[] titulaciones = { "GEI", };
        Fecha[] fecha_alta_as1 = new Fecha[3];
        for (int index = 0; index < fecha_alta_as1.length; index++) {
            fecha_alta_as1[index] = new Fecha(1, 1, 2025);
        }
        Fecha[] fecha_baja_as1 = new Fecha[3];
        for (int index = 0; index < fecha_alta_as1.length; index++) {
            fecha_baja_as1[index] = new Fecha(99, 99, 9999);
        }
        Asociacion as1 = new Asociacion("as1", titulaciones, miembrosAsociacion, miembrosAsociacion, fecha_alta_as1,
                fecha_baja_as1);
        System.out.println(as1.toString());
        // GET NOMBRE ASOCIACION
        System.out.println("Se probará el getter del nombre de la asociación:");
        System.out.println(as1.getNombreAsociacion());
        // GET CORREO ASOCIACION
        System.out.println("Se probará el getter del correo de la asociación:");
        System.out.println(as1.getCorreoContactoAsociacion());
        // GET LISTA MIEMBROS
        System.out.println("Se probará el getter de la lista de miembros de la asociación:");
        for (int i = 0; i < as1.getListaMiembrosAsociacion().length; i++) {
            System.out.println("\t" + as1.getListaMiembrosAsociacion()[i]);
        }
        // GET TITULACIONES
        System.out.println("Se probará el getter de la lista de las titulaciones de los miembros de la asociación:");
        for (int i = 0; i < as1.getTitulacionesAsociacion().length; i++) {
            System.out.println("\t" + as1.getTitulacionesAsociacion()[i]);
        }
        // GET PERSONAS EN CARGOS
        System.out.println("Se probará el getter de la lista de las personas a cargo de la asociación:");
        for (int i = 0; i < as1.getPersonasEnCargo().length; i++) {
            switch (i) {
                case 0:
                    System.out.println("\tPresidente: " + as1.getPersonasEnCargo()[i]);
                    break;
                case 1:
                    System.out.println("\tSecretario: " + as1.getPersonasEnCargo()[i]);
                    break;
                default:
                    System.out.println("\tTesorero: " + as1.getPersonasEnCargo()[i]);
                    break;
            }
        }
        // GET FECHA ALTA
        System.out.println("Se probará el getter de la lista de las fechas de alta de los miembros de la asociación:");
        for (int i = 0; i < as1.getListaMiembrosAsociacion().length; i++) {
            System.out.println("\tLa fecha de alta de " + as1.getListaMiembrosAsociacion()[i] + " es: "
                    + as1.getFechasAlta()[i].toString());
        }
        // GET FECHA BAJA
        System.out.println("Se probará el getter de la lista de las fechas de alta de los miembros de la asociación:");
        for (int i = 0; i < as1.getListaMiembrosAsociacion().length; i++) {
            System.out.println("\tLa fecha de alta de " + as1.getListaMiembrosAsociacion()[i] + " es: "
                    + as1.getFechasBaja()[i].toString());
        }
        // COPIA Y toString para mostrarla
        Asociacion copiaAs1 = as1.copia();
        System.out.println("Se probará que el método copia funciona correctamente:");
        System.out.println("Se mostrará la copia de as1, como el nombre no puede ser igual en dos asociaciones:");
        System.out.println(copiaAs1.toString());
    }
}
