package controles;

import java.time.LocalDate;

public class Prestamo {
    private final int id;
    private final int idLibro;
    private final String nombreUsuario;
    private final LocalDate fechaPrestamo;
    private final int duracionDias;
    private boolean devuelto;

    public Prestamo(int id, int idLibro, String nombreUsuario, LocalDate fechaPrestamo, int duracionDias, boolean devuelto) {
        this.id = id;
        this.idLibro = idLibro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.duracionDias = duracionDias;
        this.devuelto = devuelto;
    }

    public int getId() {
        return id;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public boolean isDevuelto() {
        return devuelto;
    }
    
    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
}