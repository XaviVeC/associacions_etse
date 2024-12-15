package prac3.Main_Consola;

import java.util.Scanner;

import prac3.Accion.Charla;
import prac3.Accion.Demostracion;
import prac3.Asociacion.Asociacion;
import prac3.Estructuras.ExcepcionesPropias;
import prac3.Estructuras.ExcepcionesPropias.AsociacionNoEncontradaException;
import prac3.Estructuras.ExcepcionesPropias.CharlaNoEncotradaException;
import prac3.Estructuras.Fecha;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;
import prac3.Estructuras.ListaMiembros;
import prac3.Fichero.EscribirEnFichero;
import prac3.Fichero.LeerFichero;
import prac3.Miembro.Alumno;
import prac3.Miembro.Miembro;
import prac3.Miembro.Profesor;

public class MainConsola {
    public static Scanner introducirPorTeclado = new Scanner(System.in);

    public static void main(String[] args) {

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
        String opcionMenu;
        int cantidadAcciones, cantidadMiembros, cantidadAsociaciones;
        int opcionMenuInt = 18;
        // Variables varias
        boolean entradaValidaOpcionMenu;
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

            entradaValidaOpcionMenu = false;
            do {
                mostraMenu();
                opcionMenu = introducirPorTeclado.nextLine();
                try {
                    opcionMenuInt = Integer.parseInt(opcionMenu);
                    entradaValidaOpcionMenu = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: '" + opcionMenu + "' no es un número válido. Inténtalo de nuevo.\n");
                }

            } while (!entradaValidaOpcionMenu);

            switch (opcionMenuInt) {
                case 1:// COMPROBADO
                    System.out.println("Se mostrará la lista con todas las asociaciones");
                    opcion1(listaDeTodasLasAsociaciones);
                    break;
                case 2:// COMPROBADO
                    boolean salirDoWhileOp2 = false;
                    String nombreAsociacionOp2 = "";
                    do {
                        System.out.println("¿Sobre qué asociación quieres información?");
                        nombreAsociacionOp2 = introducirPorTeclado.nextLine();

                        // Verificar si la asociación existe
                        try {
                            if (!listaDeTodasLasAsociaciones.existeAsociacion(nombreAsociacionOp2)) {
                                throw new ExcepcionesPropias.AsociacionNoEncontradaException(
                                        "La asociación '" + nombreAsociacionOp2
                                                + "' no existe. Por favor, inténtalo de nuevo.");
                            }
                            salirDoWhileOp2 = true;
                        } catch (AsociacionNoEncontradaException e) {
                            System.out.println(e.getMessage()); // Manejo de la excepción
                        }
                    } while (!salirDoWhileOp2);
                    System.out.println("Ahora se aplicará un filtro.");
                    int filtroOp2 = 0;
                    do {
                        System.out.println("Introduce:\n\t1 --> Professor\n\t2 --> Alumno\n\t3 --> Ambos");
                        try {
                            filtroOp2 = Integer.parseInt(introducirPorTeclado.nextLine());
                            if (filtroOp2 < 1 || filtroOp2 > 3) {
                                System.out.println("No existe esta opción.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Introduce un número.");
                        }
                    } while (filtroOp2 < 1 || filtroOp2 > 3);

                    String filtroStringOp2 = "";

                    switch (filtroOp2) {
                        case 1:
                            filtroStringOp2 = "Professor";
                            break;
                        case 2:
                            filtroStringOp2 = "Alumne";
                            break;
                        case 3:
                            filtroStringOp2 = "Ambos";
                            break;
                    }
                    opcion2(nombreAsociacionOp2, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros, filtroStringOp2);
                    break;

                case 3:// COMPROBADO
                    System.out.println(
                            "Se mostrará una lista con todos los miembros activos. Se aplicará un filtro.");
                    int filtroOp3 = 0;
                    do {
                        System.out.println("Introduce:\n\t1 --> Professor\n\t2 --> Alumno\n\t3 --> Ambos");
                        try {
                            filtroOp3 = Integer.parseInt(introducirPorTeclado.nextLine());
                            if (filtroOp3 < 1 || filtroOp3 > 3) {
                                System.out.println("No existe esta opción.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Introduce un número.");
                        }
                    } while (filtroOp3 < 1 || filtroOp3 > 3);

                    String filtroStringOp3 = "";

                    switch (filtroOp3) {
                        case 1:
                            filtroStringOp3 = "Professor";
                            break;
                        case 2:
                            filtroStringOp3 = "Alumne";
                            break;
                        case 3:
                            filtroStringOp3 = "Ambos";
                            break;
                    }
                    opcion3(listaDeTodosLosMiembros, filtroStringOp3, listaDeTodasLasAsociaciones);
                    break;
                case 4:// COMPROBADO
                    System.out.println("Se mostrarán las acciones filtradas si se quiere.");
                    int filtroOp4 = 0;
                    do {
                        System.out.println("Introduce:\n\t1 --> Demostracion\n\t2 --> Charla\n\t3 --> Ambos");
                        try {
                            filtroOp4 = Integer.parseInt(introducirPorTeclado.nextLine());
                            if (filtroOp4 < 1 || filtroOp4 > 3) {
                                System.out.println("No existe esta opción.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Introduce un número.");
                        }
                    } while (filtroOp4 < 1 || filtroOp4 > 3);

                    String filtroStringOp4 = "";

                    switch (filtroOp4) {
                        case 1:
                            filtroStringOp4 = "Demostracion";
                            break;
                        case 2:
                            filtroStringOp4 = "Charla";
                            break;
                        case 3:
                            filtroStringOp4 = "Ambos";
                            break;
                    }
                    System.out.println("¿Que tipo de accion quieres? (Charla, Demostracion, Ambos)");
                    opcion4(listaDeTodasLasAcciones, filtroStringOp4);
                    break;
                case 5:// COMPROBADO
                    String nombreAsociacionOp5 = "";
                    boolean salirDoWhileOp5 = false;
                    do {
                        System.out.println("¿Sobre qué asociación quieres información?");
                        nombreAsociacionOp5 = introducirPorTeclado.nextLine();
                        // Verificar si la asociación existe
                        try {
                            if (!listaDeTodasLasAsociaciones.existeAsociacion(nombreAsociacionOp5)) {
                                throw new ExcepcionesPropias.AsociacionNoEncontradaException(
                                        "La asociación '" + nombreAsociacionOp5
                                                + "' no existe. Por favor, inténtalo de nuevo.");
                            }
                            salirDoWhileOp5 = true;
                        } catch (AsociacionNoEncontradaException e) {
                            System.out.println(e.getMessage()); // Manejo de la excepción
                        }
                    } while (!salirDoWhileOp5);
                    opcion5(listaDeTodasLasAcciones, nombreAsociacionOp5);
                    break;
                case 6:// COMPROBADO
                    System.out
                            .println("\nSe mostrará la lista de Charlas dentro de un rango de fechas que introducirás");
                    System.out.println("Introduce el límite inferior:");
                    int diaInf = 0, mesInf = 0, yearInf = 0, diaSup = 0, mesSup = 0, yearSup = 0;
                    boolean entradaValidaOp6 = false;

                    do {
                        System.out.println("Día inferior:");
                        do {
                            try {
                                diaInf = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido.");
                            }
                        } while (!entradaValidaOp6);

                        if (diaInf < 1 || diaInf > 31) {
                            System.out.println("El rango de dias es de [1 - 31]");
                        }
                    } while (diaInf < 1 || diaInf > 31);

                    entradaValidaOp6 = false;

                    do {
                        System.out.println("Mes inferior:");
                        do {
                            try {
                                mesInf = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido.");
                            }
                        } while (!entradaValidaOp6);

                        if (mesInf < 1 || mesInf > 12) {
                            System.out.println("El rango de meses es de [1 - 12]");
                        }
                    } while (mesInf < 1 || mesInf > 12);

                    entradaValidaOp6 = false;

                    do {
                        System.out.println("Año inferior:");
                        System.out.println("El rango de años es de [1991 - 2024]");

                        do {
                            try {
                                yearInf = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido.");
                            }
                        } while (!entradaValidaOp6);

                        if (yearInf < 1991 || yearInf > 2024) {
                            System.out.println("Introduce un año válido");
                        }
                    } while (yearInf < 1991 || yearInf > 2024);

                    System.out.println("Introduce el límite superior:");
                    entradaValidaOp6 = false;

                    do {
                        System.out.println("Día superior:");
                        do {
                            try {
                                diaSup = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido.");
                            }
                        } while (!entradaValidaOp6);

                        if (diaSup < 1 || diaSup > 31) {
                            System.out.println("El rango de dias es de [1 - 31]");
                        }
                    } while (diaSup < 1 || diaSup > 31);

                    entradaValidaOp6 = false;

                    do {
                        System.out.println("Mes superior:");
                        do {
                            try {
                                mesSup = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido.");
                            }
                        } while (!entradaValidaOp6);

                        if (mesSup < 1 || mesSup > 12) {
                            System.out.println("El rango de meses es de [1 - 12]");
                        }
                    } while (mesSup < 1 || mesSup > 12);

                    entradaValidaOp6 = false;

                    do {
                        System.out.println("Año superior:");
                        System.out.println("El rango de años es de [1991 - 2024]");
                        do {
                            try {
                                yearSup = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido.");
                            }
                        } while (!entradaValidaOp6);

                        if (yearSup < 1991 || yearSup > 2024) {
                            System.out.println("Introduce un año válido");
                        }
                    } while (yearSup < 1991 || yearSup > 2024);
                    Fecha fechaInferior = new Fecha(diaInf, mesInf, yearInf);
                    Fecha fechaSuperior = new Fecha(diaSup, mesSup, yearSup);
                    opcion6(listaDeTodasLasAcciones, fechaInferior, fechaSuperior);
                    break;

                case 7:// FALTA COMPROBAR
                       // Variables que se utilizaran
                    String nombreAsociacionOp7;
                    int cantidadMiembrosOp7;
                    String nombreMiembroOp7;
                    String[] stringTitulacionesOp7;
                    Fecha[] vectorFechasAltaOp7;
                    Fecha[] vectorFechaBajaOp7;
                    String[] aliasPersonasCargosOp7;
                    // -------------------------------

                    System.out.println("Vas a añadir una nueva asociación");
                    System.out.println("Introduce el nombre del la asociación:");
                    do {
                        nombreAsociacionOp7 = introducirPorTeclado.nextLine();
                        if (listaDeTodasLasAsociaciones.existeAsociacion(nombreAsociacionOp7)) {
                            System.out.println("Ya existe este nombre, introducelo de nuevo");
                        }
                    } while (listaDeTodasLasAsociaciones.existeAsociacion(nombreAsociacionOp7));

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
                                // FALTA CREAR NUEVO MIEMBRO
                                System.out.println("Este miembro no existe, introduce alguno que sí lo haga.");
                            } else {
                                if (listaDeTodosLosMiembros.miembroPerteneceATresAsociaciones(
                                        listaDeTodasLasAsociaciones, nombreMiembroOp7)) {
                                    // COMPRUEBO QUE EL MIEMBRO ESTA EN 3 ASOCIACIONES O NO
                                    System.out.println(
                                            "esto miembro ya esta en tres asociaciones, no puede estar en mas, introduce alguno que si que pueda.");
                                }
                            }
                        } while (listaDeTodosLosMiembros.miembroExistente(nombreMiembroOp7) == -1
                                || (listaDeTodosLosMiembros.miembroPerteneceATresAsociaciones(
                                        listaDeTodasLasAsociaciones, nombreMiembroOp7)));

                        // Asignar el miembro válido al arreglo
                        miembrosAsociacion[indice] = nombreMiembroOp7;
                        indice++;
                    } while (indice < cantidadMiembrosOp7);
                    // Titulos
                    stringTitulacionesOp7 = ListaMiembros.titulacionesEnBaseAListaMiembros(listaDeTodosLosMiembros,
                            miembrosAsociacion);
                    // Fechas
                    System.out.println("¿Que número de día es hoy?");
                    int diaOp7 = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("¿En que número de mes estamos?");
                    int mesOp7 = Integer.parseInt(introducirPorTeclado.nextLine());
                    System.out.println("¿En que año estamos?");
                    int yearOp7 = Integer.parseInt(introducirPorTeclado.nextLine());
                    Fecha fechaAltaOp7 = new Fecha(diaOp7, mesOp7, yearOp7); // Fecha alta es hoy
                    Fecha fechaBajaOp7 = new Fecha(99, 99, 9999); // De momento no se ha dado de baja nadie
                    // string de fechas
                    vectorFechasAltaOp7 = new Fecha[miembrosAsociacion.length];
                    vectorFechaBajaOp7 = new Fecha[miembrosAsociacion.length];
                    for (int i = 0; i < miembrosAsociacion.length; i++) {
                        vectorFechasAltaOp7[i] = fechaAltaOp7.copia(); // Vector de fechas Alta
                        vectorFechaBajaOp7[i] = fechaBajaOp7.copia(); // Vector de fechas Baja
                    }
                    // Personas en los cargos
                    aliasPersonasCargosOp7 = new String[3];
                    for (int i = 0; i < 3; i++) {
                        aliasPersonasCargosOp7[i] = miembrosAsociacion[i]; // Vector de alias de los cargos altos
                    }
                    Asociacion asociacionNueva = new Asociacion(nombreAsociacionOp7, stringTitulacionesOp7,
                            miembrosAsociacion, aliasPersonasCargosOp7, vectorFechasAltaOp7, vectorFechaBajaOp7);
                    listaDeTodasLasAsociaciones.addAsociacion(asociacionNueva);
                    System.out.println(listaDeTodasLasAsociaciones.toString());
                    break;

                case 8:// FALTA COMPROBARLA
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

                case 9:// FALTA COMPROBARLA
                    int indiceFicheroOp9 = listaDeTodasLasAcciones.getNumeroAcciones() - 1;
                    // NOMBRE DE LA CHARLA
                    System.out.println("¿Cual es el nombre de la charla que quieres añadir?");
                    String nombreCharlaOp9 = introducirPorTeclado.nextLine();
                    // Comprovacion de si el nombre de la charla ya existe, en caso verdadero, se le
                    // pide que cambie el nombre
                    boolean charlaCorrectaOp9 = false;

                    do {
                        System.out.println("Escribe un nombre que no exista.");
                        nombreCharlaOp9 = introducirPorTeclado.nextLine();
                        if (listaDeTodasLasAcciones.noExisteCharla(nombreCharlaOp9)) {
                            charlaCorrectaOp9 = true;
                        }

                    } while (!charlaCorrectaOp9);

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
                        boolean existe = listaDeTodasLasAsociaciones.existeAsociacion(asocOp9);

                        do {
                            if (!existe) {
                                System.out.println(
                                        "El nombre de la asociacion que has introducido no existe. Escribe un nombre existente.");
                                asocOp9 = introducirPorTeclado.nextLine();
                                existe = listaDeTodasLasAsociaciones.existeAsociacion(asocOp9);
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
                                organizadorRespOp9, fechaCharla, instructoresCharla, null, nAsistentes, 0);
                    } else {
                        charlaNueva = new Charla(indiceFicheroOp9, nombreCharlaOp9, asociacionesInvolOp9,
                                organizadorRespOp9, fechaCharla, instructoresCharla, null, 0, 0);
                    }
                    listaDeTodasLasAcciones.addAccion(charlaNueva);

                    System.out.println(listaDeTodasLasAcciones.toString());

                    break;

                case 10:// ES UNA PRUEBA NO LA FUNCION FINAL
                    String[] miembrosParaComprobar = { "pedrito", "saraaaalaaa", "salatMalecom" };
                    opcion10(listaDeTodosLosMiembros, miembrosParaComprobar);
                    break;

                case 11://COMPROBADA
                    opcion11(listaDeTodasLasAcciones);
                    break;

                case 12://COMPROBADA
                    opcion12(listaDeTodasLasAsociaciones, listaDeTodosLosMiembros);
                    break;

                case 13://COMPROBADA
                    System.out.println("Se mostraran todas las charlas que tengan más de X número de asistentes.");
                    System.out.println("Introduce el número");
                    int numeroAsistentes = 0;
                    boolean formatoCorrectoOp13 = false;
                    do {
                        formatoCorrectoOp13 = false;
                        do {
                            try {
                                numeroAsistentes = Integer.parseInt(introducirPorTeclado.nextLine());
                                formatoCorrectoOp13 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Valor inválido, introduce otro valor");
                            }
                        } while (!formatoCorrectoOp13);

                        if (numeroAsistentes < 0) {
                            System.out.println("Valor incorrecto, el valor debe ser positivo");
                        } else {
                            opcion13(listaDeTodasLasAcciones, numeroAsistentes);
                        }
                    } while (numeroAsistentes < 0);

                    break;

                case 14://COMPROBADA
                    boolean charlaCorrectaOp14 = false;
                    String nombreCharlaOp14 = "";
                    boolean formatoCorrectoOp14 = false;
                    int valoracionOp14 = 0;
                    do {
                        try {
                            System.out.println("Introduce el nombre de la charla");
                            nombreCharlaOp14 = introducirPorTeclado.nextLine();
                            if (listaDeTodasLasAcciones.existeCharla(nombreCharlaOp14)) {
                                charlaCorrectaOp14 = true;
                                System.out.println("Introduce la valoracion [1 - 10]");
                                do {

                                    do {
                                        try {
                                            valoracionOp14 = Integer.parseInt(introducirPorTeclado.nextLine());
                                            formatoCorrectoOp14 = true;
                                        } catch (NumberFormatException e) {
                                            System.out.println("Valor incorrecto, introduce de nuevo.");
                                        }
                                    } while (!formatoCorrectoOp14);

                                    if (valoracionOp14 < 1 || valoracionOp14 > 10) {
                                        System.out.println("Introduce un valor válido [1 - 10]");
                                    }
                                } while (valoracionOp14 < 1 || valoracionOp14 > 10);
                                opcion14(listaDeTodasLasAcciones, nombreCharlaOp14, valoracionOp14);

                            }

                        } catch (CharlaNoEncotradaException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!charlaCorrectaOp14);

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

                case 18:
                    opcion18(listaDeTodasLasAcciones, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros);
                    break;
            }
        } while (opcionMenuInt < 18);
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
        System.out.println(listaDemostracionesOp11.toString());
    }

