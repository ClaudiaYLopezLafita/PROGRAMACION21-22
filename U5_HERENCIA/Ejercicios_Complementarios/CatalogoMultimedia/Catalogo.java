package com.company.GrupoTarde;

import java.util.Arrays;
import java.util.Comparator;

public class Catalogo {

    private Multimedia[] multimedias;

    public Catalogo() {
        this.multimedias = new Multimedia[0];
    }

    public Multimedia[] getMultimedia() {
        return multimedias;
    }

    public void setMultimedia(Multimedia[] multimedia) {
        this.multimedias = multimedia;
    }

    public boolean addMultimedia(Multimedia multimedia){
        if (!estaMultimedia(multimedia)) {
            Multimedia[] resultado = Arrays.copyOf(multimedias, multimedias.length+1);
            resultado[resultado.length-1]= multimedia;
            multimedias=resultado;
            return true;
        }
        return false;
    }

    public boolean estaMultimedia (Multimedia multimedia){
        for (int i = 0; i < multimedias.length; i++) {
            if (multimedias[i].equals(multimedia)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeMultimedia(Multimedia multimedia){
        if (estaMultimedia(multimedia)) {
            Multimedia[] resultado = new Multimedia[0];
            for (int i = 0; i < multimedias.length ; i++) {
                if (!multimedias[i].equals(multimedia)){
                    resultado = Arrays.copyOf(resultado, resultado.length+1);
                    resultado[resultado.length-1]= multimedias[i];
                }
            }
            multimedias=resultado;
            return true;
        }
        return false;
    }

    public void ordenar_por_id(){
        Arrays.sort(multimedias);
        System.out.println(Arrays.toString(multimedias));
    }

    public void ordenar_por_titulo(){
        Arrays.sort(multimedias, new Comparator<Multimedia>() {
            @Override
            public int compare(Multimedia o1, Multimedia o2) {
                return o2.getTitulo().compareTo(o1.getTitulo());
            }
        });

        System.out.println(Arrays.toString(multimedias));
    }

    public void ordenar_por_year(){
        Arrays.sort(multimedias, new Comparator<Multimedia>() {
            @Override
            public int compare(Multimedia o1, Multimedia o2) {
                return o1.getYear()-o2.getYear();
            }
        });

        System.out.println(Arrays.toString(multimedias));
    }

    public void numeros_de_elementos(){
        System.out.println("En total se han creado "+ (Multimedia.getContadorId()-1)+" elementos");
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "multimedia=" + Arrays.toString(multimedias) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalogo catalogo = (Catalogo) o;
        return Arrays.equals(multimedias, catalogo.multimedias);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(multimedias);
    }
}
