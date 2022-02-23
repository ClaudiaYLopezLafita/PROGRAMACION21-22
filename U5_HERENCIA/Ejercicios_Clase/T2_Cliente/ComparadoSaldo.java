package com.company.T2_Cliente;

import java.util.Comparator;

public class ComparadoSaldo implements Comparator<Cliente> {

    @Override
    public int compare(Cliente o1, Cliente o2) {
        Double resultado= o1.getSaldo()-o2.getSaldo();

        if (resultado>0){
            return 1;
        } else if (resultado<0){
            return -1;
        } else {
            return 0;
        }
    }
}
