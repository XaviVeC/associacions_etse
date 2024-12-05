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
        try(BufferedReader f = new BufferedReader(new FileReader (nombreFichero))){
            
            String frase = "";
            int indiceFichero, numeroDespacho, yearsEtse;
            String tipoMiembro, nombreMiembro, alias, correoMiembro, departamento, curso;
            boolean graduado;
            Data fechaAlta;
            Data fechaBaja;
            
            frase = f.readLine();
            while (frase != null) {

                StringTokenizer st = new StringTokenizer(frase,";");
                indiceFichero = Integer.parseInt(st.nextToken());
                tipoMiembro = st.nextToken();
                nombreMiembro = st.nextToken();
                alias = st.nextToken();
                correoMiembro = st.nextToken();
                //fechaAlta = - falta mirar como leerlo 
                //fechaBaja = -falta mirar como leerlo 

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
                frase = f.readLine();
            }
            f.close();
        }catch(FileNotFoundException e){
             System.out.println("el fichero actividades no se ha encontrado" + e.toString());
        }catch(IOException ex){
            System.err.println("Error en la lectura " + ex.toString());
        }
    }

    public void LeerFicheroAsociaciones(String nombreFichero, LlistaAssociacions listaAso, LlistaMembres listaM){
        try(BufferedReader f = new BufferedReader(new FileReader(nombreFichero))){
            String frase = "";
            String nombreAsociacion, correoContactoAsociacion;
            String[] titulacionesAsociacion;
            Membre[] listaMiembrosAsociacion, personasEnCargos;

            frase = f.readLine();
            while (frase != null){
                StringTokenizer st = new StringTokenizer(frase,";");
                StringTokenizer st2 = new StringTokenizer(frase,"/");
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
