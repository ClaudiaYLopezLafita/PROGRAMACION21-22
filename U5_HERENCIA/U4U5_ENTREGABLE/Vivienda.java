package com.company;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

public class Vivienda extends Propiedad implements MostrarPrecioVenta{

    private Calendar fecha;
    private Integer numBaños;
    private Integer numHabitaciones;
    private Integer capMaxima;
    private Double precio;
    private Persona[] personas;

    public Vivienda(Integer year, String direccion, Double superficie,
                    Integer numBaños, Integer numHabitaciones, Integer capMaxima,
                    Double precio) {
        super(year, direccion, superficie);
        this.numBaños = numBaños;
        this.numHabitaciones = numHabitaciones;
        this.capMaxima = capMaxima;
        this.precio = precio;
        this.personas = new Persona[0];
        this.fecha = Calendar.getInstance();
    }

    public Integer getNumBaños() {
        return numBaños;
    }

    public void setNumBaños(Integer numBaños) {
        this.numBaños = numBaños;
    }

    public Integer getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(Integer numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public Integer getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(Integer capMaxima) {
        this.capMaxima = capMaxima;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    private boolean estaPersona(Persona persona) {

        for (int i = 0; i < personas.length; i++) {
            if (personas[i].equals(persona)) {
                return true;
            }
        }
        return false;
    }

    public boolean addPersona(Persona persona){
        if (!estaPersona(persona) && personas.length<getCapMaxima()) {
            Persona[] resultado = Arrays.copyOf(personas, personas.length+1);
            resultado[resultado.length-1]=persona;
            personas = resultado;
            return true;
        }
        return false;
    }

    public boolean eliminarPersona(Persona persona) {
        if (estaPersona(persona)) {
            Persona[] result = new Persona[0];

            for (int i = 0; i < personas.length; i++) {
                if (!personas[i].equals(persona)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = personas[i];
                }
            }
            personas = result;
            return true;
        }
        return false;
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
                "numBaños=" + numBaños +
                ", numHabitaciones=" + numHabitaciones +
                ", capMaxima=" + capMaxima +
                ", precio=" + precio +
                ", personas=" + Arrays.toString(personas) +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vivienda vivienda = (Vivienda) o;
        return fecha.equals(vivienda.fecha) && numBaños.equals(vivienda.numBaños) && numHabitaciones.equals(vivienda.numHabitaciones) && capMaxima.equals(vivienda.capMaxima) && precio.equals(vivienda.precio) && Arrays.equals(personas, vivienda.personas);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), fecha, numBaños, numHabitaciones, capMaxima, precio);
        result = 31 * result + Arrays.hashCode(personas);
        return result;
    }

    @Override
    public void mostrarPrecioVenta() {
        System.out.println("Soy una Vivienda con capacidad máxima "+ this.getCapMaxima()+
                " y valgo "+ this.getPrecio() +"€");
    }
}
