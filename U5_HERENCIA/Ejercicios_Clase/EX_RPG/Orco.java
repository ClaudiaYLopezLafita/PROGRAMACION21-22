package com.company.EX_RPG;

import java.util.Objects;

public class Orco extends Personaje implements Atacar{

    private Double tonelaje;

    public Orco(String nombre, Integer energia, Integer capAtaque, Integer capDefensa,
                boolean encantado, Double tonelaje) {
        super(nombre, energia, capAtaque, capDefensa, encantado);
        this.tonelaje=tonelaje;
    }

    public Double getTonelaje() {
        return tonelaje;
    }

    public void setTonelaje(Double tonelaje) {
        this.tonelaje = tonelaje;
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
        return "Orco{" + super.toString() +
                "tonelaje=" + tonelaje +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Orco orco = (Orco) o;
        return tonelaje.equals(orco.tonelaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tonelaje);
    }
}
