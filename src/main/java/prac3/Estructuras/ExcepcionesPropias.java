package prac3.Estructuras;

public class ExcepcionesPropias {
    
    // Al buscar una asociación no aparece.
    public static class AsociacionNoEncontradaException extends Exception {
        public AsociacionNoEncontradaException(String mensajeError) {
            super(mensajeError);
        }
    }

    // Cuando al buscar una charla no aparece.
    public static class CharlaNoEncotradaException extends Exception {
        public CharlaNoEncotradaException(String mensajeError) {
            super(mensajeError);
        }
    }

    // Esta salta cuando un miembro ya se encuentra en tres asociaciones
    public static class MiembroEnTresAsociaciones extends Exception {
        public MiembroEnTresAsociaciones(String mensajeError) {
            super(mensajeError);
        }
    }

}
