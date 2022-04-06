package com.company.Ex_RazaPerros;

import com.company.Maps.Tarea4.Empleado;

import java.io.*;
import java.util.*;

public class Concurso implements Serializable {

    private String nombre;
    private String localidad;
    private Map<String, Set<Perro>> perros;

    public Concurso(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.perros = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void addDog(String raza, Perro perro){

        if(perro.getRaza().equals(raza)){
            if (!perros.containsKey(raza)){
                perros.put(raza, new TreeSet<>());
            }
            perros.get(raza).add(perro);
        } else {
            System.out.println("EL perro no es de la misma raza donde se quiere inscribir");
        }

    }

    public boolean disqualifyDog(Perro perro) {

        if (!perros.containsKey(perro.getRaza())){
            System.out.println("No existe esta raza");
            return false;
        } else {
            if (perros.get(perro.getRaza()).contains(perro)) {
                return perros.get(perro.getRaza()).remove(perro);
            }else {
                System.out.println("El pero no está inscrito");
                return false;
            }
        }

    }

    public void ownerDogs(String nss){

        Collection<Set<Perro>> collectionSet = perros.values();
        int contadorPerro =0;

        Iterator it = collectionSet.iterator();
        System.out.println("Perro del propietario "+nss);
        while (it.hasNext()){
            Set<Perro> p = (Set<Perro>) it.next();
            for (Perro perro: p) {
                if (perro.getPropietario().getNss().equals(nss)){
                    System.out.println(perro);
                    contadorPerro++;
                }
            }
        }
        if(contadorPerro==0){
            System.out.println("No hay perro para este propietario");
        }
    }

    public void perrosporPeso(String raza){
        if (perros.containsKey(raza)){
            // creamos una nueva lista con todos los perros de una raza (un conjunto)
            List<Perro> perroList = new ArrayList<>(perros.get(raza));
            Collections.sort(perroList, new Comparator<Perro>() {
                @Override
                public int compare(Perro p1, Perro p2) {
                    return p2.compareTo(p1);
                }
            });

            System.out.println(perroList);
        }else {
            System.out.println("La raza no existe");
        }
    }

    public void perrosporEdad(String raza){

        if (perros.containsKey(raza)){
            System.out.println(perros.get(raza));
        } else {
            System.out.println("La raza no existe");
        }
    }

    public void cargarDatos(){
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("perros.dat"));

            while (true){
               Perro p = (Perro) in.readObject();
               addDog(p.getRaza(),p);
            }
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void guardarPerros(){
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("perros.dat"));
            Collection<Set<Perro>> conjunto = perros.values();

            Iterator it = conjunto.iterator();

            while (it.hasNext()) {
                Set<Perro> dogs = (Set<Perro>) it.next();

                for (Perro p : dogs) {
                    oos.writeObject(p);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Concurso{" +
                "nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", perros=" + perros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concurso concurso = (Concurso) o;
        return Objects.equals(nombre, concurso.nombre) && Objects.equals(localidad, concurso.localidad) && Objects.equals(perros, concurso.perros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, localidad, perros);
    }

}
