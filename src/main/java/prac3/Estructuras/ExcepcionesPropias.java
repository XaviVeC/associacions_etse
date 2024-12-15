package prac3.Estructuras;

public class ExcepcionesPropias {

    public static class ValoracionFueraDeRangoException extends Exception {
        public ValoracionFueraDeRangoException(String message) {
            super(message);
        }
    }

    public static class AsociacionNoEncontradaException extends Exception {
        public AsociacionNoEncontradaException (String mensajeError){
            super(mensajeError);
        }
    }

    public static class CharlaNoEncotradaException extends Exception {
        public CharlaNoEncotradaException (String mensajeError){
            super(mensajeError);
        }
    }

}
