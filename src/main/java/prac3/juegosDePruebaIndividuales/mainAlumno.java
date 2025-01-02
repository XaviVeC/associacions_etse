package prac3.juegosDePruebaIndividuales;

import prac3.Estructuras.ListaMiembros;
import prac3.Fichero.LeerFichero;
import prac3.Miembro.*;;

public class mainAlumno {
    public static void main(String[] args) {
        System.out.println("Se creará un nuevo alumno y se mostrarán las comprobaciones por el terminal.");

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

        Alumno alumno = new Alumno(listaDeTodosLosMiembros.getNumeroMembres(), "Alumno", "esteban", 3, false, "GEI");

        System.out.println("Metodo toString:");
        System.out.println(alumno.toString());

        System.out.println("Getters de la clase Alumno:");
        System.out.println("Indice del fichero correcto: "+alumno.getIndiceFichero());
        System.out.println("Tipo del miembro (Alumno): "+alumno.getTipoMiembro());
        System.out.println("Alias (esteban): " +alumno.getAlias());
        System.out.println("Correo del miembro (esteban@urv.cat): "+alumno.getCorreoMiembro());
        
        System.out.println("Método copia(). Se comprobará que va bien con el debug y la dirección de memoria. Capturas en la memoria");
        Alumno alCopia = alumno.copia();
        System.out.println(alCopia.toString());
    }
}
