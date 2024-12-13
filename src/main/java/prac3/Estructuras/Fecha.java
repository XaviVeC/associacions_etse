package prac3.Estructuras;

public class Fecha {
    private int dia;
    private int mes;
    private int year;

    /**
     * Metodo constructor de la clase Data
     * Se ha comprobado que los datos introducidos por parametro tengan sentido
     * Para reflejar ese error lo que se ha hecho ha sido poner la fecha con todo 9 para que asi se vea
     * @param dia  - variable que tiene el dia
     * @param mes  - variable que contiene el mes
     * @param year - variable que contiene el year
     */
    public Fecha(int dia, int mes, int year) {
        if (diaValido(dia) && mesValido(mes) && yearValido(year)) {
            this.dia = dia;
            this.mes = mes;
            this.year = year;
        } else {
            this.dia = 99;
            this.mes = 99;
            this.year = 9999;
        }
    }

    /**
     * Getter de la variable dia
     * @return - variable dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Getter de la variable mes
     * @return - variable mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Getter de la variable year
     * @return - variable year
     */
    public int getyear() {
        return year;
    }

    /**
     * Setter de la variable dia
     * @param dia - variable dia
     */
    public void setDia(int dia) {
        if (diaValido(dia)) {
            this.dia = dia;
        }
    }

    /**
     * Setter de la variable mes
     * @param mes - variable mes
     */
    public void setMes(int mes) {
        if (mesValido(mes)) {
            this.mes = mes;
        }
    }

    /**
     * Setter de la variable year
     * @param year - variable year
     */
    public void setyear(int year) {
        if (yearValido(year)) {
            this.year = year;
        }
    }

    /**
     * Metodo que comprueba que el dia este entre 1 y 31
     * @param dia - variable dia
     * @return - true = esValida; false = no esValida
     */
    public boolean diaValido(int dia) {
        boolean esValido = true;
        
        if ((dia > 31) || (dia < 1)) {
            esValido = false;
        }
        
        return esValido;
    }

    /**
     * Metodo que comprueba que el mes este entre 1 y 12
     * @param mes - variable mes
     * @return - true = esValida; false = no esValida
     */
    public boolean mesValido(int mes) {
        boolean esValido = true;
        
        if ((mes > 12) || (mes < 1)) {
            esValido = false;
        
        }
        return esValido;
    }

    /**
     * Metodo que comprueba que el year este entre 1900 y 2030
     * @param dia - variable year
     * @return - true = esValida; false = no esValida
     */
    public boolean yearValido(int year) {
        boolean esValido = true;
        if ((year > 2030) || (year < 1)) {
            esValido = false;
        }
        return esValido;
    }

    /**
     * Metodo String que imprime la fecha
     * @return - Fecha completa
     */
    public String toString() {
        return (+this.getDia() + "/" + this.getMes() + "/" + this.getyear());
    }

    /**
     * Metodo que copia una fecha en concreto
     * @return - variable fechita
     */
    public Fecha copia() {
        return (new Fecha(dia, mes, year));
    }

    /**
     * Metodo que compara dos fechas
     * @param otraFecha la otra fecha con la que comparamos la fecha desde quese ejecuta esta funcion
     * @return retorna un codigo que
     *         - 0 -> si la fecha desde que se ejecuta es menor a otraFecha
     *         - 1 -> si son iguales
     *         - 2 -> si la fecha desde que se ejecuta es mayor a la otraFecha
     */
    public int compararFechas(Fecha otraFecha) {
        int codigoResultado;

        if (this.year > otraFecha.year) {
            codigoResultado = 2;
        } else {
            if (this.year < otraFecha.year) {
                codigoResultado = 0;
            } else {
                if (this.mes > otraFecha.mes) {
                    codigoResultado = 2;
                } else {
                    if (this.mes < otraFecha.mes) {
                        codigoResultado = 0;
                    } else {
                        if (this.dia > otraFecha.dia) {
                            codigoResultado = 2;
                        } else {
                            if (this.dia < otraFecha.dia) {
                                codigoResultado = 0;
                            } else {
                                codigoResultado = 1;
                            }
                        }
                    }
                }
            }
        }

        return codigoResultado;
    }
}