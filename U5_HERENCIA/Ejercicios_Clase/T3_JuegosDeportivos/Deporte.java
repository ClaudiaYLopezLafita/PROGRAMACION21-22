package com.company.T3_JuegosDeportivos;

import java.util.Arrays;
import java.util.Objects;

public abstract class Deporte {

    private String nombre;
    private String nomPabellon;
    private Participante[] participantes;

    public Deporte(String nombre, String nomPabellon) {
        this.nombre = nombre;
        this.nomPabellon = nomPabellon;
        this.participantes = new Participante[0];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomPabellon() {
        return nomPabellon;
    }

    public void setNomPabellon(String nomPabellon) {
        this.nomPabellon = nomPabellon;
    }

    public Participante[] getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Participante[] participantes) {
        this.participantes = participantes;
    }

    public boolean addParticipante(Participante participante) {

        if (!estaParticipante(participante)) {
            Participante[] result = Arrays.copyOf(participantes, participantes.length + 1);
            result[result.length - 1] = participante;
            participantes = result;
            return true;
        }
        return false;

    }

    public boolean removeParticipante(Participante participante) {
        if (estaParticipante(participante)) {
            Participante[] result = new Participante[0];
            for (int i = 0; i < participantes.length; i++) {
                if (!participantes[i].equals(participante)) {
                    result = Arrays.copyOf(participantes, participantes.length + 1);
                    result[result.length - 1] = participantes[i];
                }
            }
            participantes = result;
            return true;
        }
        return false;
    }

    private boolean estaParticipante(Participante participante) {
        for (int i = 0; i < participantes.length; i++) {
            if (participantes[i].equals(participante)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarParticipantes() {
        System.out.println("Participantes ordenados por edad:");
        Arrays.sort(participantes);
        for (Participante participante : participantes) {
            System.out.println(participante);
        }
    }


    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", nomPabellon='" + nomPabellon + '\'' +
                ", participantes=" + Arrays.toString(participantes) +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deporte deporte = (Deporte) o;
        return nombre.equals(deporte.nombre) && nomPabellon.equals(deporte.nomPabellon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nomPabellon);
    }
}
