package prac3.Main_Consola;

import java.util.Scanner;

import prac3.Accion.Charla;
import prac3.Accion.Demostracion;
import prac3.Estructuras.ExcepcionesPropias;
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
        // fechas opcion 6
        int diaInf, mesInf, yearInf, diaSup, mesSup, yearSup;
        Fecha fechaInferior, fechaSuperior;
        // opcion 7
        String nombreAsociacionOp7;
        int cantidadMiembrosOp7;
        String nombreMiembroOp7;
        // opcion 8

        // Opcion 16
        String aliasPersonaOp16;

        // VARIABLES DEL MAIN
        // -----------------------------------------------------------------
        int cantidadMaxima = 100;
        // Rutas de acceso de los ficheros
        String direccionesAcciones = "src/main/java/prac3/Fichero/Acciones.csv";
        String direccionesMiembros = "src/main/java/prac3/Fichero/Miembros.csv";
        String direccionesAsociaciones = "src/main/java/prac3/Fichero/Asociaciones.csv";
        // Variables enteras varias
        int opcionMenu, cantidadAcciones, cantidadMiembros, cantidadAsociaciones;
        // Definicion de las distintas listas
        ListaAcciones listaDeTodasLasAcciones;
        ListaAsociaciones listaDeTodasLasAsociaciones;
        ListaMiembros listaDeTodosLosMiembros;

        // !!!!!!!!!!!!CARLAAAAAAAAA (FICHEROS)
        // LeerFichero lectorArchivo = new LeerFichero();
        // lectorArchivo.LeerFicheroAcciones("Acciones.txt", listaDeTodasLasAcciones);

        // CANTIDADES DE ENTIDADES
        // --------------------------------------------------------------
        cantidadAcciones = LeerFichero.ContarEntidadesFichero(direccionesAcciones);
        cantidadAsociaciones = LeerFichero.ContarEntidadesFichero(direccionesAsociaciones);
        cantidadMiembros = LeerFichero.ContarEntidadesFichero(direccionesMiembros);
        System.out.println("Hay un total de: " + cantidadMiembros + " miembros");
        System.out.println("Hay un total de: " + cantidadAsociaciones + " asociaciones");
        System.out.println("Hay un total de: " + cantidadAcciones + " acciones");

        // CREACION DE LAS LISTAS
        // --------------------------------------------------------------
        listaDeTodasLasAcciones = new ListaAcciones(cantidadMaxima);
        listaDeTodasLasAsociaciones = new ListaAsociaciones(cantidadMaxima);
        listaDeTodosLosMiembros = new ListaMiembros(cantidadMaxima);

        LeerFichero.LeerFicheroAcciones(direccionesAcciones, listaDeTodasLasAcciones, cantidadAcciones);
        LeerFichero.LeerFicheroAsociaciones(direccionesAsociaciones, listaDeTodasLasAsociaciones,
                cantidadAsociaciones);
        LeerFichero.LeerFicheroMiembros(direccionesMiembros, listaDeTodosLosMiembros, cantidadMiembros);

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
                    System.out
                            .println("Escribe un filtro para profesores, alumnos, o ambos (Professor, Alumne, Ambos).");
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
                    System.out
                            .println("\nSe mostrará la lista de Charlas dentro de un rango de fechas que introducirás");
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
                    // -------------------------------------- MAS ADELANTE
                    // primera comprobacion si ya existe el nombre de la asociacion
                    // public boolean existeAsociacionMismoNombre (String nombreAsociacion,
                    // ListaAsociaciones listaTodasAsociaciones)
                    // segunda, existe el miembro que se va a añadir
                    // public static int miembroExistente(String alias, ListaMiembros
                    // listaTodosMiembros)
                    // tercera, el miembro está en menos de tres asociaciones
                    // public boolean miembroPerteneceATresAsociaciones(ListaAsociaciones
                    // listaTodasAsociaciones,
                    System.out.println("Vas a añadir una nueva asociación");
                    System.out.println("Introduce el nombre del la asociación:");
                    do {
                        nombreAsociacionOp7 = introducirPorTeclado.nextLine();
                        if (listaDeTodasLasAsociaciones.existeAsociacionMismoNombre(nombreAsociacionOp7)) {
                            System.out.println("Ya existe este nombre, introducelo de nuevo");
                        }
                    } while (listaDeTodasLasAsociaciones.existeAsociacionMismoNombre(nombreAsociacionOp7));

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

                        do {
                            nombreMiembroOp7 = introducirPorTeclado.nextLine();
                            if (listaDeTodosLosMiembros.miembroExistente(nombreMiembroOp7) == -1) {
                                System.out.println("Este miembro no existe, introduce alguno que si lo haga.");
                            }
                        } while (listaDeTodosLosMiembros.miembroExistente(nombreMiembroOp7) == -1);
                        miembrosAsociacion[indice] = nombreMiembroOp7;
                    } while (indice < cantidadMiembrosOp7);
                    // A PARTIR DE LA LISTA DE MIEMBROS SACAMOS LA LISTA DE TITULACIONES QUE CURSAN
                    // (no puede haber repeticion en la lista)

                    // QUEDA AÑADIR LOS TITULOS QUE HAY EN LA ASOCIACION

                    break;
                case 8:
                    System.out.println("Para dar de alta a un miembro en una asociación.");
                    System.out.println("Escribe tu alias.");
                    String aliasOp8 = introducirPorTeclado.nextLine();
                    System.out.println("Escribe la asociación en la que te quieres apuntar.");
                    String nomAsocOp8 = introducirPorTeclado.nextLine();
                    System.out.println("¿Que número de día es hoy?");
                    int diaOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("¿En que número de mes estamos?");
                    int mesOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("¿En que año estamos?");
                    int yearOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                    Fecha fechaAltaOp8 = new Fecha(diaOp8, mesOp8, yearOp8);
                    int comprovacion = opcion8vis1(aliasOp8, nomAsocOp8, listaDeTodosLosMiembros,
                            listaDeTodasLasAsociaciones, fechaAltaOp8);
                    if (comprovacion == -1) {
                        System.out.println("¿Eres alumno o profesor? (Alumno, Profesor)");
                        String tipoMiembroOp8 = introducirPorTeclado.nextLine();
                        if (tipoMiembroOp8 == "Profesor") {
                            System.out.println("¿En que departamento estás?");
                            String deptOp8 = introducirPorTeclado.nextLine();
                            System.out.println("¿Cual es tu número de despacho?");
                            int numDptOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                            Profesor nuevoProfesor = new Profesor(999, tipoMiembroOp8, aliasOp8, deptOp8, numDptOp8);
                            opcion8vis2(nuevoProfesor, nomAsocOp8, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros,
                                    fechaAltaOp8);
                        } else {
                            System.out.println("¿Cuántos años llevas en la universidad?");
                            int yearsEtseOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                            System.out.println("¿Ya estas graduado? (s/n)");
                            String aux = introducirPorTeclado.nextLine();
                            boolean graduado;
                            if (aux.equals("s")) {
                                graduado = true;
                            } else {
                                graduado = false;
                            }
                            System.out.println("Iniciales de la carrera que cursas");
                            String siglasCarrera = introducirPorTeclado.nextLine();
                            Alumno nuevoAlumno = new Alumno(999, tipoMiembroOp8, aliasOp8, yearsEtseOp8, graduado,
                                    siglasCarrera);
                            opcion8vis2(nuevoAlumno, nomAsocOp8, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros,
                                    fechaAltaOp8);
                        }

                    }
                    System.out.println(listaDeTodasLasAsociaciones.toString());
                    System.out.println("\n\n");
                    System.out.println(listaDeTodosLosMiembros.toString());
                    break;
                    /*
                case 9:
                    int indiceFicheroOp9 = listaDeTodasLasAcciones.getNumeroAcciones() - 1;
                    String tipoAccionOp9 = "Charla";

                    // NOMBRE DE LA CHARLA
                    System.out.println("¿Cual es el nombre de la charla que quieres añadir?");
                    String nombreCharlaOp9 = introducirPorTeclado.nextLine();
                    // Comprovacion de si el nombre de la charla ya existe, en caso verdadero, se le
                    // pide que cambie el nombre
                    boolean estaRepetida = listaDeTodasLasAcciones.charlaRepetida(nombreCharlaOp9);
                    do {
                        if (estaRepetida) {
                            System.out.println("Este nombre ya existe, tendrás que cambiarlo. Escribe uno nuevo.");
                            nombreCharlaOp9 = introducirPorTeclado.nextLine();
                            if (!listaDeTodasLasAcciones.charlaRepetida(nombreCharlaOp9)) {
                                estaRepetida = false;
                            }
                        }
                    } while (estaRepetida);

                    // ASOCIACIONES INVOLUCRADAS
                    int maximo = listaDeTodasLasAsociaciones.getIndiceAsociaciones();
                    int i = 0;
                    String asocOp9;
                    System.out.println("¿Cuantas asociaciones hay involucradas? [1 - " + maximo + "]");
                    int iPersona = Integer.parseInt(introducirPorTeclado.nextLine());
                    do {
                        if ((iPersona == 0) || (iPersona > maximo)) {
                            System.out.println("Has introducido un número inválido. Vuelve a escribirlo.");
                            iPersona = Integer.parseInt(introducirPorTeclado.nextLine());
                        }
                    } while ((iPersona < 0) || (iPersona > maximo));

                    String[] asociacionesInvolOp9 = new String[iPersona];
                    boolean asociacionRepetida = false;
                    int j = 0;

                    do {
                        System.out.println("Escribe el nombre de la asociación involucrada.");
                        asocOp9 = introducirPorTeclado.nextLine();
                        boolean existe = listaDeTodasLasAsociaciones.existeAsociacionMismoNombre(asocOp9);

                        do {
                            if (!existe) {
                                System.out.println(
                                        "El nombre de la asociacion que has introducido no existe. Escribe un nombre existente.");
                                asocOp9 = introducirPorTeclado.nextLine();
                                existe = listaDeTodasLasAsociaciones.existeAsociacionMismoNombre(asocOp9);
                            }
                        } while (!existe);
                        asociacionesInvolOp9[i] = asocOp9;

                        if (i != 0) {
                            while ((!asociacionRepetida) && (j < i)) {
                                if (asociacionesInvolOp9[j].equals(asociacionesInvolOp9[i])) {
                                    asociacionRepetida = true;
                                } else {
                                    j++;
                                }
                            }
                        }

                        j = 0;

                        if (asociacionRepetida) {
                            System.out.println("Has introducido una asociacion que ya habias introducido.");
                            asociacionesInvolOp9[i] = null;
                        }

                        if (asociacionesInvolOp9[i] != null) {
                            i++;
                        }

                        asociacionRepetida = false;

                    } while (i < iPersona);

                    // ORGANIZADOR RESPONSABLE
                    System.out.println("¿Cuál es el alias del organizador responsable?");
                    String organizadorRespOp9 = introducirPorTeclado.nextLine();
                    int existe = listaDeTodosLosMiembros.miembroExistente(organizadorRespOp9);
                    do {
                        if (existe == -1) {
                            System.out.println("El alias que has introducido no existe. Escribe un alias válido");
                            organizadorRespOp9 = introducirPorTeclado.nextLine();
                            existe = listaDeTodosLosMiembros.miembroExistente(organizadorRespOp9);
                        }
                    } while (existe == -1);

                    // FECHA
                    // Se comprueba si la charla ya se ha realizado
                    System.out.println("¿La charla ya se ha realizado? (s/n)");
                    String aux = introducirPorTeclado.nextLine();
                    boolean charlaRealizada = false;
                    if (aux.equals("s")) {
                        charlaRealizada = true;
                    }
                    // Se pregunta el dia de la charla
                    System.out.println("¿Que día es la charla?");
                    int diaOp9 = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("¿En que número de mes es la charla?");
                    int mesOp9 = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("¿En que año es la charla?");
                    int yearOp9 = Integer.parseInt(introducirPorTeclado.nextLine());
                    Fecha fechaCharla = new Fecha(diaOp9, mesOp9, yearOp9);

                    // INSTRUCTORES DE LA CHARLA
                    System.out.println("¿Cuantos instructores hay? [1 - 3]");
                    int nInstructores = Integer.parseInt(introducirPorTeclado.nextLine());
                    do {
                        if ((nInstructores == 0) || (nInstructores > 3)) {
                            System.out.println("Has introducido un número inválido. Vuelve a escribirlo.");
                            nInstructores = Integer.parseInt(introducirPorTeclado.nextLine());
                        }
                    } while ((nInstructores == 0) || (nInstructores > 3));

                    i = 0;
                    j = 0;
                    String instructorOp9;
                    boolean instructorRepetido = false;
                    String[] instructoresCharla = new String[nInstructores];

                    do {
                        System.out.println("Escribe el alias del instructor");
                        instructorOp9 = introducirPorTeclado.nextLine();
                        existe = listaDeTodosLosMiembros.miembroExistente(instructorOp9);

                        do {
                            if (existe == -1) {
                                System.out.println("El alias que has introducido no existe. Escribe un alias válido");
                                instructorOp9 = introducirPorTeclado.nextLine();
                                existe = listaDeTodosLosMiembros.miembroExistente(instructorOp9);
                            }
                        } while (existe == -1);

                        instructoresCharla[i] = instructorOp9;

                        if (i != 0) {
                            while (j < i && !instructorRepetido) {
                                if (instructoresCharla[j].equals(instructoresCharla[i])) {
                                    instructorRepetido = true;
                                } else {
                                    j++;
                                }
                            }
                        }

                        j = 0;

                        if (instructorRepetido) {
                            System.out.println("Has introducido un alias que ya habias introducido.");
                            instructoresCharla[i] = null;
                        }

                        if (instructoresCharla[i] != null) {
                            i++;
                        }

                        instructorRepetido = false;

                    } while (i < nInstructores);

                    Charla charlaNueva;

                    if (charlaRealizada) {
                        System.out.println("¿Cuantas personas asistieron?");
                        int nAsistentes = Integer.parseInt(introducirPorTeclado.nextLine());
                        do {
                            if (nAsistentes < 0) {
                                System.out.println("Introduce un número de asistentes válido.");
                                nAsistentes = Integer.parseInt(introducirPorTeclado.nextLine());
                            }
                        } while (nAsistentes < 0);
                        
                        charlaNueva = new Charla(indiceFicheroOp9, nombreCharlaOp9, asociacionesInvolOp9,
                                organizadorRespOp9, fechaCharla, instructoresCharla,null, nAsistentes, 0);
                    } else {
                        charlaNueva = new Charla(indiceFicheroOp9, nombreCharlaOp9, asociacionesInvolOp9,
                                organizadorRespOp9, fechaCharla, instructoresCharla, null,0, 0);
                    }

                    }
                    //listaDeTodasLasAcciones.addAccion(charlaNueva);

                    System.out.println(listaDeTodasLasAcciones.toString());

                    break;
                    */
                case 10:
                    String[] miembrosParaComprobar = { "pedrito", "saraaaalaaa", "salatMalecom" };
                    opcion10(listaDeTodosLosMiembros, miembrosParaComprobar);
                    break;
                case 11:
                    opcion11(listaDeTodasLasAcciones);
                    break;
                case 12:
                    opcion12(listaDeTodasLasAsociaciones, listaDeTodosLosMiembros);
                    break;
                case 13:
                    System.out.println("Se mostraran todas las charlas que tengan más de X número de asistentes.");
                    System.out.println("Introduce el número");
                    int numeroAsistentes = Integer.parseInt(introducirPorTeclado.nextLine());
                    ;
                    opcion13(listaDeTodasLasAcciones, numeroAsistentes);
                    break;
                case 14:
                    opcion14(listaDeTodasLasAcciones);
                    System.out.println(listaDeTodasLasAcciones.toString());
                    break;
                case 15:
                    opcion15(listaDeTodasLasAcciones);

                    break;
                case 16:
                    do {
                        System.out.println("Introduce el nombre de la persona");
                        aliasPersonaOp16 = introducirPorTeclado.nextLine();
                    } while (listaDeTodosLosMiembros.miembroExistente(aliasPersonaOp16) == -1);
                    opcion16(listaDeTodasLasAcciones, listaDeTodosLosMiembros, aliasPersonaOp16);
                    break;
                case 17:
                    opcion17(listaDeTodasLasAcciones);
                    break;

                default: // aplicaremos un try catch para la opcion de menu por si escriben numero > 18
                    break;
            }
        }while(opcionMenu!=18);

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
        System.out.println(ListaMiembros.miembrosDeAsociacionConcreta(nombreAsociacion, listaDeTodasLasAsociaciones,
                listaDeTodosLosMiembros, filtro).toString());
    }

    public static void opcion3(ListaMiembros listaConTodosLosMiembros, String filtro,
            ListaAsociaciones todasLasAsociaciones) {
        System.out.println(
                listaConTodosLosMiembros.miembrosActivosAplicandoFiltro(filtro, todasLasAsociaciones).toString());
    }

    public static void opcion4(ListaAcciones listaDeTodasLasAcciones, String filtro) {
        System.out.println(listaDeTodasLasAcciones.accionesSegunTipo(filtro).toString());
    }

    public static void opcion5(ListaAcciones listaTodasLasAcciones, String nombreAsociacion) {
        System.out.println(ListaAcciones.accionesDeXAsociacion(listaTodasLasAcciones, nombreAsociacion).toString());
    }

    public static void opcion6(ListaAcciones listaTodasAcciones, Fecha limInf, Fecha limSup) {
        System.out.println(listaTodasAcciones.sublistaCharlasEnRangoFechas(limInf, limSup).toString());
    }

    public static void opcion7() {

    }

    public static int opcion8vis1(String alias, String nombreAsociacion, ListaMiembros listaTodosMiembros,
            ListaAsociaciones todasAsoc,
            Fecha fechaAlta) {
        int existe = listaTodosMiembros.miembroExistente(alias);

        if (existe != -1) {
            todasAsoc.addMiembroEnAsociacionExistente(alias, nombreAsociacion, todasAsoc, fechaAlta);
        }

        return existe;
    }

    public static void opcion8vis2(Miembro miembro, String nombreAsociacion, ListaAsociaciones listaTodasAsociaciones,
            ListaMiembros listaTodosMiembros, Fecha fechaAlta) {
        listaTodosMiembros.addMiembro(miembro);
        listaTodasAsociaciones.addMiembroEnAsociacionExistente(miembro.getAlias(), nombreAsociacion,
                listaTodasAsociaciones, fechaAlta);
    }

    // ESTO ES UNA PRUEBA DE LA FUNCION DE DANI DE SACAR UN VECTOR STRING CON LAS
    // INICIALES DE LAS CARRERAS DE LOS ALUMNOS
    public static void opcion10(ListaMiembros listaTodosLosMiembros, String[] miembrosACoprobar) {
        String[] vectorTitulaciones = ListaMiembros.titulacionesEnBaseAListaMiembros(listaTodosLosMiembros,
                miembrosACoprobar);

        for (int i = 0; i < vectorTitulaciones.length; i++) {
            System.out.println("La titulacion " + (i + 1) + " es:\t" + vectorTitulaciones[i]);
        }
    }

    public static void opcion11(ListaAcciones listaTodasLasAcciones) {
        System.out.println("Se mostrará el coste total de las demostraciones que no están activas.");
        ListaAcciones listaDemostracionesOp11 = listaTodasLasAcciones.listaDemostracionesFiltradasSegunEstado(false);
        double costeTotalOp11 = listaDemostracionesOp11.costeTotalDemostraciones();

        System.out.println("Hay un total de " + listaDemostracionesOp11.getNumeroAcciones()
                + " demostraciones que ya no están activas, y su coste fue:\t" + costeTotalOp11);
    }

    public static void opcion12(ListaAsociaciones listaTodasLasAsociaciones, ListaMiembros listaTodosMiembros) {
        System.out.println(
                listaTodosMiembros.miembroEnMasAsociaciones(listaTodasLasAsociaciones, listaTodosMiembros).toString());
    }

    public static void opcion13(ListaAcciones listaTodasLasAcciones, int asistentes) {
        System.out.println(listaTodasLasAcciones.listaCharlasMasXAsistentes(asistentes));
    }

    public static void opcion14(ListaAcciones listaTodasLasAcciones) {
        // Obtener el tema de la Charla
        System.out.println("Introduce el nombre de la charla ");
        try {
            String nombreCharla = introducirPorTeclado.nextLine();
            System.out.println("Introduce la valoracion");
            int valoracion = introducirPorTeclado.nextInt();
            introducirPorTeclado.nextLine();
            if (valoracion < 0 || valoracion > 10) {
                throw new ExcepcionesPropias.ValoracionFueraDeRangoException(
                        "La valoracion que has introducido esta fuera del rango");
            }
            // Buscamos la charla dentro de la lista de Acciones
            Charla charla = null;
            for (int indiceOp14 = 0; indiceOp14 < listaTodasLasAcciones.getNumeroAcciones(); indiceOp14++) {
                if (listaTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp14) instanceof Charla) {
                    Charla posibleCharla = (Charla) listaTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp14);
                    if (posibleCharla.getNombreAccion().equals(nombreCharla)) {
                        charla = posibleCharla;
                    }
                }
            }
            if (charla != null) {

                charla.hacerValoracion(valoracion);
                System.out.println("La valoración de la charla se ha realizado correctamente");

            } else {
                System.out.println("la charla con el nombre" + nombreCharla
                        + "no ha sido encontrada o no es una charla existente");
            }

        } catch (ExcepcionesPropias.ValoracionFueraDeRangoException e) {
            System.out.println("Error: " + e.getMessage());
            introducirPorTeclado.nextLine();
        }

    }

    public static void opcion15(ListaAcciones listaTodasLasAcciones) {

        double mejorResultado15 = 0.0;

        Charla mejorCharla15 = null;
        int maxNumeroValoraciones = 0;
        double mediaDeLasValoraciones = 0.0;
        int numeroValoraciones = 0;

        for (int indiceOp15 = 0; indiceOp15 < listaTodasLasAcciones.getNumeroAcciones(); indiceOp15++) {
            if (listaTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp15) instanceof Charla) {
                Charla charla15 = (Charla) listaTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp15);
                // Calculamos la media
                numeroValoraciones = charla15.getIndiceValoraciones();

                if (numeroValoraciones > 0) {
                    mediaDeLasValoraciones = (double) charla15.getSumaValoraciones() / (double) numeroValoraciones;
                }

                // Comprobamos cual es la mejor Charla
                if ((mediaDeLasValoraciones > mejorResultado15) || (mediaDeLasValoraciones == mejorResultado15)
                        && (numeroValoraciones > maxNumeroValoraciones)) {
                    mejorResultado15 = mediaDeLasValoraciones;
                    maxNumeroValoraciones = numeroValoraciones;
                    mejorCharla15 = charla15;
                }
            }
        }

        if (mejorCharla15 != null) {
            System.out.println("La Charla con mejor puntuación es: " + mejorCharla15.getNombreAccion());
            System.out.println("Su media es: " + mejorResultado15);
            System.out.println("El numero total de valoraciones es: " + maxNumeroValoraciones);
        } else {
            System.out.println("No hi ha cap xerrada disponible.");
        }
    }

    public static void opcion16(ListaAcciones listaDeTodasLasAcciones, ListaMiembros listaDeTodosLosMiembros,
            String aliasPersonaOp16) {
        System.out.println(ListaAcciones
                .listaCharlasDeXMiembro(listaDeTodosLosMiembros, listaDeTodasLasAcciones, aliasPersonaOp16).toString());
    }

    public static void opcion17(ListaAcciones listaDeTodasLasAcciones){
      System.out.println("Se van a dar de baja a las Demostraciones que no esten activas y que se diseñaron antes de la fecha que se introduce a continuación");
        System.out.println("Limite de Fecha:");
        System.out.println("Dia Limite :");
        int diaLim = Integer.parseInt(introducirPorTeclado.nextLine());
        System.out.println("Mes Limite:");
        int mesLim = Integer.parseInt(introducirPorTeclado.nextLine());
        System.out.println("Año Limite:");
        int yearLim = Integer.parseInt(introducirPorTeclado.nextLine());
        Fecha fechaLimite = new Fecha(diaLim, mesLim, yearLim);
        
        Demostracion demostracionBaja = null;
        
        for (int indiceOp17 = 0; indiceOp17 < listaDeTodasLasAcciones.getNumeroAcciones(); indiceOp17++){

            if ((listaDeTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp17) instanceof Demostracion ) && (listaDeTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp17).getFecha().equals(fechaLimite))){
                demostracionBaja = (Demostracion) listaDeTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp17);
            }
        }

        if (demostracionBaja != null){
            //Verificamos que la fecha sea anterior a la que hemos introducido 
            if (demostracionBaja.getFecha().compararFechas(fechaLimite) == 0){
                listaDeTodasLasAcciones.eliminarAccionPorFecha(fechaLimite);
                System.out.println("La demostracion se ha dado de baja correctamente");
            }else {
                System.out.println("La demostracion no ha podido darse de baja correctamente");
            }
        }
   
    }


}
