package prac3.main_consola;

import java.util.Scanner;
import prac3.Estructuras.Fecha;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;
import prac3.Estructuras.ListaMiembros;
import prac3.Fichero.LeerFichero;
import prac3.Miembro.Miembro;
import prac3.Miembro.Profesor;
import prac3.Miembro.Alumno;
public class MainConsola {
    public static Scanner introducirPorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        // VARIABLES PARA LAS OPCIONES
        String nombreAsociacionOp2, filtroOp2;
        String filtroOp3;
        String filtroOp4;
        String nombreAsociacionOp5;
        //fechas opcion 6
        int diaInf, mesInf, yearInf, diaSup, mesSup, yearSup;
        Fecha fechaInferior, fechaSuperior;
        //opcion 7
        String nombreAsociacionOp7;
        int cantidadMiembrosOp7;
        String nombreMiembroOp7;
        //opcion 8
        
        // VARIABLES DEL MAIN
        // -----------------------------------------------------------------
        int cantidadMaxima = 100;
        // Rutas de acceso de los ficheros
        String[] direccionesAcciones = {
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Acciones.csv",
                "/src/main/java/prac3/Fichero/Miembros.csv", "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Acciones.csv" };
        String[] direccionesMiembros = {
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Miembros.csv",
                "/src/main/java/prac3/Fichero/Miembros.csv", "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Miembros.csv" };
        String[] direccionesAsociaciones = {
                "C:\\Users\\bllad\\OneDrive\\Escritorio\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Asociaciones.csv",
                "/src/main/java/prac3/Fichero/Asociaciones.csv", "C:\\Users\\Asus\\Desktop\\TRABAJO PROGRA\\associacions_etse\\src\\main\\java\\prac3\\Fichero\\Asociaciones.csv" };
        // Variables enteras varias
        int opcionMenu, cantidadAcciones, cantidadMiembros, cantidadAsociaciones;
        // Definicion de las distintas listas
        ListaAcciones listaDeTodasLasAcciones;
        ListaAsociaciones listaDeTodasLasAsociaciones;
        ListaMiembros listaDeTodosLosMiembros;

        // CANTIDADES DE ENTIDADES
        // --------------------------------------------------------------
        cantidadAcciones = LeerFichero.ContarEntidadesFichero(direccionesAcciones[0]);
        cantidadAsociaciones = LeerFichero.ContarEntidadesFichero(direccionesAsociaciones[0]);
        cantidadMiembros = LeerFichero.ContarEntidadesFichero(direccionesMiembros[0]);
        System.out.println("Hay un total de: " + cantidadMiembros + " miembros");
        System.out.println("Hay un total de: " + cantidadAsociaciones + " asociaciones");
        System.out.println("Hay un total de: " + cantidadAcciones + " acciones");

        // CREACION DE LAS LISTAS
        // --------------------------------------------------------------
        listaDeTodasLasAcciones = new ListaAcciones(cantidadMaxima);
        listaDeTodasLasAsociaciones = new ListaAsociaciones(cantidadMaxima);
        listaDeTodosLosMiembros = new ListaMiembros(cantidadMaxima);

        LeerFichero.LeerFicheroAcciones(direccionesAcciones[0], listaDeTodasLasAcciones, cantidadAcciones);
        LeerFichero.LeerFicheroAsociaciones(direccionesAsociaciones[0], listaDeTodasLasAsociaciones,
                cantidadAsociaciones);
        LeerFichero.LeerFicheroMiembros(direccionesMiembros[0], listaDeTodosLosMiembros, cantidadMiembros);

