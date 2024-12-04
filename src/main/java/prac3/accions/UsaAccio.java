package prac3.accions;
import prac3.estructures.LlistaAccions;
import java.util.Scanner;

public class UsaAccio {
    public static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        
        do {
            System.out.println("Elige la que quieres probar.\n");
            mostraMenu();
            opcion = Integer.parseInt(teclat.nextLine());
            LlistaAccions listaAcciones = new LlistaAccions(3);
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
        System.out.println("Demostracion --> 0     Charla --> 1\n");
        int decision = Integer.parseInt(teclat.nextLine());

        if (decision == 0) {
            //indico que est
        }
        else
        {
            //constructor
            //añado a lista
            
        }
        
        
        

        
    }

    public static void opcion2(LlistaAccions lista) {
        System.err.println("¿Que accion quieres comprobar?\n");
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
}