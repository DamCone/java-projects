
package veiculos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Aereo implements Veiculo{
    private final String matricula;
    private final String modelo;
    private final int asientos;

    @Override
    public void imprimir(){
        System.out.println("Matricula: "+matricula+", Modelo: "+modelo+", Asientos: "+asientos);
        comprobarMatricula();
    }

    public Aereo(String matricula, String modelo, int asientos) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.asientos = asientos;
    }
    public void comprobarMatricula(String matricula){
    }
    public void comprobarMatricula(){
        Pattern p = Pattern.compile("^[a-zA-Z]{4}[\\d]{6}");
        Matcher m = p.matcher(matricula);
        if(m.matches()){
            System.out.println("Matricula correcta");
        } else{
            System.out.println("Matricula incorrecta");
        }
    }
    
}
