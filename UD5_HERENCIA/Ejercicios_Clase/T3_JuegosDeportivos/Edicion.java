package com.company.T3_JuegosDeportivos;

import java.util.Arrays;
import java.util.Comparator;

public class Edicion {
    private Integer anio;
    private String sede;
    private Pais[] paises;
    private  Deporte[] deportes;

    public Edicion(int year, String sede) {
        if (year % 4 != 0) {
            this.anio = 2000;
        } else {
            this.anio = year;
        }
        this.sede = sede;
        this.paises = new Pais[0];
        this.deportes = new Deporte[0];
    }

    public int getYear() {
        return anio;
    }

    public void setYear(int year) {
        this.anio = year;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Pais[] getPaises() {
        return paises;
    }

    public void setPaises(Pais[] paises) {
        this.paises = paises;
    }

    public Deporte[] getDeportes() {
        return deportes;
    }

    public void setDeportes(Deporte[] deportes) {
        this.deportes = deportes;
    }

    public boolean addPais(Pais pais){

        if (!estaPais(pais)) {
            Pais[] result = Arrays.copyOf(paises, paises.length + 1);
            result[result.length - 1] = pais;
            paises = result;
            return true;
        }
        return false;
    }

    private boolean estaPais(Pais pais) {

        for (int i = 0; i < paises.length; i++) {
            if (paises[i].equals(pais)) {
                return true;
            }
        }
        return false;
    }

    public boolean addDeporte(Deporte deporte){
        if (!estaDeporte(deporte)) {
            Deporte[] resultado = Arrays.copyOf(deportes, deportes.length+1);
            resultado[resultado.length-1]=deporte;
            deportes = resultado;
            return true;
        }
        return false;
    }

    public boolean removeDeporte(Deporte deporte) {
        if (estaDeporte(deporte)) {
            Deporte[] result = new Deporte[0];

            for (int i = 0; i < deportes.length; i++) {
                if (!deportes[i].equals(deporte)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = deportes[i];
                }
            }
            deportes = result;
            return true;
        }
        return false;
    }

    private boolean estaDeporte(Deporte deporte) {

        for (int i = 0; i < deportes.length; i++) {
            if (deportes[i].equals(deporte)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarPaises() {
        System.out.println("Países ordenados de manera decreciente por el número de participantes:");
        Arrays.sort(paises, new Comparator<Pais>() {
            @Override
            public int compare(Pais pais1, Pais pais2) {
                return pais2.getNumParticipantes() - pais1.getNumParticipantes();
            }
        });

        for (int i = 0; i < paises.length; i++) {
            System.out.println(paises[i]);
        }
    }

    public void mostrarPaisesParaCeremonia() {
        System.out.println("Lista de países ordenados por su nombre:");
        Arrays.sort(paises);
        for (Pais pais : paises) {
            System.out.println(pais);
        }
    }

    @Override
    public String toString() {
        return "Juego" +
                "year=" + anio +
                ", sede='" + sede + '\'' +
                ", paises=" + Arrays.toString(paises) +
                ", deportes=" + Arrays.toString(deportes) +
                '\n';
    }
}
