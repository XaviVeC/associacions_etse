package prac3.Fichero;
import java.io.BufferedWriter;
import java.io.FileWriter;

import prac3.Asociacion.Asociacion;
import prac3.Accion.Accion;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;
import prac3.Estructuras.ListaMiembros;
import prac3.Accion.Demostracion;
import prac3.Accion.Charla;
import java.io.IOException;


public class EscribirEnFichero{

    public static void guardarListaAsociacionTexto(ListaAsociaciones listaAsociaciones, String nombreArchivo){
        try(BufferedWriter escritura = new BufferedWriter(new FileWriter(nombreArchivo))){
            for (int i = 0; i < listaAsociaciones.getIndiceAsociaciones(); i++ ){
                Asociacion asociacion = listaAsociaciones.getElementoListaAsociacion(i);
                escritura.write(asociacion.getNombreAsociacion()+ ";"+
                                asociacion.getCorreoContactoAsociacion() + ";" +
                                asociacion.getTitulacionesAsociacion() +";"+
                                asociacion.getListaMiembrosAsociacion() + ";" +
                                asociacion.getPersonasEnCargo());

            }
        }catch(IOException e) {
            e.printStackTrace();}
    }

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
                Demostracion Demostracion = (Demostracion) accion ;
                escritura.write(";" + demostracion.)

            }
        }
        
        }
    }
}