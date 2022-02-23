package com.company.EX_Piezas;

public class PiezaDamas extends PiezaTablero {

    public PiezaDamas(Integer posicionX, Integer posicionY, Color color) {
        super(posicionX, posicionY, color);
    }

    public void moverpieza(int px, int py){

        if (estaDentro(px,py)){

        }

    }

    public static boolean estaDentro(int i, int j) {
        return (i>=0 && i<=7 && j>=0 && j<=7);
    }

}
