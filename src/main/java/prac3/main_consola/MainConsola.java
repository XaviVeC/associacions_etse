package prac3.Main_Consola;

public class MainConsola {
    public static void main(String[] args) {
        mostraMenu();
        /**
         * --------------------------------------------------MENU--------------------------------------------
         * 
         * 1. Mostrar lista Asociaciones. DONE
         * 
         * 2. Mostrar lista Miembros de una asociacion concreta, con filtro para
         * profes/alumnos/los dos. DONE
         * 
         * 3. Mostrar lista Miembros activos de cualquier asociacion, con filtro para
         * profes/alumnos/los dos. DONE
         * 
         * 4. Mostrar lista Acciones con filtro para tipo de accion o no. DONE
         * 
         * 5. Obtener y Mostrar lista de Acciones de una asociacion en concreto. DONE
         * 
         * 6. Obtener y Mostrar lista de Xerrades que se hacen en una franja de fechas
         * que nos pasan por teclado.
         * EXCEPCION EN LAS FECHAS!!!!! DONE
         * 
         * 7. Add nueva Asociacion. DANI FALTA COMPROBAR
         * 
         * 8. Alta de un miembro a una asociacion. Si es nuevo se introduce toda la
         * informacion de ese miembro.
         * Si ya esta en otra asociacion se hace la relacion correspondiente.
         * 
         * 9. Add nueva Xerrada. 
         * 
         * 10. Add nueva Demostracion.
         * 
         * 11. Consultar y mostrar las Demostraciones que se consideran no-activas y
         * calcular el coste economico de prepararlas.
         * 
         * 12. Calcular la persona que participa en mas asociaciones (RECORDAR QUE COMO
         * MAXIMO 3).
         * Si hay empate la que lleva mas tiempo en alguna de ellas. Si hay empate tmb,
         * qualquiera de las empatadas. DANI
         * 
         * 13. Consultar y mostrar la Xerrada que ha tenido mas de X asistentes.
         * 
         * 14. Valorar la Xerrada por parte de un asistente.
         * 
         * 15. Consultar la Xerrada con mejor valoracion (mitjana mas alta). En caso de
         * empate, la que tenga mas valoraciones.
         * Si hay empate tmb, cualquiera de las empatadas.
         * 
         * 16. Mostrar los datos de las Xerrades que hace una persona en concreto.
         * 
         * 17. Dar de baja las Demostraciones que no esten activas y que se diseniaron
         * antes de X fecha.
         * 
         * 18. Salir del programa
         */

    }

    public static void mostraMenu() {
        System.out.println("1. Mostrar los datos de la lista de asociaciones.");
        System.out.println("2. Mostrar los datos de la lista de miembros que forman parte de una asociación, añadiendo un filtro para profesores, alumnos o ambos.");
        System.out.println("3. Mostrar los datos de la lista de miembros activos, que forman parte de cualquier asociación, añadiendo un filtro para profesores, alumnos o ambos.");
        System.out.println("4. Mostrar los datos de la lista de acciones, añadiendo un filtro o no por tipo de acción.");
        System.out.println("5. Obtener y mostrar la lista de acciones que ofrece una asociación concreta.");
        System.out.println("6. Obtener y mostrar la lista de las charlas que se realizan en un rango de fechas indicado por teclado.");
        System.out.println("7. Añadir una nueva asociación.");
        System.out.println("8. Alta de un miembro en una asociación. Puede darse el caso de que el miembro sea nuevo, y se deberá introducir toda la información del miembro, o que el miembro ya participe en otra asociación, en cuyo caso se deberá añadir la relación correspondiente.");
        System.out.println("9. Añadir una nueva charla");
        System.out.println("10. Añadir una nueva demostración");
        System.out.println("11.  Consultar y mostrar los datos de las demostraciones que se consideran no activas. Calcular el costo económico total que supuso preparar todas estas demostraciones.");
        System.out.println("12.  Calcular la persona más activa, es decir, la que participa en más asociaciones. En caso de empate, se considera la que tiene más antigüedad (en cualquier asociación). Si aún hay empate, se escoge a cualquiera de las personas que cumplen con los requisitos.");
        System.out.println("13. Consultar y mostrar los datos de las charlas que han tenido más de un cierto número indicado de asistentes.");
        System.out.println("14. Valorar una charla por parte de un asistente.");
        System.out.println("15. Consultar y mostrar la charla que está mejor valorada (que será la que tiene el promedio de valoraciones más alto). En caso de empate en la nota, se considera la que ha tenido más valoraciones, y en caso de empate se toma cualquiera.");
        System.out.println("16. Mostrar los datos de las charlas que hará una persona concreta.");
        System.out.println("17. Dar de baja las demostraciones que no estén activas y que fueron diseñadas antes de una cierta fecha.");
        System.out.println("18. Salir de la aplicación.");





    }
}
