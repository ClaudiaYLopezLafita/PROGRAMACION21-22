package com.company.EX_EmpresaFara;

import java.util.Arrays;

public class CamionCaja extends Vehiculo implements Comparable<CamionCaja>{
    private Caja[] cajas;

    public CamionCaja(String matricula, Double cargaMaxima, Conductor conductor) {
        super(matricula, cargaMaxima, conductor);
    }

    @Override
    public void descargar() {
        int numCajas = cajas.length;
        int numPrendas = 0;

        for (int i = 0; i < cajas.length; i++) {
            numPrendas = +cajas[i].getPrendas().length;
        }

        System.out.println("Descargando "+numCajas+" cajas y "+numPrendas+" prendas");

        cajas = new Caja[0];

    }

    public Caja[] getCajas() {
        return cajas;
    }

    public void setCajas(Caja[] cajas) {
        this.cajas = cajas;
    }

    public boolean addCaja(Caja caja){

        if (!estaCaja(caja)) {
            Caja[] resultado = Arrays.copyOf(cajas, cajas.length+1);
            resultado[resultado.length-1]=caja;
            cajas = resultado;
            return true;
        }
        return false;
    }

    public boolean removeCaja(Caja caja){

        if (estaCaja(caja)) {
            Caja[] resultado = new Caja[0];
            for (int i = 0; i < cajas.length; i++) {
                if (!cajas[i].equals(caja) ) { // comparamos que sean iguales o no
                    resultado = Arrays.copyOf(resultado, resultado.length + 1);
                    resultado[resultado.length-1] = cajas[i];
                }
            }
            cajas = resultado;
            return true;
        }
        return false;
    }

    private boolean estaCaja (Caja caja){

        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i].equals(caja)){
                return true;
            }
        }
        return false;
    }

    public double getCarga() {
        double result = 0;
        for (int i = 0; i < cajas.length; i++) {
            result += cajas[i].getPeso();
        }
        return result;
    }



    @Override
    public String toString() {
        return  super.toString() +
                ", cajas=" + Arrays.toString(cajas) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CamionCaja that = (CamionCaja) o;
        return Arrays.equals(cajas, that.cajas);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(cajas);
        return result;
    }

    @Override
    public int compareTo(CamionCaja o) {
        return this.getCajas().length - o.getCajas().length;
    }
}
