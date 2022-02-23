package com.company.EX_RPG;

public class Enano extends Personaje implements Atacar{

    private Double altura;

    public Enano(String nombre, Integer energia, Integer capAtaque, Integer capDefensa,
                 boolean encantado, Double altura) {
        super(nombre, energia, capAtaque, capDefensa, encantado);
        this.altura=altura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Enano{" + super.toString() +
                "altura=" + altura +
                '}';
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
}
