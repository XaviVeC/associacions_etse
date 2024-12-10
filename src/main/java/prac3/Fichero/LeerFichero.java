package prac3.Fichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import prac3.Accion.Demostracion;
import prac3.Accion.Charla;
import prac3.Asociacion.Asociacion;
import prac3.Estructuras.Fecha;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;
import prac3.Estructuras.ListaMiembros;
import prac3.Miembro.Alumno;
import prac3.Miembro.Profesor;

public class LeerFichero {


    /**
     * Metodo que lee los datos del fichero de acciones y lo guarda en una lista
     * @param nombreFichero - Nombre del fichero que contiene los datos de las acciones
     * @param nombreListaAcciones - Nombre de la lista donde guardamos las acciones
     * @param cantidadDeAcciones - Cantidad de acciones a leer
     */
    public static void LeerFicheroAcciones(String nombreFichero, ListaAcciones nombreListaAcciones,
            int cantidadDeAcciones) {

        try (BufferedReader lectura = new BufferedReader(new FileReader(nombreFichero))) {
            String informacionUnaAccion;
            String[] campos, campoFecha, camposAsociacionesInvolucradas;
            int indiceLectura = 0;
            Fecha auxiliarFecha;

            do {
                informacionUnaAccion = lectura.readLine();
                campos = informacionUnaAccion.split(";");
                campoFecha = campos[5].split("-");
                auxiliarFecha = new Fecha(Integer.parseInt(campoFecha[0]), Integer.parseInt(campoFecha[1]),
                        Integer.parseInt(campoFecha[2]));
                camposAsociacionesInvolucradas = campos[3].split("-");
                switch (campos[1]) {
                    case "Demostracion":
                        Demostracion demostracion = new Demostracion(Integer.parseInt(campos[0]), campos[1], campos[2],
                                camposAsociacionesInvolucradas, campos[4], auxiliarFecha, Integer.parseInt(campos[6]),
                                Boolean.parseBoolean(campos[7]), Integer.parseInt(campos[8].trim()));
                        nombreListaAcciones.addAccion(demostracion);
                        break;
                    case "Charla":
                        String[] intructoresCharla = campos[6].split("-");
                        String[] valoraciones = campos[7].split("-");
                        int[] valoracionesEnEntero = new int[valoraciones.length];
                        for (int i = 0; i < valoracionesEnEntero.length; i++) {
                            valoracionesEnEntero[i] = Integer.parseInt(valoraciones[i]);
                        }
                        Charla charla = new Charla(Integer.parseInt(campos[0]), campos[1], campos[2],
                                camposAsociacionesInvolucradas, campos[4], auxiliarFecha, intructoresCharla,
                                valoracionesEnEntero, Integer.parseInt(campos[8]));
                        nombreListaAcciones.addAccion(charla);
                        break;
                }
                indiceLectura++;
            } while (indiceLectura < cantidadDeAcciones);

            lectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero actividades no se ha encontrado" + e.toString());
        } catch (IOException ex) {
            System.err.println("Error en la lectura " + ex.toString());
        }
    }

    /**
     * Metodo para leer los datos del fichero miembros y guardarlos en una lista
     * 
     * @param nombreFichero    - nombre del fichero que contiene a los miembros
     * @param listaMiembros    - nombre de la lista donde queremos guardar los
     *                         miembros
     * @param cantidadMiembros - cantidad de miembros que vamos a leer
     */
    public static void LeerFicheroMiembros(String nombreFichero, ListaMiembros nombreListaMiembros,
            int cantidadMiembros) {
        try (BufferedReader lectura = new BufferedReader(new FileReader(nombreFichero))) {

            String informacionUnMiembro;
            String[] campo, campoFecha;
            Fecha fechaAlta;
            int indiceLectura = 0;
            Alumno alumno;
            Profesor profesor;
            do {
                informacionUnMiembro = lectura.readLine();
                campo = informacionUnMiembro.split(";");
                campoFecha = campo[4].split("-");

                fechaAlta = new Fecha(Integer.parseInt(campoFecha[0]), Integer.parseInt(campoFecha[1]),
                        Integer.parseInt(campoFecha[2]));

                campoFecha = campo[5].split("-");

                switch (campo[1]) {
                    case "Alumne":
                        alumno = new Alumno(Integer.parseInt(campo[0]), campo[1], campo[2], fechaAlta,
                        Integer.parseInt(campo[6]), Boolean.parseBoolean(campo[7]), campo[8].trim());

                        nombreListaMiembros.addMiembro(alumno);
                        break;
                    case "Professor":
                        profesor = new Profesor(Integer.parseInt(campo[0]), campo[1], campo[2], fechaAlta,
                        campo[6], Integer.parseInt(campo[7].trim()));
                        nombreListaMiembros.addMiembro(profesor);
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

    /**
     * Metodo para leer las asociaciones que hay guardadas dentro del fichero
     * 
     * @param nombreFichero        - Nombre del fichero que contiene las
     *                             asociaciones
     * @param listaARellenar       - Nombre de la lista donde almacenaremos las
     *                             distintas asociaciones
     * @param cantidadAsociaciones - Cantidad de asociaciones que debemos leer
     */
    public static void LeerFicheroAsociaciones(String nombreFichero, ListaAsociaciones listaARellenar,
            int cantidadAsociaciones) {

        try (BufferedReader lectura = new BufferedReader(new FileReader(nombreFichero))) {

            String informacionUnaAsociacion;
            String[] campo, campoTitulaciones, campoIntegrantes, campoCargos;
            int indiceLectura = 0;
            Asociacion asociacion;

            do {
                informacionUnaAsociacion = lectura.readLine();
                campo = informacionUnaAsociacion.split(";");
                campoTitulaciones = campo[2].split("-");
                campoIntegrantes = campo[3].split("-");
                campoCargos = campo[4].split("-");

                asociacion = new Asociacion(campo[0], campoTitulaciones, campoIntegrantes, campoCargos);

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

    /**
     * Metodo para contar las entidades de un fichero
     * 
     * @param nombreFichero - Nombre del fichero del cual queremos contar las
     *                      entidades
     * @return - Total de entidads dentro de un fichero
     */
    public static int ContarEntidadesFichero(String nombreFichero) {
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
