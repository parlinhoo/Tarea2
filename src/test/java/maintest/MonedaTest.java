package maintest;

import main.monedas.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonedaTest {

    @Test
    @DisplayName("Test de Comparación de Monedas")
    public void PruebaComparacion() {
        Moneda moneda500 = new Moneda500();
        Moneda moneda1000 = new Moneda1000();
        Moneda moneda1500 = new Moneda1500();

        System.out.println("Compparando una moneda consigo misma");
        assertEquals(0, moneda1000.compareTo(moneda1000));
        System.out.println("Resultado esperado: 0");
        System.out.println("Resultado recibido: " + moneda1000.compareTo(moneda1000));

        System.out.println("Comparando una moneda con una mas grande");
        assertTrue(moneda500.compareTo(moneda1000) == -1);
        System.out.println("Resultado esperado: -1");
        System.out.println("Resultado recibido: " + moneda500.compareTo(moneda1000));

        System.out.println("Comparando una moneda con una mas pequeña");
        assertTrue(moneda1500.compareTo(moneda1000) == 1);
        System.out.println("Resultado esperado: 1");
        System.out.println("Resultado recibido: " + moneda1500.compareTo(moneda1000));

    }

    @Test
    @DisplayName("Test toString")
    public void testToStrings() {
        Moneda moneda100 = new Moneda100();
        assertEquals("$100 (Serie " + Integer.toHexString(moneda100.hashCode()) + ")", moneda100.toString());
        System.out.println("Resultado esperado: $100 (Serie " + Integer.toHexString(moneda100.hashCode()) + ")");
        System.out.println("Resultado recibido: " + moneda100.toString());
    }
}
