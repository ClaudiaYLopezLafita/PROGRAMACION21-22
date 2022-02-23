package com.company.T2_Figura;

import java.util.Objects;

public class Triangulo extends PoligonoRegular implements Figura, Comparable{

    private Double altura;

    public Triangulo(Color color, Double lado, Double altura) {
        super(color, lado);
        this.altura=altura;
    }

    public Triangulo(){
        this(Color.AZUL, 10.0, 10.0);
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }


    @Override
    public String toString() {
        return "Triangulo{" +
                super.toString()+
                ", altura=" + altura +
                "}\n";
    }

    @Override
    public Double getArea() {
        Double area = (altura*lado)/2;

        return  area;
    }

    @Override
    public int compareTo(Object o) {
        Triangulo t = (Triangulo) o;
        return this.getLado().compareTo(((Triangulo) o).getLado());
    }
}
