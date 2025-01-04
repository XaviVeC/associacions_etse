package prac3.Fichero;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
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
     * 
     * @param nombreFichero       - Nombre del fichero que contiene los datos de las
     *                            acciones
     * @param nombreListaAcciones - Nombre de la lista donde guardamos las acciones
     * @param cantidadDeAcciones  - Cantidad de acciones a leer
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
                        Demostracion demostracion = new Demostracion(Integer.parseInt(campos[0]), campos[2],
                                camposAsociacionesInvolucradas, campos[4], auxiliarFecha, Double.parseDouble(campos[6]),
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
                        Charla charla = new Charla(Integer.parseInt(campos[0]), campos[2],
                                camposAsociacionesInvolucradas, campos[4], auxiliarFecha, intructoresCharla,
                                valoracionesEnEntero, Integer.parseInt(campos[8]), Integer.parseInt(campos[9].trim()));

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
            String[] campo;
            int indiceLectura = 0;
            Alumno alumno;
            Profesor profesor;
            do {
                informacionUnMiembro = lectura.readLine();
                campo = informacionUnMiembro.split(";");

                switch (campo[1]) {
                    case "Alumno":
                        alumno = new Alumno(Integer.parseInt(campo[0]), campo[1], campo[2],
                                Integer.parseInt(campo[3]), Boolean.parseBoolean(campo[4]), campo[5].trim());

                        nombreListaMiembros.addMiembro(alumno);
                        break;
                    case "Profesor":
                        profesor = new Profesor(Integer.parseInt(campo[0]), campo[1], campo[2],
                                campo[3], Integer.parseInt(campo[4].trim()));

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

    /**
     * Metodo para leer las asociaciones que estan dentro del fichero binario
     * 
     * @param nombreFichero     - direccion del fichero
     * @param listaAsociaciones - lista donde se guardan
     */
    public static void LeerListaAsociacionesBin(String nombreFichero, ListaAsociaciones listaAsociaciones)
            throws IOException {
        try (DataInputStream leerSerializado = new DataInputStream(new FileInputStream(nombreFichero))) {
            // Leer mientras haya asociaciones en el fichero
            while (leerSerializado.available() > 0) {
                // Leer el nombre de la asociación
                String nombre = leerSerializado.readUTF();

                // Leer las titulaciones
                int numTitulaciones = leerSerializado.readInt();
                String[] titulaciones = new String[numTitulaciones];
                for (int i = 0; i < numTitulaciones; i++) {
                    titulaciones[i] = leerSerializado.readUTF();
                }

                // Leer los integrantes
                int numIntegrantes = leerSerializado.readInt();
                String[] integrantes = new String[numIntegrantes];
                for (int i = 0; i < numIntegrantes; i++) {
                    integrantes[i] = leerSerializado.readUTF();
                }

                // Leer las fechas de alta
                int numFechasAlta = leerSerializado.readInt();
                Fecha[] altas = new Fecha[numFechasAlta];
                for (int i = 0; i < numFechasAlta; i++) {
                    int dia = leerSerializado.readInt();
                    int mes = leerSerializado.readInt();
                    int anio = leerSerializado.readInt();
                    altas[i] = new Fecha(dia, mes, anio);
                }

                // Leer las fechas de baja
                int numFechasBaja = leerSerializado.readInt();
                Fecha[] bajas = new Fecha[numFechasBaja];
                for (int i = 0; i < numFechasBaja; i++) {
                    int dia = leerSerializado.readInt();
                    int mes = leerSerializado.readInt();
                    int anio = leerSerializado.readInt();
                    bajas[i] = new Fecha(dia, mes, anio);
                }

                // Leer los cargos
                int numCargos = leerSerializado.readInt();
                String[] cargos = new String[numCargos];
                for (int i = 0; i < numCargos; i++) {
                    cargos[i] = leerSerializado.readUTF();
                }

                // Crear la nueva Asociación y agregarla a la lista
                Asociacion asociacion = new Asociacion(nombre, titulaciones, integrantes, cargos, altas, bajas);
                listaAsociaciones.addAsociacion(asociacion);
            }
            leerSerializado.close();
        } catch (EOFException e) {
            System.out.println("Lectura completa...");
        } catch (IOException e) {
            System.err.println("Error al leer las asociaciones: " + e.getMessage());
        }
    }

}
