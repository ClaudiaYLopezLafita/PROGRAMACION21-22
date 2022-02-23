package com.company.T1_Instrumento;

public class Main {
    public static void main(String[] args) {
        Piano p1 = new Piano();

        p1.add(Nota.DO);
        p1.add(Nota.LA);
        p1.add(Nota.SOL);
        p1.add(Nota.MI);
        p1.add(Nota.DO);

        System.out.println(p1);
    }
}
