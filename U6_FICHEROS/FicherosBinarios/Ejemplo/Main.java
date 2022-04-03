package com.company.FicherosBinarios.Ejemplo;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Persona p = new Persona("Emilia", "Perez", "78954125");
        Persona p1 = new Persona("Lola", "RUiz", "78954125");

        Persona[] personas = {p, p1};

        FileOutputStream archivo = new FileOutputStream("persona.dat");

        try {
            ObjectOutputStream out = new ObjectOutputStream(archivo);
            out.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream ar = new FileInputStream("persona.dat");
            ObjectInputStream in = new ObjectInputStream(ar);

            int[] n = (int[]) in.readObject();
            System.out.println(Arrays.toString(n));

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream arc = new FileInputStream("persona.dat");
            ObjectInputStream in = new ObjectInputStream(arc);

            Persona[] people = (Persona[]) in.readObject();
            System.out.println(Arrays.toString(people));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
