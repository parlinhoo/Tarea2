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
            comp = new Comprador(moneda1, 1, expendedor);
            System.out.println(comp.cuantoVuelto());
        } catch (PagoIncorrectoException e) {
            e.printStackTrace();
        } catch (PagoInsuficienteException e) {
            e.printStackTrace();
        } catch (NoHayProductoException e) {
            e.printStackTrace();
        }
    }
}
