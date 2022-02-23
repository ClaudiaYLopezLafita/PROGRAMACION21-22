package com.company.Vehiculos;

import java.util.Comparator;

public class ComparadorYear implements Comparator<Terrestre> {

    @Override
    public int compare(Terrestre t1, Terrestre t2) {
        return t1.getAnioFabricacion()-t2.getAnioFabricacion();
    }
}
