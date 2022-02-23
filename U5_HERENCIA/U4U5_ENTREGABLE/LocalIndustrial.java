package com.company;

import java.util.Calendar;
import java.util.Objects;

public class LocalIndustrial extends Local implements MostrarPrecioVenta{

    private Calendar fecha;
    private Integer consumoEnergia;

    public LocalIndustrial(Integer year, String direccion, Double superficie,
                           Persona propietario, Double precio, Integer consumoEnergia) {
        super(year, direccion, superficie, propietario, precio);
        this.consumoEnergia = consumoEnergia;
        this.fecha = Calendar.getInstance();
    }

    public Integer getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(Integer consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    @Override
    public void mostrarPropiedad() {
        System.out.println("fecha: "+ fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+
                fecha.get(Calendar.YEAR) + ", clase: "+ this.getClass().getSimpleName()+", "+ this.toString()
        );
    }

    @Override
    public String toString() {
        return super.toString() +
                "consumo Energia='" + consumoEnergia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LocalIndustrial that = (LocalIndustrial) o;
        return consumoEnergia.equals(that.consumoEnergia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), consumoEnergia);
    }

    @Override
    public void mostrarPrecioVenta() {
        System.out.println(" Soy un LocalIndustrail con un consumo un máximo de "+
                this.getConsumoEnergia()+ " y valgo "+this.getPrecio()+"€");
    }
}
