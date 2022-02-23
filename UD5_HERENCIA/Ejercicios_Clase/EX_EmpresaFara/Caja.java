package com.company.EX_EmpresaFara;

import java.util.Arrays;
import java.util.Objects;

public class Caja {

    private String id;
    private static final int MAX_PRENDAS =5;
    private Prenda[] prendas;

    public Caja(String id) {
        this.id = id;
        this.prendas = new Prenda[0];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Prenda[] getPrendas() {
        return prendas;
    }

    public void setPrendas(Prenda[] prendas) {
        this.prendas = prendas;
    }

    public boolean addPrenda(Prenda prenda){

        if (prendas.length<MAX_PRENDAS) {
            Prenda[] resultado = Arrays.copyOf(prendas, prendas.length+1);
            resultado[resultado.length-1]=prenda;
            prendas = resultado;
            return true;
        }
        return false;
    }

    public boolean removePrenda(Prenda prenda){
        // en una caja puede haber mas de una prensa identica, solo quitamos una las demas las dejamos
        boolean eliminada = false;

        if (estaPrenda(prenda)) {
            Prenda[] resultado = new Prenda[0];
            for (int i = 0; i < prendas.length; i++) {
                if (!prendas[i].equals(prenda) || eliminada){ // comparamos que sean iguales o no
                    resultado = Arrays.copyOf(resultado,resultado.length+1);
                    resultado[resultado.length-1] = prendas[i];
                }else {
                    eliminada = true;
                }
            }
            prendas = resultado;
            return true;
        }
        return false;
    }

    private boolean estaPrenda (Prenda prenda){

        for (int i = 0; i < prendas.length; i++) {
            if (prendas[i].equals(prenda)){
                return true;
            }
        }
        return false;
    }

    public double getPeso() {
        // recoremos el array de prendas y vamos sumando el peso de cada prenda
        double result = 0;
        for (int i = 0; i < prendas.length; i++) {
            result += prendas[i].getPeso();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "id='" + id + '\'' +
                ", prendas=" + Arrays.toString(prendas) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caja caja = (Caja) o;
        return id.equals(caja.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
