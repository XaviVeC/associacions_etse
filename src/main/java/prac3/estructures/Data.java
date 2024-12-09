package prac3.estructures;

public class Data {
    
    private int dia;
    private int mes;
    private int anio;

    /**
     * Metodo constructor de la clase Data
     * Se ha comprobado que los datos introducidos por parametro tengan sentido, es decir esten 
     * dentro de los intervalos reales de una fecha, no puede haber un dia mayor de 31 por ejemplo.
     * Para reflejar ese error lo que se ha hecho ha sido poner la fecha con todo 9 para que asi se vea 
     * bien la diferencia respecto las que esten correctas.
     * @param dia - variable que tiene el dia
     * @param mes - variable que contiene el mes
     * @param anio - variable que contiene el anio
     * @return - constructor Data
     */
    public Data (int dia, int mes, int anio){
        if (diaValido(dia) && mesValido(mes) && anioValido(anio)){
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        }
        else{
            this.dia = 99;
            this.mes = 99;
            this.anio = 9999;
        }
    }

    /**
     * Getter de la variable dia
     * @return - variable dia
     */
    public int getDia(){
        return dia;
    }

    /**
     * Getter de la variable mes
     * @return - variable mes
     */
    public int getMes(){
        return mes;
    }

    /**
     * Getter de la variable anio
     * @return - variable anio
     */
    public int getAnio(){
        return anio;
    }

    /**
     * Setter de la variable dia
     * @param dia - variable dia
     */
    public void setDia(int dia){
        if (diaValido(dia)) {
            this.dia = dia;
        }
    }

    /**
     * Setter de la variable mes
     * @param mes - variable mes
     */
    public void setMes(int mes){
        if (mesValido(mes)) {
            this.mes = mes;
        }
    }

    /**
     * Setter de la variable anio
     * @param anio - variable anio
     */
    public void setanio(int anio){
        if (anioValido(anio)) {
            this.anio = anio;
        }
    }

    /**
     * Metodo que comprueba que el dia este entre 1 y 31
     * @param dia - variable dia
     * @return - true = esValida, false = no esValida
     */
    public boolean diaValido(int dia){
        boolean esValido = true;
        if ((dia > 31) || (dia < 1)){
            esValido = false;
        }
        return esValido;
    }

    /**
     * Metodo que comprueba que el mes este entre 1 y 12
     * @param mes - variable mes
     * @return - true = esValida, false = no esValida
     */
    public boolean mesValido(int mes){
        boolean esValido = true;
        if ((mes > 12) || (mes < 1)){
            esValido = false;
        }
        return esValido;
    }

    /**
     * Metodo que comprueba que el anio este entre 1900 y 2030
     * @param dia - variable anio
     * @return - true = esValida, false = no esValida
     */
    public boolean anioValido(int anio){
        boolean esValido = true;
        if ((anio > 2030) || (anio < 1)){
            esValido = false;
        }
        return esValido;
    }

    /**
     * Metodo String que imprime la fecha
     * @return - Fecha completa
     */
    public String toString (){
        return(+this.getDia()+ "/" +this.getMes()+ "/" +this.getAnio());

    }

    /**
     * Metodo que copia una fecha en concreto 
     * @return - variable fechita
     */
    public Data copia(){
        Data fechita = new Data(dia, mes, anio);
        return fechita;
    } 
}