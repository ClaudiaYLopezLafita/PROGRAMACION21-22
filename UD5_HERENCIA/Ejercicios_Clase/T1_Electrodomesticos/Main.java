package com.company.T1_Electrodomesticos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Electrodomesticos[] Elec = new Electrodomesticos[10];

        Lavadora l1 = new Lavadora(400, Color.AZUL, ConsumoEnergetico.C,30,10);
        Lavadora l2 = new Lavadora();
        Lavadora l3 = new Lavadora(200, 30);
        Lavadora l4 = new Lavadora(150, Color.ROJO, ConsumoEnergetico.A,80,30);
        Lavadora l5 = new Lavadora(300, Color.NEGRO, ConsumoEnergetico.D,20,20);

        Television t1 = new Television(300,Color.NEGRO, ConsumoEnergetico.C, 20, 40, false);
        Television t2 = new Television();
        Television t3 = new Television(500,25);
        Television t4 = new Television(250,Color.ROJO, ConsumoEnergetico.B, 50, 60, true);
        Television t5 = new Television(300,Color.GRIS, ConsumoEnergetico.A, 30, 25, true);

        Elec[0]=l1;
        Elec[1]=t1;
        Elec[2]=t5;
        Elec[3]=l2;
        Elec[4]=t2;
        Elec[5]=t3;
        Elec[6]=l3;
        Elec[7]=l4;
        Elec[8]=l5;
        Elec[9]=t4;

        //System.out.println(Arrays.toString(Elec));

        Lavadora[] lav = {l1,l2,l3,l4,l5};
        System.out.println(Arrays.toString(lav));
        /*Arrays.sort(lav);
        System.out.println();
        System.out.println(Arrays.toString(lav));*/

        Arrays.sort(lav, new Comparator<Lavadora>() {

            @Override
            public int compare(Lavadora o1, Lavadora o2) {
                return (int) (o1.getPrecioFinal()-o2.getPrecioFinal());
            }
        });

        System.out.println(Arrays.toString(lav));

    }
}
