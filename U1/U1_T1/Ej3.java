import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double precioBase=8;
        double cantidadDescuento;
        int numPersonas;
        double precioPareja;
        String diaSemana =(""),descuento=("");

        System.out.println("¿Cuantas personas son:?");
        numPersonas = sc.nextInt();
        sc.nextLine();
        System.out.println("Día de la semana:");
        diaSemana = sc.nextLine();
        System.out.println("¿Tienes tarjeta CineCampa?:");
        descuento = sc.nextLine();

        switch (diaSemana){
            case "miercoles":
                precioBase = 5;
                break;
            case "jueves":
                if (numPersonas%2==0){
                    precioBase = (numPersonas/2)*11;
                } else {
                    precioBase = precioBase + (numPersonas/2*11);
                }
                break;
            default:
                precioBase = 8;
        }

        if (descuento.equals("si")){
            cantidadDescuento = 0.9;
        } else {
            cantidadDescuento =0;
        }
        double precioTotalEntradas = precioBase*numPersonas;
        double precioDescuento = precioTotalEntradas-(precioTotalEntradas*cantidadDescuento);
        double precioPago =precioTotalEntradas-precioDescuento;

        System.out.println("Numeros de entradas: "+numPersonas);
        System.out.println("Precio entrada indivudial: "+precioBase);
        System.out.println("Total: "+precioTotalEntradas);
        System.out.println("Descuento: "+precioDescuento);
        System.out.println("Total a pagar: "+precioPago);

    }
}
