package com.company.Frontera;

import java.util.Calendar;

public class Frontera {

    private int numRegistro;
    Registro[] registro;

    public Frontera() {
        this.numRegistro = 0;
        this.registro = new Registro[100];
    }

    void addRegistro(Persona p, Calendar c, Registro.Tipo t) {

        if (numRegistro<registro.length) {
            registro[numRegistro] = new Registro(p,c,t);
        } else {
            Registro aux[] = new Registro[numRegistro+1];
            for (int i = 0; i < registro.length; i++) {
                aux[i] = new Registro(registro[i].getPersona(),registro[i].getFecha(),
                        registro[i].getTipo());
            }
            aux[numRegistro] = new Registro(p,c,t);
            registro = aux;
        }
        numRegistro++;
    }

    void mostrarPersonas() {
        for (int i = 0; i < this.registro.length; i++) {
            registro[i].MostrarRegistro();
        }
    }

    void busquedaNombre(String nombre) {
        for (int i = 0; i < this.registro.length; i++) {
            if (registro[i].getPersona().getNombre().equals(nombre)) {
                registro[i].MostrarRegistro();
            }
        }
    }

    void busquedaDNI(String dni) {
        for (int i = 0; i < this.registro.length; i++) {
            if (registro[i].getPersona().getDni().equals(dni)) {
                registro[i].MostrarRegistro();
            }
        }
    }
}
