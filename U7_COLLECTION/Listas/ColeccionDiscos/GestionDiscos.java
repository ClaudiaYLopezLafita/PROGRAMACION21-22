package com.company.Listas.ColeccionDiscos;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionDiscos {

    ArrayList<Disco> album = new ArrayList<Disco>();

    public GestionDiscos() {
        this.album = new ArrayList<>();
    }

    public void listadoCompleto(){
        for(Disco d : album) {
            System.out.println(d);
        }
    }

    public void listadoAutor(String autorIntroducido){
        for(Disco d : album) {
            if(d.getAutor().equals(autorIntroducido)) {
                System.out.println(d);
            }
        }
    }

    public void listadoGenero(String generoIntroducido){
        for(Disco d : album) {
            if(d.getGenero().equals(generoIntroducido)) {
                System.out.println(d);
            }
        }
    }

    public void listadoDuracion(int limiteSuperior, int limiteInferior){
        for(Disco d : album) {
            if((d.getDuracion() <= limiteSuperior) && (d.getDuracion() >= limiteInferior)){
                System.out.println(d);
            }
        }
    }

    public void addDisco(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduzca los datos del disco.");
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        while (album.contains(new Disco(codigo,"", "", "", 0))) {
            System.out.println("Ese código ya existe en la base de datos.");
            System.out.print("Introduzca otro código: ");
            codigo = sc.nextLine();
        }

        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Género: ");
        String genero = sc.nextLine();
        System.out.print("Duración: ");
        int duracion = sc.nextInt();

        album.add(new Disco(codigo, autor, titulo, genero, duracion));
    }

    public void modificarDisco(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, introduzca el código del disco: ");
        String codigo = sc.nextLine();

        while (!album.contains(new Disco(codigo,"", "", "", 0))) {
            System.out.print("Ese código no existe.\nIntroduzca otro código: ");
            codigo = sc.nextLine();
        }
        int i = album.indexOf(new Disco(codigo, "", "", "", 0));

        System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
                System.out.println("Código: " + album.get(i).getCodigo());
        System.out.print("Nuevo código: ");
        codigo = sc.nextLine();

        if (!codigo.equals("")) {
            album.get(i).setCodigo(codigo);
        }

        System.out.println("Autor: " + album.get(i).getAutor());
        System.out.print("Nuevo autor: ");
        String autor = sc.nextLine();

        if (!autor.equals("")) {
            album.get(i).setAutor(autor);
        }

        System.out.println("Título: " + album.get(i).getTitulo());
        System.out.print("Nuevo título: ");
        String titulo = sc.nextLine();

        if (!titulo.equals("")) {
            album.get(i).setTitulo(titulo );
        }

        System.out.println("Género: " + album.get(i).getGenero());
        System.out.print("Nuevo género: ");
       String genero  = sc.nextLine();

        if (!genero.equals("")) {
            album.get(i).setGenero(genero);
        }

        System.out.println("Duración: " + album.get(i).getDuracion());
        System.out.print("Duración: ");
        int duracion= sc.nextInt();
        if (duracion!=0) {
            album.get(i).setDuracion(duracion);
        }

    }

    public void borrarDisco(String codigo){
        if (!album.contains(new Disco(codigo,"", "", "", 0))) {
            System.out.println("Lo siento, el código introducido no existe.");
        } else {
            album.remove(album.indexOf(new Disco(codigo,"", "", "", 0)));
            System.out.println("Album borrado.");
        }
    }

}
