import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int altura;

        do {
            System.out.println("Introduce la altura de las Zs: ");
            altura = sc.nextInt();
        } while (altura%2==0 && altura<=3);

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < altura-1; j++) {
                System.out.println("*");
            }

            System.out.println("*");
        }

    }
}
