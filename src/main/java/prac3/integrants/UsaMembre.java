package prac3.integrants;

import java.util.Scanner;

import prac3.estructures.LlistaAssociacions;
import prac3.estructures.LlistaMembres;
import prac3.ficheros.LlegirFitxers;

public class UsaMembre {

    public static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion, cantidadAsociaciones;

        int cantidadMiembros = LlegirFitxers.contarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Membres.csv");
        LlistaMembres listaDeTodosLosMiembros = new LlistaMembres(cantidadMiembros);

        cantidadAsociaciones = LlegirFitxers.contarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Asociaciones.csv");
        LlistaAssociacions listadeLasAsociaciones = new LlistaAssociacions(cantidadAsociaciones);
        
        System.out.println("Hay un total de: " + cantidadMiembros + " miembros");
        System.out.println("Hay un total de: " + cantidadAsociaciones + " asociaciones");

        do {
            System.out.println("Elige la opcion.");
            mostraMenu();
            opcion = Integer.parseInt(teclat.nextLine());

            switch (opcion) {
                case 1:
                    opcion1(listaDeTodosLosMiembros,
                            "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Membres.csv",
                            cantidadMiembros);
                    break;

                case 2:

                    opcion2(listaDeTodosLosMiembros, cantidadMiembros);
                    break;

                case 3:
                    opcion3(listadeLasAsociaciones, "C:\\\\Users\\\\bllad\\\\OneDrive\\\\Escritorio\\\\associacions_etse\\\\src\\\\main\\\\java\\\\prac3\\\\ficheros\\\\asociaciones.csv", cantidadAsociaciones);
                    break;

                case 4:
                    opcion4(listadeLasAsociaciones, cantidadAsociaciones);
                    break;

                default:
                    break;
            }

        } while (opcion != 5);

    }

    public static void opcion1(LlistaMembres listaARellenar, String nombreFichero, int cantidadMiembros) {
        LlegirFitxers.leerficheroMiembros(nombreFichero, listaARellenar, cantidadMiembros);
    }

    public static void opcion2(LlistaMembres listaDeTodosLosMiembros, int cantidadMiembros) {
        for (int i = 0; i < cantidadMiembros; i++) {
            System.out.println(listaDeTodosLosMiembros.toString());
        }
    }

    public static void opcion3(LlistaAssociacions listaARellenar, String nombreFichero, int cantidadAsociaciones) {
        LlegirFitxers.leerFicheroAsociaciones(nombreFichero, listaARellenar, cantidadAsociaciones);
    }

    public static void opcion4(LlistaAssociacions listaAMostrar, int cantidadAsociaciones) {
        for (int i = 0; i < cantidadAsociaciones; i++) {
            System.out.println(listaAMostrar.toString());
        }
    }

    public static void mostraMenu() {
        System.out.println("1. Rellenar la lista de miembros");
        System.out.println("2. Imprimr la lista de miembros");
        System.out.println("3. Rellenar la lista de asociaciones");
        System.out.println("4. Imprimr la lista de asociaciones");
        System.out.println("5. Salir");
    }
}
