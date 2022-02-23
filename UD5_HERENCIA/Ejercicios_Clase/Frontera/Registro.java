package com.company.Frontera;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Registro {

    private Persona persona;
    private Calendar fecha;
    public enum Tipo { ENTRADA,SALIDA};

    private Tipo tipo;

    public Registro(Persona persona) {
        this(persona, Calendar.getInstance(), Tipo.SALIDA);
    }

    public Registro(Persona persona, Tipo tipo) {
        this(persona, Calendar.getInstance(), tipo);
    }

    public Registro(Persona persona, Calendar fecha, Tipo tipo) {
        this.persona = persona;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    void MostrarRegistro() {
        System.out.println("Nombre:"+this.persona.getNombre());
        System.out.println("DNI:"+this.persona.getDni());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        System.out.println("Fecha:"+dateFormat.format(this.fecha));
        System.out.println("Tipo:"+this.tipo.toString());
        System.out.println("---------------------------------");
    }

    @Override
    public String toString() {
        return "Registro{" +
                "persona=" + persona +
                ", fecha=" + fecha +
                ", tipo=" + tipo +
                '}';
    }
}
