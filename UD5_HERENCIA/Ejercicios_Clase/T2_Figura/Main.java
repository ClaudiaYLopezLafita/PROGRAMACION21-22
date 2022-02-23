package com.company.T2_Figura;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Circulo c1 =new Circulo(3.0);
        Circulo c2 =new Circulo(6.0);
        Circulo c3 =new Circulo(1.0);
        Circulo c4 =new Circulo(9.0);
        Circulo c5 =new Circulo(5.0);

        Triangulo t1 =new Triangulo(Color.AZUL,3.5,5.2);
        Triangulo t2 =new Triangulo();
        Triangulo t3 =new Triangulo(Color.VERDE, 6.5,8.9);
        Triangulo t4 =new Triangulo(Color.AMARILLO,3.0, 10.5);
        Triangulo t5 =new Triangulo(Color.ROJO,6.0, 1.2);

        Cuadrado cd1 = new Cuadrado(Color.ROJO, 12.4);
        Cuadrado cd2 = new Cuadrado(Color.VERDE, 2.4);
        Cuadrado cd3 = new Cuadrado(Color.AMARILLO, 10.4);
        Cuadrado cd4 = new Cuadrado(Color.AZUL, 11.4);
        Cuadrado cd5 = new Cuadrado();

        Circulo[] cs ={c1, c2, c3, c4, c5};
        Triangulo[] t ={t1, t2, t3, t4,t5};
        Cuadrado[] cd = {cd1,cd2, cd3, cd4, cd5};
        PoligonoRegular[] pr = {t1,cd1,t2,cd2,t3};

        //System.out.println(Arrays.toString(pr));

        System.out.println(Arrays.toString(t));
        Arrays.sort(t, new Comparator<Triangulo>() {
            @Override
            public int compare(Triangulo o1, Triangulo o2) {

                return o1.getColor().compareTo(o2.getColor());

            }
        });

        System.out.println(Arrays.toString(t));
    }
}
