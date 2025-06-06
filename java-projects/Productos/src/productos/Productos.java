package productos;

import java.util.ArrayList;
import java.util.Iterator;

public class Productos {
    public static void main(String[] args) {
        Producto p1 = new Producto("p1", 2);
        Producto p2 = new Producto("p2", 3);
        Producto p3 = new Producto("p3", 4);
        Producto p4 = new Producto("p4", 5);
        Producto p5 = new Producto("p5", 6);
        Producto x = null;
        ArrayList<Producto> ptos = new ArrayList();
        ptos.add(p1);
        ptos.add(p2);
        ptos.add(p3);
        ptos.add(p4);
        ptos.add(p5);
        Iterator it = ptos.iterator();
        
        while(it.hasNext()){
            x = (Producto) it.next();
            System.out.println(x.getNombre());
            System.out.println(x.getCantidad());
        }
        ptos.remove(p1);
        ptos.remove(p3);
        Producto p6 = new Producto("p6", 7);
        ptos.add(2, p6);
        it = ptos.iterator();
        while(it.hasNext()){
            x = (Producto) it.next();
            System.out.println(x.getNombre());
            System.out.println(x.getCantidad());
        }
        ptos.clear();
    }

}
