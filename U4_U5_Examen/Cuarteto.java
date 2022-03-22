package com.company;

import java.util.Arrays;

public class Cuarteto extends AgrupacionOficial implements Callejear{

    private int numMiembros;
    private Integrante[] integrantes;

    public Cuarteto(String nombre, String autor, String autorMusica, String autorLetra,
                    String tipoDisfraz, int numPuntos, int numMiembros) {
        super(nombre, autor, autorMusica, autorLetra, tipoDisfraz, numPuntos);
        this.numMiembros=numMiembros;
        this.integrantes= new Integrante[0];
    }

    public int getNumMiembros() {
        return numMiembros;
    }

    public void setNumMiembros(int numMiembros) {
        this.numMiembros = numMiembros;
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
                "numMiembros=" + numMiembros +
                " Intengrantes[ " + Arrays.toString(integrantes)+
        "]]"+'\n';
    }

    @Override
    public void caminito_del_falla() {
        System.out.println("El cuarteto "+getNombre()+" va caminito del falla");
    }

    @Override
    public void cantar_la_presentacion() {
        System.out.println("Cantando la presentacion del cuarteto con nombre "+getNombre());
    }

    @Override
    public void hacer_tipo() {
        System.out.println("El cuarteto "+getNombre()+" va de "+getTipoDisfraz());
    }

    @Override
    public void amo_a_escucha() {
        System.out.println("Amo a escuha la Chirigota "+getNombre());
    }
}
