package com.company.EX_Piezas;

import java.util.Scanner;

public abstract class PiezaTablero {

    private Integer posicionX;
    private Integer posicionY;
    private Color color;

    public PiezaTablero(Integer posicionX, Integer posicionY, Color color) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.color = color;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public Color getColor() {
        return color;
    }

    public static void tablero( String posicion) {
        Scanner sc = new Scanner(System.in);

        String[][] tablero = new String[8][8];
        Character[] columnas = {'a','b','c','d','e','f','g','h'};

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j]="-";
            }
        }
        int col = obtenerColumna(posicion.charAt(0),columnas);
        int fila = 8 - Integer.parseInt(""+posicion.charAt(1));

        tablero[fila][col] = "X";

    }
    public static int obtenerColumna(Character c,Character[] columnas) {
        for (int i = 0; i < columnas.length; i++) {
            if (columnas[i]==c) {
                return i;
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return "PiezaTablero{" +
                "posicionX=" + posicionX +
                ", posicionY=" + posicionY +
                ", color=" + color +
                '}';
    }
}
