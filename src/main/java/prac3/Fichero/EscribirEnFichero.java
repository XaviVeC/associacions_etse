package prac3.Fichero;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import prac3.Accion.Accion;
import prac3.Accion.Charla;
import prac3.Accion.Demostracion;
import prac3.Asociacion.Asociacion;
import prac3.Estructuras.Fecha;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;
import prac3.Estructuras.ListaMiembros;
import prac3.Miembro.Alumno;
import prac3.Miembro.Miembro;
import prac3.Miembro.Profesor;

public class EscribirEnFichero {

    /**
     * Método para guardar una lista de asociaciones en un fichero de tipo texto 
     * @param listaAsociaciones - lista de las asociaciones 
     * @param nombreArchivo - nombre del archivo de texto 
     */
    public static void guardarListaAsociacionTexto(ListaAsociaciones listaAsociaciones, String nombreArchivo) {
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < listaAsociaciones.getIndiceAsociaciones(); i++) {
                Asociacion asociacion = listaAsociaciones.getElementoListaAsociacion(i);
                escritura.write(asociacion.getNombreAsociacion() + ";" +
                        unirLista(asociacion.getTitulacionesAsociacion(), "/") + ";" +
                        unirLista(asociacion.getListaMiembrosAsociacion(), "-") + ";" +
                        unirFecha(asociacion.getFechasAlta(), "/") + ";" +
                        unirFecha(asociacion.getFechasBaja(), "/") + ";" +
                        unirLista(asociacion.getPersonasEnCargo(), "-"));

                escritura.write("\n");

            }
            escritura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para guardar una lista de miembros en un fichero de tipo texto 
     * @param listaMiembros - lista de los miembros 
     * @param nombreArchivo - nombre del archivo de texto 
     */

    public static void guardarListaArchivoMiembros(ListaMiembros listaMiembros, String nombreArchivo) {
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < listaMiembros.getNumeroMembres(); i++) {
                Miembro miembro = listaMiembros.getMiembroEnXIndice(i);
                String tipoMiembro = "";
                if (miembro instanceof Alumno) {
                    tipoMiembro = "Alumno";
                } else if (miembro instanceof Profesor) {
                    tipoMiembro = "Profesor";
                }

                escritura.write(miembro.getIndiceFichero() + ";" +
                        tipoMiembro + ";" +
                        miembro.getAlias());

                if (miembro instanceof Alumno) {
                    Alumno alumno = (Alumno) miembro;
                    escritura.write(";" + alumno.getYearsEtse() + ";" +
                            alumno.getGraduado() + ";" +
                            alumno.getSiglasCarrera());
                } else if (miembro instanceof Profesor) {
                    Profesor profesor = (Profesor) miembro;
                    escritura.write(";" + profesor.getDepartamento() + ";" +
                            profesor.getNumeroDespacho());
                }
                escritura.write("\n");

            }
            escritura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para guardar una lista de acciones en un fichero de tipo texto 
     * @param listaAcciones - lista de las acciones 
     * @param nombreArchivo - nombre del archivo de texto 
     */
    public static void guardarArchivoAcciones(ListaAcciones listaAcciones, String nombreArchivo) {
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < listaAcciones.getNumeroAcciones(); i++) {
                Accion accion = listaAcciones.getAccionEnXIndice(i);

                String tipoAccion = "";
                if (accion instanceof Charla) {
                    tipoAccion = "Charla";
                } else if (accion instanceof Demostracion) {
                    tipoAccion = "Demostracion";
                }

                escritura.write(accion.getIndiceFichero() + ";" +
                        tipoAccion + ";" +
                        accion.getNombreAccion() + ";" +
                        unirLista(accion.getAsociacionesInvolucradas(), "-") + ";" +
                        accion.getOrganizadorResponsable());
                ;

                if (accion instanceof Charla) {
                    Charla charla = (Charla) accion;
                    escritura.write(";" + charla.getFecha() + ";" +
                            unirLista(charla.getInstructoresCharla(), "-") + ";" +
                            unirVector(charla.getValoraciones(), "-") + ";" +
                            charla.getNumeroAsistentes() + ";" +
                            charla.getIndiceValoraciones());

                } else if (accion instanceof Demostracion) {
                    Demostracion demostracion = (Demostracion) accion;
                    escritura.write(";" + demostracion.getFecha() + ";" +
                            demostracion.getCoste() + ";" +
                            demostracion.getEstado() + ";" +
                            demostracion.getVecesOfrecida() + ";");

                }
                escritura.write("\n");
            }
            escritura.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para unir una tabla de Strings
     * @param lista - lista de Strings 
     * @param delimitador - delimitador con el que separamos los elementos de la lista 
     * @return
     */

