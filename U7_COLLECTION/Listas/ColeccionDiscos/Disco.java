package com.company.Listas.ColeccionDiscos;

public class Disco {

    private String codigo;
    private String autor;
    private String titulo;
    private String genero;
    private int duracion; // duración total en minutos

    public Disco(String codigo, String autor, String titulo, String genero, int duracion) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return  "\n------------------------------------------"+
                "Disco{" +
                "codigo:'" + codigo + '\'' + '\n' +
                ", autor:'" + autor + '\'' + '\n' +
                ", titulo:'" + titulo + '\'' + '\n' +
                ", genero:'" + genero + '\'' + '\n' +
                ", duracion:" + duracion +
                '}' +
                "\n------------------------------------------";
    }

    // Considero que dos discos son iguales si tienen el mismo código.
// Es obligatorio pasar un objeto genérico como parámetro.
    @Override
    public boolean equals(Object d) {
        return (this.codigo).equals(((Disco)d).getCodigo());
    }
}
