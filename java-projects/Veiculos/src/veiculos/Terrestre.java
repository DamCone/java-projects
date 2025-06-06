
package veiculos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Terrestre implements Veiculo {
    private final String matricula;
    private final String modelo;
    private final int numeroRuedas;

    
    public void imprimir(){
        System.out.println("Matricula: "+matricula+", Modelo: "+modelo+", Número de ruedas: "+numeroRuedas);
        comprobarMatricula();
    }

    public Terrestre(String matricula, String modelo, int numeroRuedas) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.numeroRuedas = numeroRuedas;
    }
    
    public void comprobarMatricula(){
        Pattern p = Pattern.compile("^[\\d]{4}[a-zA-Z]{3}");
        Matcher m = p.matcher(matricula);
        if(m.matches()){
            System.out.println("Matricula correcta");
        } else{
            System.out.println("Matricula incorrecta");
        }
    }
    
}
