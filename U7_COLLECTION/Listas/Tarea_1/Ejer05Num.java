package com.company.Listas.Tarea1;

import java.util.Comparator;

public class Ejer05Num implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return (Integer) o2 - (Integer) o1;
    }
}
