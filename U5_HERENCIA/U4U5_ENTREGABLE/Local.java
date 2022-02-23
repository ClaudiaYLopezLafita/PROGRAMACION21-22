package com.company;

public abstract class Local extends Propiedad {

    private Persona propietario;
    private Double precio;


    public Local(Integer year, String direccion, Double superficie, Persona propietario, Double precio) {
        super(year, direccion, superficie);
        this.propietario = propietario;
        this.precio = precio;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString() +
                "propietario=" + propietario +
                "precio= "+precio;
    }
}
