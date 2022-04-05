package com.company;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Alumno> alumnos = new HashMap<>();
        Set<Alumno> alumnoSet = new TreeSet<>();
        String opcion ="";

        cargarDatos(alumnos, alumnoSet);

        do {
            mostrarOpciones();
            System.out.println("Elija un opcion");
            opcion=sc.nextLine();

            switch (opcion){
                case "1":
                    Alumno a = crearAlumno();
                    insertarAlumno(a, alumnos, alumnoSet);
                    break;
                case "2":
                    borrarAlumno(alumnos,alumnoSet);
                    break;
                case "3":
                    mostrarAlumnos(alumnoSet);
                    break;
                case "4":
                    mostrarAlumnosCurso(alumnoSet);
                    break;
                case "5":
                    modificarAlumno(alumnos, alumnoSet);
                    break;
                case "6":
                    guardarDatos(alumnos);
                    System.out.println(alumnos.values());
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        }while (!opcion.equals("6"));
    }

    public static void mostrarOpciones(){
        System.out.println("1. Insertar Almumno");
        System.out.println("2. Borrar Alumno");
        System.out.println("3. Mostrar alumnos");
        System.out.println("4. Mostrar alumnos de un curso");
        System.out.println("5. Modificar alumnos");
        System.out.println("6. Salir");
    }

    public  static void cargarDatos(Map<String, Alumno> alumnos, Set<Alumno> alumnoSet){

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Alumnos.dat"));

            try {
                while (true){
                    Alumno a = (Alumno) in.readObject(); // tranformanos cada objeto leido al de interes
                    alumnos.put(a.getDni(),a); // introducimos el clave y el valor en el mapa
                    alumnoSet.add(a);
                }
            } catch(EOFException e) {
               // System.out.println("Fin de fichero");
            }

        } catch (Exception e) {
            // e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }

    public static Alumno crearAlumno(){
        Scanner sc = new Scanner(System.in);

        String name, apellido,direccion,dni,email,curso,dual;

        System.out.println("Nombre:");
        name = sc.nextLine();
        System.out.println("Apellidos:");
        apellido = sc.nextLine();
        System.out.println("Direccion:");
        direccion = sc.nextLine();
        System.out.println("Dni:");
        dni = sc.nextLine();
        System.out.println("Email:");
        email = sc.nextLine();
        System.out.println("Curso:");
        curso = sc.nextLine();
        System.out.println("¿Dual?");
        dual = sc.nextLine();
        sc.nextLine();

        return new Alumno(name, apellido, direccion, dni, email, curso,dual);
    }

    public static void insertarAlumno (Alumno a,Map<String, Alumno> alumnos, Set<Alumno> alumnoSet ){

        if (!alumnos.containsKey(a.getDni())){
            alumnos.put(a.getDni(), a);
        } else {
            System.out.println("El alumno ya existe");
        }

        if (!alumnoSet.contains(a)) {
            alumnoSet.add(a);
        } else {
            System.out.println("EL alumno ya existe");
        }
    }

    public static void borrarAlumno(Map<String, Alumno> alumnos, Set<Alumno> alumnoSet){

        Scanner sc = new Scanner(System.in);
        String dni = "";

        System.out.println("Introduce un DNI: ");
        dni = sc.nextLine();

        Iterator<Alumno> it = alumnoSet.iterator();
        while (it.hasNext()){
            Alumno a = it.next();
            if (a.getDni().equals(dni)){
                alumnoSet.remove(a);
            }
        }

        if (alumnos.containsKey(dni)){
              alumnos.remove(dni);
        }else if (!dni.equalsIgnoreCase("fin")){
             System.out.println("El alumno no existe.");
        }
    }

    public static void mostrarAlumnos(Set<Alumno> alumnoSet){

        Iterator<Alumno> it = alumnoSet.iterator();
        while (it.hasNext()) {
            Alumno a = it.next();
            System.out.println(a);
        }
    }

    public static  void mostrarAlumnosCurso(Set<Alumno> alumnoSet){
        Scanner sc = new Scanner(System.in);
        int cantidadAlumno=0;

        System.out.println("Introduce un curso:");
        String curso = sc.nextLine();

        Iterator<Alumno> it = alumnoSet.iterator();
        while (it.hasNext()){
            Alumno a = it.next();
            if (a.getCurso().equals(curso)){
                System.out.println(a);
                cantidadAlumno++;
            }

            if (cantidadAlumno==0){
                System.out.println("No hay alumnos en el Curso");
            }
        }

    }

    public static void modificarAlumno(Map<String, Alumno> alumnos, Set<Alumno> alumnoSet){

        Scanner sc = new Scanner(System.in);
        String dni = "";

        System.out.println("Indica el DNI del alumno: ");
        dni= sc.nextLine();

        if (alumnos.containsKey(dni)){
            System.out.println("Nombre:");
            String name = sc.nextLine();
            System.out.println("Apellido:");
            String apellido = sc.nextLine();
            System.out.println("Direccion");
            String direccion = sc.nextLine();
            System.out.println("Email");
            String email = sc.nextLine();
            System.out.println("Curso:");
            String curso = sc.nextLine();
            System.out.println("¿Dual?");
            String dual = sc.nextLine();

            Alumno a = new Alumno(name, apellido, direccion, dni,email, curso, dual);
            alumnos.put(dni,a);

            Iterator<Alumno> it = alumnoSet.iterator();
            while (it.hasNext()){
                Alumno a2 = it.next();
                if (a2.getDni().equals(dni)){
                    a2.setNombre(name);
                    a2.setApellidos(apellido);
                    a2.setDireccion(direccion);
                    a2.setEmail(email);
                    a2.setCurso(curso);
                    a2.setDual(dual);
                }
            }

        } else{
            System.out.println("El empleado no existe.");
        }

    }

    public static void  guardarDatos(Map<String, Alumno> alumnos){
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Alumnos.dat"));

            Collection<Alumno> lista = alumnos.values();
            for(Alumno a : lista) {
                oos.writeObject(a);
            }
        } catch (IOException e) {
           // e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
               // e.printStackTrace();
            }
        }
    }
}
