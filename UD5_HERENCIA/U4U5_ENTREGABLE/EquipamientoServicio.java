package com.company;

import java.util.Calendar;
import java.util.Objects;
import java.util.PrimitiveIterator;

public class EquipamientoServicio extends Propiedad{

    private Calendar fecha;
    private Tipo tipo;

    public EquipamientoServicio(Integer year, String direccion, Double superficie, Tipo tipo) {
        super(year, direccion, superficie);
        this.tipo= tipo;
        this.fecha = Calendar.getInstance();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
                "tipo=" + tipo +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EquipamientoServicio that = (EquipamientoServicio) o;
        return tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipo);
    }
}
