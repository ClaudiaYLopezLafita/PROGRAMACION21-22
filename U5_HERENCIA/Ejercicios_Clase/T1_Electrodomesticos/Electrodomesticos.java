package com.company.T1_Electrodomesticos;

public class Electrodomesticos {

    float precioBase;
    Color color;
    ConsumoEnergetico consumo;
    float peso;

    public Electrodomesticos(float precioBase, Color color, ConsumoEnergetico consumo, float peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public Electrodomesticos(float precioBase,  float peso) {
        this(precioBase, Color.BLANCO, ConsumoEnergetico.F, peso);
    }

    public Electrodomesticos() {
        this(100, Color.BLANCO, ConsumoEnergetico.F, 5);
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public Color getColor() {
        return color;
    }

    public ConsumoEnergetico getConsumo() {
        return consumo;
    }

    public float getPeso() {
        return peso;
    }

    public float getPrecioFinal(){

        float precioFinal = 0;
        float plusConsumo =0;
        float plusPeso =0;

        switch (consumo){
            case A -> {
                plusConsumo = 100;
                break;
            }
            case B -> {
                plusConsumo=80;
                break;
            }
            case C -> {
                plusConsumo=60;
                break;
            }
            case D -> {
                plusConsumo=50;
                break;
            }
            case E -> {
                plusConsumo=30;
                break;
            }
            case F -> {
                plusConsumo=10;
                break;
            }
        }

        if (peso >0 && peso<=29){
            plusPeso = 10;
        } else if (peso >30 && peso<=49){
            plusPeso = 60;
        } else if (peso>50 && peso<=79){
            plusPeso = 80;
        } else if (peso>=80){
            plusPeso = 100;
        }

        precioFinal = precioBase+plusConsumo+plusPeso;

        return precioFinal;

    }

    @Override
    public String toString() {
        return "Electrodomesticos{" +
                "precioBase=" + precioBase +
                ", color=" + color +
                ", consumo=" + consumo +
                ", peso=" + peso+
                ", PrecioFInal="+getPrecioFinal()
                +'\n';
    }
}
