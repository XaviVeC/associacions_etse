package prac3.accions;

import prac3.associacions.Associacio;
import prac3.estructures.LlistaAccions;
import prac3.estructures.LlistaAssociacions;
import prac3.integrants.Professor;
import prac3.estructures.Data;
import java.util.Scanner;

public class UsaAccio {
    public static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        LlistaAccions listaAcciones = new LlistaAccions(3);
        do {
            System.out.println("Elige la que quieres probar.");
            mostraMenu();
            opcion = Integer.parseInt(teclat.nextLine());
            
            switch (opcion) {
                case 1:
                    opcion1(listaAcciones);
                    break;

                case 2:
                    opcion2(listaAcciones);
                    break;

                case 3:
                    opcion3();
                    break;

                case 4:
                    opcion4();
                    break;
            
                default:
                    break;
            }

        } while(opcion != 5);
    }
    
    public static void opcion1(LlistaAccions lista){
        System.out.println("Demostracion --> 0     Charla --> 1");
        int decision = Integer.parseInt(teclat.nextLine());
        Data aux = new Data(1,1,2001);
        if (decision == 0) {
            //indico que esta aniniadiendo una demostracion
            //relleno los datos de la demostracion
            System.out.println("Vas a introducir una demostracion a la lista de acciones.");
            System.out.println("Introduce el nombre de la demostracion.");
            String nombre = teclat.nextLine();
            System.out.println("¿Cuantas asociaciones participan?");
            int cantidad = Integer.parseInt(teclat.nextLine());
            LlistaAssociacions listaAsoc = new LlistaAssociacions(cantidad);
            for(int i = 0; i < cantidad; i++)
            {
                System.out.println("¿Que asociaciones participan?");
                String nombreAsoc = teclat.nextLine();
                Associacio asocAuxiliar = new Associacio(nombreAsoc, null, null, null, null);
                listaAsoc.addAsociacion(asocAuxiliar);
            }
            System.out.println("¿Que miembro es?");
            String nombreResponsable = teclat.nextLine();
            Professor miembroAux = new Professor(nombreResponsable, null, null, aux, aux,null, 0);

            Demostracio demo = new Demostracio(nombre, null, miembroAux, 1, aux, 1000);
            lista.addAccion(demo);
        }
        else
        {
            System.out.println("Vas a introducir una xerrada a la lista de acciones");
            System.out.println("¿Dime el nombre de la xerrada?");
            String nombreAccion = teclat.nextLine();
            System.out.println("Dime el numero de asociaciones que participan.");
            int cantidadAsociaciones = Integer.parseInt(teclat.nextLine());
            LlistaAssociacions listaAsoc = new LlistaAssociacions(cantidadAsociaciones);
            int i = 0;
            do {
                System.out.println("¿Que asociaciones participan?");
                String nombreAsoc = teclat.nextLine();
                Associacio asocAuxiliar = new Associacio(nombreAsoc, null, null, null, null);
                listaAsoc.addAsociacion(asocAuxiliar);
                i++;
            } while (i < cantidadAsociaciones);
           
            
            System.out.println("¿Que miembro es?"); 
            String nombreResponsable = teclat.nextLine();
            Professor miembroAux = new Professor(nombreResponsable, null, null, aux, aux,null, 0);
            
            Xerrada xerra = new Xerrada(nombreAccion, listaAsoc, miembroAux, 12, aux, null, null, 1);
            lista.addAccion(xerra);
        }
        
        
        

        
    }

    public static void opcion2(LlistaAccions lista) {
        System.err.println("¿Que accion quieres comprobar?");
        int indice = Integer.parseInt(teclat.nextLine());
        System.out.println(lista.getAccionEnXIndice(indice).toString());
    }

    public static void opcion3() {
        
    }
    
    public static void opcion4() {
        
    }

    public static void mostraMenu() {
        System.out.println("1. Rellenar lista acciones");
        System.out.println("2. Comprobacion de que imprime bien cualquier accion de la lista");
        System.out.println("3. Comprobacion de copia");
        System.out.println("4. Comprobacion de que se genera bien el numero del codigo");
        System.out.println("5. Salir");  
    }



























    // EXCEPCIONES

    // DATA = NULL -> NullPointerException pq no puede llamar a los getters
}