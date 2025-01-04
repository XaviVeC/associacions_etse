package prac3.juegosDePruebaIndividuales;

import prac3.Estructuras.ListaMiembros;
import prac3.Fichero.LeerFichero;
import prac3.Miembro.Profesor;

public class mainProfesor {
    public static void main(String[] args) {
        System.out.println("Se creará un nuevo profesor y se mostrarán las comprobaciones por el terminal.");

        int cantidadMaxima = 300;
        // Rutas de acceso de los ficheros
        String direccionesMiembros = "src/main/java/prac3/Fichero/Miembros.csv";
        int cantidadMiembros;
        ListaMiembros listaDeTodosLosMiembros;

        // CANTIDADES DE ENTIDADES
        // --------------------------------------------------------------
        cantidadMiembros = LeerFichero.ContarEntidadesFichero(direccionesMiembros);

        // CREACION DE LAS LISTAS
        // --------------------------------------------------------------
        listaDeTodosLosMiembros = new ListaMiembros(cantidadMaxima);
        LeerFichero.LeerFicheroMiembros(direccionesMiembros, listaDeTodosLosMiembros, cantidadMiembros);

        Profesor profe = new Profesor(listaDeTodosLosMiembros.getNumeroMembres(), "Profesor", "esteban", "DEEEA", 124);

        System.out.println("Método toString:");
        System.out.println(profe.toString());

        System.out.println("Getters de la clase profesor:");
        System.out.println("Departamento (DEEEA): " + profe.getDepartamento());
        System.out.println("Número de despacho (124): " + profe.getNumeroDespacho());

        System.out.println(
                "Método copia(). Se comprobará que va bien con el debug y la dirección de memoria. Capturas en la memoria");
        Profesor pCopia = profe.copia();
        System.out.println(pCopia.toString());
    }
}
