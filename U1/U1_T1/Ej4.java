import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num;
        boolean esPrimo = true;

        do {
            System.out.println("Introduce un numero:");
            num = sc.nextLine();
        } while(num.length()%2!=0);

        int numero = Integer.parseInt(num);
        int n1=0,n2=0;
        while (numero>10){
            n1 = numero%100;
            n2 = (numero/=100);
            System.out.println(n2+","+n1);
        }

        if (n1%2==0){
            esPrimo=false;
            System.out.println(n1+" no es primo");
        } else {
            System.out.println(n1+" es primo");
        }

        if (n2%2==0){
            esPrimo=false;
            System.out.println(n1+" no es primo");
        } else {
            System.out.println(n1+" es primo");
        }


    }
}
