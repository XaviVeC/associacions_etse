package prac3.ficheros;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

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
            int indiceFichero, numeroDespacho, yearsEtse;
            String tipoMiembro, nombreMiembro, alias, correoMiembro, departamento, curso;
            String[] trozos, trozosFechaAlta, trozosFechaBaja;
            boolean graduado;
            Data fechaAlta;
            Data fechaBaja;
            
            linia = lectura.readLine();
            while (linia != null) {

                trozos = linia.split(";");
                indiceFichero = Integer.parseInt(trozos[0]);
                tipoMiembro = trozos[1];
                nombreMiembro = trozos [2];
                alias = trozos [3];
                correoMiembro = trozos[4];
                trozosFechaAlta = trozos[5].split("-");
                trozosFechaBaja = trozos[6].split("-");
                
                
                /*
                 * 
                
                StringTokenizer st = new StringTokenizer(linia,";");
                indiceFichero = Integer.parseInt(st.nextToken());
                tipoMiembro = st.nextToken();
                nombreMiembro = st.nextToken();
                alias = st.nextToken();
                correoMiembro = st.nextToken();
                //fechaAlta = - falta mirar como leerlo 
                //fechaBaja = -falta mirar como leerlo 
                */

                switch(tipoMiembro){
                    case "Alumno":
                        curso = st.nextToken();
                        yearsEtse = Integer.parseInt(st.nextToken());
                        graduado = st.hasMoreTokens();
                        Alumne a = new Alumne(indiceFichero, tipoMiembro, nombreMiembro, alias, correoMiembro,fechaAlta,fechaBaja, curso, yearsEtse, graduado);
                        listaM.addmiembro(a);
                        break;
                    case "Profesor":
                        departamento = st.nextToken();
                        numeroDespacho = Integer.parseInt(st.nextToken());
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
            String[] titulacionesAsociacion;
            Membre[] listaMiembrosAsociacion, personasEnCargos;

            linia = lectura.readLine();
            while (linia != null){
                StringTokenizer st = new StringTokenizer(linia,";");
                StringTokenizer st2 = new StringTokenizer(linia,"/");
                nombreAsociacion = st.nextToken();
                correoContactoAsociacion = st.nextToken();
                //titulacionesAsociacion = falta mirar como leerlo 
                //listaMiembrosAsociacion = falta mirar como leerlo 
                //personasEnCargos = falta mirar como leerlo 
            
            Membre miembro = listaM.miembrosDeAsociacionConcreta(nombreAsociacion);

            if(miembro != null){
                

            }
                


            }


        }

    }

    

}