        // BUCLE PRINCIPAL DEL PROGRAMA -----------------------------------------------
        do {
            System.out.println("Elige la opcion del menu.");
            mostraMenu();
            opcionMenu = Integer.parseInt(introducirPorTeclado.nextLine());

            switch (opcionMenu) {
                case 1:
                    System.out.println("Se mostrará la lista con todas las asociaciones");
                    opcion1(listaDeTodasLasAsociaciones);
                    break;
                case 2:
                    System.out.println("¿Sobre que asociación quieres información?");
                    nombreAsociacionOp2 = introducirPorTeclado.nextLine();
                    System.out.println("Escribe un filtro para profesores, alumnos, o ambos (Professor, Alumne, Ambos).");
                    filtroOp2 = introducirPorTeclado.nextLine();
                    opcion2(nombreAsociacionOp2, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros, filtroOp2);
                    break;
                case 3:
                    System.out.println(
                            "Se mostrará una lista con todos los miembros activos.\nPuede aplicar un filtro\n\tPara profesores --> Professor\n\tPara alumnos -->Alumne\n\tSi quieres los dos --> Ambos");
                    filtroOp3 = introducirPorTeclado.nextLine();
                    opcion3(listaDeTodosLosMiembros, filtroOp3, listaDeTodasLasAsociaciones);
                    break;
                case 4:
                    System.out.println("Se mostrarán las acciones filtradas si se quiere.");
                    System.out.println("¿Que tipo de accion quieres? (Charla, Demostracion, Ambos)");
                    filtroOp4 = introducirPorTeclado.nextLine();
                    opcion4(listaDeTodasLasAcciones, filtroOp4);
                    break;
                case 5:
                    System.out.println("¿De que asociación quieres las acciones?");
                    nombreAsociacionOp5 = introducirPorTeclado.nextLine();
                    opcion5(listaDeTodasLasAcciones, nombreAsociacionOp5);
                    break;
                case 6:
                    System.out.println("\nSe mostrará la lista de Charlas dentro de un rango de fechas que introducirás");
                    System.out.println("Introduce el límite inferior:");
                    System.out.println("Día inferior:");
                    diaInf = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("Mes inferior:");
                    mesInf = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("Año inferior:");
                    yearInf = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("Introduce el límite superior:");
                    System.out.println("Día superior:");
                    diaSup = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("Mes superior:");
                    mesSup = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("Año superior:");
                    yearSup = Integer.parseInt(introducirPorTeclado.nextLine());
                    fechaInferior = new Fecha(diaInf, mesInf, yearInf);
                    fechaSuperior = new Fecha(diaSup, mesSup, yearSup);
                    opcion6(listaDeTodasLasAcciones, fechaInferior, fechaSuperior);
                    break;
                case 7:
                    //-------------------------------------- MAS ADELANTE
                    //primera comprobacion si ya existe el nombre de la asociacion
                    //public boolean existeAsociacionMismoNombre (String nombreAsociacion, ListaAsociaciones listaTodasAsociaciones)
                    //segunda, existe el miembro que se va a añadir
                    //public static int miembroExistente(String alias, ListaMiembros listaTodosMiembros)
                    //tercera, el miembro está en menos de tres asociaciones
                    //public boolean miembroPerteneceATresAsociaciones(ListaAsociaciones listaTodasAsociaciones,
                    System.out.println("Vas a añadir una nueva asociación");
                    System.out.println("Introduce el nombre del la asociación:");
                    do {
                        nombreAsociacionOp7 = introducirPorTeclado.nextLine();
                        if (ListaAsociaciones.existeAsociacionMismoNombre(nombreAsociacionOp7, listaDeTodasLasAsociaciones)) {
                            System.out.println("Ya existe este nombre, introducelo de nuevo");
                        }
                    } while (ListaAsociaciones.existeAsociacionMismoNombre(nombreAsociacionOp7, listaDeTodasLasAsociaciones));
                    
                    System.out.println("Cuantos miembros quieres añadir, mínimo tres y máximo 20:");
                    
                    do {
                        cantidadMiembrosOp7 = Integer.parseInt(introducirPorTeclado.nextLine());
                        if (cantidadMiembrosOp7 < 3 || cantidadMiembrosOp7 > 20) {
                            System.out.println("El mínimo de miembros es 3 y máximo 20, introducelo de nuevo.");
                        }
                    } while (cantidadMiembrosOp7 < 3 || cantidadMiembrosOp7 > 20);
                    int indice = 0;
                    String[] miembrosAsociacion = new String[cantidadMiembrosOp7];
                    do {
                        System.out.println("Introduce el alias del miembro " + (indice + 1) + " :");
                        
                        do{
                            nombreMiembroOp7 = introducirPorTeclado.nextLine();
                            if (ListaMiembros.miembroExistente(nombreMiembroOp7, listaDeTodosLosMiembros) == -1) {
                                System.out.println("Este miembro no existe, introduce alguno que si lo haga.");
                            }
                        }while(ListaMiembros.miembroExistente(nombreMiembroOp7, listaDeTodosLosMiembros) == -1);
                        miembrosAsociacion[indice] = nombreMiembroOp7;
                    } while (indice < cantidadMiembrosOp7);

                    //QUEDA AÑADIR LOS TITULOS QUE HAY EN LA ASOCIACION
                    

                    break;
                case 8:
                    System.out.println("Para dar de alta a un miembro en una asociación.");
                    System.out.println("Escribe tu alias.");
                    String aliasOp8 = introducirPorTeclado.nextLine();
                    System.out.println("Escribe la asociación en la que te quieres apuntar.");
                    String nomAsocOp8 = introducirPorTeclado.nextLine();
                    int comprovacion = opcion8vis1(aliasOp8, nomAsocOp8, listaDeTodosLosMiembros, listaDeTodasLasAsociaciones);
                    if (comprovacion == -1) {
                        System.out.println("¿Eres alumno o profesor? (Alumno, Profesor)");
                        String tipoMiembroOp8 = introducirPorTeclado.nextLine();
                        System.out.println("¿Que numero de día es hoy?");
                        int diaOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                        System.out.println("¿Que numero de mes es hoy?");
                        int mesOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                        System.out.println("¿Que numero de año es hoy?");
                        int yearOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                        Fecha fechaAltaOp8 = new Fecha(diaOp8, mesOp8, yearOp8);
                        if (tipoMiembroOp8 == "Profesor") {
                            System.out.println("¿En que departamento estás?");
                            String deptOp8 = introducirPorTeclado.nextLine();
                            System.out.println("¿Cual es tu número de despacho?");
                            int numDptOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                            Profesor nuevoProfesor = new Profesor(999, tipoMiembroOp8, aliasOp8, deptOp8, numDptOp8);
                            opcion8vis2(nuevoProfesor, nomAsocOp8, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros);
                        }
                        else {
                            System.out.println("¿Cuántos años llevas en la universidad?");
                            int yearsEtseOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                            System.out.println("¿Ya estas graduado? (s/n)");
                            String aux = introducirPorTeclado.nextLine();
                            boolean graduado;
                            if (aux.equals("s")) {
                                graduado = true;
                            }
                            else {
                                graduado = false;
                            }
                            System.out.println("Iniciales de la carrera que cursas");
                            String siglasCarrera = introducirPorTeclado.nextLine();
                            Alumno nuevoAlumno = new Alumno(999, tipoMiembroOp8, aliasOp8, yearsEtseOp8, graduado, siglasCarrera);
                            opcion8vis2(nuevoAlumno, nomAsocOp8, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros);
                        }

                    }
                    System.out.println(listaDeTodasLasAsociaciones.toString());
                    System.out.println("\n\n");
                    System.out.println(listaDeTodosLosMiembros.toString());
                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:

                    break;
                case 15:

                    break;
                case 16:

                    break;
                case 17:

                    break;

                default: // aplicaremos un try catch para la opcion de menu por si escriben numero > 18
                    break;
            }
        } while (opcionMenu != 18);

    }

    public static void mostraMenu() {
        System.out.println("1.\tMostrar los datos de la lista de asociaciones.");
        System.out.println(
                "2.\tMostrar los datos de la lista de miembros que forman parte de una asociación, añadiendo un filtro para profesores, alumnos o ambos.");
        System.out.println(
                "3.\tMostrar los datos de la lista de miembros activos, que forman parte de cualquier asociación, añadiendo un filtro para profesores, alumnos o ambos.");
        System.out
                .println("4.\tMostrar los datos de la lista de acciones, añadiendo un filtro o no por tipo de acción.");
        System.out.println("5.\tObtener y mostrar la lista de acciones que ofrece una asociación concreta.");
        System.out.println(
                "6.\tObtener y mostrar la lista de las charlas que se realizan en un rango de fechas indicado por teclado.");
        System.out.println("7.\tAñadir una nueva asociación.");
        System.out.println(
                "8.\tAlta de un miembro en una asociación. Puede darse el caso de que el miembro sea nuevo, y se deberá introducir toda la información del miembro, o que el miembro ya participe en otra asociación, en cuyo caso se deberá añadir la relación correspondiente.");
        System.out.println("9.\tAñadir una nueva charla");
        System.out.println("10.\tAñadir una nueva demostración");
        System.out.println(
                "11.\tConsultar y mostrar los datos de las demostraciones que se consideran no activas. Calcular el costo económico total que supuso preparar todas estas demostraciones.");
        System.out.println(
                "12.\tCalcular la persona más activa, es decir, la que participa en más asociaciones. En caso de empate, se considera la que tiene más antigüedad (en cualquier asociación). Si aún hay empate, se escoge a cualquiera de las personas que cumplen con los requisitos.");
        System.out.println(
                "13.\tConsultar y mostrar los datos de las charlas que han tenido más de un cierto número indicado de asistentes.");
        System.out.println("14.\tValorar una charla por parte de un asistente.");
        System.out.println(
                "15.\tConsultar y mostrar la charla que está mejor valorada (que será la que tiene el promedio de valoraciones más alto). En caso de empate en la nota, se considera la que ha tenido más valoraciones, y en caso de empate se toma cualquiera.");
        System.out.println("16.\tMostrar los datos de las charlas que hará una persona concreta.");
        System.out.println(
                "17.\tDar de baja las demostraciones que no estén activas y que fueron diseñadas antes de una cierta fecha.");
        System.out.println("18.\tSalir de la aplicación.");
    }

    /**
     * 
     * @param listaTodasLasAsociaciones - lista que contiene todas las asociaciones
     */
    public static void opcion1(ListaAsociaciones listaTodasLasAsociaciones) {
        System.out.println(listaTodasLasAsociaciones.toString());
    }

    public static void opcion2(String nombreAsociacion, ListaAsociaciones listaDeTodasLasAsociaciones,
            ListaMiembros listaDeTodosLosMiembros, String filtro) {
        System.out.println(ListaMiembros.miembrosDeAsociacionConcreta(nombreAsociacion, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros, filtro).toString());
    }

    public static void opcion3(ListaMiembros listaConTodosLosMiembros, String filtro, ListaAsociaciones todasLasAsociaciones) {
        System.out.println(ListaMiembros.miembrosActivosAplicandoFiltro(listaConTodosLosMiembros, filtro, todasLasAsociaciones).toString());
    }

    public static void opcion4(ListaAcciones listaDeTodasLasAcciones, String filtro) {
        System.out.println(ListaAcciones.accionesSegunTipo(listaDeTodasLasAcciones, filtro).toString());
    }

    public static void opcion5(ListaAcciones listaTodasLasAcciones, String nombreAsociacion) {
        System.out.println(ListaAcciones.accionesDeXAsociacion(listaTodasLasAcciones, nombreAsociacion).toString());
    }

    public static void opcion6(ListaAcciones listaTodasAcciones, Fecha limInf, Fecha limSup) {
        System.out.println(ListaAcciones.sublistaCharlasEnRangoFechas(listaTodasAcciones, limInf, limSup).toString());
    }
    
    public static void opcion7() {

    }

    public static int opcion8vis1(String alias, String nombreAsociacion, ListaMiembros listaTodosMiembros, ListaAsociaciones todasAsoc) {
        int existe = ListaMiembros.miembroExistente(alias, listaTodosMiembros);

        if (existe != -1) {
            todasAsoc.addMiembroEnAsociacionExistente(alias, nombreAsociacion, todasAsoc);
        }

        return existe;
    }

    public static void opcion8vis2(Miembro miembro, String nombreAsociacion, ListaAsociaciones listaTodasAsociaciones, ListaMiembros listaTodosMiembros) {
        listaTodosMiembros.addMiembro(miembro);
        listaTodasAsociaciones.addMiembroEnAsociacionExistente(miembro.getAlias(), nombreAsociacion, listaTodasAsociaciones);
    }

    

    public static void opcion9() {
        
    }

    


}
