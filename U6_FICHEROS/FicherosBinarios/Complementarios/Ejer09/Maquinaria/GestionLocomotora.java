package com.company.FicherosBinarios.Complementarios.Ejer09.Maquinaria;

import com.company.FicherosBinarios.Complementarios.Ejer09.Personal.Especialidad;
import com.company.FicherosBinarios.Complementarios.Ejer09.Personal.Mecanico;

import java.util.Arrays;
import java.util.Scanner;

public class GestionLocomotora {

    Locomotora[] locomotoras;

    public GestionLocomotora(Locomotora[] locomotoras) {
        this.locomotoras = locomotoras;
    }

    public void altaLocomotora(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre Mecanico");
        Mecanico mecanico;
        System.out.println("Matricula:");
        String matricula = sc.nextLine();
        System.out.println("potencia: ");
        Double potencia = sc.nextDouble();
        System.out.println();
        System.out.println("Año: ");
        int year = sc.nextInt();


        locomotoras = Arrays.copyOf(locomotoras, locomotoras.length+1);
        locomotoras[locomotoras.length-1]=new Locomotora(matricula,potencia,year, crearMecanico());
    }

    public Mecanico crearMecanico(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica nombre");
        String name = sc.nextLine();
        System.out.println("Indica telefono");
        String tlf = sc.nextLine();
        System.out.println("Indica Especialidad");
        Especialidad esp=Especialidad.OTROS;
        int opconEsp = sc.nextInt();

        if (opconEsp==1){
            esp = Especialidad.HIDRAULICA;
        } else if(opconEsp==2){
            esp=Especialidad.ELECTRICA;
        } else if(opconEsp==3){
            esp=Especialidad.FRENOS;
        } else if(opconEsp==2){
            esp=Especialidad.OTROS;
        }

        return new Mecanico(name,tlf,esp);
    }
}
