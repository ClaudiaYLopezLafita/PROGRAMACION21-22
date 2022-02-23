package com.company.EX_EmpresaFara;

public class Main {
    public static void main(String[] args) {
        Prenda p1 = new Prenda(12.5,"Chaleco","12458963", 10.2);
        Prenda p2 = new Prenda(2.5,"Calcetin","124963", 1.2);
        Prenda p3 = new Prenda(12.5,"Pantalon","58963", 11.2);
        PrendaColgada pc1 = new PrendaColgada(14.5, "Blusa","12458",15.2, 0.6);

        Caja c1 = new Caja("bks1245");

        c1.addPrenda(p1);
        c1.addPrenda(p3);
        c1.addPrenda(p2);
        c1.addPrenda(pc1);

        System.out.println(c1);
        c1.removePrenda(p1);

        System.out.println(c1);
    }
}
