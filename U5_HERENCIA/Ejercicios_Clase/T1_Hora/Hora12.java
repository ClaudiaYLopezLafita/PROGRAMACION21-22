package com.company.T1_Hora;
/*
*  Escribir la clase Hora12, que funciona de forma similar a la clase Hora, con la diferencia de que
* las horas solo pueden tomar un valor entre 1 y 12; y se distingue la mañana de la tarde mediante "am"
* y "pm".
* */

public class Hora12 extends Hora{

    MomentoDia momento;

    public Hora12(int hora, int minutos, MomentoDia momento) {
        super(hora, minutos);
        this.momento = momento;
    }

    @Override
    public void setHora(int hora) {
        if (hora>0 && hora<=12) {
            super.setHora(hora);
        } else {
            super.setHora(0);
        }
    }

    @Override
    public void inc() {
        super.inc();
        if (getHora()>12){
            setHora(1);
            momento = momento == MomentoDia.AM ? MomentoDia.PM : MomentoDia.AM;
        }
    }

    @Override
    public String toString() {
        String result;
        result = super.toString();
        result += " "+momento;
        return result;
    }
}
