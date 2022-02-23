package com.company.EX_EmpresaFara;

import java.util.Arrays;

public class CamionPercha extends Vehiculo implements Comparable<CamionPercha>{
    private PrendaColgada[] prendaColgadas;

    public CamionPercha(String matricula, Double cargaMaxima, Conductor conductor) {
        super(matricula, cargaMaxima, conductor);
        this.prendaColgadas= new PrendaColgada[0];
    }

    @Override
    public void descargar() {
        System.out.println("Descargando " + prendaColgadas.length + " prendas");
        prendaColgadas = new PrendaColgada[0];
    }

    public PrendaColgada[] getPrendaColgadas() {
        return prendaColgadas;
    }

    public void setPrendaColgadas(PrendaColgada[] prendaColgadas) {
        this.prendaColgadas = prendaColgadas;
    }



    public void addPrenda(PrendaColgada prenda) {
        prendaColgadas = Arrays.copyOf(prendaColgadas, prendaColgadas.length + 1);
        prendaColgadas[prendaColgadas.length - 1] = prenda;
    }

    public boolean removePrenda(PrendaColgada prenda) {

        if (existePrenda(prenda)) {
            PrendaColgada[] result = new PrendaColgada[0];
            for (int i = 0; i < prendaColgadas.length; i++) {
                if (!prendaColgadas.equals(prenda)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = prenda;
                }
            }
            prendaColgadas = result;
            return true;
        }
        return false;
    }

    private boolean existePrenda(PrendaColgada prenda) {
        for (int i = 0; i < prendaColgadas.length; i++) {
            if (prendaColgadas[i].equals(prenda)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                "prendaColgadas=" + Arrays.toString(prendaColgadas) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CamionPercha that = (CamionPercha) o;
        return Arrays.equals(prendaColgadas, that.prendaColgadas);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(prendaColgadas);
        return result;
    }

    @Override
    public int compareTo(CamionPercha o) {
        return this.prendaColgadas.length - o.getPrendaColgadas().length;
    }
}
