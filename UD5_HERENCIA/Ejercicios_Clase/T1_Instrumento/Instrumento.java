package com.company.T1_Instrumento;

import java.util.Arrays;

/*
PARTE 1: Crear la clase Instrumento, que es una clase abstracta que almacena un máximo de 100 notas musicales.
Mientras haya sitio es posible añadir nuevas notas musicales, al final, con el método add().
La clase también dispone del método abstracto interpretar() que en cada subclase que herede de Instrumento,
mostrará por consola las notas musicales según las interprete. Utilizar enumerados para definir las notas
musicales.

PARTE 2:Crear la clase Piano y la clase Campana que heredan de Instrumento.
 */
public abstract class Instrumento {

    private Nota nota[];
    private int capacidad;

    public Instrumento() {
        this.nota = new Nota[0];
        capacidad = 100;
    }

    public Nota[] getNota() {
        return nota;
    }

    public boolean add(Nota n){
        Nota[] result = new Nota[0];
        if (nota.length < capacidad){
            result = Arrays.copyOf(nota, nota.length+1);
            result[result.length-1] = n;

            nota = result;
            return true;
        }

        return false;
    }

    public abstract void interpretar();// la interpretacion de los hijos será diferente en cada uno

}
