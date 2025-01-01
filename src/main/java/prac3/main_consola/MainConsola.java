package prac3.Main_Consola;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import prac3.Accion.Charla;
import prac3.Accion.Demostracion;
import prac3.Asociacion.Asociacion;
import prac3.Estructuras.ExcepcionesPropias;
import prac3.Estructuras.ExcepcionesPropias.AsociacionNoEncontradaException;
import prac3.Estructuras.ExcepcionesPropias.CharlaNoEncotradaException;
import prac3.Estructuras.ExcepcionesPropias.MiembroEnTresAsociaciones;
import prac3.Estructuras.Fecha;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;
import prac3.Estructuras.ListaMiembros;
import prac3.Fichero.EscribirEnFichero;
import prac3.Fichero.LeerFichero;
import prac3.Main_Grafico.Main_Grafico;
import prac3.Miembro.Alumno;
import prac3.Miembro.Miembro;
import prac3.Miembro.Profesor;

public class MainConsola {
    public static Scanner introducirPorTeclado = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // VARIABLES DEL MAIN
        // -----------------------------------------------------------------
        int cantidadMaxima = 300;
        // Rutas de acceso de los ficheros
        String direccionesAcciones = "src/main/java/prac3/Fichero/Acciones.csv";
        String direccionesMiembros = "src/main/java/prac3/Fichero/Miembros.csv";
        String direccionesAsociacionesBin = "src/main/java/prac3/Fichero/AsociacionesSerializadas.bin";
        // String direccionesAsociacionesBinAux =
        // "src/main/java/prac3/Fichero/AsociacionesSerializadasAuxiliar.bin";
        // String direccionesAsociacionesBinario =
        // "src\\main\\java\\prac3\\Fichero\\AsociacionesSerializadas.bin";
        // Variables enteras varias
        int cantidadAcciones, cantidadMiembros;
        int opcionMenuInt = 18;
        // Variables varias
        boolean entradaValidaOpcionMenu;
        // Definicion de las distintas listas
        ListaAcciones listaDeTodasLasAcciones;
        ListaAsociaciones listaDeTodasLasAsociaciones;
        ListaMiembros listaDeTodosLosMiembros;

        // CANTIDADES DE ENTIDADES
        // --------------------------------------------------------------
        cantidadAcciones = LeerFichero.ContarEntidadesFichero(direccionesAcciones);
        cantidadMiembros = LeerFichero.ContarEntidadesFichero(direccionesMiembros);

        // CREACION DE LAS LISTAS
        // --------------------------------------------------------------
        listaDeTodasLasAcciones = new ListaAcciones(cantidadMaxima);
        listaDeTodasLasAsociaciones = new ListaAsociaciones(cantidadMaxima);
        listaDeTodosLosMiembros = new ListaMiembros(cantidadMaxima);

        LeerFichero.LeerFicheroAcciones(direccionesAcciones, listaDeTodasLasAcciones, cantidadAcciones);
        // System.out.println(listaDeTodasLasAcciones.toString());
        LeerFichero.LeerFicheroMiembros(direccionesMiembros, listaDeTodosLosMiembros, cantidadMiembros);
        // System.out.println(listaDeTodosLosMiembros.toString());
        LeerFichero.LeerListaAsociacionesBin(direccionesAsociacionesBin, listaDeTodasLasAsociaciones);
        // System.out.println(listaDeTodasLasAsociaciones.toString());
        SwingUtilities.invokeLater(
                () -> new Main_Grafico("Demostraciones", listaDeTodasLasAsociaciones, listaDeTodasLasAcciones));

        // BUCLE PRINCIPAL DEL PROGRAMA -----------------------------------------------
        do {
            System.out.println("Elige la opcion del menu.");

            entradaValidaOpcionMenu = false;
            do {
                mostraMenu();
                try {
                    opcionMenuInt = Integer.parseInt(introducirPorTeclado.nextLine());
                    entradaValidaOpcionMenu = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: '" + opcionMenuInt + "' no es un número válido. Introduce de nuevo:\n");
                }

            } while (!entradaValidaOpcionMenu);

            switch (opcionMenuInt) {
                case 1:// COMPROBADO
                    System.out.println("Se mostrará la lista con todas las asociaciones.");
                    opcion1(listaDeTodasLasAsociaciones);
                    break;
                case 2:// COMPROBADO
                    opcion1(listaDeTodasLasAsociaciones); // muestra la lista de asociaciones para que no tenga que
                                                          // abrir el archivo para consultarlo
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
                                                + "' no existe. Introduce de nuevo:");
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
                                System.out.println("No existe esta opción. Introduce de nuevo:");
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
                                System.out.println("No existe esta opción. Introduce de nuevo:");
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
                                System.out.println("No existe esta opción. Introduce de nuevo:");
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
                    opcion1(listaDeTodasLasAsociaciones); // muestra la lista de asociaciones para que no tenga que
                                                          // abrir el archivo para consultarlo
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
                                                + "' no existe. Introduce de nuevo:");
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
                    boolean entradaValidaOp6;

