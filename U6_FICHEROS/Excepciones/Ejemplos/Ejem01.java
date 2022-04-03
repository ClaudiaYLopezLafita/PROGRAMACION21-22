package com.company.Excepciones.Ejemplos;

public class Ejem01 {
    public static void main(String[] args) {
        int c;
        int a = 1;
        int b = 0;
        try {
            c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Estoy en el artimetco catch");
        } catch (Exception e) {
            System.out.println("Estoy en el general catch");
        }
    }
}
