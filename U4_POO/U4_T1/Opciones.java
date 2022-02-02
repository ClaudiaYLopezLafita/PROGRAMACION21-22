package com.company;

import java.util.Objects;

public class Opciones {

    private String texto;
    private boolean respuesta;

    public Opciones(String texto, boolean respuesta) {
        this.texto = texto;
        this.respuesta = respuesta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return ", \n"+ "Opciones{" +
                "texto='" + texto + '\'' +
                "respuesta=" + respuesta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opciones opciones = (Opciones) o;
        return texto.equals(opciones.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto);
    }
}
