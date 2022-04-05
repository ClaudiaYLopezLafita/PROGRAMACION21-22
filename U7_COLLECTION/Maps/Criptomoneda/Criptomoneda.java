package com.company.Maps.Criptomoneda;

import java.util.Objects;

public class Criptomoneda extends Divisa{

    private String fecha;
    private Integer volumen24h;
    private Double precioUSD;
    private Integer ranking;

    public Criptomoneda(String nombre, String simbolo, Integer id, String fecha, Integer volumen24h,
                        Double precioUSD, Integer ranking) {
        super(nombre, simbolo, id);
        this.fecha=fecha;
        this.volumen24h = volumen24h;
        this.precioUSD = precioUSD;
        this.ranking=ranking;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getVolumen24h() {
        return volumen24h;
    }

    public void setVolumen24h(Integer volumen24h) {
        this.volumen24h = volumen24h;
    }

    public Double getPrecioUSD() {
        return precioUSD;
    }

    public void setPrecioUSD(Double precioUSD) {
        this.precioUSD = precioUSD;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Criptomoneda{" + super.toString() +
                "fecha='" + fecha + '\'' +
                ", volumen24h=" + volumen24h +
                ", precioUSD=" + precioUSD +
                ", ranking=" + ranking +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Criptomoneda that = (Criptomoneda) o;
        return Objects.equals(fecha, that.fecha) && Objects.equals(volumen24h, that.volumen24h) && Objects.equals(precioUSD, that.precioUSD) && Objects.equals(ranking, that.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fecha, volumen24h, precioUSD, ranking);
    }
}
