package main.objetos;

import main.productos.bebidas.*;
import main.monedas.*;

public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    private final int precio;
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    public Moneda getVuelto() {return monVu.get();}
    public Bebida comprarBebida(Moneda moneda, int bebida) {
        if (moneda == null) {
            return null;
        }
        int valor = moneda.getValor();
        Bebida selBebida = null;
        int vuelto = valor;
        if (this.precio <= valor) {
            switch (bebida) {
                case 1:
                    selBebida = coca.get();
                    break;
                case 2:
                    selBebida = sprite.get();
                    break;
            }
        }
        if (selBebida != null) {vuelto -= this.precio;}
        for (int i = 0; i < vuelto/100; i++) {
            monVu.add(new Moneda100());
        }
        return selBebida;
    }
    public Expendedor(int latas, int precio) {
        this.coca = new Deposito<Bebida>();
        this.sprite = new Deposito<Bebida>();
        this.monVu = new Deposito<Moneda>();
        for (int i = 0; i < latas; i++) {
            coca.add(new CocaCola(100+i));
            sprite.add(new Sprite(200+i));
        }
        this.precio = precio;
    }
}
