package com.company;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

public class Examen {

    private Calendar fecha;
    private String Consejeria;
    private String URL;
    private Preguntas[] pregunta;
    private Sede[] sede;
    private static Integer maxPreguntas =100;

    public Examen(String consejeria, String URL) {
        this.fecha = Calendar.getInstance();
        Consejeria = consejeria;
        this.URL = URL;
        this.pregunta = new Preguntas[0];
        this.sede = new Sede[0];
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getConsejeria() {
        return Consejeria;
    }

    public void setConsejeria(String consejeria) {
        Consejeria = consejeria;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Preguntas[] getPregunta() {
        return pregunta;
    }

    public void setPregunta(Preguntas[] pregunta) {
        this.pregunta = pregunta;
    }

    public Sede[] getSede() {
        return sede;
    }

    public void setSede(Sede[] sede) {
        this.sede = sede;
    }

    public static Integer getMaxPreguntas() {
        return maxPreguntas;
    }

    public static void setMaxPreguntas(Integer maxPreguntas) {
        Examen.maxPreguntas = maxPreguntas;
    }

    private boolean estaPregunta (Preguntas x){

        for (int i = 0; i < pregunta.length; i++) {
            if (pregunta[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public boolean addPregunta(Preguntas x){

        Preguntas[] result = new Preguntas[0];
        if (!estaPregunta(x) && pregunta.length<maxPreguntas){
            result = Arrays.copyOf(pregunta, pregunta.length+1);
            result[result.length-1]=x;
            pregunta = result;
            return true;
        }
        return false;
    }

    public boolean removePregunta(Preguntas x){
        if (estaPregunta(x)) {
            Preguntas[] resultado = new Preguntas[0];
            for (int i = 0; i < pregunta.length; i++) {
                if (!pregunta[i].equals(x)){
                    resultado = Arrays.copyOf(resultado,resultado.length+1);
                    resultado[resultado.length-1] = pregunta[i];
                    pregunta = resultado;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean estaSede (Sede s){

        for (int i = 0; i < sede.length; i++) {
            if (sede[i].equals(s)){
                return true;
            }
        }
        return false;
    }

    public boolean addSede(Sede s){
        Sede[] result = new Sede[0];

        if (!estaSede(s)){
            result = Arrays.copyOf(sede, sede.length+1);
            result[result.length-1]=s;
            sede = result;
            return true;
        }
        return false;
    }

    public boolean removeSede(Sede s){
        if (estaSede(s)) {
            Sede[] resultado = new Sede[0];
            for (int i = 0; i < sede.length; i++) {
                if (!sede[i].equals(s)){
                    resultado = Arrays.copyOf(resultado,resultado.length+1);
                    resultado[resultado.length-1] = sede[i];
                    sede = resultado;
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
        return "Examen{" +
                "fecha=" + fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+
                fecha.get(Calendar.YEAR)+" "+fecha.get(Calendar.HOUR_OF_DAY)+":"+
                fecha.get(Calendar.MINUTE) +
                ", Consejeria='" + Consejeria + '\'' +
                ", URL='" + URL + '\n' +
                " "+" \n" +
                "pregunta=" + Arrays.toString(pregunta) + ", \n"+
                " "+" \n" +
                "sede=" + Arrays.toString(sede) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examen examen = (Examen) o;
        return Objects.equals(fecha, examen.fecha) && Objects.equals(Consejeria, examen.Consejeria) && Objects.equals(URL, examen.URL) && Arrays.equals(pregunta, examen.pregunta) && Arrays.equals(sede, examen.sede);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fecha, Consejeria, URL);
        result = 31 * result + Arrays.hashCode(pregunta);
        result = 31 * result + Arrays.hashCode(sede);
        return result;
    }
}