                    do {
                        entradaValidaOp6 = false;
                        System.out.println("Dia primer límite fecha:");
                        do {
                            try {
                                diaInf = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp6);

                        if (diaInf < 1 || diaInf > 31) {
                            System.out.println("El rango de dias es de [1 - 31]. Introduce de nuevo:");
                        }
                    } while (diaInf < 1 || diaInf > 31);

                    do {
                        entradaValidaOp6 = false;
                        System.out.println("Mes primer límite fecha:");
                        do {
                            try {
                                mesInf = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp6);

                        if (mesInf < 1 || mesInf > 12) {
                            System.out.println("El rango de meses es de [1 - 12]. Introduce de nuevo:");
                        }
                    } while (mesInf < 1 || mesInf > 12);

                    do {
                        entradaValidaOp6 = false;
                        System.out.println("Año primer límite fecha:");
                        System.out.println("El rango de años es de [1991 - 2025]");

                        do {
                            try {
                                yearInf = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp6);

                        if (yearInf < 1991 || yearInf > 2025) {
                            System.out.println("Introduce un año válido. Introduce de nuevo:");
                        }
                    } while (yearInf < 1991 || yearInf > 2025);

                    System.out.println("Introduce el límite superior:");

                    do {
                        entradaValidaOp6 = false;
                        System.out.println("Día segundo límite fecha:");
                        do {
                            try {
                                diaSup = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp6);

                        if (diaSup < 1 || diaSup > 31) {
                            System.out.println("El rango de dias es de [1 - 31]. Introduce de nuevo:");
                        }
                    } while (diaSup < 1 || diaSup > 31);

                    do {
                        entradaValidaOp6 = false;
                        System.out.println("Mes segundo límite fecha:");
                        do {
                            try {
                                mesSup = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp6);

                        if (mesSup < 1 || mesSup > 12) {
                            System.out.println("El rango de meses es de [1 - 12]. Introduce de nuevo:");
                        }
                    } while (mesSup < 1 || mesSup > 12);

                    do {
                        entradaValidaOp6 = false;
                        System.out.println("Año segundo límite fecha:");
                        System.out.println("El rango de años es de [1991 - 2025]");
                        do {
                            try {
                                yearSup = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp6 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp6);

                        if (yearSup < 1991 || yearSup > 2025) {
                            System.out.println("Introduce un año válido. Introduce de nuevo:");
                        }
                    } while (yearSup < 1991 || yearSup > 2025);

                    if (entradaValidaOpcionMenu) {

                    }
                    Fecha LimiteUno = new Fecha(diaInf, mesInf, yearInf);
                    Fecha LimiteDos = new Fecha(diaSup, mesSup, yearSup);

                    // comprobamos que fecha es menor
                    if (LimiteUno.compararFechas(LimiteDos) == 2) {
                        opcion6(listaDeTodasLasAcciones, LimiteDos, LimiteUno);
                    } else {
                        opcion6(listaDeTodasLasAcciones, LimiteUno, LimiteDos);
                    }

                    break;

                case 7:
                    // Variables que se utilizaran
                    String nombreAsociacionOp7;
                    int cantidadMiembrosOp7 = 0;
                    String nombreMiembroOp7;
                    String[] stringTitulacionesOp7;
                    Fecha[] vectorFechasAltaOp7;
                    Fecha[] vectorFechaBajaOp7;
                    String[] aliasPersonasCargosOp7;
                    boolean tamanyoCorrecto = false;
                    // -------------------------------

                    System.out.println("Vas a añadir una nueva asociación");
                    System.out.println("Introduce el nombre del la asociación:");
                    do {
                        nombreAsociacionOp7 = introducirPorTeclado.nextLine();
                        if (listaDeTodasLasAsociaciones.existeAsociacion(nombreAsociacionOp7)) {
                            System.out.println("Ya existe este nombre. Introduce de nuevo:");
                        }
                        tamanyoCorrecto = nombreAsociacionOp7.length() >= 3;
                        if (!tamanyoCorrecto) {
                            System.out.println("Debe tener al menos 3 caracteres. Introduce de nuevo:");
                        }
                        if (nombreAsociacionOp7.contains("-") || nombreAsociacionOp7.contains(";")) {
                            System.out.println("No puede contener el símbolo '-' ni el ';'. Introduce de nuevo:");
                        }
                    } while (listaDeTodasLasAsociaciones.existeAsociacion(nombreAsociacionOp7) || !tamanyoCorrecto ||
                            nombreAsociacionOp7.contains("-") || nombreAsociacionOp7.contains(";"));

                    System.out.println("Cuantos miembros quieres añadir, mínimo tres y máximo 20:");
                    boolean numeroValidoOp7 = false;
                    do {
                        do {
                            try {
                                cantidadMiembrosOp7 = Integer.parseInt(introducirPorTeclado.nextLine());
                                numeroValidoOp7 = true;
                            } catch (NumberFormatException e) {
                                System.out.println(
                                        "No se pueden introducir letras o caracteres especiales, solamente números. Introduce de nuevo:");
                            }
                        } while (!numeroValidoOp7);

                        if (cantidadMiembrosOp7 < 3 || cantidadMiembrosOp7 > 20) {
                            System.out.println("El mínimo de miembros es 3 y máximo 20. Introduce de nuevo:");
                        }
                    } while (cantidadMiembrosOp7 < 3 || cantidadMiembrosOp7 > 20);

                    int indice = 0;
                    String[] miembrosAsociacion = new String[cantidadMiembrosOp7];
                    boolean miembroValido = false, miembroRepetido;
                    System.out.println(
                            "El orden de los miembros introducidos corresponde con los cargos Presidente/a, Secretario/a y Tesorero/a.");
                    do {
                        System.out.println("Introduce el alias del miembro " + (indice + 1) + " :");

                        do {
                            miembroValido = false;
                            miembroRepetido = false;
                            nombreMiembroOp7 = introducirPorTeclado.nextLine();

                            if (listaDeTodosLosMiembros.miembroExistente(nombreMiembroOp7) == -1) {
                                System.out.println("Este miembro no existe. Introduce de nuevo:");
                            } else {
                                try {
                                    listaDeTodosLosMiembros.miembroPerteneceATresAsociaciones(
                                            listaDeTodasLasAsociaciones, nombreMiembroOp7);

                                    if (indice < 3) { // solo puede ser alumno
                                        if (listaDeTodosLosMiembros.esMiembroUnAlumno(nombreMiembroOp7)) {
                                            miembroValido = true;
                                        } else {
                                            System.out.println(
                                                    "Los cargos deben ser ocupados por alumnos. Introduce de nuevo:");
                                        }
                                    } else // puede ser cualquier cosa
                                    {
                                        miembroValido = true;
                                    }
                                } catch (MiembroEnTresAsociaciones e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            if (indice > 0) {
                                int i = 0;
                                while (i < indice && !miembroRepetido) {
                                    if (nombreMiembroOp7.equals(miembrosAsociacion[i])) {
                                        miembroRepetido = true;
                                        System.out.println("Ya has introducido este miembro. Introduce de nuevo:");
                                    } else {
                                        i++;
                                    }
                                }
                            }

                        } while (listaDeTodosLosMiembros.miembroExistente(nombreMiembroOp7) == -1 || !miembroValido
                                || miembroRepetido);

                        // Asignar el miembro válido al arreglo
                        miembrosAsociacion[indice] = nombreMiembroOp7;
                        indice++;
                    } while (indice < cantidadMiembrosOp7);
                    // Titulos
                    stringTitulacionesOp7 = listaDeTodosLosMiembros
                            .titulacionesEnBaseAListaMiembros(miembrosAsociacion);
                    // -------------------------------------------------------------------------------------
                    int diaOp7 = 0, mesOp7 = 0, yearOp7 = 0;
                    boolean entradaValidaOp7;
                    do {
                        entradaValidaOp7 = false;
                        System.out.println("Dia de creación:");
                        do {
                            try {
                                diaOp7 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp7 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp7);

                        if (diaOp7 < 1 || diaOp7 > 31) {
                            System.out.println("El rango de dias es de [1 - 31]. Introduce de nuevo:");
                        }
                    } while (diaOp7 < 1 || diaOp7 > 31);

                    do {
                        entradaValidaOp7 = false;
                        System.out.println("Mes de creacion:");
                        do {
                            try {
                                mesOp7 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp7 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp7);

                        if (mesOp7 < 1 || mesOp7 > 12) {
                            System.out.println("El rango de meses es de [1 - 12]. Introduce de nuevo:");
                        }
                    } while (mesOp7 < 1 || mesOp7 > 12);

                    do {
                        entradaValidaOp7 = false;
                        System.out.println("Año de creación:");
                        System.out.println("El rango de años es de [1991 - 2025]");

                        do {
                            try {
                                yearOp7 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp7 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp7);

                        if (yearOp7 < 1991 || yearOp7 > 2025) {
                            System.out.println("Introduce un año válido. Introduce de nuevo:");
                        }
                    } while (yearOp7 < 1991 || yearOp7 > 2025);

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

                case 8:// COMPROBADA
                    System.out.println("Para dar de alta a un miembro en una asociación.");

                    // ---------------------------------------------------------------------------------
                    String nomAsocOp8 = "";
                    Asociacion asociacionAuxiliarOp8 = null;
                    System.out.println("Escribe la asociación en la que te quieres apuntar.");
                    do {
                        nomAsocOp8 = introducirPorTeclado.nextLine();
                        if (!listaDeTodasLasAsociaciones.existeAsociacion(nomAsocOp8)) {
                            System.out.println("No existe la asociacion. Introduce de nuevo:");
                        } else {
                            boolean asociacionEncontradaOp8 = false;
                            int iBusquedaAsociacionOp8 = 0;
                            while (iBusquedaAsociacionOp8 < listaDeTodasLasAsociaciones.getIndiceAsociaciones()
                                    && !asociacionEncontradaOp8) {
                                if (listaDeTodasLasAsociaciones.getElementoListaAsociacion(iBusquedaAsociacionOp8)
                                        .getNombreAsociacion().equals(nomAsocOp8)) {
                                    asociacionAuxiliarOp8 = listaDeTodasLasAsociaciones
                                            .getElementoListaAsociacion(iBusquedaAsociacionOp8);
                                    asociacionEncontradaOp8 = true;
                                } else {
                                    iBusquedaAsociacionOp8++;
                                }
                            }

                        }

                    } while (!listaDeTodasLasAsociaciones.existeAsociacion(nomAsocOp8));
                    // ---------------------------------------------------------------------------------

                    // ---------------------------------------------------------------------------------
                    String aliasOp8 = "";
                    System.out.println("Escribe tu alias.");
                    boolean miembroValidoOp8;
                    do {
                        miembroValidoOp8 = false;
                        aliasOp8 = introducirPorTeclado.nextLine();

                        if (aliasOp8.contains(";") || aliasOp8.contains("-")) {
                            System.out.println("No pueden contener ';' o '-'. Introduce de nuevo:");

                        } else {
                            if (listaDeTodasLasAsociaciones.estaElMiembroActivoEnLaAsociacion(aliasOp8,
                                    asociacionAuxiliarOp8)) {
                                System.out.println("Este miembro ya está en la asociación. Introduce de nuevo:");
                            } else {
                                if (listaDeTodasLasAsociaciones.alumnoHaEstadoEnLaAsociacion(aliasOp8,
                                        asociacionAuxiliarOp8, listaDeTodosLosMiembros)) {
                                    System.out
                                            .println("Este alumno ya ha estado en la asociación. Introduce de nuevo:");
                                } else {
                                    miembroValidoOp8 = true;
                                }
                            }
                        }

                    } while (aliasOp8.contains(";") || aliasOp8.contains("-") || !miembroValidoOp8);
                    // ---------------------------------------------------------------------------------

                    int diaOp8 = 0, mesOp8 = 0, yearOp8 = 0;
                    // ---------------------------------------------------------------------------------
                    boolean entradaValidaOp8;
                    do {
                        entradaValidaOp8 = false;
                        System.out.println("Dia de alta:");
                        do {
                            try {
                                diaOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp8 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp8);

                        if (diaOp8 < 1 || diaOp8 > 31) {
                            System.out.println("El rango de dias es de [1 - 31]. Introduce de nuevo:");
                        }
                    } while (diaOp8 < 1 || diaOp8 > 31);

                    do {
                        entradaValidaOp8 = false;
                        System.out.println("Mes de alta:");
                        do {
                            try {
                                mesOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp8 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo: ");
                            }
                        } while (!entradaValidaOp8);

                        if (mesOp8 < 1 || mesOp8 > 12) {
                            System.out.println("El rango de meses es de [1 - 12]. Introduce de nuevo:");
                        }
                    } while (mesOp8 < 1 || mesOp8 > 12);

                    do {
                        entradaValidaOp8 = false;
                        System.out.println("Año de alta");
                        System.out.println("El rango de años es de [1991 - 2025]");

                        do {
                            try {
                                yearOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp8 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp8);

                        if (yearOp8 < 1991 || yearOp8 > 2025) {
                            System.out.println("Introduce un año válido:");
                        }
                    } while (yearOp8 < 1991 || yearOp8 > 2025);
                    // ---------------------------------------------------------------------------------
                    Fecha fechaAltaOp8 = new Fecha(diaOp8, mesOp8, yearOp8);
                    int comprovacion = opcion8vis1(aliasOp8, nomAsocOp8, listaDeTodosLosMiembros,
                            listaDeTodasLasAsociaciones, fechaAltaOp8);
                    if (comprovacion == -1) {
                        int tipoMiembroMenuOp8 = 0;
                        boolean valorCorrectoMenuOp8;
                        System.out.println("¿Eres alumno o profesor?\n\t(1 --> Alumno; 2 --> Profesor)");
                        do {
                            valorCorrectoMenuOp8 = false;
                            do {
                                try {
                                    tipoMiembroMenuOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                                    valorCorrectoMenuOp8 = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Debes introducir una opción del menú. Introduce otra vez:");
                                }
                            } while (!valorCorrectoMenuOp8);

                            if (tipoMiembroMenuOp8 < 1 || tipoMiembroMenuOp8 > 2) {
                                System.out.println("Esa opción no existe. Introduce de nuevo:");
                            }
                        } while (tipoMiembroMenuOp8 < 1 || tipoMiembroMenuOp8 > 2);
                        String tipoMiembroOp8;
                        if (tipoMiembroMenuOp8 == 1) {
                            tipoMiembroOp8 = "Alumne";
                        } else {
                            tipoMiembroOp8 = "Professor";
                        }

                        if (tipoMiembroOp8 == "Professor") {
                            // ---------------------------------------------------------------------------------
                            boolean opcionDepartamenoValido;
                            System.out
                                    .println("¿En que departamento estás? \nIntroduce: \n\t1 --> DEIM\n\t2 --> DEEEA");
                            int deptOp8 = 0;
                            String departamento = "";
                            do {
                                opcionDepartamenoValido = false;
                                do {
                                    try {
                                        deptOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                                        opcionDepartamenoValido = true;
                                    } catch (Exception e) {
                                        System.out.println(
                                                "No se pueden introducir letras ni caracteres especiales. Introduce un número:");
                                    }

                                } while (!opcionDepartamenoValido);
                                if (deptOp8 < 1 || deptOp8 > 2) {
                                    System.out.println("Opción no válida. Introduce de nuevo:");
                                }
                            } while (deptOp8 < 1 || deptOp8 > 2);
                            if (deptOp8 == 1) {
                                departamento = "DEIM";
                            } else {
                                departamento = "DEEEA";
                            }

                            // ---------------------------------------------------------------------------------

                            // ---------------------------------------------------------------------------------
                            System.out.println("¿Cual es tu número de despacho?");
                            int numDptOp8 = 0;
                            do {
                                opcionDepartamenoValido = false;
                                do {
                                    try {
                                        numDptOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                                        opcionDepartamenoValido = true;
                                    } catch (Exception e) {
                                        System.out.println(
                                                "No se pueden introducir letras ni caracteres especiales. Introduce un número.");
                                    }

                                } while (!opcionDepartamenoValido);
                                if (numDptOp8 < 0) {
                                    System.out.println("Opción no válida. Introduce de nuevo:");
                                }
                            } while (numDptOp8 < 0);

                            // ---------------------------------------------------------------------------------

                            Profesor nuevoProfesor = new Profesor(listaDeTodosLosMiembros.getNumeroMembres(),
                                    tipoMiembroOp8, aliasOp8, departamento, numDptOp8);
                            opcion8vis2(nuevoProfesor, nomAsocOp8, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros,
                                    fechaAltaOp8);
                        } else {

                            // ---------------------------------------------------------------------------------
                            System.out.println("¿Cuántos años llevas en la universidad?");
                            int yearsEtseOp8 = 0;
                            boolean formatosYearsValido;
                            do {
                                formatosYearsValido = false;

                                do {
                                    try {
                                        yearsEtseOp8 = Integer.parseInt(introducirPorTeclado.nextLine());
                                        formatosYearsValido = true;
                                    } catch (Exception e) {
                                        System.out.println(
                                                "No se pueden introducir letras ni caracteres especiales. Introduce un número.");
                                    }

                                } while (!formatosYearsValido);

                                if (yearsEtseOp8 <= 0 || yearsEtseOp8 > 15) {
                                    System.out.println("Opción no válida. Introduce de nuevo: [1 - 15]");
                                }

                            } while (yearsEtseOp8 <= 0 || yearsEtseOp8 > 15);

                            // ---------------------------------------------------------------------------------

                            // ---------------------------------------------------------------------------------
                            System.out.println("¿Ya estas graduado? (s/n)");
                            String letraOpcion = "";
                            boolean graduadoOp8 = false, validoGraduadoOp8 = false;

                            do {
                                letraOpcion = introducirPorTeclado.nextLine();
                                if (letraOpcion.equals("s") || letraOpcion.equals("n")) {
                                    validoGraduadoOp8 = true;
                                } else {
                                    System.out.println("No existe esta opción. Introduce de nuevo:");
                                }
                            } while (!validoGraduadoOp8);

                            if (letraOpcion.equals("s")) {
                                graduadoOp8 = true;
                            }

                            // ---------------------------------------------------------------------------------

                            // ---------------------------------------------------------------------------------
                            System.out.println("Iniciales de la carrera que cursas, introduce la opción:");
                            System.out.println(
                                    "\t\tGEB --> 1\tGEI --> 2\t\tGESST --> 3\n\t\tBioGEI --> 4 \tDG GEB-GESST --> 5\texternETSE --> 6");
                            int opcionMenuSiglas = 0;
                            boolean opcionCarreraValido;
                            String siglasCarrera = "";
                            do {
                                opcionCarreraValido = false;
                                do {
                                    try {
                                        opcionMenuSiglas = Integer.parseInt(introducirPorTeclado.nextLine());
                                        opcionCarreraValido = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Entrada incorrecta. Introduce un número:");
                                    }
                                } while (!opcionCarreraValido);

                                if (opcionMenuSiglas < 1 || opcionMenuSiglas > 6) {
                                    System.out.println("Esta opción no existe. Introduce de nuevo:");
                                }
                            } while (opcionMenuSiglas < 1 || opcionMenuSiglas > 6);
                            switch (opcionMenuSiglas) {
                                case 1:
                                    siglasCarrera = "GEB";
                                    break;
                                case 2:
                                    siglasCarrera = "GEI";
                                    break;
                                case 3:
                                    siglasCarrera = "GESST";
                                    break;
                                case 4:
                                    siglasCarrera = "BioGEI";
                                    break;
                                case 5:
                                    siglasCarrera = "DG GEB-GESST";
                                    break;
                                case 6:
                                    siglasCarrera = "externETSE";
                                    break;
                            }
                            // ---------------------------------------------------------------------------------

                            Alumno nuevoAlumno = new Alumno(listaDeTodosLosMiembros.getNumeroMembres(), tipoMiembroOp8,
                                    aliasOp8, yearsEtseOp8, graduadoOp8,
                                    siglasCarrera);
                            opcion8vis2(nuevoAlumno, nomAsocOp8, listaDeTodasLasAsociaciones, listaDeTodosLosMiembros,
                                    fechaAltaOp8);
                        }

                    }
                    System.out.println(listaDeTodasLasAsociaciones.toString());
                    System.out.println("\n\n");
                    System.out.println(listaDeTodosLosMiembros.toString());
                    break;

                case 9:// COMPROBADA
                    int indiceFicheroOp9 = listaDeTodasLasAcciones
                            .getAccionEnXIndice(listaDeTodasLasAcciones.getNumeroAcciones() - 1).getIndiceFichero() + 1;

                    // NOMBRE DE LA CHARLA
                    // --------------------------------------------------------------------------------
                    System.out.println("¿Cual es el nombre de la charla que quieres añadir?");
                    String nombreCharlaOp9;
                    // Comprovacion de si el nombre de la charla ya existe, en caso verdadero, se le
                    // pide que cambie el nombre
                    boolean charlaCorrectaOp9 = false;
                    do {

                        nombreCharlaOp9 = introducirPorTeclado.nextLine();
                        if (listaDeTodasLasAcciones.noExisteCharla(nombreCharlaOp9)) {
                            if (nombreCharlaOp9.contains(";")) {
                                System.out.println("El nombre de la charla no puede contener ';'. Introduce de nuevo:");
                            } else {
                                charlaCorrectaOp9 = true;
                            }

                        } else {
                            System.out.println("Escribe un nombre que no exista. Introduce de nuevo:");
                        }

                    } while (!charlaCorrectaOp9);
                    // --------------------------------------------------------------------------------

                    // ASOCIACIONES INVOLUCRADAS. COMPROBADO

                    int maximo = listaDeTodasLasAsociaciones.getIndiceAsociaciones();

                    String asocOp9;
                    System.out.println("¿Cuantas asociaciones hay involucradas? [1 - " + maximo + "]");
                    int nAsociacionesInvolucradasOp9 = 0;
                    boolean formatoNumeroAsociacionesOp9;
                    do {
                        formatoNumeroAsociacionesOp9 = false;
                        do {
                            try {
                                nAsociacionesInvolucradasOp9 = Integer.parseInt(introducirPorTeclado.nextLine());
                                formatoNumeroAsociacionesOp9 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada no válida. Introduce de nuevo:");
                            }
                        } while (!formatoNumeroAsociacionesOp9);

                        if ((nAsociacionesInvolucradasOp9 < 0) || (nAsociacionesInvolucradasOp9 > maximo)) {
                            System.out.println("Has introducido un número inválido. Vuelve a escribirlo.");
                        }
                    } while ((nAsociacionesInvolucradasOp9 < 0) || (nAsociacionesInvolucradasOp9 > maximo));

                    String[] asociacionesInvolOp9 = new String[nAsociacionesInvolucradasOp9];
                    boolean asociacionRepetida = false;
                    int j = 0, i = 0;
                    // NOMBRES DE LAS POSIBLES ASOCIACIONES
                    System.out.println("Las asociaciones que existen son:");
                    for (int k = 0; k < listaDeTodasLasAsociaciones.getIndiceAsociaciones(); k++) {
                        System.out.println("La asociación " + (k + 1) + " es:\t"
                                + listaDeTodasLasAsociaciones.getElementoListaAsociacion(k).getNombreAsociacion());
                    }
                    do {
                        System.out.println("Escribe el nombre de la asociación involucrada.");
                        asocOp9 = introducirPorTeclado.nextLine();
                        boolean existe = listaDeTodasLasAsociaciones.existeAsociacion(asocOp9);

                        do {
                            if (!existe) {
                                System.out.println(
                                        "El nombre de la asociacion que has introducido no existe. Escribe un nombre existente:");
                                asocOp9 = introducirPorTeclado.nextLine();
                                existe = listaDeTodasLasAsociaciones.existeAsociacion(asocOp9);
                            }
                        } while (!existe);

                        asociacionesInvolOp9[i] = asocOp9;

                        if (i != 0) {
                            while ((!asociacionRepetida) && (j < i)) {
                                if (asociacionesInvolOp9[j].equals(asociacionesInvolOp9[i])) {
                                    asociacionRepetida = true;
                                    System.out.println("Ya has introduciodo esta asociación. Introduce de nuevo:");
                                } else {
                                    j++;
                                }
                            }
                        }

                        j = 0;

                        if (asociacionRepetida) {
                            asociacionesInvolOp9[i] = null;
                        }

                        if (asociacionesInvolOp9[i] != null) {
                            i++;
                        }

                        asociacionRepetida = false;

                    } while (i < nAsociacionesInvolucradasOp9);

                    // -------------------------------------------------------------------------------------------------------
                    // ORGANIZADOR RESPONSABLE. COMPROBADO
                    // mostrar los posibles alias de las asociaciones
                    boolean asociacionEncontradaOp9 = false;
                    int indiceBusquedaAsociacionOp9 = 0;
                    System.out.println("Estos son los posibles responsables: ");
                    for (int k = 0; k < asociacionesInvolOp9.length; k++) {
                        asociacionEncontradaOp9 = false;
                        indiceBusquedaAsociacionOp9 = 0;
                        while (!asociacionEncontradaOp9
                                && indiceBusquedaAsociacionOp9 < listaDeTodasLasAsociaciones.getIndiceAsociaciones()) {
                            if (asociacionesInvolOp9[k].equals(listaDeTodasLasAsociaciones
                                    .getElementoListaAsociacion(indiceBusquedaAsociacionOp9).getNombreAsociacion())) {
                                System.out.println(listaDeTodasLasAsociaciones
                                        .getElementoListaAsociacion(indiceBusquedaAsociacionOp9).toString() + "\n");
                                asociacionEncontradaOp9 = true;
                            } else {
                                indiceBusquedaAsociacionOp9++;
                            }
                        }
                    }
                    String organizadorRespOp9 = "";
                    int existe = -1;
                    boolean estaEnAsociacion = false;
                    do {
                        System.out.println("¿Cuál es el alias del organizador responsable?");
                        organizadorRespOp9 = introducirPorTeclado.nextLine();
                        existe = listaDeTodosLosMiembros.miembroExistente(organizadorRespOp9);
                        estaEnAsociacion = listaDeTodasLasAsociaciones
                                .existeMiembroEnListaAsociaciones(organizadorRespOp9, asociacionesInvolOp9);
                        if (existe == -1) {
                            System.out.println("El alias que has introducido no existe. Introduce de nuevo:");
                        } else {
                            if (!estaEnAsociacion) {
                                System.out.println(
                                        "El alias que has introdicido no se encuentra en ninguna de las asociaciones involucradas. Introduce de nuevo:");
                            }
                        }
                    } while (existe == -1 || !estaEnAsociacion);
                    // -------------------------------------------------------------------------------------------------------

                    // -------------------------------------------------------------------------------------------------------
                    // Se comprueba si la charla ya se ha realizado. COMPROBADO
                    System.out.println("¿La charla ya se ha realizado? (s/n)");
                    String letraOp9 = "";
                    boolean charlaRealizada = false;

                    do {
                        letraOp9 = introducirPorTeclado.nextLine();
                        if (letraOp9.equals("s") || letraOp9.equals("n")) {
                            charlaRealizada = true;
                        } else {
                            System.out.println("No existe esta opción. Introduce de nuevo:");
                        }
                    } while (!charlaRealizada);
                    // -------------------------------------------------------------------------------------------------------

                    // -------------------------------------------------------------------------------------------------------
                    // Se pregunta el dia de la charla. COMPROBADO
                    int diaOp9 = 0, mesOp9 = 0, yearOp9 = 0;
                    boolean entradaValidaOp9;
                    do {
                        entradaValidaOp9 = false;
                        System.out.println("Dia en que está programada la charla o se hizo la charla:");
                        do {
                            try {
                                diaOp9 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp9 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp9);

                        if (diaOp9 < 1 || diaOp9 > 31) {
                            System.out.println("El rango de dias es de [1 - 31]. Introduce de nuevo:");
                        }
                    } while (diaOp9 < 1 || diaOp9 > 31);

                    do {
                        entradaValidaOp9 = false;
                        System.out.println("Mes en que está programada la charla o se hizo la charla:");
                        do {
                            try {
                                mesOp9 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp9 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp9);

                        if (mesOp9 < 1 || mesOp9 > 12) {
                            System.out.println("El rango de meses es de [1 - 12]. Introduce de nuevo:");
                        }
                    } while (mesOp9 < 1 || mesOp9 > 12);

                    do {
                        entradaValidaOp9 = false;
                        System.out.println("Año en que está programada la charla o se hizo la charla:");
                        System.out.println("El rango de años es de [1991 - 2025]");

                        do {
                            try {
                                yearOp9 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp9 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp9);

                        if (yearOp9 < 1991 || yearOp9 > 2025) {
                            System.out.println("Introduce un año válido. Introduce de nuevo:");
                        }
                    } while (yearOp9 < 1991 || yearOp9 > 2025);
                    Fecha fechaCharla = new Fecha(diaOp9, mesOp9, yearOp9);
                    // -------------------------------------------------------------------------------------------------------

                    // -------------------------------------------------------------------------------------------------------
                    // INSTRUCTORES DE LA CHARLA. COMPROBADO
                    int nInstructores = 0;
                    boolean formatoCorrecto;
                    do {
                        System.out.println("¿Cuantos instructores hay? [1 - 3]");
                        formatoCorrecto = false;
                        do {
                            try {
                                nInstructores = Integer.parseInt(introducirPorTeclado.nextLine());
                                formatoCorrecto = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada incorrecta. Introduce un número:");
                            }
                        } while (!formatoCorrecto);
                        if ((nInstructores == 0) || (nInstructores > 3)) {
                            System.out.println("Has introducido un número inválido. Vuelve a escribirlo:");
                            nInstructores = Integer.parseInt(introducirPorTeclado.nextLine());

                        }
                    } while ((nInstructores == 0) || (nInstructores > 3));

                    i = 0;
                    j = 0;
                    String instructorOp9;
                    boolean instructorRepetido = false;
                    boolean estaEnLaAsociacion = false;
                    String[] instructoresCharla = new String[nInstructores];
                    System.out.println("Los posibles instructores son: ");
                    for (int k = 0; k < asociacionesInvolOp9.length; k++) {
                        asociacionEncontradaOp9 = false;
                        indiceBusquedaAsociacionOp9 = 0;
                        while (!asociacionEncontradaOp9
                                && indiceBusquedaAsociacionOp9 < listaDeTodasLasAsociaciones.getIndiceAsociaciones()) {
                            if (asociacionesInvolOp9[k].equals(listaDeTodasLasAsociaciones
                                    .getElementoListaAsociacion(indiceBusquedaAsociacionOp9).getNombreAsociacion())) {
                                System.out.println(listaDeTodasLasAsociaciones
                                        .getElementoListaAsociacion(indiceBusquedaAsociacionOp9).toString() + "\n");
                                asociacionEncontradaOp9 = true;
                            } else {
                                indiceBusquedaAsociacionOp9++;
                            }
                        }
                    }
                    do {
                        System.out.println("Escribe el alias del instructor");

                        do {
                            instructorOp9 = introducirPorTeclado.nextLine();
                            existe = listaDeTodosLosMiembros.miembroExistente(instructorOp9);
                            estaEnLaAsociacion = listaDeTodasLasAsociaciones
                                    .existeMiembroEnListaAsociaciones(instructorOp9, asociacionesInvolOp9);
                            if (existe == -1) {
                                System.out.println("El alias que has introducido no existe. Introduce de nuevo:");
                            } else {
                                if (!estaEnLaAsociacion) {
                                    System.out.println(
                                            "El alias que has introdicido no se encuentra en ninguna de las asociaciones involucradas o está de baja. Introduce de nuevo:");
                                }
                            }
                        } while (existe == -1 || !estaEnLaAsociacion);

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
                            System.out
                                    .println("Has introducido un alias que ya habias introducido. Introduce de nuevo:");
                            instructoresCharla[i] = null;
                        }

                        if (instructoresCharla[i] != null) {
                            i++;
                        }

                        instructorRepetido = false;

                    } while (i < nInstructores);
                    // -------------------------------------------------------------------------------------------------------
                    Charla charlaNueva;

                    if (charlaRealizada) {

                        // -------------------------------------------------------------------------------------------------------
                        System.out.println("¿Cuantas personas asistieron?");
                        int nAsistentes = 0;
                        boolean entradaCorrecta;
                        int maxAsistentesOp9 = 700;
                        do {
                            entradaCorrecta = false;
                            do {
                                try {
                                    nAsistentes = Integer.parseInt(introducirPorTeclado.nextLine());
                                    entradaCorrecta = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada incorrecta. Introduce de nuevo:");
                                }
                            } while (!entradaCorrecta);

                            if (nAsistentes <= 0 || nAsistentes > maxAsistentesOp9) {
                                System.out.println("Introduce un número de asistentes válido. Introduce de nuevo:");
                            }
                        } while (nAsistentes <= 0 || nAsistentes > maxAsistentesOp9);

                        // -------------------------------------------------------------------------------------------------------

                        charlaNueva = new Charla(indiceFicheroOp9, nombreCharlaOp9, asociacionesInvolOp9,
                                organizadorRespOp9, fechaCharla, instructoresCharla, null, nAsistentes, 0);
                    } else {
                        charlaNueva = new Charla(indiceFicheroOp9, nombreCharlaOp9, asociacionesInvolOp9,
                                organizadorRespOp9, fechaCharla, instructoresCharla, null, 0, 0);
                    }

                    listaDeTodasLasAcciones.addAccion(charlaNueva);

                    System.out.println(listaDeTodasLasAcciones.toString());

                    break;

                case 10:// COMPROBADA
                    String filtroStringOp10;
                    filtroStringOp10 = "Demostracion";
                    opcion4(listaDeTodasLasAcciones, filtroStringOp10);
                    int indiceFicheroOp10 = listaDeTodasLasAcciones
                            .getAccionEnXIndice(listaDeTodasLasAcciones.getNumeroAcciones() - 1).getIndiceFichero() + 1;
                    // ----------------------------------------------------------
                    // PEDIR Y COMPROBAR EL NOMBRE DE LA DEMOSTRACIÓN
                    System.out.println("¿Cual es el nombre de la demostración que quieres añadir?");
                    String nombreDemostracionOp10;
                    // Comprovacion de si el nombre de la charla ya existe, en caso verdadero, se le
                    // pide que cambie el nombre
                    boolean demostracionCorrectaOp10 = false;
                    do {
                        nombreDemostracionOp10 = introducirPorTeclado.nextLine();
                        if (listaDeTodasLasAcciones.noExisteDemostracion(nombreDemostracionOp10)) {
                            if (nombreDemostracionOp10.length() >= 3) {
                                if (!nombreDemostracionOp10.contains(";")) {
                                    demostracionCorrectaOp10 = true;
                                } else {
                                    System.out.println("No puede contener el caracter ';', Introduce de nuevo:");
                                }
                            } else {
                                System.out.println("Debe tener al menos 3 caracteres. Introduce de nuevo:");
                            }
                        } else {
                            System.out.println("Escribe un nombre que no exista. Introduce de nuevo:");
                        }

                    } while (!demostracionCorrectaOp10);

                    // cantidad de asociaciones involucradas
                    boolean formatoCorrectoCantidadOp10;
                    int cantidadAsociacionesInvolucradasOp10 = 0;
                    do {
                        System.out.println(
                                "Introduce el número de asociaciones involucradas. [1 - " + listaDeTodasLasAsociaciones
                                        .getIndiceAsociaciones() + "]");
                        formatoCorrectoCantidadOp10 = false;
                        do {
                            try {
                                cantidadAsociacionesInvolucradasOp10 = Integer
                                        .parseInt(introducirPorTeclado.nextLine());
                                formatoCorrectoCantidadOp10 = true;

                            } catch (NumberFormatException e) {
                                System.out.println("Entrada incorrecta, debe estar un número. Introduce de nuevo:");
                            }

                        } while (!formatoCorrectoCantidadOp10);

                        if (cantidadAsociacionesInvolucradasOp10 <= 0
                                || cantidadAsociacionesInvolucradasOp10 > listaDeTodasLasAsociaciones
                                        .getIndiceAsociaciones()) {
                            System.out.println("La cantidad no es correcta. Introduce de nuevo:");
                        }
                    } while (cantidadAsociacionesInvolucradasOp10 <= 0
                            || cantidadAsociacionesInvolucradasOp10 > listaDeTodasLasAsociaciones
                                    .getIndiceAsociaciones());

                    // -----------------------------------------------
                    // COMPROBACION ASOCIACION EXISTE Y NO SE REPITEN
                    String[] asociacionesInvolOp10 = new String[cantidadAsociacionesInvolucradasOp10];

                    boolean asociacionRepetidaOp10 = false;

                    int jj = 0, ii = 0;
                    String asocOp10;
                    opcion1(listaDeTodasLasAsociaciones);
                    do {
                        System.out.println("Escribe el nombre de la asociación involucrada.");
                        asocOp10 = introducirPorTeclado.nextLine();
                        boolean existeOp10 = listaDeTodasLasAsociaciones.existeAsociacion(asocOp10);

                        do {
                            if (!existeOp10) {
                                System.out.println(
                                        "El nombre de la asociacion que has introducido no existe. Introduce de nuevo:");
                                asocOp10 = introducirPorTeclado.nextLine();
                                existeOp10 = listaDeTodasLasAsociaciones.existeAsociacion(asocOp10);
                            }
                        } while (!existeOp10);

                        asociacionesInvolOp10[ii] = asocOp10;

                        if (ii != 0) {
                            while ((!asociacionRepetidaOp10) && (jj < ii)) {
                                if (asociacionesInvolOp10[jj].equals(asociacionesInvolOp10[ii])) {
                                    asociacionRepetidaOp10 = true;
                                    System.out.println("Ya has introduciodo esta asociación. Introduce de nuevo:");
                                } else {
                                    jj++;
                                }
                            }
                        }

                        jj = 0;

                        if (asociacionRepetidaOp10) {
                            asociacionesInvolOp10[ii] = null;
                        }

                        if (asociacionesInvolOp10[ii] != null) {
                            ii++;
                        }

                        asociacionRepetidaOp10 = false;

                    } while (ii < cantidadAsociacionesInvolucradasOp10);
                    // ----------------------------------------------------------------

                    // -------------------------------------------------------------------------------------------------------
                    // ORGANIZADOR RESPONSABLE. COMPROBADO

                    String organizadorRespOp10 = "";
                    int existeOrganizadorRespOp10 = -1;
                    boolean estaEnAsociacionOp10 = false;
                    do {
                        System.out.println("¿Cuál es el alias del organizador responsable?");
                        organizadorRespOp10 = introducirPorTeclado.nextLine();
                        existeOrganizadorRespOp10 = listaDeTodosLosMiembros.miembroExistente(organizadorRespOp10);
                        estaEnAsociacionOp10 = listaDeTodasLasAsociaciones
                                .existeMiembroEnListaAsociaciones(organizadorRespOp10, asociacionesInvolOp10);
                        if (existeOrganizadorRespOp10 == -1) {
                            System.out.println("El alias que has introducido no existe. Introduce de nuevo:");
                        } else {
                            if (!estaEnAsociacionOp10) {
                                System.out.println(
                                        "El alias que has introdicido no se encuentra en ninguna de las asociaciones involucradas. Introduce de nuevo:");
                            }
                        }
                    } while (existeOrganizadorRespOp10 == -1 || !estaEnAsociacionOp10);
                    // -------------------------------------------------------------------------------------------------------

                    // -------------------------------------------------------------------------------------------------------
                    // Se pregunta el dia de la charla. COMPROBADO
                    int diaOp10 = 0, mesOp10 = 0, yearOp10 = 0;
                    boolean entradaValidaOp10;
                    do {
                        entradaValidaOp10 = false;
                        System.out.println("Dia en que está programada la demostracion o se hizo la demostracion:");
                        do {
                            try {
                                diaOp10 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp10 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp10);

                        if (diaOp10 < 1 || diaOp10 > 31) {
                            System.out.println("El rango de dias es de [1 - 31]. Introduce de nuevo:");
                        }
                    } while (diaOp10 < 1 || diaOp10 > 31);

                    do {
                        entradaValidaOp10 = false;
                        System.out.println("Mes en que está programada la demostracion o se hizo la demostracion:");
                        do {
                            try {
                                mesOp10 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp10 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp10);

                        if (mesOp10 < 1 || mesOp10 > 12) {
                            System.out.println("El rango de meses es de [1 - 12]. Introduce de nuevo:");
                        }
                    } while (mesOp10 < 1 || mesOp10 > 12);

                    do {
                        entradaValidaOp10 = false;
                        System.out.println("Año en que está programada la demostracion o se hizo la demostracion:");
                        System.out.println("El rango de años es de [1991 - 2025]");

                        do {
                            try {
                                yearOp10 = Integer.parseInt(introducirPorTeclado.nextLine());
                                entradaValidaOp10 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Has introducido un valor inválido. Introduce de nuevo:");
                            }
                        } while (!entradaValidaOp10);

                        if (yearOp10 < 1991 || yearOp10 > 2025) {
                            System.out.println("Introduce un año válido. Introduce de nuevo:");
                        }
                    } while (yearOp10 < 1991 || yearOp10 > 2025);
                    Fecha fechaCharlaOp10 = new Fecha(diaOp10, mesOp10, yearOp10);
                    // -------------------------------------------------------------------------------------------------------
                    // COMPROBACION COSTE DE LA DEMOSTRACION
                    double costeDemostracion = -1.0;
                    boolean entradaCorrectaCosteOp10;
                    do {
                        System.out.println("Introduce el coste de la demostración. [0 - 10.000]");
                        entradaCorrectaCosteOp10 = false;
                        do {
                            try {
                                costeDemostracion = Double.parseDouble(introducirPorTeclado.nextLine());
                                entradaCorrectaCosteOp10 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada incorrecta. Introduce un número:");
                            }
                        } while (!entradaCorrectaCosteOp10);
                        if (costeDemostracion < 0.0 || costeDemostracion > 10000.0) {
                            System.out.println("Valor incorrecto. Introduce de nuevo:");
                        }
                    } while (costeDemostracion < 0.0 || costeDemostracion > 10000.0);

                    // -------------------------------------------------------------------------------------------------------
                    // ----------------------------------------------------
                    // COMPROBAR SI SE OFRECE LA DEMOSTRACION
                    String opcionEstadoDemostracion;
                    boolean valido = false;
                    boolean disponible = false;
                    int vecesOfrecidaOp10 = 0;
                    do {
                        System.out.println("¿Se ha ofrecido la demostración? (s/n)");
                        opcionEstadoDemostracion = introducirPorTeclado.nextLine();
                        if (opcionEstadoDemostracion.equals("s") || opcionEstadoDemostracion.equals("n")) {
                            valido = true;
                        }
                    } while (!valido);

                    if (opcionEstadoDemostracion.equals("s")) {
                        disponible = true;
                        vecesOfrecidaOp10 = 1;
                    }
                    // ----------------------------------------------------

                    Demostracion newDemo = new Demostracion(indiceFicheroOp10, nombreDemostracionOp10,
                            asociacionesInvolOp10,
                            organizadorRespOp10, fechaCharlaOp10, costeDemostracion, disponible, vecesOfrecidaOp10);

                    listaDeTodasLasAcciones.addAccion(newDemo);
                    opcion4(listaDeTodasLasAcciones, filtroStringOp10);
                    break;

                case 11:// COMPROBADA
                    opcion11(listaDeTodasLasAcciones);
                    break;

                case 12:// COMPROBADA
                    opcion12(listaDeTodasLasAsociaciones, listaDeTodosLosMiembros);
                    break;

                case 13:// COMPROBADA
                    System.out.println("Se mostraran todas las charlas que tengan más de X número de asistentes.");
                    System.out.println("Introduce el número. Introduce de nuevo:");
                    int numeroAsistentes = 0;
                    boolean formatoCorrectoOp13 = false;
                    do {
                        formatoCorrectoOp13 = false;
                        do {
                            try {
                                numeroAsistentes = Integer.parseInt(introducirPorTeclado.nextLine());
                                formatoCorrectoOp13 = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Valor inválido, introduce otro valor:");
                            }
                        } while (!formatoCorrectoOp13);

                        if (numeroAsistentes < 0) {
                            System.out.println("Valor incorrecto, el valor debe ser positivo. Introduce de nuevo:");
                        } else {
                            opcion13(listaDeTodasLasAcciones, numeroAsistentes);
                        }
                    } while (numeroAsistentes < 0);

                    break;

                case 14:// COMPROBADA
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
                                            System.out.println("Valor incorrecto, introduce de nuevo:");
                                        }
                                    } while (!formatoCorrectoOp14);

                                    if (valoracionOp14 < 1 || valoracionOp14 > 10) {
                                        System.out.println("Introduce un valor válido [1 - 10]. Introduce de nuevo:");
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
                    String aliasPersonaOp16;
                    do {
                        System.out.println("Introduce el nombre de la persona");
                        aliasPersonaOp16 = introducirPorTeclado.nextLine();
                        if (listaDeTodosLosMiembros.miembroExistente(aliasPersonaOp16) == -1) {
                            System.out.println("Este miembro no existe. Introduce de nuevo:");
                        }
                    } while (listaDeTodosLosMiembros.miembroExistente(aliasPersonaOp16) == -1);
                    opcion16(listaDeTodasLasAcciones, listaDeTodosLosMiembros, aliasPersonaOp16);

                    break;

                case 17:
                    System.out.println("Estas son las demostraciones no activas que hay:\n");
                    Demostracion auxOp17 = null;
                    for (int iop17 = 0; iop17 < listaDeTodasLasAcciones.getNumeroAcciones(); iop17++) {
                        if (listaDeTodasLasAcciones.getAccionEnXIndice(iop17) instanceof Demostracion) {
                            auxOp17 = (Demostracion) listaDeTodasLasAcciones.getAccionEnXIndice(iop17);
                            if (!auxOp17.getEstado()) {
                                System.out.println("La demostración con indice " + (iop17 + 1) + " es:\n"
                                        + listaDeTodasLasAcciones.getAccionEnXIndice(iop17).toString() + "\n");
                            }

                        }
                    }
                    opcion17(listaDeTodasLasAcciones);
                    System.out.println(
                            "Demostraciones después de elimianar las no activas realizadas antes de la fecha \n");
                    for (int iop17 = 0; iop17 < listaDeTodasLasAcciones.getNumeroAcciones(); iop17++) {
                        if (listaDeTodasLasAcciones.getAccionEnXIndice(iop17) instanceof Demostracion) {
                            auxOp17 = (Demostracion) listaDeTodasLasAcciones.getAccionEnXIndice(iop17);
                            if (!auxOp17.getEstado()) {
                                System.out.println("La demostración con indice " + (iop17 + 1) + " es:\n"
                                        + listaDeTodasLasAcciones.getAccionEnXIndice(iop17).toString() + "\n");
                            }

                        }
                    }

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

        boolean asociacionEncontradaVis1 = false;
        int indiceVis1 = 0;
        while (!asociacionEncontradaVis1 && indiceVis1 < todasAsoc.getIndiceAsociaciones()) {
            if (todasAsoc.getElementoListaAsociacion(indiceVis1).getNombreAsociacion()
                    .equals(nombreAsociacion)) {
                asociacionEncontradaVis1 = true;
            } else {
                indiceVis1++;
            }
        }
        String[] listaTitulacionesRecalculadaVis1 = listaTodosMiembros.titulacionesEnBaseAListaMiembros(
                todasAsoc.getElementoListaAsociacion(indiceVis1).getListaMiembrosAsociacion());
        todasAsoc.getElementoListaAsociacion(indiceVis1)
                .setterTitulaciones(listaTitulacionesRecalculadaVis1);
        return existe;
    }

    public static void opcion8vis2(Miembro miembro, String nombreAsociacion, ListaAsociaciones listaTodasAsociaciones,
            ListaMiembros listaTodosMiembros, Fecha fechaAlta) {
        listaTodosMiembros.addMiembro(miembro);

        listaTodasAsociaciones.addMiembroEnAsociacionExistente(miembro.getAlias(), nombreAsociacion,
                listaTodasAsociaciones, fechaAlta);

        boolean asociacionEncontradaVis2 = false;
        int indiceVis2 = 0;
        while (!asociacionEncontradaVis2 && indiceVis2 < listaTodasAsociaciones.getIndiceAsociaciones()) {
            if (listaTodasAsociaciones.getElementoListaAsociacion(indiceVis2).getNombreAsociacion()
                    .equals(nombreAsociacion)) {
                asociacionEncontradaVis2 = true;
            } else {
                indiceVis2++;
            }
        }
        String[] listaTitulacionesRecalculadaVis2 = listaTodosMiembros.titulacionesEnBaseAListaMiembros(
                listaTodasAsociaciones.getElementoListaAsociacion(indiceVis2).getListaMiembrosAsociacion());
        listaTodasAsociaciones.getElementoListaAsociacion(indiceVis2)
                .setterTitulaciones(listaTitulacionesRecalculadaVis2);

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
        int diaLim = 0, mesLim = 0, yearLim = 0;
        boolean entradaCorrectaOp17;
        do {
            entradaCorrectaOp17 = false;
            System.out.println("Dia Limite: [1 - 31]");
            do {
                try {
                    diaLim = Integer.parseInt(introducirPorTeclado.nextLine());
                    entradaCorrectaOp17 = true;
                } catch (NumberFormatException e) {
                    System.out.println("La entrada es incorrecta, debe ser un número. Introduce de nuevo:");
                }
            } while (!entradaCorrectaOp17);
            if (diaLim < 1 || diaLim > 31) {
                System.out.println("Rango de día incorrecto. Introduce de nuevo:");
            }
        } while (diaLim < 1 || diaLim > 31);

        do {
            entradaCorrectaOp17 = false;
            System.out.println("Mes Limite: [1 - 12]");
            do {
                try {
                    mesLim = Integer.parseInt(introducirPorTeclado.nextLine());
                    entradaCorrectaOp17 = true;
                } catch (NumberFormatException e) {
                    System.out.println("La entrada es incorrecta, debe ser un número. Introduce de nuevo:");
                }
            } while (!entradaCorrectaOp17);
            if (mesLim < 1 || mesLim > 12) {
                System.out.println("El rango del mes es incorrecto. Introduce de nuevo:");
            }
        } while (mesLim < 1 || mesLim > 12);

        do {
            entradaCorrectaOp17 = false;
            System.out.println("Año Limite: [1991 - 2025]");
            do {
                try {
                    yearLim = Integer.parseInt(introducirPorTeclado.nextLine());
                    entradaCorrectaOp17 = true;
                } catch (NumberFormatException e) {
                    System.out.println("La entrada es incorrecta, debe ser un número. Introduce de nuevo:");
                }
            } while (!entradaCorrectaOp17);
            if (yearLim < 1991 || yearLim > 2025) {
                System.out.println("Rango del año incorrecto. Introduce de nuevo:");
            }
        } while (yearLim < 1991 || yearLim > 2025);

        Fecha fechaLimite = new Fecha(diaLim, mesLim, yearLim);

        listaDeTodasLasAcciones.eliminarDemostracionPorFechaYNoActivas(fechaLimite);

    }

    public static void opcion18(ListaAcciones listaDeTodasLasAcciones, ListaAsociaciones listaDeTodasLasAsociaciones,
            ListaMiembros listaDeTodosLosMiembros) {

        String respuesta = "";
        boolean respuestaValida = false;
        do {
            System.out.println("Deseas guardar la información en los ficheros antes de salir? s/n");
            respuesta = introducirPorTeclado.nextLine();
            if (respuesta.equals("s") || respuesta.equals("n")) {
                respuestaValida = true;
            } else {
                System.out.println("Lo que has escrito no es una opción.");
            }
        } while (!respuestaValida);
        if (respuesta.equalsIgnoreCase("s")) {
            EscribirEnFichero.guardarArchivoAcciones(listaDeTodasLasAcciones, "Acciones.txt");
            // EscribirEnFichero.guardarListaAsociacionTexto(listaDeTodasLasAsociaciones,
            // "Asociaciones.txt");
            EscribirEnFichero.guardarListaArchivoMiembros(listaDeTodosLosMiembros, "Miembros.txt");
            EscribirEnFichero.EscribirListaAsociacionesBin(
                    "src/main/java/prac3/Fichero/AsociacionesSerializadas.bin",
                    listaDeTodasLasAsociaciones);
            System.out.println("Datos guardados en archivos correctamente.\n");
        } else {
            System.out.println("Los datos no se han guardado.\n");
        }
    }

}
