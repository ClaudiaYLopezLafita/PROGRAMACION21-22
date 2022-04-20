package com.company.EJER_Baloncesto;

import java.io.*;
import java.util.*;

public class ClubBaloncesto {

    Map<String, Set<Jugador>> jugadores;

    public ClubBaloncesto() {
        this.jugadores = new HashMap<>();
    }

    public Map<String, Set<Jugador>> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Map<String, Set<Jugador>> jugadores) {
        this.jugadores = jugadores;
    }

    public void addJugador(Jugador jugador){

        if (jugador.getAltura()<180){
            if (!jugadores.containsKey("BAJO")){
                jugadores.put("BAJO",new TreeSet<Jugador>());
            }
            jugadores.get("BAJO").add(jugador);
        } else if (jugador.getAltura()>=180 && jugador.getAltura()<200) {
            if (!jugadores.containsKey("MEDIANO")){
                jugadores.put("MEDIANO", new TreeSet<Jugador>());
            }
            jugadores.get("MEDIANO").add(jugador);
        } else if (jugador.getAltura()>200){
            if (!jugadores.containsKey("ALTO")){
                jugadores.put("ALTO",new TreeSet<Jugador>());
            }
            jugadores.get("ALTO").add(jugador);
        }
    }

    public void removeJugador(Jugador jugador){

        if (jugador.getAltura()<180){
            if (jugadores.containsKey("BAJO")) {
                jugadores.get("BAJO").remove(jugador);
            }
        }else if (jugador.getAltura()>=180 && jugador.getAltura()<200){
            if (jugadores.containsKey("MEDIANO")) {
                jugadores.get("MEDIANO").remove(jugador);
            }
        } else if (jugador.getAltura()<200) {
            if (jugadores.containsKey("ALTO")) {
                jugadores.get("ALTO").remove(jugador);
            }
        }
    }

    public void mostrarJugadores(String size){
        if (jugadores.containsKey(size)){

            for (Jugador j:jugadores.get(size)) {
                System.out.print(j);
            }
//            List<Jugador> list = new ArrayList<Jugador>();
//            list.addAll(jugadores.get(size));
//
//            Collections.sort(list);
//            System.out.println(list);
        }
    }

    public void mostrarJugadorPorAltura(){

        List<Jugador> list = new ArrayList<>();
        list.addAll(jugadores.get("BAJO"));
        list.addAll(jugadores.get("ALTO"));
        list.addAll(jugadores.get("MEDIANO"));

        Collections.sort(list, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                return o1.getAltura()-o2.getAltura();
            }
        });
        System.out.println(list);
    }

    public void mostrarJugadorPorAltura2(){

        List<Jugador> list = new ArrayList<Jugador>();
        Collection<Set<Jugador>> setCollection = jugadores.values();

        Iterator it = setCollection.iterator();
        while (it.hasNext()){
            list.addAll((Set<Jugador>) it.next());
        }

        Collections.sort(list, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                return o1.getAltura()-o2.getAltura();
            }
        });
        System.out.println(list);
    }

    public void mostrarJugadorPorAltura3(){

        Set<String> keys = jugadores.keySet();
        ArrayList<Jugador> list = new ArrayList<>();

        for (String clave:keys) {
            list.addAll(jugadores.get(clave));
        }

        Collections.sort(list, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                return o1.getAltura()-o2.getAltura();
            }
        });
        System.out.println(list);
    }

    public void mostrarJugadorRangoEdad(Integer edadMin, Integer edadMax){
        Collection<Set<Jugador>> setCollection = jugadores.values();

        Iterator it = setCollection.iterator();
        while (it.hasNext()){
            Set<Jugador> jugadorSet = (Set<Jugador>) it.next();
            for (Jugador jugador:jugadorSet) {
                if (jugador.getEdad()>=edadMin && jugador.getEdad()<=edadMax){
                    System.out.print(jugador);
                }
            }
        }
    }

    public void cargarJugadores(){
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("jugadores.dat"));
            while (true){
                Jugador j = (Jugador) in.readObject();

                Integer altura = j.getAltura();
                String key;
                if (altura>0 && altura<180) {
                    key="BAJOS";
                } else if (altura>=180 && altura<200) {
                    key="MEDIANOS";
                } else {
                    key="ALTOS";
                }

                if (!jugadores.containsKey(key)) {
                    jugadores.put(key,new TreeSet<Jugador>());
                }

                jugadores.get(key).add(j);
            }
        } catch (Exception e) {

        } finally {
            if (in!=null) {
                try {
                    in.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public void guardarJugadores(){
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream("jugadores.dat"));
            Collection<Set<Jugador>> setCollection = jugadores.values();

            Iterator it = setCollection.iterator();
            while (it.hasNext()){
                Set<Jugador> jugadorSet = (Set<Jugador>) it.next();
                for (Jugador j:jugadorSet) {
                    out.writeObject(j);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {if (out!=null) {
            try {
                out.close();
            } catch (IOException e) {

            }
        }
        }


    }

    @Override
    public String toString() {
        return "ClubBaloncesto{" +
                "jugadores=" + jugadores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubBaloncesto that = (ClubBaloncesto) o;
        return Objects.equals(jugadores, that.jugadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jugadores);
    }
}
