package org.example;

import java.util.ArrayList;

abstract class Moneda {
    public Moneda getSerie() {return this;}
    public abstract int getValor();
    public Moneda() {}
}
class Moneda100 extends Moneda {
    @Override
    public int getValor() {return 100;}
    public Moneda100() {super();}
}
class Moneda500 extends Moneda {
    @Override
    public int getValor() {return 500;}
    public Moneda500() {super();}
}
class Moneda1000 extends Moneda {
    @Override
    public int getValor() {return 1000;}
    public Moneda1000() {super();}
}
class Moneda1500 extends Moneda {
    @Override
    public int getValor() {return 1500;}
    public Moneda1500() {super();}
}
class Comprador {
    private String sonido;
    private int vuelto = 0;
    public int cuantoVuelto() {return vuelto;}
    public String queBebiste() {return sonido;}
    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida bebida = exp.comprarBebida(m, cualBebida);
        if (bebida != null) {this.sonido = bebida.beber();}
        Moneda monedaV = exp.getVuelto();
        while (monedaV != null) {
            this.vuelto += monedaV.getValor();
            monedaV = exp.getVuelto();
        }
    }
}
abstract class Bebida {
    private int serie;
    public abstract String beber();
    public int getSerie() {return this.serie;}
    public Bebida(int serie) {this.serie = serie;}
}
class CocaCola extends Bebida {
    @Override
    public String beber() {return "cocacola";}
    public CocaCola(int serie) {super(serie);}
}
class Sprite extends Bebida {
    @Override
    public String beber() {return "sprite";}
    public Sprite(int serie) {super(serie);}
}
class Expendedor {
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
class Deposito<type> {
    private final ArrayList<type> arrayList;
    public void add(type item) {this.arrayList.add(item);}
    public type get() {
        if (!this.arrayList.isEmpty()) return this.arrayList.remove(0);
        else return null;
    }
    public Deposito() {this.arrayList = new ArrayList<>();}
}

public class MainClass {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(3,400);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
    }
}
