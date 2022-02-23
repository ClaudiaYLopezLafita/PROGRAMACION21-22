package com.company.T1_Caja;

public class CajaCarton extends Caja {

    private int etiqueta;
    private static double totalCarton =0;


    public CajaCarton(double ancho, double alto, double fondo) {
        super(ancho, alto, fondo, Unidad.CM);
        totalCarton = totalCarton+this.getSuperficie();
    }


    @Override
    public double getVolumen() {
        double d = super.getVolumen();
        return d*0.8*1000000;
    }

    public double getSuperficie() {
        return (super.getAncho()*super.getAlto()*4)+(super.getAlto()*super.getFondo()*2);
    }

    public  void setEtiqueta(int etiqueta){
        this.etiqueta = etiqueta;
    }

    public static double getTotalCarton(){
        return CajaCarton.totalCarton;
    }

    @Override
    public String toString() {
        return "Alto:"+getAlto()+"\'"+
                "Ancho:"+getAncho()+"\'"+
                "Fondo:"+getFondo()+"\'"+
                "Unidad"+getUnidad()+"\n"+
                "Volumen:"+getVolumen()+"\n"+
                "Superficie:"+getSuperficie()+"\n"+
                "Id"+this.etiqueta+"\n";
    }
}
