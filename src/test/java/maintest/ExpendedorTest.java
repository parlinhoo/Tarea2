package maintest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.*;
import main.objetos.*;
import main.monedas.*;
import main.productos.*;

public class ExpendedorTest {

    public static int[] pruebas = {
            500, 1,
            1500, 2,
            100, 1,
            1000, 5,
            1500, 6,
            2000, 3
    };

    @ParameterizedTest(name = "${0} y producto {1}")
    @MethodSource("argsPruebas")
    public void pruebaCompra(int moneda, int producto) {
        Moneda moneda1 = null;
        switch (moneda) {
            case 100 -> moneda1 = new Moneda100();
            case 500 -> moneda1 = new Moneda500();
            case 1000 -> moneda1 = new Moneda1000();
            case 1500 -> moneda1 = new Moneda1500();
        }
        Expendedor exp = new Expendedor(100);
        try {
            exp.comprarProducto(moneda1, producto);
            System.out.println("Compra realizada con éxito");
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.printf("Error atrapado: %s\n", e.getMessage());
        }
    }

    static Object[] argsPruebas(){
        Arguments[] arr = new Arguments[pruebas.length/2];
        int i = 0;
        for (i = 0; i < pruebas.length/2; i++) {
            arr[i] = Arguments.arguments(pruebas[2*i], pruebas[2*i+1]);
        }
        return arr;
    }
}
