package com.company.Listas.Instituto;

import java.io.*;
import java.util.*;

public class Instituto {

    private String nombre;
    private Map<Unidad, List<Alumno>> mapa;

    public Instituto(String nombre) {
        this.nombre = nombre;
        this.mapa = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarTodosAlumnosOrdenados() {
        Set<Alumno> completa =
                new TreeSet<>(
                        new Comparator<Alumno>() {
                            @Override
                            public int compare(Alumno a1, Alumno a2) {
                                return a1.getApellidos().compareTo(a2.getApellidos());
                            }
                        });
        Set<Map.Entry<Unidad, List<Alumno>>> entradas = mapa.entrySet();
        Iterator<Map.Entry<Unidad, List<Alumno>>> it = entradas.iterator();
        while (it.hasNext()) {
            Map.Entry<Unidad, List<Alumno>> entrada = it.next();
            completa.addAll(entrada.getValue());
        }
        System.out.println(completa);
    }

    public Unidad obtenerUnidadAlumno(Integer id) {
        Unidad resultado = new Unidad("");
        Iterator<Unidad> it = mapa.keySet().iterator();
        while (it.hasNext()) {
            Unidad u = it.next();
            List<Alumno> lista_alumnos = mapa.get(u);
            Iterator<Alumno> it_alumno = lista_alumnos.iterator();
            while (it_alumno.hasNext()) {
                Alumno a = it_alumno.next();
                if (a.getId().equals(id)) {
                    resultado = u;
                }
            }
        }
        return resultado;
    }

    public List<Alumno> mostrarAlumnosUnidad(String nombre_unidad) {
        Unidad aux = new Unidad(nombre_unidad);
        List<Alumno> resultado = new ArrayList<>();
        if (mapa.containsKey(aux)) {
            resultado = mapa.get(aux);
        }
        resultado.sort(
                new Comparator<Alumno>() {
                    @Override
                    public int compare(Alumno a1, Alumno a2) {
                        return a1.getDni().compareTo(a2.getDni());
                    }
                });
        return resultado;
    }

    public void addAlumnoUnidad(Alumno a, String nombre_unidad) {
        Unidad aux = new Unidad(nombre_unidad);
        if (!mapa.containsKey(aux)) {
            ArrayList<Alumno> unidad_alumnos = new ArrayList<>();
            unidad_alumnos.add(a);
            mapa.put(aux, unidad_alumnos);
        } else {
            mapa.get(aux).add(a);
        }
        System.out.println(mapa);
    }

    public void cargarAlumnos() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("alumnos.dat"));
            Set<Alumno> completa = (Set<Alumno>) in.readObject();
            mapa.clear();
            System.out.println("Mapa borrado");
            System.out.println(mapa);
            Iterator<Alumno> it = completa.iterator();
            while (it.hasNext()) {
                Alumno a = it.next();
                addAlumnoUnidad(a, a.getUnidad().getNombre());
            }
            System.out.println("Mapa cargado");
            System.out.println(mapa);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guardarAlumnos() {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("alumnos.dat"));
            Set<Alumno> completa = new TreeSet<>();
            Set<Map.Entry<Unidad, List<Alumno>>> entradas = mapa.entrySet();
            Iterator<Map.Entry<Unidad, List<Alumno>>> it = entradas.iterator();
            while (it.hasNext()) {
                Map.Entry<Unidad, List<Alumno>> entrada = it.next();
                completa.addAll(entrada.getValue());
            }
            out.writeObject(completa);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
