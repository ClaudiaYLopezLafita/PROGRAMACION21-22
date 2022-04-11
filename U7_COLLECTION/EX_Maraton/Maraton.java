package com.company.EX_Maraton;

import java.io.*;
import java.util.*;

public class Maraton {

    Map<Integer, Atleta> atletas;

    public Maraton() {
        this.atletas = new LinkedHashMap<>();
    }

/*
no es necesario comprobar si el dorsal (clave) está o no está inscrito
esto se debe a que el dorsal a medida que se crean nuevos se autoincroemnte
automaticamente
 */
    public void addAtleta(Atleta a){
        atletas.put(a.getDorsal(), a);
    }

    public Atleta crearAtleta(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Pais:");
        String pais = sc.nextLine();
        System.out.println("Categoria:");
        Categoria categoria = Categoria.valueOf(sc.nextLine());
        // Para indicar por teclo el valor de un ENUM

        return new Atleta(nombre, pais, categoria);
    }

    public void saveMarca(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un dorsal: ");
        Integer dorsal = sc.nextInt();
        System.out.println("Introduce un tiempo");
        Integer marca = sc.nextInt();

        if (atletas.containsKey(dorsal)){
            atletas.get(dorsal).setMarca(marca);
            atletas.get(dorsal).setFinisher(true);
        } else {
            System.out.println("El dorsal no exite.");
        }
    }

    public boolean removeAtleta(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el dorsal a borrar: ");
        Integer dorsal = sc.nextInt();

        if (atletas.containsKey(dorsal)){
          atletas.remove(dorsal);
          return true;
        } else {
            System.out.println("El dorsal no está inscrito");
        }

        return false;
    }

    public void MostrarListaFinishers(){

        Collection<Atleta> collection = atletas.values();
        List<Atleta> atletaList = new ArrayList<>(collection);
        Collections.sort(atletaList);

        for (Atleta a:atletaList) {
            if (a.isFinisher()==true){
                System.out.print(a);
            }
        }
    }

    /*
        // primero debemos pasar los valores del mapa a un collection y
        // luego a una lista para poder usar el Collections.sort
     */
    public void mostrarListaCategoria(Categoria categoria){

        Collection<Atleta> collection = atletas.values();
        List<Atleta> atletaList = new ArrayList<>(collection);
        int mumAtleta =0;

        Collections.sort(atletaList, new Comparator<Atleta>() {
            @Override
            public int compare(Atleta a1, Atleta a2) {
                return a1.getMarca()-a2.getMarca();
            }
        });

        for (Atleta a:atletaList) {
            if (a.getCategoria().equals(categoria)){
                System.out.print(a);
                mumAtleta++;
            }
        }

        if (mumAtleta==0){
            System.out.println("no ha atletas en esta categoria.");
        }

    }

    public void mostrarListaPorPais(String pais){

        Collection<Atleta> atletaCollection = atletas.values();
        int mumAtleta =0;

        for (Atleta a: atletaCollection) {
            if (a.getPais().equalsIgnoreCase(pais)){
                mumAtleta++;
            }
        }

        System.out.println("Numero de atletas de "+pais+": "+mumAtleta);
    }

    public void cargarAtletas(){
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("maraton.dat"));

            while (true){
                Atleta a = (Atleta) in.readObject();
                addAtleta(a);
            }
        } catch (IOException e) {
           // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }

    public void guardarAtleta(){

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream("maraton.dat"));
            Collection<Atleta> atletaCollection = atletas.values();

            Iterator<Atleta> it = atletaCollection.iterator();
            while (it.hasNext()){
                Atleta a = (Atleta) it.next();
                for (Atleta atl: atletaCollection) {
                    out.writeObject(atl);
                }
            }
        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
    }
}
