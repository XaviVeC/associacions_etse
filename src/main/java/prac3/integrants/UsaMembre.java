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
        int cantidadMiembros = LlegirFitxers.ContarEntidadesFichero(
                "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Membres.csv");
        LlistaMembres listaDeTodosLosMiembros = new LlistaMembres(cantidadMiembros);

        cantidadAsociaciones = LlegirFitxers.ContarEntidadesFichero(
                "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Asociaciones.csv");
        LlistaAssociacions listadeLasAsociaciones = new LlistaAssociacions(cantidadAsociaciones);
        int cantidadAcciones = LlegirFitxers.ContarEntidadesFichero(
                "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\acciones.csv");
        LlistaAccions listaAcciones = new LlistaAccions(cantidadAcciones);
        System.out.println("Hay un total de: " + cantidadMiembros + " miembros");
        System.out.println("Hay un total de: " + cantidadAsociaciones + " asociaciones");
        System.out.println("Hay un total de: " + cantidadAcciones + " acciones");
        LlegirFitxers.LeerFicheroAcciones(
                "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\acciones.csv",
                listaAcciones, cantidadAcciones);
        LlegirFitxers.LeerFicheroMiembros(
                "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Membres.csv",
                listaDeTodosLosMiembros, cantidadMiembros);
        LlegirFitxers.LeerFicheroAsociaciones(
                "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Asociaciones.csv",
                listadeLasAsociaciones, cantidadAsociaciones);
        do {
            System.out.println("Elige la opcion.");
            mostraMenu();
            opcion = Integer.parseInt(teclat.nextLine());

            switch (opcion) {
                case 1:
                    opcion1(listaDeTodosLosMiembros);
                    break;

                case 2:

                    opcion2(listadeLasAsociaciones);
                    break;

                case 3:
                    opcion3(listaAcciones);
                    break;

                case 4:
                    opcion4("Beta", listadeLasAsociaciones, listaDeTodosLosMiembros, "Professor");
                    break;
                case 5:
                    opcion5(listaDeTodosLosMiembros, "Ambos");
                    break;

                default:
                    break;
            }

        } while (opcion != 8);

    }

    public static void opcion1(LlistaMembres listaDeTodosLosMiembros) {

        System.out.println(listaDeTodosLosMiembros.toString());

    }

    public static void opcion2(LlistaAssociacions listaAsociaciones) {

        System.out.println(listaAsociaciones.toString());

    }

    public static void opcion3(LlistaAccions listaAMostrar) {

        System.out.println(listaAMostrar.toString());

    }

    public static void opcion4(String nombreAsociacion,
            LlistaAssociacions listaTodasLasAsociaciones, LlistaMembres listaTodosMiembros, String filtro) {
        System.out.println(
                LlistaMembres
                        .miembrosDeAsociacionConcreta(nombreAsociacion, listaTodasLasAsociaciones, listaTodosMiembros,
                                filtro)
                        .toString());
    }

    public static void opcion5(LlistaMembres listaTodosMiembros, String filtro) {
        System.out.println(LlistaMembres.miembrosActivos(listaTodosMiembros, filtro).toString());
    }

    public static void mostraMenu() {
        System.out.println("1. Imprimr la lista de miembros");
        System.out.println("2. Imprimr la lista de asociaciones");
        System.out.println("3. Imprimr la lista de acciones");
        System.out.println("4. Miemros X asociacion");
        System.out.println("5. Miembros activos con filtro");
        System.out.println("6. Salir");

    }
}
