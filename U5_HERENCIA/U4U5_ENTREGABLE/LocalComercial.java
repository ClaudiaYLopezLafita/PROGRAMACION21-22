package com.company;

import java.util.Calendar;

public class LocalComercial extends Local implements MostrarPrecioVenta{

    private Calendar fecha;
    private String descripcionActv;

    public LocalComercial(Integer year, String direccion, Double superficie,
                          Persona propietario, Double precio, String descripcionActv) {
        super(year, direccion, superficie, propietario, precio);
        this.descripcionActv=descripcionActv;
        this.fecha = Calendar.getInstance();
    }

    public String getDescripcionActv() {
        return descripcionActv;
    }

    public void setDescripcionActv(String descripcionActv) {
        this.descripcionActv = descripcionActv;
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
                ", actividad Comercial=" + descripcionActv +
                '}'+'\n';
    }

    @Override
    public void mostrarPrecioVenta() {
        System.out.println("Soy un LocalComercial que me dedico a "+this.descripcionActv +" y valgo "
                + this.getPrecio() +"€");
    }
}
