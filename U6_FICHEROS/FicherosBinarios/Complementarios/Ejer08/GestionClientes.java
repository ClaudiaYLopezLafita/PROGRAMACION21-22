package com.company.FicherosBinarios.Complementarios.Ejer08;
// Clase para gestionar a los clientes

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class GestionClientes {

    private Cliente[] clientes;
    static final String nombreFichero = "clientes.dat";

    public GestionClientes() {
        this.clientes = new Cliente[0];
    }

    public void cargarDatos(){
        ObjectInputStream in = null;
        this.clientes = new Cliente[0];

        try {
            in = new ObjectInputStream(new FileInputStream(nombreFichero));
            clientes = (Cliente[]) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void insertarCliente(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre completo:");
        String name = sc.nextLine();
        System.out.println("Telefono: ");
        String telefono = sc.nextLine();
        System.out.println();
        System.out.println("Identidicador: ");
        int id = sc.nextInt();

        clientes = Arrays.copyOf(clientes, clientes.length+1);
        clientes[clientes.length-1]=new Cliente(id, name, telefono);
    }

    public void modificarCliente(int id){
        Scanner sc = new Scanner(System.in);

        int pos = buscaId(id);

        if (pos==-1){
            System.out.println("El cliente no existe");
        } else  {
            Cliente clienteMod= clientes[pos];
            System.out.println("Introduzca datos del cliente");
            System.out.println("nombre: ");
            clienteMod.setNombre(sc.nextLine());
            System.out.println("telefono: ");
            clienteMod.setTelefono(sc.nextLine());

        }
    }

    public  void eliminarCliente(int id){
        int pos=buscaId(id);

        if (pos==-1){
            System.out.println("El cliente no existe");
        } else {
            clientes[pos]=clientes[clientes.length-1];
            clientes=Arrays.copyOf(clientes,clientes.length-1);
        }
    }

    public void listarClientes(){
        System.out.println(Arrays.toString(clientes));
    }

    private int buscaId (int id){
        int pos =0;
        while (pos<clientes.length && id!=clientes[pos].getId()) {
            pos++;
        }
        if (pos==clientes.length){
            pos=-1;
        }
        return pos;
    }

    public void salvaDatos(){
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(nombreFichero));
            out.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
