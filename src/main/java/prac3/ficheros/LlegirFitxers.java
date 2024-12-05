package prac3.ficheros;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import prac3.associacions.Associacio;
import prac3.estructures.Data;
import prac3.estructures.LlistaAccions;
import prac3.estructures.LlistaAssociacions;
import prac3.estructures.LlistaMembres;
import prac3.integrants.Alumne;
import prac3.integrants.Membre;
import prac3.integrants.Professor;

public class LlegirFitxers {

    public void LeerficheroMiembros(String nombreFichero, LlistaMembres listaM){
        try(BufferedReader lectura = new BufferedReader(new FileReader (nombreFichero))){
            
            String linia = "";
            int indiceFichero, numeroDespacho, yearsEtse, diaAlta, mesAlta, yearAlta, diaBaja, mesBaja, yearBaja;
            String tipoMiembro, nombreMiembro, alias, correoMiembro, departamento, curso;
            String[] trozos, trozosFechaAlta, trozosFechaBaja;
            boolean graduado;
            Data fechaAlta, fechaBaja;

            linia = lectura.readLine();
            while (linia != null) {

                trozos = linia.split(";");
                indiceFichero = Integer.parseInt(trozos[0]);
                tipoMiembro = trozos[1];
                nombreMiembro = trozos [2];
                alias = trozos [3];
                correoMiembro = trozos[4];

                 
                trozosFechaAlta = trozos[5].split("-");
                diaAlta = Integer.parseInt(trozosFechaAlta[0]);
                mesAlta = Integer.parseInt(trozosFechaAlta[1]);
                yearAlta = Integer.parseInt(trozosFechaAlta[2]);
                fechaAlta = new Data(diaAlta,mesAlta,yearAlta);

                trozosFechaBaja = trozos[6].split("-");
                diaBaja = Integer.parseInt(trozosFechaBaja[0]);
                mesBaja = Integer.parseInt(trozosFechaBaja[1]);
                yearBaja = Integer.parseInt(trozosFechaBaja[2]);
                fechaBaja = new Data (diaBaja,mesBaja,yearBaja);
                


                switch(tipoMiembro){
                    case "Alumno":
                        curso = trozos[7];
                        yearsEtse = Integer.parseInt(trozos[8]);
                        graduado = Boolean.parseBoolean(trozos[9]);
                        Alumne a = new Alumne(indiceFichero, tipoMiembro, nombreMiembro, alias, correoMiembro, fechaAlta, fechaBaja, curso, yearsEtse, graduado);
                        listaM.addmiembro(a);
                        break;
                    case "Profesor":
                        departamento = trozos[7];
                        numeroDespacho = Integer.parseInt(trozos[8]);
                        Professor p = new Professor(indiceFichero, tipoMiembro, nombreMiembro, alias, correoMiembro, fechaAlta, fechaBaja, departamento, numeroDespacho);
                        listaM.addmiembro(p);
                        break;
                }
                linia = lectura.readLine();
            }
            lectura.close();
        }catch(FileNotFoundException e){
             System.out.println("el fichero actividades no se ha encontrado" + e.toString());
        }catch(IOException ex){
            System.err.println("Error en la lectura " + ex.toString());
        }
    }

    public void LeerFicheroAsociaciones(String nombreFichero, LlistaAssociacions listaAso, LlistaMembres listaM){
        try(BufferedReader lectura = new BufferedReader(new FileReader(nombreFichero))){
            String linia = "";
            String nombreAsociacion, correoContactoAsociacion;
            String[] titulacionesAsociacion, trozos;
            Membre[] listaMiembrosAsociacion, personasEnCargos;

            linia = lectura.readLine();
            while (linia != null){
                
                trozos = linia.split(";");
                nombreAsociacion = trozos[0];
                correoContactoAsociacion = trozos[1];
                titulacionesAsociacion = trozos[2].split("/");// Supongo que el contenido de dentro de la lista de Strings esta separado por una barra 
                String[] nombresDeLosMiembros = trozos[3].split(",");
                listaMiembrosAsociacion = new Membre[nombresDeLosMiembros.length];
                String [] nombresCargos = trozos[4].split("/");
                personasEnCargos = new Membre[nombresCargos.length]; 
                
            LlistaMembres miembro = listaM.miembrosDeAsociacionConcreta(nombreAsociacion); //!!!!! NO SE SI ESTA BIEN 

            if(miembro != null){

                Associacio associacio = new Associacio(nombreAsociacion, correoContactoAsociacion, titulacionesAsociacion, listaMiembrosAsociacion, personasEnCargos);
                listaAso.addAsociacion(associacio);
            }
            
            }
            lectura.close();
            }catch(FileNotFoundException e){
                System.out.println("el fichero actividades no se ha encontrado" + e.toString());
            }catch(IOException ex){
               System.err.println("Error en la lectura " + ex.toString());
            }
    }



    

}
