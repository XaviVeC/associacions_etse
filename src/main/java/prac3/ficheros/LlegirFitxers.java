package prac3.ficheros;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LlegirFitxers {


    public void LeerficheroEntidad(String nombreFichero, Ll)

    private static String[] leerLineasFichero(int nLinies, String nombreFichero) throws FileNotFoundException {
        if (nLinies < 0)
            nLinies = 0;

        String[] result;
        result = new String[nLinies];
        Scanner f = new Scanner(new File(nombreFichero));

        String capcalera = f.nextLine();
        System.out.println("El format de les dades en cada línia és el següent\n" + capcalera);
        for (int i = 0; i < nLinies; i++) {
            result[i] = f.nextLine();
        }
        f.close();
        return result;
    }

}
