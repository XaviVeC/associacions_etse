package prac3.accions;

import prac3.integrants.Membre;
import prac3.integrants.Data;
import prac3.estructures.LlistaAssociacions;

public class Xerrada extends Accio {
    private Data fechaRealizacion; // Fecha en la que se creo el disenio de la demostracion
    private Membre[] instructoresCharla; 

    public Xerrada(String nombreDemostracion, LlistaAssociacions asociacionesInvolucradas, Membre organizadorResponsable, int indiceLista, Data fechaRealizacion, Membre[] instructoresCharla) {
        super(nombreDemostracion, asociacionesInvolucradas, organizadorResponsable, indiceLista);
        this.fechaRealizacion = fechaRealizacion;
        this.instructoresCharla = instructoresCharla;
    }

}
