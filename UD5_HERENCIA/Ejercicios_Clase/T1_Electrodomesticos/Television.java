package com.company.T1_Electrodomesticos;

public class Television extends Electrodomesticos {
    private Integer pulgadas;
    private boolean tdt;

    public Television(float precioBase, Color color, ConsumoEnergetico consumo,
                      float peso, Integer pulgadas, boolean tdt) {
        super(precioBase, color, consumo, peso);
        this.pulgadas = pulgadas;
        this.tdt = tdt;
    }

    public Television() {
        this(100, Color.BLANCO,ConsumoEnergetico.F,5,20,false);
    }

    public Television(float precioBase, float peso) {
        this(precioBase, Color.BLANCO,ConsumoEnergetico.F,peso,20,false);
    }

    public Integer getPulgadas() {
        return pulgadas;
    }

    public boolean isTdt() {
        return tdt;
    }

    @Override
    public String toString() {
        return "Television{" +
                "precioBase=" + precioBase +
                ", color=" + color +
                ", consumo=" + consumo +
                ", peso=" + peso +
                ", pulgadas=" + pulgadas +
                ", tdt=" + tdt +
                ", precioFinal="+ getPrecioFinal() +
                "} \n";
    }

    @Override
    public float getPrecioFinal() {
        float plusPulgadas=0;
        float plusTdT = 0;

        if (pulgadas>40){
            plusPulgadas = (float) (precioBase+(precioBase*0.3));
        }

        if (tdt==true){
            plusPulgadas = precioBase+50;
        }

        return super.getPrecioFinal()+plusPulgadas+plusTdT;
    }


}
