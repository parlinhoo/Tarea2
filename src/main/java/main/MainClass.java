package main;

import main.monedas.Moneda;
import main.monedas.Moneda100;
import main.monedas.Moneda1000;
import main.monedas.Moneda1500;
import main.objetos.Comprador;
import main.objetos.Expendedor;

public class MainClass {
    public static void main(String[] args) {

        /** Expendedor con 1 producto de cada variedad */
        Expendedor expendedor = new Expendedor(1);
        Moneda moneda1 = new Moneda1000();
        Comprador comp1;
        /** Intentando comprar con una moneda con valor menor al precio */
        try {
            comp1 = new Comprador(moneda1, 4, expendedor);
            System.out.println(comp1.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            expendedor.getVuelto();
            System.out.println();
            System.out.println(">>Intentando comprar con una moneda con valor menor al precio:");
            System.out.printf("Error tipo %s | %s%n", e.getClass().getName(), e.getMessage());
            System.out.println();
        }
        moneda1 = null;
        /** Intentando comprar sin una moneda (null) */
        try {
            comp1 = new Comprador(moneda1, 4, expendedor);
            System.out.println(comp1.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(">>Intentando comprar sin una moneda (null):");
            System.out.printf("Error tipo %s | %s%n", e.getClass().getName(), e.getMessage());
            System.out.println();
        }

        Moneda moneda2 = new Moneda1500();
        Comprador comp2;
        /** Comprando el unico super8 en el expendedor */
        try {
            comp2 = new Comprador(moneda2, 5, expendedor);
            System.out.println(">>Comprando el unico super8 en el expendedor:");
            System.out.println("Vuelto recibido:" + comp2.cuantoVuelto());
            System.out.println("Producto consumido:" + comp2.queConsumiste());
            System.out.println();
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            expendedor.getVuelto();
            System.out.printf("Error tipo %s | %s%n", e.getClass().getName(), e.getMessage());
            System.out.println();
        }

        Moneda moneda3 = new Moneda1500();
        Comprador comp3;
        /** Intentando comprar otro super8 (no stock) */
        try {
            comp3 = new Comprador(moneda3, 5, expendedor);
            System.out.println(comp3.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            expendedor.getVuelto();
            System.out.println(">>Intentando comprar otro super8 (no stock):");
            System.out.printf("Error tipo %s | %s%n", e.getClass().getName(), e.getMessage());
            System.out.println();
        }
        Moneda moneda4;
        Comprador comp4;
        /** Comprando el resto de productos en el expendedor */
        try {
            for (int i=1; i<5; i++){
                moneda4 = new Moneda1500();
                comp4 = new Comprador(moneda3, i, expendedor);
                System.out.println(">>Comprando el/la unico/a " +  comp4.queConsumiste() + " en el expendedor:");
                System.out.println("Vuelto recibido:" + comp4.cuantoVuelto());
                System.out.println("Producto consumido:" + comp4.queConsumiste());
                System.out.println();
            }
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.printf("Error tipo %s | %s%n", e.getClass().getName(), e.getMessage());
        }

        Moneda moneda5 = new Moneda100();
        Comprador comp5;
        /** Intentando comprar un producto que no existe en el expendedor*/
        try {
            comp1 = new Comprador(moneda5, 7, expendedor);
            System.out.println(comp1.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            expendedor.getVuelto();
            System.out.println(">>Intentando comprar un producto que no existe en el expendedor:");
            System.out.printf("Error tipo %s | %s%n", e.getClass().getName(), e.getMessage());
            System.out.println();
        }
    }
}
