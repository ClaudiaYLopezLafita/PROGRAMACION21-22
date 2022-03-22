package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class COAC {

    AgrupacionOficial[] agrupacions;

    public COAC() {
        this.agrupacions = new AgrupacionOficial[0];
    }

    public Agrupacion[] getAgrupacions() {
        return agrupacions;
    }

    public void setAgrupacions(AgrupacionOficial[] agrupacions) {
        this.agrupacions = agrupacions;
    }

    public void inscribir_agrupacion(AgrupacionOficial agrupacion){
        if (!estaAgrupación(agrupacion)){
            AgrupacionOficial[] result = Arrays.copyOf(agrupacions, agrupacions.length+1);
            result[result.length-1]=agrupacion;
            agrupacions= result;
        }
    }

    public boolean eliminar_agrupacion(AgrupacionOficial agrupacion){
        if (estaAgrupación(agrupacion)){
            AgrupacionOficial[] result = new AgrupacionOficial[0];
            for (int i = 0; i <  agrupacions.length; i++) {
                if (!agrupacions[i].equals(agrupacion)){
                    result = Arrays.copyOf(result, result.length+1);
                    result[result.length-1]=agrupacions[i];
                }
            }
            agrupacions=result;
            return true;
        }
        return false;
    }

    public boolean estaAgrupación(AgrupacionOficial agrupacionOficial){
        for (int i = 0; i < agrupacions.length; i++) {
            if (agrupacions[i].equals(agrupacionOficial)) {
                return true;
            }
        }
        return false;
    }

    public void ordenar_por_puntos(){
        Arrays.sort(agrupacions, new Comparator<AgrupacionOficial>() {
            @Override
            public int compare(AgrupacionOficial o1, AgrupacionOficial o2) {
                return o1.getNumPuntos()-o2.getNumPuntos();
            }
        });
        System.out.println(Arrays.toString(agrupacions));
    }

    public void ordenar_por_nombre(){
        Arrays.sort(agrupacions, new Comparator<AgrupacionOficial>() {
            @Override
            public int compare(AgrupacionOficial o1, AgrupacionOficial o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
        System.out.println(Arrays.toString(agrupacions));
    }

    public void ordenar_por_autor(){
        Arrays.sort(agrupacions, new Comparator<AgrupacionOficial>() {
            @Override
            public int compare(AgrupacionOficial o1, AgrupacionOficial o2) {
                return o2.getAutor().compareTo(o1.getAutor());
            }
        });
        System.out.println(Arrays.toString(agrupacions));
    }

    public void cantidadAgrupaciones(){
        System.out.println("Se han creado un total de "+Agrupacion.getNumAgrupaciones()+" agrupaciones");
    }

    @Override
    public String toString() {
        return "COAC{" +
                "agrupacions=" + Arrays.toString(agrupacions) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        COAC coac = (COAC) o;
        return Arrays.equals(agrupacions, coac.agrupacions);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(agrupacions);
    }


}
