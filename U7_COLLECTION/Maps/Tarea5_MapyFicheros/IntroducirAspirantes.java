package com.company.Maps.Tarea5_MapyFicheros;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class IntroducirAspirantes {

    private static int numAspirantes = 1;
    private HashMap<Integer, Aspirante> aspirantes;

    public IntroducirAspirantes() {
        this.aspirantes = new HashMap<>();
    }

    public static int getNumAspirantes() {
        return numAspirantes;
    }

    public HashMap<Integer, Aspirante> getAspirantes() {
        return aspirantes;
    }

    public void insetarApirante(){
        Scanner sc = new Scanner(System.in);
        String answer="";
        do {
            aspirantes.put(numAspirantes, crearAspirante());
            numAspirantes++;

            System.out.println("¿Desea seguir introduciendo aspirantes?");
            answer = sc.nextLine();

        } while (answer.equalsIgnoreCase("si"));
    }

    public static Aspirante crearAspirante(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();
        System.out.println("Introduce el dni: ");
        String dni = sc.nextLine();
        System.out.println("Introduce el telefono: ");
        String phone = sc.nextLine();

        return new Aspirante(name, dni, phone);
    }

    public void guardarFciheros(){
        ObjectOutputStream out1 = null; // Entras del mapa
        ObjectOutputStream out2 = null; // Ids
        List<Integer> ids = new LinkedList<>(aspirantes.keySet());

        try {
            out1 = new ObjectOutputStream(new FileOutputStream("aspirantes.dat"));
            out2 = new ObjectOutputStream(new FileOutputStream("ids_aspirantes.dat"));

            out1.writeObject(aspirantes);
            out2.writeObject(ids);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out1.close();
                out2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "IntroducirAspirantes{" +
                "aspirantes=" + aspirantes +
                '}';
    }

}
