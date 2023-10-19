package maintest;

import main.NoHayProductoException;
import main.PagoIncorrectoException;
import main.PagoInsuficienteException;
import main.monedas.*;
import main.objetos.*;
import main.productos.*;
import main.productos.bebidas.CocaCola;
import main.productos.bebidas.Fanta;
import main.productos.bebidas.Sprite;
import main.productos.dulces.Dulce;
import main.productos.dulces.Snickers;
import main.productos.dulces.Super8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CompradorTest {
    public static int[] pruebas = { // El vuelto se calcula en argsPruebas
            500, 1,
            1500, 2,
            100, 1,
            1500, 5,
            1500, 6,
            2000, 3
    };

    @ParameterizedTest(name = "Comprar {1} con ${0}, vuelto esperado ${2}")
    @MethodSource("argsPruebas")
    public void pruebaCompra(int moneda, int producto, int vueltoEsperado, String sonidoEsperado) {
        Moneda moneda1 = null;
        switch (moneda) {
            case 100 -> moneda1 = new Moneda100();
            case 500 -> moneda1 = new Moneda500();
            case 1000 -> moneda1 = new Moneda1000();
            case 1500 -> moneda1 = new Moneda1500();
        }
        Expendedor exp = new Expendedor(100);
        Comprador comp = null;
        try {
            comp = new Comprador(moneda1, producto, exp);
            Assertions.assertEquals(vueltoEsperado, comp.cuantoVuelto(), "Vuelto esperado no coincide");
            Assertions.assertEquals(sonidoEsperado, comp.queConsumiste(), "Producto obtenido no coincide");
            System.out.println("Compra realizada con éxito");
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.printf("Error atrapado: %s\n", e.getMessage());
        }
    }

    static Object[] argsPruebas(){
        Arguments[] arr = new Arguments[pruebas.length/2];
        int i = 0;
        for (i = 0; i < pruebas.length/2; i++) {
            int moneda = pruebas[2*i];
            int producto = pruebas[2*i+1];
            InfoProducto prod = null;
            for (InfoProducto p : InfoProducto.values()) {
                if (p.getNum() == pruebas[2 * i + 1]) {
                    prod = p;
                    break;
                }
            }
            Producto producto1 = null;
            switch (prod) {
                case COCACOLA -> producto1 = new CocaCola(1);
                case SPRITE -> producto1 = new Sprite(1);
                case FANTA -> producto1 = new Fanta(1);
                case SNICKERS -> producto1 = new Snickers(1);
                case SUPER8 -> producto1 = new Super8(1);
            }
            int vuelto;
            String sonido = null;
            if (producto1 == null || moneda < prod.getPrecio()) {
                vuelto = moneda;
            } else {
                vuelto = moneda - prod.getPrecio();
                sonido = producto1.consumir();
            }
            arr[i] = Arguments.arguments(moneda, producto, vuelto, sonido);
        }
        return arr;
    }
}
