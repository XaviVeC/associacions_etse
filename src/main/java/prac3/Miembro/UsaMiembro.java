package prac3.Miembro;

import java.util.Scanner;

import prac3.Asociacion.Asociacion;
import prac3.Estructuras.Fecha;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;
import prac3.Estructuras.ListaMiembros;
import prac3.Fichero.LeerFichero;

public class UsaMiembro {

    public static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        Fecha limInfe = new Fecha(20, 7, 2001);
        Fecha limSuper  = new Fecha(1,1,2017);
        String [] titulaciones = {"GEI", "GIB"};
        String[] listaMiembros = {"Pedro", "Luis", "Carlos"};
        String[] persCargos = {"Pedro", "Luis", "Carlos"};
        int opcion, cantidadAsociaciones;
        int cantidadMiembros = LeerFichero.ContarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Miembros.csv");
        ListaMiembros listaDeTodosLosMiembros = new ListaMiembros(cantidadMiembros);

        cantidadAsociaciones = LeerFichero.ContarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Asociaciones.csv");
        ListaAsociaciones listadeLasAsociaciones = new ListaAsociaciones(cantidadAsociaciones);
        int cantidadAcciones = LeerFichero.ContarEntidadesFichero(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Acciones.csv");
        ListaAcciones listaAcciones = new ListaAcciones(cantidadAcciones);
        System.out.println("Hay un total de: " + cantidadMiembros + " miembros");
        System.out.println("Hay un total de: " + cantidadAsociaciones + " asociaciones");
        System.out.println("Hay un total de: " + cantidadAcciones + " acciones");
        LeerFichero.LeerFicheroAcciones(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Acciones.csv",
                listaAcciones, cantidadAcciones);
        LeerFichero.LeerFicheroMiembros(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Miembros.csv",
                listaDeTodosLosMiembros, cantidadMiembros);
        LeerFichero.LeerFicheroAsociaciones(
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Asociaciones.csv",
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
    public static void opcion1(ListaMiembros listaDeTodosLosMiembros) {

        System.out.println(listaDeTodosLosMiembros.toString());

    }

    public static void opcion2(ListaAsociaciones listaAsociaciones) {

        System.out.println(listaAsociaciones.toString());

    }

    public static void opcion3(ListaAcciones listaAMostrar) {

        System.out.println(listaAMostrar.toString());

    }

    public static void opcion4(String nombreAsociacion,
            ListaAsociaciones listaTodasLasAsociaciones, ListaMiembros listaTodosMiembros, String filtro) {
        System.out.println(
                ListaMiembros
                        .miembrosDeAsociacionConcreta(nombreAsociacion, listaTodasLasAsociaciones, listaTodosMiembros,
                                filtro)
                        .toString());
    }

    public static void opcion5(ListaMiembros listaTodosMiembros, String filtro) {
        System.out.println(ListaMiembros.miembrosActivos(listaTodosMiembros, filtro).toString());
    }

    public static void opcion6(ListaAcciones listaTodasAcciones, String filtro) {
        ListaAcciones aux = ListaAcciones.accionesSegunTipo(listaTodasAcciones, filtro);
        System.out.println(aux.toString());

    }


    public static void opcion7 (ListaAcciones listaTodasAcciones, String nombreAsociacion){
        System.out.println(ListaAcciones.accionesDeXAsociacion(listaTodasAcciones, nombreAsociacion).toString());
    }


    public static void opcion8(ListaAcciones listaTodasAcciones, Fecha limInf, Fecha limSup) {
        ListaAcciones auxAccions = ListaAcciones.sublistaCharlasEnRangoFechas(listaTodasAcciones, limInf, limSup);
        System.out.println("La lista tiene un total de " + auxAccions.getNumeroAcciones() + " elementos");
        System.out.println(auxAccions.toString());
    }

    public static void opcion9 (String nombre, String correo, String[] titulaciones, String[] listaMiembros, String[] persCargos, ListaAsociaciones listaTodasLasAsociaciones){
        Asociacion asociacionAdd = new Asociacion (nombre, correo, titulaciones, listaMiembros, persCargos);
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
