package com.company;

public class Romancero extends Agrupacion implements Callejear{

    private String tematicaCartelon;

    public Romancero(String nombre, String autor, String autorMusica, String autorLetra,
                     String tipoDisfraz, String tematicaCartelon) {
        super(nombre, autor, autorMusica, autorLetra, tipoDisfraz);
        this.tematicaCartelon=tematicaCartelon;
    }

    public String getTematicaCartelon() {
        return tematicaCartelon;
    }

    public void setTematicaCartelon(String tematicaCartelon) {
        this.tematicaCartelon = tematicaCartelon;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tematicaCartelon='" + tematicaCartelon + '\'' +
                '}' + '\n';
    }

    @Override
    public void cantar_la_presentacion() {
        System.out.println("Cantando la presentacion del Romcancero con nombre "+getNombre());
    }

    @Override
    public void hacer_tipo() {
        System.out.println("El Romancero "+getNombre()+" va de "+getTipoDisfraz());
    }

    @Override
    public void amo_a_escucha() {
        System.out.println("Amo a escuha la Chirigota "+getNombre());
    }
}
