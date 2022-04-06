package com.company.Ex_RazaPerros;

public class Main {
    public static void main(String[] args) {
        Propietario p1 = new Propietario("Juan", "Lopez","1233456789SFG","España");
        Propietario p2 = new Propietario("Hinata", "Onda","987456321123QWE","Japon");
        Propietario p3 = new Propietario("James", "Smith","963852741ASD","EE.UU");
        Propietario p4 = new Propietario("Emillie", "Poulan","147258399WER","Francia");

        Perro pr1 = new Perro("Lassi", 5, 8.5, true, p1, "Caniche");
        Perro pr2 = new Perro("Lobo", 10, 10.5, false, p3, "Labrador");
        Perro pr3 = new Perro("Atila", 2, 12.5, true, p4, "Doberman");
        Perro pr4 = new Perro("Caniro", 6, 6.5, false, p2, "Doberman");
        Perro pr5 = new Perro("Tortuga", 7, 10.0, true, p3, "Corgi");
        Perro pr6 = new Perro("Kaoru", 1, 5.5, true, p1, "Pomeranean");

        Concurso c = new Concurso("ElPerroMasFeo2022", "Sevilla");

        c.addDog("Caniche", pr1);
        c.addDog("Labrador", pr2);
        c.addDog("Doberman", pr3);
        c.addDog("Doberman", pr4);
        c.addDog("Corgi", pr5);
        c.addDog("Pomeranean", pr6);

        c.ownerDogs("963852741ASD");
    }
}
