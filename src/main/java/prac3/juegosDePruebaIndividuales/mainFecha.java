package prac3.juegosDePruebaIndividuales;

import prac3.Estructuras.Fecha;

public class mainFecha {
    public static void main(String[] args) {
        // CONSTRUCTOR y el tOString
        System.out.println("Comprobamos el constructor de Fecha y lo mostramos con el toString:");
        Fecha fecha_1 = new Fecha(1, 1, 2025);
        System.out.println(fecha_1.toString());
        // INTRODUCIMOS UNA FECHA ERRONEA (ej. el dia 100)
        System.out.println("Comprobamos que pasa si se introduce una dia erroneo:");
        Fecha fecha_erronea = new Fecha(100, 1, 2025);
        System.out.println(fecha_erronea.toString());
        // GET_DIA
        System.out.println("Comprobamos el getter del dia:");
        System.out.println("El día: " + fecha_1.getDia());
        // GET_MES
        System.out.println("Comprobamos el getter del mes:");
        System.out.println("El mes: " + fecha_1.getMes());
        // GET_YEAR
        System.out.println("Comprobamos el getter del año:");
        System.out.println("El mes: " + fecha_1.getYear());
        // COPIA con TOSTRING
        System.out.println("Comprobamos el método copia de la Fecha (copiamos en fecha_2 lo que hay en fecha_1):");
        Fecha fecha_2 = fecha_1.copia();
        System.out.println(fecha_2.toString());
        // COMPARAR FECHAS
        System.out.println("Comparamos la fecha_1 con su copia (fecha_2):");
        System.out.println("Al ser las fechas (fecha_1 y fecha_2) iguales debería devolver (compararFechas) un 1: "
                + fecha_1.compararFechas(fecha_2));
    }
}
