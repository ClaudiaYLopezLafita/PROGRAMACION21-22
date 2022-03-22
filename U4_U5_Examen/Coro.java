package com.company;

import java.util.Arrays;

public class Coro extends AgrupacionOficial{

    private int numBandurrias;
    private int nummGuitarras;
    private Integrante[] integrantes;


    public Coro(String nombre, String autor, String autorMusica, String autorLetra,
                String tipoDisfraz, int numPuntos, int numBandurrias, int nummGuitarras) {
        super(nombre, autor, autorMusica, autorLetra, tipoDisfraz, numPuntos);
        this.numBandurrias=numBandurrias;
        this.nummGuitarras=nummGuitarras;
        this.integrantes= new Integrante[0];
    }


    public int getNumBandurrias() {
        return numBandurrias;
    }

    public void setNumBandurrias(int numBandurrias) {
        this.numBandurrias = numBandurrias;
    }

    public int getNummGuitarras() {
        return nummGuitarras;
    }

    public void setNummGuitarras(int nummGuitarras) {
        this.nummGuitarras = nummGuitarras;
    }

    public void insertar_integrante(Integrante i){
        if (!estaIntegrante(i)){
            Integrante[] result = Arrays.copyOf(integrantes, integrantes.length+1);
            result[result.length-1]=i;
            integrantes=result;
        }
    }

    public boolean eliminar_integrante(Integrante i){
        if (estaIntegrante(i)){
            Integrante[] result = new Integrante[0];
            for (int j = 0; j < integrantes.length; j++) {
                if (!integrantes[j].equals(i)){
                    result = Arrays.copyOf(result, result.length+1);
                    result[result.length-1]= integrantes[j];
                }
            }
            integrantes=result;
            return true;
        }
        return false;
    }

    public boolean estaIntegrante(Integrante i){
        for (int j = 0; j <  integrantes.length; j++) {
            if (integrantes[j].equals(i)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                "numBandurrias=" + numBandurrias +
                ", nummGuitarras=" + nummGuitarras +
                 "Intengrantes[ "+ Arrays.toString(integrantes)+
                "]]"+'\n';
    }

    @Override
    public void cantar_la_presentacion() {
        System.out.println("Cantando la presentacion del coro con nombre "+getNombre());
    }

    @Override
    public void hacer_tipo() {
        System.out.println("El coro "+getNombre()+" va de "+getTipoDisfraz());
    }

    @Override
    public void caminito_del_falla() {
        System.out.println("EL coro "+getNombre()+" va caminito del falla");
    }
}
