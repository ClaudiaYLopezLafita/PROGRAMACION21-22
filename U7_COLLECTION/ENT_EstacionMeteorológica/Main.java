package com.company.ENT_EstacionMeteorológica;

public class Main {
    public static void main(String[] args) {

        Coordenadas c1 = new Coordenadas(-125648, 124554);
        Coordenadas c3 = new Coordenadas(-2564, 5466);
        Coordenadas c4 = new Coordenadas(-135465, 124554);
        Coordenadas c2 = new Coordenadas(-646132, -124554);

        Medicion m1 = new Medicion(36,78,1);
        Medicion m2 = new Medicion(45,56,6);
        Medicion m3 = new Medicion(26,85,4);
        Medicion m4 = new Medicion(-3,99,10);
        Medicion m5 = new Medicion(10,10,5);
        Medicion m6 = new Medicion(50,0,20);

        EstacionMeteorológica em = new EstacionMeteorológica("mediciones.dat", c2);

        em.addNedicion(m2);
        em.addNedicion(m1);
        em.addNedicion(m3);
//        em.addNedicion(m5);
        em.addNedicion(m6);
        em.addNedicion(m4);

//        em.ordenaHumedadesDes();
//        System.out.println();
//        em.ordenaTemperaturasAsc();
        System.out.println();
        System.out.println(em.buscarMecicion(m5));
//        System.out.println();
        System.out.println(em.presionMaxima());
//        em.guardarFichero("mediciones.dat");
    }
}