    public static void opcion12(ListaAsociaciones listaTodasLasAsociaciones, ListaMiembros listaTodosMiembros) {
        System.out.println(
                listaTodosMiembros.miembroEnMasAsociaciones(listaTodasLasAsociaciones, listaTodosMiembros).toString());
    }

    public static void opcion13(ListaAcciones listaTodasLasAcciones, int asistentes) {
        System.out.println(listaTodasLasAcciones.listaCharlasMasXAsistentes(asistentes));
    }

    public static void opcion14(ListaAcciones listaTodasLasAcciones, String nombreCharla, int valoracion) {
        switch (listaTodasLasAcciones.valorarXCharla(nombreCharla, valoracion)) {
            case 0:
                System.out.println("Charla valorada correctamente");
                System.out.println(listaTodasLasAcciones.toString());
                break;

            case 2:
                System.out.println("La charla " + nombreCharla
                        + " ya no se puede valorar, ha alcanzado el máximo de valoraciones");
                break;

            case 3:
                System.out.println("Valor " + valoracion + " no valido, valores válidos [1 - 10])");
                break;
        }

    }

    public static void opcion15(ListaAcciones listaTodasLasAcciones) {
        System.out.println(listaTodasLasAcciones.charlaMejorValorada().toString());
    }

    public static void opcion16(ListaAcciones listaDeTodasLasAcciones, ListaMiembros listaDeTodosLosMiembros,
            String aliasPersonaOp16) {
        System.out.println(
                listaDeTodasLasAcciones.listaCharlasDeXMiembro(listaDeTodosLosMiembros, aliasPersonaOp16).toString());
    }

