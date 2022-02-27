package com.company.GrupoTarde;

import java.util.Arrays;
import java.util.Objects;

public class Serie extends Multimedia implements Reproducir{

    private Integer numTemporadas;
    private Capitulo[] capitulos;

    public Serie(String titulo, String director, Integer year, boolean finalizado,
                 Integer numTemporadas) {
        super(titulo, director, year, finalizado);
        this.numTemporadas = numTemporadas;
        this.capitulos = new Capitulo[0];
    }

    public Integer getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(Integer numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public Capitulo[] getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Capitulo[] capitulos) {
        this.capitulos = capitulos;
    }

    public boolean addCapitulo( Capitulo capitulo){
        if(!estaCaoitulo(capitulo)){
            Capitulo[] resultado = Arrays.copyOf(capitulos, capitulos.length+1);
            resultado[resultado.length-1] = capitulo;
            capitulos = resultado;
            return true;
        }
        return  false;
    }

    public boolean estaCaoitulo(Capitulo capitulo) {
        for (int i = 0; i < capitulos.length; i++) {
            if (capitulos[i].equals(capitulo)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeCapitulo(Capitulo capitulo){
        if (estaCaoitulo(capitulo)){
            Capitulo[] resultado = new Capitulo[0];

            for (int i = 0; i < capitulos.length; i++) {
                if (!capitulos[i].equals(capitulo)) {
                    resultado = Arrays.copyOf(resultado, resultado.length + 1);
                    resultado[resultado.length - 1] = capitulos[i];
                }
            }
            capitulos = resultado;
            return true;
        }


        return false;
    }

    @Override
    public String toString() {
        return super.toString()+
                "numTemporadas=" + numTemporadas + '\n' +
                "    capitulos=" + Arrays.toString(capitulos) +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Serie libro = (Serie) o;
        return numTemporadas.equals(libro.numTemporadas) && Arrays.equals(capitulos, libro.capitulos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), numTemporadas);
        result = 31 * result + Arrays.hashCode(capitulos);
        return result;
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo serie " + getTitulo() + ','+ " capítulo "+ getCapitulos());
    }

    @Override
    public void pause() {
        System.out.println("Pausando serie " + getTitulo() + ','+ " capítulo "+ getCapitulos());
    }

    @Override
    public void stop() {
        System.out.println("Parando serie " + getTitulo() + ','+ " capítulo "+ getCapitulos());

    }
}
