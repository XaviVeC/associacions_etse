package prac3.accions;

import prac3.integrants.Membre;
import prac3.integrants.Data;
import prac3.estructures.LlistaAssociacions;

public class Xerrada extends Accio {
    private final int MAXIMO_INSTRUCTORES = 3; // Limite maximo de las personas que imparten la charla
    private Data fechaRealizacion; // Fecha en la que se imparte la charla
    private Membre[] instructoresCharla = new Membre[MAXIMO_INSTRUCTORES]; // Instructores de la charla
    private int[] valoraciones; // Vector de valoraciones de la charla
    private int numeroDeAsistentes; // Numero de personas que asistieron a la charla

    public Xerrada(String nombreAccion, LlistaAssociacions asociacionesInvolucradas, Membre organizadorResponsable, int indiceLista, Data fechaRealizacion, Membre[] instructoresCharla, int[] valoraciones, int numeroDeAsistentes) {
        super(nombreAccion, asociacionesInvolucradas, organizadorResponsable, indiceLista);
        this.fechaRealizacion = fechaRealizacion;
        this.instructoresCharla = instructoresCharla;
        this.valoraciones = valoraciones;
        if (numeroDeAsistentes < 0) {
            this.numeroDeAsistentes = -999;
        }
        else {
            this.numeroDeAsistentes = numeroDeAsistentes;
        }
    }

    public Data getFechaRealizacion() {
        return fechaRealizacion;
    }

    public Membre[] getInstructoresCharla() {
        return instructoresCharla;
    }

    public int[] getValoraciones() {
        return valoraciones;
    }

    public int getNumeroAsistentes() {
        return numeroDeAsistentes;
    }

    public void aniadirValoracion(int valoracion, int indiceAsistente) {
        if (valoraciones.length < this.numeroDeAsistentes) {
            this.valoraciones[indiceAsistente] = valoracion;
        }
    }

    public String toString(){
        return 
    }
}
