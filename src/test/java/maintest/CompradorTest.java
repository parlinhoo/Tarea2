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
            1000, 3,
            134235324, 3
    };

    @ParameterizedTest(name = "Comprar {1} con {0}, vuelto esperado ${2}")
    @MethodSource("argsPruebas")
    public void pruebaCompra(Moneda moneda1, int producto, int vueltoEsperado, String sonidoEsperado) {
        System.out.printf("Prueba con moneda $%d y nproducto %d\nVuelto esperado: $%d, Producto esperado: %s\n", moneda1.getValor(), producto, vueltoEsperado, sonidoEsperado);
        Expendedor exp = new Expendedor(100);
        Comprador comp;
        int vuelto;
        String productoObt = null;
        try {
            comp = new Comprador(moneda1, producto, exp);
            vuelto = comp.cuantoVuelto();
            productoObt = comp.queConsumiste();
        } catch (PagoInsuficienteException | NoHayProductoException e) {
            System.out.printf("Error atrapado: %s\n", e.getMessage());
            vuelto = exp.getVuelto().getValor();
        } catch (PagoIncorrectoException e) {
            vuelto = 0;
        }
        System.out.printf("Vuelto: $%d, Producto: %s", vuelto, productoObt);
        Assertions.assertEquals(vueltoEsperado, vuelto, "Vuelto esperado no coincide");
        Assertions.assertEquals(sonidoEsperado, productoObt, "Producto obtenido no coincide");

    }

    static Object[] argsPruebas(){

        Arguments[] arr = new Arguments[pruebas.length/2];
        int i = 0;
        for (i = 0; i < pruebas.length/2; i++) {
            Moneda moneda;
            switch (pruebas[2*i]) {
                case 100 -> moneda = new Moneda100();
                case 500 -> moneda = new Moneda500();
                case 1000 -> moneda = new Moneda1000();
                case 1500 -> moneda = new Moneda1500();
                default -> moneda = new Moneda100();
            }
            int producto = pruebas[2*i+1];
            int precio = -1;
            InfoProducto prod = null;
            for (InfoProducto p : InfoProducto.values()) {
                if (p.getNum() == pruebas[2 * i + 1]) {
                    prod = p;
                    precio = prod.getPrecio();
                    break;
                }
            }
            int vuelto;
            String sonido = null;
            if (precio < 0 || moneda.getValor() < prod.getPrecio()) {
                vuelto = moneda.getValor();
            } else {
                Producto producto1 = null;
                switch (prod) {
                    case COCACOLA -> producto1 = new CocaCola(1);
                    case SPRITE -> producto1 = new Sprite(1);
                    case FANTA -> producto1 = new Fanta(1);
                    case SNICKERS -> producto1 = new Snickers(1);
                    case SUPER8 -> producto1 = new Super8(1);
                }
                vuelto = moneda.getValor() - prod.getPrecio();
                sonido = producto1.consumir();
            }
            arr[i] = Arguments.arguments(moneda, producto, vuelto, sonido);
        }
        return arr;
    }
}
