import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, cifra;

        do {
            System.out.println("Introduce el numero");
            num= sc.nextInt();
            System.out.println("Introduce la cifra");
            cifra = sc.nextInt();
        }while ((num<0 && 0<=cifra && cifra<=9) || (cifra<0 && 0<=num && num<=9));

        int ocurrencias=0;

        while (num>0){
            int resto = num%10;
            num/=10;
            ////System.out.println(num);
            if (resto==cifra){
                ocurrencias++;
            }
        }
        System.out.println("ocurrencia:"+ ocurrencias);
    }
}
