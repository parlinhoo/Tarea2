package main;

import main.monedas.*;
import main.objetos.*;
import main.productos.*;
import main.productos.bebidas.*;
import main.productos.dulces.*;

public class MainClass {
    public static void main(String[] args) {
        Expendedor expendedor = new Expendedor(1);
        Moneda moneda1 = new Moneda1000();
        Comprador comp;
        try {
            comp = new Comprador(moneda1, 4, expendedor);
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.printf("Error tipo %s | %s%n", e.getClass().getName(), e.getMessage());
        }
    }
}
