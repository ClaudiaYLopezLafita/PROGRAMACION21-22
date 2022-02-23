package com.company.T1_Instrumento;

public class Campana extends Instrumento{

    @Override
    public void interpretar() {
        System.out.println("Soy una campana: ");
        for (Nota n : this.getNota()) {
            System.out.print(n);
        }
    }
}
