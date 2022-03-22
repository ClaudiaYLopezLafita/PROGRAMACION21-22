package com.company;

import java.util.Arrays;

public class Comparsa extends AgrupacionOficial {

    private String empAtrezzo;
    private Integrante[] integrantes;

    public Comparsa(String nombre, String autor, String autorMusica, String autorLetra,
                    String tipoDisfraz, int numPuntos,String empAtrezzo) {
        super(nombre, autor, autorMusica, autorLetra, tipoDisfraz, numPuntos);
        this.empAtrezzo=empAtrezzo;
        this.integrantes=new Integrante[0];
    }

    public String getEmpAtrezzo() {
        return empAtrezzo;
    }

    public void setEmpAtrezzo(String empAtrezzo) {
        this.empAtrezzo = empAtrezzo;
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
                "empAtrezzo:'" + empAtrezzo + '\'' +
                "Intengrantes[ "+ Arrays.toString(integrantes)+
                "]]"+'\n';
    }

    @Override
    public void caminito_del_falla() {
        System.out.println("EL comparsa "+getNombre()+" va caminito del falla");
    }

    @Override
    public void cantar_la_presentacion() {
        System.out.println("Cantando la presentacion de la comparsa con nombre "+getNombre());
    }

    @Override
    public void hacer_tipo() {
        System.out.println("La comparsa"+getNombre()+" va de "+getTipoDisfraz());
    }


}
