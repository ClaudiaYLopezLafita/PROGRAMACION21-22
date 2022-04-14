package com.company.ENT_EstacionMeteorológica;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EstacionMeteorológica {

    private List<Medicion> medicions;
    private Coordenadas coordenadas;

    public EstacionMeteorológica(String fichero, Coordenadas coordenadas) {
        this.medicions = new ArrayList<>();
        this.coordenadas = coordenadas;
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream(fichero));
            while (true){
                Medicion m = (Medicion) in.readObject();
                medicions.add(m);
            }
        } catch (IOException e) {
            // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
        }
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void addNedicion( Medicion medicion){
        medicions.add(medicion);
    }

    public void ordenaTemperaturasAsc(){

        Collections.sort(medicions);
        for (Medicion m:medicions) {
            System.out.print(m);
        }
    }

    public void ordenaHumedadesDes(){
        Collections.sort(medicions, new Comparator<Medicion>() {
            @Override
            public int compare(Medicion m1, Medicion m2) {
                return m2.getHumedad().compareTo(m1.getHumedad());
            }
        });
        for (Medicion m:medicions) {
            System.out.print(m);
        }
    }

    // Para indicar que un objeto no tiene valor se pone a NULL.
    public Medicion presionMaxima(){

        Medicion medicionMax=medicions.get(0);// medicionMax será el primer objeto medicion
        for (Medicion m:medicions) {
            if (m.getPresion() > medicionMax.getPresion()){
                medicionMax = m;
            }
        }
        return medicionMax;
    }

    public boolean buscarMecicion(Medicion medicion){
        for (Medicion m:medicions) {
            if (m.equals(medicion)){
                return true;
            }
        }
        return false;
    }
    
    public void guardarFichero(String fichero){

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(fichero));
            for (Medicion m:medicions) {
                out.writeObject(m);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "EstacionMeteorológica{" +
                "medicions=" + medicions +
                ", coordenadas=" + coordenadas +
                '}';
    }
}
