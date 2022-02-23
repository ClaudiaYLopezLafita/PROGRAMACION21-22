package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Registro {

    private Propiedad[] propiedads;

    public Registro() {
        this.propiedads = new Propiedad[0];
    }

    public Propiedad[] getPropiedads() {
        return propiedads;
    }

    public void setPropiedads(Propiedad[] propiedads) {
        this.propiedads = propiedads;
    }

    public boolean addPropiedad(Propiedad propiedad){
        if (!estaPropiedad(propiedad) ) {
            Propiedad[] resultado = Arrays.copyOf(propiedads, propiedads.length+1);
            resultado[resultado.length-1]=propiedad;
            propiedads = resultado;
            return true;
        }
        return false;

    }

    public boolean eliminarPropiedad(Propiedad propiedad){
        if (estaPropiedad(propiedad)) {
            Propiedad[] result = new Propiedad[0];

            for (int i = 0; i < propiedads.length; i++) {
                if (!propiedads[i].equals(propiedad)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = propiedads[i];
                }
            }
            propiedads = result;
            return true;
        }
        return false;
    }

    public boolean estaPropiedad(Propiedad propiedad){
        for (int i = 0; i < propiedads.length; i++) {
            if (propiedads[i].equals(propiedad)) {
                return true;
            }
        }
        return false;
    }

    public void informeSuperficie(){

        Arrays.sort(propiedads);
        System.out.println(Arrays.toString(propiedads));
    }

    public void informeAntiguedad(){
        Arrays.sort(propiedads, new Comparator<Propiedad>() {
            @Override
            public int compare(Propiedad p1, Propiedad p2) {
                if (p2.getYear().equals(p1.getYear())){
                    return (int) (p2.getSuperficie()-p1.getSuperficie());
                }
                return p2.getYear()-p1.getYear();
            }
        });

        System.out.println(Arrays.toString(propiedads));
    }

    @Override
    public String toString() {
        return "Registro{" +
                "propiedads=" + Arrays.toString(propiedads) +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registro registro = (Registro) o;
        return Arrays.equals(propiedads, registro.propiedads);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(propiedads);
    }
}
