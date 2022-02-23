package com.company.T2_Figura;

import java.util.Objects;

public abstract class PoligonoRegular {

    public Color color;
    Double lado;
    private static Integer contadorPoligono =0;

    public PoligonoRegular(Color color, Double lado) {
        this.color = color;
        this.lado = lado;
        PoligonoRegular.contadorPoligono++;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    public Integer getContadorPoligono(){
        return contadorPoligono;
    }

    @Override
    public String toString() {
        return "PoligonoRegular{" +
                "color=" + color +
                ", lado=" + lado +
                ", cantidad poligonos=" + contadorPoligono
                ;
    }

}
