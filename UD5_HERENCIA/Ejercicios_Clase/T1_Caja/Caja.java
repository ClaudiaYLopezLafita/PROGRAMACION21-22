package com.company.T1_Caja;
/*
Las empresas de transportes, para evitar daños en los paquetes, embalan todas sus mercancías
en cajas con el tamaño adecuado. Una caja se crea expresamente con un ancho, un alto y un fondo y,
una vez creada, se mantiene inmutable. Cada caja lleva pegada una etiqueta con información útil como
el nombre del destinatario, dirección, etc. Se pide implementar la clase Caja con constructor:

Caja(double ancho, double alto, double fondo, Unidades u): que construye una caja con las
dimensiones especificadas, que pueden encontrarse en "cm" (centímetros) o en "m" (metros)

y métodos:

double getVolumen(): que devuelve el volumen de la caja en metros cúbicos
String toString(): que devuelva una cadena con la representación de la caja.
 */

public class Caja {

    private double ancho;
    private double alto;
    private double fondo;
    private Unidad unidad;
    private Etiqueta etiqueta;


    public Caja(double ancho, double alto, double fondo, Unidad unidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.unidad = unidad;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    public double getFondo() {
        return fondo;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public double getVolumen(){

        if (unidad == Unidad.M){
            return alto*ancho*fondo;
        } else {
            return (alto*ancho*fondo)/1000000;
        }
    }

    @Override
    public String toString() {
        return "Caja{" +
                "ancho=" + ancho +
                ", alto=" + alto +
                ", fondo=" + fondo +
                ", unidad=" + unidad +
                ", etiqueta=" + etiqueta.toString() +
                '}';
    }
}
