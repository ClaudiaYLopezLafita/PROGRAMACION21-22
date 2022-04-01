package com.company.Maps.Tarea4;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Empleado> empleados= new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String opcion="";

        cargarDatos(empleados);

        do {
            menuOpciones();
            System.out.println("Introduce la opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    visualizarEmpleados(empleados);
                    break;
                case "2":
                    borrarEmpleados(empleados);
                    break;
                case "3":
                    visualizarEpleado(empleados);
                    break;
                case "4":
                    modificarEmpleado(empleados);
                    break;
                case "5":
                    Empleado e = crearEmpleado();
                    empleados.put(e.getDni(), e);
                    break;
                case "6":
                    guardarEmpleado(empleados);
                    System.out.println(empleados);
                    break;
                default:
                    System.out.println("opcion incorrecta");

            }
        } while (!opcion.equalsIgnoreCase("6"));

    }

    private static void menuOpciones(){
        System.out.println("1. Visualizar empleados.");
        System.out.println("2. Borrar empleado/s.");
        System.out.println("3. Visualizar empleado");
        System.out.println("4. Modificar empleado");
        System.out.println("5. Insertar Empleado. ");
        System.out.println("6. NO hacer nada.");
    }

    private static Empleado crearEmpleado(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el nombre");
        String name = sc.nextLine();
        System.out.println("Escribe el Dni");
        String dni = sc.nextLine();
        System.out.println("Escribe el edad");
        Integer age = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el altura");
        Double tall = sc.nextDouble();
        System.out.println("Escribe el sueldo");
        sc.nextLine();
        Double salary = sc.nextDouble();
        System.out.println();

        return new Empleado(name, dni, age, tall, salary);

    }

    private static void guardarEmpleado(Map<String,Empleado> empleados){
// Este método escribe en el flujo de salida todo lo necesario para reconstruir dichos objetos: La clase del objeto
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Empleado.dat"));

            Collection<Empleado> lista = empleados.values();
            for(Empleado e : lista) {
                oos.writeObject(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void cargarDatos(Map<String, Empleado> empleados){
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Empleado.dat"));
            while (true){
                Empleado e = (Empleado) in.readObject();
                empleados.put(e.getDni(),e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void visualizarEmpleados(Map<String, Empleado> empleados){

        Collection<Empleado> result = empleados.values();

        Iterator it = result.iterator();
        while (it.hasNext()){
            Empleado e = (Empleado) it.next();
            // e es un objeto que contiene la clave y el valor
            System.out.println(e);
        }

    }

    public static void borrarEmpleados(Map<String, Empleado> empleados){
        Scanner sc = new Scanner(System.in);
        String answer = "";

        do {
            System.out.println("Introduce un DNI: ");
            answer = sc.nextLine();
            if (empleados.containsKey(answer)){
                empleados.remove(answer);
            }else if (!answer.equalsIgnoreCase("fin")){
                System.out.println("El empleado no existe.");
            }
        }while (!answer.equalsIgnoreCase("fin"));
    }

    public static void visualizarEpleado(Map<String, Empleado> empleados){
        Scanner sc = new Scanner(System.in);
        String answer = "";

        System.out.println("Indica el DNI del empleado: ");
        answer= sc.nextLine();

        if (empleados.containsKey(answer)){
           System.out.println(empleados.get(answer));
        } else {
            System.out.println("El empleado no existe.");
        }
    }

    public static void modificarEmpleado(Map<String, Empleado> empleados){
        Scanner sc = new Scanner(System.in);
        String answer = "";

        System.out.println("Indica el DNI del empleado: ");
        answer= sc.nextLine();

        if (empleados.containsKey(answer)){
           System.out.println("Introduce en nuevo nombre");
           String name = sc.nextLine();
           System.out.println();
           System.out.println("Introduce en nuevo edad");
           Integer age = sc.nextInt();
           System.out.println("Introduce en nuevo altura");
           Double tall = sc.nextDouble();
           System.out.println("Introduce en nuevo salario");
           Double salary = sc.nextDouble();

           Empleado e = new Empleado(name,answer,age,tall,salary);
           empleados.put(answer,e);

        } else{
                System.out.println("El empleado no existe.");
        }

    }
}
