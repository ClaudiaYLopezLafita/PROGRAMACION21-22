package com.company.Maps.Tarea5_MapyFicheros;

import java.io.*;
import java.util.*;

public class CalificarPrueba {

    private HashMap<Integer, List<Integer>> calificaciones;

    public CalificarPrueba() {
        this.calificaciones = new HashMap<>();
    }

    public HashMap<Integer, List<Integer>> getCalificaciones() {
        return calificaciones;
    }

    public void leerIDs() {
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("ids_aspirantes.dat"));
            List<Integer> ids = (List<Integer>) in.readObject();

            for (Integer id : ids) {
                calificaciones.put(id, new ArrayList<>());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void introducirCalificaciones() {
        Scanner sc = new Scanner(System.in);
        Integer nota;
        boolean seguir;

        for (Map.Entry<Integer, List<Integer>> entrada : calificaciones.entrySet()) {
            seguir = true;

            do {
                System.out.println("Introduzca la calificación para el aspirante nº " + entrada.getKey() + "(-1 para parar)");
                nota = leerNumero(sc);
                sc.nextLine();

                if (nota == -1) {
                    seguir = false;
                } else {
                    entrada.getValue().add(nota);
                }
            } while (seguir);
        }
    }

    public void guardarCalificaciones() {
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream("calificaciones.dat"));
            out.writeObject(calificaciones);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int leerNumero(Scanner teclado) {
        boolean exception;
        int result = 0;

        do {
            exception = false;
            try {
                result = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un número");
                exception = true;
            }
        } while (exception);

        return result;
    }

    @Override
    public String toString() {
        return "CalificacionPruebas{" +
                "calificaciones=" + calificaciones +
                '}';
    }
}
