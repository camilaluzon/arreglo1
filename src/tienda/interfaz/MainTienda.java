package tienda.interfaz;

import tienda.modelo.AppStore;
import tienda.modelo.Juego;
import tienda.utilitario.Valida;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        tienda.cargarDatos();
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch(opc){
                case 1:{
                    ingresarJuegos();
                }break;
                case 2:{
                    mostrarJuegos();
                }break;
                case 3:{
                    buscarJuego();
                }break;
                case 4:{
                    comprar();
                }break;
                case 5:{
                    vender();
                }break;
                case 6:{
                    juegoMasVendido();
                }break;
                case 7:{
                    System.out.println("Gracias por usar nuestros servicios");
                }break;
            }
        }while(opc != 7);
    }

    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuegos(){
        System.out.println("*******Ingreso de datos********");

        String nombre = Valida.leerString("Ingrese el nombre");
        String categoria = Valida.leerString("Ingrese la categoria");
        int tamanio = Valida.leerEntero("Ingrese el tamanio", 1);
        double precio = Valida.leerDoublePositivo("Ingrese el precio");
        int licenciasDisponibles = Valida.leerEntero("Ingrese el stock inicial", 0);

        if(tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "El juego se ha agregado con éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "El juego no pudo ser agregado");
        }
    }

    public static void mostrarJuegos(){
        Juego juegos[] = tienda.getJuegos();
        if(tienda.getIndice() >= 0){
            for(int i = 0; i <= tienda.getIndice(); i++){
                System.out.println(juegos[i]);
            }
        }else{
            System.out.println("No existe juegos a mostrar");
        }

    }

    public static void buscarJuego(){
        String nombre = Valida.leerString("Ingrese el nombre del juego");

        Juego j = tienda.buscarJuego(nombre);

        if(j != null){
            JOptionPane.showMessageDialog(null, j.toString());
        }else{
            JOptionPane.showMessageDialog(null, "El juego no se encuentra registrado");
        }
    }

    public static void comprar(){
        String nombre = Valida.leerString("Ingrese el nombre del juego");
        int cantidad = Valida.leerEntero("Ingrese la cantidad de licencias a comprar", 1);

        if(tienda.comprar(nombre, cantidad)){
            JOptionPane.showMessageDialog(null, "Las licencias se han agregado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo realizar la compra");
        }
    }

    public static void vender(){
        String nombre = Valida.leerString("Ingrese el nombre del juego");
        int cantidad = Valida.leerEntero("Ingrese la cantidad de licencias a vender", 1);

        double total = tienda.vender(nombre, cantidad);

        if(total > 0){
            JOptionPane.showMessageDialog(null, "Venta realizada correctamente.\nTotal: $" + total);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo realizar la venta. Verifique el juego y las licencias disponibles.");
        }
    }

    public static void juegoMasVendido(){
        Juego juegos[] = tienda.getJuegos();
        boolean hayVentas = false;

        for(int i = 0; i <= tienda.getIndice(); i++){
            if(juegos[i].getLicenciasVendidas() > 0){
                hayVentas = true;
            }
        }

        if(hayVentas){
            String nombre = tienda.masVendido();
            JOptionPane.showMessageDialog(null, "El juego mas vendido es: " + nombre);
        }else{
            JOptionPane.showMessageDialog(null, "Todavia no se han registrado ventas");
        }
    }
}
