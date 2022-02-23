package com.company.T1_Hora;

public class Main {
    public static void main(String[] args) {
        Hora h1 = new Hora(5,26);
        Hora h2 = new Hora(5,59);
        Hora h3 = new Hora(23,59);
       // System.out.println(h3);

        h3.inc();
        //System.out.println(h3);

        Hora12 h12 = new Hora12(12,10, MomentoDia.AM);
        //System.out.println(h12);
        for (int i = 1; i < 61; i++) {
            h12.inc();
        }
       // System.out.println(h12);

        HoraExacta he1 = new HoraExacta(12,59,59);
        System.out.println(he1);
        he1.inc();
        System.out.println(he1);
    }
}
