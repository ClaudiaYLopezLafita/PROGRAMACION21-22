package com.company;

import java.util.Arrays;

public class Sede {

    private String codSede;
    private Ciudad ciudad;
    private Opositor[] opositors;

    public Sede(String codSede, Ciudad ciudad) {
        this.codSede = codSede;
        this.ciudad = ciudad;
        this.opositors = new Opositor[0];
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Opositor[] getOpositors() {
        return opositors;
    }

    public void setOpositors(Opositor[] opositors) {
        this.opositors = opositors;
    }


    public boolean addOpositor(Opositor x){

        Opositor[] result = new Opositor[0];
        if (!estaOpositosr(x)){
            result = Arrays.copyOf(opositors, opositors.length+1);
            result[result.length-1]=x;
            opositors = result;
            return true;
        }
        return false;
    }

    private boolean estaOpositosr (Opositor x){

        for (int i = 0; i < opositors.length; i++) {
            if (opositors[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public boolean removeOpositor(Opositor x){
        if (estaOpositosr(x)) {
            Opositor[] resultado = new Opositor[0];
            for (int i = 0; i < opositors.length; i++) {
                if (!opositors[i].equals(x)){
                    resultado = Arrays.copyOf(resultado,resultado.length+1);
                    resultado[resultado.length-1] = opositors[i];
                    opositors = resultado;
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrar_informacion(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Sede{" +
                "codSede='" + codSede + '\'' +
                ", ciudad=" + ciudad + ", \n" +
                "opositors=" + Arrays.toString(opositors) +
                '}';
    }

}
