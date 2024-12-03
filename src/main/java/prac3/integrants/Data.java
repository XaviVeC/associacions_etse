package prac3.integrants;

public class Data {
    
    private int dia;
    private int mes;
    private int any;

    /**
     * Metodo constructor de la clase Data
     * Se ha comprobado que los datos introducidos por parametro tengan sentido, es decir esten 
     * dentro de los intervalos reales de una fecha, no puede haber un dia mayor de 31 por ejemplo.
     * Para reflejar ese error lo que se ha hecho ha sido poner la fecha con todo 9 para que asi se vea 
     * bien la diferencia respecto las que esten correctas.
     * @param dia - variable que tiene el dia
     * @param mes - variable que contiene el mes
     * @param any - variable que contiene el año
     * @return - constructor Data
     */
    public Data (int dia, int mes, int any){
        if (diaValido(dia) && mesValido(mes) && anyValido(any)){
            this.dia = dia;
            this.mes = mes;
            this.any = any;
        }
        else{
            this.dia = 99;
            this.mes = 99;
            this.any = 9999;
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
     * Getter de la variable any
     * @return - variable any
     */
    public int getAny(){
        return any;
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
     * Setter de la variable any
     * @param any - variable any
     */
    public void setAny(int any){
        if (anyValido(any)) {
            this.any = any;
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
     * Metodo que comprueba que el año este entre 1900 y 2030
     * @param dia - variable año
     * @return - true = esValida, false = no esValida
     */
    public boolean anyValido(int any){
        boolean esValido = true;
        if ((any > 2030) || (any < 1900)){
            esValido = false;
        }
        return esValido;
    }
}