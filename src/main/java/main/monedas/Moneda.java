package main.monedas;

public abstract class Moneda implements Comparable<Moneda> {
    public Moneda getSerie() {return this;}
    public abstract int getValor();

    @Override
    public int compareTo(Moneda o) {
        int ret = 0;
        if (this.getValor() < o.getValor()) {
            ret = -1;
        } else if (this.getValor() > o.getValor()) {
            ret = 1;
        }
        return ret;
    }

    @Override
    public String toString() {
        return String.format("$%d (Serie %s)", this.getValor(), Integer.toHexString(this.hashCode()));
    }

    public Moneda() {}
}
