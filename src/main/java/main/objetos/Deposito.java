package main.objetos;

import java.util.ArrayList;

public class Deposito<type> {
    private final ArrayList<type> arrayList;
    public void add(type item) {this.arrayList.add(item);}
    public type get() {
        if (!this.arrayList.isEmpty()) return this.arrayList.remove(0);
        else return null;
    }
    public Deposito() {this.arrayList = new ArrayList<>();}
}
