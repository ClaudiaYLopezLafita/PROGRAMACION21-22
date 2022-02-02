package com.company;

public class Main {

    public static void main(String[] args) {
        Opositor op1 = new Opositor("Pepe", "Lopez", 1995,
                Adaptacion.SI,"Mesa minusvalido");
        Opositor op2 = new Opositor("Maria", "Lara", 1989,
                Adaptacion.NO, "");
        Opositor op3 = new Opositor("Manuel", "Gomez", 1957,
                Adaptacion.NO, "");
        Opositor op4 = new Opositor("Pilar", "Dorado", 1990,
                Adaptacion.SI, "Poca visión, lupa");

        Sede s1 = new Sede("CAD41", Ciudad.CADIZ);
        Sede s2 = new Sede("SEV40", Ciudad.SEVILLA);

        Opciones opc1 = new Opciones("Los gatos ladra", false);
        Opciones opc2 = new Opciones("Los gatos vuelan", false);
        Opciones opc3 = new Opciones("Los gatos arañan", true);
        Opciones opc4 = new Opciones("Los gatos son mejores que los perros", true);
        Opciones opc5 = new Opciones("Los gatos odian el pescado", false);
        Opciones opc6 = new Opciones("Los gatos ronronean", true);

        Preguntas p1 = new Preguntas("¿Cual de las siguientes opcines es verdadera?: ");
        Preguntas p2 = new Preguntas("¿Cual de las siguientes opcines es falsa?: ");

        Examen e1 = new Examen("Medio Ambiente", "www.medioambientegatuno.com");

        /*op1.mostrar_informacion();
        op2.mostrar_informacion();
        op3.mostrar_informacion();
        op4.mostrar_informacion();*/

        s1.addOpositor(op1);
        s1.addOpositor(op2);
        s2.addOpositor(op3);
        s2.addOpositor(op4);
        s2.removeOpositor(op4);

        /*s1.mostrar_informacion();
        System.out.println();
        s2.mostrar_informacion();*/

        p1.addOpcion(opc1);
        p1.addOpcion(opc2);
        p1.addOpcion(opc3);
        p2.addOpcion(opc4);
        p2.addOpcion(opc5);
        p2.addOpcion(opc6);

        p2.removeOpcion(opc5);

        /*p1.mostrar_informacion();
        System.out.println();
        p2.mostrar_informacion();*/

        e1.addPregunta(p1);
        e1.addPregunta(p2);
        e1.addSede(s1);
        e1.addSede(s2);
        e1.removeSede(s2);
        e1.removePregunta(p1);

        e1.mostrar_informacion();

    }
}