    public static void opcion17(ListaAcciones listaDeTodasLasAcciones) {
        System.out.println(
                "Se van a dar de baja a las Demostraciones que no esten activas y que se diseñaron antes de la fecha que se introduce a continuación");
        System.out.println("Limite de Fecha:");
        System.out.println("Dia Limite :");
        int diaLim = Integer.parseInt(introducirPorTeclado.nextLine());
        System.out.println("Mes Limite:");
        int mesLim = Integer.parseInt(introducirPorTeclado.nextLine());
        System.out.println("Año Limite:");
        int yearLim = Integer.parseInt(introducirPorTeclado.nextLine());
        Fecha fechaLimite = new Fecha(diaLim, mesLim, yearLim);

        Demostracion demostracionBaja = null;

        for (int indiceOp17 = 0; indiceOp17 < listaDeTodasLasAcciones.getNumeroAcciones(); indiceOp17++) {

            if ((listaDeTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp17) instanceof Demostracion)
                    && (listaDeTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp17).getFecha()
                            .equals(fechaLimite))) {
                demostracionBaja = (Demostracion) listaDeTodasLasAcciones.getAccionEnXIndiceSinCopia(indiceOp17);
            }
        }

        if (demostracionBaja != null) {
            // Verificamos que la fecha sea anterior a la que hemos introducido
            if (demostracionBaja.getFecha().compararFechas(fechaLimite) == 0) {
                listaDeTodasLasAcciones.eliminarAccionPorFecha(fechaLimite);
                System.out.println("La demostracion se ha dado de baja correctamente");
            } else {
                System.out.println("La demostracion no ha podido darse de baja correctamente");
            }
        }

    }

    public static void opcion18(ListaAcciones listaDeTodasLasAcciones, ListaAsociaciones listaDeTodasLasAsociaciones,
            ListaMiembros listaDeTodosLosMiembros) {
        System.out.println("Deseas guardar la información en los ficheros antes de salir? s/n");
        String respuesta = introducirPorTeclado.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            EscribirEnFichero.guardarArchivoAcciones(listaDeTodasLasAcciones, "Acciones.txt");
            EscribirEnFichero.guardarListaAsociacionTexto(listaDeTodasLasAsociaciones, "Asociaciones.txt");
            EscribirEnFichero.guardarListaArchivoMiembros(listaDeTodosLosMiembros, "Miembros.txt");
            System.out.println("Datos guardados en archivos correctamente.\n");
        } else if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Los datos no se han guardado.\n");
        }

    }

}

