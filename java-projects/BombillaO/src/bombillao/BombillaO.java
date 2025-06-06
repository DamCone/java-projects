package bombillao;

public class BombillaO {
    public static void main(String[] args) {
        BombillaObj b = new BombillaObj();
        
        b.encender();
        if (b.isOn()) {
            System.out.println("Está encendida.");
        } else{
            System.out.println("Está apagada.");
        }
        b.apagar();
        if (b.isOn()) {
            System.out.println("Está encendida.");
        } else{
            System.out.println("Está apagada.");
        }
        b.apagar();
        if (b.isOn()) {
            System.out.println("Está encendida.");
        } else{
            System.out.println("Está apagada.");
        }
        b.encender();
        if (b.isOn()) {
            System.out.println("Está encendida.");
        } else{
            System.out.println("Está apagada.");
        }
    }
}
