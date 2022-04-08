package com.company.EX_Coronavirus;

import com.company.Ex_RazaPerros.Perro;

import java.io.*;
import java.util.*;

public class Coronavirus {

    private String nombre;
    private  String localidad;
    private Map<String, Set<Paciente>> infectados;

    public Coronavirus() {
        this.nombre = "COVID-19";
        this.localidad = "WUHAN";
        this.infectados = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public Map<String, Set<Paciente>> getInfectados() {
        return infectados;
    }

    public void setInfectados(Map<String, Set<Paciente>> infectados) {
        this.infectados = infectados;
    }

    public void addPaciente(String cepa, Paciente paciente){

        if (paciente.getCepa().equals(cepa)){
            if (!infectados.containsKey(cepa)){
                infectados.put(cepa,new TreeSet<>());
            }
            infectados.get(cepa).add(paciente);
        }else {
            System.out.println("La cepa de este paciente no coincide");
        }
    }

    public boolean darDeAltaPaciente(Paciente paciente){

        if (!infectados.containsKey(paciente.getCepa())){
            System.out.println("Esta cepa no existe");
            return false;
        }else{
            if (infectados.get(paciente.getCepa()).contains(paciente)){
                return infectados.get(paciente.getCepa()).remove(paciente);
            }else {
                System.out.println("Este paciente no está infectado");
                return false;
            }
        }
    }

    public void pacientesDeUnDoctor(Integer numColegiado){

        Integer cantidadPacientes=0;
        Collection<Set<Paciente>> setCollection= infectados.values();
        //devuelve set de pacientes clasificados por cepas(key del mapa).
        Iterator it = setCollection.iterator();
        System.out.println("Lista del pacientes del médico "+ numColegiado);
        while (it.hasNext()){
            Set<Paciente> pacientes = (Set<Paciente>) it.next();
            for (Paciente pc: pacientes) {
                if (pc.getMedico().getNumColegiado().equals(numColegiado)){
                    System.out.print(pc);
                    cantidadPacientes++;
                }
            }
        }

        if (cantidadPacientes ==0){
            System.out.println("El medico no tiene pacientes a su cargo.");
        }
    }

    public void pacientesPorPeso(String cepa){

        if (infectados.containsKey(cepa)){
            List<Paciente> pacienteList = new ArrayList<>(infectados.get(cepa));
            Collections.sort(pacienteList, new Comparator<Paciente>() {
                @Override
                public int compare(Paciente p1, Paciente p2) {
                    return p1.compareTo(p2);
                }
            });
            System.out.println(pacienteList);
        }else {
            System.out.println("La cepa no existe");
        }
    }

    public void pacientesPorEdad(String cepa){

        if (infectados.containsKey(cepa)){
            System.out.println(infectados.get(cepa));
        } else {
            System.out.println("La cepa no existe");
        }
    }

    public void cargarPacientes(){

        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("pacientes.dat"));

            while (true){
                Paciente p = (Paciente) in.readObject();
                addPaciente(p.getCepa(),p);
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

    public void guardarPacientes(){
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream("pacientes.dat"));
            Collection <Set<Paciente>> pcs = infectados.values();

            Iterator it = pcs.iterator();
            while (it.hasNext()){
                Set<Paciente> pacienteSet = (Set<Paciente>) it.next();
                for (Paciente p:pacienteSet) {
                    out.writeObject(p);
                }
            }
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

    @Override
    public String toString() {
        return "Coronavirus{" +
                "nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", infectados=" + infectados +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coronavirus that = (Coronavirus) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(localidad, that.localidad) && Objects.equals(infectados, that.infectados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, localidad, infectados);
    }
}
