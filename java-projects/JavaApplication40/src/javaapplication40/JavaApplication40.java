package javaapplication40;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class JavaApplication40 {
    public static void main(String[] args) {
        LocalDateTime hoyConHora = LocalDateTime.now();
        LocalDateTime fechaConHora = LocalDateTime.now();
        DateTimeFormatter esDateFormatLargo = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss").withLocale(new Locale("es", "ES"));
        System.out.println("Formato español (largo, localizado): " + fechaConHora.format(esDateFormatLargo));
    

    }

}
