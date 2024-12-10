

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
        System.out.println("1. ImprimIr la lista de miembros");
        System.out.println("2. ImprimIr la lista de asociaciones");
        System.out.println("3. ImprimIr la lista de acciones");
        System.out.println("4. Miemros X asociacion");
        System.out.println("5. Miembros activos con filtro");
        System.out.println("6. Acciones con filtro o sin filtro");
        System.out.println("7. Acciones de una asociacion en concreto");
        System.out.println("8. LA TUYA ADRI");
        System.out.println("9. Add nueva asociacion");
        System.out.println("10. Salir");

    }
}
