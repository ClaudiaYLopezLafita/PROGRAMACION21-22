package com.company.Listas.Instituto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Instituto alixar = new Instituto("Alixar");
        Unidad u1 = new Unidad("DAW1Tarde");
        Alumno a1 = new Alumno("Aitor", "Tilla", "877623D", u1);
        Alumno a2 = new Alumno("Paco", "Mer", "356353T", u1);
        Alumno a3 = new Alumno("Rigoberta", "Bandini", "53456J", u1);

        alixar.addAlumnoUnidad(a1, "DAW1Tarde");
        alixar.addAlumnoUnidad(a2, "DAW1Mañana");
        alixar.addAlumnoUnidad(a3, "DAW1Tarde");

        List<Alumno> lista = alixar.mostrarAlumnosUnidad("DAW1Tarde");
        System.out.println(lista);
        Unidad resultado = alixar.obtenerUnidadAlumno(1);
        System.out.println(resultado);
        alixar.mostrarTodosAlumnosOrdenados();
        alixar.guardarAlumnos();
        alixar.cargarAlumnos();
    }
}
