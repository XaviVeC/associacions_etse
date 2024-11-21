package prac3.main_consola;

public class MainConsola {
    public static void main(String[] args) {
        int a = 0;
        int b = 12;
        
        try{
            int x = b/a;
            System.out.println("Valor X: "+x);
        } catch(ArithmeticException e) {
            System.out.println("No s'ha pogut dividir entre 0");
        }
        
        
    }
}