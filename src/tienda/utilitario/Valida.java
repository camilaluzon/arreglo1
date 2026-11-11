package tienda.utilitario;

import java.util.Scanner;

public class Valida {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje){
        String valor = "";
        
        while(valor == null || valor.trim().isEmpty()){
            System.out.print("Ingreso incorrecto, reingrese info");
            System.out.print(mensaje + ": ");
            valor = sc.nextLine();
        }
        return valor;
    }

    public static int leerEntero(String mensaje, int minimo){
        System.out.print(mensaje + ": ");
        int valor = Integer.parseInt(sc.nextLine());

        while(valor < minimo){
            System.out.println("Valor incorrecto, reingrese info");
            System.out.print(mensaje + ": ");
            valor = Integer.parseInt(sc.nextLine());
        }

        return valor;
    }

    public static double leerDoublePositivo(String mensaje){
        System.out.print(mensaje + ": ");
        double valor = Double.parseDouble(sc.nextLine());

        while(valor <= 0){
            System.out.println("Valor incorrecto, reingrese info");
            System.out.print(mensaje + ": ");
            valor = Double.parseDouble(sc.nextLine());
        }

        return valor;
    }
}
