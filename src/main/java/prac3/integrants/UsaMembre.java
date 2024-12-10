package prac3.integrants;

import java.util.Scanner;

import prac3.estructures.Data;
import prac3.estructures.LlistaAccions;
import prac3.estructures.LlistaAssociacions;
import prac3.estructures.LlistaMembres;
import prac3.ficheros.LlegirFitxers;
import prac3.associacions.Associacio;

public class UsaMembre {

    public static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        Data limInfe = new Data(20, 7, 2001);
        Data limSuper  = new Data(1,1,2017);
        String [] titulaciones = {"GEI", "GIB"};
        String[] listaMiembros = {"Pedro", "Luis", "Carlos"};
        String[] persCargos = {"Pedro", "Luis", "Carlos"};
        int opcion, cantidadAsociaciones;
        int cantidadMiembros = LlegirFitxers.ContarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Membres.csv");
        LlistaMembres listaDeTodosLosMiembros = new LlistaMembres(cantidadMiembros);

        cantidadAsociaciones = LlegirFitxers.ContarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Asociaciones.csv");
        LlistaAssociacions listadeLasAsociaciones = new LlistaAssociacions(cantidadAsociaciones);
        int cantidadAcciones = LlegirFitxers.ContarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Acciones.csv");
        LlistaAccions listaAcciones = new LlistaAccions(cantidadAcciones);
        System.out.println("Hay un total de: " + cantidadMiembros + " miembros");
        System.out.println("Hay un total de: " + cantidadAsociaciones + " asociaciones");
        System.out.println("Hay un total de: " + cantidadAcciones + " acciones");
        LlegirFitxers.LeerFicheroAcciones(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Acciones.csv",
                listaAcciones, cantidadAcciones);
        LlegirFitxers.LeerFicheroMiembros(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Membres.csv",
                listaDeTodosLosMiembros, cantidadMiembros);
        LlegirFitxers.LeerFicheroAsociaciones(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\ficheros\\Asociaciones.csv",
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
                case 6:
                    opcion6(listaAcciones, "Ambos");
                    break;
                case 7:
                    opcion7(listaAcciones, "Gamma");
                    break;
                case 8:
                    opcion8(listaAcciones, limInfe, limSuper);
                    break;
                case 9:                                                                                     
                    opcion9("AsociacionNueva", "asociacionNueva@urv.cat", titulaciones, listaMiembros, persCargos, listadeLasAsociaciones);
                    break;
                default:
                    break;
            }

        } while (opcion != 11);

    }
//no entiendo un pijo
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

    public static void opcion6(LlistaAccions listaTodasAcciones, String filtro) {
        LlistaAccions aux = LlistaAccions.accionesSegunTipo(listaTodasAcciones, filtro);
        System.out.println(aux.toString());

    }


    public static void opcion7 (LlistaAccions listaTodasAcciones, String nombreAsociacion){
        System.out.println(LlistaAccions.accionesDeXAsociacion(listaTodasAcciones, nombreAsociacion).toString());
    }


    public static void opcion8(LlistaAccions listaTodasAcciones, Data limInf, Data limSup) {
        LlistaAccions auxAccions = LlistaAccions.sublistaCharlasEnRangoFechas(listaTodasAcciones, limInf, limSup);
        System.out.println("La lista tiene un total de " + auxAccions.getNumeroAcciones() + " elementos");
        System.out.println(auxAccions.toString());
    }

    public static void opcion9 (String nombre, String correo, String[] titulaciones, String[] listaMiembros, String[] persCargos, LlistaAssociacions listaTodasLasAsociaciones){
        Associacio asociacionAdd = new Associacio (nombre, correo, titulaciones, listaMiembros, persCargos);
        listaTodasLasAsociaciones.addAsociacion(asociacionAdd);
        System.out.println(listaTodasLasAsociaciones.toString());

    }

    public static void mostraMenu() {
        System.out.println("1. Imprimr la lista de miembros");
        System.out.println("2. Imprimr la lista de asociaciones");
        System.out.println("3. Imprimr la lista de acciones");
        System.out.println("4. Miemros X asociacion");
        System.out.println("5. Miembros activos con filtro");
        System.out.println("6. Acciones con filtro o sin filtro");
        System.out.println("7. Acciones de una asociacion en concreto");
        System.out.println("8. LA TUYA ADRI");
        System.out.println("9. Add nueva asociacion");
        System.out.println("10. Salir");

    }
}
