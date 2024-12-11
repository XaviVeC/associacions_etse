package prac3.Fichero;
import java.io.BufferedWriter;
import java.io.FileWriter;

import prac3.Asociacion.Asociacion;
import prac3.Accion.Accion;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;
import prac3.Estructuras.ListaMiembros;
import prac3.Miembro.Profesor;
import prac3.Accion.Demostracion;
import prac3.Accion.Charla;
import java.io.IOException;



public class EscribirEnFichero{
    
    /**
     * 
     * @param listaAsociaciones
     * @param nombreArchivo
     */
    public static void guardarListaAsociacionTexto(ListaAsociaciones listaAsociaciones, String nombreArchivo){
        try(BufferedWriter escritura = new BufferedWriter(new FileWriter(nombreArchivo))){
            for (int i = 0; i < listaAsociaciones.getIndiceAsociaciones(); i++ ){
                Asociacion asociacion = listaAsociaciones.getElementoListaAsociacion(i);
                escritura.write(asociacion.getNombreAsociacion()+ ";" +
                                asociacion.getCorreoContactoAsociacion() + ";" +
                                asociacion.getTitulacionesAsociacion() + ";" +
                                asociacion.getListaMiembrosAsociacion() + ";" +
                                asociacion.getPersonasEnCargo());

            }
        }catch(IOException e) {
            e.printStackTrace();}
    }

    /**
     * 
     * @param listaMiembros
     * @param nombreArchivo 
     */

    public static void guardarListaArchivoMiembros(ListaMiembros listaMiembros, String nombreArchivo){
        try(BufferedWriter escritura = new BufferedWriter(new FileWriter(nombreArchivo))){
            for (int i = 0; i < listaMiembros.getNumeroMembres(); i++){
                Miembro miembro = listaMiembros. getMiembroEnXIndice(i);
                String tipoMiembro = "";
                if (miembro instanceof Alumno){
                    tipoMiembro = "Alumno";
                }else if ( miembro instanceof Profesor){
                    tipoMiembro = "Profesor";
                }


            escritura.write(tipoMiembro +";"+
                            miembro.getIndiceFichero()  +";" + 
                            miembro.getTipoMiembro() +";" +
                            miembro.getAlias()+";" +
                            miembro.getCorreoMiembro());


            if ( miembro instanceof Alumno){
                Alumno alumno = (Alumno) miembro;
                escritura.write(";" + alumno.getSiglasCarrera() +";"+
                                    alumno.getYearsEtse() + ";"+
                                    alumno.getGraduado());
            }else if (miembro instanceof Profesor){
                Profesor profesor = (Profesor) miembro;
                escritura.write(";" +profesor.getDepartamento() +";"+
                                    profesor.getNumeroDespacho ());
            }
            escritura.write("\n");

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    

    /**
     * 
     * @param listaAcciones
     * @param nombreArchivo
     */
    public static void guardarArchivoAcciones(ListaAcciones listaAcciones, String nombreArchivo){
       try(BufferedWriter escritura  = new BufferedWriter(new FileWriter(nombreArchivo))){
            for (int i = 0; i < listaAcciones.getNumeroAcciones(); i++ ){
                Accion accion = listaAcciones.getAccionEnXIndice(i);
                String tipoAccion = "";
                if ( accion  instanceof Charla){
                    tipoAccion = "Charla";
                }else if ( accion instanceof Demostracion){
                    tipoAccion = "Demostracion";
                }
            
            escritura.write(tipoAccion + ";" +
                            accion.getCodigoAccion() +";" + 
                            accion.getTipoAccion() + ";" +
                            accion.getNombreAccion() + ";" +
                            accion. getAsociacionesInvolucradas()+";"+
                            accion.getOrganizadorResponsable());

            if ( accion instanceof Charla){
                Charla charla = (Charla) accion ;
                escritura.write(";"+charla.getFechaRealizacion() +";" +
                                    charla.getInstructoresCharla() +";" +
                                    charla.getValoraciones() + ";"+ 
                                    charla. getNumeroAsistentes());
                
            }else if ( accion  instanceof Demostracion) {
                Demostracion demostracion = (Demostracion) accion ;
                escritura.write(";"+ demostracion.getFecha() +";"+ 
                                    demostracion.getEstado() +";"+ 
                                    demostracion.getVecesOfrecida() +";"+
                                    demostracion.getCostoDemostracion());


            }
            escritura.write("\n");
        }
        
        }catch(IOException e){
             e.printStackTrace();
        }
    }
}