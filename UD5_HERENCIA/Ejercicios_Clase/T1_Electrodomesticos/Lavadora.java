package com.company.T1_Electrodomesticos;

import java.util.Comparator;

public class Lavadora extends Electrodomesticos implements Comparable{

    private int carga;

    public Lavadora(float precioBase, Color color, ConsumoEnergetico consumo, float peso, int carga) {
        super(precioBase, color, consumo, peso);
        this.carga = carga;
    }

    public Lavadora() {
       this(100,Color.BLANCO,ConsumoEnergetico.F,5,5);
    }

    public Lavadora(float precioBase, float peso) {
        super(precioBase, Color.BLANCO, ConsumoEnergetico.F,peso);
        this.carga = 5;
    }

    public Lavadora(int carga) {
        super(100, Color.BLANCO, ConsumoEnergetico.F,5);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    @Override
    public float getPrecioFinal() {
        float plusCarga=0;

        if (carga > 30){
            plusCarga = 50;
        } else {
            plusCarga =0;
        }

        return super.getPrecioFinal()+plusCarga;
    }

    @Override
    public String toString() {
        return "Lavadora{" +
                "precioBase=" + precioBase +
                ", color=" + color +
                ", consumo=" + consumo +
                ", peso=" + peso +
                ", carga=" + carga +
                ", precioFinal="+ getPrecioFinal()+
                "} \n";
    }

    /**
     * Metodo compareTo que nos permite ver cual es mayor o menor en relacion a ala carga
     * y permite despues ordenarlo
     * @param o objeto lavadora a comprar
     * @return dependiendo de la diferencia de carga devulvera, un valor positivo, nevativo o 0.
     */
    @Override
    public int compareTo(Object o) {
        Lavadora l = (Lavadora) o;
        return this.carga-l.carga;
    }

}
