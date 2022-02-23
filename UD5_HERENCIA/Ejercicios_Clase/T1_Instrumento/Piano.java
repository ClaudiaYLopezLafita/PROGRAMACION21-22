package com.company.T1_Instrumento;

public class Piano extends Instrumento {

    @Override
    public void interpretar() {
        System.out.println("Soy un piano: ");
        for (Nota n : this.getNota()) {
            System.out.print(n);
        }
    }
}
