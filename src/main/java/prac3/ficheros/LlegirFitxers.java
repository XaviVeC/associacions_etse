package prac3.ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import prac3.associacions.Associacio;
import prac3.estructures.Data;
import prac3.estructures.LlistaAssociacions;
import prac3.estructures.LlistaMembres;
import prac3.integrants.Alumne;
import prac3.integrants.Professor;

public class LlegirFitxers {

    public static void leerficheroMiembros(String nombreFichero, LlistaMembres listaMiembros, int cantidadMiembros) {
        try (BufferedReader lectura = new BufferedReader(new FileReader(nombreFichero))) {

            String informacionUnMiembro;
            String[] campo, campoFecha;
            Data fechaAlta, fechaBaja;
            int indiceLectura = 0;

            do {
                informacionUnMiembro = lectura.readLine();
                campo = informacionUnMiembro.split(";");
                campoFecha = campo[5].split("-");

                fechaAlta = new Data(Integer.parseInt(campoFecha[0]), Integer.parseInt(campoFecha[1]),
                        Integer.parseInt(campoFecha[2]));

                campoFecha = campo[6].split("-");
                fechaBaja = new Data(Integer.parseInt(campoFecha[0]), Integer.parseInt(campoFecha[1]),
                        Integer.parseInt(campoFecha[2]));

                switch (campo[1]) {
                    case "Alumne":
                        Alumne alumno = new Alumne(Integer.parseInt(campo[0]), campo[1], campo[2], campo[3], campo[4],
                                fechaAlta, fechaBaja, campo[7], Integer.parseInt(campo[8]),
                                Boolean.parseBoolean(campo[9]));
                        listaMiembros.addmiembro(alumno);
                        break;
                    case "Professor":
                        Professor profesor = new Professor(Integer.parseInt(campo[0]), campo[1], campo[2], campo[3],
                                campo[4],
                                fechaAlta, fechaBaja, campo[7], Integer.parseInt(campo[8].trim()));
                        listaMiembros.addmiembro(profesor);
                        break;
                }
                indiceLectura++;
            } while (indiceLectura < cantidadMiembros);

            lectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero actividades no se ha encontrado" + e.toString());
        } catch (IOException ex) {
            System.err.println("Error en la lectura " + ex.toString());
        }
    }


    public static void leerFicheroAsociaciones(String nombreFichero, LlistaAssociacions listaARellenar,
            int cantidadAsociaciones) {

        try (BufferedReader lectura = new BufferedReader(new FileReader(nombreFichero))) {

            String informacionUnaAsociacion;
            String[] campo, campoTitulaciones, campoIntegrantes, campoCargos;
            int indiceLectura = 0;
            Associacio asociacion;

            do {
                informacionUnaAsociacion = lectura.readLine();
                campo = informacionUnaAsociacion.split(";");
                campoTitulaciones = campo[2].split("-");
                campoIntegrantes = campo[3].split("-");
                campoCargos = campo[4].split("-");

                asociacion = new Associacio(campo[0], campo[1], campoTitulaciones, campoIntegrantes, campoCargos);

                listaARellenar.addAsociacion(asociacion);
                indiceLectura++;
            } while (indiceLectura < cantidadAsociaciones);

            lectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero actividades no se ha encontrado" + e.toString());
        } catch (IOException ex) {
            System.err.println("Error en la lectura " + ex.toString());
        }
    }

    public static int contarEntidadesFichero(String nombreFichero) {
        int contador = 0;

        try (BufferedReader lectura = new BufferedReader(new FileReader(nombreFichero))) {
            String informacionUnaEntidad;

            // Leer línea por línea
            while ((informacionUnaEntidad = lectura.readLine()) != null) {
                // Comprobar si la línea contiene información relevante
                if (!informacionUnaEntidad.isBlank()) {
                    contador++;
                }
            }
            lectura.close();
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }

        return contador;
    }

}
