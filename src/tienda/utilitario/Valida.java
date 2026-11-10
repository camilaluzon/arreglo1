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
}
