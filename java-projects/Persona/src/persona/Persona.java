package persona;

public class Persona {
    public static void main(String[] args) {
        Personas p1 = new Personas("48A", "Delfín", "Pezqueñín Noruego", 3);
        Personas p2 = new Personas("49A", "Tristán", "Renos Esquilados", 89);
        
        System.out.println("Persona 1:");
        p1.imprime();
        System.out.println("Persona 2:");
        p2.imprime();
        
        if(p1.esMayorEdad()){
            System.out.println(p1.getNombre()+" es mayor de edad.");
        } else {
            System.out.println(p1.getNombre()+" no es mayor de edad.");
        } if(p2.esMayorEdad()){
            System.out.println(p2.getNombre()+" es mayor de edad.");
        } else {
            System.out.println(p2.getNombre()+" no es mayor de edad.");
        }
        
        if(p1.esJubilado()){
            System.out.println(p1.getNombre()+" está jubilado.");
        } else {
            System.out.println(p1.getNombre()+" no está jubilado.");
        } if(p2.esMayorEdad()){
            System.out.println(p2.getNombre()+" está jubilado.");
        } else {
            System.out.println(p2.getNombre()+" no está jubilado.");
        }
        
        System.out.println("La diferencia de edad entre Tristán y Delfín es de "+(p2.diferenciaEdad(p1))+" años.");
    }
}
