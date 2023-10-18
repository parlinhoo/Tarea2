package main.objetos;

import main.*;
import main.monedas.*;
import main.productos.*;
import main.productos.bebidas.*;
import main.productos.dulces.*;

public class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulce> snickers;
    private Deposito<Dulce> super8;
    private Deposito<Moneda> monVu;
    private int contSerie = 0;
    public Moneda getVuelto() {return monVu.get();}
    public Producto comprarProducto(Moneda moneda, int producto) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        if (moneda == null) {
            throw new PagoIncorrectoException("Se esperaba una moneda, se obtuvo null");
        }
        int valor = moneda.getValor();
        InfoProducto info = null;
        for (InfoProducto prod : InfoProducto.values()) {
            if (producto == prod.getNum()) {
                info = prod;
                break;
            }
        }
        if (info == null) {
            this.monVu.add(moneda);
            throw new NoHayProductoException("Número de producto no existe");
        }
        if (info.getPrecio() > valor) {
            this.monVu.add(moneda);
            throw new NoHayProductoException("Dinero insuficiente");
        }
        this.contSerie++;
        Producto selProducto;
        switch (info) {
            case COCACOLA -> {selProducto = coca.get();}
            case FANTA -> {selProducto = fanta.get();}
            case SPRITE -> {selProducto = sprite.get();}
            case SUPER8 -> {selProducto = super8.get();}
            case SNICKERS -> {selProducto = snickers.get();}
            default -> {selProducto = null;}
        }
        if (selProducto == null) {
            this.monVu.add(moneda);
            throw new NoHayProductoException(String.format("No queda más %s en el depósito", info.name()));
        }
        int vuelto = valor - info.getPrecio();
        for (int i = 0; i < vuelto; i += 100) {
            monVu.add(new Moneda100());
        }
        return selProducto;
    }
    public Expendedor(int cantidadProd) {
        this.coca = new Deposito<Bebida>();
        this.fanta = new Deposito<Bebida>();
        this.sprite = new Deposito<Bebida>();
        this.super8 = new Deposito<Dulce>();
        this.snickers = new Deposito<Dulce>();
        this.monVu = new Deposito<Moneda>();
        for (int i = 0; i < cantidadProd; i++) {
            coca.add(new CocaCola(100+i));
            sprite.add(new Sprite(200+i));
            fanta.add(new Fanta(300+i));
            super8.add(new Super8(400+i));
            snickers.add(new Snickers(500+i));
        }
    }
}
