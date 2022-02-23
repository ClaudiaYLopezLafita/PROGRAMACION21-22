package com.company.T1_Hora;

import java.util.Objects;

public class HoraExacta extends Hora{

    private int segundo;

    public HoraExacta(int hora, int minutos, int segundo) {
        super(hora, minutos);
        this.segundo=segundo;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public boolean ingresarSegundo(int valor){
        if (valor > 60 || valor < 0){
            this.segundo = valor;
            return true;
        }
        return false;
    }

    /**
     * metodo que incrementa un segundo, y se llama al metodo super incremento, el cual se encarga de realiza
     * la comparacion de los minutos y horas e incrementarlos si es necesario.
     */
    @Override
    public void inc() {
        segundo++;
        if (segundo >= 60){
            segundo = 0;
            super.inc();
        }
    }

    @Override
    public String toString() {
        return  super.toString() +
                ":" + segundo +
                '}';
    }

}
