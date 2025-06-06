package usocubos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
public class UsoCubos {
    public static void main(String[] args) {
        BufferedReader entrada_general = new BufferedReader(new InputStreamReader(System.in));
int cont,num;
int x1,x2,y1,y2,col,prof;
 Cubo x;
 ArrayList <Cubo> misCubos = new ArrayList();
 System.out.print("Número de elementos :");
 num =Integer.parseInt(entrada_general.readLine());

for (cont=0;cont<num;cont++){
 System.out.print("Escribe x1 :");
 x1 =Integer.parseInt(entrada_general.readLine());
 System.out.print("Escribe x2 :");
 x2 =Integer.parseInt(entrada_general.readLine());
 System.out.print("Escribe y1 :");
 y1 =Integer.parseInt(entrada_general.readLine());
 System.out.print("Escribe y1 :");
 y2 =Integer.parseInt(entrada_general.readLine());
 System.out.print("Escribe color :");
 col =Integer.parseInt(entrada_general.readLine());
 System.out.print("Escribe profundidad :");
 prof =Integer.parseInt(entrada_general.readLine());
 misCubos.add( new Cubo(x1, x2, y1, y2, col, prof));
}
 Iterator it2 = misCubos.iterator();
while( it2.hasNext()) {
 x = (Cubo) it2.next();
 System.out.println("Color :"+ x.getColor() + " Volumen : " + x.volumen);
}

    }

}