/**
 * TO DO LIST
 * 1. En el toString de las asociaciones, indicar quien esta de baja o no
 * 2. Si no hay valoraciones mostrar un mensaje en el toString que ponga no
 * valorada (toString de Charlas)
 * 3. En el caso de que no se hayan llenado todas las valoraciones indicar que
 * aun se puede valorar.
 * 4. Completar la opcion 7
 * 5. Comprobar en la opcion 8
 * - añado alguien que esta -> Deja añadirlo pero luego no sale repetido en la
 * asociacion
 * - añado a alguien y despues al mismo -> Deja añadirlo pero luego no sale
 * repetido en la asociacion
 * - añado a alguien que no existe -> Se crea el miembro CORRECTO
 * - añado al mismo que antes
 * 6. ARREGLAR, si la titulacion del nuevo miembro que añades es valida y no
 * existe en la lista de titulaciones, no se añade esta titulacion a la lista
 * pero el miembro si. SE DEBERIA AÑADIR
 * 7. Estudiar si quitamos los correos de los ficheros, ya quese generan
 * automaticamente, y no hace falta leerlos,
 * y también quitar el indice fichero de todos los ficheros menos el de
 * acciones,
 * ya que en el de acciones se usa para crear el codigo de la accion, pero en el
 * resto (miembros y asociaciones) no se usa para nada.
 * 
 */
