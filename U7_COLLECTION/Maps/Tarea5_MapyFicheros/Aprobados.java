package com.company.Maps.Tarea5_MapyFicheros;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Aprobados {

    private HashMap<Integer, Double> aprobados;

    public Aprobados() {
        this.aprobados = new HashMap<>();
    }

    public HashMap<Integer, Double> getAprobados() {
        return aprobados;
    }

    public void leerCalificaciones() {
        ObjectInputStream in_calif = null;
//        ObjectInputStream in_aspir = null;

        try {
            in_calif = new ObjectInputStream(new FileInputStream("calificaciones.dat"));
//          in_aspir = new ObjectInputStream(new FileInputStream("aspirantes.dat"));

            HashMap<Integer, List<Integer>> calificaciones = (HashMap<Integer, List<Integer>>) in_calif.readObject();
//          HashMap<Integer, Aspirante> aspirantes = (HashMap<Integer, Aspirante>) in_aspir.readObject();

            Iterator<Map.Entry<Integer, List<Integer>>> it = calificaciones.entrySet().iterator();
            double media;

            while (it.hasNext()) {
                Map.Entry<Integer, List<Integer>> entry = it.next();
                media = calcularMedia(entry.getValue());

                if (media >= 5) {
                    aprobados.put(entry.getKey(), media);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in_calif.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private double calcularMedia(List<Integer> calificaciones) {
        double media = 0;
        Iterator<Integer> it = calificaciones.iterator();

        while (it.hasNext()) {
            Integer calif = it.next();
            media += calif;
        }
        media = media / calificaciones.size();
        return media;
    }

    public void generarInforme() {
        ObjectInputStream in_aspir = null;

        try {
            in_aspir = new ObjectInputStream(new FileInputStream("aspirantes.dat"));
            HashMap<Integer, Aspirante> aspirantes = (HashMap<Integer, Aspirante>) in_aspir.readObject();
            Iterator<Map.Entry<Integer, Double>> it = aprobados.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<Integer, Double> entry = it.next();
                String nombre = aspirantes.get(entry.getKey()).getNombre();
                String dni = aspirantes.get(entry.getKey()).getDni();
                double media = entry.getValue();
                System.out.println(nombre + " " + dni + " " + media);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in_aspir.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Aprobados{" +
                "aprobados=" + aprobados +
                '}';
    }
}
