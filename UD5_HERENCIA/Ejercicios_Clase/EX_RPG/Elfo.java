package com.company.EX_RPG;

public class Elfo extends Personaje implements Atacar{

    private Tipo tipo;


    public Elfo(String nombre, Integer energia, Integer capAtaque, Integer capDefensa,
                boolean encantado, Tipo tipo) {

        super(nombre, energia, capAtaque, capDefensa, encantado);
        this.tipo=tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
                "tipo=" + tipo +
                '}';
    }

}