    private static String unirLista(String[] lista, String delimitador) {
        String resultado = "";
        for (int i = 0; i < lista.length; i++) {
            resultado += lista[i];
            if (i < lista.length - 1) {
                resultado += delimitador; // Agregar el delimitador excepto al final.
            }
        }
        return resultado;
    }

    /**
     * Método para unir un vector  de enteros 
     * @param vEnteros - vector de enteros 
     * @param delimitador - delimitador con el que separamos los elementos de la lista 
     * @return 
     */
    private static String unirVector(int[] vEnteros, String delimitador) {
        String resultado = "";
        for (int i = 0; i < vEnteros.length; i++) {
            resultado += vEnteros[i];
            if (i < vEnteros.length - 1) {
                resultado += delimitador; // Agregar el delimitador excepto al final.
            }
        }
        return resultado;
    }

    /**
     * Método para unir una tabla de tipo fecha
     * @param vFecha - fecha 
     * @param delimitador - delimitador con el que separamos los elementos de la lista 
     * @return
     */
    private static String unirFecha(Fecha[] vFecha, String delimitador) {
        String resultado = "";
        for (int i = 0; i < vFecha.length; i++) {
            resultado += vFecha[i];
            if (i < vFecha.length - 1) {
                resultado += delimitador;
            }
        }
        return resultado;

    }

    /**
     * Metodo que genera un fichero serializado en formato binario (.bin).
     * 
     * @param nombreFichero     - Nombre del fichero binario.
     * @param listaAsociaciones - Lista de las asociaciones.
     */
    public static void EscribirListaAsociacionesBin(String nombreFichero, ListaAsociaciones listaAsociaciones) {
        try (DataOutputStream escribirSerializado = new DataOutputStream(new FileOutputStream(nombreFichero, false))) {
            // Iterar sobre cada asociación en la lista
            for (int i = 0; i < listaAsociaciones.getIndiceAsociaciones(); i++) {
                // Escribir el nombre de la asociación
                escribirSerializado.writeUTF(listaAsociaciones.getElementoListaAsociacion(i).getNombreAsociacion());

                // Escribir las titulaciones
                String[] titulaciones = listaAsociaciones.getElementoListaAsociacion(i).getTitulacionesAsociacion();
                escribirSerializado.writeInt(titulaciones.length); // Número de titulaciones
                for (int ii = 0; ii < titulaciones.length; ii++) {
                    escribirSerializado.writeUTF(titulaciones[ii]);
                }

                // Escribir los integrantes
                String[] integrantes = listaAsociaciones.getElementoListaAsociacion(i).getListaMiembrosAsociacion();
                escribirSerializado.writeInt(integrantes.length); // Número de integrantes
                for (int ii = 0; ii < integrantes.length; ii++) {
                    escribirSerializado.writeUTF(integrantes[ii]);
                }

                // Escribir las fechas de alta
                Fecha[] altas = listaAsociaciones.getElementoListaAsociacion(i).getFechasAlta();
                escribirSerializado.writeInt(altas.length); // Número de fechas de alta
                for (int ii = 0; ii < altas.length; ii++) {
                    escribirSerializado.writeInt(altas[ii].getDia());
                    escribirSerializado.writeInt(altas[ii].getMes());
                    escribirSerializado.writeInt(altas[ii].getYear());
                }

                // Escribir las fechas de baja
                Fecha[] bajas = listaAsociaciones.getElementoListaAsociacion(i).getFechasBaja();
                escribirSerializado.writeInt(bajas.length); // Número de fechas de baja
                for (int ii = 0; ii < bajas.length; ii++) {
                    escribirSerializado.writeInt(bajas[ii].getDia());
                    escribirSerializado.writeInt(bajas[ii].getMes());
                    escribirSerializado.writeInt(bajas[ii].getYear());
                }

                // Escribir los cargos
                String[] cargos = listaAsociaciones.getElementoListaAsociacion(i).getPersonasEnCargo();
                escribirSerializado.writeInt(cargos.length); // Número de cargos
                for (int ii = 0; ii < cargos.length; ii++) {
                    escribirSerializado.writeUTF(cargos[ii]);
                }
            }
            escribirSerializado.close();
        } catch (IOException e) {
            System.err.println("Error al escribir la lista de asociaciones: " + e.getMessage());
        }
    }



    
}