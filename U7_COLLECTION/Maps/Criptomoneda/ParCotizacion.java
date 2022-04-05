package com.company.Maps.Criptomoneda;

public class ParCotizacion {

    private Divisa base;
    private Divisa cotizada;
    private Double precio;
    private Double variacion24h;

    public ParCotizacion(Divisa base, Divisa cotizada, Double precio, Double variacion24h) {
        this.base = base;
        this.cotizada = cotizada;
        this.precio = precio;
        this.variacion24h = variacion24h;
    }

    public Divisa getBase() {
        return base;
    }

    public void setBase(Divisa base) {
        this.base = base;
    }

    public Divisa getCotizada() {
        return cotizada;
    }

    public void setCotizada(Divisa cotizada) {
        this.cotizada = cotizada;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getVariacion24h() {
        return variacion24h;
    }

    public void setVariacion24h(Double variacion24h) {
        this.variacion24h = variacion24h;
    }

    @Override
    public String toString() {
        return "ParCotizacion{" +
                "base=" + base +
                ", cotizada=" + cotizada +
                ", precio=" + precio +
                ", variacion24h=" + variacion24h +
                '}'+'\n';
    }
}
