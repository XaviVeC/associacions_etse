package prac3.integrants;

import java.util.Scanner;

import prac3.estructures.LlistaAccions;
import prac3.estructures.LlistaAssociacions;
import prac3.estructures.LlistaMembres;
import prac3.ficheros.LlegirFitxers;

public class UsaMembre {

    public static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion, cantidadAsociaciones;
        LlistaMembres auxiliarOpcion7 = new LlistaMembres(20);
        int cantidadMiembros = LlegirFitxers.ContarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Membres.csv");
        LlistaMembres listaDeTodosLosMiembros = new LlistaMembres(cantidadMiembros);

        cantidadAsociaciones = LlegirFitxers.ContarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Asociaciones.csv");
        LlistaAssociacions listadeLasAsociaciones = new LlistaAssociacions(cantidadAsociaciones);
        int cantidadAcciones = LlegirFitxers.ContarEntidadesFichero("C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Acciones.csv");
        LlistaAccions listaAcciones = new LlistaAccions(cantidadAcciones);
        System.out.println("Hay un total de: " + cantidadMiembros + " miembros");
        System.out.println("Hay un total de: " + cantidadAsociaciones + " asociaciones");
        System.out.println("Hay un total de: " + cantidadAcciones + " acciones");
        do {
            System.out.println("Elige la opcion.");
            mostraMenu();
            opcion = Integer.parseInt(teclat.nextLine());
            opcion1(listaDeTodosLosMiembros,
            "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Membres.csv",
            cantidadMiembros);
            opcion3(listadeLasAsociaciones,
                            "C:\\\\Users\\\\bllad\\\\OneDrive\\\\Escritorio\\\\associacions_etse\\\\src\\\\main\\\\java\\\\prac3\\\\ficheros\\\\asociaciones.csv",
                            cantidadAsociaciones);
            opcion5(listaAcciones, "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Acciones.csv", cantidadAcciones);
            switch (opcion) {
                case 1:

                    break;

                case 2:

                    opcion2(listaDeTodosLosMiembros, cantidadMiembros);
                    break;

                case 3:

                    break;

                case 4:
                    opcion4(listadeLasAsociaciones, cantidadAsociaciones);
                    break;
                case 5:
                    
                    break;
                case 6:
                    opcion6(listaAcciones, cantidadAcciones);
                    break;
                case 7:
                    opcion7(auxiliarOpcion7, "Beta", listadeLasAsociaciones, listaDeTodosLosMiembros);
                    break;
                default:
                    break;
            }

        } while (opcion != 8);

    }

    public static void opcion1(LlistaMembres listaARellenar, String nombreFichero, int cantidadMiembros) {
        LlegirFitxers.LeerFicheroMiembros(nombreFichero, listaARellenar, cantidadMiembros);
    }

    public static void opcion2(LlistaMembres listaDeTodosLosMiembros, int cantidadMiembros) {

        System.out.println(listaDeTodosLosMiembros.toString());

    }

    public static void opcion3(LlistaAssociacions listaARellenar, String nombreFichero, int cantidadAsociaciones) {
        LlegirFitxers.LeerFicheroAsociaciones(nombreFichero, listaARellenar, cantidadAsociaciones);
    }

    public static void opcion4(LlistaAssociacions listaAMostrar, int cantidadAsociaciones) {

        System.out.println(listaAMostrar.toString());

    }

    public static void opcion5(LlistaAccions listaARellenar, String nombreFichero, int cantidadAcciones) {
        LlegirFitxers.LeerFicheroAcciones(nombreFichero, listaARellenar, cantidadAcciones);
    }

    public static void opcion6(LlistaAccions listaAMostrar, int cantidadAcciones) {

        System.out.println(listaAMostrar.toString());

    }

    public static void opcion7(LlistaMembres lista, String nombreAsociacion,
            LlistaAssociacions listaTodasLasAsociaciones, LlistaMembres listaTodosMiembros) {
        System.out.println(
                lista.miembrosDeAsociacionConcreta(nombreAsociacion, listaTodasLasAsociaciones, listaTodosMiembros)
                        .toString());
    }

    public static void mostraMenu() {
        System.out.println("1. Rellenar la lista de miembros");
        System.out.println("2. Imprimr la lista de miembros");
        System.out.println("3. Rellenar la lista de asociaciones");
        System.out.println("4. Imprimr la lista de asociaciones");
        System.out.println("5. Rellenar acciones");
        System.out.println("6. Printear acciones");
        System.out.println("7. Miemros X asociacion");
        System.out.println("8. Salir");

    }
}
