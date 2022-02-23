package com.company.EX_RPG;

public class Personaje implements Comparable{

    private String nombre;
    private Integer energia;
    private Integer capAtaque;
    private Integer capDefensa;
    private boolean encantado;

    public Personaje(String nombre, Integer energia, Integer capAtaque, Integer capDefensa, boolean encantado) {
        this.nombre = nombre;

        if (energia<0 ||energia>100){
            this.energia=50;
        } else {
            this.energia = energia;
        }

        if (capAtaque<0 || capAtaque>100){
            this.capAtaque=50;
        } else {
            this.capAtaque = capAtaque;
        }

        if (capDefensa<0 || capDefensa>100){
            this.capDefensa=50;
        }else {
            this.capDefensa = capDefensa;
        }

        this.encantado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getCapAtaque() {
        return capAtaque;
    }

    public void setCapAtaque(Integer capAtaque) {
        this.capAtaque = capAtaque;
    }

    public Integer getCapDefensa() {
        return capDefensa;
    }

    public void setCapDefensa(Integer capDefensa) {
        this.capDefensa = capDefensa;
    }

    public boolean isEncantado() {
        return encantado;
    }

    public void setEncantado(boolean encantado) {
        this.encantado = encantado;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                ", capAtaque=" + capAtaque +
                ", capDefensa=" + capDefensa +
                ", encantado=" + encantado +
                '\n';
    }

    @Override
    public int compareTo(Object o) {
        return getEnergia()- ((Personaje) o).getEnergia();
    }

}
