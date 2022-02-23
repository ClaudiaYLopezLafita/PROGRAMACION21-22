package com.company.T1_Hora;
/*Diseñar la clase Hora que representa un instante de tiempo compuesto por una hora (de 0 a 23)
y los minutos.
 -  Dispone del constructor:
 Hora (hora,minuto), que construye un objeto con los datos pasados como parámetro

- y de los métodos:

 inc(), que incrementa la hora en un minuto
 setMinutos(valor), que da valor a los minutos, siempre y cuando sea un valor con sentido
 setHora(valor),que da valor a la hora, siempre y cuando sea un valor con sentido
 toString(), que devuelve un String con la representación del reloj.*/

import java.util.Objects;

public class Hora {

    private int hora;
    private int minutos;

    public Hora(int hora, int minutos) {
        if (hora < 0 || hora >23){
            this.hora = 0;
        } else {
            this.hora = hora;
        }

        if (minutos < 0 || minutos > 59){
            this.minutos = 0;
        } else {
            this.minutos = minutos;
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora <0 || hora>23){
            this.hora = 0;
        }else {
            this.hora = hora;
        }
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {

        if (hora<0 || hora>23) {
            this.minutos = 0;
        }else {
            this.minutos = minutos;
        }
    }

    public void inc(){

        if (minutos <= 59){
            minutos++;
            if (minutos>59){
                minutos = 0;
                hora++;
                if (hora>23){
                    hora = 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "{Hora -->  " +
                hora + ":" +
                + minutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hora hora1 = (Hora) o;
        return hora == hora1.hora;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hora);
    }
}
