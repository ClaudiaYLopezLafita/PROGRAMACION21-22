package com.company;

import java.io.*;
import java.util.*;

public class Sae {
    Map<Integer, Oferta> ofertas;

    public Sae() {
        this.ofertas = new HashMap<>();
    }

    public Map<Integer, Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(Map<Integer, Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public boolean addOferta(Oferta o){
        if (!ofertas.containsKey(o.getCodigo())){
            ofertas.put(o.getCodigo(),o);
            return true;
        }
        return false;
    }

    public boolean addTrabajador(Integer codigo, Trabajador t){
        if (ofertas.containsKey(codigo)) {
            if (!ofertas.get(codigo).getTrabajadors().contains(t)){
                ofertas.get(codigo).getTrabajadors().add(t);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean removeTrabajador(Integer codigo, Trabajador t){
        if (ofertas.containsKey(codigo)) {
            if (ofertas.get(codigo).getTrabajadors().contains(t)){
                ofertas.get(codigo).getTrabajadors().remove(t);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public  void mostrarTrabajadores(Integer codigo){
        Oferta aux = ofertas.get(codigo);
        Integer numTrabajadores=0;

        List<Trabajador> trabajadors = new ArrayList<>();

        Iterator it = aux.getTrabajadors().iterator();

        while (it.hasNext()){
            Trabajador t = (Trabajador) it.next();
            trabajadors.add(t);
            numTrabajadores++;
        }

        Collections.sort(trabajadors);
        if (numTrabajadores==0){
            System.out.println("No hay trabajadores inscrito en la oferta "+codigo);
        }else {
            System.out.println("Trabajadores de la oferta " + codigo + ": " + '\n' + trabajadors);
        }
    }

    public void mostrarTrabajadoresXEdad(Integer codigo){

        Oferta aux = ofertas.get(codigo);
        Integer numTrabajadores=0;

        List<Trabajador> trabajadors = new ArrayList<>();

        Iterator it = aux.getTrabajadors().iterator();

        while (it.hasNext()){
            Trabajador t = (Trabajador) it.next();
            trabajadors.add(t);
            numTrabajadores++;
        }

        Collections.sort(trabajadors, new Comparator<Trabajador>() {
            @Override
            public int compare(Trabajador t1, Trabajador t2) {
                if(t1.getEdad()==t2.getEdad()){
                    return t1.getNombre().compareTo(t2.getNombre());
                }
                return t1.getEdad().compareTo(t2.getEdad());
            }
        });
        if (numTrabajadores==0){
            System.out.println("No hay trabajadores inscrito en la oferta "+codigo);
        }else {
            System.out.println("Trabajadores de la oferta " + codigo + ": " + '\n' + trabajadors);
        }
    }

    public int cantidadOfertas(String dni){
        int cantidad =0;

        Collection<Oferta> ofertaCollection = ofertas.values();

        Iterator it = ofertaCollection.iterator();
        while (it.hasNext()){
            Oferta oferta = (Oferta) it.next();
            for (Trabajador t:oferta.getTrabajadors()) {
                if (t.getDni().equals(dni)){
                    cantidad++;
                }
            }
        }

        return cantidad;
    }

    public void mostrarOfertas(){

        List<Oferta> list = new ArrayList<>(ofertas.values());

        Collections.sort(list, new Comparator<Oferta>() {
            @Override
            public int compare(Oferta o1, Oferta o2) {
                return o2.getTrabajadors().size()-o1.getTrabajadors().size();
            }
        });

        for (Oferta o:list) {
            System.out.println(o.getCodigo()+" -- "+o.getDescripcion()+" -- "+o.isCubierto());
        }

    }

    public void cargarDatos(){
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("sae.dat"));

            while (true){
                Oferta o = (Oferta) ois.readObject();
                ofertas.put(o.getCodigo(),o);
            }

        } catch (Exception e) {

        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (Exception e) {

                }
            }
        }
    }

    public void guardarDatos(){
        ObjectOutputStream oos =null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("sae.dat"));
            Collection<Oferta> ofertaCollections = ofertas.values();

            Iterator it = ofertaCollections.iterator();
            while (it.hasNext()){
                Oferta oferta = (Oferta) it.next();
                oos.writeObject(oferta);
            }
        } catch (Exception e) {

        }finally {
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Sae --> " +
                "Ofertas:" + ofertas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sae sae = (Sae) o;
        return Objects.equals(ofertas, sae.ofertas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ofertas);
    }
}
