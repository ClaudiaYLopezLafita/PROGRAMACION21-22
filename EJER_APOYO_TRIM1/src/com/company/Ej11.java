package com.company;
/*
Crea una biblioteca de funciones matemáticas que contenga las
siguientes funciones. Recuerda que puedes usar unas dentro de otras si
es necesario. Observa bien lo que hace cada función ya que, si las
implementas en el orden adecuado, te puedes ahorrar mucho trabajo. Por
ejemplo, la función esCapicua resulta trivial teniendo voltea y la
función siguientePrimo también es muy fácil de implementar teniendo
esPrimo.
 */

import java.util.Scanner;

public class Ej11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un numero grande: ");
        int num = sc.nextInt();
        System.out.print("Introduce el exponente: ");
        int exp = sc.nextInt();
        System.out.print("Introduce una posicion: ");
        int pos = sc.nextInt();
        System.out.print("Introduce un digito: ");
        int dig = sc.nextInt();
        System.out.print("¿Cuantos digitos quieres eliminar?: ");
        int elim = sc.nextInt();
        System.out.print("¿Que valor quieres añadir?: ");
        int val = sc.nextInt();
        System.out.println("Indica la posicion inicial para extraer un trozo");
        int posInicial = sc.nextInt();
        System.out.println("Indica la posicion final para extraer un trozo");
        int posFinal = sc.nextInt();
        System.out.print("Introduce un segundo numero: ");
        int num2 = sc.nextInt();

        System.out.println("1.- ¿EL número es capicua?: "+esCapicua(num));
        System.out.println("2.- ¿El número es primo?: "+esPrimo(num));
        System.out.println("3.- El siguiente numero primo a tu numero es: "+siguientePrimo(num));
        System.out.println("4.- La potencia de tu numero (base) y del esponente es: "+pontencia(num,exp));
        System.out.println("5.- La cantidad de digitod que tiene "+digitos(num));
        System.out.println("6.- El número invertido es: "+numInverso(num));
        System.out.println("7.- El numero de la posicion que has indicado es: "+digitosN(num, pos));
        System.out.println("8.- La posición del digito que buscas es: "+posicionDDigito(num,dig));
        System.out.println("9.- El resultado de eliminar digitos por detras es: "+quitaPorDetras(num,elim));
        System.out.println("10.- El resultado de eliminar digitos por delante es: "+quitaPorDelante(num,elim));
        System.out.println("11.- el numero resultado con un numero detras es: "+añadeDelante(num,val));
        System.out.println("12.- el numero resultado con un numero detras es: "+añadeDetras(num,val));
        System.out.println("11.- El trozo de tu numro que quieres es: "+trozoDeNumero(num, posInicial, posFinal));
        System.out.println("14.- la union de los dos numeros es: "+juntaNumeros(num, num2));
    }


    public static int numInverso(int x){
        // voltea: Le da la vuelta a un número.

        long aux, inverso = 0, cifra;

        //le damos la vuelta al número
        aux = x;
        while (aux>0){
            cifra = aux % 10;
            inverso = inverso * 10 + cifra;
            aux                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 /=10;
        }

        return (int) inverso;
    }

    public static boolean esCapicua(int x){
        // esCapicua: Devuelve verdadero si el número que se pasa como
        //parámetro es capicúa y falso en caso contrario.

        if(x == numInverso(x)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean esPrimo(int x){
        // esPrimo: Devuelve verdadero si el número que se pasa como
        //parámetro es primo y falso en caso contrario.
        for (int i = 2; i < x; i++) {
            if (x%i == 0){
                return false;
            }
        }
        return true;
    }

    public static int siguientePrimo(int x){
        //siguientePrimo: Devuelve el menor primo que es mayor al número
        //que se pasa como parámetro.
        long i;
        for ( i = x; i < x+10; i++) {
            for (int j = 2; j < i; j++) {
                if (x%i==0){
                    return -1;
                }
            }
        }
        return (int) i;
    }

    public static int pontencia(int b, int e){
        //potencia: Dada una base y un exponente devuelve la potencia.
        int resultado = (int) Math.pow(b,e);

        return resultado;
    }

    public static int digitos( int x){
        int cantidad =0;

        while (x>0){
            int c = (int) (x%10);
            cantidad++;
            x/=10;
        }
        return cantidad;
    }

    public static int digitosN( int x, int pos){
        //digitoN: Devuelve el dígito que está en la posición n de un
        //número entero. Se empieza contando por el 0 y de izquierda a
        //derecha.
        String resultado=Integer.toString(x);
        int numero= Integer.parseInt(String.valueOf(resultado.charAt(pos)));

        return numero;
    }

    public static int posicionDDigito(int x, int d){
        // posicionDeDigito: Da la posición de la primera ocurrencia de
        //un dígito dentro de un número entero. Si no se encuentra,
        //devuelve -1.

        String num = Integer.toString(x);

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i)==d){
                return i;
            }
        }

        return -1;
    }


    public static int quitaPorDetras(int x, int c){
        // quitaPorDetras: Le quita a un número n dígitos por detrás (por
        //la derecha).
        
        String num = Integer.toString(x);

        String newNum = num.substring(0,(num.length()-c));

        int resultado = Integer.parseInt(newNum);

        return resultado;
    }

    public static int quitaPorDelante(int x, int c){
        // quitaPorDelante: Le quita a un número n dígitos por delante
        //(por la izquierda).
        String num = Integer.toString(x);

        String newNum = num.substring(c, num.length());

        int resultado = Integer.parseInt(newNum);

        return resultado;
    }

    public static int añadeDelante(int x, int b){
        // pegaPorDetras: Añade un dígito a un número por detrás
        String num = Integer.toString(x);
        String newNum = num + b;

        int resultado = Integer.parseInt(newNum);

        return resultado;

    }

    public static int añadeDetras(int x, int b){
        //pegaPorDelante: Añade un dígito a un número por delante.
        String num = Integer.toString(x);
        String newNum = b+num;

        int resultado = Integer.parseInt(newNum);

        return resultado;
    }

    public static int trozoDeNumero(int x, int a, int z){
        // trozoDeNumero: Toma como parámetros las posiciones inicial y
        //final dentro de un número y devuelve el trozo correspondiente.

        String num = Integer.toString(x);
        String newNum = num.substring(a, z);

        int resultado = Integer.parseInt(newNum);

        return resultado;
    }

    public static int juntaNumeros(int x, int z){
        // juntaNumeros: Pega dos números para formar uno.
        String num = Integer.toString(x);
        String num2 = Integer.toString(z);
        String newNum = num+num2;

        int resultado = Integer.parseInt(newNum);

        return resultado;
    }


}
