package veiculos;

import java.util.ArrayList;

public class Veiculos {
    public static void main(String[] args) {
        Coche c1 = new Coche("1234ABC", "megan", 4, true);
        Moto m1 = new Moto("2345BCD", "B&W", 2, "Rojo");
        Barco b1 = new Barco("ABCDE", "caribe", 3, true);
        Submarino s1 = new Submarino("A", "sub0", 2, 1500);
        Avion a1 = new Avion("akjfbs", "rayanair", 200, 12);
        Helicoptero h1 = new Helicoptero("ASDF123456", "HELI", 5, 4);
        Terrestre t1 = new Terrestre("vjhbad", "sbrf", 3);
        Acuatico ac1 = new Acuatico("DAKALA1", "acuamar", 3);
        Aereo ae1 = new Aereo("dj", "aereo", 2);
        
        ArrayList <Veiculo> veiculos = new ArrayList();
        veiculos.add(c1);
        veiculos.add(m1);
        veiculos.add(b1);
        veiculos.add(s1);
        veiculos.add(a1);
        veiculos.add(h1);
        veiculos.add(t1);
        veiculos.add(ac1);
        veiculos.add(ae1);
        
        c1.setAireAcondicionado(false);
        for(Veiculo x : veiculos){
            x.imprimir();
        }
        
    }

}
