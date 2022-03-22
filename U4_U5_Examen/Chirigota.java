package com.company;

import java.util.Arrays;

public class Chirigota extends AgrupacionOficial implements Callejear{

    private int numCuples;
    private Integrante[] integrantes;

    public Chirigota(String nombre, String autor, String autorMusica, String autorLetra,
                     String tipoDisfraz, int numPuntos, int numCuples) {
        super(nombre, autor, autorMusica, autorLetra, tipoDisfraz, numPuntos);
        this.numCuples=numCuples;
        this.integrantes= new Integrante[0];
    }

    public int getNumCuples() {
        return numCuples;
    }

    public void setNumCuples(int numCuples) {
        this.numCuples = numCuples;
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
                "numCuples:" + numCuples +
                "Intengrantes[ "+ Arrays.toString(integrantes)+
                "]]"+'\n';
    }

    @Override
    public void caminito_del_falla() {
       System.out.println("La chirigota "+getNombre()+" va caminito del falla");
    }

    @Override
    public void cantar_la_presentacion() {
        System.out.println("Cantando la presentacion de la chirigota con nombre "+getNombre());
    }

    @Override
    public void hacer_tipo() {
        System.out.println("La chirgota "+getNombre()+" va de "+getTipoDisfraz());
    }

    @Override
    public void amo_a_escucha() {
        System.out.println("Amo a escuha la Chirigota "+getNombre());
    }
}
