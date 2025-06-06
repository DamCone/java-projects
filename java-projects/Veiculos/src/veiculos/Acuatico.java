
package veiculos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Acuatico implements Veiculo{
    private final String matricula;
    private final String modelo;
    private final int slora;

    @Override
    public void imprimir(){
        System.out.println("Matricula: "+matricula+", Modelo: "+modelo+", Slora: "+slora);
        comprobarMatricula();
    }

    public Acuatico(String matricula, String modelo, int slora) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.slora = slora;
    }
    public void comprobarMatricula(String matricula){
    }
    public void comprobarMatricula(){
        Pattern p = Pattern.compile("[a-zA-Z]{3,10}");
        Matcher m = p.matcher(matricula);
        if(m.matches()){
            System.out.println("Matricula correcta");
        } else{
            System.out.println("Matricula incorrecta");
        }
    }
}
