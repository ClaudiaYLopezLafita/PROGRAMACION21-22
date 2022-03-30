package com.company.Maps.Tarea3b.Ejer04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Traductor {

    private Map<String, String> diccionario;

    public Traductor(String fileName) {
        this.diccionario = new HashMap<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String linea = in.readLine();
            while (linea!=null){
                String[] palabras = linea.split(",");
                diccionario.put(palabras[0],palabras[1]);
                linea= in.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Map<String, String> getDiccionarios() {
        return diccionario;
    }
}
