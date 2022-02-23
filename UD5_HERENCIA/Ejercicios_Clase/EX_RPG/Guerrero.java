package com.company.EX_RPG;

public class Guerrero extends Hombres implements Atacar{

    private int edad;

    public Guerrero(String nombre, Integer energia, Integer capAtaque, Integer capDefensa,
                    boolean encantado, int edad) {
        super(nombre, energia, capAtaque, capDefensa, encantado);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void atacarPersonaje(Personaje p) {

        if (!this.getClass().equals(p.getClass())){

            int daño = (this.getCapAtaque()-p.getCapDefensa());
            p.setEnergia(p.getEnergia()-daño);

            System.out.println(this.getNombre()+"-AL ATAQUEEE!!!");

        } else {
            System.out.println("No ataco a los de mi clase");
        }

    }

    @Override
    public String toString() {
        return super.toString() +
                "edad=" + edad +
                '\n';
    }
}
