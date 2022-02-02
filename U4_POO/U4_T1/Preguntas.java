package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Preguntas {

    private String enunciado;
    private Opciones[] opcion;
    private static Integer maxOpciones = 3;

    public Preguntas(String enunciado) {
        this.enunciado = enunciado;
        this.opcion = new Opciones[0];
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Opciones[] getOpcion() {
        return opcion;
    }

    public void setOpcion(Opciones[] opcion) {
        this.opcion = opcion;
    }

    public static Integer getMaxOpciones() {
        return maxOpciones;
    }

    public static void setMaxOpciones(Integer maxOpciones) {
        Preguntas.maxOpciones = maxOpciones;
    }

    public boolean estaOpcion (Opciones x){

        for (int i = 0; i < opcion.length; i++) {
            if (opcion[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public boolean addOpcion(Opciones x){
        Opciones[] result = new Opciones[0];
        if (!estaOpcion(x) && result.length<maxOpciones){
            result = Arrays.copyOf(opcion, opcion.length+1);
            result[result.length-1]=x;
            opcion = result;
            return true;
        }
        return false;
    }

    public boolean removeOpcion(Opciones x){
        if (estaOpcion(x)) {
            Opciones[] resultado = new Opciones[0];
            for (int i = 0; i < opcion.length; i++) {
                if (!opcion[i].equals(x)){
                    resultado = Arrays.copyOf(resultado,resultado.length+1);
                    resultado[resultado.length-1] = opcion[i];
                    opcion = resultado;
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrar_informacion(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "\n" +"Preguntas{" +
                "enunciado='" + enunciado + ", \n" +
                "opcion=" + Arrays.toString(opcion) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preguntas preguntas = (Preguntas) o;
        return enunciado.equals(preguntas.enunciado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enunciado);
    }
}
