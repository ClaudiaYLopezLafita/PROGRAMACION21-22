package com.company.T2_Figura;

public class Cuadrado extends PoligonoRegular implements Figura{

    public Cuadrado(Color color, Double lado) {
        super(color, lado);
    }

    public Cuadrado() {
        this(Color.AZUL,10.0);
    }

    @Override
    public String toString() {
        return "Rectangulo{}"+
                super.toString();
    }

    @Override
    public Double getArea() {
        Double area = lado*lado;

        return area;
    }
}
